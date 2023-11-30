package com.rmspl.odisha.creche.app.report;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.rmspl.app.data.service.DataFetcher;
import com.rmspl.odisha.creche.utility.Utility;
import com.smartxls.RangeStyle;
import com.smartxls.WorkBook;

public class DownloadReportExcelWriter {
	String strDataExcelPath;
	private static Log log = LogFactory.getLog(DownloadReportExcelWriter.class);		
	WorkBook objWorkBook = null;
	
	private List<String[]> lstdata = new ArrayList<String[]>();
	
	public WorkBook PrepareExcel(String str_session_id, 
								 File destinationDir, 
								 File destinationDownloadDir, 
								 String excel_template_name, 
								 String fileName,
								 String proj_type,
								 String user_type,
								 String map_id,
								 String rept_type,
								 String sel_period,
								 String sel_catg,
								 String sel_mnth_yr,
								 String sel_mnth_yr_start,
								 Integer start_row){
		objWorkBook = new WorkBook();
		
		try {
			objWorkBook.readXLSX((destinationDir.getAbsolutePath()+"/"+excel_template_name).trim());
		} catch (Exception e) {
			log.info("Error while reading excel file for        --     "+ e);
			return null;
		}
		
		try {
			objWorkBook.setSheet(0);
			
			if(sel_period.equalsIgnoreCase("till_month")) {
				objWorkBook.setText(0, 3, "Till Month : "+Utility.getMonthName(sel_mnth_yr.substring(5, sel_mnth_yr.length()))+" - "+sel_mnth_yr.substring(0, 4));
			} else if(sel_period.equalsIgnoreCase("by_month")) {
				objWorkBook.setText(0, 3, "For Month : "+Utility.getMonthName(sel_mnth_yr.substring(5, sel_mnth_yr.length()))+" - "+sel_mnth_yr.substring(0, 4));
			}
			
			/*lstdata = DataFetcher.getProcData("CALL sp_df_hp_web_rept_pop("+
												Utility.checkVal(user_type)+", "+
												Utility.checkVal(map_id)+", "+
												Utility.checkVal(rept_type)+", "+
												Utility.checkVal(sel_period)+", "+
												Utility.checkVal(sel_mnth_yr)+
												")");*/
			
			String  str_sql = "";			
			if(rept_type.equalsIgnoreCase("19")) {
				if(proj_type.equalsIgnoreCase("All")) {
					str_sql = "CALL sp_df_hp_web_rept_pop_19("+
																Utility.checkVal(user_type)+", "+
																Utility.checkVal(map_id)+", "+
																Utility.checkVal(rept_type)+", "+
																Utility.checkVal(sel_catg)+", "+
																Utility.checkVal(sel_mnth_yr_start)+
																")";
					
					lstdata = DataFetcher.getProcData(str_sql);
					//Base Month
					objWorkBook.setText(0, 8, lstdata.get(0)[lstdata.get(0).length-2]);
					//Comparing Month
					objWorkBook.setText(0, 10, lstdata.get(0)[lstdata.get(0).length-1]);
				}else {
					str_sql = "CALL sp_df_hp_web_rept_pop_19_cr("+
																Utility.checkVal(user_type)+", "+
																Utility.checkVal(map_id)+", "+
																Utility.checkVal(rept_type)+", "+
																Utility.checkVal(sel_catg)+", "+
																Utility.checkVal(sel_mnth_yr_start)+", "+
																Utility.checkVal(proj_type)+
																")";

					lstdata = DataFetcher.getProcData(str_sql);
					//Base Month
					objWorkBook.setText(0, 8, lstdata.get(0)[lstdata.get(0).length-2]);
					//Comparing Month
					objWorkBook.setText(0, 10, lstdata.get(0)[lstdata.get(0).length-1]);
				}				
			} else {
				if(proj_type.equalsIgnoreCase("All")) {
					str_sql ="CALL sp_df_hp_web_rept_pop("+
															Utility.checkVal(user_type)+", "+
															Utility.checkVal(map_id)+", "+
															Utility.checkVal(rept_type)+", "+
															Utility.checkVal(sel_period)+", "+
															Utility.checkVal(sel_mnth_yr)+
															")";
							
					lstdata = DataFetcher.getProcData(str_sql);
				}else {
					str_sql ="CALL sp_df_hp_web_rept_pop_cr("+
															Utility.checkVal(user_type)+", "+
															Utility.checkVal(map_id)+", "+
															Utility.checkVal(rept_type)+", "+
															Utility.checkVal(sel_period)+", "+
															Utility.checkVal(sel_mnth_yr)+", "+
															Utility.checkVal(proj_type)+
															")";
					
					
					
					lstdata = DataFetcher.getProcData(str_sql);
				}				
			}			
			//log.info("str_sql : >>>>>>  "+str_sql);			
			int row = start_row;							
			for (int i = 0; i < lstdata.size(); i++) {
				int data_col_length = lstdata.get(i).length;
				if(rept_type.equalsIgnoreCase("19")) {
					data_col_length = (lstdata.get(i).length-2);
				}
				//for (int j = 0; j < lstdata.get(i).length; j++) {
				for (int j = 0; j < data_col_length; j++) {
					//Write '-' for null value
					if (lstdata.get(i)[j].equalsIgnoreCase("N/A")) {
						objWorkBook.setText(row, j, "-");
					} else {						
						/*try {
							objWorkBook.setNumber(row, j, Double.parseDouble(lstdata.get(i)[j]));
						} catch (Exception e) {
							objWorkBook.setText(row, j, lstdata.get(i)[j]);
						}*/
						objWorkBook.setText(row, j, lstdata.get(i)[j]);
					}					
				}
				row++;
			}
			
			//End Row Index
			int endRow = start_row + lstdata.size();
			//Start Column Index
			int strtCol = 0;
			//End Column Index
			//int endCol = lstdata.get(0).length;
			int endCol = 0;
			if(rept_type.equalsIgnoreCase("19")) {
				endCol = (lstdata.get(0).length-2);
			} else {
				endCol = lstdata.get(0).length;
			}
			
			RangeStyle rangeStyle = objWorkBook.getRangeStyle();
			for (int rowIndex = start_row; rowIndex < endRow; rowIndex++) {
				for (int colIndex = strtCol; colIndex < endCol; colIndex++) {
					rangeStyle = objWorkBook.getRangeStyle(rowIndex, colIndex, rowIndex, colIndex);
					rangeStyle.setLeftBorder(RangeStyle.BorderThin);
					rangeStyle.setLeftBorderColor(Color.black.getRGB());
					rangeStyle.setTopBorder(RangeStyle.BorderThin);
					rangeStyle.setRightBorder(RangeStyle.BorderThin);
					rangeStyle.setBottomBorder(RangeStyle.BorderThin);
					//apply to the horizon border of the whole range
					rangeStyle.setHorizontalInsideBorder(RangeStyle.BorderThin);
					//apply to the vertical border of the whole range
					rangeStyle.setVerticalInsideBorder(RangeStyle.BorderThin);
					objWorkBook.setRangeStyle(rangeStyle, rowIndex, colIndex, rowIndex, colIndex);//set format for cell B2
				}
			}			
			
			// Create excel file to destination folder
			objWorkBook.writeXLSX(destinationDownloadDir.getAbsolutePath()+"/"+str_session_id+fileName.trim());
			return objWorkBook;
		} catch (Exception e) {
			try {			
				// Create excel file to destination folder
				objWorkBook.writeXLSX(destinationDownloadDir.getAbsolutePath()+"/"+str_session_id+fileName.trim());
				return objWorkBook;
			} catch (Exception ex) {
				log.info("Error while writing excel file for          "+ex);
				return null;
			}
		}
		/*try {
			objWorkBook.setSheet(0);
			// Create excel file to destination folder
			objWorkBook.writeXLSX(destinationDownloadDir.getAbsolutePath()+"/"+str_session_id+fileName.trim());
			return objWorkBook;
		} catch (Exception e) {
			log.info("Error while writing excel file for          "+e);
			return null;
		}*/
	}	
}

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

public class DownloadAllAnthropometryDataExcelWriter {
	String strDataExcelPath;
	private static Log log = LogFactory.getLog(DownloadAllAnthropometryDataExcelWriter.class);		
	WorkBook objWorkBook = null;
	
	private List<String[]> lstdata = new ArrayList<String[]>();
	
	public WorkBook PrepareExcel(String str_session_id, 
								 File destinationDir, 
								 File destinationDownloadDir, 
								 String excel_template_name, 
								 String fileName,								 
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
			
			lstdata = DataFetcher.getProcData("CALL sp_df_all_anthro()");
			
			int row = start_row;							
			for (int i = 0; i < lstdata.size(); i++) {
				for (int j = 0; j < lstdata.get(i).length; j++) {
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
			int endCol = lstdata.get(0).length;
						
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

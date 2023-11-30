package com.rmspl.odisha.creche.app.managedataedit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;

import com.rmspl.app.data.service.DataFetcher;
import com.rmspl.app.data.service.NoRecordFoundException;
import com.rmspl.odisha.creche.utility.Utility;

import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;

/**
 * Servlet implementation for populate Data Logs
 */
public class EditApprovePendingDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * Write Log
	 */
	private static Log log = LogFactory.getLog(EditApprovePendingDetail.class);
       
	/**
	 * GET Request to populate Data Logs
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[][] datas = null;
		JSONObject json_data = new JSONObject();
		JSONArray ja = new JSONArray();
		JSONArray tempJa = new JSONArray();
		
		try {
			  
			String sel_formid = request.getParameter("formid");
			String sel_mnthid = request.getParameter("mnthid");
			String sel_year = request.getParameter("year");
			
			/*
			CALL `sp_df_data_edit_tbl_det`('11', '11', '2019')-- For Total and a particular month year.
			CALL `sp_df_data_edit_tbl_det`('10', '12', '2019')-- For Creche Committee Meeting and a particular month year.
			CALL `sp_df_data_edit_tbl_det`('9', '11', '2019')-- For Follow-up after Discharge from NRC and a particular month year.
			CALL `sp_df_data_edit_tbl_det`('8', '11', '2019')-- For NRC Register and a particular month year.
			CALL `sp_df_data_edit_tbl_det`('7', '11', '2019') -- For Creche Monitoring Checklist. and a particular month year.
			CALL `sp_df_data_edit_tbl_det`('6', '11', '2019')-- For Quality Check Monitoring and a particular month year.
			CALL `sp_df_data_edit_tbl_det`('5', '11', '2019')-- For Red Flag Follow-up and a particular month year.
			CALL `sp_df_data_edit_tbl_det`('4', '03', '2020')-- For Monthly Attendance and a particular month year.
			CALL `sp_df_data_edit_tbl_det`('3', '03', '2020')-- For Monthly Anthropometry and a particular month year.
			CALL `sp_df_data_edit_tbl_det`('2', '12', '2019')-- For Child Details and a particular month year.
			CALL `sp_df_data_edit_tbl_det`('1', '12', '2019') -- For Household and a particular month year.
			
			CALL `sp_df_data_edit_tbl_det`('10', NULL, '2019')-- For Creche Committee Meeting and a particular month year.
			CALL `sp_df_data_edit_tbl_det`('9', NULL, '2019')-- For Follow-up after Discharge from NRC and a particular month year.
			CALL `sp_df_data_edit_tbl_det`('8', NULL, '2019')-- For NRC Register and a particular month year.
			CALL `sp_df_data_edit_tbl_det`('7', NULL, '2019') -- For Creche Monitoring Checklist. and a particular month year.
			CALL `sp_df_data_edit_tbl_det`('6', NULL, '2019')-- For Quality Check Monitoring and a particular month year.
			CALL `sp_df_data_edit_tbl_det`('5', NULL, '2019')-- For Red Flag Follow-up and a particular month year.
			CALL `sp_df_data_edit_tbl_det`('4', NULL, '2019')-- For Monthly Attendance and a particular month year.
			CALL `sp_df_data_edit_tbl_det`('3', NULL, '2019')-- For Monthly Anthropometry and a particular month year.
			CALL `sp_df_data_edit_tbl_det`('2', NULL, '2019')-- For Child Details and a particular month year.
			CALL `sp_df_data_edit_tbl_det`('1', NULL, '2019') -- For Household and a particular month year.
			*/
			
			String str_sql = "CALL sp_df_data_edit_tbl_det("+Utility.checkVal(sel_formid)+", "
															+Utility.checkVal(sel_mnthid)+", "
															+Utility.checkVal(sel_year)+")";
			
			List<String[]> lstdata = DataFetcher.getProcData(str_sql);		
			
			
			datas = new String[lstdata.size()][lstdata.get(0).length];
			
			for (int i = 0; i < datas.length; i++){
				tempJa = new JSONArray();
				//tempJa.add(lstdata.get(i)[4]);
			  	for (int j = 0; j < datas[i].length;j++) {
			  		if(lstdata.get(i)[j].equalsIgnoreCase("N/A") || lstdata.get(i)[j].equalsIgnoreCase("(NULL)")) {
			  			tempJa.add("-");
			  		} else{
			  			tempJa.add(lstdata.get(i)[j]);
			  		}
		  		}
			  	ja.add(tempJa);
	  		}
			//JSONObject json_data = new JSONObject();
			json_data.put("data", ja);		
			
			response.getWriter().print(json_data);	
			/*
			 * } catch(NoRecordFoundException e){
			 * log.info("Error to get data From DB ... Cause : "+e.getLocalizedMessage());
			 * response.getWriter().print("N/A");
			 */
		} catch (Exception e) { 
			tempJa = new JSONArray();
			tempJa.add("");
			tempJa.add("No Data");
			for (int j = 0; j < 13;j++) {
				tempJa.add("");
	  		}
		  	ja.add(tempJa);
		  	json_data.put("data", ja);
		  	response.getWriter().print(json_data);
		}	
	}
}

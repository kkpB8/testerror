package com.rmspl.odisha.creche.mobile.sync;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.rmspl.app.data.service.ApkVersionMismatchException;
import com.rmspl.app.data.service.DataFetcher;
import com.rmspl.app.data.service.JsonParseException;
import com.rmspl.app.data.service.NoRecordFoundException;
import com.rmspl.app.misc.LogCreator;
import com.rmspl.odisha.creche.mobile.util.Utility;

/**
 * Servlet implementation class Data Sync
 */
public class DataSync extends HttpServlet {
	/**
	 * version identifier for a Serializable class
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * path of temporary directory
	 */
	//private static final String TMP_DIR_PATH = FileUtils.getTempDirectoryPath();
	/**
	 * temporary director to confirm whether path exists or not
	 */
	//private File tmpDir;
	/**
	 * Write log
	 */
	private static Log log = LogFactory.getLog(DataSync.class);
	/**
	 * directory for uploaded files
	 */
	//private File destinationDir;
	/**
	 * Actual path for Image files
	 */
	//private String imagePath;
	/**
	 * directory for Log files
	 */
	private File logDir;
	/**
	 * Actual path for Log files
	 */
	private String logPath;
	/**
	 * Response Data
	 */	
	//private JSONObject json_resp = new JSONObject();
	
	
	private JSONArray arr_json_resp = new JSONArray();
	
	/**
	 * setting the uploaded file directory path before servlet accepts any request 
	 */
	public void init(ServletConfig config) throws ServletException {		
		super.init(config);
		/*tmpDir = new File(TMP_DIR_PATH);
		
		if(!tmpDir.isDirectory()) {
			throw new ServletException(TMP_DIR_PATH + " is not a directory");
		}
		imagePath = getServletContext().getInitParameter("FilePath");
		destinationDir = new File(imagePath);
		if(!destinationDir.isDirectory()) {
			Utility.createDirectory(new File(imagePath));
		}
		logPath = getServletContext().getInitParameter("FilePath")+"/Log/";
		logDir = new File(logPath);
		if(!logDir.isDirectory()) {
			Utility.createDirectory(new File(getServletContext().getInitParameter("FilePath")+"/Log/"));
		}*/
		logPath = getServletContext().getInitParameter("FilePath")+"/Log/Data_Sync/";
		logDir = new File(logPath);
		if(!logDir.isDirectory()) {
			Utility.createDirectory(new File(getServletContext().getInitParameter("FilePath")+"/Log/Data_Sync/"));
		}
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		
		
		try {
			String str_imei = request.getParameter("imei");
			String str_user_name = request.getParameter("user_name");

			List<String[]> lst_data = new ArrayList<String[]>();
			
			lst_data = DataFetcher.getProcData("CALL sp_df_hh_list_pd("+
													Utility.checkVal(str_imei)+", "+
													Utility.checkVal(str_user_name)+
													")");
			processData(lst_data, "hh_list_pd");
			
			lst_data = DataFetcher.getProcData("CALL sp_df_child_dtl_pd("+
													Utility.checkVal(str_imei)+", "+
													Utility.checkVal(str_user_name)+
													")");
			processData(lst_data, "child_dtl_pd");
			
			lst_data = DataFetcher.getProcData("CALL sp_df_child_anthropometry_pd("+
													Utility.checkVal(str_imei)+", "+
													Utility.checkVal(str_user_name)+
													")");
			processData(lst_data, "child_anthropometry_pd");
			
			lst_data = DataFetcher.getProcData("CALL sp_df_child_mnth_attend_pd("+
													Utility.checkVal(str_imei)+", "+
													Utility.checkVal(str_user_name)+
													")");
			processData(lst_data, "child_mnth_attend_pd");
			
			lst_data = DataFetcher.getProcData("CALL sp_df_child_redflag_pd("+
													Utility.checkVal(str_imei)+", "+
													Utility.checkVal(str_user_name)+
													")");
			processData(lst_data, "child_redflag_pd");	
			
			/*for (int i = 0; i < arr_json_resp.size(); i++) {
				JSONObject obj_json = (JSONObject) arr_json_resp.get(i);				
				if(obj_json.containsKey("hh_list_pd")) {
					JSONArray arr_temp = (JSONArray) obj_json.get("hh_list_pd");					
					for (int j = 0; j < arr_temp.size(); j++) {						
						JSONObject temp_json = (JSONObject) arr_temp.get(j);
						log.info(temp_json.toJSONString());
					}					
				}				
			}*/
			
			response.getWriter().print(arr_json_resp.toJSONString());
			return;
		} catch (NoRecordFoundException e) {			
			//log.error("No Record found Exception for Data Sync.....");
			LogCreator.writeLog(logDir, "No Record found Exception for Data Sync.....", LogCreator.MESSAGE);
			response.getWriter().print("error");
			return;
		} catch(JsonParseException ex) {
			//log.error("Json Parse exception for Data Sync",ex);
			LogCreator.writeLog(logDir, "Json Parse exception for Data Sync.....", LogCreator.MESSAGE);
			response.getWriter().print("error");
			return;
		} /*catch(ParseException ex) {
			ex.printStackTrace();
			//log.error("Parse exception for Data Sync",ex);
			LogCreator.writeLog(logDir, "Parse exception for Data Sync.....", LogCreator.MESSAGE);
			response.getWriter().print("error");
			return;
		}*/ catch(Exception ex) {
			ex.printStackTrace();
			//log.error("Exception for Data Sync",ex);
			LogCreator.writeLog(logDir, "Exception for Data Sync.....", LogCreator.MESSAGE);
			response.getWriter().print("error");
			return;
		}
	}
	
	/**
	 * Method to process JSON data
	 * @param lst_data
	 * @param tbl_nm
	 * @throws NoRecordFoundException
	 * @throws ApkVersionMismatchException
	 * @throws JsonParseException
	 * @throws ParseException 
	 */
	private void processData(List<String[]> lst_data, String tbl_nm) throws NoRecordFoundException, JsonParseException {
		JSONObject objJson = new JSONObject();	
		//When only column name returns
		if(lst_data.size() == 1) {
			/*
			JSONArray arr_temp = new JSONArray();
			for (int i = 0; i < lst_data.size(); i++) {
				JSONObject temp_json = new JSONObject();
				for (int j = 0; j < lst_data.get(i).length; j++) {
					temp_json.put(lst_data.get(i)[j], "");
				}
				//log.info(temp_json.toJson());	
				arr_temp.add(temp_json);
			}
			//log.info(arr_temp.toJson());
			objJson.put(tbl_nm, arr_temp);
			//log.info(objJson.toJson());	
			arr_json_resp.add(objJson);			
			//log.info(arr_json_resp.toJson());			
			*/
		} 
		//When data returns
		else {
			JSONArray arr_temp = new JSONArray();
			for (int i = 1; i < lst_data.size(); i++) {
				JSONObject temp_json = new JSONObject();
				for (int j = 0; j < lst_data.get(i).length; j++) {
					temp_json.put(lst_data.get(0)[j], lst_data.get(i)[j]);
				}
				//log.info(temp_json.toJson());	
				arr_temp.add(temp_json);
			}
			//log.info(arr_temp.toJson());
			objJson.put(tbl_nm, arr_temp);
			//log.info(objJson.toJson());	
			arr_json_resp.add(objJson);			
			//log.info(arr_json_resp.toJson());			
		}
	}
}

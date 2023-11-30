package com.rmspl.odisha.creche.mobile.dataentry;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
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
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.rmspl.app.data.service.ApkVersionMismatchException;
import com.rmspl.app.data.service.DataFetcher;
import com.rmspl.app.data.service.JsonParseException;
import com.rmspl.app.data.service.NoRecordFoundException;
import com.rmspl.app.misc.LogCreator;
import com.rmspl.odisha.creche.mobile.util.Utility;

/**
 * Servlet implementation class NRC Follow Up
 */
public class NRCFollowUp extends HttpServlet {
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
	//private static Log log = LogFactory.getLog(NRCRegister.class);
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
	private JSONObject json_resp = new JSONObject();
	
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
		logPath = getServletContext().getInitParameter("FilePath")+"/Log/NRC_Follow_Up/";
		logDir = new File(logPath);
		if(!logDir.isDirectory()) {
			Utility.createDirectory(new File(getServletContext().getInitParameter("FilePath")+"/Log/NRC_Follow_Up/"));
		}
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		try {
			processData(response, request.getParameter("data"));
			response.getWriter().print(json_resp);
			return;
		} catch (NoRecordFoundException e) {			
			//log.error("No Record found Exception for NRC Follow Up.....");
			LogCreator.writeLog(logDir, "No Record found Exception for NRC Follow Up.....", LogCreator.MESSAGE);
			setJsonResponse("error");
			response.getWriter().print(json_resp);
			return;
		} catch (ApkVersionMismatchException e) {			
			//log.error("Old apk version for NRC Follow Up.....");
			LogCreator.writeLog(logDir, "Old apk version for NRC Follow Up.....", LogCreator.MESSAGE);
			setJsonResponse("old_apk");
			response.getWriter().print(json_resp);
			return;
		} catch(JsonParseException ex) {
			//log.error("Json Parse exception for NRC Follow Up",ex);
			LogCreator.writeLog(logDir, "Json Parse exception for NRC Follow Up.....", LogCreator.MESSAGE);
			setJsonResponse("error_json");
			response.getWriter().print(json_resp);
			return;
		} catch(ParseException ex) {
			//log.error("Parse exception for NRC Follow Up",ex);
			LogCreator.writeLog(logDir, "Parse exception for NRC Follow Up.....", LogCreator.MESSAGE);
			setJsonResponse("error_parse");
			response.getWriter().print(json_resp);
			return;
		} catch(Exception ex) {
			//log.error("Exception for NRC Follow Up",ex);
			LogCreator.writeLog(logDir, "Exception for NRC Follow Up.....", LogCreator.MESSAGE);
			setJsonResponse("error_exception");
			response.getWriter().print(json_resp);
			return;
		}
	}
	
	/**
	 * Method to process JSON data
	 * @param response
	 * @param data
	 * @throws NoRecordFoundException
	 * @throws ApkVersionMismatchException
	 * @throws JsonParseException
	 * @throws ParseException 
	 */
	private void processData(HttpServletResponse response, String data) throws NoRecordFoundException, ApkVersionMismatchException, JsonParseException, ParseException {
		/*
		1.	app_ver						- App Version.
		2. 	file_id						- File ID.
		3. 	obj_dt						- Object Date
        4. 	obj_time					- Object Date
		5. 	obj_imei					- IMEI.
		7. 	dt_cd						- District Code.
		8. 	bk_cd						- Block Code.
		9. 	gp_cd						- GP Code.
		10. vl_cd						- Village Code.
		11.	creche_cd					- Creche Code.
		12. child_cd					- Child Code.
			
		13. wk_no						- Week No.
		14. wk_dt						- Week Date.
		15. wk_child_wgt_kg				- Weight.
		16. wk_child_muac_cm			- Muac.
		
		17.	log_user					- Users Information
		18.	submit_stat	 				- Submit Status		
		19.	chk							- Return True / False
		*/
		
		String app_ver = null;
		String file_id = null;
		String obj_dt = null;
		String obj_time = null;
		String obj_imei = null;
		String dt_cd = null;
		String bk_cd = null;
		String gp_cd = null;
		String vl_cd = null;
		String creche_cd = null;
		String child_cd = null;
		String wk_no = null;
		String wk_dt = null; 
		String wk_child_wgt_kg = null;
		String wk_child_muac_cm = null;
		
		String log_user = null;		
		String submit_stat = null;		
		String chk = null;
		
		List<String[]> lst_data = null;
		
		//log.info("Enter for Parse.....................");
		//log.info(request.getParameter("data"));
		//Parse the text file
		JSONParser parser = new JSONParser();
		Object obj_data = parser.parse(data);			
		JSONObject jsonObjData = (JSONObject) obj_data;
		
		JSONObject jsonLogData = new JSONObject();
		JSONObject jsonLogImageData = new JSONObject();
		
		Set<String> keys = jsonObjData.keySet();	
		//log.info("Total Key..."+keys.size());
		Iterator<String> itr = keys.iterator();			
		while (itr.hasNext()) {
			String key = itr.next().toString();
		    //System.out.println("Key..."+key);			        
		    //System.out.println("Value..."+jsonObjData.get(key));
			
			//Image key for Child images
		    if(key.startsWith("img_child")) {
		    	jsonLogImageData.put(key, jsonObjData.get(key));
		    } else {
		    	jsonLogData.put(key, jsonObjData.get(key));
		    }				    
		}			
		//log.info("Data for NRC Follow Up : "+jsonLogData.toString());
		LogCreator.writeLog(logDir, "Data for NRC Follow Up: "+jsonLogData.toString(), LogCreator.MESSAGE);
		//LogCreator.writeLog(logDir, "Data for NRC Follow Up Image Information : "+jsonLogImageData.toString(), LogCreator.MESSAGE);
	
		app_ver = jsonObjData.get("app_ver").toString();				
		String db_app_ver = DataFetcher.getData("SELECT app_version FROM hits").get(0)[0];
		
		// Compares Mobile App version with DB App version			     
		//log.info(Double.parseDouble(db_app_ver)+"..."+Double.parseDouble(app_ver));
		//log.info("Compared Value..."+Double.compare(Double.parseDouble(app_ver), Double.parseDouble(db_app_ver)));
	    if(Double.compare(Double.parseDouble(app_ver), Double.parseDouble(db_app_ver)) < 0) {
	    	throw new ApkVersionMismatchException("Old APK..."+file_id);
	    }
		
		file_id = jsonObjData.get("file_id").toString();
		obj_dt = jsonObjData.get("obj_dt").toString();
		obj_time = jsonObjData.get("obj_time").toString();								
		obj_imei = jsonObjData.get("obj_imei").toString();
		dt_cd = jsonObjData.get("dt_cd").toString();
		bk_cd = jsonObjData.get("bk_cd").toString();								
		gp_cd = jsonObjData.get("gp_cd").toString();
		vl_cd = jsonObjData.get("vl_cd").toString();
		creche_cd = jsonObjData.get("creche_cd").toString();
		child_cd = jsonObjData.get("child_cd").toString();
		LogCreator.writeLog(logDir, "1...", LogCreator.MESSAGE);		
		wk_no = jsonObjData.get("wk_no").toString();		
		wk_dt = jsonObjData.get("wk_dt").toString();
		LogCreator.writeLog(logDir, "2...", LogCreator.MESSAGE);
		wk_child_wgt_kg = jsonObjData.get("wk_child_wgt_kg").toString();
		wk_child_muac_cm = jsonObjData.get("wk_child_muac_cm").toString();
		LogCreator.writeLog(logDir, "3...", LogCreator.MESSAGE);
		log_user = jsonObjData.get("log_user").toString();
		submit_stat = jsonObjData.get("submit_stat").toString();		
		chk = jsonObjData.get("chk").toString();
		String date_time = obj_dt + " "+ obj_time.replaceAll("-", ":");
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			LogCreator.writeLog(logDir, "Error to sleep..."+e.getLocalizedMessage(), LogCreator.ERROR);
		}
		
		String mst_child_nrc_follow_up_sql = null;			
		mst_child_nrc_follow_up_sql = "CALL sp_di_child_nrc_followup("+
								Utility.checkVal(app_ver)+", "+
								Utility.checkVal(file_id)+", "+
								Utility.checkVal(date_time)+", "+
								Utility.checkVal(obj_imei)+", "+
								Utility.checkVal(dt_cd)+", "+
								Utility.checkVal(bk_cd)+", "+
								Utility.checkVal(gp_cd)+", "+
								Utility.checkVal(vl_cd)+", "+
								Utility.checkVal(creche_cd)+", "+
								Utility.checkVal(child_cd)+", "+
								Utility.checkVal(wk_no)+", "+
								Utility.checkVal(wk_dt)+", "+
								Utility.checkVal(wk_child_wgt_kg)+", "+								
								Utility.checkVal(wk_child_muac_cm)+", "+																
								Utility.checkVal(log_user)+", "+
								Utility.checkVal(submit_stat)+", "+
								Utility.checkVal(com.rmspl.odisha.creche.utility.Utility.getCurrentDateTime())+", "+
								Utility.checkVal(chk)+")";
		
		//LogCreator.writeLog(logDir, "SQL for NRC Follow Up : "+mst_child_nrc_follow_up_sql, LogCreator.MESSAGE);
		lst_data = DataFetcher.getProcData(mst_child_nrc_follow_up_sql);
		
					
		if(lst_data.get(0)[0].equalsIgnoreCase("1")) {
			setJsonResponse("done");	
		} else if(lst_data.get(0)[0].equalsIgnoreCase("0")) {						
			setJsonResponse("no_user");
		} else if(lst_data.get(0)[0].equalsIgnoreCase("2")) {						
			setJsonResponse("no_child");
		} else {				
			//log.error("Error to upload NRC Follow Up Data..."+file_id);
			LogCreator.writeLog(logDir, "Error to upload NRC Follow Up Data..."+file_id, LogCreator.MESSAGE);
			throw new NoRecordFoundException("Error to upload Data..."+file_id+"...");
		}
	}
	
	/**
	 * Method to set response in json
	 * @param status
	 * @return
	 */
	private JSONObject setJsonResponse(String status) {
		//log.info("here in setJsonResponse..."+status+"..."+hh_code);
		json_resp.put("status", status);
		return json_resp;
	}	
}

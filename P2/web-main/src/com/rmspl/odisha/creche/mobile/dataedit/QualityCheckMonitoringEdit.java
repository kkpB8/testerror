package com.rmspl.odisha.creche.mobile.dataedit;

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
 * Servlet implementation class Quality Check Monitoring Edit
 */
public class QualityCheckMonitoringEdit extends HttpServlet {
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
	//private static Log log = LogFactory.getLog(QualityCheckMonitoringEdit.class);
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
		logPath = getServletContext().getInitParameter("FilePath")+"/Log/Quality_Check_Monitoring/";
		logDir = new File(logPath);
		if(!logDir.isDirectory()) {
			Utility.createDirectory(new File(getServletContext().getInitParameter("FilePath")+"/Log/Quality_Check_Monitoring/"));
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
			//log.error("No Record found Exception for Quality Check Monitoring Edit.....");
			LogCreator.writeLog(logDir, "No Record found Exception for Quality Check Monitoring Edit.....", LogCreator.MESSAGE);
			setJsonResponse("error");
			response.getWriter().print(json_resp);
			return;
		} catch (ApkVersionMismatchException e) {			
			//log.error("Old apk version for Quality Check Monitoring Edit.....");
			LogCreator.writeLog(logDir, "Old apk version for Quality Check Monitoring Edit.....", LogCreator.MESSAGE);
			setJsonResponse("old_apk");
			response.getWriter().print(json_resp);
			return;
		} catch(JsonParseException ex) {
			//log.error("Json Parse exception for Quality Check Monitoring Edit",ex);
			LogCreator.writeLog(logDir, "Json Parse exception for Quality Check Monitoring Edit.....", LogCreator.MESSAGE);
			setJsonResponse("error_json");
			response.getWriter().print(json_resp);
			return;
		} catch(ParseException ex) {
			//log.error("Parse exception for Quality Check Monitoring Edit",ex);
			LogCreator.writeLog(logDir, "Parse exception for Quality Check Monitoring Edit.....", LogCreator.MESSAGE);
			setJsonResponse("error_parse");
			response.getWriter().print(json_resp);
			return;
		} catch(Exception ex) {
			//log.error("Exception for Quality Check Monitoring Edit",ex);
			LogCreator.writeLog(logDir, "Exception for Quality Check Monitoring Edit.....", LogCreator.MESSAGE);
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
		1.	app_ver						- takes App Version.
		2. 	file_id						- takes File ID.
		3. 	obj_dt						- takes Object Date
        4. 	obj_time					- takes Object Date
		5. 	obj_imei					- takes IMEI.
		7. 	dt_cd						- takes District Code.
		8. 	bk_cd						- takes Block Code.
		9. 	gp_cd						- takes GP Code.
		10. vl_cd						- takes Village Code.
		11.	creche_cd					- takes Creche Code.
		12.	anthro_dt  					- takes Anthro Date.
		13.	child_cd					- Child Code
		14.	child_dob	    			- Child DoB
		15.	child_gen	 				- Child Gender
		16.	child_age_mnth	 			- Child Age in Month
		17.	child_dt_masure_wgt	 		- Child Weight Measure Date
		18.	child_wgt_kg				- Child Weight (in kg)
		19.	child_dt_masure_lngth	    - Child Length Measure Date
		20.	child_lngth_hgt_cm	 		- Child Length (in cm)
		21.	instr_use	 				- Instrument Used
		22.	child_wgt_kg_qck	      	- Child Weight (in kg) during QC
		23.	child_lngth_hgt_cm_qck	 	- Child Length (in cm) during QC
		24.	instr_use_qck 				- Instrument Used during QC
		25. child_wgt_chk_qck  
		26. child_hgt_chk_qck
		27. child_wgt_anthro
		28. child_hgt_anthro
		29.	submit_stat	 				- Submit Status
		30.	log_user					- Users Information
		31.	chk							- Return True / False
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
		String anthro_dt = null;
		String child_cd = null;
		String child_dob = null;
		String child_gen = null;
		String child_age_mnth = null;
		String child_dt_masure_wgt = null;
		String child_wgt_kg = null;
		String child_dt_masure_lngth = null;
		String child_lngth_hgt_cm = null;
		String instr_use = null;
		String child_wgt_kg_qck = null;
		String child_lngth_hgt_cm_qck = null;
		String instr_use_qck = null;
		
		String child_wgt_chk_qck = null;
		String child_hgt_chk_qck = null;
		String child_wgt_anthro = null;
		String child_hgt_anthro = null;
		
		String remarks = null;
		String submit_stat = null;
		String log_user = null;
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
		//log.info("Data for Quality Check Monitoring Edit : "+jsonLogData.toString());
		LogCreator.writeLog(logDir, "Data for Quality Check Monitoring : "+jsonLogData.toString(), LogCreator.MESSAGE);
		//LogCreator.writeLog(logDir, "Data for Quality Check Monitoring Edit Image Information : "+jsonLogImageData.toString(), LogCreator.MESSAGE);
	
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
		anthro_dt = jsonObjData.get("anthro_dt").toString();
		child_cd = jsonObjData.get("child_cd").toString();
		child_dob = jsonObjData.get("child_dob").toString();
		child_gen = jsonObjData.get("child_gen").toString();
		child_age_mnth = jsonObjData.get("child_age_mnth").toString();
		child_dt_masure_wgt = jsonObjData.get("child_dt_masure_wgt").toString();
		child_wgt_kg = jsonObjData.get("child_wgt_kg").toString();
		child_dt_masure_lngth = jsonObjData.get("child_dt_masure_lngth").toString();
		child_lngth_hgt_cm = jsonObjData.get("child_lngth_hgt_cm").toString();
		instr_use = jsonObjData.get("instr_use").toString();
		child_wgt_kg_qck = jsonObjData.get("child_wgt_kg_qck").toString();
		child_lngth_hgt_cm_qck = jsonObjData.get("child_lngth_hgt_cm_qck").toString();
		instr_use_qck = jsonObjData.get("instr_use_qck").toString();
		
		child_wgt_chk_qck = jsonObjData.get("child_wgt_chk_qck").toString();
		child_hgt_chk_qck = jsonObjData.get("child_hgt_chk_qck").toString();
		child_wgt_anthro = jsonObjData.get("child_wgt_anthro").toString();
		child_hgt_anthro = jsonObjData.get("child_hgt_anthro").toString();
		
		remarks = jsonObjData.get("remarks").toString();
		submit_stat = jsonObjData.get("submit_stat").toString();
		log_user = jsonObjData.get("log_user").toString();
		chk = jsonObjData.get("chk").toString();
		String date_time = obj_dt + " "+ obj_time.replaceAll("-", ":");
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			LogCreator.writeLog(logDir, "Error to sleep..."+e.getLocalizedMessage(), LogCreator.ERROR);
		}
		
		String mst_qlty_chk_monitor_sql = null;			
		mst_qlty_chk_monitor_sql = "CALL sp_di_qlty_chk_monitor_edit("+
								Utility.checkVal(app_ver)+", "+
								Utility.checkVal(file_id)+", "+
								Utility.checkVal(date_time)+", "+
								Utility.checkVal(obj_imei)+", "+
								Utility.checkVal(dt_cd)+", "+
								Utility.checkVal(bk_cd)+", "+
								Utility.checkVal(gp_cd)+", "+
								Utility.checkVal(vl_cd)+", "+
								Utility.checkVal(creche_cd)+", "+
								Utility.checkVal(anthro_dt)+", "+
								Utility.checkVal(child_cd)+", "+
								Utility.checkVal(child_dob)+", "+
								Utility.checkVal(child_gen)+", "+
								Utility.checkVal(child_age_mnth)+", "+
								Utility.checkVal(child_dt_masure_wgt)+", "+
								Utility.checkVal(child_wgt_kg)+", "+
								Utility.checkVal(child_dt_masure_lngth)+", "+
								Utility.checkVal(child_lngth_hgt_cm)+", "+
								Utility.checkVal(instr_use)+", "+
								Utility.checkVal(child_wgt_kg_qck)+", "+
								Utility.checkVal(child_lngth_hgt_cm_qck)+", "+
								Utility.checkVal(instr_use_qck)+", "+
								
								Utility.checkVal(child_wgt_chk_qck)+", "+
								Utility.checkVal(child_hgt_chk_qck)+", "+
								Utility.checkVal(child_wgt_anthro)+", "+
								Utility.checkVal(child_hgt_anthro)+", "+

								Utility.checkVal(log_user)+", "+
								Utility.checkVal(submit_stat)+", "+
								Utility.checkVal(remarks)+", "+
								Utility.checkVal(com.rmspl.odisha.creche.utility.Utility.getCurrentDateTime())+", "+
								Utility.checkVal(chk)+")";
		
		lst_data = DataFetcher.getProcData(mst_qlty_chk_monitor_sql);
					
		if(lst_data.get(0)[0].equalsIgnoreCase("1")) {
			setJsonResponse("done");	
		} else if(lst_data.get(0)[0].equalsIgnoreCase("0")) {						
			setJsonResponse("no_user");
		} else if(lst_data.get(0)[0].equalsIgnoreCase("2")) {						
			setJsonResponse("no_child");
		} else {				
			//log.error("Error to upload Quality Check Monitoring Data Edit..."+file_id);
			LogCreator.writeLog(logDir, "Error to upload Quality Check Monitoring Edit Data..."+file_id, LogCreator.MESSAGE);
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

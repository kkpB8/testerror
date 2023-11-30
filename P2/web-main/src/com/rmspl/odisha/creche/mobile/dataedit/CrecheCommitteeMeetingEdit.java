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
 * Servlet implementation class Creche Committee Meeting Edit
 */
public class CrecheCommitteeMeetingEdit extends HttpServlet {
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
	//private static Log log = LogFactory.getLog(CrecheCommitteeMeetingEdit.class);
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
		logPath = getServletContext().getInitParameter("FilePath")+"/Log/Creche_Committee_Meeting/";
		logDir = new File(logPath);
		if(!logDir.isDirectory()) {
			Utility.createDirectory(new File(getServletContext().getInitParameter("FilePath")+"/Log/Creche_Committee_Meeting/"));
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
			//log.error("No Record found Exception for Creche Committee Meeting Edit.....");
			LogCreator.writeLog(logDir, "No Record found Exception for Creche Committee Meeting Edit.....", LogCreator.MESSAGE);
			setJsonResponse("error");
			response.getWriter().print(json_resp);
			return;
		} catch (ApkVersionMismatchException e) {			
			//log.error("Old apk version for Creche Committee Meeting Edit.....");
			LogCreator.writeLog(logDir, "Old apk version for Creche Committee Meeting Edit.....", LogCreator.MESSAGE);
			setJsonResponse("old_apk");
			response.getWriter().print(json_resp);
			return;
		} catch(JsonParseException ex) {
			//log.error("Json Parse exception for Creche Committee Meeting Edit",ex);
			LogCreator.writeLog(logDir, "Json Parse exception for Creche Committee Meeting Edit.....", LogCreator.MESSAGE);
			setJsonResponse("error_json");
			response.getWriter().print(json_resp);
			return;
		} catch(ParseException ex) {
			//log.error("Parse exception for Creche Committee Meeting Edit",ex);
			LogCreator.writeLog(logDir, "Parse exception for Creche Committee Meeting Edit.....", LogCreator.MESSAGE);
			setJsonResponse("error_parse");
			response.getWriter().print(json_resp);
			return;
		} catch(Exception ex) {
			//log.error("Exception for Creche Committee Meeting Edit",ex);
			LogCreator.writeLog(logDir, "Exception for Creche Committee Meeting Edit.....", LogCreator.MESSAGE);
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
		12. meeting_dt 
        13. no_part_meeting
        14. asha_part_meeting
        15. aww_part_meeting
        16. other_part_meeting
        17. other_part_meeting_nm
        18. blk_prj_part_meeting
        19. mejor_discuss
        20. mejor_decision
        21. proposed_dt_meet
        22. remarks
		23.	submit_stat	 				- Submit Status
		24.	log_user					- Users Information
		25.	chk							- Return True / False
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
		String meeting_dt = null; 
		String no_part_meeting = null;
		String asha_part_meeting = null;
		String aww_part_meeting = null;
		String other_part_meeting = null;
		String other_part_meeting_nm = null;
		String blk_prj_part_meeting = null;
		String mejor_discuss = null;
		String mejor_decision = null;
		String proposed_dt_meet = null;
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
		//log.info("Data for Creche Committee Meeting Edit : "+jsonLogData.toString());
		LogCreator.writeLog(logDir, "Data for Creche Committee Meeting Edit : "+jsonLogData.toString(), LogCreator.MESSAGE);
		//LogCreator.writeLog(logDir, "Data for Creche Committee Meeting Edit Image Information : "+jsonLogImageData.toString(), LogCreator.MESSAGE);
	
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
		meeting_dt = jsonObjData.get("meeting_dt").toString();
		no_part_meeting = jsonObjData.get("no_part_meeting").toString();
		asha_part_meeting = jsonObjData.get("asha_part_meeting").toString();
		aww_part_meeting = jsonObjData.get("aww_part_meeting").toString();
		other_part_meeting = jsonObjData.get("other_part_meeting").toString();
		other_part_meeting_nm = jsonObjData.get("other_part_meeting_nm").toString();
		blk_prj_part_meeting = jsonObjData.get("blk_prj_part_meeting").toString();
		mejor_discuss = jsonObjData.get("mejor_discuss").toString();
		mejor_decision = jsonObjData.get("mejor_decision").toString();
		proposed_dt_meet = jsonObjData.get("proposed_dt_meet").toString();
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
		
		String mst_creche_commit_meeting_sql = null;			
		mst_creche_commit_meeting_sql = "CALL sp_di_creche_commit_meeting_edit("+
								Utility.checkVal(app_ver)+", "+
								Utility.checkVal(file_id)+", "+
								Utility.checkVal(date_time)+", "+
								Utility.checkVal(obj_imei)+", "+
								Utility.checkVal(dt_cd)+", "+
								Utility.checkVal(bk_cd)+", "+
								Utility.checkVal(gp_cd)+", "+
								Utility.checkVal(vl_cd)+", "+
								Utility.checkVal(creche_cd)+", "+
								Utility.checkVal(meeting_dt)+", "+
								Utility.checkVal2(no_part_meeting)+", "+
								Utility.checkVal2(asha_part_meeting)+", "+
								Utility.checkVal2(aww_part_meeting)+", "+
								Utility.checkVal2(other_part_meeting)+", "+
								Utility.checkVal2(other_part_meeting_nm)+", "+
								Utility.checkVal2(blk_prj_part_meeting)+", "+
								Utility.checkVal(mejor_discuss)+", "+
								Utility.checkVal(mejor_decision)+", "+
								Utility.checkVal(proposed_dt_meet)+", "+
								Utility.checkVal(log_user)+", "+
								Utility.checkVal(submit_stat)+", "+
								Utility.checkVal(remarks)+", "+
								Utility.checkVal(com.rmspl.odisha.creche.utility.Utility.getCurrentDateTime())+", "+
								Utility.checkVal(chk)+")";
		
		lst_data = DataFetcher.getProcData(mst_creche_commit_meeting_sql);
					
		if(lst_data.get(0)[0].equalsIgnoreCase("1")) {
			setJsonResponse("done");	
		} else if(lst_data.get(0)[0].equalsIgnoreCase("0")) {						
			setJsonResponse("no_user");
		} else if(lst_data.get(0)[0].equalsIgnoreCase("2")) {						
			setJsonResponse("no_child");
		} else {				
			//log.error("Error to upload Creche Committee Meeting Data Edit..."+file_id);
			LogCreator.writeLog(logDir, "Error to upload Creche Committee Meeting Data Edit..."+file_id, LogCreator.MESSAGE);
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

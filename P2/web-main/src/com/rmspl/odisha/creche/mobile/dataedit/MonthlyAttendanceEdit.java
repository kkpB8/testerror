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
 * Servlet implementation class Monthly Attendance Edit
 */
public class MonthlyAttendanceEdit extends HttpServlet {
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
	//private static Log log = LogFactory.getLog(MonthlyAttendance.class);
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
		logPath = getServletContext().getInitParameter("FilePath")+"/Log/Monthly_Attendance/";
		logDir = new File(logPath);
		if(!logDir.isDirectory()) {
			Utility.createDirectory(new File(getServletContext().getInitParameter("FilePath")+"/Log/Monthly_Attendance/"));
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
			//log.error("No Record found Exception for Monthly Attendance Edit.....");
			LogCreator.writeLog(logDir, "No Record found Exception for Monthly Attendance Edit.....", LogCreator.MESSAGE);
			setJsonResponse("error");
			response.getWriter().print(json_resp);
			return;
		} catch (ApkVersionMismatchException e) {			
			//log.error("Old apk version for Monthly Attendance Edit.....");
			LogCreator.writeLog(logDir, "Old apk version for Monthly Attendance Edit.....", LogCreator.MESSAGE);
			setJsonResponse("old_apk");
			response.getWriter().print(json_resp);
			return;
		} catch(JsonParseException ex) {
			//log.error("Json Parse exception for Monthly Attendance Edit",ex);
			LogCreator.writeLog(logDir, "Json Parse exception for Monthly Attendance Edit.....", LogCreator.MESSAGE);
			setJsonResponse("error_json");
			response.getWriter().print(json_resp);
			return;
		} catch(ParseException ex) {
			//log.error("Parse exception for Monthly Attendance Edit",ex);
			LogCreator.writeLog(logDir, "Parse exception for Monthly Attendance Edit.....", LogCreator.MESSAGE);
			setJsonResponse("error_parse");
			response.getWriter().print(json_resp);
			return;
		} catch(Exception ex) {
			//log.error("Exception for Monthly Attendance Edit",ex);
			LogCreator.writeLog(logDir, "Exception for Monthly Attendance Edit.....", LogCreator.MESSAGE);
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
		6. 	hh_cd       				- takes HH Code.
		7. 	dt_cd						- takes District Code.
		8. 	bk_cd						- takes Block Code.
		9. 	gp_cd						- takes GP Code.
		10. vl_cd						- takes Village Code.
		11.	creche_cd					- takes Creche Code.
		12.	mnth_yr  					- takes Month Year.
		13.	creche_opan_d				- No. of Days in month the Creche was opened
		14.	child_cd	    			- Child Code
		15.	child_attd_creche_d	 		- Total No. of days child attended the Creche
		16.	child_inact_reason	 		- Reason for Child being inactive
		17.	child_inact_reason_oth	 	- Reason for Child being inactive (Other)
		18.	child_absent_more_7d		- Is the child is absent for more than 7 consecutive days?
		19.	child_absent_reason	    	- Reason for absenteeism
		20.	child_absent_reason_oth	 	- Reason for absenteeism (Other)
		21.	child_recv_thr_awc	     	- Has the child received THR from AWC?
		22.	child_wgt_taken_awc	     	- Whether weight taken at AWC?
		23.	awc_wgt_neasure_avail	 	- Whether AWC weight measurement is available?
		24.	child_wgt_kg_awc	      	- Weight (in kg) in AWC
		25.	child_wgt_not_reason	 	- Reason for not getting AWC weight
		26.	child_wgt_not_reason_oth 	- Reason for not getting AWC weight (Other)
		27.	child_ill_dur_mnth_yn	 	- Was the child ill any time during the month?
		28.	child_ill_dur_mnth_specify	- If, Yes, then specify the illness
		30.	child_enroll_stat_yn	    - Enrollment Status Yes/No
		29.	child_enroll_stat	        - Enrollment Status
		30.	users_nm	    			- Users Information
		31.	submit_stat	                - Submit Status
		32.	chk							- Return True / False
		33. ent_remarks					- Edit Remarks
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
		String mnth_yr = null;
		String creche_opan_d = null;
		String child_cd = null;
		String child_attd_creche_d = null;
		String child_inact_reason = null;
		String child_inact_reason_oth = null;
		String child_absent_more_7d = null;
		String child_absent_reason = null;
		String child_absent_reason_oth = null;
		String child_recv_thr_awc = null;
		String child_wgt_taken_awc = null;
		String awc_wgt_neasure_avail = null;
		String child_wgt_kg_awc = null;
		String child_wgt_not_reason = null;
		String child_wgt_not_reason_oth = null;
		String child_ill_dur_mnth_yn = null;
		String child_ill_dur_mnth_specify = null;
		String child_enroll_stat_yn = null;
		String child_enroll_stat = null;
		String users_nm = null;
		String submit_stat = null;
		String chk = null;
		String remarks = null;
		
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
		//log.info("Data for Monthly Attendance Edit : "+jsonLogData.toString());
		LogCreator.writeLog(logDir, "Data for Monthly Attendance Edit : "+jsonLogData.toString(), LogCreator.MESSAGE);
		//LogCreator.writeLog(logDir, "Data for Monthly Attendance Edit Image Information : "+jsonLogImageData.toString(), LogCreator.MESSAGE);
	
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
		mnth_yr = jsonObjData.get("mnth_yr").toString();
		creche_opan_d = jsonObjData.get("creche_opan_d").toString();
		child_cd = jsonObjData.get("child_cd").toString();
		child_attd_creche_d = jsonObjData.get("child_attd_creche_d").toString();
		child_inact_reason = jsonObjData.get("child_inact_reason").toString();
		child_inact_reason_oth = jsonObjData.get("child_inact_reason_oth").toString();
		child_absent_more_7d = jsonObjData.get("child_absent_more_7d").toString();
		child_absent_reason = jsonObjData.get("child_absent_reason").toString();
		child_absent_reason_oth = jsonObjData.get("child_absent_reason_oth").toString();
		child_recv_thr_awc = jsonObjData.get("child_recv_thr_awc").toString();
		child_wgt_taken_awc = jsonObjData.get("child_wgt_taken_awc").toString();
		awc_wgt_neasure_avail = jsonObjData.get("awc_wgt_neasure_avail").toString();
		child_wgt_kg_awc = jsonObjData.get("child_wgt_kg_awc").toString();
		child_wgt_not_reason = jsonObjData.get("child_wgt_not_reason").toString();
		child_wgt_not_reason_oth = jsonObjData.get("child_wgt_not_reason_oth").toString();
		child_ill_dur_mnth_yn = jsonObjData.get("child_ill_dur_mnth_yn").toString();
		child_ill_dur_mnth_specify = jsonObjData.get("child_ill_dur_mnth_specify").toString();
		child_enroll_stat_yn = jsonObjData.get("child_enroll_stat_yn").toString();
		child_enroll_stat = jsonObjData.get("child_enroll_stat").toString();
		users_nm = jsonObjData.get("users_nm").toString();
		submit_stat = jsonObjData.get("submit_stat").toString();
		chk = jsonObjData.get("chk").toString();
		remarks = jsonObjData.get("remarks").toString();
		
		String date_time = obj_dt + " "+ obj_time.replaceAll("-", ":");
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			LogCreator.writeLog(logDir, "Error to sleep..."+e.getLocalizedMessage(), LogCreator.ERROR);
		}
		
		String mst_mnth_attn_sql = null;			
		mst_mnth_attn_sql = "CALL sp_di_child_mnth_attend_edit("+
								Utility.checkVal(app_ver)+", "+
								Utility.checkVal(file_id)+", "+
								Utility.checkVal(date_time)+", "+
								Utility.checkVal(obj_imei)+", "+
								Utility.checkVal(dt_cd)+", "+
								Utility.checkVal(bk_cd)+", "+
								Utility.checkVal(gp_cd)+", "+
								Utility.checkVal(vl_cd)+", "+
								Utility.checkVal(creche_cd)+", "+
								Utility.checkVal(mnth_yr)+", "+
								Utility.checkVal(creche_opan_d)+", "+
								Utility.checkVal(child_cd)+", "+
								Utility.checkVal(child_attd_creche_d)+", "+
								Utility.checkVal(child_inact_reason)+", "+
								Utility.checkVal(child_inact_reason_oth)+", "+
								Utility.checkVal(child_absent_more_7d)+", "+
								Utility.checkVal(child_absent_reason)+", "+
								Utility.checkVal(child_absent_reason_oth)+", "+
								Utility.checkVal(child_recv_thr_awc)+", "+
								Utility.checkVal(child_wgt_taken_awc)+", "+
								Utility.checkVal(awc_wgt_neasure_avail)+", "+
								Utility.checkVal(child_wgt_kg_awc)+", "+
								Utility.checkVal(child_wgt_not_reason)+", "+
								Utility.checkVal(child_wgt_not_reason_oth)+", "+
								Utility.checkVal(child_ill_dur_mnth_yn)+", "+
								Utility.checkVal(child_ill_dur_mnth_specify)+", "+
								Utility.checkVal(child_enroll_stat_yn)+", "+
								Utility.checkVal(child_enroll_stat)+", "+
								Utility.checkVal(users_nm)+", "+
								Utility.checkVal(submit_stat)+", "+
								Utility.checkVal(remarks)+", "+
								Utility.checkVal(com.rmspl.odisha.creche.utility.Utility.getCurrentDateTime())+", "+
								Utility.checkVal(chk)+")";
		
		lst_data = DataFetcher.getProcData(mst_mnth_attn_sql);
					
		if(lst_data.get(0)[0].equalsIgnoreCase("1")) {
			setJsonResponse("done");	
		} else if(lst_data.get(0)[0].equalsIgnoreCase("0")) {						
			setJsonResponse("no_user");
		} else if(lst_data.get(0)[0].equalsIgnoreCase("2")) {						
			setJsonResponse("no_child");
		} else {				
			//log.error("Error to upload Monthly Attendance Edit Data..."+file_id);
			LogCreator.writeLog(logDir, "Error to upload Monthly Attendance Edit Data..."+file_id, LogCreator.MESSAGE);
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

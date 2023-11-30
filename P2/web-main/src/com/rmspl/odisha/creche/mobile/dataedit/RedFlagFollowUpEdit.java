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
 * Servlet implementation class Red Flag Follow Up Edit
 */
public class RedFlagFollowUpEdit extends HttpServlet {
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
	//private static Log log = LogFactory.getLog(RedFlagFollowUp.class);
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
		logPath = getServletContext().getInitParameter("FilePath")+"/Log/Red_Flag_Follow_Up/";
		logDir = new File(logPath);
		if(!logDir.isDirectory()) {
			Utility.createDirectory(new File(getServletContext().getInitParameter("FilePath")+"/Log/Red_Flag_Follow_Up/"));
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
			//log.error("No Record found Exception for Red Flag Follow Up Edit.....");
			LogCreator.writeLog(logDir, "No Record found Exception for Red Flag Follow Up Edit.....", LogCreator.MESSAGE);
			setJsonResponse("error");
			response.getWriter().print(json_resp);
			return;
		} catch (ApkVersionMismatchException e) {			
			//log.error("Old apk version for Red Flag Follow Up Edit.....");
			LogCreator.writeLog(logDir, "Old apk version for Red Flag Follow Up Edit.....", LogCreator.MESSAGE);
			setJsonResponse("old_apk");
			response.getWriter().print(json_resp);
			return;
		} catch(JsonParseException ex) {
			//log.error("Json Parse exception for Red Flag Follow Up Edit",ex);
			LogCreator.writeLog(logDir, "Json Parse exception for Red Flag Follow Up Edit.....", LogCreator.MESSAGE);
			setJsonResponse("error_json");
			response.getWriter().print(json_resp);
			return;
		} catch(ParseException ex) {
			//log.error("Parse exception for Red Flag Follow Up Edit",ex);
			LogCreator.writeLog(logDir, "Parse exception for Red Flag Follow Up Edit.....", LogCreator.MESSAGE);
			setJsonResponse("error_parse");
			response.getWriter().print(json_resp);
			return;
		} catch(Exception ex) {
			//log.error("Exception for Red Flag Follow Up Edit",ex);
			LogCreator.writeLog(logDir, "Exception for Red Flag Follow Up Edit.....", LogCreator.MESSAGE);
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
		12. visit_dt	
		13. child_cd	
		14. child_age_mnth	
		15. follw_up_catg	
		16. child_wgt_kg	
		17. wgt_for_age	
		18. hgt_for_age	
		19. wgt_for_hgt	
		20. child_ref_hlth_faclty_yn	
		21. child_visit_hlth_faclty	
		22. visit_hlth_faclty_loc	
		23. visit_hlth_faclty_dt
		23. visit_hlth_faclty_dt_na	
		24. blood_test_done	
		25. hlth_chkup_rept	
		26. child_nvisit_hlth_faclty	
		27. child_nvisit_hlth_faclty_oth	
		28. child_ref_nrc_yn	
		29. child_ref_admit_yn	
		30. child_ref_nadmit	
		31. child_ref_nadmit_oth	
		32. users_nm					- Users Information
		33. submit_stat					- Submit Status
		34. chk							- Return True / False
		35. remarks 					- Edit Remarks
		*/
		
		String app_ver = null;
		String file_id = null;
		String obj_dt = null;
		String obj_time = null;
		String obj_imei = null;
		String hh_cd = null;
		String dt_cd = null;
		String bk_cd = null;
		String gp_cd = null;
		String vl_cd = null;
		String creche_cd = null;
		String visit_dt = null;	
		String child_cd	= null;
		String child_age_mnth = null;	
		String follw_up_catg = null;	
		String child_wgt_kg = null;	
		String wgt_for_age = null;	
		String hgt_for_age = null;	
		String wgt_for_hgt = null;	
		String child_ref_hlth_faclty_yn = null;	
		String child_visit_hlth_faclty = null;	
		String visit_hlth_faclty_loc = null;	
		String visit_hlth_faclty_dt = null;	
		String visit_hlth_faclty_dt_na = null;
		String blood_test_done = null;	
		String hlth_chkup_rept = null;	
		String child_nvisit_hlth_faclty = null;
		String child_nvisit_hlth_faclty_oth = null;	
		String child_ref_nrc_yn = null;	
		String child_ref_admit_yn = null;	
		String child_ref_nadmit = null;	
		String child_ref_nadmit_oth = null;	
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
		//log.info("Data for Red Flag Follow Up Edit : "+jsonLogData.toString());
		LogCreator.writeLog(logDir, "Data for Red Flag Follow Up Edit : "+jsonLogData.toString(), LogCreator.MESSAGE);
		//LogCreator.writeLog(logDir, "Data for Red Flag Follow Up Edit Image Information : "+jsonLogImageData.toString(), LogCreator.MESSAGE);
	
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
		visit_dt = jsonObjData.get("visit_dt").toString();	
		child_cd = jsonObjData.get("child_cd").toString();
		child_age_mnth = jsonObjData.get("child_age_mnth").toString();
		follw_up_catg = jsonObjData.get("follw_up_catg").toString();	
		child_wgt_kg = jsonObjData.get("child_wgt_kg").toString();
		wgt_for_age = jsonObjData.get("wgt_for_age").toString();
		hgt_for_age = jsonObjData.get("hgt_for_age").toString();
		wgt_for_hgt = jsonObjData.get("wgt_for_hgt").toString();	
		child_ref_hlth_faclty_yn = jsonObjData.get("child_ref_hlth_faclty_yn").toString();
		child_visit_hlth_faclty = jsonObjData.get("child_visit_hlth_faclty").toString();
		visit_hlth_faclty_loc = jsonObjData.get("visit_hlth_faclty_loc").toString();	
		visit_hlth_faclty_dt = jsonObjData.get("visit_hlth_faclty_dt").toString();
		visit_hlth_faclty_dt_na = jsonObjData.get("visit_hlth_faclty_dt_na").toString();
		blood_test_done = jsonObjData.get("blood_test_done").toString();
		hlth_chkup_rept = jsonObjData.get("hlth_chkup_rept").toString();
		child_nvisit_hlth_faclty = jsonObjData.get("child_nvisit_hlth_faclty").toString();
		child_nvisit_hlth_faclty_oth = jsonObjData.get("child_nvisit_hlth_faclty_oth").toString();	
		child_ref_nrc_yn = jsonObjData.get("child_ref_nrc_yn").toString();	
		child_ref_admit_yn = jsonObjData.get("child_ref_admit_yn").toString();	
		child_ref_nadmit = jsonObjData.get("child_ref_nadmit").toString();
		child_ref_nadmit_oth = jsonObjData.get("child_ref_nadmit_oth").toString();
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
		
		String mst_red_flag_sql = null;			
		mst_red_flag_sql = "CALL sp_di_child_redflag_edit("+
								Utility.checkVal(app_ver)+", "+
								Utility.checkVal(file_id)+", "+
								Utility.checkVal(date_time)+", "+
								Utility.checkVal(obj_imei)+", "+
								Utility.checkVal(dt_cd)+", "+
								Utility.checkVal(bk_cd)+", "+
								Utility.checkVal(gp_cd)+", "+
								Utility.checkVal(vl_cd)+", "+
								Utility.checkVal(creche_cd)+", "+
								Utility.checkVal(visit_dt)+", "+	
								Utility.checkVal(child_cd)+", "+
								Utility.checkVal(child_age_mnth)+", "+
								Utility.checkVal(follw_up_catg)+", "+
								Utility.checkVal(child_wgt_kg)+", "+
								Utility.checkVal(wgt_for_age)+", "+
								Utility.checkVal(hgt_for_age)+", "+
								Utility.checkVal(wgt_for_hgt)+", "+	
								Utility.checkVal(child_ref_hlth_faclty_yn)+", "+
								Utility.checkVal(child_visit_hlth_faclty)+", "+
								Utility.checkVal(visit_hlth_faclty_loc)+", "+	
								Utility.checkVal(visit_hlth_faclty_dt)+", "+
								Utility.checkVal(visit_hlth_faclty_dt_na)+", "+
								Utility.checkVal(blood_test_done)+", "+
								Utility.checkVal(hlth_chkup_rept)+", "+
								Utility.checkVal(child_nvisit_hlth_faclty)+", "+
								Utility.checkVal(child_nvisit_hlth_faclty_oth)+", "+
								Utility.checkVal(child_ref_nrc_yn)+", "+	
								Utility.checkVal(child_ref_admit_yn)+", "+
								Utility.checkVal(child_ref_nadmit)+", "+
								Utility.checkVal(child_ref_nadmit_oth)+", "+
								Utility.checkVal(users_nm)+", "+
								Utility.checkVal(submit_stat)+", "+
								Utility.checkVal(remarks)+", "+
								Utility.checkVal(com.rmspl.odisha.creche.utility.Utility.getCurrentDateTime())+", "+
								Utility.checkVal(chk)+")";
		
		lst_data = DataFetcher.getProcData(mst_red_flag_sql);
					
		if(lst_data.get(0)[0].equalsIgnoreCase("1")) {
			setJsonResponse("done");	
		} else if(lst_data.get(0)[0].equalsIgnoreCase("0")) {						
			setJsonResponse("no_user");
		} else if(lst_data.get(0)[0].equalsIgnoreCase("2")) {						
			setJsonResponse("no_child");
		} else {				
			//log.error("Error to upload Red Flag Follow Up Edit Data..."+file_id);
			LogCreator.writeLog(logDir, "Error to upload Red Flag Follow Up Edit Data..."+file_id, LogCreator.MESSAGE);
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

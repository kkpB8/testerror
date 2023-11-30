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
 * Servlet implementation class Creche Monitoring Checklist Form 2
 */
public class CrecheMonitoringChecklistForm2Edit extends HttpServlet {
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
	//private static Log log = LogFactory.getLog(CrecheMonitoringChecklist.class);
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
		logPath = getServletContext().getInitParameter("FilePath")+"/Log/Creche_Monitoring_Checklist/";
		logDir = new File(logPath);
		if(!logDir.isDirectory()) {
			Utility.createDirectory(new File(getServletContext().getInitParameter("FilePath")+"/Log/Creche_Monitoring_Checklist/"));
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
			//log.error("No Record found Exception for Creche Monitoring Checklist.....");
			LogCreator.writeLog(logDir, "No Record found Exception for Creche Monitoring Checklist.....", LogCreator.MESSAGE);
			setJsonResponse("error");
			response.getWriter().print(json_resp);
			return;
		} catch (ApkVersionMismatchException e) {			
			//log.error("Old apk version for Creche Monitoring Checklist.....");
			LogCreator.writeLog(logDir, "Old apk version for Creche Monitoring Checklist.....", LogCreator.MESSAGE);
			setJsonResponse("old_apk");
			response.getWriter().print(json_resp);
			return;
		} catch(JsonParseException ex) {
			//log.error("Json Parse exception for Creche Monitoring Checklist",ex);
			LogCreator.writeLog(logDir, "Json Parse exception for Creche Monitoring Checklist.....", LogCreator.MESSAGE);
			setJsonResponse("error_json");
			response.getWriter().print(json_resp);
			return;
		} catch(ParseException ex) {
			//log.error("Parse exception for Creche Monitoring Checklist",ex);
			LogCreator.writeLog(logDir, "Parse exception for Creche Monitoring Checklist.....", LogCreator.MESSAGE);
			setJsonResponse("error_parse");
			response.getWriter().print(json_resp);
			return;
		} catch(Exception ex) {
			ex.printStackTrace();
			//log.error("Exception for Creche Monitoring Checklist",ex);
			LogCreator.writeLog(logDir, "Exception for Creche Monitoring Checklist.....", LogCreator.MESSAGE);
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
		
		String visit_dt = null;
		String visit_tm = null;

		String nm_prof_vis = null;
		String pro_prof_vis = null;

		String cr_open_yn = null;
		String cr_open_yn_rsn = null;
		String p1_child_present_visit_tm_no = null;
		String p1_worker_present_visit_yn = null;
		String p1_addl_info = null;

		String p2_light_fixture_yn = null;
		String p2_fan_yn = null;
		String p2_toilet_yn = null;
		String p2_addl_info = null;

		String p3_essen_tngs = null;
		String p3_weigh_scl = null;
		String p3_stadiometer = null;
		String p3_infantometer_muac = null;
		String p3_main_tngs = null;
		String p3_addl_info = null;

		String p4_rec_reg = null;
		String p4_qual_iec = null;
		String p4_addl_info = null;

		String p5_cln_cr = null;
		String p5_food_cov_yn = null;
		String p5_per_hygn = null;
		String p5_addl_info = null;

		String p6_hygn_child = null;
		String p6_nail_cut = null;
		String p6_hand_wash_child = null;
		String p6_meal_prot = null;
		String p6_addl_info = null;
        
        String log_user = null;
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
		//log.info("Data for Creche Monitoring Checklist : "+jsonLogData.toString());
		LogCreator.writeLog(logDir, "Data for Creche Monitoring Checklist : "+jsonLogData.toString(), LogCreator.MESSAGE);
		//LogCreator.writeLog(logDir, "Data for Creche Monitoring Checklist Image Information : "+jsonLogImageData.toString(), LogCreator.MESSAGE);
	
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
		visit_tm = jsonObjData.get("visit_tm").toString();

		nm_prof_vis = jsonObjData.get("nm_prof_vis").toString();
		pro_prof_vis = jsonObjData.get("pro_prof_vis").toString();

		cr_open_yn = jsonObjData.get("cr_open_yn").toString();
		cr_open_yn_rsn = jsonObjData.get("cr_open_yn_rsn").toString();
		p1_child_present_visit_tm_no = jsonObjData.get("p1_child_present_visit_tm_no").toString();
		p1_worker_present_visit_yn = jsonObjData.get("p1_worker_present_visit_yn").toString();
		p1_addl_info = jsonObjData.get("p1_addl_info").toString();

		p2_light_fixture_yn = jsonObjData.get("p2_light_fixture_yn").toString();
		p2_fan_yn = jsonObjData.get("p2_fan_yn").toString();
		p2_toilet_yn = jsonObjData.get("p2_toilet_yn").toString();
		p2_addl_info = jsonObjData.get("p2_addl_info").toString();

		p3_essen_tngs = jsonObjData.get("p3_essen_tngs").toString();
		p3_weigh_scl = jsonObjData.get("p3_weigh_scl").toString();
		p3_stadiometer = jsonObjData.get("p3_stadiometer").toString();
		p3_infantometer_muac = jsonObjData.get("p3_infantometer_muac").toString();
		p3_main_tngs = jsonObjData.get("p3_main_tngs").toString();
		p3_addl_info = jsonObjData.get("p3_addl_info").toString();

		p4_rec_reg = jsonObjData.get("p4_rec_reg").toString();
		p4_qual_iec = jsonObjData.get("p4_qual_iec").toString();
		p4_addl_info = jsonObjData.get("p4_addl_info").toString();

		p5_cln_cr = jsonObjData.get("p5_cln_cr").toString();
		p5_food_cov_yn = jsonObjData.get("p5_food_cov_yn").toString();
		p5_per_hygn = jsonObjData.get("p5_per_hygn").toString();
		p5_addl_info = jsonObjData.get("p5_addl_info").toString();

		p6_hygn_child = jsonObjData.get("p6_hygn_child").toString();
		p6_nail_cut = jsonObjData.get("p6_nail_cut").toString();
		p6_hand_wash_child = jsonObjData.get("p6_hand_wash_child").toString();
		p6_meal_prot = jsonObjData.get("p6_meal_prot").toString();
		p6_addl_info = jsonObjData.get("p6_addl_info").toString();
		
        log_user = jsonObjData.get("log_user").toString();
		submit_stat = jsonObjData.get("submit_stat").toString();
		chk = jsonObjData.get("chk").toString();
		
		remarks = jsonObjData.get("remarks").toString();
		String date_time = obj_dt + " "+ obj_time.replaceAll("-", ":");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			LogCreator.writeLog(logDir, "Error to sleep..."+e.getLocalizedMessage(), LogCreator.ERROR);
		}
		String mst_creche_monitor_chklist_sql = null;			
		mst_creche_monitor_chklist_sql = "CALL sp_di_creche_monitor_chkliist_brief_edit("+
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
								Utility.checkVal(visit_tm)+", "+
								Utility.checkVal(nm_prof_vis)+", "+
								Utility.checkVal(pro_prof_vis)+", "+
								Utility.checkVal(cr_open_yn)+", "+
								Utility.checkVal(cr_open_yn_rsn)+", "+
								Utility.checkVal(p1_child_present_visit_tm_no)+", "+
								Utility.checkVal(p1_worker_present_visit_yn)+", "+
								Utility.checkVal(p1_addl_info)+", "+
								Utility.checkVal(p2_light_fixture_yn)+", "+
								Utility.checkVal(p2_fan_yn)+", "+
								Utility.checkVal(p2_toilet_yn)+", "+
								Utility.checkVal(p2_addl_info)+", "+
								Utility.checkVal(p3_essen_tngs)+", "+
								Utility.checkVal(p3_weigh_scl)+", "+
								Utility.checkVal(p3_stadiometer)+", "+
								Utility.checkVal(p3_infantometer_muac)+", "+
								Utility.checkVal(p3_main_tngs)+", "+
								Utility.checkVal(p3_addl_info)+", "+
								Utility.checkVal(p4_rec_reg)+", "+
								Utility.checkVal(p4_qual_iec)+", "+
								Utility.checkVal(p4_addl_info)+", "+
								Utility.checkVal(p5_cln_cr)+", "+
								Utility.checkVal(p5_food_cov_yn)+", "+
								Utility.checkVal(p5_per_hygn)+", "+
								Utility.checkVal(p5_addl_info)+", "+
								Utility.checkVal(p6_hygn_child)+", "+
								Utility.checkVal(p6_nail_cut)+", "+
								Utility.checkVal(p6_hand_wash_child)+", "+
								Utility.checkVal(p6_meal_prot)+", "+
								Utility.checkVal(p6_addl_info)+", "+
								Utility.checkVal(log_user)+", "+
								Utility.checkVal(submit_stat)+", "+
								Utility.checkVal(com.rmspl.odisha.creche.utility.Utility.getCurrentDateTime())+", "+
								Utility.checkVal(remarks)+")";
		
		lst_data = DataFetcher.getProcData(mst_creche_monitor_chklist_sql);
					
		if(lst_data.get(0)[0].equalsIgnoreCase("1")) {
			setJsonResponse("done");	
		} else if(lst_data.get(0)[0].equalsIgnoreCase("0")) {						
			setJsonResponse("no_user");
		} else if(lst_data.get(0)[0].equalsIgnoreCase("2")) {						
			setJsonResponse("no_child");
		} else {				
			//log.error("Error to upload Creche Monitoring Checklist Data..."+file_id);
			LogCreator.writeLog(logDir, "Error to upload Creche Monitoring Checklist Data..."+file_id, LogCreator.MESSAGE);
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

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
 * Servlet implementation class NRC Register
 */
public class NRCRegister extends HttpServlet {
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
		logPath = getServletContext().getInitParameter("FilePath")+"/Log/NRC_Register/";
		logDir = new File(logPath);
		if(!logDir.isDirectory()) {
			Utility.createDirectory(new File(getServletContext().getInitParameter("FilePath")+"/Log/NRC_Register/"));
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
			//log.error("No Record found Exception for NRC Register.....");
			LogCreator.writeLog(logDir, "No Record found Exception for NRC Register.....", LogCreator.MESSAGE);
			setJsonResponse("error");
			response.getWriter().print(json_resp);
			return;
		} catch (ApkVersionMismatchException e) {			
			//log.error("Old apk version for NRC Register.....");
			LogCreator.writeLog(logDir, "Old apk version for NRC Register.....", LogCreator.MESSAGE);
			setJsonResponse("old_apk");
			response.getWriter().print(json_resp);
			return;
		} catch(JsonParseException ex) {
			//log.error("Json Parse exception for NRC Register",ex);
			LogCreator.writeLog(logDir, "Json Parse exception for NRC Register.....", LogCreator.MESSAGE);
			setJsonResponse("error_json");
			response.getWriter().print(json_resp);
			return;
		} catch(ParseException ex) {
			//log.error("Parse exception for NRC Register",ex);
			LogCreator.writeLog(logDir, "Parse exception for NRC Register.....", LogCreator.MESSAGE);
			setJsonResponse("error_parse");
			response.getWriter().print(json_resp);
			return;
		} catch(Exception ex) {
			//log.error("Exception for NRC Register",ex);
			LogCreator.writeLog(logDir, "Exception for NRC Register.....", LogCreator.MESSAGE);
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
		12. report_dt					- Report date
			Page - 1
		13. p1_child_cd
		14. p1_child_dob
		15. p1_child_gen
		16. p1_child_age_mnth
		17. p1_ref_nrc_cause 
		18. p1_child_wgt_kg 
		19. p1_child_lngth_hgt_cm
		20. p1_child_muac_cm 
		21. p1_ref_dt 
			Page - 2
		22. p2_admission_dt 
		23. p2_admission_tm 
		24. p2_child_age_mnth_admin 
		25. p2_tick_follow 
		26. p2_ref_by 
		27. p2_appetite_test 
		28. p2_breastfeed_yn 
		29. p2_compl_food_yn 
		30. p2_compl_food_type 
		31. p2_child_wgt_kg 
		32. p2_child_wgt_kg_na 
		33. p2_child_lngth_hgt_cm 
		34. p2_child_lngth_hgt_cm_na 
		35. p2_child_muac_cm 
		36. p2_child_muac_cm_na 
		37. p2_wgt_for_age_val 
		38. p2_hgt_for_age_val 
		39. p2_wgt_for_hgt_val 
		40. p2_muac 
		41. p2_oedema 
			Page - 3
		42. p3_was_child = null;
		43. p3_stool_yn = null;
		44. p3_vomitting_yn = null;
		45. p3_dehydrated_yn = null;
		46. p3_cough_yn = null;
		47. p3_septic_shock_yn = null;
		48. p3_resp_rate = null;
		49. p3_pale_conj = null;
		50. p3_temp_am = null;
		51. p3_temp_pm = null;
		52. p3_liver_size = null;
			Page - 4
		53. p4_haemoglobin = null;
		54. p4_malaria_test = null;
		55. p4_tb_test = null;
		56. p4_blood_glucose = null;
		57. p4_stool_re = null;
		58. p4_stool_me = null;
		59. p4_hiv = null;
			Page - 5
		60. p5_discharge_dt = null;
		61. p5_child_wgt_kg = null;
		62. p5_child_wgt_kg_na = null;
		63. p5_child_lngth_hgt_cm = null;
		64. p5_child_lngth_hgt_cm_na = null;
		65. p5_child_muac_cm = null;
		66. p5_child_muac_cm_na = null;
		67. p5_wgt_for_age_val = null;
		68. p5_hgt_for_age_val = null;
		69. p5_wgt_for_hgt_val = null;
		70. p5_muac = null;
		71. p5_child_recv_200mg = null;
		72. p5_child_recv_400mg = null;
		73. p5_child_recv_suppl = null;
		74. p5_child_parent_recv_nutri_yn = null;
		75. p5_fam_recv_wages_yn = null;
		
		76.	log_user					- Users Information
		77.	submit_stat	 				- Submit Status		
		78.	chk							- Return True / False
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
		String report_dt = null;
		//Page - 1
		String p1_child_cd = null;
		String p1_child_dob = null;
		String p1_child_gen = null; 
		String p1_child_age_mnth = null;
		String p1_ref_nrc_cause = null;
		String p1_child_wgt_kg = null;
		String p1_child_lngth_hgt_cm = null;
		String p1_child_muac_cm = null;
		String p1_ref_dt = null;
		//Page - 2
		String p2_admission_dt = null;
		String p2_admission_tm = null;
		String p2_child_age_mnth_admin = null;
		String p2_tick_follow = null;
		String p2_ref_by = null;
		String p2_appetite_test = null;
		String p2_breastfeed_yn = null;
		String p2_compl_food_yn = null;
		String p2_compl_food_type = null;
		String p2_child_wgt_kg = null;
		String p2_child_wgt_kg_na = null;
		String p2_child_lngth_hgt_cm = null;
		String p2_child_lngth_hgt_cm_na = null;
		String p2_child_muac_cm = null;
		String p2_child_muac_cm_na = null;
		String p2_wgt_for_age_val = null;
		String p2_hgt_for_age_val = null;
		String p2_wgt_for_hgt_val = null;
		String p2_muac = null;
		String p2_oedema = null;
		//Page - 3
		String p3_was_child = null;
		String p3_stool_yn = null;
		String p3_vomitting_yn = null;
		String p3_dehydrated_yn = null;
		String p3_cough_yn = null;
		String p3_septic_shock_yn = null;
		String p3_resp_rate = null;
		String p3_pale_conj = null;
		String p3_temp_am = null;
		String p3_temp_pm = null;
		String p3_liver_size = null;
		//Page - 4
		String p4_haemoglobin = null;
		String p4_malaria_test = null;
		String p4_tb_test = null;
		String p4_blood_glucose = null;
		String p4_stool_re = null;
		String p4_stool_me = null;
		String p4_hiv = null;
		//Page - 5
		String p5_discharge_dt = null;
		String p5_child_wgt_kg = null;
		String p5_child_wgt_kg_na = null;
		String p5_child_lngth_hgt_cm = null;
		String p5_child_lngth_hgt_cm_na = null;
		String p5_child_muac_cm = null;
		String p5_child_muac_cm_na = null;
		String p5_wgt_for_age_val = null;
		String p5_hgt_for_age_val = null;
		String p5_wgt_for_hgt_val = null;
		String p5_muac = null;
		String p5_child_recv_200mg = null;
		String p5_child_recv_400mg = null;
		String p5_child_recv_suppl = null;
		String p5_child_parent_recv_nutri_yn = null;
		String p5_fam_recv_wages_yn = null;
		
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
		//log.info("Data for NRC Register : "+jsonLogData.toString());
		LogCreator.writeLog(logDir, "Data for NRC Register : "+jsonLogData.toString(), LogCreator.MESSAGE);
		//LogCreator.writeLog(logDir, "Data for NRC Register Image Information : "+jsonLogImageData.toString(), LogCreator.MESSAGE);
	
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
		report_dt = jsonObjData.get("report_dt").toString();
		//LogCreator.writeLog(logDir, "1...", LogCreator.MESSAGE);		
		p1_child_cd = jsonObjData.get("p1_child_cd").toString();
		p1_child_dob = jsonObjData.get("p1_child_dob").toString();
		p1_child_gen = jsonObjData.get("p1_child_gen").toString();
		p1_child_age_mnth = jsonObjData.get("p1_child_age_mnth").toString();
		p1_ref_nrc_cause = jsonObjData.get("p1_ref_nrc_cause").toString();
		p1_child_wgt_kg = jsonObjData.get("p1_child_wgt_kg").toString();
		p1_child_lngth_hgt_cm = jsonObjData.get("p1_child_lngth_hgt_cm").toString();
		p1_child_muac_cm = jsonObjData.get("p1_child_muac_cm").toString();
		p1_ref_dt = jsonObjData.get("p1_ref_dt").toString();
		p2_admission_dt = jsonObjData.get("p2_admission_dt").toString();
		p2_admission_tm = jsonObjData.get("p2_admission_tm").toString();
		p2_child_age_mnth_admin = jsonObjData.get("p2_child_age_mnth_admin").toString();
		p2_tick_follow = jsonObjData.get("p2_tick_follow").toString();
		p2_ref_by = jsonObjData.get("p2_ref_by").toString();
		p2_appetite_test = jsonObjData.get("p2_appetite_test").toString();
		p2_breastfeed_yn = jsonObjData.get("p2_breastfeed_yn").toString();
		p2_compl_food_yn = jsonObjData.get("p2_compl_food_yn").toString();
		p2_compl_food_type = jsonObjData.get("p2_compl_food_type").toString();
		p2_child_wgt_kg = jsonObjData.get("p2_child_wgt_kg").toString();
		p2_child_wgt_kg_na = jsonObjData.get("p2_child_wgt_kg_na").toString();
		p2_child_lngth_hgt_cm = jsonObjData.get("p2_child_lngth_hgt_cm").toString();
		p2_child_lngth_hgt_cm_na = jsonObjData.get("p2_child_lngth_hgt_cm_na").toString();
		p2_child_muac_cm = jsonObjData.get("p2_child_muac_cm").toString();
		p2_child_muac_cm_na = jsonObjData.get("p2_child_muac_cm_na").toString();
		p2_wgt_for_age_val = jsonObjData.get("p2_wgt_for_age_val").toString();
		p2_hgt_for_age_val = jsonObjData.get("p2_hgt_for_age_val").toString();
		p2_wgt_for_hgt_val = jsonObjData.get("p2_wgt_for_hgt_val").toString();
		p2_muac = jsonObjData.get("p2_muac").toString();
		p2_oedema = jsonObjData.get("p2_oedema").toString();		
		p3_was_child = jsonObjData.get("p3_was_child").toString();
		p3_stool_yn = jsonObjData.get("p3_stool_yn").toString();
		p3_vomitting_yn = jsonObjData.get("p3_vomitting_yn").toString();
		p3_dehydrated_yn = jsonObjData.get("p3_dehydrated_yn").toString();
		p3_cough_yn = jsonObjData.get("p3_cough_yn").toString();
		p3_septic_shock_yn = jsonObjData.get("p3_septic_shock_yn").toString();
		p3_resp_rate = jsonObjData.get("p3_resp_rate").toString();
		p3_pale_conj = jsonObjData.get("p3_pale_conj").toString();
		p3_temp_am = jsonObjData.get("p3_temp_am").toString();
		p3_temp_pm = jsonObjData.get("p3_temp_pm").toString();
		p3_liver_size = jsonObjData.get("p3_liver_size").toString();
		p4_haemoglobin = jsonObjData.get("p4_haemoglobin").toString();
		p4_malaria_test = jsonObjData.get("p4_malaria_test").toString();
		p4_tb_test = jsonObjData.get("p4_tb_test").toString();
		p4_blood_glucose = jsonObjData.get("p4_blood_glucose").toString();
		p4_stool_re = jsonObjData.get("p4_stool_re").toString();
		p4_stool_me = jsonObjData.get("p4_stool_me").toString();
		p4_hiv = jsonObjData.get("p4_hiv").toString();
		//LogCreator.writeLog(logDir, "6...", LogCreator.MESSAGE);
		p5_discharge_dt = jsonObjData.get("p5_discharge_dt").toString();
		p5_child_wgt_kg = jsonObjData.get("p5_child_wgt_kg").toString();
		p5_child_wgt_kg_na = jsonObjData.get("p5_child_wgt_kg_na").toString();
		p5_child_lngth_hgt_cm = jsonObjData.get("p5_child_lngth_hgt_cm").toString();
		p5_child_lngth_hgt_cm_na = jsonObjData.get("p5_child_lngth_hgt_cm_na").toString();
		p5_child_muac_cm = jsonObjData.get("p5_child_muac_cm").toString();
		p5_child_muac_cm_na = jsonObjData.get("p5_child_muac_cm_na").toString();
		p5_wgt_for_age_val = jsonObjData.get("p5_wgt_for_age_val").toString();
		p5_hgt_for_age_val = jsonObjData.get("p5_hgt_for_age_val").toString();
		p5_wgt_for_hgt_val = jsonObjData.get("p5_wgt_for_hgt_val").toString();
		p5_muac = jsonObjData.get("p5_muac").toString();
		p5_child_recv_200mg = jsonObjData.get("p5_child_recv_200mg").toString();
		p5_child_recv_400mg = jsonObjData.get("p5_child_recv_400mg").toString();
		p5_child_recv_suppl = jsonObjData.get("p5_child_recv_suppl").toString();
		p5_child_parent_recv_nutri_yn = jsonObjData.get("p5_child_parent_recv_nutri_yn").toString();
		p5_fam_recv_wages_yn = jsonObjData.get("p5_fam_recv_wages_yn").toString();
		log_user = jsonObjData.get("log_user").toString();
		submit_stat = jsonObjData.get("submit_stat").toString();		
		chk = jsonObjData.get("chk").toString();
		String date_time = obj_dt + " "+ obj_time.replaceAll("-", ":");
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			LogCreator.writeLog(logDir, "Error to sleep..."+e.getLocalizedMessage(), LogCreator.ERROR);
		}
		
		String mst_child_nrc_reg_sql = null;			
		mst_child_nrc_reg_sql = "CALL sp_di_child_nrc_reg("+
								Utility.checkVal(app_ver)+", "+
								Utility.checkVal(file_id)+", "+
								Utility.checkVal(date_time)+", "+
								Utility.checkVal(obj_imei)+", "+
								Utility.checkVal(dt_cd)+", "+
								Utility.checkVal(bk_cd)+", "+
								Utility.checkVal(gp_cd)+", "+
								Utility.checkVal(vl_cd)+", "+
								Utility.checkVal(creche_cd)+", "+
								Utility.checkVal(report_dt)+", "+
								Utility.checkVal(p1_child_cd)+", "+
								Utility.checkVal(p1_child_dob)+", "+
								Utility.checkVal(p1_child_gen)+", "+
								Utility.checkVal(p1_child_age_mnth)+", "+
								Utility.checkVal(p1_ref_nrc_cause)+", "+
								Utility.checkVal(p1_child_wgt_kg)+", "+
								Utility.checkVal(p1_child_lngth_hgt_cm)+", "+
								Utility.checkVal(p1_child_muac_cm)+", "+
								Utility.checkVal(p1_ref_dt)+", "+
								Utility.checkVal(p2_admission_dt)+", "+
								Utility.checkVal(p2_admission_tm)+", "+
								Utility.checkVal(p2_child_age_mnth_admin)+", "+
								Utility.checkVal(p2_tick_follow)+", "+
								Utility.checkVal(p2_ref_by)+", "+
								Utility.checkVal3(p2_appetite_test)+", "+
								Utility.checkVal3(p2_breastfeed_yn)+", "+
								Utility.checkVal3(p2_compl_food_yn)+", "+
								Utility.checkVal(p2_compl_food_type)+", "+
								Utility.checkVal(p2_child_wgt_kg)+", "+
								Utility.checkVal(p2_child_wgt_kg_na)+", "+
								Utility.checkVal(p2_child_lngth_hgt_cm)+", "+
								Utility.checkVal(p2_child_lngth_hgt_cm_na)+", "+
								Utility.checkVal(p2_child_muac_cm)+", "+
								Utility.checkVal(p2_child_muac_cm_na)+", "+
								Utility.checkVal(p2_wgt_for_age_val)+", "+
								//Utility.checkVal(p2_wgt_for_age)+", "+
								Utility.checkVal(p2_hgt_for_age_val)+", "+
								//Utility.checkVal(p2_hgt_for_age)+", "+
								Utility.checkVal(p2_wgt_for_hgt_val)+", "+
								//Utility.checkVal(p2_wgt_for_hgt)+", "+
								Utility.checkVal(p2_muac)+", "+
								Utility.checkVal(p2_oedema)+", "+
								Utility.checkVal3(p3_was_child)+", "+
								Utility.checkVal3(p3_stool_yn)+", "+
								Utility.checkVal3(p3_vomitting_yn)+", "+
								Utility.checkVal3(p3_dehydrated_yn)+", "+
								Utility.checkVal3(p3_cough_yn)+", "+
								Utility.checkVal3(p3_septic_shock_yn)+", "+
								Utility.checkVal(p3_resp_rate)+", "+
								Utility.checkVal3(p3_pale_conj)+", "+
								Utility.checkVal(p3_temp_am)+", "+
								Utility.checkVal(p3_temp_pm)+", "+
								Utility.checkVal(p3_liver_size)+", "+
								Utility.checkVal(p4_haemoglobin)+", "+
								Utility.checkVal3(p4_malaria_test)+", "+
								Utility.checkVal3(p4_tb_test)+", "+
								Utility.checkVal(p4_blood_glucose)+", "+
								Utility.checkVal(p4_stool_re)+", "+
								Utility.checkVal(p4_stool_me)+", "+
								Utility.checkVal3(p4_hiv)+", "+
								Utility.checkVal(p5_discharge_dt)+", "+
								Utility.checkVal(p5_child_wgt_kg)+", "+
								Utility.checkVal(p5_child_wgt_kg_na)+", "+
								Utility.checkVal(p5_child_lngth_hgt_cm)+", "+
								Utility.checkVal(p5_child_lngth_hgt_cm_na)+", "+
								Utility.checkVal(p5_child_muac_cm)+", "+
								Utility.checkVal(p5_child_muac_cm_na)+", "+
								Utility.checkVal(p5_wgt_for_age_val)+", "+								
								Utility.checkVal(p5_hgt_for_age_val)+", "+
								Utility.checkVal(p5_wgt_for_hgt_val)+", "+
								Utility.checkVal(p5_muac)+", "+
								Utility.checkVal3(p5_child_recv_200mg)+", "+
								Utility.checkVal3(p5_child_recv_400mg)+", "+
								Utility.checkVal(p5_child_recv_suppl)+", "+
								Utility.checkVal3(p5_child_parent_recv_nutri_yn)+", "+
								Utility.checkVal(p5_fam_recv_wages_yn)+", "+								
								Utility.checkVal(log_user)+", "+
								Utility.checkVal(submit_stat)+", "+
								Utility.checkVal(com.rmspl.odisha.creche.utility.Utility.getCurrentDateTime())+", "+
								Utility.checkVal(chk)+")";
		
		LogCreator.writeLog(logDir, "SQL for NRC Register : "+mst_child_nrc_reg_sql, LogCreator.MESSAGE);
		lst_data = DataFetcher.getProcData(mst_child_nrc_reg_sql);
		
					
		if(lst_data.get(0)[0].equalsIgnoreCase("1")) {
			setJsonResponse("done");	
		} else if(lst_data.get(0)[0].equalsIgnoreCase("0")) {						
			setJsonResponse("no_user");
		} else if(lst_data.get(0)[0].equalsIgnoreCase("2")) {						
			setJsonResponse("no_child");
		} else {				
			//log.error("Error to upload NRC Register Data..."+file_id);
			LogCreator.writeLog(logDir, "Error to upload NRC Register Data..."+file_id, LogCreator.MESSAGE);
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

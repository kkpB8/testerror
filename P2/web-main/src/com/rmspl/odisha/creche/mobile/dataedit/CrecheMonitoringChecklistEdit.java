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
 * Servlet implementation class Creche Monitoring Checklist Edit
 */
public class CrecheMonitoringChecklistEdit extends HttpServlet {
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
	//private static Log log = LogFactory.getLog(CrecheMonitoringChecklistEdit.class);
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
			//log.error("No Record found Exception for Creche Monitoring Checklist Edit.....");
			LogCreator.writeLog(logDir, "No Record found Exception for Creche Monitoring Checklist Edit.....", LogCreator.MESSAGE);
			setJsonResponse("error");
			response.getWriter().print(json_resp);
			return;
		} catch (ApkVersionMismatchException e) {			
			//log.error("Old apk version for Creche Monitoring Checklist Edit.....");
			LogCreator.writeLog(logDir, "Old apk version for Creche Monitoring Checklist Edit.....", LogCreator.MESSAGE);
			setJsonResponse("old_apk");
			response.getWriter().print(json_resp);
			return;
		} catch(JsonParseException ex) {
			//log.error("Json Parse exception for Creche Monitoring Checklist Edit",ex);
			LogCreator.writeLog(logDir, "Json Parse exception for Creche Monitoring Checklist Edit.....", LogCreator.MESSAGE);
			setJsonResponse("error_json");
			response.getWriter().print(json_resp);
			return;
		} catch(ParseException ex) {
			//log.error("Parse exception for Creche Monitoring Checklist Edit",ex);
			LogCreator.writeLog(logDir, "Parse exception for Creche Monitoring Checklist Edit.....", LogCreator.MESSAGE);
			setJsonResponse("error_parse");
			response.getWriter().print(json_resp);
			return;
		} catch(Exception ex) {
			ex.printStackTrace();
			LogCreator.writeLog(logDir, "Exception for Creche Monitoring Checklist Edit.....", LogCreator.MESSAGE);
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
        String visit_stm = null;
        String visit_etm = null;
        String p1_child_present_no = null;
        String p1_child_present_visit_tm_no = null;
        String p1_worker_present_visit_yn = null;

        String p2_light_fixture_yn = null;
        String p2_light_option = null;
        String p2_fan_yn = null;
        String p2_fan_option = null;
        String p2_window_yn = null;
        String p2_natural_light_yn = null;
        String p2_kitchen_seperate_yn = null;
        String p2_toilet_yn = null;

        String p3_smokeless_chulha_yn = null;
        String p3_smokeless_chulha_option = null;
        String p3_steel_box_yn = null;
        String p3_steel_box_option = null;
        String p3_first_aid_yn = null;
        String p3_first_aid_option = null;
        String p3_steel_drum_yn = null;
        String p3_steel_drum_option = null;
        String p3_ladle_drink_yn = null;
        String p3_ladle_drink_option = null;
        String p3_utensils_use_yn = null;
        String p3_utensils_use_option = null;
        String p3_measure_cup_oil_yn = null;
        String p3_measure_cup_oil_option = null;
        String p3_plastic_bucket_yn = null;
        String p3_plastic_bucket_option = null;
        String p3_plastic_mug_yn = null;
        String p3_plastic_mug_option = null;
        String p3_handwash_soap_case_yn = null;
        String p3_handwash_soap_case_option = null;
        String p3_nail_cutter_yn = null;
        String p3_nail_cutter_option = null;
        String p3_plastic_container_yn = null;
        String p3_plastic_container_option = null;
        String p3_dustbin_yn = null;
        String p3_dustbin_option = null;
        String p3_broom_dust_panel_yn = null;
        String p3_broom_dust_panel_option = null;
        String p3_toy_yn = null;
        String p3_toy_option = null;
        String p3_mosquito_net_yn = null;
        String p3_mosquito_net_option = null;
        String p3_durries_yn = null;
        String p3_durries_option = null;
        String p3_clock_yn = null;
        String p3_clock_option = null;
        String p3_towel_yn = null;
        String p3_towel_option = null;
        String p3_dishwash_soap_yn = null;
        String p3_dishwash_soap_option = null;
        String p3_handwash_station_yn = null;
        String p3_handwash_station_option = null;

        String p4_entrylvl_regs_yn = null;
        String p4_entrylvl_regs_option = null;
        String p4_attdn_regs_yn = null;
        String p4_attdn_regs_option = null;
        String p4_growth_chart_yn = null;
        String p4_growth_chart_option = null;
        String p4_redflag_flwup_form_yn = null;
        String p4_redflag_flwup_form_option = null;
        String p4_nrc_refrl_form_yn = null;
        String p4_nrc_refrl_form_option = null;
        String p4_stock_regs_yn = null;
        String p4_stock_regs_option = null;
        String p4_home_visit_qrs_yn = null;
        String p4_home_visit_qrs_option = null;
        String p4_daily_consmp_regs_yn = null;
        String p4_daily_consmp_regs_option = null;
        String p4_comm_growth_chart_disp_yn = null;
        String p4_comm_growth_chart_disp_option = null;
        String p4_attdn_calndr_disp_yn = null;
        String p4_attdn_calndr_disp_option = null;

        String p5_floor_cln_yn = null;
        String p5_trash_off_prop_yn = null;
        String p5_food_cover_stored_yn = null;
        String p5_leftover_disclrd_yn = null;
        String p5_dish_wash_after_meal_yn = null;
        String p5_dish_wash_after_meal_option = null;

        String p6_nail_cut_clean_yn = null;
        String p6_worker_washhand_cook_yn = null;
        String p6_worker_washhand_feed_yn = null;
        String p6_worker_washhand_toilet_yn = null;

        String p7_face_clean_yn = null;
        String p7_nail_cut_clean_yn = null;
        String p7_observ_worker_washhand_feed_yn = null;
        String p7_observ_worker_ch_washhand_feed_yn = null;
        String p7_observ_worker_ch_washhand_toilet_yn = null;

        String p8_drink_wat_boil_yn = null;
        String p8_menu_follow_meal_yn = null;

        String p9_weigh_scl_yn = null;
        String p9_weigh_scl_option = null;
        String p9_stadiometer_yn = null;
        String p9_stadiometer_option = null;
        String p9_infantometer_yn = null;
        String p9_infantometer_option = null;
        String p9_muac_type_yn = null;
        String p9_muac_type_option = null;
        
        String p10_gm_status = null;
        String p10_gm_val = null;
        String p10_gm_serv_recc_dt = null;
        String p10_gm_remarks = null;
        String p10_thr_status = null;
        String p10_thr_val = null;
        String p10_thr_serv_recc_dt = null;
        String p10_thr_remarks = null;
        String p10_immu_status = null;
        String p10_immu_val = null;
        String p10_immu_serv_recc_dt = null;
        String p10_immu_remarks = null;
        String p10_ifa_status = null;
        String p10_ifa_val = null;
        String p10_ifa_serv_recc_dt = null;
        String p10_ifa_remarks = null;
        String p10_vita_status = null;
        String p10_vita_val = null;
        String p10_vita_serv_recc_dt = null;
        String p10_vita_remarks = null;
        String p10_dew_status = null;
        String p10_dew_val = null;
        String p10_dew_serv_recc_dt = null;
        String p10_dew_remarks = null;
        
        String remarks = null;
        
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
		//log.info("Data for Creche Monitoring Checklist Edit : "+jsonLogData.toString());
		LogCreator.writeLog(logDir, "Data for Creche Monitoring Checklist Edit : "+jsonLogData.toString(), LogCreator.MESSAGE);
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
        visit_stm = jsonObjData.get("visit_stm").toString();
        visit_etm = jsonObjData.get("visit_etm").toString();
        p1_child_present_no = jsonObjData.get("p1_child_present_no").toString();
        p1_child_present_visit_tm_no = jsonObjData.get("p1_child_present_visit_tm_no").toString();
        p1_worker_present_visit_yn = jsonObjData.get("p1_worker_present_visit_yn").toString();

        p2_light_fixture_yn = jsonObjData.get("p2_light_fixture_yn").toString();
        p2_light_option = jsonObjData.get("p2_light_option").toString();
        p2_fan_yn = jsonObjData.get("p2_fan_yn").toString();
        p2_fan_option = jsonObjData.get("p2_fan_option").toString();
        p2_window_yn = jsonObjData.get("p2_window_yn").toString();        
        p2_natural_light_yn = jsonObjData.get("p2_natural_light_yn").toString();
        p2_kitchen_seperate_yn = jsonObjData.get("p2_kitchen_seperate_yn").toString();
        p2_toilet_yn = jsonObjData.get("p2_toilet_yn").toString();

        p3_smokeless_chulha_yn = jsonObjData.get("p3_smokeless_chulha_yn").toString();
        p3_smokeless_chulha_option = jsonObjData.get("p3_smokeless_chulha_option").toString();
        p3_steel_box_yn = jsonObjData.get("p3_steel_box_yn").toString();
        p3_steel_box_option = jsonObjData.get("p3_steel_box_option").toString();
        p3_first_aid_yn = jsonObjData.get("p3_first_aid_yn").toString();
        p3_first_aid_option = jsonObjData.get("p3_first_aid_option").toString();
        p3_steel_drum_yn = jsonObjData.get("p3_steel_drum_yn").toString();
        p3_steel_drum_option = jsonObjData.get("p3_steel_drum_option").toString();
        p3_ladle_drink_yn = jsonObjData.get("p3_ladle_drink_yn").toString();
        p3_ladle_drink_option = jsonObjData.get("p3_ladle_drink_option").toString();
        p3_utensils_use_yn = jsonObjData.get("p3_utensils_use_yn").toString();
        p3_utensils_use_option = jsonObjData.get("p3_utensils_use_option").toString();
        p3_measure_cup_oil_yn = jsonObjData.get("p3_measure_cup_oil_yn").toString();
        p3_measure_cup_oil_option = jsonObjData.get("p3_measure_cup_oil_option").toString();
        p3_plastic_bucket_yn = jsonObjData.get("p3_plastic_bucket_yn").toString();
        p3_plastic_bucket_option = jsonObjData.get("p3_plastic_bucket_option").toString();
        p3_plastic_mug_yn = jsonObjData.get("p3_plastic_mug_yn").toString();
        p3_plastic_mug_option = jsonObjData.get("p3_plastic_mug_option").toString();
        p3_handwash_soap_case_yn = jsonObjData.get("p3_handwash_soap_case_yn").toString();
        p3_handwash_soap_case_option = jsonObjData.get("p3_handwash_soap_case_option").toString();
        p3_nail_cutter_yn = jsonObjData.get("p3_nail_cutter_yn").toString();
        p3_nail_cutter_option = jsonObjData.get("p3_nail_cutter_option").toString();
        p3_plastic_container_yn = jsonObjData.get("p3_plastic_container_yn").toString();
        p3_plastic_container_option = jsonObjData.get("p3_plastic_container_option").toString();
        p3_dustbin_yn = jsonObjData.get("p3_dustbin_yn").toString();
        p3_dustbin_option = jsonObjData.get("p3_dustbin_option").toString();
        p3_broom_dust_panel_yn = jsonObjData.get("p3_broom_dust_panel_yn").toString();
        p3_broom_dust_panel_option = jsonObjData.get("p3_broom_dust_panel_option").toString();
        p3_toy_yn = jsonObjData.get("p3_toy_yn").toString();
        p3_toy_option = jsonObjData.get("p3_toy_option").toString();
        p3_mosquito_net_yn = jsonObjData.get("p3_mosquito_net_yn").toString();
        p3_mosquito_net_option = jsonObjData.get("p3_mosquito_net_option").toString();
        p3_durries_yn = jsonObjData.get("p3_durries_yn").toString();
        p3_durries_option = jsonObjData.get("p3_durries_option").toString();
        p3_clock_yn = jsonObjData.get("p3_clock_yn").toString();
        p3_clock_option = jsonObjData.get("p3_clock_option").toString();
        p3_towel_yn = jsonObjData.get("p3_towel_yn").toString();
        p3_towel_option = jsonObjData.get("p3_towel_option").toString();
        p3_dishwash_soap_yn = jsonObjData.get("p3_dishwash_soap_yn").toString();
        p3_dishwash_soap_option = jsonObjData.get("p3_dishwash_soap_option").toString();
        p3_handwash_station_yn = jsonObjData.get("p3_handwash_station_yn").toString();
        p3_handwash_station_option = jsonObjData.get("p3_handwash_station_option").toString();

        p4_entrylvl_regs_yn = jsonObjData.get("p4_entrylvl_regs_yn").toString();
        p4_entrylvl_regs_option = jsonObjData.get("p4_entrylvl_regs_option").toString();
        p4_attdn_regs_yn = jsonObjData.get("p4_attdn_regs_yn").toString();
        p4_attdn_regs_option = jsonObjData.get("p4_attdn_regs_option").toString();
        p4_growth_chart_yn = jsonObjData.get("p4_growth_chart_yn").toString();
        p4_growth_chart_option = jsonObjData.get("p4_growth_chart_option").toString();
        p4_redflag_flwup_form_yn = jsonObjData.get("p4_redflag_flwup_form_yn").toString();
        p4_redflag_flwup_form_option = jsonObjData.get("p4_redflag_flwup_form_option").toString();
        p4_nrc_refrl_form_yn = jsonObjData.get("p4_nrc_refrl_form_yn").toString();
        p4_nrc_refrl_form_option = jsonObjData.get("p4_nrc_refrl_form_option").toString();
        p4_stock_regs_yn = jsonObjData.get("p4_stock_regs_yn").toString();
        p4_stock_regs_option = jsonObjData.get("p4_stock_regs_option").toString();
        p4_home_visit_qrs_yn = jsonObjData.get("p4_home_visit_qrs_yn").toString();
        p4_home_visit_qrs_option = jsonObjData.get("p4_home_visit_qrs_option").toString();
        p4_daily_consmp_regs_yn = jsonObjData.get("p4_daily_consmp_regs_yn").toString();
        p4_daily_consmp_regs_option = jsonObjData.get("p4_daily_consmp_regs_option").toString();
        p4_comm_growth_chart_disp_yn = jsonObjData.get("p4_comm_growth_chart_disp_yn").toString();
        p4_comm_growth_chart_disp_option = jsonObjData.get("p4_comm_growth_chart_disp_option").toString();
        p4_attdn_calndr_disp_yn = jsonObjData.get("p4_attdn_calndr_disp_yn").toString();
        p4_attdn_calndr_disp_option = jsonObjData.get("p4_attdn_calndr_disp_option").toString();

        p5_floor_cln_yn = jsonObjData.get("p5_floor_cln_yn").toString();
        p5_trash_off_prop_yn = jsonObjData.get("p5_trash_off_prop_yn").toString();
        p5_food_cover_stored_yn = jsonObjData.get("p5_food_cover_stored_yn").toString();
        p5_leftover_disclrd_yn = jsonObjData.get("p5_leftover_disclrd_yn").toString();
        p5_dish_wash_after_meal_yn = jsonObjData.get("p5_dish_wash_after_meal_yn").toString();
        p5_dish_wash_after_meal_option = jsonObjData.get("p5_dish_wash_after_meal_option").toString();

        p6_nail_cut_clean_yn = jsonObjData.get("p6_nail_cut_clean_yn").toString();
        p6_worker_washhand_cook_yn = jsonObjData.get("p6_worker_washhand_cook_yn").toString();
        p6_worker_washhand_feed_yn = jsonObjData.get("p6_worker_washhand_feed_yn").toString();
        p6_worker_washhand_toilet_yn = jsonObjData.get("p6_worker_washhand_toilet_yn").toString();

        p7_face_clean_yn = jsonObjData.get("p7_face_clean_yn").toString();
        p7_nail_cut_clean_yn = jsonObjData.get("p7_nail_cut_clean_yn").toString();
        p7_observ_worker_washhand_feed_yn = jsonObjData.get("p7_observ_worker_washhand_feed_yn").toString();
        p7_observ_worker_ch_washhand_feed_yn = jsonObjData.get("p7_observ_worker_ch_washhand_feed_yn").toString();
        p7_observ_worker_ch_washhand_toilet_yn = jsonObjData.get("p7_observ_worker_ch_washhand_toilet_yn").toString();

        p8_drink_wat_boil_yn = jsonObjData.get("p8_drink_wat_boil_yn").toString();
        p8_menu_follow_meal_yn = jsonObjData.get("p8_menu_follow_meal_yn").toString();

        p9_weigh_scl_yn = jsonObjData.get("p9_weigh_scl_yn").toString();
        p9_weigh_scl_option = jsonObjData.get("p9_weigh_scl_option").toString();
        p9_stadiometer_yn = jsonObjData.get("p9_stadiometer_yn").toString();
        p9_stadiometer_option = jsonObjData.get("p9_stadiometer_option").toString();
        p9_infantometer_yn = jsonObjData.get("p9_infantometer_yn").toString();
        p9_infantometer_option = jsonObjData.get("p9_infantometer_option").toString();
        p9_muac_type_yn = jsonObjData.get("p9_muac_type_yn").toString();
        p9_muac_type_option = jsonObjData.get("p9_muac_type_option").toString();
        
        p10_gm_status = jsonObjData.get("p10_gm_status").toString();
        p10_gm_val = jsonObjData.get("p10_gm_val").toString();
        p10_gm_serv_recc_dt = jsonObjData.get("p10_gm_serv_recc_dt").toString();
        p10_gm_remarks = jsonObjData.get("p10_gm_remarks").toString();
        p10_thr_status = jsonObjData.get("p10_thr_status").toString();
        p10_thr_val = jsonObjData.get("p10_thr_val").toString();
        p10_thr_serv_recc_dt = jsonObjData.get("p10_thr_serv_recc_dt").toString();
        p10_thr_remarks = jsonObjData.get("p10_thr_remarks").toString();
        p10_immu_status = jsonObjData.get("p10_immu_status").toString();
        p10_immu_val = jsonObjData.get("p10_immu_val").toString();
        p10_immu_serv_recc_dt = jsonObjData.get("p10_immu_serv_recc_dt").toString();
        p10_immu_remarks = jsonObjData.get("p10_immu_remarks").toString();
        p10_ifa_status = jsonObjData.get("p10_ifa_status").toString();
        p10_ifa_val = jsonObjData.get("p10_ifa_val").toString();
        p10_ifa_serv_recc_dt = jsonObjData.get("p10_ifa_serv_recc_dt").toString();
        p10_ifa_remarks = jsonObjData.get("p10_ifa_remarks").toString();
        p10_vita_status = jsonObjData.get("p10_vita_status").toString();
        p10_vita_val = jsonObjData.get("p10_vita_val").toString();
        p10_vita_serv_recc_dt = jsonObjData.get("p10_vita_serv_recc_dt").toString();
        p10_vita_remarks = jsonObjData.get("p10_vita_remarks").toString();
        p10_dew_status = jsonObjData.get("p10_dew_status").toString();
        p10_dew_val = jsonObjData.get("p10_dew_val").toString();
        p10_dew_serv_recc_dt = jsonObjData.get("p10_dew_serv_recc_dt").toString();
        p10_dew_remarks = jsonObjData.get("p10_dew_remarks").toString();
        
        remarks = jsonObjData.get("remarks").toString();
        log_user = jsonObjData.get("log_user").toString();
		submit_stat = jsonObjData.get("submit_stat").toString();
		chk = jsonObjData.get("chk").toString();
		String date_time = obj_dt + " "+ obj_time.replaceAll("-", ":");
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			LogCreator.writeLog(logDir, "Error to sleep..."+e.getLocalizedMessage(), LogCreator.ERROR);
		}
		
		String mst_creche_monitor_chklist_sql = null;			
		mst_creche_monitor_chklist_sql = "CALL sp_di_creche_monitor_chkliist_edit("+
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
								Utility.checkVal(visit_stm)+", "+
								Utility.checkVal(visit_etm)+", "+
								Utility.checkVal(p1_child_present_no)+", "+
								Utility.checkVal(p1_child_present_visit_tm_no)+", "+
								Utility.checkVal(p1_worker_present_visit_yn)+", "+
								Utility.checkVal(p2_light_fixture_yn)+", "+
								Utility.checkVal(p2_light_option)+", "+
								Utility.checkVal(p2_fan_yn)+", "+
								Utility.checkVal(p2_fan_option)+", "+
								Utility.checkVal(p2_window_yn)+", "+
								Utility.checkVal(p2_natural_light_yn)+", "+
								Utility.checkVal(p2_kitchen_seperate_yn)+", "+
								Utility.checkVal(p2_toilet_yn)+", "+
								Utility.checkVal(p3_smokeless_chulha_yn)+", "+
								Utility.checkVal(p3_smokeless_chulha_option)+", "+
								Utility.checkVal(p3_steel_box_yn)+", "+
								Utility.checkVal(p3_steel_box_option)+", "+
								Utility.checkVal(p3_first_aid_yn)+", "+
								Utility.checkVal(p3_first_aid_option)+", "+
								Utility.checkVal(p3_steel_drum_yn)+", "+
								Utility.checkVal(p3_steel_drum_option)+", "+
								Utility.checkVal(p3_ladle_drink_yn)+", "+
								Utility.checkVal(p3_ladle_drink_option)+", "+
								Utility.checkVal(p3_utensils_use_yn)+", "+
								Utility.checkVal(p3_utensils_use_option)+", "+
								Utility.checkVal(p3_measure_cup_oil_yn)+", "+
								Utility.checkVal(p3_measure_cup_oil_option)+", "+
								Utility.checkVal(p3_plastic_bucket_yn)+", "+
								Utility.checkVal(p3_plastic_bucket_option)+", "+
								Utility.checkVal(p3_plastic_mug_yn)+", "+
								Utility.checkVal(p3_plastic_mug_option)+", "+
								Utility.checkVal(p3_handwash_soap_case_yn)+", "+
								Utility.checkVal(p3_handwash_soap_case_option)+", "+
								Utility.checkVal(p3_nail_cutter_yn)+", "+
								Utility.checkVal(p3_nail_cutter_option)+", "+
								Utility.checkVal(p3_plastic_container_yn)+", "+
								Utility.checkVal(p3_plastic_container_option)+", "+
								Utility.checkVal(p3_dustbin_yn)+", "+
								Utility.checkVal(p3_dustbin_option)+", "+
								Utility.checkVal(p3_broom_dust_panel_yn)+", "+
								Utility.checkVal(p3_broom_dust_panel_option)+", "+
								Utility.checkVal(p3_toy_yn)+", "+
								Utility.checkVal(p3_toy_option)+", "+
								Utility.checkVal(p3_mosquito_net_yn)+", "+
								Utility.checkVal(p3_mosquito_net_option)+", "+
								Utility.checkVal(p3_durries_yn)+", "+
								Utility.checkVal(p3_durries_option)+", "+
								Utility.checkVal(p3_clock_yn)+", "+
								Utility.checkVal(p3_clock_option)+", "+
								Utility.checkVal(p3_towel_yn)+", "+
								Utility.checkVal(p3_towel_option)+", "+
								Utility.checkVal(p3_dishwash_soap_yn)+", "+
								Utility.checkVal(p3_dishwash_soap_option)+", "+
								Utility.checkVal(p3_handwash_station_yn)+", "+
								Utility.checkVal(p3_handwash_station_option)+", "+
								Utility.checkVal(p4_entrylvl_regs_yn)+", "+
								Utility.checkVal(p4_entrylvl_regs_option)+", "+
								Utility.checkVal(p4_attdn_regs_yn)+", "+
								Utility.checkVal(p4_attdn_regs_option)+", "+
								Utility.checkVal(p4_growth_chart_yn)+", "+
								Utility.checkVal(p4_growth_chart_option)+", "+
								Utility.checkVal(p4_redflag_flwup_form_yn)+", "+
								Utility.checkVal(p4_redflag_flwup_form_option)+", "+
								Utility.checkVal(p4_nrc_refrl_form_yn)+", "+
								Utility.checkVal(p4_nrc_refrl_form_option)+", "+
								Utility.checkVal(p4_stock_regs_yn)+", "+
								Utility.checkVal(p4_stock_regs_option)+", "+
								Utility.checkVal(p4_home_visit_qrs_yn)+", "+
								Utility.checkVal(p4_home_visit_qrs_option)+", "+
								Utility.checkVal(p4_daily_consmp_regs_yn)+", "+
								Utility.checkVal(p4_daily_consmp_regs_option)+", "+
								Utility.checkVal(p4_comm_growth_chart_disp_yn)+", "+
								Utility.checkVal(p4_comm_growth_chart_disp_option)+", "+
								Utility.checkVal(p4_attdn_calndr_disp_yn)+", "+
								Utility.checkVal(p4_attdn_calndr_disp_option)+", "+
								Utility.checkVal(p5_floor_cln_yn)+", "+
								Utility.checkVal(p5_trash_off_prop_yn)+", "+
								Utility.checkVal(p5_food_cover_stored_yn)+", "+
								Utility.checkVal(p5_leftover_disclrd_yn)+", "+
								Utility.checkVal(p5_dish_wash_after_meal_yn)+", "+
								Utility.checkVal(p5_dish_wash_after_meal_option)+", "+
								Utility.checkVal(p6_nail_cut_clean_yn)+", "+
								Utility.checkVal(p6_worker_washhand_cook_yn)+", "+
								Utility.checkVal(p6_worker_washhand_feed_yn)+", "+
								Utility.checkVal(p6_worker_washhand_toilet_yn)+", "+
								Utility.checkVal(p7_face_clean_yn)+", "+
								Utility.checkVal(p7_nail_cut_clean_yn)+", "+
								Utility.checkVal(p7_observ_worker_washhand_feed_yn)+", "+
								Utility.checkVal(p7_observ_worker_ch_washhand_feed_yn)+", "+
								Utility.checkVal(p7_observ_worker_ch_washhand_toilet_yn)+", "+
								Utility.checkVal(p8_drink_wat_boil_yn)+", "+
								Utility.checkVal(p8_menu_follow_meal_yn)+", "+
								Utility.checkVal(p9_weigh_scl_yn)+", "+
								Utility.checkVal(p9_weigh_scl_option)+", "+
								Utility.checkVal(p9_stadiometer_yn)+", "+
								Utility.checkVal(p9_stadiometer_option)+", "+
								Utility.checkVal(p9_infantometer_yn)+", "+
								Utility.checkVal(p9_infantometer_option)+", "+
								Utility.checkVal(p9_muac_type_yn)+", "+
								Utility.checkVal(p9_muac_type_option)+", "+
								Utility.checkVal(p10_gm_status)+", "+
								Utility.checkVal(p10_gm_val)+", "+
								Utility.checkVal(p10_gm_serv_recc_dt)+", "+
								Utility.checkVal(p10_gm_remarks)+", "+
								Utility.checkVal(p10_thr_status)+", "+
								Utility.checkVal(p10_thr_val)+", "+
								Utility.checkVal(p10_thr_serv_recc_dt)+", "+
								Utility.checkVal(p10_thr_remarks)+", "+
								Utility.checkVal(p10_immu_status)+", "+
								Utility.checkVal(p10_immu_val)+", "+
								Utility.checkVal(p10_immu_serv_recc_dt)+", "+
								Utility.checkVal(p10_immu_remarks)+", "+
								Utility.checkVal(p10_ifa_status)+", "+
								Utility.checkVal(p10_ifa_val)+", "+
								Utility.checkVal(p10_ifa_serv_recc_dt)+", "+
								Utility.checkVal(p10_ifa_remarks)+", "+
								Utility.checkVal(p10_vita_status)+", "+
								Utility.checkVal(p10_vita_val)+", "+
								Utility.checkVal(p10_vita_serv_recc_dt)+", "+
								Utility.checkVal(p10_vita_remarks)+", "+
								Utility.checkVal(p10_dew_status)+", "+
								Utility.checkVal(p10_dew_val)+", "+
								Utility.checkVal(p10_dew_serv_recc_dt)+", "+
								Utility.checkVal(p10_dew_remarks)+", "+
								Utility.checkVal(log_user)+", "+
								Utility.checkVal(submit_stat)+", "+
								Utility.checkVal(remarks)+", "+
								Utility.checkVal(com.rmspl.odisha.creche.utility.Utility.getCurrentDateTime())+", "+
								Utility.checkVal(chk)+")";
		
		lst_data = DataFetcher.getProcData(mst_creche_monitor_chklist_sql);
					
		if(lst_data.get(0)[0].equalsIgnoreCase("1")) {
			setJsonResponse("done");	
		} else if(lst_data.get(0)[0].equalsIgnoreCase("0")) {						
			setJsonResponse("no_user");
		} else if(lst_data.get(0)[0].equalsIgnoreCase("2")) {						
			setJsonResponse("no_child");
		} else {				
			//log.error("Error to upload Creche Monitoring Checklist Data Edit..."+file_id);
			LogCreator.writeLog(logDir, "Error to upload Creche Monitoring Checklist Data Edit..."+file_id, LogCreator.MESSAGE);
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

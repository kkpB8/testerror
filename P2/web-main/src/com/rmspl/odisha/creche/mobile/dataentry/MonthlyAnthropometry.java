package com.rmspl.odisha.creche.mobile.dataentry;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
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
import com.rmspl.odisha.creche.utility.Base64ToImage;

/**
 * Servlet implementation class Monthly Anthropometry
 */
public class MonthlyAnthropometry extends HttpServlet {
	/**
	 * version identifier for a Serializable class
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * path of temporary directory
	 */
	private static final String TMP_DIR_PATH = FileUtils.getTempDirectoryPath();
	/**
	 * temporary director to confirm whether path exists or not
	 */
	private File tmpDir;
	/**
	 * Write log
	 */
	//private static Log log = LogFactory.getLog(MonthlyAnthropometry.class);
	/**
	 * directory for uploaded files
	 */
	private File destinationDir;
	/**
	 * Actual path for Image files
	 */
	private String imagePath;
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
		tmpDir = new File(TMP_DIR_PATH);
		
		if(!tmpDir.isDirectory()) {
			throw new ServletException(TMP_DIR_PATH + " is not a directory");
		}
		imagePath = getServletContext().getInitParameter("FilePath");
		destinationDir = new File(imagePath);
		if(!destinationDir.isDirectory()) {
			Utility.createDirectory(new File(imagePath));
		}
		/*logPath = getServletContext().getInitParameter("FilePath")+"/Log/";
		logDir = new File(logPath);
		if(!logDir.isDirectory()) {
			Utility.createDirectory(new File(getServletContext().getInitParameter("FilePath")+"/Log/"));
		}*/
		logPath = getServletContext().getInitParameter("FilePath")+"/Log/Monthly_Anthropometry/";
		logDir = new File(logPath);
		if(!logDir.isDirectory()) {
			Utility.createDirectory(new File(getServletContext().getInitParameter("FilePath")+"/Log/Monthly_Anthropometry/"));
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
			//log.error("No Record found Exception for Monthly Anthropometry.....");
			LogCreator.writeLog(logDir, "No Record found Exception for Monthly Anthropometry.....", LogCreator.MESSAGE);
			setJsonResponse("error");
			response.getWriter().print(json_resp);
			return;
		} catch (ApkVersionMismatchException e) {			
			//log.error("Old apk version for Monthly Anthropometry.....");
			LogCreator.writeLog(logDir, "Old apk version for Monthly Anthropometry.....", LogCreator.MESSAGE);
			setJsonResponse("old_apk");
			response.getWriter().print(json_resp);
			return;
		} catch(JsonParseException ex) {
			//log.error("Json Parse exception for Monthly Anthropometry",ex);
			LogCreator.writeLog(logDir, "Json Parse exception for Monthly Anthropometry.....", LogCreator.MESSAGE);
			setJsonResponse("error_json");
			response.getWriter().print(json_resp);
			return;
		} catch(ParseException ex) {
			//log.error("Parse exception for Monthly Anthropometry",ex);
			LogCreator.writeLog(logDir, "Parse exception for Monthly Anthropometry.....", LogCreator.MESSAGE);
			setJsonResponse("error_parse");
			response.getWriter().print(json_resp);
			return;
		} catch(IOException ex) {
			//log.error("Input Output exception for Monthly Anthropometry",ex);
			LogCreator.writeLog(logDir, "Input Output exception for Monthly Anthropometry.....", LogCreator.MESSAGE);
			setJsonResponse("error_io");
			response.getWriter().print(json_resp);
			return;
		} catch(Exception ex) {
			//log.error("Exception for Monthly Anthropometry",ex);
			LogCreator.writeLog(logDir, "Exception for Monthly Anthropometry.....", LogCreator.MESSAGE);
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
	 * @throws IOException 
	 * @throws ParseException 
	 */
	private void processData(HttpServletResponse response, String data) throws NoRecordFoundException, ApkVersionMismatchException, JsonParseException, IOException, ParseException {
		/*
		1.	app_ver	                                    - Application Version																							
		2.	file_id									    - File Id																							
		3.	obj_dt									    - Object Date & Time	
		3.	obj_time 									- Object Date & Time																								
		4.	obj_imei 									- Object IMEI																							
		5.	dt_cd 										- District																							
		6.	bk_cd 										- Block																							
		7.	gp_cd										- GP																							
		8.	vl_cd										- Village																							
		9.	creche_cd									- Creche Code																							
		10.	mnth_yr										- Month-Year																							
		11.	anthro_dt									- Date																							
		12.	child_cd									- Child Code																							
		13.	addmis_dt									- Date of Addmission																							
		14.	child_age_mnth								- Child Age in Month																							
		15.	current_bf_yn								- Currently Breastfeeding?																							
		16.	child_disable_yn							- Does the child have any disability																							
		17.	child_disable_nm							- If,Yes,Name the disability																							
		18.	child_disable_oth							- If,Yes,Name the disability (Other)																							
		19.	child_longterm_ill_yn						- Does the child have any long term illness																							
		20.	child_longterm_ill_nm						- If,Yes,then specify the illness																							
		21.	child_longterm_ill_oth						- If,Yes,then specify the illness (Other)																							
		22.	mem_longterm_ill_yn							- Any long-term illness in any of the family member(for more than one year)?																							
		23.	mem_longterm_ill_nm							- If,Yes,then specify the illness																							
		24.	mem_longterm_ill_oth						- If,Yes,then specify the illness (Other)																							
		25.	remarks										- Remarks																							
		26.	child_age_mnth_ex							- Child Age in Month																							
		27.	child_wgt_kg_ex								- Child Weight in Kg.																							
		28.	child_wgt_na								- Child Weight in Kg. (Not Available)																							
		29.	mother_occu									- Mother Occupation																							
		30.	mother_occu_oth								- Mother Occupation (Other)																							
		31.	child_lngth_hgt_cm							- Child Length / Height in cm.																							
		32.	child_lngth_hgt_na							- Child Length / Height in cm. (Not Available)																							
		33.	instr_use									- Instrument Used																							
		34.	child_muac_cm								- Child MUAC in cm.																							
		35.	child_muac_na								- Child MUAC in cm. (Not Available)																							
		36.	reason_anthro_ntaken						- Reason for anthropometry not being taken																							
		37.	reason_any_illness							- Any illness(if the child is ill at the time of anthropometry)?		
		37.	reason_any_illness_other					- Other illness(if the child is ill at the time of anthropometry)?																							
		38.	red_flag_chk								- Check for Red Flag																							
		39.	red_flag_catg								- Red Flag Categories																							
		40.	users_nm									- Users Information																							
		41.	submit_stat									- Submit Status	"ps" / "fs"																						
		42.	chk											- Return True / False																							
		43.	wgt_for_age									- Weight for Age																							
		44.	hgt_for_age									- Height for Age																							
		45.	wgt_for_hgt									- Weight for Height																							
		46.	muac										- MUAC			
		47. child_stat									- Child Status																				
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
		String anthro_dt = null;
		String child_cd = null;
		String addmis_dt = null;
		String child_age_mnth = null;
		String current_bf_yn = null;
		String child_disable_yn = null;
		String child_disable_nm = null;
		String child_disable_oth = null;
		String child_longterm_ill_yn = null;
		String child_longterm_ill_nm = null;
		String child_longterm_ill_oth = null;
		String mem_longterm_ill_yn = null;
		String mem_longterm_ill_nm = null;
		String mem_longterm_ill_oth = null;
		String remarks = null;
		String child_age_mnth_ex = null;
		String child_wgt_kg_ex = null;
		String child_wgt_na = null;
		String mother_occu = null;
		String mother_occu_oth = null;
		String child_lngth_hgt_cm = null;
		String child_lngth_hgt_na = null;
		String instr_use = null;
		String child_muac_cm = null;
		String child_muac_na = null;
		String reason_anthro_ntaken = null;
		String reason_any_illness = null;
		String reason_any_illness_other = null;
		String red_flag_chk = null;
		String red_flag_catg = null;
		String users_nm = null;
		String submit_stat = null;
		String chk = null;
		String wgt_for_age = null;
		String hgt_for_age = null;
		String wgt_for_hgt = null;
		String muac = null;
		String child_stat = null;
		JSONArray arr_image_child = new JSONArray();
		
		List<String[]> lst_data = null;
		
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
		    if(key.startsWith("img_details")) {
		    	jsonLogImageData.put(key, jsonObjData.get(key));
		    } else {
		    	jsonLogData.put(key, jsonObjData.get(key));
		    }				    
		}			
		//log.info("Data for Monthly Anthropometry : "+jsonLogData.toString());
		LogCreator.writeLog(logDir, "Data for Monthly Anthropometry : "+jsonLogData.toString(), LogCreator.MESSAGE);
		LogCreator.writeLog(logDir, "Data for Monthly Anthropometry Image Information : "+jsonLogImageData.toString(), LogCreator.MESSAGE);
	
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
		anthro_dt = jsonObjData.get("anthro_dt").toString();
		child_cd = jsonObjData.get("child_cd").toString();
		addmis_dt = jsonObjData.get("addmis_dt").toString();
		child_age_mnth = jsonObjData.get("child_age_mnth").toString();
		current_bf_yn = jsonObjData.get("current_bf_yn").toString();
		child_disable_yn = jsonObjData.get("child_disable_yn").toString();
		child_disable_nm = jsonObjData.get("child_disable_nm").toString();
		child_disable_oth = jsonObjData.get("child_disable_oth").toString();
		child_longterm_ill_yn = jsonObjData.get("child_longterm_ill_yn").toString();
		child_longterm_ill_nm = jsonObjData.get("child_longterm_ill_nm").toString();
		child_longterm_ill_oth = jsonObjData.get("child_longterm_ill_oth").toString();
		mem_longterm_ill_yn = jsonObjData.get("mem_longterm_ill_yn").toString();
		mem_longterm_ill_nm = jsonObjData.get("mem_longterm_ill_nm").toString();
		mem_longterm_ill_oth = jsonObjData.get("mem_longterm_ill_oth").toString();
		remarks = jsonObjData.get("remarks").toString();
		child_age_mnth_ex = jsonObjData.get("child_age_mnth_ex").toString();
		child_wgt_kg_ex = jsonObjData.get("child_wgt_kg_ex").toString();
		child_wgt_na = jsonObjData.get("child_wgt_na").toString();
		mother_occu = jsonObjData.get("mother_occu").toString();
		mother_occu_oth = jsonObjData.get("mother_occu_oth").toString();
		child_lngth_hgt_cm = jsonObjData.get("child_lngth_hgt_cm").toString();
		child_lngth_hgt_na = jsonObjData.get("child_lngth_hgt_na").toString();
		instr_use = jsonObjData.get("instr_use").toString();
		child_muac_cm = jsonObjData.get("child_muac_cm").toString();
		child_muac_na = jsonObjData.get("child_muac_na").toString();
		reason_anthro_ntaken = jsonObjData.get("reason_anthro_ntaken").toString();
		reason_any_illness = jsonObjData.get("reason_any_illness").toString();
		reason_any_illness_other = jsonObjData.get("reason_any_illness_other").toString();
		red_flag_chk = jsonObjData.get("red_flag_chk").toString();
		red_flag_catg = jsonObjData.get("red_flag_catg").toString();
		users_nm = jsonObjData.get("users_nm").toString();
		submit_stat = jsonObjData.get("submit_stat").toString();
		chk = jsonObjData.get("chk").toString();
		wgt_for_age = jsonObjData.get("wgt_for_age").toString();
		hgt_for_age = jsonObjData.get("hgt_for_age").toString();
		wgt_for_hgt = jsonObjData.get("wgt_for_hgt").toString();
		muac = jsonObjData.get("muac").toString();
		child_stat = jsonObjData.get("child_stat").toString();
		
		arr_image_child = (JSONArray) jsonObjData.get("img_details");
		
		String date_time = obj_dt + " "+ obj_time.replaceAll("-", ":");
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			LogCreator.writeLog(logDir, "Error to sleep..."+e.getLocalizedMessage(), LogCreator.ERROR);
		}
		
		String mst_mnth_anthro_sql = null;			
		mst_mnth_anthro_sql = "CALL sp_di_child_anthro("+
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
									Utility.checkVal(anthro_dt)+", "+
									Utility.checkVal(child_cd)+", "+
									Utility.checkVal(addmis_dt)+", "+
									Utility.checkVal(child_age_mnth)+", "+
									Utility.checkVal(current_bf_yn)+", "+
									Utility.checkVal(child_disable_yn)+", "+
									Utility.checkVal(child_disable_nm)+", "+
									Utility.checkVal(child_disable_oth)+", "+
									Utility.checkVal(child_longterm_ill_yn)+", "+
									Utility.checkVal(child_longterm_ill_nm)+", "+
									Utility.checkVal(child_longterm_ill_oth)+", "+
									Utility.checkVal(mem_longterm_ill_yn)+", "+
									Utility.checkVal(mem_longterm_ill_nm)+", "+
									Utility.checkVal(mem_longterm_ill_oth)+", "+
									Utility.checkVal(remarks)+", "+
									Utility.checkVal(child_age_mnth_ex)+", "+
									Utility.checkVal(child_wgt_kg_ex)+", "+
									Utility.checkVal(child_wgt_na)+", "+
									Utility.checkVal(mother_occu)+", "+
									Utility.checkVal(mother_occu_oth)+", "+
									Utility.checkVal(child_lngth_hgt_cm)+", "+
									Utility.checkVal(child_lngth_hgt_na)+", "+
									Utility.checkVal(instr_use)+", "+
									Utility.checkVal(child_muac_cm)+", "+
									Utility.checkVal(child_muac_na)+", "+
									Utility.checkVal(reason_anthro_ntaken)+", "+
									Utility.checkVal(reason_any_illness)+", "+
									Utility.checkVal(red_flag_chk)+", "+
									Utility.checkVal(red_flag_catg)+", "+
									Utility.checkVal(users_nm)+", "+
									Utility.checkVal(submit_stat)+", "+
									Utility.checkVal(child_stat)+", "+
									Utility.checkVal(com.rmspl.odisha.creche.utility.Utility.getCurrentDateTime())+", "+
									Utility.checkVal(chk)+", "+
									Utility.checkVal(wgt_for_age)+", "+
									Utility.checkVal(hgt_for_age)+", "+
									Utility.checkVal(wgt_for_hgt)+", "+
									Utility.checkVal(muac)+", "+
									Utility.checkVal(reason_any_illness_other)+")";
		
		lst_data = DataFetcher.getProcData(mst_mnth_anthro_sql);
		
		if(lst_data.get(0)[0].equalsIgnoreCase("1")) {
			if(arr_image_child.size() > 0) {
				processImage(arr_image_child, file_id);
			}			
			setJsonResponse("done");
		} else if(lst_data.get(0)[0].equalsIgnoreCase("0")) {						
			setJsonResponse("no_user");
		} else if(lst_data.get(0)[0].equalsIgnoreCase("2")) {						
			setJsonResponse("no_child");
		} else {				
			//log.error("Error to upload Data for Monthly Anthropometry..."+file_id);
			LogCreator.writeLog(logDir, "Error to upload Monthly Anthropometry Data..."+file_id, LogCreator.MESSAGE);
			throw new NoRecordFoundException("Error to upload Data for Monthly Anthropometry..."+file_id+"...");
		}
	}
	
	/**
	 * Method to process Image
	 * @param arr_image_child 
	 * @param file_id 
	 * @throws IOException 
	 * @throws NoRecordFoundException 
	 */
	private void processImage(JSONArray arr_image_child, String file_id) throws IOException, NoRecordFoundException {
		//Save Child Image
		for (int i = 0; i < arr_image_child.size(); i++) {
			JSONObject temp_json_child_img = (JSONObject) arr_image_child.get(i);
			String img_index = temp_json_child_img.get("img_index").toString();
			String img_b64 = temp_json_child_img.get("img_b64").toString();
			
			//When Image not available
			if(img_b64.equalsIgnoreCase("")) {
				continue;
			}
			
			List<String[]> lst_data = null;
			lst_data = DataFetcher.getProcData("CALL sp_df_image_anthro_upld("+Utility.checkVal(file_id)+", "+
																	    Utility.checkVal(img_index)+")");
			
			//Root directory for Child Details
			Utility.createDirectory(new File(destinationDir+"/Monthly_Anthropometry"));
			//Create District directory
			Utility.createDirectory(new File(destinationDir+"/Monthly_Anthropometry/"+lst_data.get(0)[0]));
			//Create Block directory
			Utility.createDirectory(new File(destinationDir+"/Monthly_Anthropometry/"+lst_data.get(0)[0]+"/"+lst_data.get(0)[1]));
			//Create GP directory
			Utility.createDirectory(new File(destinationDir+"/Monthly_Anthropometry/"+lst_data.get(0)[0]+"/"+lst_data.get(0)[1]+"/"+lst_data.get(0)[2]));
			//Create Village directory
			Utility.createDirectory(new File(destinationDir+"/Monthly_Anthropometry/"+lst_data.get(0)[0]+"/"+lst_data.get(0)[1]+"/"+lst_data.get(0)[2]+"/"+lst_data.get(0)[3]));
			//Create Creche directory
			Utility.createDirectory(new File(destinationDir+"/Monthly_Anthropometry/"+lst_data.get(0)[0]+"/"+lst_data.get(0)[1]+"/"+lst_data.get(0)[2]+"/"+lst_data.get(0)[3]+"/"+lst_data.get(0)[4]));
			
			File file_img = new File(destinationDir+"/Monthly_Anthropometry/"+lst_data.get(0)[0]+"/"+lst_data.get(0)[1]+"/"+lst_data.get(0)[2]+"/"+lst_data.get(0)[3]+"/"+lst_data.get(0)[4]+"/"+lst_data.get(0)[5]+".jpg");
			BufferedImage image = null;
			// write the image
			image = Base64ToImage.getImage(img_b64);
			ImageIO.write(image, "jpg", file_img);
	        //Updation of flag_image field for Image
			DataFetcher.getProcData("CALL sp_up_image_anthro_flg("+Utility.checkVal(file_id)+", "+
															Utility.checkVal(img_index)+")");
		}
	}


	/**
	 * Method to set response in json
	 * @param status
	 * @param child_code
	 * @return
	 */
	private JSONObject setJsonResponse(String status) {
		//log.info("here in setJsonResponse..."+status+"..."+hh_code);
		json_resp.put("status", status);
		return json_resp;
	}
}

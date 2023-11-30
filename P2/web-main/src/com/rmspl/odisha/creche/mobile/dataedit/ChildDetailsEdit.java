package com.rmspl.odisha.creche.mobile.dataedit;

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
 * Servlet implementation class Child Details Edit
 */
public class ChildDetailsEdit extends HttpServlet {
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
	//private static Log log = LogFactory.getLog(ChildDetails.class);
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
		logPath = getServletContext().getInitParameter("FilePath")+"/Log/Child_Details/";
		logDir = new File(logPath);
		if(!logDir.isDirectory()) {
			Utility.createDirectory(new File(getServletContext().getInitParameter("FilePath")+"/Log/Child_Details/"));
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
			//log.error("No Record found Exception for Child Details Edit.....");
			LogCreator.writeLog(logDir, "No Record found Exception for Child Details Edit.....", LogCreator.MESSAGE);
			setJsonResponse("error", null);
			response.getWriter().print(json_resp);
			return;
		} catch (ApkVersionMismatchException e) {			
			//log.error("Old apk version for Child Details Edit.....");
			LogCreator.writeLog(logDir, "Old apk version for Child Details Edit.....", LogCreator.MESSAGE);
			setJsonResponse("old_apk", null);
			response.getWriter().print(json_resp);
			return;
		} catch(JsonParseException ex) {
			//log.error("Json Parse exception for Child Details Edit",ex);
			LogCreator.writeLog(logDir, "Json Parse exception for Child Details Edit.....", LogCreator.MESSAGE);
			setJsonResponse("error_json", null);
			response.getWriter().print(json_resp);
			return;
		} catch(ParseException ex) {
			//log.error("Parse exception for Child Details Edit",ex);
			LogCreator.writeLog(logDir, "Parse exception for Child Details Edit.....", LogCreator.MESSAGE);
			setJsonResponse("error_parse", null);
			response.getWriter().print(json_resp);
			return;
		} catch(IOException ex) {
			//log.error("Input Output exception for Child Details Edit",ex);
			LogCreator.writeLog(logDir, "Input Output exception for Child Details Edit.....", LogCreator.MESSAGE);
			setJsonResponse("error_io", null);
			response.getWriter().print(json_resp);
			return;
		} catch(Exception ex) {
			//log.error("Exception for Child Details Edit",ex);
			LogCreator.writeLog(logDir, "Exception for Child Details Edit.....", LogCreator.MESSAGE);
			setJsonResponse("error_exception", null);
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
		1. 	app_ver		 			- takes App Version.
		2. 	file_id		 			- takes File ID.
		3. 	obj_dt		 			- takes Object Date
        4. 	obj_time		 		- takes Object Date
		5. 	obj_imei		 		- takes IMEI.
		6. 	dt_cd		 			- takes District Code.
		7. 	bk_cd		 			- takes Block Code.
		8. 	gp_cd		 			- takes GP Code.
		9. 	vl_cd					- takes Village Code.
		10. hh_cd        			- takes HH Code.
		11. hh_couple_no 			- takes HH Couple No.
		12. child_no	 			- takes Child No.
		13.	child_cd	 			- Child Code
		14.	child_nm	 			- Child Name
		15.	child_dob	 			- Child Date of Birth
		16.	child_dob_na 			- Child Date of Birth (Not Available)
		17.	child_gen	 			- Child Gender/Sex
		18.	child_dt_masure	 		- Child Date of Measurement
		19.	child_age_mnth	 		- Child Age in Month
		20.	child_birth_ord	 		- Child Birth Order
		21.	child_birth_wgt_kg		- Child Birth Weight in Kg.
		22.	child_birth_wgt_na		- Child Birth Weight in Kg. (Not Available)
		23.	child_wgt_kg			- Child Weight in Kg.
		24.	child_wgt_na			- Child Weight in Kg. (Not Available)
		25.	child_lngth_hgt_cm		- Child Length / Height in cm.
		26.	child_lngth_hgt_na		- Child Length / Height in cm. (Not Available)
		27.	instr_use				- Instrument Used
		28.	child_muac_cm			- Child MUAC in cm.
		29.	child_muac_na			- Child MUAC in cm. (Not Available)
		30.	submit_stat				- Users Information
		31.	users_nm				- Submit Status
		32.	rec_ins_dt				- Record Insert Date
		33.	chk						- Return True / False
		34.	wgt_for_age				- Weight for Age
		35.	hgt_for_age				- Height for Age
		36.	wgt_for_hgt				- Weight for Height
		37.	muac					- MUAC
		38. ent_remarks 			- Edit Remarks
		39. img_b64					- Image base64
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
		String hh_cd = null;
		String hh_couple_no = null;
		String child_no = null;
		String child_cd = null;
		String child_nm = null;
		String child_dob = null;
		String child_dob_na = null;
		String child_gen = null;
		String child_dt_masure = null;
		String child_age_mnth = null;
		String child_birth_ord = null;
		String child_birth_wgt_kg = null;
		String child_birth_wgt_na = null;
		String child_wgt_kg = null;
		String child_wgt_na = null;
		String child_lngth_hgt_cm = null;
		String child_lngth_hgt_na = null;
		String instr_use = null;
		String child_muac_cm = null;
		String child_muac_na = null;
		String submit_stat = null;
		String users_nm	= null;
		String chk = null;
		String wgt_for_age = null;
		String hgt_for_age = null;
		String wgt_for_hgt = null;
		String muac = null;
		String ent_remarks = null;
		String img_b64 = null;
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
		//log.info("Data for Child Details Edit : "+jsonLogData.toString());
		LogCreator.writeLog(logDir, "Data for Child Details Edit : "+jsonLogData.toString(), LogCreator.MESSAGE);
		LogCreator.writeLog(logDir, "Data for Child Details Edit Image Information : "+jsonLogImageData.toString(), LogCreator.MESSAGE);
	
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
		hh_cd = jsonObjData.get("hh_cd").toString();
		hh_couple_no = jsonObjData.get("hh_couple_no").toString();
		child_no = jsonObjData.get("child_no").toString();
		child_cd = jsonObjData.get("child_cd").toString();
		child_nm = jsonObjData.get("child_nm").toString();
		child_dob = jsonObjData.get("child_dob").toString();
		child_dob_na = jsonObjData.get("child_dob_na").toString();
		child_gen = jsonObjData.get("child_gen").toString();
		child_dt_masure = jsonObjData.get("child_dt_masure").toString();
		child_age_mnth = jsonObjData.get("child_age_mnth").toString();
		child_birth_ord = jsonObjData.get("child_birth_ord").toString();
		child_birth_wgt_kg = jsonObjData.get("child_birth_wgt_kg").toString();
		child_birth_wgt_na = jsonObjData.get("child_birth_wgt_na").toString();
		child_wgt_kg = jsonObjData.get("child_wgt_kg").toString();
		child_wgt_na = jsonObjData.get("child_wgt_na").toString();
		child_lngth_hgt_cm = jsonObjData.get("child_lngth_hgt_cm").toString();
		child_lngth_hgt_na = jsonObjData.get("child_lngth_hgt_na").toString();
		instr_use = jsonObjData.get("instr_use").toString();
		child_muac_cm = jsonObjData.get("child_muac_cm").toString();
		child_muac_na = jsonObjData.get("child_muac_na").toString();
		submit_stat = jsonObjData.get("submit_stat").toString();
		users_nm = jsonObjData.get("users_nm").toString();
		chk = jsonObjData.get("chk").toString();
		wgt_for_age = jsonObjData.get("wgt_for_age").toString();
		hgt_for_age = jsonObjData.get("hgt_for_age").toString();
		wgt_for_hgt = jsonObjData.get("wgt_for_hgt").toString();
		muac = jsonObjData.get("muac").toString();
		ent_remarks = jsonObjData.get("ent_remarks").toString();
		
		arr_image_child = (JSONArray) jsonObjData.get("img_details");
		
		String date_time = obj_dt + " "+ obj_time.replaceAll("-", ":");
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			LogCreator.writeLog(logDir, "Error to sleep..."+e.getLocalizedMessage(), LogCreator.ERROR);
		}
		
		String mst_child_details_sql = null;			
		mst_child_details_sql = "CALL sp_di_child_dtl_edit("+
									Utility.checkVal(app_ver)+", "+
									Utility.checkVal(file_id)+", "+
									Utility.checkVal(date_time)+", "+
									Utility.checkVal(obj_imei)+", "+
									Utility.checkVal(dt_cd)+", "+
									Utility.checkVal(bk_cd)+", "+
									Utility.checkVal(gp_cd)+", "+
									Utility.checkVal(vl_cd)+", "+
									Utility.checkVal(hh_cd)+", "+
									Utility.checkVal(hh_couple_no)+", "+
									Utility.checkVal(child_no)+", "+
									Utility.checkVal(child_cd)+", "+
									Utility.checkVal(child_nm)+", "+
									Utility.checkVal(child_dob)+", "+
									Utility.checkVal(child_dob_na)+", "+
									Utility.checkVal(child_gen)+", "+
									Utility.checkVal(child_dt_masure)+", "+
									Utility.checkVal(child_age_mnth)+", "+
									Utility.checkVal(child_birth_ord)+", "+
									Utility.checkVal(child_birth_wgt_kg)+", "+
									Utility.checkVal(child_birth_wgt_na)+", "+
									Utility.checkVal(child_wgt_kg)+", "+
									Utility.checkVal(child_wgt_na)+", "+
									Utility.checkVal(child_lngth_hgt_cm)+", "+
									Utility.checkVal(child_lngth_hgt_na)+", "+
									Utility.checkVal(instr_use)+", "+
									Utility.checkVal(child_muac_cm)+", "+
									Utility.checkVal(child_muac_na)+", "+
									Utility.checkVal(submit_stat)+", "+
									Utility.checkVal(ent_remarks)+", "+
									Utility.checkVal(users_nm)+", "+
									Utility.checkVal(com.rmspl.odisha.creche.utility.Utility.getCurrentDateTime())+", "+
									Utility.checkVal(chk)+", "+
									Utility.checkVal(wgt_for_age)+", "+
									Utility.checkVal(hgt_for_age)+", "+
									Utility.checkVal(wgt_for_hgt)+", "+
									Utility.checkVal(muac)+")";
		
		lst_data = DataFetcher.getProcData(mst_child_details_sql);
		
		if(lst_data.get(0)[0].equalsIgnoreCase("1")) {
			if(arr_image_child.size() > 0) {
				processImage(arr_image_child, file_id);
			}			
			setJsonResponse("done", lst_data.get(0)[1]);
		} else if(lst_data.get(0)[0].equalsIgnoreCase("0")) {						
			setJsonResponse("no_user", null);
		} else if(lst_data.get(0)[0].equalsIgnoreCase("2")) {						
			setJsonResponse("no_child", null);
		} else {				
			//log.error("Error to upload Data for Child Details Edit..."+file_id);
			LogCreator.writeLog(logDir, "Error to upload Data for Child Details Edit..."+file_id, LogCreator.MESSAGE);
			throw new NoRecordFoundException("Error to upload Data for Child Details Edit..."+file_id+"...");
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
			lst_data = DataFetcher.getProcData("CALL sp_df_image_upld("+Utility.checkVal(file_id)+", "+
																	    Utility.checkVal(img_index)+")");
			
			//Root directory for Child Details Edit
			Utility.createDirectory(new File(destinationDir+"/Child_Details"));
			//Create District directory
			Utility.createDirectory(new File(destinationDir+"/Child_Details/"+lst_data.get(0)[0]));
			//Create Block directory
			Utility.createDirectory(new File(destinationDir+"/Child_Details/"+lst_data.get(0)[0]+"/"+lst_data.get(0)[1]));
			//Create GP directory
			Utility.createDirectory(new File(destinationDir+"/Child_Details/"+lst_data.get(0)[0]+"/"+lst_data.get(0)[1]+"/"+lst_data.get(0)[2]));
			//Create Village directory
			Utility.createDirectory(new File(destinationDir+"/Child_Details/"+lst_data.get(0)[0]+"/"+lst_data.get(0)[1]+"/"+lst_data.get(0)[2]+"/"+lst_data.get(0)[3]));
			
			File file_img = new File(destinationDir+"/Child_Details/"+lst_data.get(0)[0]+"/"+lst_data.get(0)[1]+"/"+lst_data.get(0)[2]+"/"+lst_data.get(0)[3]+"/"+lst_data.get(0)[4]+".jpg");
			BufferedImage image = null;
			// write the image
			image = Base64ToImage.getImage(img_b64);
			ImageIO.write(image, "jpg", file_img);
	        //Updation of flag_image field for Image
			DataFetcher.getProcData("CALL sp_up_image_flg("+Utility.checkVal(file_id)+", "+
															Utility.checkVal(img_index)+")");
		}
	}


	/**
	 * Method to set response in json
	 * @param status
	 * @param child_code
	 * @return
	 */
	private JSONObject setJsonResponse(String status, String child_code) {
		//log.info("here in setJsonResponse..."+status+"..."+hh_code);
		json_resp.put("status", status);
		json_resp.put("child_code", child_code);	
		return json_resp;
	}
}

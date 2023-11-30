package com.rmspl.odisha.creche.mobile.dataentry;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
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
 * Servlet implementation class HH Listing Sync
 */
public class HHListingSync extends HttpServlet {
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
	//private static Log log = LogFactory.getLog(HHListingSync.class);
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
		logPath = getServletContext().getInitParameter("FilePath")+"/Log/HH_Listing_Sync/";
		logDir = new File(logPath);
		if(!logDir.isDirectory()) {
			Utility.createDirectory(new File(getServletContext().getInitParameter("FilePath")+"/Log/HH_Listing_Sync/"));
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
			//log.error("No Record found Exception for HH Listing Sync.....");
			LogCreator.writeLog(logDir, "No Record found Exception for HH Listing Sync.....", LogCreator.MESSAGE);
			setJsonResponse("error", null);
			response.getWriter().print(json_resp);
			return;
		} catch (ApkVersionMismatchException e) {			
			//log.error("Old apk version for HH Listing Sync.....");
			LogCreator.writeLog(logDir, "Old apk version for HH Listing Sync.....", LogCreator.MESSAGE);
			setJsonResponse("old_apk", null);
			response.getWriter().print(json_resp);
			return;
		} catch(JsonParseException ex) {
			//log.error("Json Parse exception for HH Listing Sync",ex);
			LogCreator.writeLog(logDir, "Json Parse exception for HH Listing Sync.....", LogCreator.MESSAGE);
			setJsonResponse("error_json", null);
			response.getWriter().print(json_resp);
			return;
		} catch(ParseException ex) {
			//log.error("Parse exception for HH Listing Sync",ex);
			LogCreator.writeLog(logDir, "Parse exception for HH Listing Sync.....", LogCreator.MESSAGE);
			setJsonResponse("error_parse", null);
			response.getWriter().print(json_resp);
			return;
		} catch(Exception ex) {
			//log.error("Exception for HH Listing Sync",ex);
			LogCreator.writeLog(logDir, "Exception for HH Listing Sync.....", LogCreator.MESSAGE);
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
	 * @throws ParseException 
	 */
	private void processData(HttpServletResponse response, String data) throws NoRecordFoundException, ApkVersionMismatchException, JsonParseException, ParseException {
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
		
		String hh_couple_no = null;
		String father_nm = null;
		String mother_nm = null;
		String father_edu = null;
		String father_edu_oth = null;
		String mother_edu = null;
		String mother_edu_oth = null;
		String father_occu = null;
		String father_occu_oth = null;
		String mother_occu = null;
		String mother_occu_oth = null;
		String caste = null;
		String caste_oth = null;
		String religion = null;
		String religion_oth = null;
		String ration_card_type = null;
		String fam_own_land_yn = null;
		String house_type = null;
		String submit_stat = null;
		
		String ent_remarks = null;
		
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
		//log.info("Data for HH Listing : "+jsonLogData.toString());
		LogCreator.writeLog(logDir, "Data for HH Listing Sync : "+jsonLogData.toString(), LogCreator.MESSAGE);
		//LogCreator.writeLog(logDir, "Data for HH Image Information : "+jsonLogImageData.toString(), LogCreator.MESSAGE);
	
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
		hh_cd = jsonObjData.get("hh_cd").toString();
		dt_cd = jsonObjData.get("dt_cd").toString();
		bk_cd = jsonObjData.get("bk_cd").toString();								
		gp_cd = jsonObjData.get("gp_cd").toString();
		vl_cd = jsonObjData.get("vl_cd").toString();
		hh_couple_no = jsonObjData.get("hh_couple_no").toString();
		father_nm = jsonObjData.get("father_nm").toString();
		mother_nm = jsonObjData.get("mother_nm").toString();
		father_edu = jsonObjData.get("father_edu").toString();
		father_edu_oth = jsonObjData.get("father_edu_oth").toString();
		mother_edu = jsonObjData.get("mother_edu").toString();
		mother_edu_oth = jsonObjData.get("mother_edu_oth").toString();
		father_occu = jsonObjData.get("father_occu").toString();
		father_occu_oth = jsonObjData.get("father_occu_oth").toString();
		mother_occu = jsonObjData.get("mother_occu").toString();
		mother_occu_oth = jsonObjData.get("mother_occu_oth").toString();
		caste = jsonObjData.get("caste").toString();
		caste_oth = jsonObjData.get("caste_oth").toString();
		religion = jsonObjData.get("religion").toString();
		religion_oth = jsonObjData.get("religion_oth").toString();
		ration_card_type = jsonObjData.get("ration_card_type").toString();
		fam_own_land_yn = jsonObjData.get("fam_own_land_yn").toString();
		house_type = jsonObjData.get("house_type").toString();
		submit_stat = jsonObjData.get("submit_stat").toString();
		log_user = jsonObjData.get("log_user").toString();
		chk = jsonObjData.get("chk").toString();
		ent_remarks = jsonObjData.get("ent_remarks").toString();
		
		String date_time = obj_dt + " "+ obj_time.replaceAll("-", ":");
		
		String mst_hh_list_sql = null;			
		mst_hh_list_sql = "CALL sp_di_hh_list_backdata("+
							Utility.checkVal(app_ver)+", "+
							Utility.checkVal(file_id)+", "+
							Utility.checkVal(date_time)+", "+
							Utility.checkVal(obj_imei)+", "+
				
							Utility.checkVal(hh_cd)+", "+
							Utility.checkVal(dt_cd)+", "+
							Utility.checkVal(bk_cd)+", "+
							Utility.checkVal(gp_cd)+", "+
							Utility.checkVal(vl_cd)+", "+
							
							Utility.checkVal(hh_couple_no)+", "+
							Utility.checkVal(father_nm)+", "+
							Utility.checkVal(mother_nm)+", "+
							Utility.checkVal(father_edu)+", "+
							Utility.checkVal(father_edu_oth)+", "+
							Utility.checkVal(mother_edu)+", "+
							Utility.checkVal(mother_edu_oth)+", "+
							Utility.checkVal(father_occu)+", "+
							Utility.checkVal(father_occu_oth)+", "+
							Utility.checkVal(mother_occu)+", "+
							Utility.checkVal(mother_occu_oth)+", "+
							Utility.checkVal(caste)+", "+
							Utility.checkVal(caste_oth)+", "+
							Utility.checkVal(religion)+", "+
							Utility.checkVal(religion_oth)+", "+
							Utility.checkVal(ration_card_type)+", "+
							Utility.checkVal(fam_own_land_yn)+", "+
							Utility.checkVal(house_type)+", "+
							Utility.checkVal(submit_stat)+", "+
							Utility.checkVal(log_user)+", "+
							Utility.checkVal(com.rmspl.odisha.creche.utility.Utility.getCurrentDateTime())+", "+
							Utility.checkVal(chk)+", "+
							Utility.checkVal(ent_remarks)+")";
		
		lst_data = DataFetcher.getProcData(mst_hh_list_sql);
					
		if(lst_data.get(0)[0].equalsIgnoreCase("1")) {
			setJsonResponse("done", lst_data.get(0)[1]);	
		} else if(lst_data.get(0)[0].equalsIgnoreCase("0")) {						
			setJsonResponse("no_user", null);
		} else if(lst_data.get(0)[0].equalsIgnoreCase("2")) {						
			setJsonResponse("no_child", null);
		} else {				
			//log.error("Error to upload HH Listing Sync Data..."+file_id);
			LogCreator.writeLog(logDir, "Error to upload HH Listing Sync Data..."+file_id, LogCreator.MESSAGE);
			throw new NoRecordFoundException("Error to upload Data..."+file_id+"...");
		}
	}
	
	/**
	 * Method to set response in json
	 * @param status
	 * @param hh_code
	 * @return
	 */
	private JSONObject setJsonResponse(String status, String hh_code) {
		//log.info("here in setJsonResponse..."+status+"..."+hh_code);
		json_resp.put("status", status);
		json_resp.put("hh_code", hh_code);	
		return json_resp;
	}	
}

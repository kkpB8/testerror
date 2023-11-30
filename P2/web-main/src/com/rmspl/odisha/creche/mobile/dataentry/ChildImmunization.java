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
 * Servlet implementation class Child Details
 */
public class ChildImmunization extends HttpServlet {
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
		logPath = getServletContext().getInitParameter("FilePath")+"/Log/Child_Immu/";
		logDir = new File(logPath);
		if(!logDir.isDirectory()) {
			Utility.createDirectory(new File(getServletContext().getInitParameter("FilePath")+"/Log/Child_Immu/"));
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
			//log.error("No Record found Exception for Child Immunization.....");
			LogCreator.writeLog(logDir, "No Record found Exception for Child Immunization.....", LogCreator.MESSAGE);
			setJsonResponse("error");
			response.getWriter().print(json_resp);
			return;
		} catch (ApkVersionMismatchException e) {			
			//log.error("Old apk version for Child Immunization.....");
			LogCreator.writeLog(logDir, "Old apk version for Child Immunization.....", LogCreator.MESSAGE);
			setJsonResponse("old_apk");
			response.getWriter().print(json_resp);
			return;
		} catch(JsonParseException ex) {
			//log.error("Json Parse exception for Child Immunization",ex);
			LogCreator.writeLog(logDir, "Json Parse exception for Child Immunization.....", LogCreator.MESSAGE);
			setJsonResponse("error_json");
			response.getWriter().print(json_resp);
			return;
		} catch(ParseException ex) {
			//log.error("Parse exception for Child Immunization",ex);
			LogCreator.writeLog(logDir, "Parse exception for Child Immunization.....", LogCreator.MESSAGE);
			setJsonResponse("error_parse");
			response.getWriter().print(json_resp);
			return;
		} catch(IOException ex) {
			//log.error("Input Output exception for Child Immunization",ex);
			LogCreator.writeLog(logDir, "Input Output exception for Child Immunization.....", LogCreator.MESSAGE);
			setJsonResponse("error_io");
			response.getWriter().print(json_resp);
			return;
		} catch(Exception ex) {
			//log.error("Exception for Child Immunization",ex);
			LogCreator.writeLog(logDir, "Exception for Child Immunization.....", LogCreator.MESSAGE);
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
		01. app_ver 		- takes App Version.
		02. file_id 		- takes File ID.
		03. objdt 			- takes Object Datetime.
		04. obj_imei 		- takes Object IMEI.
		05. dt_cd 			- takes District.
		06. bk_cd 			- takes Block.
		07. gp_cd 			- takes GP.
		08. vl_cd 			- takes Village.
		09. creche_cd 		- takes Creche.
		10. father_nm 		- takes Name of Father.
		11. mother_nm 		- takes Name of Mother.
		12. child_nm 		- takes Child Name.
		13. child_dob 		- takes Child Date of Birth.
		14. child_gen 		- takes Child Gender.
		15. child_rept_dt 	- takes Reporting Date.
		16. mcp_crd_avail   - takes Whether MCP Card Available.
		17. data_immu 		- takes Child Code, Immu ID and Immu Date. -- MULTIPLE DATASET WITHIN DOUBLE INVERTED COMMAS
		18. child_wgt_immu  - takes Weight at Immu.
		19. users_nm 		- takes Username.
		20. rec_ins_dt 		- takes Record Insert Date.
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
		String father_nm = null;
		String mother_nm = null;
		//String child_cd = null;
		String child_nm = null;
		String child_dob = null;
		String child_gen = null;
		String child_rept_dt = null;
		String mcp_crd_avail = null;
		String data_immu = null;
		String child_wgt_immu = null;
		String users_nm = null;		
		List<String[]> lst_data = null;
		//log.info(request.getParameter("data"));
		
		JSONParser parser = new JSONParser();
		Object obj_data = parser.parse(data);
		JSONObject jsonObjData = (JSONObject) obj_data;
		
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
		father_nm = jsonObjData.get("father_nm").toString();
		mother_nm = jsonObjData.get("mother_nm").toString();
		//child_cd = jsonObjData.get("child_cd").toString();
		child_nm = jsonObjData.get("child_nm").toString();
		child_dob = jsonObjData.get("child_dob").toString();
		child_gen = jsonObjData.get("child_gen").toString();
		child_rept_dt = jsonObjData.get("child_rept_dt").toString();
		mcp_crd_avail = jsonObjData.get("mcp_crd_avail").toString();
		data_immu = jsonObjData.get("data_immu").toString();
		child_wgt_immu = jsonObjData.get("child_wgt_immu").toString();
		users_nm = jsonObjData.get("users_nm").toString();
		
		String date_time = obj_dt + " "+ obj_time.replaceAll("-", ":");
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			LogCreator.writeLog(logDir, "Error to sleep..."+e.getLocalizedMessage(), LogCreator.ERROR);
		}
		
		String mst_child_details_sql = null;			
		mst_child_details_sql = "CALL sp_di_child_immu("+
									Utility.checkVal(app_ver)+", "+
									Utility.checkVal(file_id)+", "+
									Utility.checkVal(date_time)+", "+
									Utility.checkVal(obj_imei)+", "+
									Utility.checkVal(dt_cd)+", "+
									Utility.checkVal(bk_cd)+", "+
									Utility.checkVal(gp_cd)+", "+
									Utility.checkVal(vl_cd)+", "+
									Utility.checkVal(creche_cd)+", "+
									Utility.checkVal(father_nm)+", "+
									Utility.checkVal(mother_nm)+", "+
									Utility.checkVal(child_nm)+", "+
									Utility.checkVal(child_dob)+", "+
									Utility.checkVal(child_gen)+", "+
									Utility.checkVal(child_rept_dt)+", "+
									Utility.checkVal(mcp_crd_avail)+", "+
									Utility.checkValueMulti(data_immu)+", "+
									Utility.checkVal(child_wgt_immu)+", "+
									Utility.checkVal(users_nm)+", "+
									Utility.checkVal(com.rmspl.odisha.creche.utility.Utility.getCurrentDateTime())+")";
		//System.out.println("SQL = "+mst_child_details_sql);
		lst_data = DataFetcher.getProcData(mst_child_details_sql);
		
		if(lst_data.get(0)[0].equalsIgnoreCase("1")) {			
			setJsonResponse("done");
		} else {				
			//log.error("Error to upload Data for Child Immunization..."+file_id);
			LogCreator.writeLog(logDir, "Error to upload Data for Child Immunization..."+file_id, LogCreator.MESSAGE);
			throw new NoRecordFoundException("Error to upload Data for Child Immunization..."+file_id+"...");
		}
	}

	/**
	 * Method to set response in json
	 * @param status
	 * @param child_code
	 * @return
	 */
	private JSONObject setJsonResponse(String status) {
		//log.info("here in setJsonResponse..."+status);
		json_resp.put("status", status);
		return json_resp;
	}
}

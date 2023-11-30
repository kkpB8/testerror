package com.rmspl.odisha.creche.app.user.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.rmspl.app.data.service.DataFetcher;
import com.rmspl.app.data.service.NoRecordFoundException;
import com.rmspl.odisha.creche.utility.Utility;

/**
 * Servlet implementation class to create Web user
 */
public class SaveNewWebUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * Write log
	 */
	private static Log log = LogFactory.getLog(SaveNewWebUser.class);
	
	private String txtCrtUsrName;
	private String txtCrtUsrEmail;
	private String txtCrtUsrPhn;
	private String txtCrtUsrId;
	private String txtCrtUsrPwd;
	private String userlvl;
	private String userlvlCode;
	//private String st_code;
	//private String selDist;
	//private String selBlock;
	private String menuCode;
	private String subMenuCode;
	private String grpCode;
	private String subGrpCode;
	private String loginusrid;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	    	//JSON parser object
			JSONParser parser = new JSONParser();
			Object object = new Object();
			//JSON parameter set
			JSONObject json_param_set_obj = null;
	    	String json_param_set= request.getParameter("json_param_set");
	    	
	    	object = parser.parse(json_param_set);
			json_param_set_obj = (JSONObject) object;
			
			String str_sql = "";
			//System.out.println(json_param_set_obj);
			//log.info(json_param_set_obj);
		
			//Check json size
			if (json_param_set_obj.size() > 0) {
				//Extract the value of dynamic JSON key				
				txtCrtUsrName = json_param_set_obj.get("txtCrtUsrName").toString();
				txtCrtUsrEmail = json_param_set_obj.get("txtCrtUsrEmail").toString();
				txtCrtUsrPhn = json_param_set_obj.get("txtCrtUsrPhn").toString();				
				txtCrtUsrId = json_param_set_obj.get("txtCrtUsrId").toString();
				txtCrtUsrPwd = json_param_set_obj.get("txtCrtUsrPwd").toString();
				userlvl = json_param_set_obj.get("userlvl").toString();
				userlvlCode = json_param_set_obj.get("userlvlCode").toString();
				//st_code = json_param_set_obj.get("st_code").toString();
				//selDist = json_param_set_obj.get("selDist").toString();
				//selBlock = json_param_set_obj.get("selBlock").toString();
				menuCode = json_param_set_obj.get("menuCode").toString();
				subMenuCode = json_param_set_obj.get("subMenuCode").toString();
				grpCode = json_param_set_obj.get("grpCode").toString();
				subGrpCode = json_param_set_obj.get("subGrpCode").toString();
				loginusrid = json_param_set_obj.get("loginusrid").toString();
				
				str_sql = "CALL sp_di_web_user_add("+
									Utility.checkVal(txtCrtUsrName)+", "+
									Utility.checkVal(txtCrtUsrEmail)+", "+
									Utility.checkVal(txtCrtUsrPhn)+", "+
									Utility.checkVal(txtCrtUsrId)+", "+
									Utility.checkVal(txtCrtUsrPwd)+", "+
									Utility.checkVal(userlvl)+", "+
									Utility.checkVal(userlvlCode)+", "+
									Utility.checkVal(menuCode)+", "+
									Utility.checkVal(subMenuCode)+", "+
									Utility.checkVal(grpCode)+", "+
									Utility.checkVal(subGrpCode)+", "+
									Utility.checkVal(loginusrid)+", "+
									Utility.checkVal(Utility.getCurrentDateTime())+
									")";
			}
			//For Upload
			List<String[]> lstData = new ArrayList<String[]>();
			try {
				lstData = DataFetcher.getProcData(str_sql);
				if (lstData.size() > 0) {
					JSONObject resp_json = new JSONObject();
					resp_json.put("status", "1");
					response.getWriter().print(resp_json);
				} else {
					JSONObject resp_json = new JSONObject();
					resp_json.put("status", "0");
					response.getWriter().print(resp_json);
				}
			} catch (NoRecordFoundException e) {
				log.info("Error to Creating new user for Web...."+e.getLocalizedMessage()+" Cause : "+e.getCause());
				//response.getWriter().print("Error");
				JSONObject resp_json = new JSONObject();
				resp_json.put("status", "0");
				response.getWriter().print(resp_json);
			}
	    } catch (ParseException e) {
	    	log.info("Error to parse Data...."+e.getLocalizedMessage()+" Cause : "+e.getCause());
			//response.getWriter().print("Error");
	    	JSONObject resp_json = new JSONObject();
			resp_json.put("status", "0");
			response.getWriter().print(resp_json);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	log.info("Error to Creating new user ...."+e.getLocalizedMessage()+" Cause : "+e.getCause());
			//response.getWriter().print("Error");
	    	JSONObject resp_json = new JSONObject();
			resp_json.put("status", "0");
			response.getWriter().print(resp_json);
		}
	}
}

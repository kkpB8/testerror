package com.rmspl.odisha.creche.app.admin;

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
 * Servlet implementation class to add Geography
 */
public class AddGeography extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * Write log
	 */
	private static Log log = LogFactory.getLog(AddGeography.class);
	
	private String sel_level = null;
	private String sel_dt = null;
	private String sel_bk = null;
	private String sel_gp = null;
	private String sel_vl = null;
	private String login_user = null;
	
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
			//log.info(json_param_set_obj);
		
			//Check json size
			if (json_param_set_obj.size() > 0) {
				//Extract the value of dynamic JSON key				
				sel_level = json_param_set_obj.get("sel_level").toString();
				sel_dt = json_param_set_obj.get("sel_dt").toString();
				sel_bk = json_param_set_obj.get("sel_bk").toString();				
				sel_gp = json_param_set_obj.get("sel_gp").toString();
				sel_vl = json_param_set_obj.get("sel_vl").toString();
				login_user = json_param_set_obj.get("login_user").toString();
				
				str_sql = "CALL sp_di_add_geography("+
									Utility.checkVal(sel_level)+", "+
									Utility.checkVal(sel_dt)+", "+
									Utility.checkVal(sel_bk)+", "+
									Utility.checkVal(sel_gp)+", "+
									Utility.checkVal(sel_vl)+", "+
									Utility.checkVal(login_user)+", "+
									Utility.checkVal(Utility.getCurrentDateTime())+
									")";
			}
			//For Upload
			List<String[]> lstData = new ArrayList<String[]>();
			try {
				lstData = DataFetcher.getProcData(str_sql);
				if (lstData.size() > 0) {
					JSONObject resp_json = new JSONObject();
					if(lstData.get(0)[0].equalsIgnoreCase("1")) {
						resp_json.put("status", "1");
					} else if(lstData.get(0)[0].equalsIgnoreCase("0")) {
						resp_json.put("status", "0");
					} else {
						resp_json.put("status", "2");
					}
					response.getWriter().print(resp_json);
				} else {
					JSONObject resp_json = new JSONObject();
					resp_json.put("status", "2");
					response.getWriter().print(resp_json);
				}
			} catch (NoRecordFoundException e) {
				log.info("Error to Creating new user for Web...."+e.getLocalizedMessage()+" Cause : "+e.getCause());
				//response.getWriter().print("Error");
				JSONObject resp_json = new JSONObject();
				resp_json.put("status", "2");
				response.getWriter().print(resp_json);
			}
	    } catch (ParseException e) {
	    	log.info("Error to parse Data...."+e.getLocalizedMessage()+" Cause : "+e.getCause());
			//response.getWriter().print("Error");
	    	JSONObject resp_json = new JSONObject();
			resp_json.put("status", "2");
			response.getWriter().print(resp_json);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	log.info("Error to add Geography ...."+e.getLocalizedMessage()+" Cause : "+e.getCause());
	    	JSONObject resp_json = new JSONObject();
			resp_json.put("status", "2");
			response.getWriter().print(resp_json);
		}
	}
}

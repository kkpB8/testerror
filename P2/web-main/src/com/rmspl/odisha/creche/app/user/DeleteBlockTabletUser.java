package com.rmspl.odisha.creche.app.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation to delete Tablet User
 */

public class DeleteBlockTabletUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * Write log
	 */
	private static Log log = LogFactory.getLog(SaveNewTabletUser.class);
		
	private String user_name;
	private String mod_type;	
	private String added_bk;
	private String loginusrid;
	
	
	/**
	 * Post Request to delete Tablet User
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
				user_name = json_param_set_obj.get("user_name").toString();
				mod_type = json_param_set_obj.get("mod_type").toString();
				added_bk = json_param_set_obj.get("added_bk").toString();				
				loginusrid = json_param_set_obj.get("loginusrid").toString();
				
				str_sql = Utility.checkVal(user_name)+", "+
						  Utility.checkVal(mod_type)+", "+
						  added_bk+", "+
						  Utility.checkVal(loginusrid)+", "+
						  Utility.checkVal(Utility.getCurrentDateTime());
				
				str_sql = "CALL sp_du_tab_usr_add_del_bk("+str_sql+")";				
			}

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
				log.info("Error to delete block...."+e.getLocalizedMessage()+" Cause : "+e.getCause());
				JSONObject resp_json = new JSONObject();
				resp_json.put("status", "0");
				response.getWriter().print(resp_json);
			}
	    } catch (ParseException e) {
	    	log.info("Error to parse Data...."+e.getLocalizedMessage()+" Cause : "+e.getCause());
	    	JSONObject resp_json = new JSONObject();
	    	resp_json.put("status", "0");
			response.getWriter().print(resp_json);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	log.info("Error to delete block ...."+e.getLocalizedMessage()+" Cause : "+e.getCause());
	    	JSONObject resp_json = new JSONObject();
	    	resp_json.put("status", "0");
			response.getWriter().print(resp_json);
		}
	}
}

package com.rmspl.odisha.creche.app.admin;

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
 * Servlet implementation class to create Web user
 */
public class AddQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * Write log
	 */
	private static Log log = LogFactory.getLog(AddQuestion.class);
	
	private String sel_form = null;
	private String sel_qtn_type = null;
	private String chk_mandatory = null;
	private String chk_dont_know = null;
	private String txt_qtn = null;
	private String sel_qtn_format = null;
	private String chk_always = null;
	private String sel_prev_qtn_type = null;
	private String sel_prev_condition_type = null;
	private String txt_cnd_val = null;
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
				sel_form = json_param_set_obj.get("sel_form").toString();
				sel_qtn_type = json_param_set_obj.get("sel_qtn_type").toString();
				chk_mandatory = json_param_set_obj.get("chk_mandatory").toString();				
				chk_dont_know = json_param_set_obj.get("chk_dont_know").toString();
				txt_qtn = json_param_set_obj.get("txt_qtn").toString();
				sel_qtn_format = json_param_set_obj.get("sel_qtn_format").toString();
				chk_always = json_param_set_obj.get("chk_always").toString();
				sel_prev_qtn_type = json_param_set_obj.get("sel_prev_qtn_type").toString();
				sel_prev_condition_type = json_param_set_obj.get("sel_prev_condition_type").toString();
				txt_cnd_val = json_param_set_obj.get("txt_cnd_val").toString();
				login_user = json_param_set_obj.get("login_user").toString();
				
				str_sql = "CALL sp_df_nw_qstn("+
									Utility.checkVal(sel_form)+", "+
									Utility.checkVal(sel_qtn_type)+", "+
									Utility.checkVal(chk_mandatory)+", "+
									Utility.checkVal(chk_dont_know)+", "+
									Utility.checkVal(txt_qtn)+", "+
									Utility.checkVal(sel_qtn_format)+", "+
									Utility.checkVal(chk_always)+", "+
									Utility.checkVal(sel_prev_qtn_type)+", "+
									Utility.checkVal(sel_prev_condition_type)+", "+
									Utility.checkVal(txt_cnd_val)+", "+
									Utility.checkVal(Utility.getCurrentDateTime())+", "+
									Utility.checkVal(login_user)+
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

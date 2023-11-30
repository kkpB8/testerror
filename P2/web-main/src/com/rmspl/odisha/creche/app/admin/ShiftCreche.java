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
 * Servlet implementation class to create Web user
 */
public class ShiftCreche extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * Write log
	 */
	private static Log log = LogFactory.getLog(ShiftCreche.class);
	
	private String opt_type = null;
	private String sel_dt_shf_des = null;
	private String sel_bk_shf_des = null;
	private String sel_gp_shf_des = null;
	private String sel_vl_shf_des = null;
	private String sel_cr_shf_src = null;
	private String txt_cr_shf_src_name = null;
	private String sel_func_del = null;
	private String sel_type_del = null;
	private String sel_prj_prog_shf_des = null; //# 31.01.2022
	private String sel_date_del = null;
	private String txt_remarks_shf_des = null;
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
				opt_type = json_param_set_obj.get("opt_type").toString();
				sel_dt_shf_des = json_param_set_obj.get("sel_dt_shf_des").toString();
				sel_bk_shf_des = json_param_set_obj.get("sel_bk_shf_des").toString();				
				sel_gp_shf_des = json_param_set_obj.get("sel_gp_shf_des").toString();
				sel_vl_shf_des = json_param_set_obj.get("sel_vl_shf_des").toString();
				sel_cr_shf_src = json_param_set_obj.get("sel_cr_shf_src").toString();
				sel_prj_prog_shf_des = json_param_set_obj.get("sel_prj_prog_shf_des").toString();
				txt_remarks_shf_des = json_param_set_obj.get("txt_remarks_shf_des").toString();
				login_user = json_param_set_obj.get("login_user").toString();
				
				str_sql = "CALL sp_du_creche_manage("+
									Utility.checkVal(opt_type)+", "+
									Utility.checkVal(sel_dt_shf_des)+", "+
									Utility.checkVal(sel_bk_shf_des)+", "+
									Utility.checkVal(sel_gp_shf_des)+", "+
									Utility.checkVal(sel_vl_shf_des)+", "+
									Utility.checkVal(sel_cr_shf_src)+", "+
									"NULL, " + "NULL, " + "NULL, "+
									Utility.checkVal(sel_prj_prog_shf_des)+", "+
									"NULL, "+
									Utility.checkVal(txt_remarks_shf_des)+", "+
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

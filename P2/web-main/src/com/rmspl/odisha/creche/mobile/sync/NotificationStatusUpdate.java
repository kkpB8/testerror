package com.rmspl.odisha.creche.mobile.sync;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;

import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;

import com.rmspl.app.data.service.DataFetcher;
import com.rmspl.app.data.service.NoRecordFoundException;
import com.rmspl.odisha.creche.mobile.util.Utility;

/**
 * Servlet implementation class Notification Status Update
 */
public class NotificationStatusUpdate extends HttpServlet {
	/**
	 * version identifier for a Serializable class
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Write log
	 */
	private static Log log = LogFactory.getLog(NotificationStatusUpdate.class);

	/**
	 * Response Data
	 */	
	private JSONObject json_resp = new JSONObject();
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		/*
		 * CALL `sp_du_mob_noti_flag`(var_frm_no VARCHAR(5), var_hh_cd VARCHAR(20),
		 * var_child_cd VARCHAR(20), var_creche_cd VARCHAR(20), var_rec_upd_dttime
		 * DATETIME, var_users_nm LONGTEXT)
		 */
		
		String form_no = request.getParameter("form_no");
		String hh_cd = request.getParameter("hh_cd");
		String child_cd = request.getParameter("child_cd");
		String creche_cd = request.getParameter("creche_cd");
		String rec_upd_dttime = request.getParameter("rec_upd_dttime");
		String users_nm = request.getParameter("users_nm");
		List<String[]> lst_data = null;
		try {
				
			String mst_sql = null;			
			mst_sql = "CALL sp_du_mob_noti_flag("+Utility.checkVal(form_no)+", "+
					Utility.checkVal(hh_cd)+", "+
					Utility.checkVal(child_cd)+", "+
					Utility.checkVal(creche_cd)+", "+
					Utility.checkVal(rec_upd_dttime)+", "+
					Utility.checkVal(users_nm)+")";
			lst_data = DataFetcher.getProcData(mst_sql);
			
			if (lst_data.get(0)[0].equalsIgnoreCase("1")) {
				json_resp.put("status", "done");
				response.getWriter().print(json_resp);
			} else if (lst_data.get(0)[0].equalsIgnoreCase("0")) {
				json_resp.put("status", "error");
				response.getWriter().print(json_resp);
			} else {
				json_resp.put("status", "error");
				response.getWriter().print(json_resp);
			}
		} catch (NoRecordFoundException e) {
			log.info("Error to update Notification Data for Mobile..."+e.getLocalizedMessage());
			response.getWriter().print("no_data");
		}
			
	}
	

}

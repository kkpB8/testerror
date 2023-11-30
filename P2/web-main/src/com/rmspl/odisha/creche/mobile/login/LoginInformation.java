package com.rmspl.odisha.creche.mobile.login;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;

import com.rmspl.app.data.service.DataFetcher;
import com.rmspl.app.data.service.NoRecordFoundException;
import com.rmspl.odisha.creche.mobile.util.Utility;

/**
 * Servlet implementation class User Login
 */
public class LoginInformation extends HttpServlet {
	/**
	 * version identifier for a Serializable class
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Write log
	 */
	private static Log log = LogFactory.getLog(LoginInformation.class);

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		/*
		1. var_user_nm		- takes user name information.
		2. var_pwd			- takes password.
		3. var_imei			* takes imei.
		3. var_reg_id		- takes registration id.
		*/
		
		//User Name
		String user_name = request.getParameter("user_name");
		//Password
		String user_pwd = request.getParameter("user_pwd");
		//IMEI
		String imei = request.getParameter("imei");
		//Registration ID
		String reg_id = request.getParameter("reg_id");
		
		try {
			String[][] datas = null;
			try {
				//Processing District, Block, GP, Village and Creche Master Data for Mobile
				List<String[]> lst_data = DataFetcher.getProcData("CALL sp_df_tab_usr_login("+Utility.checkVal(user_name)+", "+Utility.checkVal(user_pwd)+")");
				
				if (lst_data.get(0)[0].equalsIgnoreCase("no_user")) {
					response.getWriter().print("no_user");		
				} else if (lst_data.get(0)[0].equalsIgnoreCase("user_pwd")) {
					response.getWriter().print("user_pwd");		
				} else if (lst_data.get(0)[0].equalsIgnoreCase("user_del")) {
					response.getWriter().print("user_del");			
				} else if (lst_data.get(0)[0].equalsIgnoreCase("user_log")) {
					response.getWriter().print("user_log");			
				} else {
					datas = new String[lst_data.size()][lst_data.get(0).length];
					for (int i = 0; i < datas.length; i++) {
						for (int j = 0; j < datas[i].length; j++) {
							datas[i][j] = lst_data.get(i)[j];
						}
					}
					JSONArray jdatas = (JSONArray) JSONSerializer.toJSON(datas);
					response.setCharacterEncoding("UTF-8");
					response.getWriter().print(jdatas);	
				}
			} catch (NoRecordFoundException e) {
				log.info("Error to get Master Data for Mobile..."+e.getLocalizedMessage());
				response.getWriter().print("no_data");
			}
		} catch (Exception e) {
			log.info("Error to login with user information...Message :"+e.getLocalizedMessage()+" Cause :"+e.getCause());
			response.getWriter().print("N/A");
		}		
	}
}

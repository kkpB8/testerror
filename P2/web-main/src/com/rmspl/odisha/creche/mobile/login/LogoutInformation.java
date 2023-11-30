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
 * Servlet implementation class User Logout
 */
public class LogoutInformation extends HttpServlet {
	/**
	 * version identifier for a Serializable class
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Write log
	 */
	private static Log log = LogFactory.getLog(LogoutInformation.class);

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		/*
		1. var_user_nm		- takes user name information.
		2. var_pwd			- takes password.
		*/
		
		//User Name
		String user_name = request.getParameter("user_name");
		//Password
		String user_pwd = request.getParameter("user_pwd");
		
		try {
			String[][] datas = null;
			try {
				//Logout for Mobile
				List<String[]> lst_data = DataFetcher.getProcData("CALL sp_df_tab_usr_logout("+Utility.checkVal(user_name)+", "+Utility.checkVal(user_pwd)+")");
				
				if (lst_data.get(0)[0].equalsIgnoreCase("1")) {
					response.getWriter().print("done");		
				} else {
					response.getWriter().print("error");	
				}
			} catch (NoRecordFoundException e) {
				log.info("Error to Logout for Mobile..."+e.getLocalizedMessage());
				response.getWriter().print("error");
			}
		} catch (Exception e) {
			log.info("Error to logout for Mobile...Message :"+e.getLocalizedMessage()+" Cause :"+e.getCause());
			response.getWriter().print("N/A");
		}		
	}
}

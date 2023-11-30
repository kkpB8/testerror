package com.rmspl.odisha.creche.mobile.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.rmspl.app.data.service.DataFetcher;
import com.rmspl.odisha.creche.mobile.util.Utility;

/**
 * Servlet implementation class to change Password
 */
public class PasswordChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(PasswordChange.class);
	
	/**
	 * Post request to change User's Password
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String user_name = request.getParameter("user_name");
		String curr_pwd = request.getParameter("curr_pwd");
		String conf_new_pwd = request.getParameter("conf_new_pwd");
		
		try {
			String status = DataFetcher.getProcData("CALL sp_du_tab_usr_pw_chnge("+Utility.checkVal(user_name)+", "+
																			 	   Utility.checkVal(curr_pwd)+", "+
																			 	   Utility.checkVal(conf_new_pwd)+", "+
																			 	   "'"+com.rmspl.odisha.creche.utility.Utility.getCurrentDateTime()+"')").get(0)[0];
			
			if(status.equalsIgnoreCase("0")) {
				response.getWriter().print("wrong_password");
			} else if(status.equalsIgnoreCase("1")) {
				response.getWriter().print("done");
			} else {
				response.getWriter().print("N/A");
			}
			return;			
		} catch (Exception e) {
			log.info("Error to Change Password..."+e.getLocalizedMessage()+"-------"+e.getMessage());
			response.getWriter().print("N/A");
			return;
		}	
	}
}

package com.rmspl.odisha.creche.app.profile;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.rmspl.app.data.service.DataFetcher;
import com.rmspl.odisha.creche.utility.Utility;

/**
 * Servlet implementation class to change Password
 */
public class ChangePasswordWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(ChangePasswordWeb.class);
	
	/**
	 * Post request to change User's Password
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String user_name = request.getRemoteUser();		
		String curr_pwd = request.getParameter("curr_pwd");
		String conf_pwd = request.getParameter("conf_pwd");
		//log.info(user_name+"..."+curr_pwd+"..."+conf_pwd);
		
		try {
			String status = DataFetcher.getProcData("CALL sp_du_web_usr_pw_chnge("+Utility.checkVal(user_name)+", "+
																			 Utility.checkVal(curr_pwd)+", "+
																			 Utility.checkVal(conf_pwd)+", "+
																			 Utility.checkVal(Utility.getCurrentDateTime())+")").get(0)[0];
			
			response.getWriter().print(status);	
			return;			
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Error to Change Password..."+e.getLocalizedMessage()+"-------"+e.getMessage());
			response.getWriter().print("N/A");
			return;
		}	
	}
}

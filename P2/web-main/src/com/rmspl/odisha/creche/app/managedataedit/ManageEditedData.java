package com.rmspl.odisha.creche.app.managedataedit;

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
 * Servlet implementation class to manage Edited data after Approve Reject
 */
public class ManageEditedData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(ManageEditedData.class);
	
	/**
	 * Post request to change User's Password
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mnth_yr = request.getParameter("mnth_yr");
		String form_id = request.getParameter("form_id");
		String dttm = request.getParameter("dttm");
		String code = request.getParameter("code");
		String sl_no = request.getParameter("sl_no");
		String ed_cur_stat = request.getParameter("ed_cur_stat");
		String edit_user = request.getParameter("edit_user");
		String ed_cur_dt = request.getParameter("ed_cur_dt");
		String remarks = request.getParameter("remarks");
		
		try {
			
			/*
			 	The Procedure will update the Edited Dataset (Approve/Reject).
				Parameters used:
			
				1. var_mnth_yr - takes month year.
				2. var_form_id - takes form id.
				3. var_dttime - takes uploaded date time.
				4. var_code - takes household code/ child code/ creche code.
				5. var_sl_no - takes household couple no/ week no.
				6. var_ed_cur_stat - takes 'A' for Approval and 'R' for Rejection.
				7. var_edit_user - takes the user name who approves or rejects the dataset.
				8. var_ed_cur_dt - takes the date and time of approval or rejection.
				9. var_remarks - takes remarks of the user mainly for rejection of the dataset.
			 
			*/
			
			remarks = Utility.checkVal(remarks);
			remarks = remarks.equalsIgnoreCase("NULL")?"'N/A'":remarks;
			
			String status = DataFetcher.getProcData("CALL sp_du_data_edit_appr_rejct("+Utility.checkVal(mnth_yr)+", "+
																				Utility.checkVal(form_id)+", "+
																			 	Utility.checkVal(dttm)+", "+
																			 	Utility.checkVal(code)+", "+
																			 	Utility.checkVal(sl_no)+", "+
																			 	Utility.checkVal(ed_cur_stat)+", "+																			 	
																			 	Utility.checkVal(edit_user)+", '"+																		 	
																			 	//Utility.checkVal(ed_cur_dt)+", '"+
																			 	Utility.getCurrentDateTime()+"', "+
																			 	remarks+")").get(0)[0];
			response.getWriter().print(status);	
			return;			
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Error to manage Edited data after Approve/Reject..."+e.getLocalizedMessage()+"-------"+e.getMessage());
			response.getWriter().print("N/A");
			return;
		}	
	}
}

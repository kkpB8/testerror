package com.rmspl.odisha.creche.app.managedataedit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.rmspl.app.data.service.DataFetcher;
import com.rmspl.app.data.service.NoRecordFoundException;
import com.rmspl.odisha.creche.utility.Utility;

import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;

/**
 * Servlet implementation for populate Data Logs
 */
public class DataManagePopulator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * Write Log
	 */
	private static Log log = LogFactory.getLog(DataManagePopulator.class);
       
	/**
	 * GET Request to populate Data Logs
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String mnth_yr = request.getParameter("mnth_yr");
			String form_id = request.getParameter("form_id");
			String dttm = request.getParameter("dttm");
			String code = request.getParameter("code");
			String sl_no = request.getParameter("sl_no");
			
			/*
			String str_sql = "CALL sp_df_form_edit_manage("+
														Utility.checkVal(form_type)+", "+
														Utility.checkVal(sel_mnth_yr)+", "+
														Utility.checkVal(sel_dt)+", "+
														Utility.checkVal(sel_bk)+", "+
														Utility.checkVal(sel_gp)+", "+
														Utility.checkVal(sel_vl)+", "+
														Utility.checkVal(sel_cr)+", "+
														Utility.checkVal(sel_form_id)+
														")";
			*/
			String str_sql = "CALL sp_df_data_edit_pop("+
														Utility.checkVal(mnth_yr)+", "+
														Utility.checkVal(form_id)+", "+
														Utility.checkVal(dttm)+", "+
														Utility.checkVal(code)+", "+
														Utility.checkVal(sl_no)+
														")";
			List<String[]> lstdata = new ArrayList<String[]>();
			lstdata = DataFetcher.getProcData(str_sql);			
						
			String[][] datas = null;
			datas = new String[lstdata.size()][lstdata.get(0).length];
			for (int i = 0; i < datas.length; i++) {
				for (int j = 0; j < datas[i].length; j++) {
					datas[i][j] = lstdata.get(i)[j];
				}
			}
			JSONArray jdatas = (JSONArray) JSONSerializer.toJSON(datas);
			response.getWriter().print(jdatas);			
		} catch(NoRecordFoundException e){
			log.info("Error to get data From DB ... Cause : "+e.getLocalizedMessage());
			response.getWriter().print("N/A");
		} catch (Exception e) { 
			response.getWriter().print("N/A");
		}	
	}
}

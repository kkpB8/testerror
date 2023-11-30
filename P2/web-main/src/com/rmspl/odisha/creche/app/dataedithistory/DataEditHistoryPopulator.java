package com.rmspl.odisha.creche.app.dataedithistory;

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
public class DataEditHistoryPopulator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * Write Log
	 */
	private static Log log = LogFactory.getLog(DataEditHistoryPopulator.class);
       
	/**
	 * GET Request to populate Data Logs
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String form_id = request.getParameter("form_id");
			String sel_mnth_yr = request.getParameter("sel_mnth_yr");
			String sel_dt = request.getParameter("sel_dt");
			String sel_bk = request.getParameter("sel_bk");
			String sel_gp = request.getParameter("sel_gp");
			String sel_vl = request.getParameter("sel_vl");
			String sel_cr = request.getParameter("sel_cr");
			
			String str_sql = "CALL sp_df_form_edit_hist("+
														Utility.checkVal(form_id)+", "+
														Utility.checkVal(sel_mnth_yr)+", "+
														Utility.checkVal(sel_dt)+", "+
														Utility.checkVal(sel_bk)+", "+
														Utility.checkVal(sel_gp)+", "+
														Utility.checkVal(sel_vl)+", "+
														Utility.checkVal(sel_cr)+
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

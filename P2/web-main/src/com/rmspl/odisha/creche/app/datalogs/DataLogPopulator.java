package com.rmspl.odisha.creche.app.datalogs;

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
public class DataLogPopulator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * Write Log
	 */
	private static Log log = LogFactory.getLog(DataLogPopulator.class);
       
	/**
	 * GET Request to populate Data Logs
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String sel_mnth_yr = request.getParameter("sel_mnth_yr");
			
			String str_sql = "CALL sp_df_form_data_log("+Utility.checkVal(request.getRemoteUser())+", "+
														 Utility.checkVal(sel_mnth_yr)+")";
			
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

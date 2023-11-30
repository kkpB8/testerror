package com.rmspl.odisha.creche.app.overview;

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
 * Servlet implementation for Overview Chart
 */
public class PopChartOverview extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * Write Log
	 */
	private static Log log = LogFactory.getLog(PopChartOverview.class);
       
	/**
	 * GET Request to populate Data for Column Chart
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String sel_fltr_level = request.getParameter("sel_fltr_level");
			String sel_fltr_level_code = request.getParameter("sel_fltr_level_code");
			String sel_ovr_sub_grp = request.getParameter("sel_ovr_sub_grp");
			String indi_id = request.getParameter("indi_id");			
			String sel_mnth_yr = request.getParameter("sel_mnth_yr");
			String sel_period = request.getParameter("sel_period");
			String str_sel_creche_catg = request.getParameter("sel_creche_catg"); //# 27.01.2022
			
			String str_sql="";
			//# For All Creche
			if (str_sel_creche_catg.equalsIgnoreCase("All")) {
				str_sql = "CALL sp_df_hp_ovrview_pop("+Utility.checkVal(sel_fltr_level)+", "+
						  Utility.checkVal(sel_fltr_level_code)+", "+
						  Utility.checkVal(sel_ovr_sub_grp)+", "+
						  Utility.checkVal(indi_id)+", "+
						  Utility.checkVal(sel_mnth_yr)+", "+
						  Utility.checkVal(sel_period)+")";
			}
			//# For OPNIP/APF-PHRS
			else {
				str_sql = "CALL sp_df_hp_ovrview_pop_cr("+Utility.checkVal(sel_fltr_level)+", "+
						  Utility.checkVal(sel_fltr_level_code)+", "+
						  Utility.checkVal(sel_ovr_sub_grp)+", "+
						  Utility.checkVal(indi_id)+", "+
						  Utility.checkVal(sel_mnth_yr)+", "+
						  Utility.checkVal(sel_period)+", "+
						  Utility.checkVal(str_sel_creche_catg)+")";
			}
			
			
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

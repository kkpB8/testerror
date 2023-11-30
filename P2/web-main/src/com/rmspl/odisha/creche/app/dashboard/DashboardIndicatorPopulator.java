package com.rmspl.odisha.creche.app.dashboard;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;

import com.rmspl.app.data.service.DataFetcher;

import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;

/**
 * Servlet implementation to populate indicator for Monitoring Indicator
 */
public class DashboardIndicatorPopulator extends HttpServlet {
	
	/**
	 * version identifier for a Serializable class
	 */
	private static final long serialVersionUID = 1L;
	
	private static Log log = LogFactory.getLog(DashboardIndicatorPopulator.class);

	/**
	 * method to populate Block Names
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[][] datas = null;
		try {
			List<String[]> lstdata = DataFetcher.getProcData("CALL sp_df_hp_dashboard_indi_pop('"+
																request.getParameter("sel_fltr_level")+"', '"+
																//request.getParameter("sel_dsh_grp")+"', '"+
																request.getParameter("sel_dsh_sub_grp")+"')");
			datas = new String[lstdata.size()][lstdata.get(0).length];			
			for (int i = 0; i < datas.length; i++) {
				for (int j = 0; j < datas[i].length; j++) {
					datas[i][j] = lstdata.get(i)[j];
				}
			}
			JSONArray jdatas = (JSONArray) JSONSerializer.toJSON(datas);
			response.getWriter().print(jdatas);
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print("N/A");
		}
	}
}

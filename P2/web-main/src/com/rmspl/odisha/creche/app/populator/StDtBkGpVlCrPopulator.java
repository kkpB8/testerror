package com.rmspl.odisha.creche.app.populator;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation to populate Industrial Park And Unit
 */
public class StDtBkGpVlCrPopulator extends HttpServlet {
	
	/**
	 * version identifier for a Serializable class
	 */
	private static final long serialVersionUID = 1L;
	
	private static Log log = LogFactory.getLog(StDtBkGpVlCrPopulator.class);

	/**
	 * method to populate Block Names
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[][] datas = null;
		try {
			List<String[]> lstdata = DataFetcher.getProcData("CALL sp_df_stdt_bkgp_vlcr_pop()");
			
			List<String[]> lstdata_new = new ArrayList<String[]>();
			
			if(request.isUserInRole("super_user")) {
				lstdata_new = lstdata;
			}
			else if(request.isUserInRole("st_user")) {
				lstdata_new = lstdata;
			}
			else if(request.isUserInRole("dt_user")) {
				String dt_code = request.getSession().getAttribute("user_dt").toString();
				for (String[] strings : lstdata) {
					if(strings[2].equalsIgnoreCase(dt_code)) {
						lstdata_new.add(strings);
					}					
				}
			}
			else if(request.isUserInRole("bk_user")) {
				String dt_code = request.getSession().getAttribute("user_dt").toString();
				String bk_code = request.getSession().getAttribute("user_bk").toString();
				for (String[] strings : lstdata) {
					if(strings[2].equalsIgnoreCase(dt_code)
							&& strings[4].equalsIgnoreCase(bk_code)) {
						lstdata_new.add(strings);
					}					
				}
			}
			//# 18.01.2022
			else if(request.isUserInRole("gp_user")) {
				String dt_code = request.getSession().getAttribute("user_dt").toString();
				String bk_code = request.getSession().getAttribute("user_bk").toString();
				String gp_code = request.getSession().getAttribute("user_gp").toString();
				for (String[] strings : lstdata) {
					if(strings[2].equalsIgnoreCase(dt_code)
							&& strings[4].equalsIgnoreCase(bk_code)
								&& strings[6].equalsIgnoreCase(gp_code)) {
						lstdata_new.add(strings);
					}					
				}
			}
			//-------------------------------Data preparation with JSON Object-------------------------------//
			
			
			datas = new String[lstdata_new.size()][lstdata_new.get(0).length];			
			for (int i = 0; i < datas.length; i++) {
				for (int j = 0; j < datas[i].length; j++) {
					datas[i][j] = lstdata_new.get(i)[j];
				}
			}
			
			JSONArray jdatas = (JSONArray) JSONSerializer.toJSON(datas);
			response.getWriter().print(jdatas);
			
			//-------------------------------Data preparation as per Database return-------------------------------//
			
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print("N/A");
		}
	}
}

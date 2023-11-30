package com.rmspl.odisha.creche.app.user.populator;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rmspl.app.data.service.DataFetcher;
import com.rmspl.odisha.creche.utility.Utility;

import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;

/**
 * Servlet implementation to populate Tablet User for modify
 */

public class TabletUserPopulatorForModify extends HttpServlet {
	/**
	 * version identifier for a Serializable class
	 */
	private static final long serialVersionUID = 1L;
       
	/**
	 * Get Request to delete Tablet User
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[][] datas = null;
		try {
			List<String[]> lstdata = null;			
			
			lstdata = DataFetcher.getProcData("CALL sp_df_tab_usr_dt_pop("+											
											    Utility.checkVal(request.getParameter("level"))+", "+
												Utility.checkVal(request.getParameter("dt_code"))+
												")");
			if(lstdata.size() == 0) {
				response.getWriter().print("N/A");
				return;
			}						
			datas = new String[lstdata.size()][lstdata.get(0).length];
			for (int i = 0; i < datas.length; i++) {
				for (int j = 0; j < datas[i].length; j++) {
					datas[i][j] = lstdata.get(i)[j];
				}
			}	
			JSONArray jdatas = (JSONArray) JSONSerializer.toJSON(datas);
			response.getWriter().print(jdatas);
		} catch (Exception e) { 
			response.getWriter().print("N/A");
		}
	}
}

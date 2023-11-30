package com.rmspl.odisha.creche.app.report;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.rmspl.app.data.service.DataFetcher;

import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;

/**
 * Servlet implementation for populate Nutritional Status
 */

public class ChildInfoPopulator extends HttpServlet {
	/**
	 * version identifier for a Serializable class
	 */
	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(ChildInfoPopulator.class);
       
	/**
	 * method  for populate child info
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[][] datas = null;
		String child_code = request.getParameter("child_code");
		try {
			List<String[]> lstdata = DataFetcher.getProcData("CALL  sp_df_child_info('"+child_code+"')");
			datas = new String[lstdata.size()][lstdata.get(0).length];
			for (int i = 0; i < datas.length; i++) {
				for (int j = 0; j < datas[i].length; j++) {
					if (lstdata.get(i)[j].equalsIgnoreCase("N/A")) {
						datas[i][j] = "-";
					} else {
						datas[i][j] = lstdata.get(i)[j];
					}
				}
			}	
			JSONArray jdatas = (JSONArray) JSONSerializer.toJSON(datas);
			response.getWriter().print(jdatas);
		} catch (Exception e) { 
			response.getWriter().print("N/A");
		}
	}
}

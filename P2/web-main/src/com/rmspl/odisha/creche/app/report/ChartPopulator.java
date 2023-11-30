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


/**
 * Servlet implementation for populate Nutritional Status
 */

public class ChartPopulator extends HttpServlet {
	/**
	 * version identifier for a Serializable class
	 */
	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(ChartPopulator.class);
       
	/**
	 * method  for populate sector names in web page
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//String[][] datas = null;
		String mode = request.getParameter("mode");
		String child_code = request.getParameter("child_code");
		try {
			List<String[]> lstdata = DataFetcher.getProcData("CALL  sp_df_child_chart('"+mode+"', '"+ child_code+"')");
			//datas = new String[lstdata.size()][lstdata.get(0).length];
			String data = "[";
			for (int i = 0; i < lstdata.size(); i++) {
				data = data + "[";
				for (int j = 0; j < lstdata.get(i).length; j++) {
					
					String strTemp = null;
					if (lstdata.get(i)[j].equalsIgnoreCase("N/A") || lstdata.get(i)[j] == null) {
						strTemp = "";
					} else {
						
						if(j==9) {
							strTemp = "<a>"+lstdata.get(i)[j]+"</a>"; 
						} else {
							strTemp = lstdata.get(i)[j]; 
						}
					}
					
					
					if (j == 9) {
						data = data + "'"+strTemp + "'],";
					} else {
						data = data + strTemp + ",";
					}
					//System.out.println("lstdata.get("+i+")["+j+"]: "+strTemp);
				}
			}
			String finalData = data.substring(0, data.length() - 1) + "]";
			
			//JSONArray jdatas = (JSONArray) JSONSerializer.toJSON(datas);
			response.getWriter().print(finalData);
		} catch (Exception e) { 
			response.getWriter().print("N/A");
		}
	}
}

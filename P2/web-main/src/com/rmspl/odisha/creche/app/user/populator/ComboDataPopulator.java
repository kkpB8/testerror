package com.rmspl.odisha.creche.app.user.populator;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;
import com.rmspl.app.data.service.DataFetcher;

/**
 * Servlet implementation to populate combo data
 */
public class ComboDataPopulator extends HttpServlet {
	
	private static Log log = LogFactory.getLog(DataFetcher.class);
	/**
	 * version identifier for a Serializable class
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * method to populate combo data
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[][] datas = null;
		try {
			String type = request.getParameter("type");
			String code = request.getParameter("code");
			String str_sql = "";
			
			if(type.equalsIgnoreCase("selDist")) {
				str_sql = "CALL sp_df_dt_bk_pop()";
			}
			else if(type.equalsIgnoreCase("selMPA")) {
				str_sql = "CALL sp_df_mpa_pop()";
			}
			
			List<String[]> lstdata = DataFetcher.getProcData(str_sql);
			//log.info(str_sql + " : " + lstdata.size());
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

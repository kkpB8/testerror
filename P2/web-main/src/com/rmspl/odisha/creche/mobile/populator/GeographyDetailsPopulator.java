package com.rmspl.odisha.creche.mobile.populator;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;

import com.rmspl.app.data.service.DataFetcher;
import com.rmspl.app.data.service.NoRecordFoundException;
import com.rmspl.odisha.creche.mobile.util.Utility;

/**
 * Servlet implementation class Geography Details Populator
 */
public class GeographyDetailsPopulator extends HttpServlet {
	/**
	 * version identifier for a Serializable class
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Write log
	 */
	private static Log log = LogFactory.getLog(GeographyDetailsPopulator.class);

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//User Name
		String user_name = request.getParameter("user_name");
		
		String[][] datas = null;
		try {
			//Processing District, Block, GP, Village and Creche Master Data for Mobile
			List<String[]> lst_data = DataFetcher.getProcData("CALL sp_df_tab_usr_geo_dtls_sync("+Utility.checkVal(user_name)+")");
			datas = new String[lst_data.size()][lst_data.get(0).length];
			for (int i = 0; i < datas.length; i++) {
				for (int j = 0; j < datas[i].length; j++) {
					datas[i][j] = lst_data.get(i)[j];
				}
			}
			JSONArray jdatas = (JSONArray) JSONSerializer.toJSON(datas);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(jdatas);	
		} catch (NoRecordFoundException e) {
			log.info("Error to get Master Data for Mobile..."+e.getLocalizedMessage());
			response.getWriter().print("no_data");
		}
	}
}

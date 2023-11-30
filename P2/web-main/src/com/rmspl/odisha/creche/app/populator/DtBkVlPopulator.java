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
import org.json.simple.JsonObject;

import com.rmspl.app.data.service.DataFetcher;
import com.rmspl.app.data.service.NoRecordFoundException;

import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;

/**
 * Servlet implementation for populate all the District-Block-Village
 */

public class DtBkVlPopulator extends HttpServlet {
	/**
	 * version identifier for a Serializable class
	 */
	private static final long serialVersionUID = 1L;
	
	private static Log log = LogFactory.getLog(DtBkVlPopulator.class);
       
	/**
	 * Get Request to populate all District Names
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String[][] datas = null;
		List<String[]> lst_data = null;
		
		try {
			lst_data = DataFetcher.getProcData("CALL sp_df_add_geography('"+request.getParameter("type")+"')");
			
			List<String[]> lstdata_new = new ArrayList<String[]>();
			
			if(request.isUserInRole("super_user")) {
				lstdata_new = lst_data;
			}
			else if(request.isUserInRole("st_user")) {
				lstdata_new = lst_data;
			}
			else if(request.isUserInRole("dt_user")) {
				String dt_code = request.getSession().getAttribute("user_dt").toString();
				for (String[] strings : lst_data) {
					if(strings[0].equalsIgnoreCase(dt_code)) {
						lstdata_new.add(strings);
					}					
				}
			}
			else if(request.isUserInRole("bk_user")) {
				String dt_code = request.getSession().getAttribute("user_dt").toString();
				String bk_code = request.getSession().getAttribute("user_bk").toString();
				for (String[] strings : lst_data) {
					if(strings[0].equalsIgnoreCase(dt_code)
							&& strings[2].equalsIgnoreCase(bk_code)) {
						lstdata_new.add(strings);
					}					
				}
			}
			
			/*datas = new String[lst_data.size()][lst_data.get(0).length];			
			for (int i = 0; i < datas.length; i++) {
				for (int j = 0; j < datas[i].length; j++) {
					datas[i][j] = lst_data.get(i)[j];
				}
			}*/
			
			datas = new String[lstdata_new.size()][lstdata_new.get(0).length];			
			for (int i = 0; i < datas.length; i++) {
				for (int j = 0; j < datas[i].length; j++) {
					datas[i][j] = lstdata_new.get(i)[j];
				}
			}
			
			JSONArray jdatas = (JSONArray) JSONSerializer.toJSON(datas);
			response.getWriter().print(jdatas);			
		} catch (NoRecordFoundException e) {
			log.error("Error to get information..."+e.getLocalizedMessage());
			response.getWriter().print("N/A");
		} catch (IOException e) { 
			log.error("Error to get information..."+e.getLocalizedMessage());
			response.getWriter().print("N/A");
		} catch (Exception e) { 
			log.error("Error to get information..."+e.getLocalizedMessage());
			response.getWriter().print("N/A");
		}	
	}
}

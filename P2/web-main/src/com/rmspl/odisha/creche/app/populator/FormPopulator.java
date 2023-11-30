package com.rmspl.odisha.creche.app.populator;

import java.io.IOException;
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
 * Servlet implementation for populate all the Forms
 */

public class FormPopulator extends HttpServlet {
	/**
	 * version identifier for a Serializable class
	 */
	private static final long serialVersionUID = 1L;
	
	private static Log log = LogFactory.getLog(FormPopulator.class);
       
	/**
	 * Get Request to populate all District Names
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String[][] datas = null;
		List<String[]> lst_data = null;
		
		try {
			lst_data = DataFetcher.getProcData("CALL sp_df_form_popu()");
			
			datas = new String[lst_data.size()][lst_data.get(0).length];			
			for (int i = 0; i < datas.length; i++) {
				for (int j = 0; j < datas[i].length; j++) {
					datas[i][j] = lst_data.get(i)[j];
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

package com.rmspl.odisha.creche.app.archive;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.rmspl.app.data.service.DataFetcher;
import com.rmspl.app.data.service.NoRecordFoundException;
import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;

/**
 * Servlet implementation for populate all the Clinic List
 */

public class UploadedFileListPopulator extends HttpServlet {
	/**
	 * version identifier for a Serializable class
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * to write log
	 */
	private static Log log = LogFactory.getLog(UploadedFileListPopulator.class);
       
	/**
	 * Get Request to populate all the Registered Clinic
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<String[]> lstdata = null;
		String[][] datas = null;
		
		try {
			lstdata = DataFetcher.getProcData("CALL sp_df_mst_pdf_upld()");
			datas = new String[lstdata.size()][lstdata.get(0).length];
			for (int i = 0; i < datas.length; i++) {
				for (int j = 0; j < datas[i].length; j++) {
					datas[i][j] = checkVal(lstdata.get(i)[j]);
				}
			}	
			JSONArray jdatas = (JSONArray) JSONSerializer.toJSON(datas);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(jdatas);
		} catch (NoRecordFoundException e) { 
			log.info("Error to get data from DB....."+e.getLocalizedMessage()+" Cause :"+e.getCause());
			response.getWriter().print("N/A");
		} catch (Exception e) { 
			log.info("Error to populate uploaded pdf file list...."+e.getLocalizedMessage()+" Cause :"+e.getCause());
			response.getWriter().print("N/A");
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param str_val
	 * @return str_val
	 */
	private String checkVal(String str_val) {
		if (str_val.contains("\n")) {
			str_val = str_val.replace("\n", "####").replace("\r", "####");
			//str_val = str_val.replaceAll("[\n\t]", "");
			//System.out.println("After Replace Enter: "+str_val);
		}
		return str_val;
	}
}

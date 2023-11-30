package com.rmspl.odisha.creche.mobile.sync;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;

import com.rmspl.app.data.service.ApkVersionMismatchException;
import com.rmspl.app.data.service.DataFetcher;
import com.rmspl.app.data.service.JsonParseException;
import com.rmspl.app.data.service.NoRecordFoundException;
import com.rmspl.app.misc.LogCreator;
import com.rmspl.odisha.creche.mobile.util.Utility;

import net.sf.json.JSONSerializer;

/**
 * Servlet implementation class Creche Committee Meeting Sync
 */
public class CrecheCommitteeMeetingSync extends HttpServlet {
	/**
	 * version identifier for a Serializable class
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Write log
	 */
	private static Log log = LogFactory.getLog(CrecheCommitteeMeetingSync.class);
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		
		
		String str_imei = request.getParameter("imei");
		String str_user_name = request.getParameter("user_name");
		
		String[][] datas = null;
		
		try {
			List<String[]> lst_data = DataFetcher.getProcData("CALL sp_df_creche_commit_meeting_pd("+Utility.checkVal(str_imei)+", "+Utility.checkVal(str_user_name)+")");
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
			log.info("Error to get Creche Committee Meeting Sync Data for Mobile..."+e.getLocalizedMessage());
			response.getWriter().print("no_data");
		}
	}
}

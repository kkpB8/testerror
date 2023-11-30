package com.rmspl.odisha.creche.mobile.sync;

import java.util.List;
import java.io.File;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;

import com.rmspl.app.data.service.DataFetcher;
import com.rmspl.app.data.service.NoRecordFoundException;
import com.rmspl.odisha.creche.mobile.util.Utility;

import net.sf.json.JSONSerializer;

/**
 * Servlet implementation class Child Sync
 */
public class ChildSync extends HttpServlet {
	/**
	 * version identifier for a Serializable class
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * path of temporary directory
	 */
	private static final String TMP_DIR_PATH = FileUtils.getTempDirectoryPath();
	/**
	 * temporary director to confirm whether path exists or not
	 */
	private File tmpDir;
	/**
	 * path of uploaded files
	 */
	private static final String DESTINATION_DIR_PATH ="/rtdas_data";
	/**
	 * directory for uploaded files
	 */
	private File destinationDir;
	/**
	 * Write log
	 */
	private static Log log = LogFactory.getLog(ChildSync.class);
	
	/**
	 * Setting the uploaded File Directory path before servlet accepts any request 
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		tmpDir = new File(TMP_DIR_PATH);
		
		if(!tmpDir.isDirectory()) {
			throw new ServletException(TMP_DIR_PATH + " is not a directory");
		}
		String realPath = getServletContext().getInitParameter("FilePath");
		destinationDir = new File(realPath);
		if(!destinationDir.isDirectory()) {
			throw new ServletException(DESTINATION_DIR_PATH+" is not a directory");
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		
		
		String str_imei = request.getParameter("imei");
		String str_user_name = request.getParameter("user_name");
		
		String[][] datas = null;
		
		try {
			List<String[]> lst_data = DataFetcher.getProcData("CALL sp_df_child_dtl_pd("+Utility.checkVal(str_imei)+", "+Utility.checkVal(str_user_name)+")");
			datas = new String[lst_data.size()][lst_data.get(0).length];
			for (int i = 0; i < datas.length; i++) {
				for (int j = 0; j < datas[i].length; j++) {
					if(j == 36) {
						if(lst_data.get(i)[j].equalsIgnoreCase("N/A")) {
							datas[i][j] = "";
						} else {
							File file_img = new File(destinationDir+"/"+lst_data.get(i)[j]+".jpg");
							if(file_img.exists()) {
								String ImageString = Utility.getBase64Image(file_img);
								datas[i][j] = ImageString;
							} else {
								datas[i][j] = "";
							}							
						}						
					} else {
						datas[i][j] = lst_data.get(i)[j];
					}
					//datas[i][j] = lst_data.get(i)[j];
				}
			}
			JSONArray jdatas = (JSONArray) JSONSerializer.toJSON(datas);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(jdatas);	
		} catch (NoRecordFoundException e) {
			log.info("Error to get Child Data for Mobile..."+e.getLocalizedMessage());
			response.getWriter().print("no_data");
		}
	}
}

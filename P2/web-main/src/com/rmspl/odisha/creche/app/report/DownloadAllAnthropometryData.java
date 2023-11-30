package com.rmspl.odisha.creche.app.report;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DownloadAllAnthropometryData extends HttpServlet {	

    private static final long serialVersionUID = 1L;
    private static final String TMP_DIR_PATH = FileUtils.getTempDirectoryPath();
    private File tmpDir;
    private static final String DESTINATION_DIR_PATH = "/excel_template";
    private static final String DESTINATION_DIR_DOWNLOAD_PATH = "/rtdas_data";
    private File destinationDir;
    private File destinationDownloadDir;
    
    private static Log log = LogFactory.getLog(DownloadAllAnthropometryData.class);
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        tmpDir = new File(TMP_DIR_PATH);
		
		if(!tmpDir.isDirectory()) {
			throw new ServletException(TMP_DIR_PATH + " is not a directory");
		}
		String realPath = getServletContext().getRealPath(DESTINATION_DIR_PATH);
		String realDownloadPath = getServletContext().getRealPath(DESTINATION_DIR_DOWNLOAD_PATH);
		destinationDir = new File(realPath);
		destinationDownloadDir = new File(realDownloadPath);
		if(!destinationDir.isDirectory()) {
			throw new ServletException(DESTINATION_DIR_PATH+" is not a directory");
		}
		if(!destinationDownloadDir.isDirectory()) {
			throw new ServletException(DESTINATION_DIR_DOWNLOAD_PATH+" is not a directory");
		}
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			/*String json_data = request.getParameter("json_data");
			//log.info(">>>>>>>>"+json_data);
			JSONParser parser = new JSONParser();
			Object object = new Object();
			object = parser.parse(json_data);
			JSONObject json_param_set_obj = (JSONObject) object;
			
			String user_type = json_param_set_obj.get("user_type").toString();
			String map_id = json_param_set_obj.get("map_id").toString();
			String rept_type = json_param_set_obj.get("rept_type").toString();
			String sel_period = json_param_set_obj.get("sel_period").toString();
			String sel_catg = json_param_set_obj.get("sel_catg").toString();
			String sel_mnth_yr = json_param_set_obj.get("sel_mnth_yr").toString();
			String sel_mnth_yr_start = json_param_set_obj.get("sel_mnth_yr_start").toString();*/
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
			sdf.setTimeZone(TimeZone.getTimeZone("IST"));
			String str_cur_date = sdf.format(new Date());	
			
			String excel_template_name = null;
			String fileName = null;
			String str_session_id = request.getSession().getId();
			Integer start_row = null;
			
			excel_template_name = "all_anthropometry_data.xlsx";
			fileName = "All_Anthropometry_Data_"+str_cur_date+".xlsx";
			start_row = 1;
										
			new DownloadAllAnthropometryDataExcelWriter().PrepareExcel(str_session_id, 
														 				destinationDir, 
														 				destinationDownloadDir, 
														 				excel_template_name, 
														 				fileName,														 
														 				start_row);
					
			//download file option
			response.setContentType("text/plain");		
			response.setHeader("Content-Disposition", "attachment;filename="+fileName.trim());
			ServletContext ctx = getServletContext();
			InputStream is = ctx.getResourceAsStream("rtdas_data/"+str_session_id+fileName.trim());
			int read=0;
			byte[] bytes = new byte[1024];
			OutputStream os = response.getOutputStream();
			while((read = is.read(bytes))!= -1){			
				os.write(bytes, 0, read);
			}
			
			is.close();
			os.flush();
			os.close();
			
			File file = new File(destinationDownloadDir.getAbsolutePath()+"/"+str_session_id+fileName.trim());
			if (file.exists()) {
				file.delete();
			}			
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print("N/A");
		}
	}	
}

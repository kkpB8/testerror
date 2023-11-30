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

public class DownloadBulkReport extends HttpServlet {	

    private static final long serialVersionUID = 1L;
    private static final String TMP_DIR_PATH = FileUtils.getTempDirectoryPath();
    private File tmpDir;
    private static final String DESTINATION_DIR_PATH = "/excel_template";
    private static final String DESTINATION_DIR_DOWNLOAD_PATH = "/rtdas_data";
    private File destinationDir;
    private File destinationDownloadDir;
    
    private static Log log = LogFactory.getLog(DownloadBulkReport.class);
    
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
			String json_data = request.getParameter("json_data");
			//log.info(">>>>>>>>"+json_data);
			JSONParser parser = new JSONParser();
			Object object = new Object();
			object = parser.parse(json_data);
			JSONObject json_param_set_obj = (JSONObject) object;
			
			String rept_type = json_param_set_obj.get("selRptTypeBulk").toString();
			String selDist = json_param_set_obj.get("selDist").toString();
			String selYear = json_param_set_obj.get("selYear").toString();
			
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
			sdf.setTimeZone(TimeZone.getTimeZone("IST"));
			String str_cur_date = sdf.format(new Date());	
			
			String excel_template_name = null;
			String fileName = null;
			String str_session_id = request.getSession().getId();
			Integer start_row = null;
			
			//Houselisting Details
			if(rept_type.equalsIgnoreCase("01")) {
				excel_template_name = "Houselisting_Details.xlsx";
				fileName = "Houselisting_Details_"+str_cur_date+".xlsx";
				start_row = 2;
			} 
			//Child Details
			else if(rept_type.equalsIgnoreCase("02")) {
				excel_template_name = "Child_Details.xlsx";
				fileName = "Child_Details_"+str_cur_date+".xlsx";
				start_row = 2;
			} 
			//Entry Register
			else if(rept_type.equalsIgnoreCase("03")) {
				excel_template_name = "Entry_Register.xlsx";
				fileName = "Entry_Register_"+str_cur_date+".xlsx";
				start_row = 2;
			} 
			//Monthly Anthropometry
			else if(rept_type.equalsIgnoreCase("04")) {
				excel_template_name = "all_anthropometry_data.xlsx";
				fileName = "Monthly_Anthropometry_"+str_cur_date+".xlsx";
				start_row = 2;
			} 
			//Monthly Attendance
			else if(rept_type.equalsIgnoreCase("05")) {
				excel_template_name = "Monthly_Attendance.xlsx";
				fileName = "Monthly_Attendance_"+str_cur_date+".xlsx";
				start_row = 2;
			} 
			//Red Flag Follow-up
			else if(rept_type.equalsIgnoreCase("06")) {
				excel_template_name = "Red_Flag_Followup.xlsx";
				fileName = "Red_Flag_Followup_"+str_cur_date+".xlsx";
				start_row = 2;
			} 
			
			
			new DownloadBulkReportExcelWriter().PrepareExcel(str_session_id, 
														 destinationDir, 
														 destinationDownloadDir, 
														 excel_template_name, 
														 fileName,
														 rept_type,
														 selDist,
														 selYear,
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

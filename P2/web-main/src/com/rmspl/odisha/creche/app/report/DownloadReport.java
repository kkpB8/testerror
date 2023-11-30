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

public class DownloadReport extends HttpServlet {	

    private static final long serialVersionUID = 1L;
    private static final String TMP_DIR_PATH = FileUtils.getTempDirectoryPath();
    private File tmpDir;
    private static final String DESTINATION_DIR_PATH = "/excel_template";
    private static final String DESTINATION_DIR_DOWNLOAD_PATH = "/rtdas_data";
    private File destinationDir;
    private File destinationDownloadDir;
    
    private static Log log = LogFactory.getLog(DownloadReport.class);
    
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
			
			String proj_type = json_param_set_obj.get("proj_type").toString();
			String user_type = json_param_set_obj.get("user_type").toString();
			String map_id = json_param_set_obj.get("map_id").toString();
			String rept_type = json_param_set_obj.get("rept_type").toString();
			String sel_period = json_param_set_obj.get("sel_period").toString();
			String sel_catg = json_param_set_obj.get("sel_catg").toString();
			String sel_mnth_yr = json_param_set_obj.get("sel_mnth_yr").toString();
			String sel_mnth_yr_start = json_param_set_obj.get("sel_mnth_yr_start").toString();
			
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
				fileName = "Houselisting_Details_"+proj_type+"_"+str_cur_date+".xlsx";
				start_row = 2;
			} 
			//Child Details
			else if(rept_type.equalsIgnoreCase("02")) {
				excel_template_name = "Child_Details.xlsx";
				fileName = "Child_Details_"+proj_type+"_"+str_cur_date+".xlsx";
				start_row = 2;
			} 
			//Entry Register
			else if(rept_type.equalsIgnoreCase("03")) {
				excel_template_name = "Entry_Register.xlsx";
				fileName = "Entry_Register_"+proj_type+"_"+str_cur_date+".xlsx";
				start_row = 2;
			} 
			//Monthly Anthropometry
			else if(rept_type.equalsIgnoreCase("04")) {
				excel_template_name = "Monthly_Anthropometry.xlsx";
				fileName = "Monthly_Anthropometry_"+proj_type+"_"+str_cur_date+".xlsx";
				start_row = 2;
			} 
			//Monthly Attendance
			else if(rept_type.equalsIgnoreCase("05")) {
				excel_template_name = "Monthly_Attendance.xlsx";
				fileName = "Monthly_Attendance_"+proj_type+"_"+str_cur_date+".xlsx";
				start_row = 2;
			} 
			//Red Flag Follow-up
			else if(rept_type.equalsIgnoreCase("06")) {
				excel_template_name = "Red_Flag_Followup.xlsx";
				fileName = "Red_Flag_Followup_"+proj_type+"_"+str_cur_date+".xlsx";
				start_row = 2;
			} 
			//List of Stunted Children - Moderate
			else if(rept_type.equalsIgnoreCase("07")) {
				excel_template_name = "List_of_Stunted_Children_Moderate.xlsx";
				fileName = "List_of_Stunted_Children_Moderate_"+proj_type+"_"+str_cur_date+".xlsx";
				start_row = 2;
			} 
			//List of Stunted Children - Severe
			else if(rept_type.equalsIgnoreCase("08")) {
				excel_template_name = "List_of_Stunted_Children_Severe.xlsx";
				fileName = "List_of_Stunted_Children_Severe_"+proj_type+"_"+str_cur_date+".xlsx";
				start_row = 2;
			} 
			//List of Underweight Children - Moderate
			else if(rept_type.equalsIgnoreCase("09")) {
				excel_template_name = "List_of_Underweight_Children_Moderate.xlsx";
				fileName = "List_of_Underweight_Children_Moderate_"+proj_type+"_"+str_cur_date+".xlsx";
				start_row = 2;
			} 
			//List of Underweight Children - Severe
			else if(rept_type.equalsIgnoreCase("10")) {
				excel_template_name = "List_of_Underweight_Children_Severe.xlsx";
				fileName = "List_of_Underweight_Children_Severe_"+proj_type+"_"+str_cur_date+".xlsx";
				start_row = 2;
			} 
			//List of Wasted Children - Moderate
			else if(rept_type.equalsIgnoreCase("11")) {
				excel_template_name = "List_of_Wasted_Children_Moderate.xlsx";
				fileName = "List_of_Wasted_Children_Moderate_"+proj_type+"_"+str_cur_date+".xlsx";
				start_row = 2;
			} 
			//List of Wasted Children - Severe
			else if(rept_type.equalsIgnoreCase("12")) {
				excel_template_name = "List_of_Wasted_Children_Severe.xlsx";
				fileName = "List_of_Wasted_Children_Severe_"+proj_type+"_"+str_cur_date+".xlsx";
				start_row = 2;
			} 
			//List of Children having Implausible HAZ
			else if(rept_type.equalsIgnoreCase("13")) {
				excel_template_name = "List_of_Children_having_Implausible_HAZ.xlsx";
				fileName = "List_of_Children_having_Implausible_HAZ_"+proj_type+"_"+str_cur_date+".xlsx";
				start_row = 2;
			} 
			//List of Children having Implausible WAZ
			else if(rept_type.equalsIgnoreCase("14")) {
				excel_template_name = "List_of_Children_having_Implausible_WAZ.xlsx";
				fileName = "List_of_Children_having_Implausible_WAZ_"+proj_type+"_"+str_cur_date+".xlsx";
				start_row = 2;
			} 
			//List of Children having Implausible WHZ
			else if(rept_type.equalsIgnoreCase("15")) {
				excel_template_name = "List_of_Children_having_Implausible_WHZ.xlsx";
				fileName = "List_of_Children_having_Implausible_WHZ_"+proj_type+"_"+str_cur_date+".xlsx";
				start_row = 2;
			} 
			//Monthly Record
			else if(rept_type.equalsIgnoreCase("16")) {
				excel_template_name = "Monthly_Record.xlsx";
				fileName = "Monthly_Record_"+proj_type+"_"+str_cur_date+".xlsx";
				start_row = 2;
			} 
			//Community Growth Calendar (WAZ)
			/*else if(rept_type.equalsIgnoreCase("17")) {
				excel_template_name = "***.xlsx";
				fileName = "***_"+str_cur_date+".xlsx";
				start_row = 2;
			}*/ 
			//Child Atlas (Colour Coded) with Growth Chart
			/*else if(rept_type.equalsIgnoreCase("18")) {
				excel_template_name = "***.xlsx";
				fileName = "***_"+str_cur_date+".xlsx";
				start_row = 2;
			}*/ 
			//Growth Status Summary Report
			else if(rept_type.equalsIgnoreCase("19")) {
				excel_template_name = "Growth_Status_Summary_Report.xlsx";
				fileName = "Growth_Status_Summary_Report_"+proj_type+"_"+str_cur_date+".xlsx";
				start_row = 2;
			}
			else if(rept_type.equalsIgnoreCase("20")) {
				excel_template_name = "Creche_monitoring_checklist_Detail.xlsx";
				fileName = "Creche_monitoring_checklist_Detail_"+proj_type+"_"+str_cur_date+".xlsx";
				start_row = 2;
			} 
			else if(rept_type.equalsIgnoreCase("21")) {
				excel_template_name = "Creche_monitoring_checklist_Brief.xlsx";
				fileName = "Creche_monitoring_checklist_Brief_"+proj_type+"_"+str_cur_date+".xlsx";
				start_row = 2;
			} 
			else if(rept_type.equalsIgnoreCase("22")) {
				excel_template_name = "Child_Immunization.xlsx";
				fileName = "Child_Immunization_"+proj_type+"_"+str_cur_date+".xlsx";
				start_row = 2;
			} 
			else if(rept_type.equalsIgnoreCase("23")) {
				excel_template_name = "Creche_Committee_Meeting.xlsx";
				fileName = "Creche_Committee_Meeting_"+proj_type+"_"+str_cur_date+".xlsx";
				start_row = 2;
			} 
			else if(rept_type.equalsIgnoreCase("24")) {
				excel_template_name = "Creche_Worker_Attendance.xlsx";
				fileName = "Creche_Worker_Attendance_"+proj_type+"_"+str_cur_date+".xlsx";
				start_row = 2;
			} 
							
			new DownloadReportExcelWriter().PrepareExcel(str_session_id, 
														 destinationDir, 
														 destinationDownloadDir, 
														 excel_template_name, 
														 fileName,
														 proj_type,
														 user_type,
														 map_id,
														 rept_type,
														 sel_period,
														 sel_catg,
														 sel_mnth_yr,
														 sel_mnth_yr_start,
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

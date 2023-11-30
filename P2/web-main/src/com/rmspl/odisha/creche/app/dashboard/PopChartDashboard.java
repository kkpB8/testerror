package com.rmspl.odisha.creche.app.dashboard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.rmspl.app.data.service.DataFetcher;
import com.rmspl.app.data.service.NoRecordFoundException;
import com.rmspl.odisha.creche.utility.Utility;

import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;

/**
 * Servlet implementation for Overview Chart
 */
public class PopChartDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * Write Log
	 */
	private static Log log = LogFactory.getLog(PopChartDashboard.class);
       
	/**
	 * GET Request to populate Data for Column Chart
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String json_data = request.getParameter("json_data");
			//log.info(">>>>>>>>"+json_data);
			//Parse the JSON
			JSONParser parser = new JSONParser();
			Object object = new Object();
			object = parser.parse(json_data);
			JSONObject json_param_set_obj = (JSONObject) object;
			
			String filter_level = json_param_set_obj.get("filter_level").toString();
			String filter_code = json_param_set_obj.get("filter_code").toString();
			String sub_grp_code = json_param_set_obj.get("sub_grp_code").toString();
			String indi_code = json_param_set_obj.get("indi_code").toString();	
			String sel_mnth_yr = json_param_set_obj.get("sel_mnth_yr").toString();
			String sel_period = json_param_set_obj.get("sel_period").toString();
			String sel_creche_catg = json_param_set_obj.get("sel_creche_catg").toString();
			
			String str_sql = null;
			//For All Project/Program
			if(sel_creche_catg.equalsIgnoreCase("All")){
				str_sql = "CALL sp_df_hp_dashboard_pop("+Utility.checkVal(filter_level)+", "+
															    Utility.checkVal(filter_code)+", "+
															    Utility.checkVal(sub_grp_code)+", "+
															    Utility.checkVal(indi_code)+", "+
															    Utility.checkVal(sel_mnth_yr)+", "+
															    Utility.checkVal(sel_period)+")";
			}
			//For OPNIP/APF-PHRS Project/Program
			else {
				System.out.println();
				str_sql = "CALL sp_df_hp_dashboard_pop_cr("+Utility.checkVal(filter_level)+", "+
													     	Utility.checkVal(filter_code)+", "+
													     	Utility.checkVal(sub_grp_code)+", "+
													     	Utility.checkVal(indi_code)+", "+
													     	Utility.checkVal(sel_mnth_yr)+", "+
													     	Utility.checkVal(sel_period)+", "+
													     	Utility.checkVal(sel_creche_catg)+")";
			}
			/*String str_sql = null;
			//For Total
			if(sub_grp_code.equalsIgnoreCase("0001")) {
				str_sql = "CALL sp_df_hp_monitor_pop_total("+Utility.checkVal(filter_level)+", "+
						  							   		 Utility.checkVal(filter_code)+", "+
						  							   		 Utility.checkVal(sub_grp_code)+", "+
						  							   		 Utility.checkVal(indi_code)+", "+
						  							   		 Utility.checkVal(sel_mnth_yr)+", "+
						  							   		 Utility.checkVal(sel_period)+")";
			}
			//For By Sex
			else if(sub_grp_code.equalsIgnoreCase("0002")) {
				str_sql = "CALL sp_df_hp_monitor_pop_sex("+Utility.checkVal(filter_level)+", "+
						  							   		 Utility.checkVal(filter_code)+", "+
						  							   		 Utility.checkVal(sub_grp_code)+", "+
						  							   		 Utility.checkVal(indi_code)+", "+
						  							   		 Utility.checkVal(sel_mnth_yr)+", "+
						  							   		 Utility.checkVal(sel_period)+")";
			}
			//For By Religion
			else if(sub_grp_code.equalsIgnoreCase("0003")) {
				str_sql = "CALL sp_df_hp_monitor_pop_religion("+Utility.checkVal(filter_level)+", "+
						  							   		 Utility.checkVal(filter_code)+", "+
						  							   		 Utility.checkVal(sub_grp_code)+", "+
						  							   		 Utility.checkVal(indi_code)+", "+
						  							   		 Utility.checkVal(sel_mnth_yr)+", "+
						  							   		 Utility.checkVal(sel_period)+")";
			}
			//For By Caste
			else if(sub_grp_code.equalsIgnoreCase("0004")) {
				str_sql = "CALL sp_df_hp_monitor_pop_caste("+Utility.checkVal(filter_level)+", "+
						  							   		 Utility.checkVal(filter_code)+", "+
						  							   		 Utility.checkVal(sub_grp_code)+", "+
						  							   		 Utility.checkVal(indi_code)+", "+
						  							   		 Utility.checkVal(sel_mnth_yr)+", "+
						  							   		 Utility.checkVal(sel_period)+")";
			}*/
			
			List<String[]> lstdata = new ArrayList<String[]>();
			lstdata = DataFetcher.getProcData(str_sql);	
			
			
			String[][] datas = null;
			datas = new String[lstdata.size()][lstdata.get(0).length];
			for (int i = 0; i < datas.length; i++) {
				for (int j = 0; j < datas[i].length; j++) {
					datas[i][j] = lstdata.get(i)[j];
				}
			}
			JSONArray jdatas = (JSONArray) JSONSerializer.toJSON(datas);
			response.getWriter().print(jdatas);			
		} catch(NoRecordFoundException e){
			log.info("Error to get data From DB ... Cause : "+e.getLocalizedMessage());
			response.getWriter().print("N/A");
		} catch (Exception e) { 
			e.printStackTrace();
			response.getWriter().print("N/A");
		}	
	}
}

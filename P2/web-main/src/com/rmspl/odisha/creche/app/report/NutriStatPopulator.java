package com.rmspl.odisha.creche.app.report;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.rmspl.app.data.service.DataFetcher;


/**
 * Servlet implementation for populate Nutritional Status
 */

public class NutriStatPopulator extends HttpServlet {
	/**
	 * version identifier for a Serializable class
	 */
	private static final long serialVersionUID = 1L;
	private static Log log = LogFactory.getLog(NutriStatPopulator.class);
       
	/**
	 * method  for populate sector names in web page
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[][] datas = null;
		String jatakIdData = "~[";
		String lvl = request.getParameter("lvl");
		String code = request.getParameter("code");
		//String month = request.getParameter("month");
		try {
			List<String[]> lstdata = DataFetcher.getProcData("CALL sp_df_child_pop('"+lvl+"', '"+code+"')");
			//log.info("CALL  sp_df_child_nstat('"+lvl+"', '"+code+"')");
			
			/*for (String[] strings : lstdata) {
				System.out.println("");
				for (int i = 0; i < strings.length; i++) {
					System.out.print(strings[i]+", ");
				}
			}*/
			//int[] statusCount = new int[4];
			datas = new String[lstdata.size()][lstdata.get(0).length];
			for (int i = 0; i < lstdata.size(); i++) {
				jatakIdData += "['"+lstdata.get(i)[0]+"', '"+lstdata.get(i)[1]+"'],";
				
			}
			jatakIdData = jatakIdData.substring(0, jatakIdData.length() - 1) + "]"; //remove last comma
			
			
			String data = "[";
			for (int i = 0; i < datas.length; i++) {
				data = data + "[";
				for (int j = 1; j <= datas[i].length - 1; j++) {
					//System.out.println(datas[i].length+" is the length of array list and value of j is: "+j);
					/*if (j == 3 || j == 4 || j == 5 || j == 6) {*/
					if (j >= 4) {
						if (lstdata.get(i)[j].equalsIgnoreCase("N/A") || lstdata.get(i)[j] == null) {
							
							if (j == 6) {
								data = data + "{v: 5, f: ''}],";
							} else {
								data = data + "{v: 5, f: ''},";
							}
							
						} else {
							if (lstdata.get(i)[j].equalsIgnoreCase("S")) {
								
								if (j == 6) {
									data = data + "{v: 1, f: '"+lstdata.get(i)[j]+"'}],";
								} else {
									data = data + "{v: 1, f: '"+lstdata.get(i)[j]+"'},";
								}
								
								
							} else if (lstdata.get(i)[j].equalsIgnoreCase("M")) {
								if (j == 6) {
									data = data + "{v: 2, f: '"+lstdata.get(i)[j]+"'}],";
								} else {
									data = data + "{v: 2, f: '"+lstdata.get(i)[j]+"'},";
								}
								
							} else if (lstdata.get(i)[j].equalsIgnoreCase("N")) {
								
								if (j == 6) {
									data = data + "{v: 3, f: '"+lstdata.get(i)[j]+"'}],";
								} else {
									data = data + "{v: 3, f: '"+lstdata.get(i)[j]+"'},";
								}
								
							} else if (lstdata.get(i)[j].equalsIgnoreCase("O")) {
								if (j == 6) {
									data = data + "{v: 4, f: '"+lstdata.get(i)[j]+"'}],";
								} else {
									data = data + "{v: 4, f: '"+lstdata.get(i)[j]+"'},";
								}
							} else {
								if (j == 6) {
									data = data + "{v: 6, f: '"+lstdata.get(i)[j]+"'}],";
								} else {
									data = data + "{v: 6, f: '"+lstdata.get(i)[j]+"'},";
								}
							}
						}
					} else { //For child id (first 2 field)
						//Child Name field's data color scheme
						if (j == 2) {
							//data = data + "'"+lstdata.get(i)[j]+"',";
							
							if (lstdata.get(i)[4].equalsIgnoreCase("N")) {
								data = data + "{v: 3, f: '"+lstdata.get(i)[j]+"'},";
							} else if (lstdata.get(i)[4].equalsIgnoreCase("M")) {
								data = data + "{v: 2, f: '"+lstdata.get(i)[j]+"'},";
							} else if (lstdata.get(i)[4].equalsIgnoreCase("S")) {
								data = data + "{v:1, f: '"+lstdata.get(i)[j]+"'},";
							} else if (lstdata.get(i)[4].equalsIgnoreCase("O")) {
								data = data + "{v: 4, f: '"+lstdata.get(i)[j]+"'},";
							} else {
								data = data + "{v: 6, f: '"+lstdata.get(i)[j]+"'},";
							}
						} else if(j==3) {
							String[] dateStr = lstdata.get(i)[3].split("-");
							String dateString = dateStr[2]+"/"+dateStr[0]+"/"+dateStr[1];
							data += "'"+dateString+"', ";
						} else {
							//data = data + "'"+lstdata.get(i)[j]+"',";
							//data = data + "{v: '"+lstdata.get(i)[0]+"', f: '"+lstdata.get(i)[j]+"'},";
							data = data + "{v: '"+lstdata.get(i)[j]+"', f: '"+lstdata.get(i)[j]+"'},";
						}
					}
				}
			}
			
			String finalData = data.substring(0, data.length() - 1) + "]"; //remove last comma
			//log.info(finalData);
			//JSONArray jdatas = (JSONArray) JSONSerializer.toJSON(datas);
			response.getWriter().print(finalData + jatakIdData);
		} catch (Exception e) { 
			response.getWriter().print("N/A");
		}
	}
}

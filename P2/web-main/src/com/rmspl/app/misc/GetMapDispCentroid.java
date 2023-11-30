package com.rmspl.app.misc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rmspl.app.data.service.DataFetcher;
import com.rmspl.app.data.service.NoRecordFoundException;

/**
 * Servlet implementation class GetMapDispCentroid
 */

public class GetMapDispCentroid extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Variables to hold the data for Latitude, Longitude and Zoom Factor
		String lati = "";
		String longi = "";
		String zoom = "";
		try {
			List<String[]> lstData = DataFetcher.getData("SELECT x_coord, y_coord, zoom FROM mst_qmap_coord WHERE map_id = '"+request.getParameter("map_id")+"'");
			
			if (lstData.size() == 1) {
				lati = lstData.get(0)[1];
				longi = lstData.get(0)[0];
				zoom = lstData.get(0)[2];
				
				//Set the values in session variables.
				request.getSession().setAttribute("lati", lati);
				request.getSession().setAttribute("longi", longi);
				request.getSession().setAttribute("zoom", zoom);
				response.getWriter().print("Done");
			} else {
				response.getWriter().print("N/A");
			}
		} catch (NoRecordFoundException e) {
			response.getWriter().print("N/A");
		}
	}

}

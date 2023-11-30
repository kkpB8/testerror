package com.rmspl.odisha.creche.app.report.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Servlet implementation for saving image after rotate
 */
public class RotateImage extends HttpServlet {
	/**
	 * version identifier for a Serializable class
	 */
	private static final long serialVersionUID = 1L;	
	/**
	 * to write log
	 */
	private static Log log = LogFactory.getLog(RotateImage.class);
	/**
	 * directory for uploaded files
	 */
	private File destinationDir;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String realPath = getServletContext().getInitParameter("FilePath");
		destinationDir = new File(realPath);
		if(!destinationDir.isDirectory()) {
			throw new ServletException("ImageFilePath is not a directory");
		}
	}
       
    /**
	 * Get request to save image in database after rotate
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String objId = request.getParameter("fileId");
		
		String filePath = null;
		String fileName = null;
		
		//log.info(objId);
		filePath = objId.substring(0, objId.lastIndexOf("/"));
		fileName = objId.substring(objId.lastIndexOf("/")+1, objId.length());		
		//log.info(filePath);
		//log.info(fileName);
		
		try {
			new ImageRotater(destinationDir+"/"+filePath, fileName+".jpg").rotate();
			response.getWriter().print("Rotated");
		} catch (Exception e) {
			log.error("No image found ..."+objId+"..."+e.getLocalizedMessage(), e);
			response.getWriter().print("Error");
		}
	}
}

package com.rmspl.odisha.creche.app.report.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Servlet implementation to get image
 */
public class SurveyImage extends HttpServlet {
	/**
	 * version identifier for a Serializable class
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * to write log
	 */
	private static Log log = LogFactory.getLog(SurveyImage.class);
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
	 * Method to display image in base map insert/edit page 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		File file = null;
		String objId = request.getParameter("id");
		try {
			file = new File(destinationDir+"/"+objId+".jpg");
			//log.info("File Name..."+file.getAbsolutePath());
			if (!file.exists()) {
				file = new File(destinationDir, "ghost.jpg");
			}			
			BufferedImage bi = ImageIO.read(file);
			OutputStream out = response.getOutputStream();
			ImageIO.write(bi, "jpg", out);
			out.close();			
		} catch (Exception e) {
			log.error("No image found for Child..."+objId+"..."+e.getLocalizedMessage(), e);
			e.printStackTrace();
			response.getWriter().print("NO_FILE");
		}
	}
}

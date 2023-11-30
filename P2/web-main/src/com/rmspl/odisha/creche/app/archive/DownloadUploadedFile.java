package com.rmspl.odisha.creche.app.archive;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 */
public class DownloadUploadedFile extends HttpServlet {
	/**
	 * version identifier for a Serializable class
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * to write log
	 */
	@SuppressWarnings("unused")
	private static Log log = LogFactory.getLog(DownloadUploadedFile.class);
	/**
	 * path of temporary directory
	 */
	private static final String TMP_DIR_PATH = FileUtils.getTempDirectoryPath();
	/**
	 * temporary director to confirm whether path exists or not
	 */
	private File tmpDir;
	/**
	 * directory for Downloaded files
	 */
	private File destinationDir;
	/**
	 * Actual path for Downloaded files
	 */
	private String realPath;
    
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
		tmpDir = new File(TMP_DIR_PATH);
		
		if(!tmpDir.isDirectory()) {
			throw new ServletException(TMP_DIR_PATH + " is not a directory");
		}
		realPath = getServletContext().getInitParameter("FilePath");
		destinationDir = new File(realPath);
		if(!destinationDir.isDirectory()) {
			throw new ServletException("Downloaded FilePath is not a directory");
		}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//File Id
		String file_id = request.getParameter("file_id");
		//File Name
		String file_name = request.getParameter("file_name");
		//File name modified
		if (file_name.contains(" ")) {
			file_name = file_name.replaceAll(" ", "_");
		}
		
		//Download the File
		downloadFile(response, file_id, file_name);
	}
	
	/**
	 * Function to download file.
	 * @param response
	 * @param fileName
	 * @throws IOException
	 */
	private void downloadFile(HttpServletResponse response, String file_id, String file_name) throws IOException {
		
		//String downloadedFileName = fileName.substring(fileName.indexOf("^")+1, fileName.length());
		//download file option
		response.setContentType("text/plain");		
		response.setHeader("Content-Disposition", "attachment;filename="+file_name);
		@SuppressWarnings("unused")
		ServletContext ctx = getServletContext();
		FileInputStream is = new FileInputStream(new File(destinationDir+"/docs/"+file_id));
		int read=0;
		byte[] bytes = new byte[1024];
		OutputStream os = response.getOutputStream();
		while((read = is.read(bytes))!= -1){			
			os.write(bytes, 0, read);
		}
		is.close();
		os.flush();
		os.close();
	}	
}

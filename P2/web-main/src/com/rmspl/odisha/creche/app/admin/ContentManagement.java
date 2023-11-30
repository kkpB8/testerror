package com.rmspl.odisha.creche.app.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.rmspl.app.data.service.DataFetcher;
import com.rmspl.app.data.service.NoRecordFoundException;
import com.rmspl.odisha.creche.utility.Utility;

/**
 * Servlet implementation class 
 */
public class ContentManagement extends HttpServlet {
	/**
	 * version identifier for a Serializable class
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * to write log
	 */
	private static Log log = LogFactory.getLog(ContentManagement.class);
	/**
	 * path of temporary directory
	 */
	private static final String TMP_DIR_PATH = FileUtils.getTempDirectoryPath();
	/**
	 * temporary director to confirm whether path exists or not
	 */
	private File tmpDir;
	/**
	 * directory for uploaded files
	 */
	private File destinationDir;
	/**
	 * Actual path for uploaded files
	 */
	private String realPath;
	
	/**
	 * setting the uploaded file directory path before servlet accepts any request 
	 */
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		tmpDir = new File(TMP_DIR_PATH);
		
		if(!tmpDir.isDirectory()) {
			throw new ServletException(TMP_DIR_PATH + " is not a directory");
		}
		realPath = getServletContext().getInitParameter("FilePath");
		destinationDir = new File(realPath);
		if(!destinationDir.isDirectory()) {
			throw new ServletException("Uploaded FilePath is not a directory");
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//User Id
		String user_id = "";
		//File Description
		String fileDesc = "";
		//Uploaded File name
		String fileName = "";
		
		try {
			@SuppressWarnings("unchecked")
			List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			for (FileItem item : items) {				
				if (item.isFormField()) {
					if (item.getFieldName().equalsIgnoreCase("fileDesc")) {
						fileDesc = item.getString();
					} 
				} else {
					//original file name
					fileName = item.getName();
					//File Id
					String fileId = request.getSession().getId()+"^"
						+Utility.getCurrentDateTime().replaceAll(" ", "_").replaceAll(":", "_").replaceAll("-", "_")+"."+fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
					//Insert Upload File Details 
					List<String[]> lstData = new ArrayList<String[]>();
					lstData = DataFetcher.getProcData("CALL sp_di_mst_pdf_upld("+Utility.checkVal(fileId)
														+", "+Utility.checkVal(fileName)
														+", "+Utility.checkVal(fileDesc)
														+", "+Utility.checkVal(Utility.getCurrentDateTime())
														+", '"+request.getRemoteUser()+"')");
					
					//When file details uploaded successfully
					if (lstData.get(0)[0].equalsIgnoreCase("1")) {
						//Upload the files into the server respective folder
						//Creating Folder
						createDirectory(new File(destinationDir+"/docs"));
						//createDirectory(new File(destinationDir+"/docs/"+catgId));
						//createDirectory(new File(destinationDir+"/docs/"+catgId+"/"+Utility.getCurrentDate()));
						File file = new File(destinationDir+"/docs/", fileName);	
						File uploadedFile = new File(destinationDir+"/docs/", fileId);
						
						item.write(file);	
						InputStream inStream = new FileInputStream(file);
						OutputStream outStream = new FileOutputStream(uploadedFile);
						
						byte[] buffer = new byte[1024*4]; // maximum 4 mb
			    	    int length;
			    	    //copy the file content in bytes
			    	    while ((length = inStream.read(buffer)) > 0) {
			    	    	outStream.write(buffer, 0, length);
			    	    }
			    	    inStream.close();
			    	    outStream.close();
			    	    file.delete();
					}
				}
			} 
			response.getWriter().print("Done");
		} catch(FileUploadException ex) {
			response.getWriter().print("Error");
			log.error("Error encountered while uploading file...Message : "+ex.getLocalizedMessage()+ " Cause : "+ex.getCause());
		} catch(IOException ex) {
			response.getWriter().print("Error");
			log.error("Error encountered while uploading file...Message : "+ex.getLocalizedMessage()+ " Cause : "+ex.getCause());
		} catch(NoRecordFoundException ex) {
			response.getWriter().print("Error");
			log.error("Error encountered while uploading file...Message : "+ex.getLocalizedMessage()+ " Cause : "+ex.getCause());
		} catch(Exception ex) {
			response.getWriter().print("Error");
			log.error("Error encountered while uploading file...Message : "+ex.getLocalizedMessage()+ " Cause : "+ex.getCause());
			ex.printStackTrace();
		} 
	}
	
	/**
	 * Method to create a new directory, if not exists
	 * @param folder
	 */
	private void createDirectory(File folder) {
		//Check whether Folder exists or not 
	    if (!folder.exists()) {
	    	folder.mkdir();
		}
	}
}
package com.rmspl.odisha.creche.mobile.util;

import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;

public class Utility {
	public static final String password = "&#@hfKjkj2156154";
	
	
	/**
	 * Method to validate Data
	 * @param strVal
	 * @return
	 */
	public static String checkVal(String strVal) {
		if (strVal.equalsIgnoreCase("NULL")
				|| strVal.equalsIgnoreCase("")
					|| strVal.equalsIgnoreCase("N/A")
						|| strVal.equalsIgnoreCase("NA")
							|| strVal.equalsIgnoreCase(null)) {
			return "NULL";
		} else {
			//strVal = "'"+strVal+"'";
			//Replacing tab & new line
			//return "'"+str_val.replaceAll("[\n\t]", "")+"'";
			strVal = strVal.replaceAll("[\n\t]", "");
			strVal = strVal.replaceAll("'", "''");
			return "'"+strVal+"'";
		}
	}
	
	/**
	 * Method to validate Data
	 * @param strVal
	 * @return
	 */
	public static String checkVal2(String strVal) {
		if (strVal.equalsIgnoreCase("NULL")
				|| strVal.equalsIgnoreCase("")
					|| strVal.equalsIgnoreCase("NA")
						|| strVal.equalsIgnoreCase(null)) {
			return "NULL";
		} else {
			//strVal = "'"+strVal+"'";
			//Replacing tab & new line
			//return "'"+str_val.replaceAll("[\n\t]", "")+"'";
			strVal = strVal.replaceAll("[\n\t]", "");
			strVal = strVal.replaceAll("'", "''");
			return "'"+strVal+"'";
		}
	}
	
	/**
	* Method to validate Data for "NA"
	* @param strVal
	* @return
	*/
	public static String checkVal3(String strVal) {
		if (strVal.equalsIgnoreCase("NULL")
			|| strVal.equalsIgnoreCase("")
				|| strVal.equalsIgnoreCase("N/A")
					|| strVal.equalsIgnoreCase(null)) {
				return "NULL";
		} else {
			//strVal = "'"+strVal+"'";
			//Replacing tab & new line
			//return "'"+str_val.replaceAll("[\n\t]", "")+"'";
			strVal = strVal.replaceAll("[\n\t]", "");
			strVal = strVal.replaceAll("'", "''");
			return "'"+strVal+"'";
		}
	}
	
	/**
	 * Method to validate Multiple Data
	 * @param strVal
	 * @return
	 */
	public static String checkMultiVal(String strVal) {
		if (strVal.equalsIgnoreCase("")) {
			return "'N/A'";
		} else {
			//strVal = "'"+strVal+"'";
			//Replacing tab & new line
			//return "'"+str_val.replaceAll("[\n\t]", "")+"'";
			strVal = strVal.replaceAll("[\n\t]", "");
			strVal = strVal.replaceAll("'", "''");
			return "'"+strVal+"'";
		}
	}
	
	/**
     * Method to check Blank/NULL value
     * @param response
     * @param str_val
     * @return 
     */
    public static String checkValueMulti(String str_val) {
            String data = null;
            if (str_val.equalsIgnoreCase("N/A")) {
                    //data = "'"+str_val+"'";
                    data = "\"'"+str_val+"'\"";
            } else {
                    data = "\""+str_val+"\"";
            }
            return data;
    }
	
	/**
	 * Function to change the date format from DD-MM-YYYY to YYYY-MM-DD
	 * @param strDate	Date
	 * @return	Date in MySQL format
	 */
	public static String changeDateFormat(String strDate) {
		if (!(strDate.trim().equalsIgnoreCase("")
				|| strDate.trim().equalsIgnoreCase("NULL"))) {
			strDate= strDate.substring(6, strDate.length())+"-"+strDate.substring(3, 5)+"-"+strDate.substring(0, 2);
		} else {
			strDate = "NULL";
		}
		return strDate;
	}
	/**
	 * Method to create a new directory, if not exists
	 * @param folder
	 */
	public static void createDirectory(File folder) {
		//Check whether Folder exists or not 
	    if (!folder.exists()) {
	    	folder.mkdir();
		}
	}
	
	/**
	 * Method to convert Image to Base64
	 * @param file_img	Image File
	 * @return	Base64 String
	 * @throws IOException	IO Exception
	 */
	public static String getBase64Image(File file_img) throws IOException{
		RenderedImage image = null;
		File sourceimage = file_img;
		image = ImageIO.read(sourceimage);	
		
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ImageIO.write(image, "jpg", output);
		String base64String = DatatypeConverter.printBase64Binary(output.toByteArray());
		//System.out.println(base64String);
		return base64String;
	}
}

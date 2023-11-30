package com.rmspl.odisha.creche.utility;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Decoder.BASE64Decoder;
 
//import sun.misc.BASE64Decoder;
/**
 *  Input : Base64 encoded Image
 *  Outpu : Save it as image file (png)
 */
public class Base64ToImage {
	
	public static BufferedImage getImage(String base64String) {
		
        // decode base64 encoded image
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] decodedBytes = null;
		try {
			decodedBytes = decoder.decodeBuffer(base64String);
		} catch (IOException e1) {
			return null;
		}
        //log.debug("Decoded upload data : " + decodedBytes.length);
        //System.out.println("Decoded upload data : " + decodedBytes.length);
 
           
        //String uploadFile = "/tmp/test.png";
        //String uploadFile = str_pic_id+".jpg";
        //log.debug("File save path : " + uploadFile);
        //System.out.println("File save path : " + uploadFile);
 
         // buffered image from the decoded bytes 
         BufferedImage image = null;
		try {
			image = ImageIO.read(new ByteArrayInputStream(decodedBytes));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		return image;
		
         /*if (image == null) {
              //log.error("Buffered Image is null");
        	 //System.out.println("Buffered Image is null");
        	 return null;
          }
         File f = new File(uploadFile);
 
         // write the image
          try {
			ImageIO.write(image2, "jpg", f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;*/
	}
}
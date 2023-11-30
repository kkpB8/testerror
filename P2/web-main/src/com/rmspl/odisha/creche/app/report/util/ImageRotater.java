package com.rmspl.odisha.creche.app.report.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.rmspl.app.data.service.DataFetcher;

/**
 * This class is responsible to rotate Object's image 
 * @author root
 *
 */
public class ImageRotater {
	/**
	 * holds the file path
	 */
	private String filePath = null;
	/**
	 * holds the file name
	 */
	private String fileName = null;
	/**
	 * holds the Table name
	 */
	//private String tableName = null;
	
	/**
	 * constructor to set file path and file name
	 * @param filePath	Actual File Path
	 * @param fileName	File Name
	 */
	public ImageRotater(String filePath, String fileName) {
		setFilePath(filePath);
		setFileName(fileName);		
		//setTableName(tableName);
	}
	
	/**
	 * Method to rotate image by 90 degree
	 * @return	Image after rotation
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public ImageRotater rotate() throws FileNotFoundException, IOException {
		File oldFile = new File(getFilePath()+"/"+getFileName());
		BufferedImage oldImage = ImageIO.read(new FileInputStream(oldFile));
		BufferedImage newImage = new BufferedImage(oldImage.getHeight(), oldImage.getWidth(), oldImage.getType());
		Graphics2D graphics = (Graphics2D) newImage.getGraphics();
		graphics.rotate(Math.toRadians(90), newImage.getWidth() / 2, newImage.getHeight() / 2);
		graphics.translate((newImage.getWidth() - oldImage.getWidth()) / 2, (newImage.getHeight() - oldImage.getHeight()) / 2);
		graphics.drawImage(oldImage, 0, 0, oldImage.getWidth(), oldImage.getHeight(), null);
		oldFile.delete();
		ImageIO.write(newImage, getFileName().substring(getFileName().indexOf(".") + 1), new FileOutputStream(getFilePath()+"/"+getFileName()));
		return this;
	}
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/*public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}*/	
}
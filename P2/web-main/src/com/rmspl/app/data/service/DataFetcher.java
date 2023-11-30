package com.rmspl.app.data.service;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.rmspl.app.data.connector.JDBCConnectionFactory;

public abstract class DataFetcher {

	//private static final String FIELD_SEPERATOR = "^";
    
    private static Log log = LogFactory.getLog(DataFetcher.class);
    private static File destinationDir = new File("/var/app_file/vbdkl/test/");
    String currentTime = "";    

    public DataFetcher() {}

    /**
     * Method to fire the SQL and returned retrieved data
     * @param str_sql {@link String} sql
     * @return {@link List} of {@link String} {@link Array}
     * @throws NoRecordFoundException
     */
    public static List<String[]> getData(String str_sql) throws NoRecordFoundException {
    	//log.info("Get Select Data Called .............."+str_sql);
    	//log.info("Before calling get SQL..."+new SimpleDateFormat ("yyyy.MM.dd  hh:mm:ss.SSS ").format(new Date()));
    	//LogCreator.writeLog(destinationDir, "SQL calling start..."+new SimpleDateFormat ("yyyy.MM.dd  hh:mm:ss.SSS ").format(new Date())+"... " + str_sql, LogCreator.MESSAGE);
    	
    	//log.info(str_sql);
    	List<String[]> datas = new ArrayList<String[]>();
    	Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
			conn = JDBCConnectionFactory.getInstance().getConnection();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        	//fetch data			
        	rs = stmt.executeQuery(str_sql);
        	//log.info("Get Connection .............."+rs.getMetaData().getColumnCount());
        	while(rs.next()) {
        		String[] data = new String[rs.getMetaData().getColumnCount()];
        		for(int f = 0; f < rs.getMetaData().getColumnCount(); f++) {
        			Object obj = rs.getObject(f+1);
        			//log.info("Get Value .............."+f+".............."+String.valueOf(obj));
        			//if the data is null
        			if (obj == null){
        				data[f] = "N/A";
        				continue;
        			} else {
        				if (rs.getMetaData().getColumnType(f+1) == Types.DATE) {
        					Format formatter = null;		
            				formatter = new SimpleDateFormat("dd-MM-yyyy");
            				data[f] = formatter.format(obj);
						} /*else if ((rs.getMetaData().getColumnType(f+1) == Types.DECIMAL) 
										|| (rs.getMetaData().getColumnType(f+1) == Types.DOUBLE) 
											|| (rs.getMetaData().getColumnType(f+1) == Types.FLOAT)) {
							BigDecimal b = new BigDecimal(obj.toString()).setScale(2, BigDecimal.ROUND_HALF_UP);
							String str_data = String.valueOf(b);
							data[f] = str_data;
						}*/ else {							
							data[f] = String.valueOf(obj);
						}
						//log.info(data[f]+".....");
					}
				}
        		datas.add(data);
			}        	
        } catch (SQLException e) {
			log.error("Cannot Fetch Data For SQL : "+str_sql+"\n\tCause : "+e.getCause());
			throw new NoRecordFoundException();
		} finally {
			DbUtil.closeQuitely(rs);
	        DbUtil.closeQuitely(stmt);
	        DbUtil.closeQuitely(conn);
		}
        if (datas.size() > 0) {
        	//log.info("Before sending response from SQL..."+new SimpleDateFormat ("yyyy.MM.dd  hh:mm:ss.SSS ").format(new Date()));
        	//LogCreator.writeLog(destinationDir, "SQL execution end..."+new SimpleDateFormat ("yyyy.MM.dd  hh:mm:ss.SSS ").format(new Date())+"... " + str_sql, LogCreator.MESSAGE);
            return datas;    
            } else {
                    throw new NoRecordFoundException();
            }    	
    }
    
    /**
     * Method to call the Procedure and returned retrieved data
     * @param str_sql	{@link String} SQL
     * @return	{@link List} of {@link String} {@link Array}
     * @throws NoRecordFoundException
     */
    public static List<String[]> getProcData(String str_sql) throws NoRecordFoundException {
    	System.out.println("Get Procedure data Called .............. " + str_sql);
    	//log.info("Before calling Store Procedure..."+new SimpleDateFormat ("yyyy.MM.dd  hh:mm:ss.SSS ").format(new Date()));
    	//LogCreator.writeLog(destinationDir, "Procedure calling start..."+new SimpleDateFormat ("yyyy.MM.dd  hh:mm:ss.SSS ").format(new Date())+"... " + str_sql, LogCreator.MESSAGE);
    	
    	List<String[]> datas = new ArrayList<String[]>();
    	Connection conn = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
			conn = JDBCConnectionFactory.getInstance().getConnection();
			stmt = conn.prepareCall("{"+str_sql+"}");
        	//fetch data
        	rs = stmt.executeQuery();
        	while(rs.next()) {
        		String[] data = new String[rs.getMetaData().getColumnCount()];
        		for(int f = 0; f < rs.getMetaData().getColumnCount(); f++) {
        			Object obj = rs.getObject(f+1);
        			if (obj == null){
        				//stb.append("N/A").append(FIELD_SEPERATOR);
        				data[f] = "N/A";
        				continue;
        			} else {        				        				
        				if (rs.getMetaData().getColumnType(f+1) == Types.DATE) {
        					Format formatter = null;		
            				formatter = new SimpleDateFormat("dd-MM-yyyy");
            				data[f] = formatter.format(obj);
						} /*else if ((rs.getMetaData().getColumnType(f+1) == Types.DECIMAL)
										|| (rs.getMetaData().getColumnType(f+1) == Types.DOUBLE) 
											|| (rs.getMetaData().getColumnType(f+1) == Types.FLOAT)) {
							BigDecimal b = new BigDecimal(obj.toString()).setScale(2, BigDecimal.ROUND_HALF_UP);
							String str_data = String.valueOf(b);
							data[f] = str_data;
						}*/ else {							
							data[f] = String.valueOf(obj);
						}
						//log.info(data[f]+".....");
					}
				}
        		datas.add(data);
			}
		} catch (SQLException e) {
			log.error("Cannot Fetch Data For SQL : "+str_sql+"\n\tCause : "+e.getCause()+"---"+e.getLocalizedMessage());
			//throw new NoRecordFoundException();
			throw new NoRecordFoundException(String.valueOf(e.getErrorCode()));
		} finally {
			DbUtil.closeQuitely(rs);
	        DbUtil.closeQuitely(stmt);
	        DbUtil.closeQuitely(conn);
		}
        if (datas.size() > 0) {
        	//log.info("Before sending response from Store Procedure..."+new SimpleDateFormat ("yyyy.MM.dd  hh:mm:ss.SSS ").format(new Date()));
        	//LogCreator.writeLog(destinationDir, "Procedure execution end..."+new SimpleDateFormat ("yyyy.MM.dd  hh:mm:ss.SSS ").format(new Date())+"... " + str_sql, LogCreator.MESSAGE);
        	return datas;    
            } else {
                    throw new NoRecordFoundException();
            }    	
    }
    
    /**
     * Method to call Procedure
     * @param str_sql	{@link String} SQL
     * @return	{@link Boolean} true if successful, false if not
     */
    /*public static boolean callProcedure(String str_sql) {
    	log.info("Get Procedure data Called .............. " + str_sql);
    	
    	boolean boo_success = false;
    	Connection conn = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
			conn = JDBCConnectionFactory.getInstance().getConnection();
			stmt = conn.prepareCall("{"+str_sql+"}");
			boo_success = stmt.execute();
        } catch (SQLException e) {
			log.error("Cannot Call Procedure For SQL : "+str_sql+"\n\tCause : "+e.getCause());
		} finally {
			DbUtil.closeQuitely(rs);
	        DbUtil.closeQuitely(stmt);
	        DbUtil.closeQuitely(conn);
		}
        
        return boo_success;
    }*/
    public static boolean callProcedure(String str_sql) {
    	//log.info("Get Procedure data Called .............."+str_sql);    	
    	boolean boo_success = false;
    	int int_status = 0;
    	Connection conn = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
			conn = JDBCConnectionFactory.getInstance().getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareCall("{"+str_sql+"}");
			//boo_success = stmt.execute();
			int_status = stmt.executeUpdate();
			if (int_status == 1) {
				boo_success = true;
				conn.commit();
			} else {
				boo_success = false;
				if (conn != null) {
			        conn.rollback();
			        log.info("rollback");
			      }
			}
			//log.info("Success : " + int_status);
        } catch (SQLException e) {
        	
			log.error("Cannot Call Procedure For SQL : "+str_sql+"\n\tCause : "+e.getCause());
		} finally {
			DbUtil.closeQuitely(rs);
	        DbUtil.closeQuitely(stmt);
	        DbUtil.closeQuitely(conn);
		}
        
        return boo_success;
    }
    
    /**
     * Method to insert the data in the database
     * @param str_sql {@link String} Insert SQL
     * @return {@link String} Status (1 - if successful, 0 - if not)
     */
    public static String insertData(String str_sql) {
    	//log.info("Get Insert Data Called .............."+str_sql);
    	String strStatus = "0";
    	Connection conn = null;
        Statement stmt = null;		
    	//insert data
    	try {
    		conn = JDBCConnectionFactory.getInstance().getConnection();
    		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			int i = stmt.executeUpdate(str_sql);
			strStatus = String.valueOf(i);
		} catch (SQLException e) { 
			log.error("Cannot Insert Data For SQL : "+str_sql
					+"\n\tCause : "+e.getMessage());
		} finally {
			DbUtil.closeQuitely(stmt);
	        DbUtil.closeQuitely(conn);
		}
		return strStatus;
    }  
    
    /**
     * 
     * @param str_sql
     * @return
     */
    public static String createTable(String str_sql) {
    	String strStatus = "0";
    	Connection conn = null;
        Statement stmt = null;		
    	//insert data
    	try {
    		conn = JDBCConnectionFactory.getInstance().getConnection();
    		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			stmt.executeUpdate(str_sql);
			strStatus = "1";
		} catch (SQLException e) { 
			log.error("Cannot Create Table For SQL : "+str_sql
					+"\n\tCause : "+e.getCause());
		} finally {
			DbUtil.closeQuitely(stmt);
	        DbUtil.closeQuitely(conn);
		}
		return strStatus;
    } 
    
    /**
     * Method to insert/update file in database
     * @param file	{@link File} to be inserted
     * @param tableName	{@link String} Table Name
     * @param fieldName	{@link String} Field Name
     * @param condition	{@link String} Condition
     */
    public static boolean updateFileData(File file, String tableName, String fieldName, String condition) {
    	String INSERT_FILE = "UPDATE "+tableName+" SET "+fieldName+" = ? WHERE "+condition;
    	Connection conn = null;
    	PreparedStatement ps = null;
    	int result = 0;
    	//insert data
    	try {
    		FileInputStream fis = new FileInputStream(file);
    		conn = JDBCConnectionFactory.getInstance().getConnection();
    		ps = conn.prepareStatement(INSERT_FILE);
    		ps.setBinaryStream(1, (InputStream) fis, (int) file.length());
    	    result = ps.executeUpdate();
		} catch (SQLException e) { 
			//throw new InsertionFailedException("Cannot Update Data For SQL : "+INSERT_PICTURE, e.getCause());
			log.error("Cannot Insert Data For SQL : "+INSERT_FILE+"\n\tCause : "+e.getMessage());
		} catch (FileNotFoundException e) {
			//throw new InsertionFailedException("Cannot Find Data File : "+file.getName(), e.getCause());
			log.error("Cannot Insert File : "+file.getName()+"\n\tCause : "+e.getMessage());
		} finally {
			DbUtil.closeQuitely(ps);
	        DbUtil.closeQuitely(conn);
		}
    	if (result == 0) {
			return false;
		} else {
			return true;
		}
    }
    
    public static byte[] getFileData(String strSQL) {
    	//log.info("Here in getFileData........"+strSQL);
    	Blob img ;
        byte[] imgData = null;
        Connection conn = null;
        Statement stmt = null;		
        ResultSet rs = null;
    	try {
    		conn = JDBCConnectionFactory.getInstance().getConnection();
    		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(strSQL);
			rs.next ();   
		    img = rs.getBlob(1);
		    imgData = img.getBytes(1,(int)img.length());
		} catch (SQLException e) {
			imgData = getBlankPic();
			log.error("Cannot Fetch Picture For : "+strSQL+"\n\tCause : "+e.getCause());
		} catch (Exception e) {
			imgData = getBlankPic();
			log.error("picture not found : Cause : "+e.getCause());
		}
    	
    	finally {
			DbUtil.closeQuitely(rs);
			DbUtil.closeQuitely(stmt);
	        DbUtil.closeQuitely(conn);
		}
        return imgData;
    }
    
    public static byte[] getBlankPic() {
    	Blob img ;
        byte[] imgData = null;
        Connection conn = null;
        Statement stmt = null;		
        ResultSet rs = null;
    	try {
    		conn = JDBCConnectionFactory.getInstance().getConnection();
    		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery("SELECT obj_image FROM mst_layer_pic WHERE obj_code = 'Blank'");
			rs.next ();   
		    img = rs.getBlob(1);
		    imgData = img.getBytes(1,(int)img.length());
		} catch (SQLException e) {
			imgData = getBlankPic();
			log.error("Cannot Fetch Blank image: \n\tCause : "+e.getCause());
		} catch (Exception e) {
			imgData = getBlankPic();
			log.error("picture not found : Cause : "+e.getCause());
		}
    	return imgData;
    }
    
    public static byte[] getFileDataProc(String strSQL) {
    	Blob img ;
        byte[] imgData = null;
        Connection conn = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
			conn = JDBCConnectionFactory.getInstance().getConnection();
			stmt = conn.prepareCall("{"+strSQL+"}");
        	rs = stmt.executeQuery();
			rs.next ();   
		    img = rs.getBlob(1);
		    imgData = img.getBytes(1,(int)img.length());
		} catch (SQLException e) { 
			log.error("Cannot Fetch Picture For : "+strSQL+"\n\tCause : "+e.getCause());
		} finally {
			DbUtil.closeQuitely(rs);
			DbUtil.closeQuitely(stmt);
	        DbUtil.closeQuitely(conn);
		}
        return imgData;
    }
}

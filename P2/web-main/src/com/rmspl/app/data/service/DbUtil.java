package com.rmspl.app.data.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class DbUtil {

	private static SimpleDateFormat DATE_PARSER = new SimpleDateFormat("ddMMyy-HHmmss");
    private static SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static Log log = LogFactory.getLog(DbUtil.class);
    
    public DbUtil() { }

    public static void closeQuitely(Connection conn) {
        try {
            if(conn != null) {
                conn.close();
            }
        } catch(Exception exp) {
        	log.error("Cannot Close connection : "+exp.getCause());
        }
    }

    public static void closeQuitely(ResultSet rs) {
        try {
            if(rs != null) {
                rs.close();
            }
        } catch(Exception exp) {
        	log.error("Cannot Close ResultSet : "+exp.getCause());
        }
    }

    public static void closeQuitely(Statement st) {
        try {
            if(st != null) {
                st.close();
            }
        } catch(Exception exp) {
        	log.error("Cannot Close Statement : "+exp.getCause());
        }
    }

    public static void closeQuitely(PreparedStatement pst) {
        try {
            if(pst != null) {
                pst.close();
            }
        } catch(Exception exp) {
        	log.error("Cannot Close PreparedStatement : "+exp.getCause());
        }
    }

    public static String getDbDateTime(String date, String time) throws ParseException {
        return DATE_FORMATTER.format(DATE_PARSER.parse(date.concat("-").concat(time)));
    }
}

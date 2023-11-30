package com.rmspl.app.misc;

import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogCreator {
	
	private final static DateFormat df = new SimpleDateFormat ("yyyy.MM.dd  hh:mm:ss.SSS ");
    public static final int MESSAGE = 1;
	public static final int ERROR = 0;

    private LogCreator() { }
    
    public static void writeLog(File logFile, String msg, int intVal) {
        try {
        	DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy");
            Date now = new Date();
            String currentTime = LogCreator.df.format(now); 
            FileWriter aWriter = new FileWriter(logFile+"/"+dateFormat.format(now)+".txt", true);
            
            aWriter.write(System.getProperty("line.separator"));
            if (intVal == ERROR) {
            	aWriter.write(currentTime + "  --------------->> Error --------------->> " + System.getProperty("line.separator"));            	
			} else {
				aWriter.write(currentTime + "  --------------->> Message --------------->> " + System.getProperty("line.separator"));
			}     
            aWriter.write("\t\t" + msg + System.getProperty("line.separator"));
            //System.out.println(currentTime + " " + msg);
            aWriter.flush();
            aWriter.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

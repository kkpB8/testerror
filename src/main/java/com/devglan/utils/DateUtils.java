package com.devglan.utils;



import java.text.ParseException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

public class DateUtils {

//DATE
public static Date secondsToDateConverter(Integer seconds){
    if(seconds!=0 && seconds!=null){
        long millis = seconds;
        LocalDateTime date = LocalDateTime.ofEpochSecond(millis, 0, ZoneOffset.UTC);
       Date out = Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
        return out;
    }
    else
    return null;
}

public static Date secondsToDateConverterLong(Long seconds){
    if(seconds!=0 && seconds!=null){
        long millis = seconds;
        LocalDateTime date = LocalDateTime.ofEpochSecond(millis, 0, ZoneOffset.UTC);
        Date out = Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
        return out;
    }
    else
        return null;
}

    public static Integer dateToSecondsConverter(Date date) throws ParseException {

    	LocalDateTime dateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        if(dateTime!=null) {
            long ldt = dateTime.toEpochSecond(ZoneOffset.UTC);
            Integer intDate = (int) ldt;
            return intDate;
        }
        else
            return 0;

    }
    
    public static Long dateToSecondsConverterLong(Date date) throws ParseException {
    	Long long1 = new Long("0");
    	        LocalDateTime dateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

    	        if(dateTime!=null) {
    	            long ldt = dateTime.toEpochSecond(ZoneOffset.UTC);
    	           // Integer intDate = (int) ldt;
    	            return ldt;
    	        }
    	        else
    	            return long1;

    	    }
    //Timestamp
	
	  public static Timestamp secondsToTimestampConverter(Integer seconds) {
	  if(seconds!=0) { long millis = seconds; LocalDateTime date1 =
	  LocalDateTime.ofEpochSecond(millis+19800, 0, ZoneOffset.UTC);
	  
	  Timestamp date = Timestamp.valueOf(date1); return date; } else return null; }
	 
    
  //Timestamp
    public static Timestamp secondsToTimestampConverter(Long seconds) {
        if(seconds!=0) {
            long millis = seconds;
            //19800
            LocalDateTime date1 = LocalDateTime.ofEpochSecond(millis+19800, 0, ZoneOffset.UTC);
            
            Timestamp date = Timestamp.valueOf(date1);
            return date;
        }
        else
        return null;
    }

    public static Integer TimestampToSecondsConverter(Timestamp dateTime) throws ParseException {
        if(dateTime!=null) {
        long ldt = dateTime.getTime();
        Integer intDate = (int) ldt;
        return intDate;
            }
        else
            return 0;
        }
}

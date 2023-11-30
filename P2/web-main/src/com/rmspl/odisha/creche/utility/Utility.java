package com.rmspl.odisha.creche.utility;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.mysql.jdbc.log.Log;

public class Utility {
	
	/**
	 * Method to get current date
	 * @return
	 */
	public static String getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("IST"));
		String currDate = sdf.format(new Date());
		return currDate;
	}
	/**
	 * Method to get current date
	 * @return
	 */
	public static String getCurrentDateInMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("IST"));
		String currDate = sdf.format(new Date());
		return currDate;
	}
	
	/**
	 * Method to get current time
	 * @return
	 */
	public static String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
		sdf.setTimeZone(TimeZone.getTimeZone("IST"));
		String currTime = sdf.format(new Date());
		//String currTime = currDateTime.substring(currDateTime.indexOf(" "), currDateTime.length());
		return currTime;
	}
	
	/**
	 * Function to check the value and set the value for SQL
	 * @param str_val
	 * @return str_val
	 */
	public static String checkVal(String str_val) {
		
		//For single quote(')
		str_val = str_val.replaceAll("'", "\\\\'");
		//For enter manage
		str_val = str_val.replaceAll("\"", "\\\\\"");
		
		if (str_val.trim().equalsIgnoreCase("NA")
				|| str_val.trim().equalsIgnoreCase("N/A")
					|| str_val.trim().equalsIgnoreCase("NULL")
						|| str_val.trim().equalsIgnoreCase("")
							|| str_val.trim() == null) {
			str_val = "NULL";
		} else {
			 str_val = "'"+str_val+"'";
		}
		return str_val;
	}
	
	
	/**
	 * Function to Get Current date-Time(IST) 
	 * @return currDateTime
	 */
	public static String getCurrentDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("IST"));
		String currDateTime = sdf.format(new Date());
		return currDateTime;
	}
	
	/**
	 * Function to change the date format from DD/MM/YYYY to YYYY-MM-DD
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
	* Method to get all the financial years form the given year
	* @param startingYear {@link Integer} Starting Year
	* @return {@link List} of {@link String} Years
	*/
	public static String getFinancialYears() {
		
		String years = new String();
		Calendar curDate = Calendar.getInstance();
		curDate.setTimeZone(TimeZone.getTimeZone("IST"));
		
		int startingYear= curDate.get(Calendar.YEAR);
		
		if ( curDate.get(Calendar.MONTH) > Calendar.MARCH) {
			years= String.valueOf(startingYear)+"-"+String.valueOf(startingYear + 1);
		} else {
			years= String.valueOf(startingYear-1)+"-"+String.valueOf(startingYear);
		}
		//System.out.println(years);
		return years;
	} //# End getFinancialYears
	
	/**
	* Method to get all the Calender years form the given year
	* @param startingYear {@link Integer} Starting Year
	* @return {@link List} of {@link String} Years
	*/
	public static List<String> getCalenderYears(int startingYear) {
		
		List<String> years = new ArrayList<String>();
		Calendar curDate = Calendar.getInstance();
		curDate.setTimeZone(TimeZone.getTimeZone("IST"));
		
		int CurYear= curDate.get(Calendar.YEAR);
		
		while (startingYear <= curDate.get(Calendar.YEAR)) {			
			years.add(String.valueOf(startingYear));			
			startingYear += 1;
		}		
		Collections.reverse(years);
		return years;
	} //# End getFinancialYears
	
	
	public static String getMonthName(String short_month) {
		if(short_month.equalsIgnoreCase("01")) {
			return "January";
		} else if(short_month.equalsIgnoreCase("02")) {
			return "February";
		} else if(short_month.equalsIgnoreCase("03")) {
			return "March";
		} else if(short_month.equalsIgnoreCase("04")) {
			return "April";
		} else if(short_month.equalsIgnoreCase("05")) {
			return "May";
		} else if(short_month.equalsIgnoreCase("06")) {
			return "June";
		} else if(short_month.equalsIgnoreCase("07")) {
			return "July";
		} else if(short_month.equalsIgnoreCase("08")) {
			return "August";
		} else if(short_month.equalsIgnoreCase("09")) {
			return "September";
		} else if(short_month.equalsIgnoreCase("10")) {
			return "October";
		} else if(short_month.equalsIgnoreCase("11")) {
			return "November";
		} else if(short_month.equalsIgnoreCase("12")) {
			return "December";
		} else {
			return null;
		}				
	}
	
	
} //# End Class
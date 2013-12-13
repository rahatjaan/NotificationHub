package com.servercentral.communication.hub.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String shortDateFormat = "yyyy-MM-dd";
	public static String getShortDate(Date date,String format){
		DateFormat df = new SimpleDateFormat(format);
		return df.format(date);
//		return null;	
	}
	
	public static String getShortDate(Date date){
		
		return getShortDate(date,shortDateFormat);	
	}
}

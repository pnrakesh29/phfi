package com.smh.util;


import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

@SuppressWarnings("deprecation")
public final class DateUtil {

	private static SimpleDateFormat dateFormat = new SimpleDateFormat();
	public static String viewDateFormat = "dd/MM/yyyy";
	public static String viewDateTimeFormat = "dd/MM/yyyy HH:mm:ss";

	/**
	 * Method to get Current Timestamp
	 * 
	 * @return
	 */
	public static Timestamp getCurrentTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * Method to get java.sql.Timestamp from given date string and pattern
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static Timestamp toTimestamp(String date, String pattern) {
		try {
			dateFormat.applyPattern(pattern);
			return new Timestamp(dateFormat.parse(date).getTime());
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Date toDate(Date date, String pattern) {
		dateFormat.applyPattern(pattern);
		return new Date(date.getTime());

	}

	public static Time toTime(String time, String pattern) {

		try {
			dateFormat.applyPattern(pattern);
			// return new Time(dateFormat.parse(dateFormat.format(time)).getTime());
			return new Time(dateFormat.parse(time).getTime());

		}
		catch(ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Method to get Date as string from given date time stamp and pattern
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String toDateStringFormat(Timestamp date, String pattern) {
		if(null != date) {
			dateFormat.applyPattern(pattern);
			return dateFormat.format(date);
		}
		else {
			return null;
		}
	}

	/**
	 * Method to get Current Day's EOD Timestamp
	 * 
	 * @return
	 */
	public static Timestamp getCurrentDayEODTimestamp() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 1);
		return new Timestamp(calendar.getTimeInMillis());
	}

	/**
	 * Method to get java.sql.Timestamp from given date string and pattern
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	
  public static Timestamp getStartDayTimestamp(String date, String pattern) {
		try {
			if(null == date || "".equals(date)) {
				return null;
			}
			dateFormat.applyPattern(pattern);
			Date date2 = dateFormat.parse(date);
			date2.setHours(00);
			date2.setMinutes(00);
			date2.setSeconds(00);
			return new Timestamp(date2.getTime());
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Method to get java.sql.Timestamp from given date string and pattern
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static Timestamp getEndDayTimestamp(String date, String pattern) {
		try {
			if(null == date || "".equals(date)) {
				return null;
			}
			dateFormat.applyPattern(pattern);
			Date date2 = dateFormat.parse(date);
			date2.setHours(23);
			date2.setMinutes(59);
			date2.setSeconds(59);
			return new Timestamp(date2.getTime());
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		return null;
	}





	public static XMLGregorianCalendar convertStringToXMLGregorianCalendar(String dateStr,String pattern) 
	{
		XMLGregorianCalendar calendar = null;
		try
		{
			DateFormat format = new SimpleDateFormat(pattern);
			Date date = format.parse(dateStr);

			GregorianCalendar gregory = new GregorianCalendar();
			gregory.setTime(date);

			calendar = DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(
							gregory);
		}
		catch (ParseException p)
		{
			p.printStackTrace();
		}
		catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		StringBuffer dateBuffer = new StringBuffer();
		dateBuffer.append(calendar.getDay()+"/"+calendar.getMonth()+"/"+calendar.getYear()+" "+calendar.getHour()+":"+calendar.getMinute()+":"+calendar.getSecond() );



		System.out.println(dateBuffer.toString());
		return calendar;
	}

	public static String convertXMLGregorianCalendartoString(XMLGregorianCalendar gregorianCalendar)
	{
		StringBuffer dateBuffer = new StringBuffer();
		dateBuffer.append(gregorianCalendar.getDay()+"/"+gregorianCalendar.getMonth()+"/"+gregorianCalendar.getYear());
		return dateBuffer.toString();
	}





	public static String convertTime(long time)
	{
		long dividend=time/60;
		long remainder=time%60;
		long journeyDay=dividend/24;

		long hour=dividend%24;
		long min=remainder;

		String mins=String.valueOf(min);
		String hours=String.valueOf(hour);

		if(min/10==0 || min==0){
			mins="0"+mins;
		}
		if(hour/10==0 || hour==0){
			hours="0"+hours;
		}
		String timeString=hours+":"+mins;


		if(journeyDay!=0){
			timeString=timeString+". Arrives Next day";
		}
		System.out.println(timeString);
		/* System.out.println(timeString);
	  //   System.out.println("time is"+time);
	    Date date = new Date(time);
	 //   System.out.println("date"+date);
	    Format format = new SimpleDateFormat("HH:mm:ss");
	    return format.format(date).toString();*/
		return timeString;
	}

	public static String converToTime(long time)
	{
		long timeReminder = time%60;
		long timeQuotient = time/60;
		long hour = timeQuotient%24;
		String endParameter = (hour>12)?" pm":" am";
		hour = (hour>12)?hour - 12:hour;
		String arrivalTime = String.valueOf(hour)+":"+((timeReminder<10)?"0":"")+String.valueOf(timeReminder)+endParameter;
		return arrivalTime;
	}


	public static String getValidDates(String dates,String pat,String oldFormat) throws ParseException
	{
		DateFormat originalFormat = new SimpleDateFormat(oldFormat);
		DateFormat targetFormat = new SimpleDateFormat(pat);
		Date date = originalFormat.parse(dates);
		String formattedDate = targetFormat.format(date);
		return formattedDate;
	}

	public static String getValidSysDate(String dates,String pat,String oldFormat)
	{
		if ( oldFormat.indexOf(".")>-1)
		{
			oldFormat=oldFormat.replace(".","/");
			dates=dates.replace(".","/");
		}
		String formattedDate=null;
		try{
			DateFormat originalFormat = new SimpleDateFormat(oldFormat);
			//    DateFormat targetFormat = new SimpleDateFormat(pat+" hh:mm:ss");
			DateFormat targetFormat = new SimpleDateFormat(pat);
			Date date = originalFormat.parse(dates);
			formattedDate = targetFormat.format(date);

		}
		catch(ParseException DPE)
		{
			System.out.println("Error DateUtil::getValidSysDate()"+DPE.getMessage());
		}
		return formattedDate;
	}
	
	 /**
	   * This method used for formated the current date and time.
	   * 
	   * @return String
	   */
	  @SuppressWarnings("unused")
    private String getFormattedTime() {
	    StringBuffer formattedTime = new StringBuffer();
	    // CCYYMMDDHHMMSS
	    DecimalFormat formatter = new DecimalFormat("00");
	    Calendar c = Calendar.getInstance();
	    c.setTime(new Date());
	    formattedTime.append(c.get(Calendar.YEAR));
	    formattedTime.append(formatter.format(c.get(Calendar.MONTH) + 1));
	    formattedTime.append(formatter.format(c.get(Calendar.DATE)));
	    formattedTime.append(formatter.format(c.get(Calendar.HOUR_OF_DAY)));
	    formattedTime.append(formatter.format(c.get(Calendar.MINUTE)));
	    formattedTime.append(formatter.format(c.get(Calendar.SECOND)));
	    return formattedTime.toString();
	  }

	public static void main(String[] args) throws ParseException, DatatypeConfigurationException {
		//    System.out.println("time is" + DateUtil.toTime("14:30:12 am", "hh:mm:ss a"));

		// System.out.println(DateUtil.toTimestamp("01/19/1959","MM/dd/yyyy"));

		// System.out.println(convertStringToXMLGregorianCalendar("10/04/2013","dd/MM/yyyy"));

		//System.out.println(getValidDates("12/12/2012 12:12:12","dd.MM.yyyy","dd/MM/yyyy")); 

		System.out.println(getStartDayTimestamp("23/5/2013", "dd/MM/yyyy"));

		// System.out.println(logToTime(1335));
	}

}

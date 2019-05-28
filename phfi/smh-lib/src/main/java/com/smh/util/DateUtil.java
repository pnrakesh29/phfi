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


public final class DateUtil {

  private static SimpleDateFormat dateFormat = new SimpleDateFormat();

  public static String viewDateFormat = "dd/MM/yyyy";
  
  public static final String DATE_FORMAT= "MM/dd/yyyy";

  public static String viewDateTimeFormat = "dd/MM/yyyy HH:mm:ss";
  
  public static String viewDateMinFormat = "MM/dd/yyyy HH:mm";
  
  private static String START_TIME = " 00:00:00";
    
  private static String END_TIME = " 23:59:59";

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
   * Method to get Date as string from given date and pattern
   * 
   * @param date
   * @param pattern
   * @return
   */
  public static String toDateStringFormat(Date date, String pattern) {
    if(null != date) {
      dateFormat.applyPattern(pattern);
      return dateFormat.format(date);
    }
    else {
      return null;
    }
  }
  
  public static Date toDate(String date, String pattern) {
		dateFormat.applyPattern(pattern);
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
		}
		return null;

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
  @SuppressWarnings("deprecation")
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
  @SuppressWarnings("deprecation")
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

  public static XMLGregorianCalendar convertStringToXMLGregorianCalendar(String dateStr, String pattern) {
    XMLGregorianCalendar calendar = null;
    try {
      DateFormat format = new SimpleDateFormat(pattern);
      Date date = format.parse(dateStr);

      GregorianCalendar gregory = new GregorianCalendar();
      gregory.setTime(date);

      calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
    }
    catch(ParseException p) {
      p.printStackTrace();
    }
    catch(DatatypeConfigurationException e) {
      e.printStackTrace();
    }
    StringBuffer dateBuffer = new StringBuffer();
    dateBuffer.append(calendar.getDay() + "/" + calendar.getMonth() + "/" + calendar.getYear() + " "
                      + calendar.getHour() + ":" + calendar.getMinute() + ":" + calendar.getSecond());

    System.out.println(dateBuffer.toString());
    return calendar;
  }

  public static String convertXMLGregorianCalendartoString(XMLGregorianCalendar gregorianCalendar) {
    StringBuffer dateBuffer = new StringBuffer();
    dateBuffer.append(gregorianCalendar.getDay() + "/" + gregorianCalendar.getMonth() + "/"
                      + gregorianCalendar.getYear());
    return dateBuffer.toString();
  }

  public static String convertTime(long time) {
    long dividend = time / 60;
    long remainder = time % 60;
    long journeyDay = dividend / 24;

    long hour = dividend % 24;
    long min = remainder;

    String mins = String.valueOf(min);
    String hours = String.valueOf(hour);

    if(min / 10 == 0 || min == 0) {
      mins = "0" + mins;
    }
    if(hour / 10 == 0 || hour == 0) {
      hours = "0" + hours;
    }
    String timeString = hours + ":" + mins;

    if(journeyDay != 0) {
      timeString = timeString + ". Arrives Next day";
    }
    System.out.println(timeString);
    /*
     * System.out.println(timeString); // System.out.println("time is"+time);
     * Date date = new Date(time); // System.out.println("date"+date); Format
     * format = new SimpleDateFormat("HH:mm:ss"); return
     * format.format(date).toString();
     */
    return timeString;
  }

  public static String converToTime(long time) {
    long timeReminder = time % 60;
    long timeQuotient = time / 60;
    long hour = timeQuotient % 24;
    String endParameter = (hour > 12) ? " pm" : " am";
    hour = (hour > 12) ? hour - 12 : hour;
    String arrivalTime = String.valueOf(hour) + ":" + ((timeReminder < 10) ? "0" : "") + String.valueOf(timeReminder)
                         + endParameter;
    return arrivalTime;
  }

  public static String getValidDates(String dates, String pat, String oldFormat) throws ParseException {
    DateFormat originalFormat = new SimpleDateFormat(oldFormat);
    DateFormat targetFormat = new SimpleDateFormat(pat);
    Date date = originalFormat.parse(dates);
    String formattedDate = targetFormat.format(date);
    return formattedDate;
  }

  public static String getValidSysDate(String dates, String pat, String oldFormat) {
    if(oldFormat.indexOf(".") > -1) {
      oldFormat = oldFormat.replace(".", "/");
      dates = dates.replace(".", "/");
    }
    String formattedDate = null;
    try {
      DateFormat originalFormat = new SimpleDateFormat(oldFormat);
      // DateFormat targetFormat = new SimpleDateFormat(pat+" hh:mm:ss");
      DateFormat targetFormat = new SimpleDateFormat(pat);
      Date date = originalFormat.parse(dates);
      formattedDate = targetFormat.format(date);

    }
    catch(ParseException DPE) {
      System.out.println("Error DateUtil::getValidSysDate()" + DPE.getMessage());
    }
    return formattedDate;
  }

  /**
   * This method used for formated the current date and time.
   * 
   * @return String
   */
  public static String getFormattedTime() {
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
  
  /**
   * This method used for formated the current date and time.
   * 
   * @return String
   */
  public static Timestamp getOTPExpiryDateTime(Integer mins) {
    Calendar c = Calendar.getInstance();
    c.setTime(new Date());
    c.add(Calendar.MINUTE, mins);
    Timestamp timestamp=new Timestamp(c.getTimeInMillis());
    if(timestamp.before(new Date())) {
     
      System.out.println(timestamp+"before"+new Date());
    }
    else {
      System.out.println(timestamp+"after"+new Date());
    }
    return new Timestamp(c.getTimeInMillis());
  }


  /**
   * This method used for formated the current date and time.
   * 
   * @return String
   */
  public static Timestamp getExpiryDateTime(Integer days) {
    // CCYYMMDDHHMMSS
    Calendar c = Calendar.getInstance();
    c.setTime(new Date());
    c.add(Calendar.DAY_OF_MONTH, +days);
    c.set(Calendar.HOUR_OF_DAY, 23);
    c.set(Calendar.MINUTE, 59);
    c.set(Calendar.SECOND, 59);
    c.set(Calendar.MILLISECOND, 1);
    
    System.out.println(new Timestamp(c.getTimeInMillis()));
    
    Timestamp timestamp=new Timestamp(c.getTimeInMillis());
    
    System.out.println(timestamp.toString().substring(5, 7)+"/"+timestamp.toString().substring(2, 4));
    return new Timestamp(c.getTimeInMillis());
  }

  /**
   * This method used for formated the current date and time.
   * 
   * @return String
   */
  public static Timestamp getTokenExpiryDate(Integer days) {
    // CCYYMMDDHHMMSS
    Calendar c = Calendar.getInstance();
    c.setTime(new Date());
    c.add(Calendar.DAY_OF_MONTH, +days);
    c.set(Calendar.HOUR_OF_DAY, 23);
    c.set(Calendar.MINUTE, 59);
    c.set(Calendar.SECOND, 59);
    c.set(Calendar.MILLISECOND, 1);
    
    
    Timestamp timestamp=new Timestamp(c.getTimeInMillis());
    
    System.out.println(timestamp.toString().substring(5, 7)+"/"+timestamp.toString().substring(2, 4) );
    return timestamp;
  }
  
  public static Timestamp getTimeStamp(String mystring) {
    Timestamp timestamp = null;
    try {
      SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd hh:mm:ss.SSS");
      Date parsedDate = dateFormat.parse(mystring);
      timestamp = new java.sql.Timestamp(parsedDate.getTime());
    }
    catch(Exception e) {// this generic but you can control another types of
                        // exception
      // look the origin of excption
    }
    return timestamp;
  }
  
  
  public static boolean cardExpiry(String input) {
	    Date expiry = null;
	    Date date = null;
	   Calendar calendar = Calendar.getInstance();
	    String currentDate = calendar.get(Calendar.MONTH)+1+"/"+String.valueOf(calendar.get(Calendar.YEAR)).substring(String.valueOf(calendar.get(Calendar.YEAR)).length()-2);
	    if(input.matches("(?:0[1-9]|1[0-2])/[0-9]{2}")){
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
	    simpleDateFormat.setLenient(false);
	   
	    try {
	      expiry = simpleDateFormat.parse(input);
	      date = simpleDateFormat.parse(currentDate);
	    }
	    catch(ParseException e1) {
	      // TODO Auto-generated catch block
	      e1.printStackTrace();
	    }
	    }
	    boolean expired = expiry.before(date);
	    return expired;
	    
	  }
  
  
  public static Date toDate(String str_date){
    DateFormat formatter ; 
    Date date = null ; 
       formatter = new SimpleDateFormat("dd-MM-yy");
       try {
        date = formatter.parse(str_date);
        
        System.out.println(formatter.format(date));
      }
      catch(ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      return date;
  }
  
  /**
   * Method to append Time to date value at the end
   * 
   * @param date
   * @return
   */
  public static String appendFromTime(String date) {

    if(null != date) {
      if(date.contains(START_TIME.trim())) {
        //DO nothing
      }
      else {
        date += START_TIME;
      }
    }
    return date;

  }

  /**
   * Method to append Time to date value at the end
   * 
   * @param date
   * @return
   */
  public static String appendToTime(String date) {

    if(null != date) {
      if(date.contains(END_TIME.trim())) {
        //DO nothing
      }
      else {
        date += END_TIME;
      }
    }
    return date;

  }
  
  public static Timestamp addDaysToTimetsamp(Timestamp timestamp, int days){
	  Calendar calendar = Calendar.getInstance();
	  calendar.add(Calendar.HOUR, days*24);
	  timestamp.setTime(calendar.getTimeInMillis());
	  return timestamp;
  }

  public static Boolean compareTwoDate(String date){
		 Date currentDate = new Date();
		 Date dateTocomapre = toDate(date,"dd-MM-yy");
		 return currentDate.after(dateTocomapre);
	  }
  
	/**
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String formatTimestamp(Timestamp date) {

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		return sdf.format(date);

	}
	
	public static String timeStamptoStringFormat(Timestamp date, String pattern) {
		if(null != date) {
			dateFormat.applyPattern(pattern);
			return dateFormat.format(date);
		}
		else {
			return null;
		}
	}
	
  public static void main(String[] args) throws ParseException, DatatypeConfigurationException {
    // System.out.println("time is" + DateUtil.toTime("14:30:12 am",
    // "hh:mm:ss a"));

    // System.out.println(DateUtil.toTimestamp("01/19/1959","MM/dd/yyyy"));
    //System.out.println(DateUtil.toDate().toString());
    // System.out.println(convertStringToXMLGregorianCalendar("10/04/2013","dd/MM/yyyy"));

    // System.out.println(getValidDates("12/12/2012 12:12:12","dd.MM.yyyy","dd/MM/yyyy"));

    // System.out.println(getStartDayTimestamp("23/5/2013", "dd/MM/yyyy"));

    // System.out.println(logToTime(1335));
   // System.out.println(getExpiryDateTime(2));
	  System.out.println(cardExpiry("09/16"));
  }

}

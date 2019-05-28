/**
 * 
 */
package com.smh.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.smh.constants.PHFIWebConstant;


public final class StringUtil {

  /**
	 * 
	 */
  private StringUtil() {
    // TODO Auto-generated constructor stub
  }

  public static boolean isNullAndEmpty(String data) {
    return (data == null || "".equals(data.trim()));
  }

  @SuppressWarnings("rawtypes")
  public static boolean isListNotNullNEmpty(List list) {
    return (list != null && !list.isEmpty());
  }
  @SuppressWarnings("rawtypes")
  public static boolean isListNullNEmpty(List list) {
    return (list == null || list.isEmpty());
  }

  /**
   * @param number
   * @return
   */
  public static String toString(Number number) {
    if(null == number) {
      return "";
    }
    else {
      return String.valueOf(number);
    }
  }

  public static boolean isNullEmpty(String input) {
    return (input == null || "".equals(input.trim()));
  }

  public static String getDateValueForWSAPI(String raw, String time) {
    if(raw == null || "".equals(raw.trim()))
      return null;
    try {
      if(raw.indexOf("/") != -1 || raw.indexOf("-") != -1 || raw.indexOf(".") != -1) {
        String result = "";
        String splitVariable = (raw.indexOf("/") != -1) ? "/" : ((raw.indexOf("-") != -1) ? "-" : "\\.");
        String[] raws = raw.split(splitVariable);
        result = (raws[0].length() < 2) ? "0" + raws[0] : raws[0];
        result += "/" + ((raws[1].length() < 2) ? "0" + raws[1] : raws[1]);
        result += "/" + raws[2];
        result += " " + time;
        return result;
      }
    }
    catch(Exception e) {
      // TODO Auto-generated catch block
      // e.printStackTrace();
    }

    return null;
  }

  public static String toAmount(Object object) {
    String amount = "0.00";
    try {
      Double doubleValue = null;
      if(object != null) {
        doubleValue = Double.valueOf(object.toString());
        if(null != doubleValue) {
          amount = String.format("%.2f", doubleValue);
        }
      }
    }
    catch(NumberFormatException e) {
      // TODO Auto-generated catch block
      // e.printStackTrace();
    }
    return amount;
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  public static List startIndexList(int size, int index) {
    List list = new ArrayList();
    for(int i = 0; i <= size / index; i++) {
      list.add((i * index) + 1);

    }
    return list;
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  public static List endIndex(int size, int index) {
    List list = new ArrayList();
    if(size == 0) {
      list.add(1);
    }
    for(int i = 1; i <= size / index; i++) {
      list.add((i * index));

    }
    return list;
  }

  public static String[] converArray(String data) {
    if(!isNullEmpty(data)) {
      String arrayData[] = data.split(",");
      return arrayData;
    }
    return null;
  }

  public static String convertString(String[] arrayData) {
    if(arrayData != null && arrayData.length > 0) {
      StringBuilder sb = new StringBuilder();
      for(String arr : arrayData) {
        sb.append(arr + ",");
      }
      return sb.toString().substring(0, sb.toString().length() - 1);
    }
    return "";
  }

  /**
   * Method to convert String List to String array
   * 
   * @param featureList
   * @return
   */
  public static String convertListToString(List<String> featureList) {

    if(StringUtil.isListNotNullNEmpty(featureList)) {
      StringBuilder sb = new StringBuilder();
      for(String feature : featureList) {
        sb.append(feature + ",");
      }
      return sb.toString().substring(0, sb.toString().length() - 1);
    }
    return "";
  }




  /**
   * Method to validate Mobile Number
   * 
   * @param phone
   * @return
   */
  public static boolean validatePhone(String phone) {
    boolean flag = true;
    // if(phone.length()>=11)
    Pattern pattern = Pattern.compile("^[0-9]+$");
    Matcher matcher = pattern.matcher(phone);
    flag = matcher.matches();
    return flag;
  }


  public static Boolean checkEquality(String newValue, String oldValue, boolean mand) {
    if(mand)
      return (newValue.trim().equals(oldValue.trim())) ? true : false;
    else {
      newValue = (StringUtil.isNullAndEmpty(newValue)) ? "" : newValue.trim();
      oldValue = (StringUtil.isNullAndEmpty(oldValue)) ? "" : oldValue.trim();
      return (newValue.equals(oldValue)) ? true : false;
    }

  }
  
  /**
   * Method to get String based on Long value
   * 
   * @param value
   * @return
   */
  public static String getString(Long value) {
    if(null == value) {
      return null;
    }
    return value.toString();
  }
  
  /**
   * Method to get String based on Long value
   * 
   * @param value
   * @return
   */
  public static Long getLong(String value) {
    if(null == value) {
      return null;
    }
    try {
      return Long.valueOf(value);
    }
    catch(NumberFormatException e) {
      return null;
    }
  }
  
  /**
   * Method to get String based on Long value
   * 
   * @param value
   * @return
   */
  public static Long getLong(Long value) {
    if(null == value) {
      return 0L;
    }
    return value;
  }
  
  public static String getSupportedType(String BarType,String qrType)
  {
    if(!StringUtil.isNullAndEmpty(BarType) && StringUtil.isNullAndEmpty(qrType))
      return "|"+BarType+"|";
    else if(StringUtil.isNullAndEmpty(BarType) && !StringUtil.isNullAndEmpty(qrType))
      return "|"+qrType+"|";
    return "|"+BarType+"|"+qrType+"|";
    
  }

  
  public static  List<String> getSubCodeType(String codeType)
  {
    List<String> codeTypeList = new ArrayList<String>();
    codeType = codeType.substring(1, codeType.length()-1);
    if(codeType.contains("\\|"))
    {
      String[] codeTypeData = codeType.split("\\|");
      for(String data:codeTypeData)
        codeTypeList.add(data);
    }
    else
      codeTypeList.add(codeType);
        
    return codeTypeList;
  }
  
  public static boolean validateUserName(String userName) {
	    Pattern pattern;
	    Matcher matcher;
	    final String USERNAME_PATTERN = "^[A-Za-z0-9 _]+$";
	    pattern = Pattern.compile(USERNAME_PATTERN);
	    matcher = pattern.matcher(userName);
	    return matcher.matches();
	  }
  
  public static boolean isNull(Object input) {
		return (input == null);
	}
  
  public static String getCookieValue(HttpServletRequest request) {
	    Cookie[] cookies = request.getCookies();
	    String cookieValue = "DUMMY_COOKIETEST";
	    for(Cookie cookie : cookies) {
	      if(PHFIWebConstant.COOKIE_CHATAK_NAME.equalsIgnoreCase(cookie.getName())) {
	        cookieValue = cookie.getValue();
	        break;
	      }
	    }
	    return cookieValue;
	  }
  
}

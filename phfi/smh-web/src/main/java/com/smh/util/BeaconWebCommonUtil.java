package com.smh.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.BeanUtils;

@SuppressWarnings("rawtypes")
public final class BeaconWebCommonUtil {

	
	public static boolean isNullAndEmpty(String data) {
	    return (data == null || "".equals(data.trim()));
	  }
	
	public static boolean isListNotNullAndEmpty(List list) {
		return (list != null && !list.isEmpty());
	}
	
	public static String generateRandomNumber(int length) {
	    StringBuffer sb = new StringBuffer();
	    Random random = new Random();
	    for(int n = 0; n < length; n++) {
	      int j = (Math.abs(random.nextInt()) % 10);
	      // If First digit is "0", skip that and get next random
	      if(n == 0 && j == 0) {
	        n--;
	        continue;
	      }
	      sb.append(Integer.toString(j));
	    }
	    return sb.toString();
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
	      e.printStackTrace();
	    }
	    return amount;
	  }
	
	/**
	   * This method generate the random numeric value based on length
	   * 
	   * @param length
	   * @return String
	   */
	  public static String generateRandNumeric(int length) {
	    String finalRandString = "";
	    Random randomObj = new Random();
	    for(int j = 0; j < length; j++) {
	      int rand_int = randomObj.nextInt(72);
	      finalRandString += rand_int;
	      if(finalRandString.length() >= length) {
	        finalRandString = finalRandString.substring(0, length);
	        break;
	      }
	    }
	    return finalRandString;
	  }
		/**
		 * Method to copy the the list of beans properties from source to destination class bean
		 * @param sourceList
		 * @param D
		 * @return
		 * @throws InstantiationException
		 * @throws IllegalAccessException
		 */
		@SuppressWarnings("unchecked")
		public static <Source, Destination> List<Destination> copyListBeanProperty(Iterable<Source> sourceList, Class Destiniation) throws InstantiationException, IllegalAccessException {
			List<Destination> list = new ArrayList<Destination>();
			for (Source source: sourceList) {
				list.add((Destination) copyBeanProperties(source, Destiniation));
			}
			return list;
		}
		
		

		/**
		 * Method to copy the the bean properties from source to destination class bean
		 * @param source
		 * @param Destination
		 * @return
		 * @throws InstantiationException
		 * @throws IllegalAccessException
		 */
		@SuppressWarnings("unchecked")
		public static <Source, Destination> Destination copyBeanProperties(Source source, Class Destination) throws InstantiationException, IllegalAccessException{
			Destination destination = (Destination) Destination.newInstance();
			BeanUtils.copyProperties(source, destination);
			return destination;
		}
		
		/**
		 * This method is used to copy the not null properties from source object to destination object.
		 * 
		 * @param source
		 * @param destination
		 * @throws Exception
		 */
		public static <Source, Destination> void copyProperties(Source source, Destination destination) throws Exception {
		    for (Method method : source.getClass().getDeclaredMethods()) {
		    	try{
		    		String methodName = method.getName();
		    		if(methodName.startsWith("get")){
		    			methodName = methodName.replaceFirst("get", "set");
		    			String args = null;
		    			Object value =  method.invoke(source, args);
		    			if(value != null){
			    			Method method2 = destination.getClass().getMethod(methodName, value.getClass());
			    			method2.invoke(destination, value);
		    			}
		    		}
		    	}catch(Exception e){
		    	}
		    }
		  }

		
		/*public static Long getLongAmount(Double amount){
			return (amount == null ? null : ((long) (amount * HUNDRED)));
		}
		
		public static Double getDoubleAmount(Long amount){
			return (amount == null ? null : ((double) (amount / HUNDRED)));
		}*/
}

/**
 * 
 */
package com.smh.smssender.service.impl;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"unchecked", "rawtypes"})
public class SMSThreadLocal {

	private static Map threadMap = new HashMap();
	 
	public static void add(Object object) {
        threadMap.put(Thread.currentThread(), object);
    }
 
    public static void remove(Object object) {
        threadMap.remove(Thread.currentThread());
    }
 
    public static Object get() {
        return threadMap.get(Thread.currentThread());
    }
}

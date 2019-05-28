package com.smh.util;



import java.io.IOException;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;



public final class Properties extends PropertyPlaceholderConfigurer {

	// Property key for propsExported
	private static java.util.Properties propsExported = new java.util.Properties();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.core.io.support.PropertiesLoaderSupport#mergeProperties
	 * ()
	 */
	public java.util.Properties mergeProperties() throws IOException {
		propsExported = super.mergeProperties();
		return propsExported;
	}

	/**
	 * Get the value of given key from the property file
	 * 
	 * @param key
	 * @return
	 */
	public static String getProperty(final String key) {
		String value = propsExported.getProperty(key);
		return ((value == null) ? "" : value);
	}
}

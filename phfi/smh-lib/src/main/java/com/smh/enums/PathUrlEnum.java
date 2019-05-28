package com.smh.enums;

public enum PathUrlEnum {

	CHATAK_ADMIN_PATH_URL_ENUM("path-url-enum");

	private String url;

	PathUrlEnum() {
	}

	private PathUrlEnum(String url) {
		this.url = url;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
}

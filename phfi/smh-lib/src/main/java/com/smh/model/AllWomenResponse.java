/**
 * 
 */
package com.smh.model;

import java.util.List;

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Mar 6, 2016 10:19:19 PM
 * @version 1.0
 */
public class AllWomenResponse extends Response {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6898654500678882280L;
	List<String> womanName;
	/**
	 * @return the womanName
	 */
	public List<String> getWomanName() {
		return womanName;
	}
	/**
	 * @param womanName the womanName to set
	 */
	public void setWomanName(List<String> womanName) {
		this.womanName = womanName;
	}
}

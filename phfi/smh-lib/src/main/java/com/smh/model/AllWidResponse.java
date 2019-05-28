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
 * @date Mar 6, 2016 10:17:49 PM
 * @version 1.0
 */
public class AllWidResponse extends Response{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5868400862887620525L;
	private List<Integer> wid;
	/**
	 * @return the wid
	 */
	public List<Integer> getWid() {
		return wid;
	}
	/**
	 * @param wid the wid to set
	 */
	public void setWid(List<Integer> wid) {
		this.wid = wid;
	}
}

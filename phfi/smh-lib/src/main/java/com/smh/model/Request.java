/**
 * 
 */
package com.smh.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Request implements Serializable {

	/**
   * 
   */
	private static final long serialVersionUID = 6781313786877782012L;

	private String createdBy;

	private String orginChannel;

	private Long originTimestamp;

	private String name;
	
	private Long id;
	
	private String status;
	
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public Long getOriginTimestamp() {
		return originTimestamp;
	}

	public void setOriginTimestamp(Long originTimestamp) {
		this.originTimestamp = originTimestamp;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the orginChannel
	 */
	public String getOrginChannel() {
		return orginChannel;
	}

	/**
	 * @param orginChannel
	 *            the orginChannel to set
	 */
	public void setOrginChannel(String orginChannel) {
		this.orginChannel = orginChannel;
	}

  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {
    this.id = id;
  }

}

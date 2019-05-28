/**
 * 
 */
package com.smh.model;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL) 
public class Response implements Serializable {


  /**
   * 
   */
  private static final long serialVersionUID = -8793812026991479051L;

  private String responseCode;

  private String responseMessage;
  
  private String responseMessageExt;
  
  private Long txnDateTime;
  
  private List<?> responseList;
  
  private Integer noOfRecords;
  
  private String responseStatus;


	/**
	 * @return the noOfRecords
	 */
	public Integer getNoOfRecords() {
		return noOfRecords;
	}
	
	/**
	 * @param noOfRecords the noOfRecords to set
	 */
	public void setNoOfRecords(Integer noOfRecords) {
		this.noOfRecords = noOfRecords;
	}


  /**
   * @return the txnDateTime
   */
  public Long getTxnDateTime() {
    return txnDateTime;
  }

  /**
   * @param txnDateTime the txnDateTime to set
   */
  public void setTxnDateTime(Long txnDateTime) {
    this.txnDateTime = txnDateTime;
  }

  /**
   * @return the responseList
   */
  public List<?> getResponseList() {
    return responseList;
  }

  /**
   * @param responseList the responseList to set
   */
  public void setResponseList(List<?> responseList) {
    this.responseList = responseList;
  }

  /**
   * @return the responseCode
   */
  public String getResponseCode() {
    return responseCode;
  }

  /**
   * @param responseCode the responseCode to set
   */
  public void setResponseCode(String responseCode) {
    this.responseCode = responseCode;
  }

  /**
   * @return the responseMessage
   */
  public String getResponseMessage() {
    return responseMessage;
  }

  /**
   * @param responseMessage the responseMessage to set
   */
  public void setResponseMessage(String responseMessage) {
    this.responseMessage = responseMessage;
  }

  /**
   * @return the responseMessageExt
   */
  public String getResponseMessageExt() {
    return responseMessageExt;
  }

  /**
   * @param responseMessageExt the responseMessageExt to set
   */
  public void setResponseMessageExt(String responseMessageExt) {
    this.responseMessageExt = responseMessageExt;
  }


  /**
   * @return the responseStatus
   */
  public String getResponseStatus() {
    return responseStatus;
  }

  /**
   * @param responseStatus the responseStatus to set
   */
  public void setResponseStatus(String responseStatus) {
    this.responseStatus = responseStatus;
  }

  
  
}

/**
 * 
 */
package com.smh.exception;

public class BeaconServiceException extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = 7375272986220181341L;
  
	private String httpStatusCode;
	private String message;
	private String reason;
	private String errorCode;
  
  /**
   * 
   */
  public BeaconServiceException() {
    super();
  }

  /**
   * @param arg0
   */
  public BeaconServiceException(String arg0) {
    super(arg0);
  }

  /**
   * @param arg0
   */
  public BeaconServiceException(Throwable arg0) {
    super(arg0);
  }

  /**
   * @param arg0
   * @param arg1
   */
  public BeaconServiceException(String arg0, Throwable arg1) {
    super(arg0, arg1);
  }

  /**
   * 
   * @param errorCode
   * @param errorMessage
   */
  public BeaconServiceException(String errorCode, String errorMessage) {
	    setErrorCode(errorCode);
	    setMessage(errorMessage);
	  }
  
  /**
   * 
   * @param ex
   * @param httpStatusCode
   * @param message
   * @param reason
   * @param errorCode
   */
  public BeaconServiceException(Exception ex, String httpStatusCode,
			String message, String reason, String errorCode) {
		initCause(ex);
		setHttpStatusCode(httpStatusCode);
		setMessage(message);
		setReason(reason);
		setErrorCode(errorCode);
	}

	public String getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(String httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}

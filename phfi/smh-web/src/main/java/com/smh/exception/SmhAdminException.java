/**
 * 
 */
package com.smh.exception;

public class SmhAdminException extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = 7375272986220181341L;
  
  /**
   * 
   */
  public SmhAdminException() {
    super();
  }

  /**
   * @param arg0
   */
  public SmhAdminException(String arg0) {
    super(arg0);
  }

  /**
   * @param arg0
   */
  public SmhAdminException(Throwable arg0) {
    super(arg0);
  }

  /**
   * @param arg0
   * @param arg1
   */
  public SmhAdminException(String arg0, Throwable arg1) {
    super(arg0, arg1);
  }

}

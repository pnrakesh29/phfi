package com.smh.model;;

public class SecurityQuestionResponse extends Response{

  /**
   * 
   */
  private static final long serialVersionUID = -4623452528932056932L;
  
  private String securityQuestion;
  
  private String userName;

  /**
   * @return the securityQuestion
   */
  public String getSecurityQuestion() {
    return securityQuestion;
  }

  /**
   * @param securityQuestion the securityQuestion to set
   */
  public void setSecurityQuestion(String securityQuestion) {
    this.securityQuestion = securityQuestion;
  }

  /**
   * @return the userName
   */
  public String getUserName() {
    return userName;
  }

  /**
   * @param userName the userName to set
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }
  
  

}

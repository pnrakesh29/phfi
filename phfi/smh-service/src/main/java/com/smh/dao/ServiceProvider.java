package com.smh.dao;

import com.smh.model.SearchRequest;

/**
*
* << Add Comments Here >>
*
* @author Shekhar Prasad
* @date 21-Dec-2015 10:46:11 AM
* @version 1.0
*/
public class ServiceProvider extends SearchRequest {
	/**
	 * 
	 */
	private static final long serialVersionUID = 644109212251290840L;
	private Long SERVICE_PROVIDER_ID ;
	private Long SUBSERVICE_PROVIDER_ID ;
	private String NAME	;
	private String DESCRIPTION	;
	private String ADDRESS1;
	private String ADDRESS2	;
	private String CITY	;
	private String STATE;
	private String COUNTRY;
	private Long ZIP;
	private Long PHONE;
	private String  EMAIL;
	private String SP_WEBSITE;
	private String STATUS;
	private Long SERVICE_TSM_ID;
	private Long SERVICE_SP_ID;
	private String SERVICE_TYPE;
	private String SP_TYPE;
	private String DOMAIN;
	private String ORDER_BY;
	private String SSP_STATUS;
	private String CREATED_BY;
	private String UPDATED_BY;
	private String REASON;
	private String requestFrom;
	
	/**
	 * @return the sERVICE_PROVIDER_ID
	 */
	public Long getSERVICE_PROVIDER_ID() {
		return SERVICE_PROVIDER_ID;
	}
	/**
	 * @param sERVICE_PROVIDER_ID the sERVICE_PROVIDER_ID to set
	 */
	public void setSERVICE_PROVIDER_ID(Long sERVICE_PROVIDER_ID) {
		SERVICE_PROVIDER_ID = sERVICE_PROVIDER_ID;
	}
	/**
	 * @return the nAME
	 */
	public String getNAME() {
		return NAME;
	}
	/**
	 * @param nAME the nAME to set
	 */
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	/**
	 * @return the dESCRIPTION
	 */
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	/**
	 * @param dESCRIPTION the dESCRIPTION to set
	 */
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	/**
	 * @return the aDDRESS1
	 */
	public String getADDRESS1() {
		return ADDRESS1;
	}
	/**
	 * @param aDDRESS1 the aDDRESS1 to set
	 */
	public void setADDRESS1(String aDDRESS1) {
		ADDRESS1 = aDDRESS1;
	}
	/**
	 * @return the aDDRESS2
	 */
	public String getADDRESS2() {
		return ADDRESS2;
	}
	/**
	 * @param aDDRESS2 the aDDRESS2 to set
	 */
	public void setADDRESS2(String aDDRESS2) {
		ADDRESS2 = aDDRESS2;
	}
	/**
	 * @return the cITY
	 */
	public String getCITY() {
		return CITY;
	}
	/**
	 * @param cITY the cITY to set
	 */
	public void setCITY(String cITY) {
		CITY = cITY;
	}
	/**
	 * @return the sTATE
	 */
	public String getSTATE() {
		return STATE;
	}
	/**
	 * @param sTATE the sTATE to set
	 */
	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}
	/**
	 * @return the cOUNTRY
	 */
	public String getCOUNTRY() {
		return COUNTRY;
	}
	/**
	 * @param cOUNTRY the cOUNTRY to set
	 */
	public void setCOUNTRY(String cOUNTRY) {
		COUNTRY = cOUNTRY;
	}
	/**
	 * @return the zIP
	 */
	public Long getZIP() {
		return ZIP;
	}
	/**
	 * @param zIP the zIP to set
	 */
	public void setZIP(Long zIP) {
		ZIP = zIP;
	}
	/**
	 * @return the pHONE
	 */
	public Long getPHONE() {
		return PHONE;
	}
	/**
	 * @param pHONE the pHONE to set
	 */
	public void setPHONE(Long pHONE) {
		PHONE = pHONE;
	}
	/**
	 * @return the eMAIL
	 */
	public String getEMAIL() {
		return EMAIL;
	}
	/**
	 * @param eMAIL the eMAIL to set
	 */
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	/**
	 * @return the sP_WEBSITE
	 */
	public String getSP_WEBSITE() {
		return SP_WEBSITE;
	}
	/**
	 * @param sP_WEBSITE the sP_WEBSITE to set
	 */
	public void setSP_WEBSITE(String sP_WEBSITE) {
		SP_WEBSITE = sP_WEBSITE;
	}
	/**
	 * @return the sTATUS
	 */
	public String getSTATUS() {
		return STATUS;
	}
	/**
	 * @param sTATUS the sTATUS to set
	 */
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	
	public Long getSERVICE_TSM_ID() {
		return SERVICE_TSM_ID;
	}
	
	public void setSERVICE_TSM_ID(Long sERVICE_TSM_ID) {
		SERVICE_TSM_ID = sERVICE_TSM_ID;
	}
	
	public Long getSERVICE_SP_ID() {
		return SERVICE_SP_ID;
	}
	
	public void setSERVICE_SP_ID(Long sERVICE_SP_ID) {
		SERVICE_SP_ID = sERVICE_SP_ID;
	}
	
	public String getSERVICE_TYPE() {
		return SERVICE_TYPE;
	}
	
	public void setSERVICE_TYPE(String sERVICE_TYPE) {
		SERVICE_TYPE = sERVICE_TYPE;
	}
	
	public String getDOMAIN() {
		return DOMAIN;
	}
	
	public void setDOMAIN(String dOMAIN) {
		DOMAIN = dOMAIN;
	}
	public String getSP_TYPE() {
		return SP_TYPE;
	}
	public void setSP_TYPE(String sP_TYPE) {
		SP_TYPE = sP_TYPE;
	}
	/**
	 * @return the sUBSERVICE_PROVIDER_ID
	 */
	public Long getSUBSERVICE_PROVIDER_ID() {
		return SUBSERVICE_PROVIDER_ID;
	}
	/**
	 * @param sUBSERVICE_PROVIDER_ID the sUBSERVICE_PROVIDER_ID to set
	 */
	public void setSUBSERVICE_PROVIDER_ID(Long sUBSERVICE_PROVIDER_ID) {
		SUBSERVICE_PROVIDER_ID = sUBSERVICE_PROVIDER_ID;
	}
  public String getORDER_BY() {
    return ORDER_BY;
  }
  public void setORDER_BY(String oRDER_BY) {
    ORDER_BY = oRDER_BY;
  }
  public String getSSP_STATUS() {
    return SSP_STATUS;
  }
  public void setSSP_STATUS(String sSP_STATUS) {
    SSP_STATUS = sSP_STATUS;
  }
  
  /**
 * @return the cREATED_BY
 */
public String getCREATED_BY() {
	return CREATED_BY;
}
/**
 * @param cREATED_BY the cREATED_BY to set
 */
public void setCREATED_BY(String cREATED_BY) {
	CREATED_BY = cREATED_BY;
}
/**
 * @return the uPDATED_BY
 */
public String getUPDATED_BY() {
	return UPDATED_BY;
}
/**
 * @param uPDATED_BY the uPDATED_BY to set
 */
public void setUPDATED_BY(String uPDATED_BY) {
	UPDATED_BY = uPDATED_BY;
}
/**
   * @return the requestFrom
   */
  public String getRequestFrom() {
    return requestFrom;
  }
  /**
   * @param requestFrom the requestFrom to set
   */
  public void setRequestFrom(String requestFrom) {
    this.requestFrom = requestFrom;
  }
  /**
   * @return the rEASON
   */
  public String getREASON() {
    return REASON;
  }
  /**
   * @param rEASON the rEASON to set
   */
  public void setREASON(String rEASON) {
    REASON = rEASON;
  }
    
}

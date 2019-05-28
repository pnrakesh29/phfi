/**
 * 
 */
package com.smh.model;

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Jan 24, 2016 12:00:28 PM
 * @version 1.0
 */
public class ReportRequest extends SearchRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3240471422238021775L;

	private Integer slNo;
	private String fullName;
	private Integer wid;
	private String obstetricScore;
	private Integer daysToDeliver;
	private String findings;
	private String clinicalAssesment;
	private String clinicalStatus;
	private String nameOfAsha;
	private String villageName;
	private Integer age;
	private String cast;
	private String trimester;
	private String noOfVisit;
	private String maternityStatus;
	
	
	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * @return the wid
	 */
	public Integer getWid() {
		return wid;
	}
	/**
	 * @param wid the wid to set
	 */
	public void setWid(Integer wid) {
		this.wid = wid;
	}
	/**
	 * @return the obstetricScore
	 */
	public String getObstetricScore() {
		return obstetricScore;
	}
	/**
	 * @param obstetricScore the obstetricScore to set
	 */
	public void setObstetricScore(String obstetricScore) {
		this.obstetricScore = obstetricScore;
	}
	/**
	 * @return the daysToDeliver
	 */
	public Integer getDaysToDeliver() {
		return daysToDeliver;
	}
	/**
	 * @param daysToDeliver the daysToDeliver to set
	 */
	public void setDaysToDeliver(Integer daysToDeliver) {
		this.daysToDeliver = daysToDeliver;
	}
	/**
	 * @return the findings
	 */
	public String getFindings() {
		return findings;
	}
	/**
	 * @param findings the findings to set
	 */
	public void setFindings(String findings) {
		this.findings = findings;
	}
	/**
	 * @return the clinicalAssesment
	 */
	public String getClinicalAssesment() {
		return clinicalAssesment;
	}
	/**
	 * @param clinicalAssesment the clinicalAssesment to set
	 */
	public void setClinicalAssesment(String clinicalAssesment) {
		this.clinicalAssesment = clinicalAssesment;
	}
	/**
	 * @return the clinicalStatus
	 */
	public String getClinicalStatus() {
		return clinicalStatus;
	}
	/**
	 * @param clinicalStatus the clinicalStatus to set
	 */
	public void setClinicalStatus(String clinicalStatus) {
		this.clinicalStatus = clinicalStatus;
	}
	/**
	 * @return the nameOfAsha
	 */
	public String getNameOfAsha() {
		return nameOfAsha;
	}
	/**
	 * @param nameOfAsha the nameOfAsha to set
	 */
	public void setNameOfAsha(String nameOfAsha) {
		this.nameOfAsha = nameOfAsha;
	}
	/**
	 * @return the villageName
	 */
	public String getVillageName() {
		return villageName;
	}
	/**
	 * @param villageName the villageName to set
	 */
	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}
	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * @return the cast
	 */
	public String getCast() {
		return cast;
	}
	/**
	 * @param cast the cast to set
	 */
	public void setCast(String cast) {
		this.cast = cast;
	}
	/**
	 * @return the trimester
	 */
	public String getTrimester() {
		return trimester;
	}
	/**
	 * @param trimester the trimester to set
	 */
	public void setTrimester(String trimester) {
		this.trimester = trimester;
	}
	/**
	 * @return the noOfVisit
	 */
	public String getNoOfVisit() {
		return noOfVisit;
	}
	/**
	 * @param noOfVisit the noOfVisit to set
	 */
	public void setNoOfVisit(String noOfVisit) {
		this.noOfVisit = noOfVisit;
	}
	/**
	 * @return the slNo
	 */
	public Integer getSlNo() {
		return slNo;
	}
	/**
	 * @param slNo the slNo to set
	 */
	public void setSlNo(Integer slNo) {
		this.slNo = slNo;
	}
	/**
	 * @return the maternityStatus
	 */
	public String getMaternityStatus() {
		return maternityStatus;
	}
	/**
	 * @param maternityStatus the maternityStatus to set
	 */
	public void setMaternityStatus(String maternityStatus) {
		this.maternityStatus = maternityStatus;
	}
}

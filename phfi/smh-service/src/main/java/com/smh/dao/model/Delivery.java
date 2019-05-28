/**
 * 
 */
package com.smh.dao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Jan 21, 2016 10:59:04 PM
 * @version 1.0
 */
@Entity
@Table(name="DELIVERY")
public class Delivery implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9133099136764153777L;
	@Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
	
	@Column(name = "WOMAN_NAME")
	private String womanName;
	
	@Column(name = "WID")
	private Integer wid;
	
	@Column(name = "VISIT_DATE")
	private String visitDate;
	
	@Column(name = "DELIVERY_DATE")
	private String deliveryDate;
	
	@Column(name = "PREGNANCY_LAST")
	private String pregnancyLast;
	
	@Column(name = "IS_BABY_ALIVE")
	private String isBabyAlive;
	
	@Column(name = "DELIVERY_PLACE")
	private String deliveryPlace;
	
	@Column(name = "OTHER_PLACE")
	private String otherPlace;
	
	@Column(name = "DELIVERY_CONDUCTEDBY")
	private String deliveryConductedBy;
	
	@Column(name = "DELIVERY_TYPE")
	private String deliveryType;
	
	@Column(name = "BABY_WEIGHT")
	private String babyWeight;
	
	@Column(name = "ISEXCE_BLEEDING")
	private String isExcessiveBleeding;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the womanName
	 */
	public String getWomanName() {
		return womanName;
	}

	/**
	 * @param womanName the womanName to set
	 */
	public void setWomanName(String womanName) {
		this.womanName = womanName;
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
	 * @return the visitDate
	 */
	public String getVisitDate() {
		return visitDate;
	}

	/**
	 * @param visitDate the visitDate to set
	 */
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

	

	/**
	 * @return the pregnancyLast
	 */
	public String getPregnancyLast() {
		return pregnancyLast;
	}

	/**
	 * @param pregnancyLast the pregnancyLast to set
	 */
	public void setPregnancyLast(String pregnancyLast) {
		this.pregnancyLast = pregnancyLast;
	}

	/**
	 * @return the isBabyAlive
	 */
	public String getIsBabyAlive() {
		return isBabyAlive;
	}

	/**
	 * @param isBabyAlive the isBabyAlive to set
	 */
	public void setIsBabyAlive(String isBabyAlive) {
		this.isBabyAlive = isBabyAlive;
	}

	/**
	 * @return the deliveryPlace
	 */
	public String getDeliveryPlace() {
		return deliveryPlace;
	}

	/**
	 * @param deliveryPlace the deliveryPlace to set
	 */
	public void setDeliveryPlace(String deliveryPlace) {
		this.deliveryPlace = deliveryPlace;
	}

	/**
	 * @return the otherPlace
	 */
	public String getOtherPlace() {
		return otherPlace;
	}

	/**
	 * @param otherPlace the otherPlace to set
	 */
	public void setOtherPlace(String otherPlace) {
		this.otherPlace = otherPlace;
	}

	/**
	 * @return the deliveryConductedBy
	 */
	public String getDeliveryConductedBy() {
		return deliveryConductedBy;
	}

	/**
	 * @param deliveryConductedBy the deliveryConductedBy to set
	 */
	public void setDeliveryConductedBy(String deliveryConductedBy) {
		this.deliveryConductedBy = deliveryConductedBy;
	}

	/**
	 * @return the deliveryType
	 */
	public String getDeliveryType() {
		return deliveryType;
	}

	/**
	 * @param deliveryType the deliveryType to set
	 */
	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	/**
	 * @return the babyWeight
	 */
	public String getBabyWeight() {
		return babyWeight;
	}

	/**
	 * @param babyWeight the babyWeight to set
	 */
	public void setBabyWeight(String babyWeight) {
		this.babyWeight = babyWeight;
	}

	/**
	 * @return the isExcessiveBleeding
	 */
	public String getIsExcessiveBleeding() {
		return isExcessiveBleeding;
	}

	/**
	 * @param isExcessiveBleeding the isExcessiveBleeding to set
	 */
	public void setIsExcessiveBleeding(String isExcessiveBleeding) {
		this.isExcessiveBleeding = isExcessiveBleeding;
	}

	/**
	 * @return the deliveryDate
	 */
	public String getDeliveryDate() {
		return deliveryDate;
	}

	/**
	 * @param deliveryDate the deliveryDate to set
	 */
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

}

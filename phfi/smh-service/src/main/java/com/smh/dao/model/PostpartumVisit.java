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
 * @date Jan 16, 2016 11:37:31 PM
 * @version 1.0
 */
@Entity
@Table(name="POSTPARTUM_VISIT")
public class PostpartumVisit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5505224016329340291L;
	
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
	
	@Column(name = "HAVE_FEVER")
	private String haveFever;
	 
	@Column(name = "ISFEVER_ASSOCATED")
	private String isFeverAssocated;
	 
	@Column(name = "ISFEVER_COMEANDGO")
	private String isFeverComeAndGo;
	 
	@Column(name = "IS_FEEL_TIRED")
	private String isFeelTired;
	 
	@Column(name = "IS_FITS")
	private String isFits;
	 
	@Column(name = "IS_CONSCIOUSNESS")
	private String isConsciousness;
	 
	@Column(name = "HAVE_HEADACHES")
	private String haveHeadaches;
	 
	@Column(name = "BLURRED_VISION")
	private String haveBlurredVision;
	
	@Column(name = "ISDIFFICULT_FEED")
	private String isDifficultToFeed;
	
	@Column(name = "PAIN_IN_BREAST")
	private String painInBreast;
	
	@Column(name = "LUMP_IN_BREAST")
	private String lumpInBreast;
	
	
	@Column(name = "IS_BREATHLESS")
	private String isBreathless;
	 
	 @Column(name = "WHEN_BREATHLESS")
	private String whenBreathless;
	 
	@Column(name = "HAVE_COUGH")
	private String haveCough;
	 
	@Column(name = "HOWLONG_HAVECOUGH")
	private String howLongHaveCough;
	 
	@Column(name = "IS_ABDOMINAL_PAIN")
	private String isAbdominalPain;
	 
	@Column(name = "WHERE_PAIN")
	private String wherePain;
	 
	@Column(name = "BABY_MOVE")
	private String babyMove;
	 
	@Column(name = "IS_VAGINAL_DIS")
	private String isVaginalDischarge;
	 
	@Column(name = "IS_BLEEDING")
	private String isBleeding;
	
	@Column(name = "NO_DAY_AFTER_DEL")
	private String noDayAfterDel;
	
	@Column(name = "NO_OF_CLOTHES")
	private String noOfClothes;
	
	@Column(name = "ISPASSCLOT_BLEEDING")
	private String isPassClotBleeding;
	
	@Column(name = "HAS_BLEEDING_INCREASE")
	private String hasBleedingIncrease;
	
	@Column(name = "IS_BURNING_PAIN")
	private String isBurningPain;
	
	@Column(name = "IS_OUT_OFBREATH")
	private String isoutOfBreath;
	
	@Column(name = "IS_TALKING")
	private String isTalking;
	
	@Column(name = "UPPER_EYE_COLOR")
	private String upperEyeColor;
	
	@Column(name = "LOWER_EYE_COLOR")
	private String lowerEyeColor;
	
	@Column(name = "IS_ANKLE_DEPRESS")
	private String isAnkleDepression;
	
	@Column(name = "IS_EYE_SWELLING")
	private String isEyeSwelling;
	 
	@Column(name = "BP")
	private String bp;
	 
	@Column(name = "FIRST_BP")
	private String firstBp;
	 
	@Column(name = "SEC_BP")
	private String secBp;
	 
	@Column(name = "BP_DATE_ONE")
	private String bpDateOne;
	 
	@Column(name = "BP_DATE_SEC")
	private String bpDateSec;
	 
	@Column(name = "HB")
	private String hb;
	 
	@Column(name = "FIRST_HB")
	private String firstHb;
	 
	@Column(name = "SEC_HB")
	private String secHb;
	 
	@Column(name = "HB_DATE_ONE")
	private String hbDateOne;
	
	@Column(name = "HB_DATE_SEC")
	private String hbDateSec;
	
	@Column(name = "URINE")	
	private String urine;
	
	@Column(name = "FIRST_URINE")
	private String firstUrine;
	
	@Column(name = "SEC_URINE")
	private String secUrine;
	
	@Column(name = "URINE_DATE_ONE")
	private String urineDateOne;
	
	@Column(name = "URINE_DATE_SEC")
	private String urineDateSec;
	
	@Column(name = "MALARIA")
	private String malaria;
	 
	@Column(name = "FIRST_MALARIA")
	private String firstMalaria;
	 
	@Column(name = "SEC_MALARIA")
	private String secMalaria;
	
	@Column(name = "MALARIA_DATE_ONE")
	private String malariaDateOne;
	 
	@Column(name = "MALARIA_DATE_SEC")
	private String malariaDateSec;
	 
	@Column(name = "SPUTUM")
	private String sputum;
	 
	@Column(name = "SPUTUM_TEST")
	private String sputumTest;
	 
	@Column(name = "SPUTUM_DATE")
	private String sputumDate;
	 
	@Column(name = "TALKING_IRRELEVANTLY")
	private String  talkingIrrelevantly;
	
	@Column(name = "ISHEARING_IMAGINARY")
	private String  isHearingImaginary;
	
	@Column(name = "CARRING_BABYANDHERSELF")
	private String  carringBabyAndHerself;
	
	@Column(name = "CREATED_DATE")
    private String createdDate;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "UPDATED_DATE")
    private String updatedDate;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

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
	 * @return the haveFever
	 */
	public String getHaveFever() {
		return haveFever;
	}

	/**
	 * @param haveFever the haveFever to set
	 */
	public void setHaveFever(String haveFever) {
		this.haveFever = haveFever;
	}

	/**
	 * @return the isFeverAssocated
	 */
	public String getIsFeverAssocated() {
		return isFeverAssocated;
	}

	/**
	 * @param isFeverAssocated the isFeverAssocated to set
	 */
	public void setIsFeverAssocated(String isFeverAssocated) {
		this.isFeverAssocated = isFeverAssocated;
	}

	/**
	 * @return the isFeverComeAndGo
	 */
	public String getIsFeverComeAndGo() {
		return isFeverComeAndGo;
	}

	/**
	 * @param isFeverComeAndGo the isFeverComeAndGo to set
	 */
	public void setIsFeverComeAndGo(String isFeverComeAndGo) {
		this.isFeverComeAndGo = isFeverComeAndGo;
	}

	/**
	 * @return the isFeelTired
	 */
	public String getIsFeelTired() {
		return isFeelTired;
	}

	/**
	 * @param isFeelTired the isFeelTired to set
	 */
	public void setIsFeelTired(String isFeelTired) {
		this.isFeelTired = isFeelTired;
	}

	/**
	 * @return the isFits
	 */
	public String getIsFits() {
		return isFits;
	}

	/**
	 * @param isFits the isFits to set
	 */
	public void setIsFits(String isFits) {
		this.isFits = isFits;
	}

	/**
	 * @return the isConsciousness
	 */
	public String getIsConsciousness() {
		return isConsciousness;
	}

	/**
	 * @param isConsciousness the isConsciousness to set
	 */
	public void setIsConsciousness(String isConsciousness) {
		this.isConsciousness = isConsciousness;
	}

	/**
	 * @return the haveHeadaches
	 */
	public String getHaveHeadaches() {
		return haveHeadaches;
	}

	/**
	 * @param haveHeadaches the haveHeadaches to set
	 */
	public void setHaveHeadaches(String haveHeadaches) {
		this.haveHeadaches = haveHeadaches;
	}

	/**
	 * @return the haveBlurredVision
	 */
	public String getHaveBlurredVision() {
		return haveBlurredVision;
	}

	/**
	 * @param haveBlurredVision the haveBlurredVision to set
	 */
	public void setHaveBlurredVision(String haveBlurredVision) {
		this.haveBlurredVision = haveBlurredVision;
	}

	/**
	 * @return the isDifficultToFeed
	 */
	public String getIsDifficultToFeed() {
		return isDifficultToFeed;
	}

	/**
	 * @param isDifficultToFeed the isDifficultToFeed to set
	 */
	public void setIsDifficultToFeed(String isDifficultToFeed) {
		this.isDifficultToFeed = isDifficultToFeed;
	}

	/**
	 * @return the isBreathless
	 */
	public String getIsBreathless() {
		return isBreathless;
	}

	/**
	 * @param isBreathless the isBreathless to set
	 */
	public void setIsBreathless(String isBreathless) {
		this.isBreathless = isBreathless;
	}

	/**
	 * @return the whenBreathless
	 */
	public String getWhenBreathless() {
		return whenBreathless;
	}

	/**
	 * @param whenBreathless the whenBreathless to set
	 */
	public void setWhenBreathless(String whenBreathless) {
		this.whenBreathless = whenBreathless;
	}

	/**
	 * @return the haveCough
	 */
	public String getHaveCough() {
		return haveCough;
	}

	/**
	 * @param haveCough the haveCough to set
	 */
	public void setHaveCough(String haveCough) {
		this.haveCough = haveCough;
	}

	/**
	 * @return the howLongHaveCough
	 */
	public String getHowLongHaveCough() {
		return howLongHaveCough;
	}

	/**
	 * @param howLongHaveCough the howLongHaveCough to set
	 */
	public void setHowLongHaveCough(String howLongHaveCough) {
		this.howLongHaveCough = howLongHaveCough;
	}

	/**
	 * @return the isAbdominalPain
	 */
	public String getIsAbdominalPain() {
		return isAbdominalPain;
	}

	/**
	 * @param isAbdominalPain the isAbdominalPain to set
	 */
	public void setIsAbdominalPain(String isAbdominalPain) {
		this.isAbdominalPain = isAbdominalPain;
	}

	/**
	 * @return the wherePain
	 */
	public String getWherePain() {
		return wherePain;
	}

	/**
	 * @param wherePain the wherePain to set
	 */
	public void setWherePain(String wherePain) {
		this.wherePain = wherePain;
	}

	/**
	 * @return the babyMove
	 */
	public String getBabyMove() {
		return babyMove;
	}

	/**
	 * @param babyMove the babyMove to set
	 */
	public void setBabyMove(String babyMove) {
		this.babyMove = babyMove;
	}

	/**
	 * @return the isVaginalDischarge
	 */
	public String getIsVaginalDischarge() {
		return isVaginalDischarge;
	}

	/**
	 * @param isVaginalDischarge the isVaginalDischarge to set
	 */
	public void setIsVaginalDischarge(String isVaginalDischarge) {
		this.isVaginalDischarge = isVaginalDischarge;
	}

	/**
	 * @return the isBleeding
	 */
	public String getIsBleeding() {
		return isBleeding;
	}

	/**
	 * @param isBleeding the isBleeding to set
	 */
	public void setIsBleeding(String isBleeding) {
		this.isBleeding = isBleeding;
	}

	/**
	 * @return the noDayAfterDel
	 */
	public String getNoDayAfterDel() {
		return noDayAfterDel;
	}

	/**
	 * @param noDayAfterDel the noDayAfterDel to set
	 */
	public void setNoDayAfterDel(String noDayAfterDel) {
		this.noDayAfterDel = noDayAfterDel;
	}

	/**
	 * @return the noOfClothes
	 */
	public String getNoOfClothes() {
		return noOfClothes;
	}

	/**
	 * @param noOfClothes the noOfClothes to set
	 */
	public void setNoOfClothes(String noOfClothes) {
		this.noOfClothes = noOfClothes;
	}

	/**
	 * @return the isPassClotBleeding
	 */
	public String getIsPassClotBleeding() {
		return isPassClotBleeding;
	}

	/**
	 * @param isPassClotBleeding the isPassClotBleeding to set
	 */
	public void setIsPassClotBleeding(String isPassClotBleeding) {
		this.isPassClotBleeding = isPassClotBleeding;
	}


	/**
	 * @return the isBurningPain
	 */
	public String getIsBurningPain() {
		return isBurningPain;
	}

	/**
	 * @param isBurningPain the isBurningPain to set
	 */
	public void setIsBurningPain(String isBurningPain) {
		this.isBurningPain = isBurningPain;
	}

	/**
	 * @return the isoutOfBreath
	 */
	public String getIsoutOfBreath() {
		return isoutOfBreath;
	}

	/**
	 * @param isoutOfBreath the isoutOfBreath to set
	 */
	public void setIsoutOfBreath(String isoutOfBreath) {
		this.isoutOfBreath = isoutOfBreath;
	}

	/**
	 * @return the isTalking
	 */
	public String getIsTalking() {
		return isTalking;
	}

	/**
	 * @param isTalking the isTalking to set
	 */
	public void setIsTalking(String isTalking) {
		this.isTalking = isTalking;
	}

	/**
	 * @return the upperEyeColor
	 */
	public String getUpperEyeColor() {
		return upperEyeColor;
	}

	/**
	 * @param upperEyeColor the upperEyeColor to set
	 */
	public void setUpperEyeColor(String upperEyeColor) {
		this.upperEyeColor = upperEyeColor;
	}

	/**
	 * @return the lowerEyeColor
	 */
	public String getLowerEyeColor() {
		return lowerEyeColor;
	}

	/**
	 * @param lowerEyeColor the lowerEyeColor to set
	 */
	public void setLowerEyeColor(String lowerEyeColor) {
		this.lowerEyeColor = lowerEyeColor;
	}

	/**
	 * @return the isAnkleDepression
	 */
	public String getIsAnkleDepression() {
		return isAnkleDepression;
	}

	/**
	 * @param isAnkleDepression the isAnkleDepression to set
	 */
	public void setIsAnkleDepression(String isAnkleDepression) {
		this.isAnkleDepression = isAnkleDepression;
	}

	/**
	 * @return the isEyeSwelling
	 */
	public String getIsEyeSwelling() {
		return isEyeSwelling;
	}

	/**
	 * @param isEyeSwelling the isEyeSwelling to set
	 */
	public void setIsEyeSwelling(String isEyeSwelling) {
		this.isEyeSwelling = isEyeSwelling;
	}

	/**
	 * @return the bp
	 */
	public String getBp() {
		return bp;
	}

	/**
	 * @param bp the bp to set
	 */
	public void setBp(String bp) {
		this.bp = bp;
	}

	/**
	 * @return the firstBp
	 */
	public String getFirstBp() {
		return firstBp;
	}

	/**
	 * @param firstBp the firstBp to set
	 */
	public void setFirstBp(String firstBp) {
		this.firstBp = firstBp;
	}

	/**
	 * @return the secBp
	 */
	public String getSecBp() {
		return secBp;
	}

	/**
	 * @param secBp the secBp to set
	 */
	public void setSecBp(String secBp) {
		this.secBp = secBp;
	}

	/**
	 * @return the bpDateOne
	 */
	public String getBpDateOne() {
		return bpDateOne;
	}

	/**
	 * @param bpDateOne the bpDateOne to set
	 */
	public void setBpDateOne(String bpDateOne) {
		this.bpDateOne = bpDateOne;
	}

	/**
	 * @return the bpDateSec
	 */
	public String getBpDateSec() {
		return bpDateSec;
	}

	/**
	 * @param bpDateSec the bpDateSec to set
	 */
	public void setBpDateSec(String bpDateSec) {
		this.bpDateSec = bpDateSec;
	}

	/**
	 * @return the hb
	 */
	public String getHb() {
		return hb;
	}

	/**
	 * @param hb the hb to set
	 */
	public void setHb(String hb) {
		this.hb = hb;
	}

	/**
	 * @return the firstHb
	 */
	public String getFirstHb() {
		return firstHb;
	}

	/**
	 * @param firstHb the firstHb to set
	 */
	public void setFirstHb(String firstHb) {
		this.firstHb = firstHb;
	}

	/**
	 * @return the secHb
	 */
	public String getSecHb() {
		return secHb;
	}

	/**
	 * @param secHb the secHb to set
	 */
	public void setSecHb(String secHb) {
		this.secHb = secHb;
	}

	/**
	 * @return the hbDateOne
	 */
	public String getHbDateOne() {
		return hbDateOne;
	}

	/**
	 * @param hbDateOne the hbDateOne to set
	 */
	public void setHbDateOne(String hbDateOne) {
		this.hbDateOne = hbDateOne;
	}

	/**
	 * @return the hbDateSec
	 */
	public String getHbDateSec() {
		return hbDateSec;
	}

	/**
	 * @param hbDateSec the hbDateSec to set
	 */
	public void setHbDateSec(String hbDateSec) {
		this.hbDateSec = hbDateSec;
	}

	/**
	 * @return the urine
	 */
	public String getUrine() {
		return urine;
	}

	/**
	 * @param urine the urine to set
	 */
	public void setUrine(String urine) {
		this.urine = urine;
	}

	/**
	 * @return the firstUrine
	 */
	public String getFirstUrine() {
		return firstUrine;
	}

	/**
	 * @param firstUrine the firstUrine to set
	 */
	public void setFirstUrine(String firstUrine) {
		this.firstUrine = firstUrine;
	}

	/**
	 * @return the secUrine
	 */
	public String getSecUrine() {
		return secUrine;
	}

	/**
	 * @param secUrine the secUrine to set
	 */
	public void setSecUrine(String secUrine) {
		this.secUrine = secUrine;
	}

	/**
	 * @return the urineDateOne
	 */
	public String getUrineDateOne() {
		return urineDateOne;
	}

	/**
	 * @param urineDateOne the urineDateOne to set
	 */
	public void setUrineDateOne(String urineDateOne) {
		this.urineDateOne = urineDateOne;
	}

	/**
	 * @return the urineDateSec
	 */
	public String getUrineDateSec() {
		return urineDateSec;
	}

	/**
	 * @param urineDateSec the urineDateSec to set
	 */
	public void setUrineDateSec(String urineDateSec) {
		this.urineDateSec = urineDateSec;
	}

	
	
	/**
	 * @return the malaria
	 */
	public String getMalaria() {
		return malaria;
	}

	/**
	 * @param malaria the malaria to set
	 */
	public void setMalaria(String malaria) {
		this.malaria = malaria;
	}

	/**
	 * @return the firstMalaria
	 */
	public String getFirstMalaria() {
		return firstMalaria;
	}

	/**
	 * @param firstMalaria the firstMalaria to set
	 */
	public void setFirstMalaria(String firstMalaria) {
		this.firstMalaria = firstMalaria;
	}

	/**
	 * @return the secMalaria
	 */
	public String getSecMalaria() {
		return secMalaria;
	}

	/**
	 * @param secMalaria the secMalaria to set
	 */
	public void setSecMalaria(String secMalaria) {
		this.secMalaria = secMalaria;
	}

	/**
	 * @return the malariaDateOne
	 */
	public String getMalariaDateOne() {
		return malariaDateOne;
	}

	/**
	 * @param malariaDateOne the malariaDateOne to set
	 */
	public void setMalariaDateOne(String malariaDateOne) {
		this.malariaDateOne = malariaDateOne;
	}

	/**
	 * @return the malariaDateSec
	 */
	public String getMalariaDateSec() {
		return malariaDateSec;
	}

	/**
	 * @param malariaDateSec the malariaDateSec to set
	 */
	public void setMalariaDateSec(String malariaDateSec) {
		this.malariaDateSec = malariaDateSec;
	}

	/**
	 * @return the sputum
	 */
	public String getSputum() {
		return sputum;
	}

	/**
	 * @param sputum the sputum to set
	 */
	public void setSputum(String sputum) {
		this.sputum = sputum;
	}

	/**
	 * @return the sputumTest
	 */
	public String getSputumTest() {
		return sputumTest;
	}

	/**
	 * @param sputumTest the sputumTest to set
	 */
	public void setSputumTest(String sputumTest) {
		this.sputumTest = sputumTest;
	}

	/**
	 * @return the sputumDate
	 */
	public String getSputumDate() {
		return sputumDate;
	}

	/**
	 * @param sputumDate the sputumDate to set
	 */
	public void setSputumDate(String sputumDate) {
		this.sputumDate = sputumDate;
	}

	/**
	 * @return the talkingIrrelevantly
	 */
	public String getTalkingIrrelevantly() {
		return talkingIrrelevantly;
	}

	/**
	 * @param talkingIrrelevantly the talkingIrrelevantly to set
	 */
	public void setTalkingIrrelevantly(String talkingIrrelevantly) {
		this.talkingIrrelevantly = talkingIrrelevantly;
	}

	/**
	 * @return the isHearingImaginary
	 */
	public String getIsHearingImaginary() {
		return isHearingImaginary;
	}

	/**
	 * @param isHearingImaginary the isHearingImaginary to set
	 */
	public void setIsHearingImaginary(String isHearingImaginary) {
		this.isHearingImaginary = isHearingImaginary;
	}

	/**
	 * @return the carringBabyAndHerself
	 */
	public String getCarringBabyAndHerself() {
		return carringBabyAndHerself;
	}

	/**
	 * @param carringBabyAndHerself the carringBabyAndHerself to set
	 */
	public void setCarringBabyAndHerself(String carringBabyAndHerself) {
		this.carringBabyAndHerself = carringBabyAndHerself;
	}

	/**
	 * @return the createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the updatedDate
	 */
	public String getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the painInBreast
	 */
	public String getPainInBreast() {
		return painInBreast;
	}

	/**
	 * @param painInBreast the painInBreast to set
	 */
	public void setPainInBreast(String painInBreast) {
		this.painInBreast = painInBreast;
	}

	/**
	 * @return the lumpInBreast
	 */
	public String getLumpInBreast() {
		return lumpInBreast;
	}

	/**
	 * @param lumpInBreast the lumpInBreast to set
	 */
	public void setLumpInBreast(String lumpInBreast) {
		this.lumpInBreast = lumpInBreast;
	}

	/**
	 * @return the hasBleedingIncrease
	 */
	public String getHasBleedingIncrease() {
		return hasBleedingIncrease;
	}

	/**
	 * @param hasBleedingIncrease the hasBleedingIncrease to set
	 */
	public void setHasBleedingIncrease(String hasBleedingIncrease) {
		this.hasBleedingIncrease = hasBleedingIncrease;
	}


}

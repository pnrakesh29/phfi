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
 * @date Jan 14, 2016 11:45:14 PM
 * @version 1.0
 */


@Entity
@Table(name = "PREGNANCY_VISIT")
public class PregnancyVisit implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -57607954448701737L;
	
	@Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
	 
	@Column(name = "WOMAN_NAME")
	private String womanName;
	
	@Column(name = "WID")
	private int wid;
	
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
	 
	@Column(name = "FELT_GIDDY")
	private String feltGiddy;
	 
	@Column(name = "HAVE_HEADACHES")
	private String haveHeadaches;
	 
	@Column(name = "BLURRED_VISION")
	private String haveBlurredVision;
	 
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
	 
	@Column(name = "KINDOF_BLEEDING")
	private String kindOfBleeding;
	 
	@Column(name = "IS_WATER_BROKEN")
	private String isWaterBroken;
	
	@Column(name = "IS_BURNING_PAIN")
	private String isBurningPain;
	
	@Column(name = "TOE_RINGS_TIGHTER")
	private String toeRingsTighter;
	 
	@Column(name = "IS_BANGLES")
	private String isBangles;
	 
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
	 
	@Column(name = "WEIGHT")	
	private String weight;
	 
	@Column(name = "FIRST_WEIGHT")
	private String firstWeight;
	 
	@Column(name = "SEC_WEIGHT")
	private String SecWeight;
	 
	@Column(name = "THIRD_WEIGHT")
	private String thirdWeight;
	 
	@Column(name = "FOURTH_WEIGHT")
	private String fourthWeight;
	 
	@Column(name = "WEIGHT_DATE_ONE")
	private String weightDateOne;
	 
	@Column(name = "WEIGHT_DATE_SEC")
	private String weightDateSec;
	 
	@Column(name = "WEIGHT_DATE_THIRD")
	private String weightDateThird;
	 
	@Column(name = "WEIGHT_DATE_FOUR")
	private String weightDateFour;
	 
	@Column(name = "BP")
	private String bp;
	 
	@Column(name = "FIRST_BP")
	private String firstBp;
	 
	@Column(name = "SEC_BP")
	private String secBp;
	 
	@Column(name = "THIRD_BP")
	private String thirdBp;
	
	@Column(name = "FOUR_BP")
	private String fourBp;
	 
	@Column(name = "BP_DATE_ONE")
	private String bpDateOne;
	 
	@Column(name = "BP_DATE_SEC")
	private String bpDateSec;
	 
	@Column(name = "BP_DATE_THIRD")
	private String bpDateThird;
	 
	@Column(name = "BP_DATE_FOUR")
	private String bpDateFour;
	 
	@Column(name = "HB")
	private String hb;
	 
	@Column(name = "FIRST_HB")
	private String firstHb;
	 
	@Column(name = "SEC_HB")
	private String secHb;
	 
	@Column(name = "THIRD_HB")
	private String thirdHb;
	
	@Column(name = "FOUR_HB")
	private String fourHb;
	
	@Column(name = "HB_DATE_ONE")
	private String hbDateOne;
	
	@Column(name = "HB_DATE_SEC")
	private String hbDateSec;
	
	@Column(name = "HB_DATE_THIRD")
	private String hbDateThird;
	
	@Column(name = "HB_DATE_FOUR")
	private String hbDateFour;
	
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
	
	@Column(name = "ULTRASOUND")	
	private String ultrasound;
	
	@Column(name = "FIRST_ULTRASOUND")
	private String firstUltrasound;
	
	@Column(name = "SEC_ULTRASOUND")
	private String secUltrasound;
	 
	@Column(name = "ULTRASOUND_DATE_ONE")
	private String ultrasoundDateOne;
	 
	@Column(name = "ULTRASOUND_DATE_SEC")
	private String ultrasoundDateSec;
	
	@Column(name = "RBS")
	private String rbs;
	
	@Column(name = "FIRST_RBS")
	private String firstRbs;
	
	@Column(name = "SEC_RBS")
	private String secRbs;
	
	@Column(name = "RBS_DATE_ONE")
	private String rbsDateOne;
	
	@Column(name = "RBS_DATE_SEC")
	private String rbsDateSec;
	 
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
	public int getWid() {
		return wid;
	}

	/**
	 * @param wid the wid to set
	 */
	public void setWid(int wid) {
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
	 * @return the feltGiddy
	 */
	public String getFeltGiddy() {
		return feltGiddy;
	}

	/**
	 * @param feltGiddy the feltGiddy to set
	 */
	public void setFeltGiddy(String feltGiddy) {
		this.feltGiddy = feltGiddy;
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
	 * @return the kindOfBleeding
	 */
	public String getKindOfBleeding() {
		return kindOfBleeding;
	}

	/**
	 * @param kindOfBleeding the kindOfBleeding to set
	 */
	public void setKindOfBleeding(String kindOfBleeding) {
		this.kindOfBleeding = kindOfBleeding;
	}

	/**
	 * @return the isWaterBroken
	 */
	public String getIsWaterBroken() {
		return isWaterBroken;
	}

	/**
	 * @param isWaterBroken the isWaterBroken to set
	 */
	public void setIsWaterBroken(String isWaterBroken) {
		this.isWaterBroken = isWaterBroken;
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
	 * @return the toeRingsTighter
	 */
	public String getToeRingsTighter() {
		return toeRingsTighter;
	}

	/**
	 * @param toeRingsTighter the toeRingsTighter to set
	 */
	public void setToeRingsTighter(String toeRingsTighter) {
		this.toeRingsTighter = toeRingsTighter;
	}

	/**
	 * @return the isBangles
	 */
	public String getIsBangles() {
		return isBangles;
	}

	/**
	 * @param isBangles the isBangles to set
	 */
	public void setIsBangles(String isBangles) {
		this.isBangles = isBangles;
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
	 * @return the weight
	 */
	public String getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}

	/**
	 * @return the firstWeight
	 */
	public String getFirstWeight() {
		return firstWeight;
	}

	/**
	 * @param firstWeight the firstWeight to set
	 */
	public void setFirstWeight(String firstWeight) {
		this.firstWeight = firstWeight;
	}

	/**
	 * @return the secWeight
	 */
	public String getSecWeight() {
		return SecWeight;
	}

	/**
	 * @param secWeight the secWeight to set
	 */
	public void setSecWeight(String secWeight) {
		SecWeight = secWeight;
	}

	/**
	 * @return the thirdWeight
	 */
	public String getThirdWeight() {
		return thirdWeight;
	}

	/**
	 * @param thirdWeight the thirdWeight to set
	 */
	public void setThirdWeight(String thirdWeight) {
		this.thirdWeight = thirdWeight;
	}

	/**
	 * @return the fourthWeight
	 */
	public String getFourthWeight() {
		return fourthWeight;
	}

	/**
	 * @param fourthWeight the fourthWeight to set
	 */
	public void setFourthWeight(String fourthWeight) {
		this.fourthWeight = fourthWeight;
	}

	/**
	 * @return the weightDateOne
	 */
	public String getWeightDateOne() {
		return weightDateOne;
	}

	/**
	 * @param weightDateOne the weightDateOne to set
	 */
	public void setWeightDateOne(String weightDateOne) {
		this.weightDateOne = weightDateOne;
	}

	/**
	 * @return the weightDateSec
	 */
	public String getWeightDateSec() {
		return weightDateSec;
	}

	/**
	 * @param weightDateSec the weightDateSec to set
	 */
	public void setWeightDateSec(String weightDateSec) {
		this.weightDateSec = weightDateSec;
	}

	/**
	 * @return the weightDateThird
	 */
	public String getWeightDateThird() {
		return weightDateThird;
	}

	/**
	 * @param weightDateThird the weightDateThird to set
	 */
	public void setWeightDateThird(String weightDateThird) {
		this.weightDateThird = weightDateThird;
	}

	/**
	 * @return the weightDateFour
	 */
	public String getWeightDateFour() {
		return weightDateFour;
	}

	/**
	 * @param weightDateFour the weightDateFour to set
	 */
	public void setWeightDateFour(String weightDateFour) {
		this.weightDateFour = weightDateFour;
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
	 * @return the thirdBp
	 */
	public String getThirdBp() {
		return thirdBp;
	}

	/**
	 * @param thirdBp the thirdBp to set
	 */
	public void setThirdBp(String thirdBp) {
		this.thirdBp = thirdBp;
	}

	/**
	 * @return the fourBp
	 */
	public String getFourBp() {
		return fourBp;
	}

	/**
	 * @param fourBp the fourBp to set
	 */
	public void setFourBp(String fourBp) {
		this.fourBp = fourBp;
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
	 * @return the bpDateThird
	 */
	public String getBpDateThird() {
		return bpDateThird;
	}

	/**
	 * @param bpDateThird the bpDateThird to set
	 */
	public void setBpDateThird(String bpDateThird) {
		this.bpDateThird = bpDateThird;
	}

	/**
	 * @return the bpDateFour
	 */
	public String getBpDateFour() {
		return bpDateFour;
	}

	/**
	 * @param bpDateFour the bpDateFour to set
	 */
	public void setBpDateFour(String bpDateFour) {
		this.bpDateFour = bpDateFour;
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
	 * @return the thirdHb
	 */
	public String getThirdHb() {
		return thirdHb;
	}

	/**
	 * @param thirdHb the thirdHb to set
	 */
	public void setThirdHb(String thirdHb) {
		this.thirdHb = thirdHb;
	}

	/**
	 * @return the fourHb
	 */
	public String getFourHb() {
		return fourHb;
	}

	/**
	 * @param fourHb the fourHb to set
	 */
	public void setFourHb(String fourHb) {
		this.fourHb = fourHb;
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
	 * @return the hbDateThird
	 */
	public String getHbDateThird() {
		return hbDateThird;
	}

	/**
	 * @param hbDateThird the hbDateThird to set
	 */
	public void setHbDateThird(String hbDateThird) {
		this.hbDateThird = hbDateThird;
	}

	/**
	 * @return the hbDateFour
	 */
	public String getHbDateFour() {
		return hbDateFour;
	}

	/**
	 * @param hbDateFour the hbDateFour to set
	 */
	public void setHbDateFour(String hbDateFour) {
		this.hbDateFour = hbDateFour;
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
	 * @return the ultrasound
	 */
	public String getUltrasound() {
		return ultrasound;
	}

	/**
	 * @param ultrasound the ultrasound to set
	 */
	public void setUltrasound(String ultrasound) {
		this.ultrasound = ultrasound;
	}

	/**
	 * @return the firstUltrasound
	 */
	public String getFirstUltrasound() {
		return firstUltrasound;
	}

	/**
	 * @param firstUltrasound the firstUltrasound to set
	 */
	public void setFirstUltrasound(String firstUltrasound) {
		this.firstUltrasound = firstUltrasound;
	}

	/**
	 * @return the secUltrasound
	 */
	public String getSecUltrasound() {
		return secUltrasound;
	}

	/**
	 * @param secUltrasound the secUltrasound to set
	 */
	public void setSecUltrasound(String secUltrasound) {
		this.secUltrasound = secUltrasound;
	}

	/**
	 * @return the ultrasoundDateOne
	 */
	public String getUltrasoundDateOne() {
		return ultrasoundDateOne;
	}

	/**
	 * @param ultrasoundDateOne the ultrasoundDateOne to set
	 */
	public void setUltrasoundDateOne(String ultrasoundDateOne) {
		this.ultrasoundDateOne = ultrasoundDateOne;
	}

	/**
	 * @return the ultrasoundDateSec
	 */
	public String getUltrasoundDateSec() {
		return ultrasoundDateSec;
	}

	/**
	 * @param ultrasoundDateSec the ultrasoundDateSec to set
	 */
	public void setUltrasoundDateSec(String ultrasoundDateSec) {
		this.ultrasoundDateSec = ultrasoundDateSec;
	}

	/**
	 * @return the rbs
	 */
	public String getRbs() {
		return rbs;
	}

	/**
	 * @param rbs the rbs to set
	 */
	public void setRbs(String rbs) {
		this.rbs = rbs;
	}

	/**
	 * @return the firstRbs
	 */
	public String getFirstRbs() {
		return firstRbs;
	}

	/**
	 * @param firstRbs the firstRbs to set
	 */
	public void setFirstRbs(String firstRbs) {
		this.firstRbs = firstRbs;
	}

	/**
	 * @return the secRbs
	 */
	public String getSecRbs() {
		return secRbs;
	}

	/**
	 * @param secRbs the secRbs to set
	 */
	public void setSecRbs(String secRbs) {
		this.secRbs = secRbs;
	}

	/**
	 * @return the rbsDateOne
	 */
	public String getRbsDateOne() {
		return rbsDateOne;
	}

	/**
	 * @param rbsDateOne the rbsDateOne to set
	 */
	public void setRbsDateOne(String rbsDateOne) {
		this.rbsDateOne = rbsDateOne;
	}

	/**
	 * @return the rbsDateSec
	 */
	public String getRbsDateSec() {
		return rbsDateSec;
	}

	/**
	 * @param rbsDateSec the rbsDateSec to set
	 */
	public void setRbsDateSec(String rbsDateSec) {
		this.rbsDateSec = rbsDateSec;
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

	

}

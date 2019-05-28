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
 * @date Jan 4, 2016 12:01:10 AM
 * @version 1.0O
 */
@Entity
@Table(name = "REGISTRATION")
public class Registration implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8780964661238537100L;

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    
    @Column(name = "REG_DATE")
	private String regDate;
    
    @Column(name = "MATERNITY_STATUS")
	private String maternityStatus;
    
    @Column(name = "UID")
	private Integer uid;
    
    @Column(name = "VILLAGE_NAME")
	private String villageName;
    
    @Column(name = "PHC")
	private String phc;
    
    @Column(name = "ASHA_NAME")
	private String ashaName;
    
    @Column(name = "ANM_NAME")
	private String anmName;
    
    @Column(name = "ASHA_FACI_NAME")
	private String ashaFacilitatorName;
    
    @Column(name = "WOMEN_FIRST_NAME")
	private String womenFirstName;
    
    @Column(name = "WOMEN_HUS_NAME")
	private String womenHusbandName;
    
    @Column(name = "WOMEN_SUR_NAME")
	private String womenSurname;
    
    @Column(name = "HUS_FIRST_NAME")
	private String husbandFirstName;
    
    @Column(name = "HUS_FATHER_NAME")
	private String husbandFatherName;
    
    @Column(name = "HUS_SUR_NAME")
	private String husbandSurname;
    
    @Column(name = "STREET_MARITAL")
	private String streetMarital;
    
    @Column(name = "LANDMARK_MARITAL")
	private String landmarkMarital;
    
    @Column(name = "VILLAGE_MARITAL")
	private String villageMarital;
    
    @Column(name = "TALUK_MARITAL")
	private String talukMarital;
    
    @Column(name = "DISTRICT_MARITAL")
	private String districtMarital;
    
    @Column(name = "PHONE1_MARITAL")
	private String phone1Marital;
    
    @Column(name = "PHONE2_MARITAL")
	private String phone2Marital;
    
    @Column(name = "STREET_NATAL")
	private String streetNatal;
    
    @Column(name = "LANDMARK_NATAL")
	private String landmarkNatal;
    
    @Column(name = "VILLAGE_NATAL")
	private String villageNatal;
    
    @Column(name = "TALUK_NATAL")
	private String talukNatal;
    
    @Column(name = "DISTRICT_NATAL")
	private String districtNatal;
    
    @Column(name = "PHONE1_NATAL")
	private String phone1Natal;
    
    @Column(name = "PHONE2_NATAL")
	private String phone2Natal;
    
    @Column(name = "CURRENT_PLACE")
	private String currentPlace;
    
    @Column(name = "OTHER_CUR_PLACE")
	private String otherCurrentPlace;
    
    @Column(name = "AGE")
	private Integer age;
    
    @Column(name = "EDUCATION")    
	private String education;
    
    @Column(name = "EDUCATION_OTHER")
	private String educationOther;
    
    @Column(name = "RELIGION")
	private String religion;
    
    @Column(name = "OTHER_RELIGION")
	private String otherReligion;
    
    @Column(name = "CASTE")
	private String caste;
    
    @Column(name = "CAST_CATEGORY")
	private String castcategory;
    
    @Column(name = "DIABETES")
	private String diabetes;
    
    @Column(name = "HYPERTENSION")
	private String hypertension;
    
    @Column(name = "HEART_DISEASE")
	private String heartdisease;
    
    @Column(name = "JAUNDICE")
	private String jaundice;
    
    @Column(name = "ANAEMIA")
	private String anaemia;
    
    @Column(name = "THYROID_PROBLEM")
	private String thyroidproblem;
    
    @Column(name = "OTHER_PROBLEM")
	private String anyotherproblem;
    
    @Column(name = "PROBLEM_DESC")
	private String problemDesc;
    
    @Column(name = "PREGNANCY_COUNT")
	private Integer pregnancyCount;
    
    @Column(name = "NO_OF_CHILDREN")
	private Integer noOfChildren;
    
    @Column(name = "RECENT_DELIVERY")
	private String dateOfRecentDelivery;
    
    @Column(name = "EARLY_DELIVERY")
	private Integer earlyDelivery;
    
    @Column(name = "CAESAREAN")
	private Integer caesarean;
    
    @Column(name = "BREATHLESSNESS")
	private String breathlessness;
    
    @Column(name = "SEVERE_PALLOR")
	private String severepallor;
    
    @Column(name = "BLEED_EXCESSIVELY")
	private String bleedexcessively;
    
    @Column(name = "LMP")
	private String lmp;
    
    @Column(name = "HEIGHT")
	private Integer height;
    
    @Column(name = "BLOOD_GROUP")
	private String bloodgroup;
    
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
	 * @return the regDate
	 */
	public String getRegDate() {
		return regDate;
	}

	/**
	 * @param regDate the regDate to set
	 */
	public void setRegDate(String regDate) {
		this.regDate = regDate;
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
	 * @return the phc
	 */
	public String getPhc() {
		return phc;
	}

	/**
	 * @param phc the phc to set
	 */
	public void setPhc(String phc) {
		this.phc = phc;
	}

	/**
	 * @return the ashaName
	 */
	public String getAshaName() {
		return ashaName;
	}

	/**
	 * @param ashaName the ashaName to set
	 */
	public void setAshaName(String ashaName) {
		this.ashaName = ashaName;
	}

	/**
	 * @return the anmName
	 */
	public String getAnmName() {
		return anmName;
	}

	/**
	 * @param anmName the anmName to set
	 */
	public void setAnmName(String anmName) {
		this.anmName = anmName;
	}

	/**
	 * @return the ashaFacilitatorName
	 */
	public String getAshaFacilitatorName() {
		return ashaFacilitatorName;
	}

	/**
	 * @param ashaFacilitatorName the ashaFacilitatorName to set
	 */
	public void setAshaFacilitatorName(String ashaFacilitatorName) {
		this.ashaFacilitatorName = ashaFacilitatorName;
	}

	/**
	 * @return the womenFirstName
	 */
	public String getWomenFirstName() {
		return womenFirstName;
	}

	/**
	 * @param womenFirstName the womenFirstName to set
	 */
	public void setWomenFirstName(String womenFirstName) {
		this.womenFirstName = womenFirstName;
	}

	/**
	 * @return the womenHusbandName
	 */
	public String getWomenHusbandName() {
		return womenHusbandName;
	}

	/**
	 * @param womenHusbandName the womenHusbandName to set
	 */
	public void setWomenHusbandName(String womenHusbandName) {
		this.womenHusbandName = womenHusbandName;
	}

	/**
	 * @return the womenSurname
	 */
	public String getWomenSurname() {
		return womenSurname;
	}

	/**
	 * @param womenSurname the womenSurname to set
	 */
	public void setWomenSurname(String womenSurname) {
		this.womenSurname = womenSurname;
	}

	/**
	 * @return the husbandFirstName
	 */
	public String getHusbandFirstName() {
		return husbandFirstName;
	}

	/**
	 * @param husbandFirstName the husbandFirstName to set
	 */
	public void setHusbandFirstName(String husbandFirstName) {
		this.husbandFirstName = husbandFirstName;
	}

	/**
	 * @return the husbandFatherName
	 */
	public String getHusbandFatherName() {
		return husbandFatherName;
	}

	/**
	 * @param husbandFatherName the husbandFatherName to set
	 */
	public void setHusbandFatherName(String husbandFatherName) {
		this.husbandFatherName = husbandFatherName;
	}

	/**
	 * @return the husbandSurname
	 */
	public String getHusbandSurname() {
		return husbandSurname;
	}

	/**
	 * @param husbandSurname the husbandSurname to set
	 */
	public void setHusbandSurname(String husbandSurname) {
		this.husbandSurname = husbandSurname;
	}

	/**
	 * @return the streetMarital
	 */
	public String getStreetMarital() {
		return streetMarital;
	}

	/**
	 * @param streetMarital the streetMarital to set
	 */
	public void setStreetMarital(String streetMarital) {
		this.streetMarital = streetMarital;
	}

	/**
	 * @return the landmarkMarital
	 */
	public String getLandmarkMarital() {
		return landmarkMarital;
	}

	/**
	 * @param landmarkMarital the landmarkMarital to set
	 */
	public void setLandmarkMarital(String landmarkMarital) {
		this.landmarkMarital = landmarkMarital;
	}

	/**
	 * @return the villageMarital
	 */
	public String getVillageMarital() {
		return villageMarital;
	}

	/**
	 * @param villageMarital the villageMarital to set
	 */
	public void setVillageMarital(String villageMarital) {
		this.villageMarital = villageMarital;
	}

	/**
	 * @return the talukMarital
	 */
	public String getTalukMarital() {
		return talukMarital;
	}

	/**
	 * @param talukMarital the talukMarital to set
	 */
	public void setTalukMarital(String talukMarital) {
		this.talukMarital = talukMarital;
	}

	/**
	 * @return the districtMarital
	 */
	public String getDistrictMarital() {
		return districtMarital;
	}

	/**
	 * @param districtMarital the districtMarital to set
	 */
	public void setDistrictMarital(String districtMarital) {
		this.districtMarital = districtMarital;
	}

	/**
	 * @return the phone1Marital
	 */
	public String getPhone1Marital() {
		return phone1Marital;
	}

	/**
	 * @param phone1Marital the phone1Marital to set
	 */
	public void setPhone1Marital(String phone1Marital) {
		this.phone1Marital = phone1Marital;
	}

	/**
	 * @return the phone2Marital
	 */
	public String getPhone2Marital() {
		return phone2Marital;
	}

	/**
	 * @param phone2Marital the phone2Marital to set
	 */
	public void setPhone2Marital(String phone2Marital) {
		this.phone2Marital = phone2Marital;
	}

	/**
	 * @return the streetNatal
	 */
	public String getStreetNatal() {
		return streetNatal;
	}

	/**
	 * @param streetNatal the streetNatal to set
	 */
	public void setStreetNatal(String streetNatal) {
		this.streetNatal = streetNatal;
	}

	/**
	 * @return the landmarkNatal
	 */
	public String getLandmarkNatal() {
		return landmarkNatal;
	}

	/**
	 * @param landmarkNatal the landmarkNatal to set
	 */
	public void setLandmarkNatal(String landmarkNatal) {
		this.landmarkNatal = landmarkNatal;
	}

	/**
	 * @return the villageNatal
	 */
	public String getVillageNatal() {
		return villageNatal;
	}

	/**
	 * @param villageNatal the villageNatal to set
	 */
	public void setVillageNatal(String villageNatal) {
		this.villageNatal = villageNatal;
	}

	/**
	 * @return the talukNatal
	 */
	public String getTalukNatal() {
		return talukNatal;
	}

	/**
	 * @param talukNatal the talukNatal to set
	 */
	public void setTalukNatal(String talukNatal) {
		this.talukNatal = talukNatal;
	}

	/**
	 * @return the districtNatal
	 */
	public String getDistrictNatal() {
		return districtNatal;
	}

	/**
	 * @param districtNatal the districtNatal to set
	 */
	public void setDistrictNatal(String districtNatal) {
		this.districtNatal = districtNatal;
	}

	/**
	 * @return the phone1Natal
	 */
	public String getPhone1Natal() {
		return phone1Natal;
	}

	/**
	 * @param phone1Natal the phone1Natal to set
	 */
	public void setPhone1Natal(String phone1Natal) {
		this.phone1Natal = phone1Natal;
	}

	/**
	 * @return the phone2Natal
	 */
	public String getPhone2Natal() {
		return phone2Natal;
	}

	/**
	 * @param phone2Natal the phone2Natal to set
	 */
	public void setPhone2Natal(String phone2Natal) {
		this.phone2Natal = phone2Natal;
	}

	/**
	 * @return the currentPlace
	 */
	public String getCurrentPlace() {
		return currentPlace;
	}

	/**
	 * @param currentPlace the currentPlace to set
	 */
	public void setCurrentPlace(String currentPlace) {
		this.currentPlace = currentPlace;
	}

	/**
	 * @return the otherCurrentPlace
	 */
	public String getOtherCurrentPlace() {
		return otherCurrentPlace;
	}

	/**
	 * @param otherCurrentPlace the otherCurrentPlace to set
	 */
	public void setOtherCurrentPlace(String otherCurrentPlace) {
		this.otherCurrentPlace = otherCurrentPlace;
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
	 * @return the education
	 */
	public String getEducation() {
		return education;
	}

	/**
	 * @param education the education to set
	 */
	public void setEducation(String education) {
		this.education = education;
	}

	/**
	 * @return the educationOther
	 */
	public String getEducationOther() {
		return educationOther;
	}

	/**
	 * @param educationOther the educationOther to set
	 */
	public void setEducationOther(String educationOther) {
		this.educationOther = educationOther;
	}

	/**
	 * @return the religion
	 */
	public String getReligion() {
		return religion;
	}

	/**
	 * @param religion the religion to set
	 */
	public void setReligion(String religion) {
		this.religion = religion;
	}

	/**
	 * @return the otherReligion
	 */
	public String getOtherReligion() {
		return otherReligion;
	}

	/**
	 * @param otherReligion the otherReligion to set
	 */
	public void setOtherReligion(String otherReligion) {
		this.otherReligion = otherReligion;
	}

	/**
	 * @return the caste
	 */
	public String getCaste() {
		return caste;
	}

	/**
	 * @param caste the caste to set
	 */
	public void setCaste(String caste) {
		this.caste = caste;
	}

	/**
	 * @return the castcategory
	 */
	public String getCastcategory() {
		return castcategory;
	}

	/**
	 * @param castcategory the castcategory to set
	 */
	public void setCastcategory(String castcategory) {
		this.castcategory = castcategory;
	}

	/**
	 * @return the diabetes
	 */
	public String getDiabetes() {
		return diabetes;
	}

	/**
	 * @param diabetes the diabetes to set
	 */
	public void setDiabetes(String diabetes) {
		this.diabetes = diabetes;
	}

	/**
	 * @return the hypertension
	 */
	public String getHypertension() {
		return hypertension;
	}

	/**
	 * @param hypertension the hypertension to set
	 */
	public void setHypertension(String hypertension) {
		this.hypertension = hypertension;
	}

	/**
	 * @return the heartdisease
	 */
	public String getHeartdisease() {
		return heartdisease;
	}

	/**
	 * @param heartdisease the heartdisease to set
	 */
	public void setHeartdisease(String heartdisease) {
		this.heartdisease = heartdisease;
	}

	/**
	 * @return the jaundice
	 */
	public String getJaundice() {
		return jaundice;
	}

	/**
	 * @param jaundice the jaundice to set
	 */
	public void setJaundice(String jaundice) {
		this.jaundice = jaundice;
	}

	/**
	 * @return the anaemia
	 */
	public String getAnaemia() {
		return anaemia;
	}

	/**
	 * @param anaemia the anaemia to set
	 */
	public void setAnaemia(String anaemia) {
		this.anaemia = anaemia;
	}

	/**
	 * @return the thyroidproblem
	 */
	public String getThyroidproblem() {
		return thyroidproblem;
	}

	/**
	 * @param thyroidproblem the thyroidproblem to set
	 */
	public void setThyroidproblem(String thyroidproblem) {
		this.thyroidproblem = thyroidproblem;
	}

	/**
	 * @return the anyotherproblem
	 */
	public String getAnyotherproblem() {
		return anyotherproblem;
	}

	/**
	 * @param anyotherproblem the anyotherproblem to set
	 */
	public void setAnyotherproblem(String anyotherproblem) {
		this.anyotherproblem = anyotherproblem;
	}

	/**
	 * @return the problemDesc
	 */
	public String getProblemDesc() {
		return problemDesc;
	}

	/**
	 * @param problemDesc the problemDesc to set
	 */
	public void setProblemDesc(String problemDesc) {
		this.problemDesc = problemDesc;
	}

	/**
	 * @return the pregnancyCount
	 */
	public Integer getPregnancyCount() {
		return pregnancyCount;
	}

	/**
	 * @param pregnancyCount the pregnancyCount to set
	 */
	public void setPregnancyCount(Integer pregnancyCount) {
		this.pregnancyCount = pregnancyCount;
	}

	/**
	 * @return the noOfChildren
	 */
	public Integer getNoOfChildren() {
		return noOfChildren;
	}

	/**
	 * @param noOfChildren the noOfChildren to set
	 */
	public void setNoOfChildren(Integer noOfChildren) {
		this.noOfChildren = noOfChildren;
	}

	/**
	 * @return the dateOfRecentDelivery
	 */
	public String getDateOfRecentDelivery() {
		return dateOfRecentDelivery;
	}

	/**
	 * @param dateOfRecentDelivery the dateOfRecentDelivery to set
	 */
	public void setDateOfRecentDelivery(String dateOfRecentDelivery) {
		this.dateOfRecentDelivery = dateOfRecentDelivery;
	}

	/**
	 * @return the earlyDelivery
	 */
	public Integer getEarlyDelivery() {
		return earlyDelivery;
	}

	/**
	 * @param earlyDelivery the earlyDelivery to set
	 */
	public void setEarlyDelivery(Integer earlyDelivery) {
		this.earlyDelivery = earlyDelivery;
	}

	/**
	 * @return the caesarean
	 */
	public Integer getCaesarean() {
		return caesarean;
	}

	/**
	 * @param caesarean the caesarean to set
	 */
	public void setCaesarean(Integer caesarean) {
		this.caesarean = caesarean;
	}

	/**
	 * @return the breathlessness
	 */
	public String getBreathlessness() {
		return breathlessness;
	}

	/**
	 * @param breathlessness the breathlessness to set
	 */
	public void setBreathlessness(String breathlessness) {
		this.breathlessness = breathlessness;
	}

	/**
	 * @return the severepallor
	 */
	public String getSeverepallor() {
		return severepallor;
	}

	/**
	 * @param severepallor the severepallor to set
	 */
	public void setSeverepallor(String severepallor) {
		this.severepallor = severepallor;
	}

	/**
	 * @return the bleedexcessively
	 */
	public String getBleedexcessively() {
		return bleedexcessively;
	}

	/**
	 * @param bleedexcessively the bleedexcessively to set
	 */
	public void setBleedexcessively(String bleedexcessively) {
		this.bleedexcessively = bleedexcessively;
	}

	/**
	 * @return the lmp
	 */
	public String getLmp() {
		return lmp;
	}

	/**
	 * @param lmp the lmp to set
	 */
	public void setLmp(String lmp) {
		this.lmp = lmp;
	}

	/**
	 * @return the height
	 */
	public Integer getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}

	/**
	 * @return the bloodgroup
	 */
	public String getBloodgroup() {
		return bloodgroup;
	}

	/**
	 * @param bloodgroup the bloodgroup to set
	 */
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
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
	 * @return the uid
	 */
	public Integer getUid() {
		return uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
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

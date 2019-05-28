/**
 * 
 */
package com.smh.handler.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smh.constants.Condition;
import com.smh.constants.Constant;
import com.smh.constants.PhfiErrorCodes;
import com.smh.dao.ReportDao;
import com.smh.dao.SymptomDao;
import com.smh.dao.model.Delivery;
import com.smh.dao.model.PostpartumVisit;
import com.smh.dao.model.PregnancyVisit;
import com.smh.dao.model.Registration;
import com.smh.dao.model.Symptom;
import com.smh.handler.ReportHandler;
import com.smh.model.MedicalCaseSheetDTO;
import com.smh.model.PhfiDeliveryFormRequest;
import com.smh.model.PhfiDeliveryFormResponse;
import com.smh.model.PhfiPostPartumVisitRequest;
import com.smh.model.PhfiPostPartumVisitResponse;
import com.smh.model.PhfiRegistrationRequest;
import com.smh.model.PhfiRegistrationResponse;
import com.smh.model.PhfiVisitRequest;
import com.smh.model.PhfiVisitResponse;
import com.smh.model.ReportRequest;
import com.smh.model.ReportResponse;
import com.smh.util.CommonUtil;
import com.smh.util.Properties;
import com.smh.util.StringUtil;

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Jan 24, 2016 12:29:07 PM
 * @version 1.0
 */
@Service("reportHandler")
public class ReportHandlerImpl implements ReportHandler{

	public static Logger logger = Logger.getLogger(ReportHandlerImpl.class);
	
	@Autowired
	private ReportDao reportDao;
	
	@Autowired
	private SymptomDao symptomDao;
	
	
	/**
	 * @param reportRequest
	 * @return ReportResponse
	 */
	
	
	
	@Override
	public ReportResponse getMasterReport(ReportRequest reportRequest) {
		logger.info("Entering :: RegistrationHandlerImpl :: createRegistration method");
		ReportResponse response = new ReportResponse();
		try {
			List<Registration> registrationList = reportDao.getReport(reportRequest);
			if(!StringUtil.isListNotNullNEmpty(registrationList)){
				response.setResponseCode(PhfiErrorCodes.REPORT_NOT_FOUND);
				response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
				return response;
			}
			
			//get All Symptoms
			HashMap<String,String> symptom =new HashMap<String,String>();
			List<Symptom> symptomList = symptomDao.findAll();
			if(StringUtil.isListNotNullNEmpty(symptomList)){
				for(Symptom symptomData :symptomList){
					symptom.put(symptomData.getSymptomId(),symptomData.getSymptomPhrases());
				}
			}
			List<ReportRequest> reportList = new ArrayList<ReportRequest>();
			for(Registration registration :registrationList){
				
				ReportRequest request = new ReportRequest();
				request.setSlNo(registration.getId());
				request.setFullName(registration.getWomenFirstName()+" "+registration.getWomenSurname());
				request.setWid(registration.getUid());
				
				request.setDaysToDeliver(getDaysToDeliver(registration));
				request.setObstetricScore(getObstetricScore(registration));
				request.setNameOfAsha(registration.getAshaName());
				request.setAge(registration.getAge());
				request.setCast(registration.getCaste());
				request.setVillageName(registration.getVillageName());
				String findingAssessVisit[] = getFindings(registration,symptom).split(":");
				request.setFindings(findingAssessVisit[0]);
				request.setClinicalAssesment(findingAssessVisit[1]);
				request.setNoOfVisit(findingAssessVisit[2]);
				request.setClinicalStatus(findingAssessVisit[8]);
				reportList.add(request);
			}
			response.setReportRequest(reportList);
			response.setNoOfRecords(reportList.size());
			response.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
			response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
		} catch (Exception e) {
			logger.error("Error :: RegistrationHandlerImpl :: createRegistration method", e);
			response.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
			response.setResponseMessage(Properties.getProperty(PhfiErrorCodes.SYSTEM_ERROR));
		}
		logger.info("Exiting :: RegistrationHandlerImpl :: createRegistration method");

		return response;
	}

	/**
	 * @param registration
	 * @return
	 */
	private Integer getDaysToDeliver(Registration registration) {
		
		Integer days=null;
		
		String lmp = registration.getLmp();
		Date date =new Date();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String currentDate = df.format(date);
		try {
			Date lmpDate = df.parse(lmp);
			Date sysDate = df.parse(currentDate);
			Long diff = (lmpDate.getTime() - sysDate.getTime())/(1000 * 60 * 60 * 24);
			 days = (int) (diff + 280);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		return days;
	}

	/**
	 * @param registration
	 * @return obstetricScore
	 */
	private String getObstetricScore(Registration registration) {
		int g =registration.getPregnancyCount();
		int l = (g-1)*2;
		int a = g-1;
		int p = g-a-1;
		String obstetricScore = "G"+g+"P"+p+"A"+a+"L"+l;
		return obstetricScore;
	}

	/**
	 * @param registration
	 * @param symptom 
	 * @return
	 */
	private String getFindings(Registration registration, HashMap<String, String> symptom) {
		
		logger.info("Entering :: RegistrationHandlerImpl :: getFindings method");
		StringBuilder findings = new StringBuilder();
		StringBuilder clinicalAsses = new StringBuilder();
		List<String> testresult=null;
		String visitDate ="";
		String genralExamination = "";
		String bpHistory ="";
		String weightHistory = "";
		ArrayList<String> assesmentStatus = new ArrayList<String>();
		List<PregnancyVisit> pregnancyList = reportDao.findByWid(registration.getUid());
		
		List<PostpartumVisit> postpartumList = reportDao.findByPWid(registration.getUid());
		
		int noOfVisit =pregnancyList.size() + postpartumList.size();
		String visitType =Constant.PREGNANT;
		
		if(StringUtil.isListNotNullNEmpty(pregnancyList) && StringUtil.isListNotNullNEmpty(postpartumList)){
			String pregnancyVisitDate = pregnancyList.get(0).getVisitDate();
			String postpartumVistsDate = postpartumList.get(0).getVisitDate();
			
			visitDate = pregnancyVisitDate;
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date preDate = df.parse(pregnancyVisitDate);
				Date postDate = df.parse(postpartumVistsDate);
				if(postDate.after(preDate)){
					visitType =Constant.POSTPARTUM;
					visitDate = postpartumVistsDate;
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}else if(StringUtil.isListNotNullNEmpty(postpartumList)){
			visitType =Constant.POSTPARTUM;
			visitDate = postpartumList.get(0).getVisitDate();
		}else if(StringUtil.isListNotNullNEmpty(pregnancyList)){
			visitType =Constant.PREGNANT;
			visitDate =  pregnancyList.get(0).getVisitDate();
		}else{
			visitType="";
		}
		
		if(Constant.PREGNANT.equalsIgnoreCase(visitType)){
			PregnancyVisit pregnancyVisit = pregnancyList.get(0);
			//get all symptom phrases
			//check have fever
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getHaveFever())){
				if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsFeverAssocated())){
					if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsFeverComeAndGo())){
						findings.append(symptom.get("PHRASES1"));
						findings.append(", ");
					}else{
						findings.append(symptom.get("PHRASES2"));
						findings.append(", ");
					}
				}else if(Constant.No.equalsIgnoreCase(pregnancyVisit.getIsFeverAssocated())){
					
					if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsFeverComeAndGo())){
						findings.append(symptom.get("PHRASES3"));
						findings.append(", ");
					}else{
						findings.append(symptom.get("PHRASES4"));
						findings.append(", ");
					}
					
				}
				
			}else{
				findings.append(symptom.get("PHRASES5"));
				findings.append(", ");
			}
			//check feel tired
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsFeelTired())){
				findings.append(symptom.get("PHRASES6"));
				findings.append(", ");
			}else if(Constant.No.equalsIgnoreCase(pregnancyVisit.getIsFeelTired())){
				findings.append(symptom.get("PHRASES7"));
				findings.append(", ");
			}else{
				//TODO Nothing
			}
			//check have feet
			
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsFits())){
				findings.append(symptom.get("PHRASES8"));
				findings.append(", ");
			}else if(Constant.No.equalsIgnoreCase(pregnancyVisit.getIsFits())){
				findings.append(symptom.get("PHRASES9"));
				findings.append(", ");
			}else{
				//TODO Nothing
			}
			//check have consciousness
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsConsciousness())){
				findings.append(symptom.get("PHRASES10"));
				findings.append(", ");
			}else if(Constant.No.equalsIgnoreCase(pregnancyVisit.getIsConsciousness())){
				findings.append(symptom.get("PHRASES11"));
				findings.append(", ");
			}else{
				//TODO Nothing
			}
			//check have felt giddy
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getFeltGiddy())){
				findings.append(symptom.get("PHRASES12"));
				findings.append(", ");
			}else if(Constant.No.equalsIgnoreCase(pregnancyVisit.getFeltGiddy())){
				findings.append(symptom.get("PHRASES13"));
				findings.append(", ");
			}else{
				//TODO Nothing
			}
			
			//check have headaches
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getHaveHeadaches())){
				findings.append(symptom.get("PHRASES14"));
				findings.append(", ");
			}else if(Constant.No.equalsIgnoreCase(pregnancyVisit.getHaveHeadaches())){
				findings.append(symptom.get("PHRASES15"));
				findings.append(", ");
			}else{
				//TODO Nothing
			}
			
			//check have Blurred Vision
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getHaveBlurredVision())){
				findings.append(symptom.get("PHRASES16"));
				findings.append(", ");
			}else if(Constant.No.equalsIgnoreCase(pregnancyVisit.getHaveBlurredVision())){
				findings.append(symptom.get("PHRASES17"));
				findings.append(", ");
			}else{
				//TODO Nothing
			}
			
			//check have breathless
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsBreathless())){
				if(pregnancyVisit.getWhenBreathless().contains(Constant.SITTING)){
					findings.append(symptom.get("PHRASES18"));
					findings.append(", ");
				}
				if(pregnancyVisit.getWhenBreathless().contains(Constant.COOKING)){
					findings.append(symptom.get("PHRASES19"));
					findings.append(", ");
				}
				if(pregnancyVisit.getWhenBreathless().contains(Constant.CARRING_LOAD)){
					findings.append(symptom.get("PHRASES20"));
					findings.append(", ");
				}
				
			}else if(Constant.No.equalsIgnoreCase(pregnancyVisit.getIsBreathless())){
				findings.append(symptom.get("PHRASES21"));
				findings.append(", ");
			}else{
				//TODO Nothing
			}
			
			//check cough
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getHaveCough())){
				if(pregnancyVisit.getHowLongHaveCough().equalsIgnoreCase(Constant.LESS_THEN_THREE_WEEK)){
					findings.append(symptom.get("PHRASES21"));
					findings.append(", ");
				}else if(pregnancyVisit.getHowLongHaveCough().equalsIgnoreCase(Constant.MORE_THEN_THREE_WEEK)){
					findings.append(symptom.get("PHRASES22"));
					findings.append(", ");
				}else{
					//TODO nothing
				}
				
			}else if(Constant.No.equalsIgnoreCase(pregnancyVisit.getHaveCough())){
				findings.append(symptom.get("PHRASES23"));
				findings.append(", ");
			}else{
				//TODO nothing
			}
			
			//check for abnormal pain
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsAbdominalPain())){
				if(pregnancyVisit.getWherePain().equalsIgnoreCase(Constant.UPPER)){
					findings.append(symptom.get("PHRASES24"));
					findings.append(", ");
				}else if(pregnancyVisit.getWherePain().equalsIgnoreCase(Constant.LOWER)){
					findings.append(symptom.get("PHRASES25"));
					findings.append(", ");
				}else{
					findings.append(symptom.get("PHRASES26"));
					findings.append(", ");
				}
			}else{
				findings.append(symptom.get("PHRASES27"));
				findings.append(", ");
			}
			
			//check for baby move
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getBabyMove())){
				findings.append(symptom.get("PHRASES28"));
				findings.append(", ");
			}else{
				findings.append(symptom.get("PHRASES29"));
				findings.append(", ");
			}
			//check for verginal discharge
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsVaginalDischarge())){
				findings.append(symptom.get("PHRASES30"));
				findings.append(", ");
			}else{
				findings.append(symptom.get("PHRASES31"));
				findings.append(", ");
			}
			
			//check for bleeding
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsBleeding())){
				if(Constant.SPOTTING.contains(pregnancyVisit.getKindOfBleeding())){
					findings.append(symptom.get("PHRASES32"));
					findings.append(", ");
				}else if(Constant.PERIOD_LIKE.contains(pregnancyVisit.getKindOfBleeding())){
					findings.append(symptom.get("PHRASES33"));
					findings.append(", ");
				}else if(Constant.TAP_LIKE.contains(pregnancyVisit.getKindOfBleeding())){
					findings.append(symptom.get("PHRASES34"));
					findings.append(", ");
				}else{
				//TODO Nothing	
				}
			}else{
				findings.append(symptom.get("PHRASES35"));
				findings.append(", ");
			}
			
			//check for water broken
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsWaterBroken())){
				findings.append(symptom.get("PHRASES36"));
				findings.append(", ");
			}else if(Constant.No.equalsIgnoreCase(pregnancyVisit.getIsWaterBroken())){
				findings.append(symptom.get("PHRASES37"));
				findings.append(", ");
			}else{
				//TODO Nothing
			}
			
			//check burning pain while unirating
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsBurningPain())){
				findings.append(symptom.get("PHRASES38"));
				findings.append(", ");
			}else if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsBurningPain())){
				findings.append(symptom.get("PHRASES39"));
				findings.append(", ");
			}else{
				//TODO Nothing
			}
			//check for toe ring tigher
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getToeRingsTighter())){
				findings.append(symptom.get("PHRASES40"));
				findings.append(", ");
			}else if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getToeRingsTighter())){
				findings.append(symptom.get("PHRASES41"));
				findings.append(", ");
			}else{
				//TODO Nothing
			}
			//check for bangless
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsBangles())){
				findings.append(symptom.get("PHRASES42"));
				findings.append(", ");
			}else if(Constant.No.equalsIgnoreCase(pregnancyVisit.getIsBangles())){
				findings.append(symptom.get("PHRASES43"));
				findings.append(", ");
			}else{
				//TODO Nothing
			}
			
			//check tailkin illogical
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsTalking())){
				findings.append(symptom.get("PHRASES44"));
				findings.append(", ");
			}else if(Constant.No.equalsIgnoreCase(pregnancyVisit.getIsTalking())){
				findings.append(symptom.get("PHRASES45"));
				findings.append(", ");
			}else{
				//TODO Nothing
			}
			
			//check out of breath
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsoutOfBreath())){
				findings.append(symptom.get("PHRASES46"));
				findings.append(", ");
			}
			//check for talking irrelevantly
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsTalking())){
				findings.append(symptom.get("PHRASES47"));
				findings.append(", ");
			}
			
			//check for talking irrelevantly
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsTalking())){
				findings.append(symptom.get("PHRASES48"));
				findings.append(", ");
			}
			
			//check for upper eye color
			if(Constant.YELLOW.equalsIgnoreCase(pregnancyVisit.getUpperEyeColor())){
				findings.append(symptom.get("PHRASES49"));
				findings.append(", ");
			}
			//check for lower eye color
			if(Constant.YELLOW.equalsIgnoreCase(pregnancyVisit.getLowerEyeColor())){
				findings.append(symptom.get("PHRASES50"));
				findings.append(", ");
			}
			
			//check for Ankle Depression
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsAnkleDepression())){
				findings.append(symptom.get("PHRASES51"));
				findings.append(", ");
			}
			//check for Eye Swelling
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsEyeSwelling())){
				findings.append(symptom.get("PHRASES52"));
			}
			
			// code added for clinical assessment
			
			//get Gestational Age in week
			int gestationalAge =getGestationalAge(registration); 
			
			
			if((Constant.Yes.equalsIgnoreCase(pregnancyVisit.getHaveFever()) ||Constant.Yes.equalsIgnoreCase(pregnancyVisit.getHaveFever())) &&(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsFits()) ||Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsTalking()))){
				clinicalAsses.append(Condition.CVT);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.EMERGENCY);
			}
			
			String bp[] = pregnancyVisit.getFirstBp().split("/");
			Boolean bpCheck =false;
			if(bp.length ==2){
				if(Integer.parseInt(bp[0]) > 160 && Integer.parseInt(bp[1]) > 110 ){
					bpCheck =true;
				}
			}
			
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsAnkleDepression()) || Constant.Yes.equalsIgnoreCase(pregnancyVisit.getUrine()) && Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsFits()) || Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsConsciousness()) || bpCheck){
				clinicalAsses.append(Condition.ECLAMPSIA);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.HIGH);
				//servrity high
			}
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsAnkleDepression()) || Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsBurningPain()) && Constant.Yes.equalsIgnoreCase(pregnancyVisit.getHaveHeadaches()) || Constant.Yes.equalsIgnoreCase(pregnancyVisit.getHaveBlurredVision()) || Constant.UPPER.equalsIgnoreCase(pregnancyVisit.getWherePain())){
				clinicalAsses.append(Condition.IMMINENT_ECLAMPSIA);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.HIGH);
				
			}
			
			
			
			
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsEyeSwelling()) || "3+".equalsIgnoreCase(pregnancyVisit.getFirstUrine()) || bpCheck){
				clinicalAsses.append(Condition.IMMINENT_ECLAMPSIA);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.HIGH);
			}
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsAnkleDepression()) || Integer.parseInt(bp[0]) <= 160 && Integer.parseInt(bp[0]) >= 140 && Integer.parseInt(bp[1]) <= 110 && Integer.parseInt(bp[1]) >= 90 && Constant.Yes.equalsIgnoreCase(pregnancyVisit.getUrine())){
				clinicalAsses.append(Condition.PRE_ECLAMPSIA);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.LOW);
			}
			
			
			
			
			int hb = Integer.parseInt(pregnancyVisit.getFirstHb());
			
			if(hb > 11 && hb < 7){
				clinicalAsses.append(Condition.ANAEMIA);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.LOW);
			}
			if(Constant.PALE.equalsIgnoreCase(pregnancyVisit.getLowerEyeColor()) || Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsAnkleDepression()) || hb < 7 && Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsBreathless()) || Constant.COOKING.equalsIgnoreCase(pregnancyVisit.getWhenBreathless())|| Constant.Yes.equalsIgnoreCase(pregnancyVisit.getHaveCough())){
				clinicalAsses.append(Condition.SEVERE_ANAEMIA);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.EMERGENCY);
			}
			
			
			if(Constant.No.equalsIgnoreCase(pregnancyVisit.getHaveFever()) && Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsBurningPain())){
				clinicalAsses.append(Condition.UTI);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.LOW);
				//low serverity
			}
			
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getHaveFever()) && Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsBurningPain())){
				clinicalAsses.append(Condition.UTI);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.HIGH);
				//high serverity
			}
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getHaveFever()) && Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsAbdominalPain()) && Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsTalking())){
				clinicalAsses.append(Condition.SEPSIS);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.HIGH);
				//high serverity
			}
			
			
			if(gestationalAge < Constant.FOURTEEN &&  Constant.LOWER.equalsIgnoreCase(pregnancyVisit.getWherePain()) && (Constant.SPOTTING.equalsIgnoreCase(pregnancyVisit.getKindOfBleeding()) || Constant.PERIOD_LIKE.equalsIgnoreCase(pregnancyVisit.getKindOfBleeding()) ) ){
				clinicalAsses.append(Condition.ECTOPIC_PREGNANCY_OR_ABORTION);
				clinicalAsses.append(", ");
			}
			

			if(gestationalAge < Constant.FOURTEEN &&  Constant.LOWER.equalsIgnoreCase(pregnancyVisit.getWherePain()) && Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsConsciousness()) && (Constant.SPOTTING.equalsIgnoreCase(pregnancyVisit.getKindOfBleeding()) || Constant.PERIOD_LIKE.equalsIgnoreCase(pregnancyVisit.getKindOfBleeding()) ) ){
				clinicalAsses.append(Condition.ECTOPIC_PREGNANCY);
				clinicalAsses.append(", ");
			}
			
			if(gestationalAge < Constant.FOURTEEN && gestationalAge < Constant.TWO_EIGHT &&  Constant.LOWER.equalsIgnoreCase(pregnancyVisit.getWherePain()) && (Constant.SPOTTING.equalsIgnoreCase(pregnancyVisit.getKindOfBleeding()) || Constant.PERIOD_LIKE.equalsIgnoreCase(pregnancyVisit.getKindOfBleeding()) ) ){
				clinicalAsses.append(Condition.ABORTION);
				clinicalAsses.append(", ");
			}
			if(gestationalAge > Constant.TWO_EIGHT &&  Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsAbdominalPain()) && (Constant.SPOTTING.equalsIgnoreCase(pregnancyVisit.getKindOfBleeding()) || Constant.PERIOD_LIKE.equalsIgnoreCase(pregnancyVisit.getKindOfBleeding()) ) ){
				clinicalAsses.append(Condition.ABRUPTIO_PLACENTA);
				clinicalAsses.append(", ");
			}

			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsAbdominalPain()) && Constant.TAP_LIKE.equalsIgnoreCase(pregnancyVisit.getKindOfBleeding())){
				clinicalAsses.append(Condition.ABRUPTIO_PLACENTA);
				clinicalAsses.append(", ");
			}
			
			/*
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsAbdominalPain()) && Constant.TAP_LIKE.equalsIgnoreCase(pregnancyVisit.getKindOfBleeding())){
				clinicalAsses.append(Condition.ABRUPTIO_PLACENTA);
				clinicalAsses.append(", ");
			}*/
			
			if(Constant.SPOTTING.equalsIgnoreCase(pregnancyVisit.getKindOfBleeding()) && Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsAbdominalPain()) && Constant.Yes.equalsIgnoreCase(pregnancyVisit.getBabyMove()) && gestationalAge > Constant.TWO_EIGHT){
				clinicalAsses.append(Condition.ABRUPTIO_PLACENTA_AND_INTRAUTERINE_DEATH);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.EMERGENCY);
				//servarity emergency
			}
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getBabyMove()) && gestationalAge > Constant.TWO_EIGHT){
				clinicalAsses.append(Condition.INTRAUTERINE_DEATH);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.HIGH);
				//servarity High
			}
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsAbdominalPain()) && Constant.No.equalsIgnoreCase(pregnancyVisit.getIsBleeding()) && Constant.No.equalsIgnoreCase(pregnancyVisit.getIsAnkleDepression())){
				clinicalAsses.append(Condition.ABDOMINAL_PAIN_FOR_EVALUATION);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.EMERGENCY);
				//servarity emergency
			}
			
			
			
			if(gestationalAge < Constant.FOURTEEN &&  Constant.No.equalsIgnoreCase(pregnancyVisit.getIsAbdominalPain()) && Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsConsciousness()) && (Constant.SPOTTING.equalsIgnoreCase(pregnancyVisit.getKindOfBleeding()) || Constant.PERIOD_LIKE.equalsIgnoreCase(pregnancyVisit.getKindOfBleeding()) ) ){
				clinicalAsses.append(Condition.FIRST_TRIMESTER_BLEEDING);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.LOW);
			}
			if(gestationalAge >= Constant.FOURTEEN && gestationalAge <= Constant.TWO_EIGHT &&  Constant.No.equalsIgnoreCase(pregnancyVisit.getIsAbdominalPain()) && Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsConsciousness()) && (Constant.SPOTTING.equalsIgnoreCase(pregnancyVisit.getKindOfBleeding()) || Constant.PERIOD_LIKE.equalsIgnoreCase(pregnancyVisit.getKindOfBleeding()) ) ){
				clinicalAsses.append(Condition.MID_PREGNANCY_BLEEDING);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.LOW);
			}
			if(gestationalAge > Constant.TWO_EIGHT &&  Constant.No.equalsIgnoreCase(pregnancyVisit.getIsAbdominalPain()) && Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsConsciousness()) && (Constant.SPOTTING.equalsIgnoreCase(pregnancyVisit.getKindOfBleeding()) || Constant.PERIOD_LIKE.equalsIgnoreCase(pregnancyVisit.getKindOfBleeding()) ) ){
				clinicalAsses.append(Condition.LATE_PREGNANCY_BLEEDING);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.LOW);
			}
			
			if(Constant.MORE_THEN_THREE_WEEK.equalsIgnoreCase(pregnancyVisit.getHowLongHaveCough()) && Constant.SPUTUM_TEST_POSITIVE.equalsIgnoreCase(pregnancyVisit.getSputumTest())){
				clinicalAsses.append(Condition.TUBERCULOSIS);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.HIGH);
				//servrity high
			}
			if(Constant.MORE_THEN_THREE_WEEK.equalsIgnoreCase(pregnancyVisit.getHowLongHaveCough()) && (Constant.SPUTUM_TEST_NEGATIVE.equalsIgnoreCase(pregnancyVisit.getSputumTest()) || Constant.NOT_DONE.equalsIgnoreCase(pregnancyVisit.getSputum()))){
				clinicalAsses.append(Condition.TUBERCULOSIS);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.LOW);
				//servrity Low
				
			}
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getHaveFever()) && Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsFeverAssocated()) && Constant.SPUTUM_TEST_POSITIVE.equalsIgnoreCase(pregnancyVisit.getFirstMalaria())){
				clinicalAsses.append(Condition.MALARIA);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.LOW);
				//servrity Low
				
			}
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getHaveFever()) && Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsFeverAssocated()) && Constant.NOT_DONE.equalsIgnoreCase(pregnancyVisit.getMalaria())){
				clinicalAsses.append(Condition.MALARIA);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.LOW);
				//servrity Low
				
			}
			if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getHaveFever()) && Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsFeverAssocated()) && Constant.SPUTUM_TEST_NEGATIVE.equalsIgnoreCase(pregnancyVisit.getFirstMalaria())){
				clinicalAsses.append(Condition.MALARIA);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.LOW);
				//servrity Low
			
			}
			
			if(Integer.parseInt(pregnancyVisit.getFirstRbs()) > 140 ){
				clinicalAsses.append(Condition.GESTATIONAL_DIABETES);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.LOW);
			}
			if(Integer.parseInt(pregnancyVisit.getFirstHb()) < 10 ){
				clinicalAsses.append(Condition.ANAEMIA);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.LOW);
			}
			if(Integer.parseInt(pregnancyVisit.getFirstHb()) < Constant.SEVEN ){
				clinicalAsses.append(Condition.SEVERE_ANAEMIA);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.HIGH);
			}
			if(Constant.YELLOW.equalsIgnoreCase(pregnancyVisit.getUpperEyeColor())){
				clinicalAsses.append(Condition.ICTERUS_EVALUATION);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.HIGH);
			}
			if(Constant.SPUTUM_TEST_POSITIVE.equalsIgnoreCase(pregnancyVisit.getSputumTest())){
				clinicalAsses.append(Condition.TUBERCULOSIS);
				assesmentStatus.add(Condition.LOW);
			}
			
			genralExamination = getPregnenecyGeneralExamination(pregnancyVisit,symptom);
			bpHistory =getPregnencyBpDetails(pregnancyVisit);
			weightHistory = getWeightHistory(pregnancyVisit);
			testresult = getTestResult(pregnancyVisit);
		}else if(Constant.POSTPARTUM.equalsIgnoreCase(visitType)){
			PostpartumVisit postpartumVisit = postpartumList.get(0);
			
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getHaveFever())){
				if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsFeverAssocated())){
					if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsFeverComeAndGo())){
						findings.append(symptom.get("PHRASES1"));
						findings.append(", ");
					}else{
						findings.append(symptom.get("PHRASES2"));
						findings.append(", ");
					}
				}else if(Constant.No.equalsIgnoreCase(postpartumVisit.getIsFeverAssocated())){
					
					if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsFeverComeAndGo())){
						findings.append(symptom.get("PHRASES3"));
						findings.append(", ");
					}else{
						findings.append(symptom.get("PHRASES4"));
						findings.append(", ");
					}
					
				}else{
					findings.append(symptom.get("PHRASES5"));
					findings.append(", ");
				}
				
			}
			
			//check have feet
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsFits())){
				findings.append(symptom.get("PHRASES8"));
				findings.append(", ");
			}else if(Constant.No.equalsIgnoreCase(postpartumVisit.getIsFits())){
				findings.append(symptom.get("PHRASES9"));
				findings.append(", ");
			}else{
				//TODO Nothing
			}
			
			//check have consciousness
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsConsciousness())){
				findings.append(symptom.get("PHRASES10"));
				findings.append(", ");
			}else if(Constant.No.equalsIgnoreCase(postpartumVisit.getIsConsciousness())){
				findings.append(symptom.get("PHRASES11"));
				findings.append(", ");
			}else{
				//TODO Nothing
			}
			
			//check have headaches
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getHaveHeadaches())){
				findings.append(symptom.get("PHRASES14"));
				findings.append(", ");
			}else if(Constant.No.equalsIgnoreCase(postpartumVisit.getHaveHeadaches())){
				findings.append(symptom.get("PHRASES15"));
				findings.append(", ");
			}else{
				//TODO Nothing
			}
			//check have Blurred Vision
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getHaveBlurredVision())){
				findings.append(symptom.get("PHRASES16"));
				findings.append(", ");
			}else if(Constant.No.equalsIgnoreCase(postpartumVisit.getHaveBlurredVision())){
				findings.append(symptom.get("PHRASES17"));
				findings.append(", ");
			}else{
				//TODO Nothing
			}
			//check for fedding baby
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsDifficultToFeed())){
				if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getPainInBreast())){
					if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getLumpInBreast())){
						findings.append(symptom.get("PHRASES53"));
						findings.append(", ");
					}else if(Constant.No.equalsIgnoreCase(postpartumVisit.getLumpInBreast())){
						findings.append(symptom.get("PHRASES54"));
						findings.append(", ");
					}else{
						//TODO NOTHING
					}
				}else if(Constant.No.equalsIgnoreCase(postpartumVisit.getPainInBreast())){
					findings.append(symptom.get("PHRASES55"));
					findings.append(", ");
				}else{
					//TODO Nothing
				}
			}else if(Constant.No.equalsIgnoreCase(postpartumVisit.getIsDifficultToFeed())){
				findings.append(symptom.get("PHRASES56"));
				findings.append(", ");
			}else{
				//TODO Nothing
			}
			//check have breathless
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsBreathless())){
				if(postpartumVisit.getWhenBreathless().contains(Constant.SITTING)){
					findings.append(symptom.get("PHRASES18"));
					findings.append(", ");
				}
				if(postpartumVisit.getWhenBreathless().contains(Constant.COOKING)){
					findings.append(symptom.get("PHRASES19"));
					findings.append(", ");
				}
				if(postpartumVisit.getWhenBreathless().contains(Constant.CARRING_LOAD)){
					findings.append(symptom.get("PHRASES20"));
					findings.append(", ");
				}
				
			}else if(Constant.No.equalsIgnoreCase(postpartumVisit.getIsBreathless())){
				findings.append(symptom.get("PHRASES21"));
				findings.append(", ");
			}else{
				//TODO Nothing
			}
			//check cough
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getHaveCough())){
				if(postpartumVisit.getHowLongHaveCough().equalsIgnoreCase(Constant.LESS_THEN_THREE_WEEK)){
					findings.append(symptom.get("PHRASES21"));
					findings.append(", ");
				}else if(postpartumVisit.getHowLongHaveCough().equalsIgnoreCase(Constant.MORE_THEN_THREE_WEEK)){
					findings.append(symptom.get("PHRASES22"));
					findings.append(", ");
				}else{
					//TODO nothing
				}
				
			}else if(Constant.No.equalsIgnoreCase(postpartumVisit.getHaveCough())){
				findings.append(symptom.get("PHRASES23"));
				findings.append(", ");
			}else{
				//TODO nothing
			}
			//check for abnormal pain
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsAbdominalPain())){
				if(postpartumVisit.getWherePain().equalsIgnoreCase(Constant.UPPER)){
					findings.append(symptom.get("PHRASES24"));
					findings.append(", ");
				}else if(postpartumVisit.getWherePain().equalsIgnoreCase(Constant.LOWER)){
					findings.append(symptom.get("PHRASES25"));
					findings.append(", ");
				}else{
					findings.append(symptom.get("PHRASES26"));
					findings.append(", ");
				}
			}else{
				findings.append(symptom.get("PHRASES27"));
				findings.append(", ");
			}
			//check for verginal discharge
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsVaginalDischarge())){
				findings.append(symptom.get("PHRASES30"));
				findings.append(", ");
			}else{
				findings.append(symptom.get("PHRASES31"));
				findings.append(", ");
			}
			//check for bleeding
			
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsBleeding())){
				if(Constant.NO_OF_DAY < Integer.parseInt(postpartumVisit.getNoDayAfterDel())){
					findings.append(symptom.get("PHRASES57"));
					findings.append(", ");
				}else if(Constant.NO_OF_DAY > Integer.parseInt(postpartumVisit.getNoDayAfterDel())){
					findings.append(symptom.get("PHRASES58"));
					findings.append(", ");
				}else{
					//TODO Nothing
				}
				if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsPassClotBleeding())){
					findings.append(symptom.get("PHRASES59"));
					findings.append(", ");
				}else if(Constant.No.equalsIgnoreCase(postpartumVisit.getIsPassClotBleeding())){
					findings.append(symptom.get("PHRASES60"));
					findings.append(", ");
				}else{
					//TODO Nothing
				}
				
				if(Constant.THREE_OR_MORE < Integer.parseInt(postpartumVisit.getNoOfClothes())){
					findings.append(symptom.get("PHRASES61"));
					findings.append(", ");
				}else if(Constant.TWO_OR_LESS >  Integer.parseInt(postpartumVisit.getNoOfClothes())){
					findings.append(symptom.get("PHRASES62"));
					findings.append(", ");
				}
				if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getHasBleedingIncrease())){
					findings.append(symptom.get("PHRASES63"));
					findings.append(", ");
				}else if(Constant.No.equalsIgnoreCase(postpartumVisit.getHasBleedingIncrease())){
					findings.append(symptom.get("PHRASES64"));
					findings.append(", ");
				}else{
					//TODO Nothing
				}
			}else if(Constant.No.equalsIgnoreCase(postpartumVisit.getIsBleeding())){
				findings.append(symptom.get("PHRASES65"));
				findings.append(", ");
			}else{
				//TODO Nothing
			}
			
			//check burning pain while unirating
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsBurningPain())){
				findings.append(symptom.get("PHRASES38"));
				findings.append(", ");
			}else if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsBurningPain())){
				findings.append(symptom.get("PHRASES39"));
				findings.append(", ");
			}else{
				//TODO Nothing
			}
			//check tailkin illogical
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsTalking())){
				findings.append(symptom.get("PHRASES44"));
				findings.append(", ");
			}else if(Constant.No.equalsIgnoreCase(postpartumVisit.getIsTalking())){
				findings.append(symptom.get("PHRASES45"));
				findings.append(", ");
			}else{
				//TODO Nothing
			}
			
			//check interest in carring baby
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getCarringBabyAndHerself())){
				findings.append(symptom.get("PHRASES66"));
				findings.append(", ");
			}else if(Constant.No.equalsIgnoreCase(postpartumVisit.getCarringBabyAndHerself())){
				findings.append(symptom.get("PHRASES67"));
				findings.append(", ");
			}else{
				//TODO Nothing
			}
			
			//check Hearing imaginary sound
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsHearingImaginary())){
				findings.append(symptom.get("PHRASES68"));
				findings.append(", ");
			}else if(Constant.No.equalsIgnoreCase(postpartumVisit.getIsHearingImaginary())){
				findings.append(symptom.get("PHRASES69"));
				findings.append(", ");
			}else{
				//TODO Nothing
			}
			
			//check out of breath
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsoutOfBreath())){
				findings.append(symptom.get("PHRASES46"));
				findings.append(", ");
			}
			//check for talking irrelevantly
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsTalking())){
				findings.append(symptom.get("PHRASES47"));
				findings.append(", ");
			}
			
			//check for talking irrelevantly
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsTalking())){
				findings.append(symptom.get("PHRASES48"));
				findings.append(", ");
			}
			
			//check for upper eye color
			if(Constant.YELLOW.equalsIgnoreCase(postpartumVisit.getUpperEyeColor())){
				findings.append(symptom.get("PHRASES49"));
				findings.append(", ");
			}
			//check for lower eye color
			if(Constant.YELLOW.equalsIgnoreCase(postpartumVisit.getLowerEyeColor())){
				findings.append(symptom.get("PHRASES50"));
				findings.append(", ");
			}
			
			//check for Ankle Depression
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsAnkleDepression())){
				findings.append(symptom.get("PHRASES51"));
				findings.append(", ");
			}
			//check for Eye Swelling
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsEyeSwelling())){
				findings.append(symptom.get("PHRASES52"));
				findings.append(", ");
			}
			
			
			// code added for clinical assessment for postpartum woman
			
			
			//get Gestational Age in week
		//	int gestationalAge =getGestationalAge(registration); 
			
			
			if((Constant.Yes.equalsIgnoreCase(postpartumVisit.getHaveFever()) ||Constant.Yes.equalsIgnoreCase(postpartumVisit.getHaveFever())) &&(Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsFits()) ||Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsTalking()))){
				clinicalAsses.append(Condition.CVT);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.EMERGENCY);
			}
			
			String bp[] = postpartumVisit.getFirstBp().split("/");
			Boolean bpCheck =false;
			if(bp.length ==2){
				if(Integer.parseInt(bp[0]) > 160 && Integer.parseInt(bp[1]) > 110 ){
					bpCheck =true;
				}
			}
			
			
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsEyeSwelling()) || "3+".equalsIgnoreCase(postpartumVisit.getFirstUrine()) || bpCheck){
				clinicalAsses.append(Condition.IMMINENT_ECLAMPSIA);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.HIGH);
			}
			
			int hb = Integer.parseInt(postpartumVisit.getFirstHb());
			
			if(hb > 11 && hb < 7){
				clinicalAsses.append(Condition.ANAEMIA);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.LOW);
			}
			
			if(Constant.No.equalsIgnoreCase(postpartumVisit.getHaveFever()) && Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsBurningPain())){
				clinicalAsses.append(Condition.UTI);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.LOW);
				//low serverity
			}
			
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getHaveFever()) && Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsBurningPain())){
				clinicalAsses.append(Condition.UTI);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.HIGH);
				//high serverity
			}
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getHaveFever()) && Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsAbdominalPain()) && Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsTalking())){
				clinicalAsses.append(Condition.SEPSIS);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.HIGH);
				//high serverity
			}
		
			
			if(Constant.MORE_THEN_THREE_WEEK.equalsIgnoreCase(postpartumVisit.getHowLongHaveCough()) && Constant.SPUTUM_TEST_POSITIVE.equalsIgnoreCase(postpartumVisit.getSputumTest())){
				clinicalAsses.append(Condition.TUBERCULOSIS);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.HIGH);
				//servrity high
			}
			if(Constant.MORE_THEN_THREE_WEEK.equalsIgnoreCase(postpartumVisit.getHowLongHaveCough()) && (Constant.SPUTUM_TEST_NEGATIVE.equalsIgnoreCase(postpartumVisit.getSputumTest()) || Constant.NOT_DONE.equalsIgnoreCase(postpartumVisit.getSputum()))){
				clinicalAsses.append(Condition.TUBERCULOSIS);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.LOW);
				//servrity Low
				
			}
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getHaveFever()) && Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsFeverAssocated()) && Constant.SPUTUM_TEST_POSITIVE.equalsIgnoreCase(postpartumVisit.getFirstMalaria())){
				clinicalAsses.append(Condition.MALARIA);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.LOW);
				//servrity Low
				
			}
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getHaveFever()) && Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsFeverAssocated()) && Constant.NOT_DONE.equalsIgnoreCase(postpartumVisit.getMalaria())){
				clinicalAsses.append(Condition.MALARIA);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.LOW);
				//servrity Low
				
			}
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getHaveFever()) && Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsFeverAssocated()) && Constant.SPUTUM_TEST_NEGATIVE.equalsIgnoreCase(postpartumVisit.getFirstMalaria())){
				clinicalAsses.append(Condition.MALARIA);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.LOW);
				//servrity Low
			
			}
			
			if(Constant.NO_OF_DAY.equals(postpartumVisit.getNoDayAfterDel()) || Constant.Yes.equalsIgnoreCase(postpartumVisit.getHasBleedingIncrease()) || Constant.TWO <Integer.parseInt(postpartumVisit.getNoOfClothes())){
				clinicalAsses.append(Condition.PPH);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.EMERGENCY);
				//servrity Emergency
			}
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getPainInBreast()) && Constant.No.equalsIgnoreCase(postpartumVisit.getHaveFever())){
				clinicalAsses.append(Condition.MASTITIS_BREAST_ABSCESS);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.HIGH);
				//servrity High
			
			}
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getPainInBreast()) && Constant.Yes.equalsIgnoreCase(postpartumVisit.getHaveFever())){
				clinicalAsses.append(Condition.MASTITIS_BREAST_ABSCESS);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.HIGH);
				//servrity High
			
			}
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getLumpInBreast()) && Constant.Yes.equalsIgnoreCase(postpartumVisit.getHaveFever())){
				clinicalAsses.append(Condition.BREAST_ABSCESS);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.HIGH);
				//servrity High
			}
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsTalking()) && Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsHearingImaginary())){
				clinicalAsses.append(Condition.PSYCHOSIS);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.HIGH);
				//servrity High
			}
			if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsTalking()) && Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsHearingImaginary()) &&  Constant.Yes.equalsIgnoreCase(postpartumVisit.getCarringBabyAndHerself())){
				clinicalAsses.append(Condition.DEPRESSION_PSYHOSIS);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.LOW);
				//servrity low
			}
			if(Constant.No.equalsIgnoreCase(postpartumVisit.getIsTalking()) && Constant.No.equalsIgnoreCase(postpartumVisit.getIsHearingImaginary()) &&  Constant.Yes.equalsIgnoreCase(postpartumVisit.getCarringBabyAndHerself())){
				clinicalAsses.append(Condition.DEPRESSION);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.LOW);
				//servrity low
			}
			
			if(Integer.parseInt(postpartumVisit.getFirstHb()) < 10 ){
				clinicalAsses.append(Condition.ANAEMIA);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.LOW);
			}
			if(Integer.parseInt(postpartumVisit.getFirstHb()) < Constant.SEVEN ){
				clinicalAsses.append(Condition.SEVERE_ANAEMIA);
				clinicalAsses.append(", ");
				assesmentStatus.add(Condition.HIGH);
			}
			
			if(Constant.SPUTUM_TEST_POSITIVE.equalsIgnoreCase(postpartumVisit.getSputumTest())){
				clinicalAsses.append(Condition.TUBERCULOSIS);
				assesmentStatus.add(Condition.HIGH);
			}
			genralExamination = getPostpartumGeneralExamination(postpartumVisit,symptom);
			bpHistory = getPostpartumBpDetails(postpartumVisit);
			testresult = getTestResult(postpartumVisit);
			
		}else{
			//TODO Nothing
	}
		String asses = getAssesmentStatus(assesmentStatus);
		return findings.toString()+":"+clinicalAsses.toString()+":"+noOfVisit+":"+visitDate+":"+genralExamination+":"+bpHistory+":"+weightHistory+":"+testresult+":"+asses;
}


	/**
	 * @param assesmentStatus
	 * @return
	 */
	private String getAssesmentStatus(ArrayList<String> assesmentStatus) {
		
		String status ="";
		HashSet<String> set = new HashSet<String>();
		for(String set1 : assesmentStatus){
			set.add(set1);
		}
		
		Iterator<String> it = set.iterator();
		Map<String, Integer> map = new HashMap<String, Integer>();
		while (it.hasNext()) {
			int count = 0;
			String assesment = it.next();
			for (String status1 : assesmentStatus) {
					if(status1.equalsIgnoreCase(assesment)){
						count++;
					}
			}
			map.put(assesment, count);
		}
		
		
		
		if( map.containsKey(Condition.LOW) &&  map.get(Condition.LOW) <=3){
			status = Condition.LOW;
		}
		if(map.containsKey(Condition.HIGH) && map.get(Condition.HIGH) >=1 ||map.containsKey(Condition.LOW) && map.get(Condition.LOW) >3){
			status = Condition.HIGH;
		}
		if( map.containsKey(Condition.EMERGENCY) && map.get(Condition.EMERGENCY) >=1 || map.containsKey(Condition.HIGH) && map.get(Condition.HIGH) >=2 ){
			status = Condition.EMERGENCY;
		}
		
		return status;
	}

	/**
	 * @param pregnancyVisit
	 * @return
	 */
	private List<String> getTestResult(PregnancyVisit pregnancyVisit) {
		List<String>testResult = new ArrayList<String>();
		if(Constant.DONE.equalsIgnoreCase(pregnancyVisit.getHb())){
			StringBuilder sb = new StringBuilder();
			sb.append("HB = ");
			if(null != pregnancyVisit.getFirstHb()){
				sb.append(pregnancyVisit.getFirstHb());
				sb.append(" (");
				sb.append(pregnancyVisit.getHbDateOne());
				sb.append(" );");
			}
			if(null != pregnancyVisit.getSecHb()){
				sb.append(pregnancyVisit.getSecHb());
				sb.append(" (");
				sb.append(pregnancyVisit.getHbDateSec());
				sb.append(" );");
			}
			testResult.add(sb.toString());
		}
		if(Constant.DONE.equalsIgnoreCase(pregnancyVisit.getUrine())){
			StringBuilder sb = new StringBuilder();
			sb.append("Urine albumin = ");
			if(null != pregnancyVisit.getFirstUrine()){
				sb.append(pregnancyVisit.getFirstUrine());
				sb.append(" (");
				sb.append(pregnancyVisit.getUrineDateOne());
				sb.append(" );");
			}
			if(null != pregnancyVisit.getSecUrine()){
				sb.append(pregnancyVisit.getSecUrine());
				sb.append(" (");
				sb.append(pregnancyVisit.getUrineDateSec());
				sb.append(" );");
			}
			testResult.add(sb.toString());
		}
		if(Constant.DONE.equalsIgnoreCase(pregnancyVisit.getMalaria())){
			StringBuilder sb = new StringBuilder();
			sb.append("Test for Malaria = ");
			if(null != pregnancyVisit.getFirstMalaria()){
				sb.append(pregnancyVisit.getFirstMalaria());
				sb.append(" (");
				sb.append(pregnancyVisit.getMalariaDateOne());
				sb.append(" );");
			}
			if(null != pregnancyVisit.getSecMalaria()){
				sb.append(pregnancyVisit.getSecMalaria());
				sb.append(" (");
				sb.append(pregnancyVisit.getMalariaDateSec());
				sb.append(" );");
			}
			testResult.add(sb.toString());
		}
		if(Constant.DONE.equalsIgnoreCase(pregnancyVisit.getSputum())){
			StringBuilder sb = new StringBuilder();
			sb.append("Sputum Test  = ");
			if(null != pregnancyVisit.getSputumTest()){
				sb.append(pregnancyVisit.getSputumTest());
				sb.append(" (");
				sb.append(pregnancyVisit.getSputumDate());
				sb.append(" );");
			}
			testResult.add(sb.toString());
		}
		if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getUltrasound())){
			StringBuilder sb = new StringBuilder();
			sb.append("Ultrasound Scan = ");
			if(null != pregnancyVisit.getFirstUltrasound()){
				sb.append(pregnancyVisit.getFirstUltrasound());
				sb.append(" (");
				sb.append(pregnancyVisit.getUltrasoundDateOne());
				sb.append(" );");
			}
			if(null != pregnancyVisit.getSecUltrasound()){
				sb.append(pregnancyVisit.getSecUltrasound());
				sb.append(" (");
				sb.append(pregnancyVisit.getUltrasoundDateSec());
				sb.append(" );");
			}
			testResult.add(sb.toString());
		}
		if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getRbs())){
			StringBuilder sb = new StringBuilder();
			sb.append("RBS = ");
			if(null != pregnancyVisit.getFirstRbs()){
				sb.append(pregnancyVisit.getFirstRbs());
				sb.append(" (");
				sb.append(pregnancyVisit.getRbsDateOne());
				sb.append(" );");
			}
			if(null != pregnancyVisit.getSecRbs()){
				sb.append(pregnancyVisit.getSecRbs());
				sb.append(" (");
				sb.append(pregnancyVisit.getRbsDateSec());
				sb.append(" );");
			}
			testResult.add(sb.toString());
		}
		
		
		
		return testResult;
	}

	/**
	 * @param postpartumVisit
	 * @return
	 */
	private List<String> getTestResult(PostpartumVisit postpartumVisit) {
		List<String>testResult = new ArrayList<String>();
		if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getHb())){
			StringBuilder sb = new StringBuilder();
			sb.append("HB = ");
			if(null != postpartumVisit.getFirstHb()){
				sb.append(postpartumVisit.getFirstHb());
				sb.append(" (");
				sb.append(postpartumVisit.getHbDateOne());
				sb.append(" );");
			}
			if(null != postpartumVisit.getSecHb()){
				sb.append(postpartumVisit.getSecHb());
				sb.append(" (");
				sb.append(postpartumVisit.getHbDateSec());
				sb.append(" );");
			}
			testResult.add(sb.toString());
		}
		if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getUrine())){
			StringBuilder sb = new StringBuilder();
			sb.append("Urine albumin = ");
			if(null != postpartumVisit.getFirstUrine()){
				sb.append(postpartumVisit.getFirstUrine());
				sb.append(" (");
				sb.append(postpartumVisit.getUrineDateOne());
				sb.append(" );");
			}
			if(null != postpartumVisit.getSecUrine()){
				sb.append(postpartumVisit.getSecUrine());
				sb.append(" (");
				sb.append(postpartumVisit.getUrineDateSec());
				sb.append(" );");
			}
			testResult.add(sb.toString());
		}
		if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getMalaria())){
			StringBuilder sb = new StringBuilder();
			sb.append("Test for Malaria = ");
			if(null != postpartumVisit.getFirstMalaria()){
				sb.append(postpartumVisit.getFirstMalaria());
				sb.append(" (");
				sb.append(postpartumVisit.getMalariaDateOne());
				sb.append(" );");
			}
			if(null != postpartumVisit.getSecMalaria()){
				sb.append(postpartumVisit.getSecMalaria());
				sb.append(" (");
				sb.append(postpartumVisit.getMalariaDateSec());
				sb.append(" );");
			}
			testResult.add(sb.toString());
		}
		if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getSputum())){
			StringBuilder sb = new StringBuilder();
			sb.append("Sputum Test = ");
			if(null != postpartumVisit.getSputumTest()){
				sb.append(postpartumVisit.getSputumTest());
				sb.append(" (");
				sb.append(postpartumVisit.getSputumDate());
				sb.append(" );");
			}
			testResult.add(sb.toString());
		}
		
		
		
		return testResult;
	}

	/**
	 * @param pregnancyVisit
	 * @return
	 */
	private String getWeightHistory(PregnancyVisit pregnancyVisit) {
		StringBuilder sb = new StringBuilder();
		if(null != pregnancyVisit.getFirstWeight()){
			sb.append(pregnancyVisit.getFirstWeight());
			sb.append(" (");
			sb.append(pregnancyVisit.getWeightDateOne());
			sb.append(" );");
		}
		if(null != pregnancyVisit.getSecWeight()){
			sb.append(pregnancyVisit.getSecWeight());
			sb.append(" (");
			sb.append(pregnancyVisit.getWeightDateOne());
			sb.append(" );");
		}
		if(null != pregnancyVisit.getWeightDateThird()){
			sb.append(pregnancyVisit.getThirdWeight());
			sb.append(" (");
			sb.append(pregnancyVisit.getWeightDateThird());
			sb.append(" );");
		}
		if(null != pregnancyVisit.getFourthWeight()){
			sb.append(pregnancyVisit.getFourthWeight());
			sb.append(" (");
			sb.append(pregnancyVisit.getWeightDateFour());
			sb.append(" );");
		}
	
	return sb.toString();
	}

	/**
	 * @param pregnancyVisit
	 * @return
	 */
	private String getPregnencyBpDetails(PregnancyVisit pregnancyVisit) {	
		StringBuilder sb = new StringBuilder();
		if(null != pregnancyVisit.getFirstBp()){
			sb.append(pregnancyVisit.getFirstBp());
			sb.append(" (");
			sb.append(pregnancyVisit.getBpDateOne());
			sb.append(" );");
		}
		if(null != pregnancyVisit.getSecBp()){
			sb.append(pregnancyVisit.getSecBp());
			sb.append(" (");
			sb.append(pregnancyVisit.getBpDateSec());
			sb.append(" );");
		}
		if(null != pregnancyVisit.getThirdBp()){
			sb.append(pregnancyVisit.getThirdBp());
			sb.append(" (");
			sb.append(pregnancyVisit.getBpDateThird());
			sb.append(" );");
		}
		if(null != pregnancyVisit.getFourBp()){
			sb.append(pregnancyVisit.getFourBp());
			sb.append(" (");
			sb.append(pregnancyVisit.getBpDateFour());
			sb.append(" );");
		}
	
	return sb.toString();
	}

	/**
	 * @param postpartumVisit
	 * @return
	 */
	private String getPostpartumBpDetails(PostpartumVisit postpartumVisit) {
		StringBuilder sb = new StringBuilder();
		if(null != postpartumVisit.getFirstBp()){
			sb.append(postpartumVisit.getFirstBp());
			sb.append(" (");
			sb.append(postpartumVisit.getBpDateOne());
			sb.append(" );");
		}
		if(null != postpartumVisit.getSecBp()){
			sb.append(postpartumVisit.getSecBp());
			sb.append(" (");
			sb.append(postpartumVisit.getBpDateSec());
			sb.append(" );");
		}
		
		return sb.toString();
	}

	/**
	 * @param postpartumVisit
	 * @param symptom
	 * @return
	 */
	private String getPostpartumGeneralExamination(PostpartumVisit postpartumVisit, HashMap<String, String> symptom) {
		String generalExam ="";
		if(Constant.YELLOW.equalsIgnoreCase(postpartumVisit.getUpperEyeColor())){
			generalExam += symptom.get("PHRASES49")+", ";
		}
		if(Constant.PALE.equalsIgnoreCase(postpartumVisit.getLowerEyeColor())){
			generalExam += symptom.get("PHRASES50")+", ";
		}
		if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getLowerEyeColor())){
			generalExam += symptom.get("PHRASES47")+", ";
		}
		if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsAnkleDepression())){
			generalExam += symptom.get("PHRASES51")+", ";
		}
		if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsEyeSwelling())){
			generalExam += symptom.get("PHRASES52")+", ";
		}
		if(Constant.Yes.equalsIgnoreCase(postpartumVisit.getIsTalking())){
			generalExam += symptom.get("PHRASES48")+".";
		}
		return generalExam;
	}

	/**
	 * @param pregnancyVisit
	 * @param symptom 
	 * @return
	 */
	private String getPregnenecyGeneralExamination(PregnancyVisit pregnancyVisit, HashMap<String, String> symptom) {
		
		String generalExam ="";
		if(Constant.YELLOW.equalsIgnoreCase(pregnancyVisit.getUpperEyeColor())){
			generalExam += symptom.get("PHRASES49")+", ";
		}
		if(Constant.PALE.equalsIgnoreCase(pregnancyVisit.getLowerEyeColor())){
			generalExam += symptom.get("PHRASES50")+", ";
		}
		if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getLowerEyeColor())){
			generalExam += symptom.get("PHRASES47")+", ";
		}
		if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsAnkleDepression())){
			generalExam += symptom.get("PHRASES51")+", ";
		}
		if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsEyeSwelling())){
			generalExam += symptom.get("PHRASES52")+", ";
		}
		if(Constant.Yes.equalsIgnoreCase(pregnancyVisit.getIsTalking())){
			generalExam += symptom.get("PHRASES48")+".";
		}
		return generalExam;
	}

	/**
	 * @param registration
	 * @return
	 */
	private int getGestationalAge(Registration registration) {

		Integer days=null;
		
		String lmp = registration.getLmp();
		Date date =new Date();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String currentDate = df.format(date);
		try {
			Date lmpDate = df.parse(lmp);
			Date sysDate = df.parse(currentDate);
			long diff = (sysDate.getTime() - lmpDate.getTime())/(1000 * 60 * 60 * 24 * 7);
			System.out.println(diff);
			 days = (int)diff;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		return days;
	}

	/**
	 * @param reportRequest
	 * @return
	 */
	@Override
	public MedicalCaseSheetDTO getCaseSheetReport(ReportRequest reportRequest) {

		logger.info("Entering :: RegistrationHandlerImpl :: createRegistration method");
		MedicalCaseSheetDTO response = new MedicalCaseSheetDTO();
		try {
			List<Registration> registrationList = reportDao.getReport(reportRequest);
			if(!StringUtil.isListNotNullNEmpty(registrationList)){
				response.setResponseCode(PhfiErrorCodes.REPORT_NOT_FOUND);
				response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
				return response;
			}
			
			//get All Symptoms
			HashMap<String,String> symptom =new HashMap<String,String>();
			List<Symptom> symptomList = symptomDao.findAll();
			if(StringUtil.isListNotNullNEmpty(symptomList)){
				for(Symptom symptomData :symptomList){
					symptom.put(symptomData.getSymptomId(),symptomData.getSymptomPhrases());
				}
			}
			
			for(Registration registration :registrationList){
				String findingAssessVisit[] = getFindings(registration,symptom).split(":");
				if(findingAssessVisit.length <= 10){
					response.setCurrentHistory(findingAssessVisit[0]);
					response.setIntialAsses(findingAssessVisit[1]);
					/*response.setNoOfVisit(findingAssessVisit[2]);*/
					response.setVisitDate(findingAssessVisit[3]);
					response.setGenralExamination(findingAssessVisit[4]);
					response.setBp(findingAssessVisit[5]);
					if(!Constant.POSTPARTUM.equalsIgnoreCase(registration.getMaternityStatus())){
					response.setWeight(findingAssessVisit[6]);
				}
					response.setLabTest(Arrays.asList(findingAssessVisit[7]));
					response.setServerity(findingAssessVisit[8]);
				}
				//check for EDD
				String edd = getEDD(registration.getLmp());
				response.setEdd(edd);
				//check for trimester
				int gestationAge = getGestationalAge(registration);
				String trimester ="";
				if(gestationAge <= 12 ){
					trimester ="First Trimester";
				}else if(gestationAge >=13 && gestationAge <= 24){
					trimester = "Second Trimester";
				}else if(gestationAge >24){
					trimester ="Third Trimester";
				}else{
					
				}
			
				response.setName(registration.getWomenFirstName()+" "+registration.getWomenSurname());
				response.setWid(registration.getUid().toString());
				response.setObstetricScore(getObstetricScore(registration));
				response.setAge(registration.getAge().toString());
				response.setVillageName(registration.getVillageName());
				response.setTakul(registration.getTalukMarital());
				response.setLmp(registration.getLmp());
				response.setCurrentAddress(registration.getStreetMarital()+", "+registration.getVillageMarital()+", "+registration.getTalukMarital()+", "+
				registration.getDistrictMarital()+" ,"+registration.getLandmarkMarital());
				
				response.setAlternativeAddress(registration.getStreetNatal()+", "+registration.getVillageNatal()+", "+registration.getTalukNatal()+", "+
						registration.getDistrictNatal()+" ,"+registration.getLandmarkNatal());
				response.setTrimester(trimester);
				response.setDistric(registration.getDistrictMarital());
				response.setPredisposingFactor(getPredisposingFaction(registration));
				response.setPastHistory(getPastHistory(registration));
			}
		/*	response.setReportRequest(reportList);*/
			response.setNoOfRecords(1);
			response.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
			response.setResponseMessage(Properties.getProperty(response.getResponseCode()));
		} catch (Exception e) {
			logger.error("Error :: RegistrationHandlerImpl :: createRegistration method", e);
			response.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
			response.setResponseMessage(Properties.getProperty(PhfiErrorCodes.SYSTEM_ERROR));
		}
		logger.info("Exiting :: RegistrationHandlerImpl :: createRegistration method");

		return response;
	
	}

	/**
	 * @param registration
	 * @return
	 */
	private String getPastHistory(Registration registration) {
		StringBuilder sb = new StringBuilder();
		if(Constant.Yes.equalsIgnoreCase(registration.getDiabetes())){
			sb.append(Condition.PASTHISTORY1+", ");
		}
		if(Constant.Yes.equalsIgnoreCase(registration.getHypertension())){
			sb.append(Condition.PASTHISTORY2+", ");
		}
		if(Constant.Yes.equalsIgnoreCase(registration.getHeartdisease())){
			sb.append(Condition.PASTHISTORY3+", ");
		}
		if(Constant.Yes.equalsIgnoreCase(registration.getAnaemia())){
			sb.append(Condition.PASTHISTORY4+", ");
		}
		if(Constant.Yes.equalsIgnoreCase(registration.getThyroidproblem())){
			sb.append(Condition.PASTHISTORY5+", ");
		}
		if(0 >= registration.getCaesarean()){
			sb.append("h/o previous lscs"+", ");
		}
		if(Constant.Yes.equalsIgnoreCase(registration.getBleedexcessively())){
			sb.append("h/o previous PPH.");
		}
		
		return sb.toString();
	}

	/**
	 * @param registration
	 * @return
	 */
	private String getPredisposingFaction(Registration registration) {
		StringBuilder sb = new StringBuilder();
		if(17 >= registration.getAge()){
			sb.append(Condition.FACTOR1+", ");
		}
		if(35 <= registration.getAge()){
			sb.append(Condition.FACTOR2 + ", ");
		}
		String recentDel = registration.getDateOfRecentDelivery();
		String lmp = registration.getLmp();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		Date d1 = null;
		Date d2 = null;
		int diffDate =0;
			try {
				d1 = format.parse(recentDel);
				d2 = format.parse(lmp);
				DateTime dt1 = new DateTime(d1);
				DateTime dt2 = new DateTime(d2);
				diffDate =Years.yearsBetween(dt1, dt2).getYears();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			if(diffDate < 2){
				sb.append(Condition.FACTOR3+", ");
			}
			
			int p = getP(registration);
			if(p >= 3){
				sb.append(Condition.FACTOR4+", ");
			}
			if( 140  > registration.getHeight()){
				sb.append(Condition.FACTOR5);
			}
			
		return sb.toString();
	}

	/**
	 * @param registration
	 * @return
	 */
	private int getP(Registration registration) {
		int g =registration.getPregnancyCount();
		int a = g-1;
		int p = g-a-1;
		return p;
	}

	/**
	 * @param lmp
	 * @return
	 */
	private String getEDD(String lmp) {
	
		long totalSec =0;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date lmpDate = df.parse(lmp);
			Long days = 1000*60*60*24*280L;
			totalSec = (lmpDate.getTime() + days);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date d1 = new Date();
		d1.setTime(totalSec);
		 String edd = df.format(d1);
		return edd;
	}

	/**
	 * @return
	 */
	@Override
	public PhfiRegistrationResponse getMasterRawData() {
	logger.info("Entering :: RegistrationHandlerImpl :: createRegistration method");
	PhfiRegistrationResponse rawMasterData = new PhfiRegistrationResponse();
	try {
		List<Registration> registrationRawData = reportDao.getMasterRawData();
		if(!StringUtil.isListNotNullNEmpty(registrationRawData)){
			rawMasterData.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
			rawMasterData.setResponseMessage(Properties.getProperty(rawMasterData.getResponseCode()));
		}
		List<PhfiRegistrationRequest> registrationData = CommonUtil.copyListBeanProperty(registrationRawData, PhfiRegistrationRequest.class);
		rawMasterData.setPhfiRegistrationRequest(registrationData);
		rawMasterData.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
		rawMasterData.setResponseMessage(Properties.getProperty(rawMasterData.getResponseCode()));
	} catch (Exception e) {
		logger.error("Error :: RegistrationHandlerImpl :: createRegistration method", e);
		rawMasterData.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
		rawMasterData.setResponseMessage(Properties.getProperty(PhfiErrorCodes.SYSTEM_ERROR));
	}
	logger.info("Exiting :: RegistrationHandlerImpl :: createRegistration method");

	return rawMasterData;
	}

	/**
	 * @return
	 */
	@Override
	public PhfiVisitResponse getPregnancyRawData() {
		logger.info("Entering :: RegistrationHandlerImpl :: createRegistration method");
		PhfiVisitResponse rawMasterData = new PhfiVisitResponse();
		try {
			List<PregnancyVisit> registrationRawData = reportDao.getPregnancyRawData();
			if(!StringUtil.isListNotNullNEmpty(registrationRawData)){
				rawMasterData.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
				rawMasterData.setResponseMessage(Properties.getProperty(rawMasterData.getResponseCode()));
			}
			List<PhfiVisitRequest> registrationData = CommonUtil.copyListBeanProperty(registrationRawData, PhfiVisitRequest.class);
			rawMasterData.setPhfiVisitRequest(registrationData);
			rawMasterData.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
			rawMasterData.setResponseMessage(Properties.getProperty(rawMasterData.getResponseCode()));
		} catch (Exception e) {
			logger.error("Error :: RegistrationHandlerImpl :: createRegistration method", e);
			rawMasterData.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
			rawMasterData.setResponseMessage(Properties.getProperty(PhfiErrorCodes.SYSTEM_ERROR));
		}
		logger.info("Exiting :: RegistrationHandlerImpl :: createRegistration method");

		return rawMasterData;
	}

	/**
	 * @return
	 */
	@Override
	public PhfiPostPartumVisitResponse getPostpartumRawData() {
		logger.info("Entering :: RegistrationHandlerImpl :: createRegistration method");
		PhfiPostPartumVisitResponse rawMasterData = new PhfiPostPartumVisitResponse();
		try {
			List<PostpartumVisit> registrationRawData = reportDao.getPostpartumRawData();
			if(!StringUtil.isListNotNullNEmpty(registrationRawData)){
				rawMasterData.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
				rawMasterData.setResponseMessage(Properties.getProperty(rawMasterData.getResponseCode()));
			}
			List<PhfiPostPartumVisitRequest> registrationData = CommonUtil.copyListBeanProperty(registrationRawData, PhfiPostPartumVisitRequest.class);
			rawMasterData.setPhfiPostPartumVisitRequest(registrationData);
			rawMasterData.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
			rawMasterData.setResponseMessage(Properties.getProperty(rawMasterData.getResponseCode()));
		} catch (Exception e) {
			logger.error("Error :: RegistrationHandlerImpl :: createRegistration method", e);
			rawMasterData.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
			rawMasterData.setResponseMessage(Properties.getProperty(PhfiErrorCodes.SYSTEM_ERROR));
		}
		logger.info("Exiting :: RegistrationHandlerImpl :: createRegistration method");

		return rawMasterData;
	}

	/**
	 * @return
	 */
	@Override
	public PhfiDeliveryFormResponse getDeliveryRawData() {
		logger.info("Entering :: RegistrationHandlerImpl :: createRegistration method");
		PhfiDeliveryFormResponse rawMasterData = new PhfiDeliveryFormResponse();
		try {
			List<Delivery> registrationRawData = reportDao.getDeliveryRawData();
			if(!StringUtil.isListNotNullNEmpty(registrationRawData)){
				rawMasterData.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
				rawMasterData.setResponseMessage(Properties.getProperty(rawMasterData.getResponseCode()));
			}
			List<PhfiDeliveryFormRequest> registrationData = CommonUtil.copyListBeanProperty(registrationRawData, PhfiDeliveryFormRequest.class);
			rawMasterData.setPhfiDeliveryFormRequest(registrationData);
			rawMasterData.setResponseCode(PhfiErrorCodes.PHFI_SUCCESS);
			rawMasterData.setResponseMessage(Properties.getProperty(rawMasterData.getResponseCode()));
		} catch (Exception e) {
			logger.error("Error :: RegistrationHandlerImpl :: createRegistration method", e);
			rawMasterData.setResponseCode(PhfiErrorCodes.SYSTEM_ERROR);
			rawMasterData.setResponseMessage(Properties.getProperty(PhfiErrorCodes.SYSTEM_ERROR));
		}
		logger.info("Exiting :: RegistrationHandlerImpl :: createRegistration method");

		return rawMasterData;
	}
	


}

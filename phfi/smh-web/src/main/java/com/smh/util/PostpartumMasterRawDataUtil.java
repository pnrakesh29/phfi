/**
 * 
 */
package com.smh.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.log4j.Logger;

import com.smh.constants.PHFIWebConstant;
import com.smh.model.PhfiPostPartumVisitRequest;

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Feb 28, 2016 12:41:04 PM
 * @version 1.0
 */
public class PostpartumMasterRawDataUtil {

	private static final Logger logger  = Logger.getLogger(PostpartumMasterRawDataUtil.class);
	/**
	 * @param phfiPostPartumVisitRequest
	 * @param response
	 */
	public static void downloadPhfiParameterXl(
			List<PhfiPostPartumVisitRequest> phfiPostPartumVisitRequest,
			HttpServletResponse response) {
		logger.info("Entering :: BeaconReportUtil :: PostpartumMasterRawDataUtil method");
		response.setContentType("application/vnd.ms-excel");
		Date date = new Date();
		String dateString = new SimpleDateFormat(PHFIWebConstant.EXPORT_FILE_NAME_DATE_FORMAT).format(date);
		String headerDate = new SimpleDateFormat(PHFIWebConstant.EXPORT_HEADER_DATE_FORMAT ).format(date);
		String filename = "Postpartum_Raw_Data_"+dateString+".xls";
		response.setHeader("Content-Disposition", "attachment;filename="
				+ filename);
		try {
			WritableWorkbook w = Workbook.createWorkbook(response.getOutputStream());
			WritableSheet s = w.createSheet(Properties.getProperty("phfi.header.postpartum.messages"), 0);
			 WritableCellFormat cellFormat = new WritableCellFormat();
			
			s.addCell(new Label(0, 0, Properties.getProperty("phfi.header.postpartum.messages")));
			s.addCell(new Label(0, 2, "Report Date: " + headerDate,cellFormat));
			s.addCell(new Label(0, 4, "WID",cellFormat));
			s.addCell(new Label(1, 4, "Name of the woman",cellFormat));
			s.addCell(new Label(2, 4, "Visit date",cellFormat));
			s.addCell(new Label(3, 4, "ALERT Symptom: Loss of consciousness",cellFormat));
			s.addCell(new Label(4, 4, "ALERT Symptom: Fits",cellFormat));
			/*s.addCell(new Label(5, 4, "ALERT Symptom: Fainting",cellFormat));*/
			/*s.addCell(new Label(6, 4, "ALERT Symptom: Profuse bleeding",cellFormat));
			s.addCell(new Label(7, 4, "ALERT Symptom: Violent behaviour; Irrelevant talk/out of touch with reality",cellFormat));*/
			s.addCell(new Label(5, 4, "Fever",cellFormat));
			s.addCell(new Label(6, 4, "If yes, is it associated with chills and shivering",cellFormat));
			s.addCell(new Label(7, 4, "If yes, does the fever come and go",cellFormat));
			s.addCell(new Label(8, 4, "Fits",cellFormat));
			s.addCell(new Label(9, 4, "Loss of consciousness",cellFormat));
			s.addCell(new Label(10, 4, "Fainting",cellFormat));
			s.addCell(new Label(11, 4, "Severe headaches ",cellFormat));
			s.addCell(new Label(12, 4, "Blurred vision",cellFormat));
			s.addCell(new Label(13, 4, "Difficulty in feeding the baby",cellFormat));
			s.addCell(new Label(14, 4, "If yes, is there pain and redness in the breast",cellFormat));
			s.addCell(new Label(15, 4, "If it is difficult, is there a painful lump in the breast",cellFormat));
			s.addCell(new Label(16, 4, "Breathlessness",cellFormat));
			s.addCell(new Label(17, 4, "If yes, when",cellFormat));
			s.addCell(new Label(18, 4, "Cough",cellFormat));
			s.addCell(new Label(19, 4, "If yes, duration of cough  ",cellFormat));
			s.addCell(new Label(20, 4, "Abdominal pain",cellFormat));
			s.addCell(new Label(21, 4, "If yes, location of pain",cellFormat));
			/*s.addCell(new Label23, 4, "Foetal movements in the past 12 hours ",cellFormat));*/
			s.addCell(new Label(22, 4, "Unpleasant smelling vaginal discharge",cellFormat));
			s.addCell(new Label(23, 4, "Current bleeding",cellFormat));
			s.addCell(new Label(24, 4, "If yes, duration of bleeding ",cellFormat));
		
			s.addCell(new Label(25, 4, "Passing of clots while bleeding",cellFormat));
			s.addCell(new Label(26, 4, "Number of cloths changed in a day",cellFormat));
			s.addCell(new Label(27, 4, "Increase in bleeding after delivery",cellFormat));
			s.addCell(new Label(28, 4, "Burning sensation or pain while urinating",cellFormat));
			s.addCell(new Label(29, 4, "Observe: Looking out of breath",cellFormat));
			s.addCell(new Label(30, 4, "Observe: Woman talking in an illogical and disconnected manner",cellFormat));
			s.addCell(new Label(31, 4, "Observe: Colour of woman's upper eyelid",cellFormat));
			s.addCell(new Label(32, 4, "Observe: Colour of woman's lower eyelid",cellFormat));
			s.addCell(new Label(33, 4, "Observe: Pedal oedama",cellFormat));
			s.addCell(new Label(34, 4, "Observe: Facial puffiness",cellFormat));
	
			s.addCell(new Label(35, 4, "Was the woman's BP measured",cellFormat));
			s.addCell(new Label(36, 4, "If yes, BP value 1",cellFormat));
			s.addCell(new Label(37, 4, "Date on which BP value 1 was measured",cellFormat));
			s.addCell(new Label(38, 4, "BP value 2",cellFormat));
			s.addCell(new Label(39, 4, "Date on which BP value 2 was measured",cellFormat));
			
			s.addCell(new Label(40, 4, "Was the woman's Hb level measured",cellFormat));
			s.addCell(new Label(41, 4, "If yes, Hb value 1",cellFormat));
			s.addCell(new Label(42, 4, "Date on which Hb value 1 was measured",cellFormat));
			s.addCell(new Label(43, 4, "Hb value 2",cellFormat));
			s.addCell(new Label(44, 4, "Date on which Hb value 2 was measured",cellFormat));
		
			s.addCell(new Label(45, 4, "Undergone a urine test",cellFormat));
			s.addCell(new Label(46, 4, "If yes, value 1 of albumin content in urine",cellFormat));
			s.addCell(new Label(47, 4, "Date on which Urine Albumin value 1 was tested",cellFormat));
			s.addCell(new Label(48, 4, "Urine Albumin value 2",cellFormat));
			s.addCell(new Label(49, 4, "Date on which Urine Albumin value 2 was tested",cellFormat));
			
			s.addCell(new Label(50, 4, "Undergone Malaria test ",cellFormat));
			s.addCell(new Label(51, 4, "If yes, result ",cellFormat));
			s.addCell(new Label(52, 4, "Test date ",cellFormat));
			s.addCell(new Label(53, 4, "Undergone Sputum test ",cellFormat));
			s.addCell(new Label(54, 4, "If yes, result ",cellFormat));
			s.addCell(new Label(55, 4, "Test date",cellFormat));
			s.addCell(new Label(56, 4, "Ask family if the woman is showing interest in caring for the baby and herself",cellFormat));
			s.addCell(new Label(57, 4, "Ask family about illogical and disconnected talk",cellFormat));
			s.addCell(new Label(58, 4, "Ask family about hallucinations",cellFormat));
			
			
			int j = 5;
			for(PhfiPostPartumVisitRequest registrationRequest : phfiPostPartumVisitRequest){
				int i=0;
				s.addCell(new Label(i++, j, ""+((registrationRequest.getWid() != null) ? registrationRequest.getWid() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getWomanName() != null) ? registrationRequest.getWomanName() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getVisitDate()!= null) ? registrationRequest.getVisitDate() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsConsciousness()!= null) ? registrationRequest.getIsConsciousness() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsFits()!= null) ? registrationRequest.getIsFits() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getHaveFever() != null) ? registrationRequest.getHaveFever(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsFeverAssocated() != null) ? registrationRequest.getIsFeverAssocated() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsFeverComeAndGo()!= null) ? registrationRequest.getIsFeverComeAndGo() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsFits() != null) ? registrationRequest.getIsFits(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsConsciousness()!= null) ? registrationRequest.getIsConsciousness() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getHaveHeadaches()!= null) ? registrationRequest.getHaveHeadaches() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getHaveBlurredVision()!= null) ? registrationRequest.getHaveBlurredVision() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsDifficultToFeed()!= null) ? registrationRequest.getIsDifficultToFeed() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getPainInBreast()!= null) ? registrationRequest.getPainInBreast() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getLumpInBreast()!= null) ? registrationRequest.getLumpInBreast() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsBurningPain()!= null) ? registrationRequest.getIsBurningPain() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsBreathless()!= null) ? registrationRequest.getIsBreathless() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getWhenBreathless() != null) ? registrationRequest.getWhenBreathless(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getHaveCough()!= null) ? registrationRequest.getHaveCough() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getHowLongHaveCough()!= null) ? registrationRequest.getHowLongHaveCough() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsAbdominalPain() != null) ? registrationRequest.getIsAbdominalPain(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getWherePain()!= null) ? registrationRequest.getWherePain() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsVaginalDischarge()!= null) ? registrationRequest.getIsVaginalDischarge() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsBleeding()!= null) ? registrationRequest.getIsBleeding() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getNoDayAfterDel() != null) ? registrationRequest.getNoDayAfterDel(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsPassClotBleeding() != null) ? registrationRequest.getIsPassClotBleeding(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getNoOfClothes() != null) ? registrationRequest.getNoOfClothes(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getHasBleedingIncrease() != null) ? registrationRequest.getHasBleedingIncrease(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsBurningPain()!= null) ? registrationRequest.getIsBurningPain() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsoutOfBreath() != null) ? registrationRequest.getIsoutOfBreath(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsTalking()!= null) ? registrationRequest.getIsTalking(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getUpperEyeColor()!= null) ? registrationRequest.getUpperEyeColor() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getLowerEyeColor() != null) ? registrationRequest.getLowerEyeColor(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsAnkleDepression()!= null) ? registrationRequest.getIsAnkleDepression() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsEyeSwelling()!= null) ? registrationRequest.getIsEyeSwelling() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getBp() != null) ? registrationRequest.getBp(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getFirstBp()!= null) ? registrationRequest.getFirstBp() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getBpDateOne() != null) ? registrationRequest.getBpDateOne(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getSecBp() != null) ? registrationRequest.getSecBp(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getBpDateSec()!= null) ? registrationRequest.getBpDateSec() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getHb() != null) ? registrationRequest.getHb(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getFirstHb()!= null) ? registrationRequest.getFirstHb() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getHbDateOne()!= null) ? registrationRequest.getHbDateOne() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getSecHb() != null) ? registrationRequest.getSecHb(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getHbDateSec()!= null) ? registrationRequest.getHbDateSec() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getUrine()!= null) ? registrationRequest.getUrine() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getFirstUrine() != null) ? registrationRequest.getFirstUrine(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getUrineDateOne() != null) ? registrationRequest.getUrineDateOne(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getSecUrine() != null) ? registrationRequest.getSecUrine(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getUrineDateSec() != null) ? registrationRequest.getUrineDateSec(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getMalaria()!= null) ? registrationRequest.getMalaria() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getFirstMalaria() != null) ? registrationRequest.getFirstMalaria(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getMalariaDateOne() != null) ? registrationRequest.getMalariaDateOne(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getSputum()!= null) ? registrationRequest.getSputum() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getSputumTest() != null) ? registrationRequest.getSputumTest(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getSputumDate() != null) ? registrationRequest.getSputumDate(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getCarringBabyAndHerself()!= null) ? registrationRequest.getCarringBabyAndHerself(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getTalkingIrrelevantly()!= null) ? registrationRequest.getTalkingIrrelevantly(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsHearingImaginary()!= null) ? registrationRequest.getIsHearingImaginary(): " ") + ""));
				j = j+1;
			}
			
			w.write();
			w.close();
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (Exception e) {
			logger.error("Error :: BeaconReportUtil :: downloadBeaconParameterXl method",e);
		}
		logger.info("Exiting :: BeaconReportUtil :: downloadBeaconParameterXl method");
	}

}

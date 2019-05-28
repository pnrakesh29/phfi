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
import com.smh.model.PhfiVisitRequest;

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Feb 28, 2016 12:40:30 PM
 * @version 1.0
 */
public class PreganancyMasterRawDataUtil {

	private static final Logger logger  = Logger.getLogger(PreganancyMasterRawDataUtil.class);

	public static void downloadPhfiParameterXl(List<PhfiVisitRequest> rawDataRequest, HttpServletResponse response){
		logger.info("Entering :: BeaconReportUtil :: downloadBeaconParameterXl method");
		response.setContentType("application/vnd.ms-excel");
		Date date = new Date();
		String dateString = new SimpleDateFormat(PHFIWebConstant.EXPORT_FILE_NAME_DATE_FORMAT).format(date);
		String headerDate = new SimpleDateFormat(PHFIWebConstant.EXPORT_HEADER_DATE_FORMAT ).format(date);
		String filename = "Pregnancy_Raw_Data_"+dateString+".xls";
		response.setHeader("Content-Disposition", "attachment;filename="
				+ filename);
		try {
			WritableWorkbook w = Workbook.createWorkbook(response.getOutputStream());
			WritableSheet s = w.createSheet(Properties.getProperty("phfi.header.pregnancy.messages"), 0);
			 WritableCellFormat cellFormat = new WritableCellFormat();
			
			s.addCell(new Label(0, 0, Properties.getProperty("phfi.header.pregnancy.messages")));
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
			s.addCell(new Label(8, 4, "Tiredness while cooking or cleaning",cellFormat));
			s.addCell(new Label(9, 4, "Fits",cellFormat));
			s.addCell(new Label(10, 4, "Loss of consciousness",cellFormat));
			s.addCell(new Label(11, 4, "Fainting",cellFormat));
			s.addCell(new Label(12, 4, "Severe headaches ",cellFormat));
			s.addCell(new Label(13, 4, "Blurred vision",cellFormat));
			s.addCell(new Label(14, 4, "Breathlessness",cellFormat));
			s.addCell(new Label(15, 4, "If yes, when",cellFormat));
			s.addCell(new Label(16, 4, "Cough",cellFormat));
			s.addCell(new Label(17, 4, "If yes, duration of cough  ",cellFormat));
			s.addCell(new Label(18, 4, "Abdominal pain",cellFormat));
			s.addCell(new Label(19, 4, "If yes, location of pain",cellFormat));
			s.addCell(new Label(20, 4, "Foetal movements in the past 12 hours ",cellFormat));
			s.addCell(new Label(21, 4, "Unpleasant smelling vaginal discharge",cellFormat));
			s.addCell(new Label(22, 4, "Current bleeding",cellFormat));
			s.addCell(new Label(23, 4, "If yes, what kind of bleeding",cellFormat));
			s.addCell(new Label(24, 4, "Broken waters ",cellFormat));
			s.addCell(new Label(25, 4, "Burning sensation or pain while urinating",cellFormat));
			s.addCell(new Label(26, 4, "Tightening of toe-rings",cellFormat));
			s.addCell(new Label(27, 4, "Difficulty in wearing bangles",cellFormat));
			s.addCell(new Label(28, 4, "Observe: Woman looking out of breath",cellFormat));
			s.addCell(new Label(29, 4, "Observe: Woman talking in an illogical and disconnected manner",cellFormat));
			s.addCell(new Label(30, 4, "Observe: Colour of woman's upper eyelid",cellFormat));
			s.addCell(new Label(31, 4, "Observe: Colour of woman's lower eyelid",cellFormat));
			s.addCell(new Label(32, 4, "Observe: Pedal oedama",cellFormat));
			s.addCell(new Label(33, 4, "Observe: Facial puffiness",cellFormat));
			s.addCell(new Label(34, 4, "Was the woman's weight measured",cellFormat));
			s.addCell(new Label(35, 4, "If yes, value 1 in kg",cellFormat));
			s.addCell(new Label(36, 4, "Date on which value 1 was measured",cellFormat));
			s.addCell(new Label(37, 4, "Weight of the woman in kg (value 2)",cellFormat));
			s.addCell(new Label(38, 4, "Date on which value 2 was measured",cellFormat));
			s.addCell(new Label(39, 4, "Weight of the woman in kg (value 3)",cellFormat));
			s.addCell(new Label(40, 4, "Date on which value 3 was measured",cellFormat));
			s.addCell(new Label(41, 4, "Weight of the woman in kg (value 4)",cellFormat));
			s.addCell(new Label(42, 4, "Date on which value 4 was measured",cellFormat));
			s.addCell(new Label(43, 4, "Was the woman's BP measured",cellFormat));
			s.addCell(new Label(44, 4, "If yes, BP value 1",cellFormat));
			s.addCell(new Label(45, 4, "Date on which BP value 1 was measured",cellFormat));
			s.addCell(new Label(46, 4, "BP value 2",cellFormat));
			s.addCell(new Label(47, 4, "Date on which BP value 2 was measured",cellFormat));
			s.addCell(new Label(48, 4, "BP value 3",cellFormat));
			s.addCell(new Label(49, 4, "Date on which BP value 3 was measured",cellFormat));
			s.addCell(new Label(50, 4, "BP value 4",cellFormat));
			s.addCell(new Label(51, 4, "Date on which BP value 4 was measured",cellFormat));
			s.addCell(new Label(52, 4, "Was the woman's Hb level measured",cellFormat));
			s.addCell(new Label(53, 4, "If yes, Hb value 1",cellFormat));
			s.addCell(new Label(54, 4, "Date on which Hb value 1 was measured",cellFormat));
			s.addCell(new Label(55, 4, "Hb value 2",cellFormat));
			s.addCell(new Label(56, 4, "Date on which Hb value 2 was measured",cellFormat));
			s.addCell(new Label(57, 4, "Hb value 3",cellFormat));
			s.addCell(new Label(58, 4, "Date on which Hb value 3 was measured",cellFormat));
			s.addCell(new Label(59, 4, "Hb value 4",cellFormat));
			s.addCell(new Label(60, 4, "Date on which Hb value 4 was measured",cellFormat));
			s.addCell(new Label(61, 4, "Undergone a urine test",cellFormat));
			s.addCell(new Label(62, 4, "If yes, value 1 of albumin content in urine",cellFormat));
			s.addCell(new Label(63, 4, "Date on which Urine Albumin value 1 was tested",cellFormat));
			s.addCell(new Label(64, 4, "Urine Albumin value 2",cellFormat));
			s.addCell(new Label(65, 4, "Date on which Urine Albumin value 2 was tested",cellFormat));
			s.addCell(new Label(66, 4, "Undergone an ultrasound scan",cellFormat));
			s.addCell(new Label(67, 4, "If yes, date of scan 1 ",cellFormat));
			s.addCell(new Label(68, 4, "Date of scan 2 ",cellFormat));
			s.addCell(new Label(69, 4, "Undergone RBS test  ",cellFormat));
			s.addCell(new Label(70, 4, "If yes, value 1 of RBS",cellFormat));
			s.addCell(new Label(71, 4, "Date on which RBS value 1 was tested",cellFormat));
			s.addCell(new Label(72, 4, "Value 2 of RBS ",cellFormat));
			s.addCell(new Label(73, 4, "Date on which RBS value 2 was tested",cellFormat));
			s.addCell(new Label(74, 4, "Undergone Malaria test ",cellFormat));
			s.addCell(new Label(75, 4, "If yes, result ",cellFormat));
			s.addCell(new Label(76, 4, "Test date ",cellFormat));
			s.addCell(new Label(77, 4, "Undergone Sputum test ",cellFormat));
			s.addCell(new Label(78, 4, "If yes, result ",cellFormat));
			s.addCell(new Label(79, 4, "Test date",cellFormat));
			s.addCell(new Label(80, 4, "Ask family about illogical and disconnected talk",cellFormat));
			
			
			int j = 5;
			for(PhfiVisitRequest registrationRequest : rawDataRequest){
				int i=0;
				s.addCell(new Label(i++, j, ""+((registrationRequest.getWid() != null) ? registrationRequest.getWid() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getWomanName() != null) ? registrationRequest.getWomanName() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getVisitDate()!= null) ? registrationRequest.getVisitDate() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsConsciousness()!= null) ? registrationRequest.getIsConsciousness() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsFits()!= null) ? registrationRequest.getIsFits() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getHaveFever() != null) ? registrationRequest.getHaveFever(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsFeverAssocated() != null) ? registrationRequest.getIsFeverAssocated() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsFeverComeAndGo()!= null) ? registrationRequest.getIsFeverComeAndGo() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsFeelTired()!= null) ? registrationRequest.getIsFeelTired() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsFits() != null) ? registrationRequest.getIsFits(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsConsciousness()!= null) ? registrationRequest.getIsConsciousness() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getFeltGiddy()!= null) ? registrationRequest.getFeltGiddy() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getHaveHeadaches()!= null) ? registrationRequest.getHaveHeadaches() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getHaveBlurredVision()!= null) ? registrationRequest.getHaveBlurredVision() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsBreathless()!= null) ? registrationRequest.getIsBreathless() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getWhenBreathless() != null) ? registrationRequest.getWhenBreathless(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getHaveCough()!= null) ? registrationRequest.getHaveCough() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getHowLongHaveCough()!= null) ? registrationRequest.getHowLongHaveCough() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsAbdominalPain() != null) ? registrationRequest.getIsAbdominalPain(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getWherePain()!= null) ? registrationRequest.getWherePain() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getBabyMove() != null) ? registrationRequest.getBabyMove(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsVaginalDischarge()!= null) ? registrationRequest.getIsVaginalDischarge() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsBleeding()!= null) ? registrationRequest.getIsBleeding() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getKindOfBleeding() != null) ? registrationRequest.getKindOfBleeding(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsWaterBroken()!= null) ? registrationRequest.getIsWaterBroken() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsBurningPain()!= null) ? registrationRequest.getIsBurningPain() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getToeRingsTighter()!= null) ? registrationRequest.getToeRingsTighter() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsBangles()!= null) ? registrationRequest.getIsBangles() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsoutOfBreath() != null) ? registrationRequest.getIsoutOfBreath(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsTalking()!= null) ? registrationRequest.getIsTalking(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getUpperEyeColor()!= null) ? registrationRequest.getUpperEyeColor() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getLowerEyeColor() != null) ? registrationRequest.getLowerEyeColor(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsAnkleDepression()!= null) ? registrationRequest.getIsAnkleDepression() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsEyeSwelling()!= null) ? registrationRequest.getIsEyeSwelling() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getWeight() != null) ? registrationRequest.getWeight(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getFirstWeight()!= null) ? registrationRequest.getFirstWeight() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getWeightDateOne()!= null) ? registrationRequest.getWeightDateOne() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getSecWeight() != null) ? registrationRequest.getSecWeight(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getWeightDateSec()!= null) ? registrationRequest.getWeightDateSec() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getThirdWeight() != null) ? registrationRequest.getThirdWeight(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getWeightDateThird() != null) ? registrationRequest.getWeightDateThird(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getFourthWeight()!= null) ? registrationRequest.getFourthWeight() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getWeightDateFour() != null) ? registrationRequest.getWeightDateFour(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getBp() != null) ? registrationRequest.getBp(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getFirstBp()!= null) ? registrationRequest.getFirstBp() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getBpDateOne() != null) ? registrationRequest.getBpDateOne(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getSecBp() != null) ? registrationRequest.getSecBp(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getBpDateSec()!= null) ? registrationRequest.getBpDateSec() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getThirdBp() != null) ? registrationRequest.getThirdBp(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getBpDateThird() != null) ? registrationRequest.getBpDateThird(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getFourBp()!= null) ? registrationRequest.getFourBp() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getBpDateFour() != null) ? registrationRequest.getBpDateFour(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getHb() != null) ? registrationRequest.getHb(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getFirstHb() != null) ? registrationRequest.getFirstHb(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getHbDateOne()!= null) ? registrationRequest.getHbDateOne() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getSecHb() != null) ? registrationRequest.getSecHb(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getHbDateSec()!= null) ? registrationRequest.getHbDateSec() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getThirdHb() != null) ? registrationRequest.getThirdHb(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getHbDateThird() != null) ? registrationRequest.getHbDateThird(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getFourHb()!= null) ? registrationRequest.getFourHb() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getHbDateFour() != null) ? registrationRequest.getHbDateFour(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getUrine()!= null) ? registrationRequest.getUrine() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getFirstUrine() != null) ? registrationRequest.getFirstUrine(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getUrineDateOne() != null) ? registrationRequest.getUrineDateOne(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getSecUrine() != null) ? registrationRequest.getSecUrine(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getUrineDateSec() != null) ? registrationRequest.getUrineDateSec(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getUltrasound()!= null) ? registrationRequest.getUltrasound() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getUltrasoundDateOne() != null) ? registrationRequest.getUltrasoundDateOne(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getUltrasoundDateSec() != null) ? registrationRequest.getUltrasoundDateSec(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getRbs()!= null) ? registrationRequest.getRbs() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getFirstRbs() != null) ? registrationRequest.getFirstRbs(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getRbsDateOne() != null) ? registrationRequest.getRbsDateOne(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getSecRbs() != null) ? registrationRequest.getSecRbs(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getRbsDateSec() != null) ? registrationRequest.getRbsDateSec(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getMalaria()!= null) ? registrationRequest.getMalaria() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getFirstMalaria() != null) ? registrationRequest.getFirstMalaria(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getMalariaDateOne() != null) ? registrationRequest.getMalariaDateOne(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getSputum()!= null) ? registrationRequest.getSputum() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getSputumTest() != null) ? registrationRequest.getSputumTest(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getSputumDate() != null) ? registrationRequest.getSputumDate(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsTalking()!= null) ? registrationRequest.getIsTalking(): " ") + ""));
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

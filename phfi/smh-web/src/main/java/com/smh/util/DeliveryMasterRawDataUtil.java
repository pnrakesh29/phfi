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
import com.smh.model.PhfiDeliveryFormRequest;

/**
 *
 * << Add Comments Here >>
 *
 * @author Shekhar Prasad
 * @date Feb 28, 2016 12:41:21 PM
 * @version 1.0
 */
public class DeliveryMasterRawDataUtil {
	private static final Logger logger  = Logger.getLogger(DeliveryMasterRawDataUtil.class);
	/**
	 * @param phfiDeliveryFormRequest
	 * @param response
	 */
	public static void downloadPhfiParameterXl(List<PhfiDeliveryFormRequest> phfiDeliveryFormRequest,HttpServletResponse response) {
		logger.info("Entering :: DeliveryMasterRawDataUtil :: downloadPhfiParameterXl method");
		response.setContentType("application/vnd.ms-excel");
		Date date = new Date();
		String dateString = new SimpleDateFormat(PHFIWebConstant.EXPORT_FILE_NAME_DATE_FORMAT).format(date);
		String headerDate = new SimpleDateFormat(PHFIWebConstant.EXPORT_HEADER_DATE_FORMAT ).format(date);
		String filename = "Delivery_Raw_Data_"+dateString+".xls";
		response.setHeader("Content-Disposition", "attachment;filename="
				+ filename);
		try {
			WritableWorkbook w = Workbook.createWorkbook(response.getOutputStream());
			WritableSheet s = w.createSheet(Properties.getProperty("phfi.header.delivery.messages"), 0);
			 WritableCellFormat cellFormat = new WritableCellFormat();
			
			s.addCell(new Label(0, 0, Properties.getProperty("phfi.header.delivery.messages")));
			s.addCell(new Label(0, 2, "Report Date: " + headerDate,cellFormat));
			s.addCell(new Label(0, 4, "WID",cellFormat));
			s.addCell(new Label(1, 4, "Name of the woman",cellFormat));
			s.addCell(new Label(2, 4, "Visit date",cellFormat));
			s.addCell(new Label(3, 4, "Date of this delivery",cellFormat));
			s.addCell(new Label(4, 4, "Duration of pregnancy",cellFormat));
			s.addCell(new Label(5, 4, "Live baby",cellFormat));
			s.addCell(new Label(6, 4, "Place of delivery",cellFormat));
			s.addCell(new Label(7, 4, "If any other, specify",cellFormat));
			s.addCell(new Label(8, 4, "Who conducted the delivery? Indicate all persons who played any role in it.",cellFormat));
			s.addCell(new Label(9, 4, "Type of delivery",cellFormat));
			s.addCell(new Label(10, 4, "Baby's birth weight in kg.",cellFormat));
			s.addCell(new Label(11, 4, "Excessive bleeding after delivery",cellFormat));
			
			int j = 5;
			for(PhfiDeliveryFormRequest registrationRequest : phfiDeliveryFormRequest){
				int i=0;
				s.addCell(new Label(i++, j, ""+((registrationRequest.getWid() != null) ? registrationRequest.getWid() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getWomanName() != null) ? registrationRequest.getWomanName() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getVisitDate()!= null) ? registrationRequest.getVisitDate() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getDeliveryDate()!= null) ? registrationRequest.getDeliveryDate() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getPregnancyLast()!= null) ? registrationRequest.getPregnancyLast() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsBabyAlive() != null) ? registrationRequest.getIsBabyAlive(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getDeliveryPlace() != null) ? registrationRequest.getDeliveryPlace() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getOtherPlace()!= null) ? registrationRequest.getOtherPlace() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getDeliveryConductedBy()!= null) ? registrationRequest.getDeliveryConductedBy() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getDeliveryType()!= null) ? registrationRequest.getDeliveryType(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getBabyWeight()!= null) ? registrationRequest.getBabyWeight() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getIsExcessiveBleeding()!= null) ? registrationRequest.getIsExcessiveBleeding() : " ") + ""));
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

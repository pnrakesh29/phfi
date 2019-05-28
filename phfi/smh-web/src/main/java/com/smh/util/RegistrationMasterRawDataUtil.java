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
import com.smh.model.PhfiRegistrationRequest;

public class RegistrationMasterRawDataUtil 
{
	private static final Logger logger  = Logger.getLogger(RegistrationMasterRawDataUtil.class);

	public static void downloadPhfiParameterXl(List<PhfiRegistrationRequest> rawDataRequest, HttpServletResponse response){
		logger.info("Entering :: BeaconReportUtil :: downloadBeaconParameterXl method");
		response.setContentType("application/vnd.ms-excel");
		Date date = new Date();
		String dateString = new SimpleDateFormat(PHFIWebConstant.EXPORT_FILE_NAME_DATE_FORMAT).format(date);
		String headerDate = new SimpleDateFormat(PHFIWebConstant.EXPORT_HEADER_DATE_FORMAT ).format(date);
		String filename = "Registration_Raw_Data_"+dateString+".xls";
		response.setHeader("Content-Disposition", "attachment;filename="
				+ filename);
		try {
			WritableWorkbook w = Workbook.createWorkbook(response.getOutputStream());
			WritableSheet s = w.createSheet(Properties.getProperty("phfi.header.registration.messages"), 0);
			 WritableCellFormat cellFormat = new WritableCellFormat();
			
			s.addCell(new Label(0, 0, Properties.getProperty("phfi.header.registration.messages")));
			s.addCell(new Label(0, 2, "Report Date: " + headerDate,cellFormat));
			s.addCell(new Label(0, 4, "WID",cellFormat));
			s.addCell(new Label(1, 4, "Village",cellFormat));
			s.addCell(new Label(2, 4, "PHC",cellFormat));
			s.addCell(new Label(3, 4, "Name of ASHA",cellFormat));
			s.addCell(new Label(4, 4, "Name of ANM",cellFormat));
			s.addCell(new Label(5, 4, "Name of ASHA facilitator",cellFormat));
			s.addCell(new Label(6, 4, "Registration date",cellFormat));
			s.addCell(new Label(7, 4, "Full name of the registered woman",cellFormat));
			s.addCell(new Label(8, 4, "Full name of her husband",cellFormat));
			s.addCell(new Label(9, 4, "Pregnancy Status",cellFormat));
			s.addCell(new Label(10, 4, "Address of marital home",cellFormat));
			s.addCell(new Label(11, 4, "Phone number",cellFormat));
			s.addCell(new Label(12, 4, "Address of natal home",cellFormat));
			s.addCell(new Label(13, 4, "Phone number",cellFormat));
			s.addCell(new Label(14, 4, "Type of current residence",cellFormat));
			s.addCell(new Label(15, 4, "If any other, specify",cellFormat));
			s.addCell(new Label(16, 4, "Age",cellFormat));
			s.addCell(new Label(17, 4, "Education",cellFormat));
			s.addCell(new Label(18, 4, "If literate, then upto which standard",cellFormat));
			s.addCell(new Label(19, 4, "Religion",cellFormat));
			s.addCell(new Label(20, 4, "If any other, specify",cellFormat));
			s.addCell(new Label(21, 4, "Caste",cellFormat));
			s.addCell(new Label(22, 4, "Caste category",cellFormat));
			s.addCell(new Label(23, 4, "Past history of diabetes",cellFormat));
			s.addCell(new Label(24, 4, "Past history of hypertension",cellFormat));
			s.addCell(new Label(25, 4, "Past history of heart disease",cellFormat));
			s.addCell(new Label(26, 4, "Past history of anaemia",cellFormat));
			s.addCell(new Label(27, 4, "Past history of thyroid problems",cellFormat));
			s.addCell(new Label(28, 4, "Past history of any other problems",cellFormat));
			s.addCell(new Label(29, 4, "If yes, specify",cellFormat));
			s.addCell(new Label(30, 4, "Number of pregnancies",cellFormat));
			s.addCell(new Label(31, 4, "Number of living children",cellFormat));
			s.addCell(new Label(32, 4, "Date of last delivery",cellFormat));
			s.addCell(new Label(33, 4, "Number of pregnancies that did not cross 7 months",cellFormat));
			s.addCell(new Label(34, 4, "Number of Caesarean operations undergone",cellFormat));
			s.addCell(new Label(35, 4, "Breathlessness in previous pregnancy ",cellFormat));
			s.addCell(new Label(36, 4, "Severe pallor in previous pregnancy",cellFormat));
			s.addCell(new Label(37, 4, "Excessive bleeding after previous delivery",cellFormat));
			s.addCell(new Label(38, 4, "LMP",cellFormat));
			s.addCell(new Label(39, 4, "Height in cm.",cellFormat));
			s.addCell(new Label(40, 4, "Blood group ",cellFormat));
			int j = 5;
			for(PhfiRegistrationRequest registrationRequest : rawDataRequest){
				int i=0;
				s.addCell(new Label(i++, j, ""+((registrationRequest.getUid() != null) ? registrationRequest.getUid() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getVillageName() != null) ? registrationRequest.getVillageName() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getPhc()!= null) ? registrationRequest.getPhc() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getAshaName()!= null) ? registrationRequest.getAshaName() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getAnmName()!= null) ? registrationRequest.getAnmName() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getAshaFacilitatorName() != null) ? registrationRequest.getAshaFacilitatorName(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getRegDate() != null) ? registrationRequest.getRegDate() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getWomenFirstName()!= null) ? registrationRequest.getWomenFirstName() +" "+registrationRequest.getWomenSurname() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getWomenHusbandName()!= null) ? registrationRequest.getWomenHusbandName() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getMaternityStatus() != null) ? registrationRequest.getMaternityStatus(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getStreetMarital()!= null) ? registrationRequest.getStreetMarital()+";"+registrationRequest.getLandmarkMarital()+";"+registrationRequest.getVillageMarital()+";"+registrationRequest.getTalukMarital()+";"+registrationRequest.getDistrictMarital() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getPhone1Marital()!= null) ? registrationRequest.getPhone1Marital() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getStreetNatal()!= null) ? registrationRequest.getStreetNatal()+";"+registrationRequest.getLandmarkNatal()+";"+registrationRequest.getVillageNatal()+";"+registrationRequest.getTalukNatal()+";"+registrationRequest.getDistrictNatal() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getPhone1Natal()!= null) ? registrationRequest.getPhone1Natal() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getOtherCurrentPlace()!= null) ? registrationRequest.getOtherCurrentPlace() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getOtherCurrentPlace() != null) ? registrationRequest.getOtherCurrentPlace(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getAge()!= null) ? registrationRequest.getAge() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getEducation()!= null) ? registrationRequest.getEducation() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getEducationOther() != null) ? registrationRequest.getEducationOther(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getReligion()!= null) ? registrationRequest.getReligion() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getOtherReligion() != null) ? registrationRequest.getOtherReligion(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getCaste()!= null) ? registrationRequest.getCaste() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getCastcategory()!= null) ? registrationRequest.getCastcategory() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getDiabetes() != null) ? registrationRequest.getDiabetes(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getHypertension()!= null) ? registrationRequest.getHypertension() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getHeartdisease()!= null) ? registrationRequest.getHeartdisease() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getAnaemia()!= null) ? registrationRequest.getAnaemia() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getThyroidproblem()!= null) ? registrationRequest.getThyroidproblem() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getAnyotherproblem() != null) ? registrationRequest.getAnyotherproblem(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getProblemDesc()!= null) ? registrationRequest.getProblemDesc(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getPregnancyCount()!= null) ? registrationRequest.getPregnancyCount() : " ") + ""));
				
				s.addCell(new Label(i++, j, ""+((registrationRequest.getNoOfChildren() != null) ? registrationRequest.getNoOfChildren(): " ") + ""));
				
				s.addCell(new Label(i++, j, ""+((registrationRequest.getDateOfRecentDelivery()!= null) ? registrationRequest.getDateOfRecentDelivery() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getEarlyDelivery()!= null) ? CommonUtil.toAmount(registrationRequest.getEarlyDelivery()) : " ") + ""));
				
				
				s.addCell(new Label(i++, j, ""+((registrationRequest.getCaesarean() != null) ? registrationRequest.getCaesarean(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getBreathlessness()!= null) ? registrationRequest.getBreathlessness() : " ") + ""));
				
				s.addCell(new Label(i++, j, ""+((registrationRequest.getSeverepallor()!= null) ? registrationRequest.getSeverepallor() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getBleedexcessively() != null) ? registrationRequest.getBleedexcessively(): " ") + ""));
				
				s.addCell(new Label(i++, j, ""+((registrationRequest.getLmp()!= null) ? registrationRequest.getLmp() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getHeight() != null) ? registrationRequest.getHeight(): " ") + ""));
				s.addCell(new Label(i++, j, ""+((registrationRequest.getBloodgroup() != null) ? registrationRequest.getBloodgroup(): " ") + ""));
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
	/*public static void downloadBeaconParameterPdf(List<BeaconRequest> beaconParameter,HttpServletResponse response) {
		response.setContentType("application/pdf");
		logger.info("Entering :: BeaconReportUtil :: downloadBeaconParameterPdf method");
		Date date = new Date();
		String dateString = new SimpleDateFormat(
				PHFIWebConstant.EXPORT_FILE_NAME_DATE_FORMAT).format(date);

		String filename = "Beacon_" + dateString + ".pdf";
		response.setHeader("Content-Disposition", "attachment;filename="
				+ filename);
		PdfPTable table = new PdfPTable(7);
		try {
			table.setWidths(new int[] {4,5,4,5,4,4,4});
			table.setTotalWidth(200);
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}

		BaseColor myColortext;
		Font myContentStyle = new Font();
		myContentStyle.setSize(10);
		myContentStyle.setStyle(Font.BOLD);
		myColortext = WebColors.getRGBColor("#FFFFFF");
		myContentStyle.setColor(myColortext);

		Font reportStyle = new Font();
		reportStyle.setSize(10);
		reportStyle.setStyle(Font.BOLD);

		Calendar calendar = Calendar.getInstance();
		PdfPCell reportdate = new PdfPCell(new Phrase("Report Date: "
				+ DateUtil.toDateStringFormat(
						new Timestamp(calendar.getTimeInMillis()),
						PHFIWebConstant.EXPORT_HEADER_DATE_FORMAT),reportStyle));
		reportdate.setColspan(12);
		reportdate.setPaddingBottom(8);
		reportdate.setPaddingTop(8);
		reportdate.setHorizontalAlignment(Element.ALIGN_RIGHT);
		reportdate.setBorder(Rectangle.NO_BORDER);
		table.addCell(reportdate);

		PdfPCell c1 = new PdfPCell(new Phrase("Beacon Name", myContentStyle));
		c1.setPadding(4);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.GRAY);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("UUID", myContentStyle));
		c1.setPadding(4);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.GRAY);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Zone Name", myContentStyle));
		c1.setPadding(4);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.GRAY);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Color", myContentStyle));
		c1.setPadding(4);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.GRAY);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("MAC Address", myContentStyle));
		c1.setPadding(4);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.GRAY);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Transmit Power", myContentStyle));
		c1.setPadding(4);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.GRAY);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Status", myContentStyle));
		c1.setPadding(4);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.GRAY);
		table.addCell(c1);
		for (BeaconRequest beaconRequest : beaconParameter) {
			int j = 1;
			table.setHeaderRows(j);
			table.addCell((beaconRequest.getBeaconName()!= null) ?beaconRequest.getBeaconName() + "" : "");
			table.addCell((beaconRequest.getUuid() != null) ? beaconRequest.getUuid()+"" : "");
			table.addCell((beaconRequest.getZoneName() != null) ? beaconRequest.getZoneName()+"" : "");
			table.addCell((beaconRequest.getColor() != null) ? beaconRequest.getColor()+"" : "");
			table.addCell((beaconRequest.getMacAddress() != null) ? beaconRequest.getMacAddress(): "");
			table.addCell((beaconRequest.getTransmitPower() != null) ? CommonUtil.toAmount(beaconRequest.getTransmitPower()) : "");
			table.addCell((beaconRequest.getStatus() != null) ? beaconRequest.getStatus(): "");

			++j;

		}
		Document document = new Document(PageSize.A3, 50, 50, 70, 70);

		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PdfWriter writer = PdfWriter.getInstance(document, baos);
			
			  TableHeader event = new TableHeader();
			  writer.setPageEvent(event); event.setFooter(Properties
			  .getProperty("chatak.footer.copyright.message"));
			 
			document.open();
			Font HeaderStyle = new Font();
			HeaderStyle.setSize(18);
			HeaderStyle.setStyle(Font.BOLD);

			Rectangle page = document.getPageSize();
			PdfPTable header = new PdfPTable(1);
			PdfPCell headercell = new PdfPCell(new Phrase(
					Properties.getProperty("chatak.header.issuer.messages"),
					HeaderStyle));
			headercell.setColspan(6);
			headercell.setBorder(Rectangle.BOTTOM);
			headercell.setHorizontalAlignment(Element.ALIGN_CENTER);
			headercell.setPaddingBottom(10);
			header.addCell(headercell);
			header.setTotalWidth(page.getWidth() - document.leftMargin()
					- document.rightMargin());

			header.writeSelectedRows(
					0,
					-1,
					document.leftMargin(),
					page.getHeight() - document.topMargin()
							+ header.getTotalHeight(),
					writer.getDirectContent());

			document.add(table);

			document.close();
			response.setHeader("Expires", "0");
			response.setHeader("Cache-Control",
					"must-revalidate, post-check=0, pre-check=0");
			response.setHeader("Pragma", "public");
			response.setContentType("application/pdf");
			response.setContentLength(baos.size());
			ServletOutputStream os = response.getOutputStream();
			baos.writeTo(os);
			os.flush();
			os.close();
			response.getOutputStream().flush();
			response.getOutputStream().close();

		} catch (DocumentException e) {
			logger.error(
					"ERROR::method1:: BeaconReportUtil :: downloadBeaconParameterPdf",
					e);
		} catch (IOException e) {
			logger.error(
					"ERROR::method2::BeaconReportUtil :: downloadBeaconParameterPdf",
					e);
		}
		logger.info("Exiting :: BeaconReportUtil :: downloadBeaconParameterPdf method");
	}*/
}

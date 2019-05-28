package com.smh.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import jxl.CellView;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.log4j.Logger;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.smh.constants.Constant;
import com.smh.model.AdminUserRequest;
import com.smh.util.DateUtil;

public class UserMgmtFileUtil {
	
	private static final Logger logger  = Logger.getLogger(UserMgmtFileUtil.class);
	
	public static void downloadUserXl(List<AdminUserRequest> adminUserRequests, HttpServletResponse response){
		logger.info("Entering :: UserMgmtFileUtil :: downloadUserXl method");
		response.setContentType("application/vnd.ms-excel");
		Date date = new Date();
		String dateString = new SimpleDateFormat(Constant.EXPORT_FILE_NAME_DATE_FORMAT).format(date);
		String headerDate = new SimpleDateFormat(Constant.EXPORT_HEADER_DATE_FORMAT).format(date);
		String filename = "User_"+dateString+".xls";
		response.setHeader("Content-Disposition", "attachment;filename="
				+ filename);
		try {
			WritableWorkbook w = Workbook.createWorkbook(response.getOutputStream());
			WritableSheet s = w.createSheet(Properties.getProperty("chatak.header.user.messages"), 0);
			WritableCellFormat cellFormat = new WritableCellFormat();
		      cellFormat.setAlignment(Alignment.JUSTIFY);
		      cellFormat.setWrap(true);
		      CellView columnAView = new CellView();
				columnAView.setSize(7000);
				s.setColumnView(0, columnAView);
				s.setColumnView(1, columnAView);
				s.setColumnView(2, columnAView);
				s.setColumnView(3, columnAView);
				s.setColumnView(4, columnAView);
				s.setColumnView(5, columnAView);
				s.setColumnView(6, columnAView);
				s.setColumnView(7, columnAView);
			s.addCell(new Label(0, 0, Properties
					.getProperty("chatak.header.user.messages")));
			s.addCell(new Label(0, 2, "Report Date: " + headerDate));
			s.addCell(new Label(0, 4, "Entity Type"));
			s.addCell(new Label(1, 4, "Role Name"));
			s.addCell(new Label(2, 4, "Username"));
			s.addCell(new Label(3, 4, "First Name"));
			s.addCell(new Label(4, 4, "Last Name"));
			s.addCell(new Label(5, 4, "Mobile"));
			s.addCell(new Label(6, 4, "Email"));
			s.addCell(new Label(7, 4, "Status"));
			
			int j = 5;
			for(AdminUserRequest adminUserRequest : adminUserRequests){
				int i=0;
				s.addCell(new Label(i++, j, ""+((adminUserRequest.getUserType() != null) ? adminUserRequest.getUserType() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((adminUserRequest.getRoleName() != null) ? adminUserRequest.getRoleName() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((adminUserRequest.getUserName() != null) ? adminUserRequest.getUserName() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((adminUserRequest.getFirstName() != null) ? adminUserRequest.getFirstName() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((adminUserRequest.getLastName() != null) ? adminUserRequest.getLastName() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((adminUserRequest.getPhone() != null) ? adminUserRequest.getPhone() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((adminUserRequest.getEmail() != null) ? adminUserRequest.getEmail() : " ") + ""));
				s.addCell(new Label(i++, j, ""+((adminUserRequest.getStatus() != null) ? adminUserRequest.getStatus() : " ") + ""));
				j = j+1;
			}
			w.write();
			w.close();
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (Exception e) {
			logger.error("Error :: UserMgmtFileUtil :: downloadUserXl method",e);
		}
		logger.info("Exiting :: UserMgmtFileUtil :: downloadUserXl method");
	}
	public static void downloadUserPdf(List<AdminUserRequest> adminUserRequests ,
			HttpServletResponse response) {
		response.setContentType("application/pdf");
		logger.info("Entering :: UserMgmtFileUtil :: downloadUserPdf method");
		Date date = new Date();
		String dateString = new SimpleDateFormat(
				Constant.EXPORT_FILE_NAME_DATE_FORMAT).format(date);

		String filename = "User_" + dateString + ".pdf";
		response.setHeader("Content-Disposition", "attachment;filename="
				+ filename);
		PdfPTable table = new PdfPTable(8);
		try {
			table.setWidths(new int[] {8,10,9,9,9,9,9,9});
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
						Constant.EXPORT_HEADER_DATE_FORMAT), reportStyle));
		reportdate.setColspan(12);
		reportdate.setPaddingBottom(8);
		reportdate.setPaddingTop(8);
		reportdate.setHorizontalAlignment(Element.ALIGN_RIGHT);
		reportdate.setBorder(Rectangle.NO_BORDER);
		table.addCell(reportdate);

		PdfPCell c1 = new PdfPCell(new Phrase("Entity Type", myContentStyle));
		c1.setPadding(5);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.GRAY);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Role Name", myContentStyle));
		c1.setPadding(5);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.GRAY);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Username", myContentStyle));
		c1.setPadding(5);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.GRAY);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("First Name", myContentStyle));
		c1.setPadding(5);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.GRAY);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Last Name", myContentStyle));
		c1.setPadding(5);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.GRAY);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Mobile", myContentStyle));
		c1.setPadding(5);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.GRAY);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Email", myContentStyle));
		c1.setPadding(5);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.GRAY);
		table.addCell(c1);
		
		c1 = new PdfPCell(new Phrase("Status", myContentStyle));
		c1.setPadding(5);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.GRAY);
		table.addCell(c1);

		for (AdminUserRequest adminUserRequest : adminUserRequests) {
			int j = 1;
			table.setHeaderRows(j);
			table.addCell((adminUserRequest.getUserType() != null) ? adminUserRequest.getUserType() + "" : "");
			table.addCell((adminUserRequest.getRoleName() != null) ? adminUserRequest.getRoleName() + "" : "");
			table.addCell((adminUserRequest.getUserName() != null) ? adminUserRequest.getUserName()+"" : "");
			table.addCell((adminUserRequest.getFirstName() != null) ? adminUserRequest.getFirstName()+"" : "");
			table.addCell((adminUserRequest.getLastName() != null) ? adminUserRequest.getLastName()+"" : "");
			table.addCell((adminUserRequest.getPhone() != null) ? adminUserRequest.getPhone()+"" : "");
			table.addCell((adminUserRequest.getEmail() != null) ? adminUserRequest.getEmail()+"" : "");
			table.addCell((adminUserRequest.getStatus() != null) ? adminUserRequest.getStatus()+"" : "");

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
					Properties.getProperty("chatak.header.user.messages"),
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
					"ERROR::method1:: UserMgmtFileUtil :: downloadUserPdf",
					e);
		} catch (IOException e) {
			logger.error(
					"ERROR::method2::UserMgmtFileUtil :: downloadUserPdf",
					e);
		}
		logger.info("Exiting :: UserMgmtFileUtil :: downloadUserPdf method");
	}

}

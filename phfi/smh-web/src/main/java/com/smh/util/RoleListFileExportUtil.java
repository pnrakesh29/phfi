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

import jxl.Workbook;
import jxl.write.Label;
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
import com.smh.constants.PHFIWebConstant;
import com.smh.model.UserRoleRequest;
import com.smh.model.UserRoles;
import com.smh.util.DateUtil;
import com.smh.util.StringUtil;

public class RoleListFileExportUtil {
	private static Logger logger = Logger.getLogger(RoleListFileExportUtil.class);
	public static void downloadRoleCsvReport(List<UserRoles> roleList,
			HttpServletResponse response) {
		try {

			Date date = new Date();
			String dateString = new SimpleDateFormat()
					.format(date);

			String filename = "Prepaid_Roles_" + dateString + ".csv";
			response.setContentType("text/csv");

			response.setHeader("Content-Disposition", "attachment;filename="
					+ filename);

			StringBuffer fw = new StringBuffer();
			fw.append("Name,");
			fw.append("Type,");
			fw.append("Availability,");
			fw.append("Status");
			fw.append('\n');
			for (UserRoles roles : roleList) {
				fw.append((!StringUtil.isNullAndEmpty(roles.getNAME() )) ? roles.getNAME() : " ");
				fw.append(',');
				fw.append((!StringUtil.isNullAndEmpty(roles.getDESCRIPTION() )) ? roles.getDESCRIPTION() : " ");
				//fw.append((!StringUtil.isNullAndEmpty(roles.getROLE_LEVEL())) ?(roles.getROLE_LEVEL().equals("MW"))?"Mea Wallet":(roles.getROLE_LEVEL().equals("SP"))?"Service Provider":"Sub Service Provider": " ");
				//fw.append(',');
				//fw.append(Utils.formatCommaSeparatedValues(StringUtil.convertString(roles.getAvailability())));
				fw.append(',');
				fw.append((!StringUtil.isNullAndEmpty(roles.getSTATUS()))? roles.getSTATUS()  : " ");
				fw.append('\n');
			}
			response.getWriter().print(fw);
		} catch (IOException e) {
			 logger.error("ERROR:: RoleListFileExportUtil::downloadRoleCsvReport ", e);
		}

	}

	public static void downloadRoleXlS(List<UserRoleRequest> roleList,
			HttpServletResponse response) {

		response.setContentType("application/vnd.ms-excel");
		Date date = new Date();
		String dateString = new SimpleDateFormat(PHFIWebConstant.EXPORT_FILE_NAME_DATE_FORMAT ).format(date);
		String headerDate = new SimpleDateFormat(PHFIWebConstant.EXPORT_HEADER_DATE_FORMAT ).format(date);
		String filename = "Chatak_Roles_" + dateString + ".xls";
		response.setHeader("Content-Disposition", "attachment;filename="
				+ filename);

		try {
			WritableWorkbook w = Workbook.createWorkbook(response
					.getOutputStream());
			WritableSheet s = w.createSheet(Properties.getProperty("chatak.header.roles.messages"),0);
			
			s.addCell(new Label(0, 0, Properties.getProperty("chatak.header.roles.messages")));
			s.addCell(new Label(0, 2, "Report Date: "+headerDate));
			s.addCell(new Label(0, 4, "Role Name"));
			s.addCell(new Label(1, 4, "Role Description"));
			s.addCell(new Label(2, 4, "Role Category"));
			
			//s.addCell(new Label(2, 0, "Availability"));
			s.addCell(new Label(3, 4, "Status"));
				

//			s.addCell(new Label(4, 0, "Status"));
			int j = 5;
			for (UserRoleRequest role : roleList) {
				int i = 0;
				s.addCell(new Label(i++, j, "" + ((role.getRoleName()!= null) ? role.getRoleName() : " ")+ ""));
				s.addCell(new Label(i++, j, "" + ((role.getDescription() != null) ? role.getDescription() : " ") + ""));
				s.addCell(new Label(i++, j, "" + ((role.getRoleType().getValue() != null) ? role.getRoleType().getValue() : " ") + ""));
				//s.addCell(new Label(i++, j, "" + ((role.getROLE_LEVEL() != null) ?(role.getROLE_LEVEL().equals("MW"))?"Mea Wallet":(role.getROLE_LEVEL().equals("SP"))?"Service Provider":"Sub Service Provider": " ") + ""));
				//s.addCell(new Label(i++, j, "" + (StringUtil.convertString(role.getAvailability())) + ""));
				s.addCell(new Label(i++, j, "" + ((role.getStatus() !=null) ?  role.getStatus() : " ") + ""));
				j = j + 1;
			}
			w.write();
			w.close();
		} catch (Exception e) {
			 logger.error("ERROR:: RoleListFileExportUtil::downloadRoleXlS ", e);
		}
	}

	public static void downloadRolePdf(List<UserRoleRequest> roleList,
			HttpServletResponse response) {

		response.setContentType("application/pdf");
		Date date = new Date();
		String dateString = new SimpleDateFormat(PHFIWebConstant.EXPORT_FILE_NAME_DATE_FORMAT ).format(date);

		String filename = "Chatak_Roles_" + dateString + ".pdf";
		response.setHeader("Content-Disposition", "attachment;filename="
				+ filename);

		PdfPTable table = new PdfPTable(4);
		try {
			table.setWidths(new int[] {5,8,4,3});
			table.setWidthPercentage(100);
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
		reportdate.setColspan(6);
		reportdate.setPaddingBottom(8);
		reportdate.setPaddingTop(8);
		reportdate.setHorizontalAlignment(Element.ALIGN_RIGHT);
		reportdate.setBorder(Rectangle.NO_BORDER);
		table.addCell(reportdate);

		PdfPCell c1 = new PdfPCell(new Phrase("Role Name", myContentStyle));
		c1.setPadding(4);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.GRAY);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Role Description ", myContentStyle));
		c1.setPadding(4);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.GRAY);
		table.addCell(c1);
		
		
		c1 = new PdfPCell(new Phrase("Role Category", myContentStyle));
		c1.setPadding(4);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.GRAY);
		table.addCell(c1);
		
		/*c1 = new PdfPCell(new Phrase("Role Level", myContentStyle));
		c1.setPadding(4);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.GRAY);
		table.addCell(c1);*/

		/*c1 = new PdfPCell(new Phrase(" Availability", myContentStyle));
		c1.setPadding(4);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.GRAY);
		table.addCell(c1);*/

		c1 = new PdfPCell(new Phrase("Status", myContentStyle));
		c1.setPadding(4);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setBackgroundColor(BaseColor.GRAY);
		table.addCell(c1);

		for (UserRoleRequest roles : roleList) {
			int j = 1;
			table.setHeaderRows(j);
			table.addCell((!StringUtil.isNullAndEmpty(roles.getRoleName())) ? roles.getRoleName(): "");
     		table.addCell((!StringUtil.isNullAndEmpty(roles.getDescription())) ? roles.getDescription() : "");
     		table.addCell((!StringUtil.isNullAndEmpty(roles.getRoleType().getValue())) ? roles.getRoleType().getValue() : "");
			//table.addCell((!StringUtil.isNullAndEmpty(roles.getROLE_LEVEL())) ?(roles.getROLE_LEVEL().equals("MW"))?"Mea Wallet":(roles.getROLE_LEVEL().equals("SP"))?"Service Provider":"Sub Service Provider": " ");
			
			
			//table.addCell(StringUtil.convertString(roles.getAvailability()));
			table.addCell((!StringUtil.isNullEmpty(roles.getStatus())) ? roles.getStatus() : "");
		
			++j;

		}

		Document document = new Document(PageSize.A3, 50, 50, 70, 70);
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PdfWriter writer = PdfWriter.getInstance(document, baos);
			TableHeader event = new TableHeader();
			writer.setPageEvent(event);
			event.setFooter(Properties.getProperty("chatak.footer.copyright.message"));

			document.open();
			Font HeaderStyle = new Font(); 
			HeaderStyle.setSize(18);
			HeaderStyle.setStyle(Font.BOLD);  

			Rectangle page = document.getPageSize();
			PdfPTable header = new PdfPTable(1);
			PdfPCell  headercell = new PdfPCell(new Phrase(Properties.getProperty("chatak.header.roles.messages"),HeaderStyle));
			
			headercell.setColspan(6);
			headercell.setBorder(Rectangle.BOTTOM);
			headercell.setHorizontalAlignment(Element.ALIGN_CENTER);
			headercell.setPaddingBottom(10);
			header.addCell(headercell);
			  
			header.setTotalWidth(page.getWidth() - document.leftMargin()  
					- document.rightMargin());  

			header.writeSelectedRows(0, -1, document.leftMargin(), page.getHeight() - document.topMargin() + header.getTotalHeight(), writer  
					.getDirectContent()); 

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

		} catch (DocumentException e) {
			logger.error("ERROR::method1:: RoleListFileExportUtil::downloadRolePdf ", e);
		} catch (IOException e) {
			logger.error("ERROR::method2:: RoleListFileExportUtil::downloadRolePdf ", e);
		}
	}
}

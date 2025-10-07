package com.ashokit.reports;

import java.io.IOException;
import java.util.List;

import com.ashokit.dao.Enquiry;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

public class PDFGenerator {

	public void generate(List<Enquiry> enquiryList, HttpServletResponse response)
			throws DocumentException, IOException {

		// Creating the Object of Document
		Document document = new Document(PageSize.A4);

		// Getting instance of PdfWriter
		PdfWriter.getInstance(document, response.getOutputStream());

		// Opening the created document to change it
		document.open();
		
		/*Image logoImage = Image.getInstance("images/ashokit.jpg");
		logoImage.scaleAbsolute(200, 60);
		logoImage.setAlignment(Element.ALIGN_CENTER);
		document.add(logoImage);*/
		

		// Creating font Setting font style and size
		Font headingFontSize = FontFactory.getFont(FontFactory.TIMES_ROMAN,18,Font.BOLD,CMYKColor.RED);
		// Creating paragraph
		Paragraph paragraph = new Paragraph("Ashok IT Enquires Information", headingFontSize);
		// Aligning the paragraph in the document
		paragraph.setAlignment(Element.ALIGN_CENTER);
		// Adding the created paragraph in the document
		document.add(paragraph);
	
		//adding two lines of spacing
		createEmptyLine(paragraph, 2);	

		// Creating a table of the 4 columns
		PdfPTable table = new PdfPTable(4);

		// Setting width of the table, its columns and spacing
		table.setWidthPercentage(100f);
		table.setWidths(new int[] {20,30,30,20});
		table.setSpacingBefore(5);

		// Creating font Setting font style and size
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(CMYKColor.WHITE);

		// Create Table Cells for the table header
		PdfPCell cell = new PdfPCell();

		// Setting the background color and padding of the table cell
		cell.setBackgroundColor(CMYKColor.RED);
		cell.setPadding(10);
		
		// Adding headings in the created table cell or header
		// Adding Cell to table
		cell.setPhrase(new Phrase("Enquiry ID", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Name", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Email-ID", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Contact No", font));
		table.addCell(cell);

		// Iterating the list of Enquires
		for (Enquiry enquiry : enquiryList) {
			// Adding Enquiry id
			table.addCell(String.valueOf(enquiry.getEnquiryId()));
			// Adding Enquiry name
			table.addCell(enquiry.getEnquiryName());
			// Adding Enquiry email
			table.addCell(enquiry.getEmailId());
			// Adding Enquiry ContactNo
			table.addCell(enquiry.getContactNo());
		}

		// Adding the created table to the document
		document.add(table);

		// Closing the document
		document.close();
	}
	
	private static void createEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
}

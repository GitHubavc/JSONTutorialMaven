package JsonPackage;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.io.IOException;

public class CreatePdf {
    static String pdfLocation="/Users/amit/IdeaProjects/JSONTutorialMaven/Data/CreatedPdfNew.pdf";
    public static void main(String[] args) throws IOException {
        //create a PDF doc
        PDDocument PdfDocument= new PDDocument();
        //create a new page
        PDPage PdfPage= new PDPage(PDRectangle.A4);
        //add this page to the doc
        PdfDocument.addPage(PdfPage);
        //Create content stream
        PDPageContentStream contentStream= new PDPageContentStream(PdfDocument,PdfPage);
        //Font and Size
        PDType1Font font= new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD);
        contentStream.setFont(font,16);

        contentStream.beginText();
        contentStream.newLineAtOffset(50,700);
        contentStream.showText("Hello PDF , This is from AMIT");
        contentStream.endText();
        contentStream.close();
        //Save PDF file
        PdfDocument.save(pdfLocation);
        PdfDocument.close();

        System.out.println("PDF CREATED SUCCESSFULLY!!!");




    }
}

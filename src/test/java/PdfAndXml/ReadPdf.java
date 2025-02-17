package PdfAndXml;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class ReadPdf {
    static String pdfPath="/Users/amit/IdeaProjects/JSONTutorialMaven/Data/sample.pdf";

    public static void main(String[] args) throws IOException {
        File pdfFile=new File(pdfPath);
        PDDocument doc=Loader.loadPDF(pdfFile);

        PDFTextStripper pdfStripper= new PDFTextStripper();
        String text=pdfStripper.getText(doc);
        doc.close();
        System.out.println(text);

    }
}

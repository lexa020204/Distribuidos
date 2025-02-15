import co.edu.upb.pdfConverter.DocPdfConverter;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> docs = Arrays.asList(
                "C:\\documents\\hojaExcel.xlsx",
                "C:\\documents\\hola.docx",
                "C:\\documents\\hola2.pptx"
        );

        String outputDir = "C:\\pdfs";
        DocPdfConverter converter = new DocPdfConverter(outputDir);

        converter.convertDocuments(docs);
        converter.printGeneratePdfs();
    }
}
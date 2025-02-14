package co.edu.upb.pdfConverter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UrlPDFConverter {

   public  List<String> convertUrlsPdf(List<String> urls)  throws IOException, InterruptedException{
       List<String> pdfPaths = new ArrayList<>();
       String chromePath = System.getenv("GOOGLE_CHROME");
       if (chromePath == null){
           throw new IllegalStateException("La variable de entorno GOOGLE_CHROME no está definida.");
       }

       for (String url : urls) {
           String outputFileName = "C:\\pdfs\\" + System.currentTimeMillis() + ".pdf";
           File outputFile = new File(outputFileName);

           ProcessBuilder processBuilder = new ProcessBuilder(
                   chromePath,
                   "--headless",
                   "--disable-gpu",
                   "--print-to-pdf=" + outputFile.getAbsolutePath(),
                   url
           );

           Process process = processBuilder.start();
           int exitCode = process.waitFor();

           if (exitCode == 0) {
               pdfPaths.add(outputFile.getAbsolutePath());
           } else {
               System.err.println("Error al convertir la URL: " + url);
           }
       }
       return pdfPaths;
   }




}

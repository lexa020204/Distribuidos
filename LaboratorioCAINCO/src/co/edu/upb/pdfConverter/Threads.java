package co.edu.upb.pdfConverter;

import java.util.List;

public class Threads {

    private final List<String> docs;

    public  Threads(List<String> docs){
        this.docs = docs;
    }

    public void star(){
        for (int i = 1 ; i<17; i++){
            long startTime = System.currentTimeMillis();
            String outputDir = "C:\\pdfs";
            DocPdfConverter converter = new DocPdfConverter(outputDir);
            converter.convertDocuments(docs, i);
            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            System.out.println("Tiempo total de ejecución: " + totalTime + " ms. Este es para  " + i + " hilos :).");
            converter.printGeneratePdfs();
        }
    }

}

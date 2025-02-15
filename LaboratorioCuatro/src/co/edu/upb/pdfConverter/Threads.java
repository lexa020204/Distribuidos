package co.edu.upb.pdfConverter;

import java.io.IOException;
import java.util.List;

public class Threads {
    private final List<URL> urls;



    public Threads(List<URL> urls ){
        this.urls = urls ;
    }

    public void star() throws IOException, InterruptedException {
        for (int i = 1; i <17; i++){
            long startTime = System.currentTimeMillis();

            UrlPDFConverter urlPDFConverter = new UrlPDFConverter();
            List<String> pdfs = urlPDFConverter.convertUrlsPdf(this.urls, i );
            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            System.out.println("Tiempo total de ejecución: " + totalTime + " ms. Este es para  " + i + " hilos :).");
            System.out.println("Archivos PDF generados:");
            pdfs.forEach(System.out::println);
        }

    }
}

package co.edu.upb.pdfConverter;

import java.io.IOException;
import java.util.List;

public class Threads {
    private final List<URL> urls;



    public Threads(List<URL> urls ){
        this.urls = urls ;
    }

    public void star() throws IOException, InterruptedException {
        UrlPDFConverter urlPDFConverter = new UrlPDFConverter();
        List<String> pdfs = urlPDFConverter.convertUrlsPdf(this.urls, 4 );
        System.out.println("Archivos PDF generados:");
        pdfs.forEach(System.out::println);
    }
}

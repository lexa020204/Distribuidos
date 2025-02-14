import co.edu.upb.pdfConverter.UrlPDFConverter;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> urls= List.of(
                "https://archiveofourown.org/works/63072403",
                "https://archiveofourown.org/works/63072385"
        );

        try{
            UrlPDFConverter converter = new UrlPDFConverter();
            List<String> resultados = converter.convertUrlsPdf(urls);
            System.out.println("Archivos PDF generados:");
            resultados.forEach(System.out::println);
        }
        catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
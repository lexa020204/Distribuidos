import co.edu.upb.pdfConverter.Threads;
import co.edu.upb.pdfConverter.URL;
import co.edu.upb.pdfConverter.URlsRepository;
import co.edu.upb.pdfConverter.UrlPDFConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       URlsRepository repo = new URlsRepository();
        List<URL> urls = repo.getURLs();
        Threads threads = new Threads(urls);
        try{
           threads.star();
        }
        catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
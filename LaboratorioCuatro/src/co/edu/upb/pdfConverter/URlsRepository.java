package co.edu.upb.pdfConverter;

import java.util.ArrayList;
import java.util.Arrays;

public class URlsRepository {
    public final ArrayList<URL> urls;


    public  URlsRepository(){
        urls = new ArrayList<>();
        configURLS();
    }

    void configURLS() {
        URL[] ur = {
                new URL("https://archiveofourown.org/works/63072403", "pdf1"),
                new URL("https://archiveofourown.org/works/63072385", "pdf2")
        };

        this.urls.addAll(Arrays.asList(ur));
    }

    public ArrayList<URL> getURLs() {
        return this.urls;
    }

}

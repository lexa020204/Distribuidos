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
                new URL("https://archiveofourown.org/works/56374246", "pdf1"),
                new URL("https://archiveofourown.org/works/58615816", "pdf2"),
                new URL("https://archiveofourown.org/works/3756754", "pdf3"),
                new URL("https://archiveofourown.org/works/5063674", "pdf4"),
                new URL("https://archiveofourown.org/works/7318987", "pdf5"),
                new URL("https://archiveofourown.org/works/13630258", "pdf6"),
                new URL("https://archiveofourown.org/works/5178790", "pdf7"),
                new URL("https://archiveofourown.org/works/9787334", "pdf8"),
                new URL("https://archiveofourown.org/works/9265507", "pdf9"),
                new URL("https://archiveofourown.org/works/11534832", "pdf10"),
                new URL("https://archiveofourown.org/works/12055221", "pdf11"),
                new URL("https://archiveofourown.org/works/3756754", "pdf12"),
                new URL("https://archiveofourown.org/works/56374246", "pdf13"),
                new URL("https://archiveofourown.org/works/58615816", "pdf14"),
                new URL("https://archiveofourown.org/works/5063674", "pdf15"),
                new URL("https://archiveofourown.org/works/7318987", "pdf16"),
                new URL("https://archiveofourown.org/works/13630258", "pdf17"),
                new URL("https://archiveofourown.org/works/5178790", "pdf18"),
                new URL("https://archiveofourown.org/works/9787334", "pdf19"),
                new URL("https://archiveofourown.org/works/9265507", "pdf20"),
                new URL("https://archiveofourown.org/works/11534832", "pdf21"),
                new URL("https://archiveofourown.org/works/12055221", "pdf22"),
                new URL("https://archiveofourown.org/works/3756754", "pdf23"),
                new URL("https://archiveofourown.org/works/56374246", "pdf24"),
                new URL("https://archiveofourown.org/works/58615816", "pdf25"),
                new URL("https://archiveofourown.org/works/5063674", "pdf26"),
                new URL("https://archiveofourown.org/works/7318987", "pdf27"),
                new URL("https://archiveofourown.org/works/13630258", "pdf28"),
                new URL("https://archiveofourown.org/works/5178790", "pdf29"),
                new URL("https://archiveofourown.org/works/9787334", "pdf30"),
                new URL("https://www.fanfiction.net/s/5063674/1/Unconventional", "pdf31"),
                new URL("https://www.fanfiction.net/s/7318987/1/There-s-a-Hole-in-the-Fabric-of-My-Reality", "pdf32"),

        };

        this.urls.addAll(Arrays.asList(ur));
    }

    public ArrayList<URL> getURLs() {
        return this.urls;
    }

}

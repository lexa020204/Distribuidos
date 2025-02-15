import co.edu.upb.pdfConverter.DocPdfConverter;
import co.edu.upb.pdfConverter.DocRepository;
import co.edu.upb.pdfConverter.Threads;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        DocRepository paths = new DocRepository();
        List<String> docs = paths.collectFilePaths("C:\\documents\\");

        Threads threads = new Threads(docs);
        threads.star();
    }
}
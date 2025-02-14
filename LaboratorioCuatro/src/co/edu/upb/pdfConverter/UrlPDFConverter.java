package co.edu.upb.pdfConverter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UrlPDFConverter {

   public  List<String> convertUrlsPdf(List<URL> urls, int numThreads)  throws IOException, InterruptedException{

       List<String> pdfPaths = Collections.synchronizedList(new ArrayList<>());
       String chromePath = System.getenv("GOOGLE_CHROME");
       if (chromePath == null){
           throw new IllegalStateException("La variable de entorno GOOGLE_CHROME no está definida.");
       }

       ExecutorService executor = Executors.newFixedThreadPool(numThreads);
       List<Future<?>> futures = new ArrayList<>();

       for (URL urlObj : urls) {
           Future<?> future = executor.submit(()->{
              try{
                  String outputFileName = "C:\\pdfs\\" + urlObj.getName() + ".pdf";
                  File outputFile = new File(outputFileName);


                  ProcessBuilder processBuilder = new ProcessBuilder(
                          chromePath,
                          "--headless",
                          "--disable-gpu",
                          "--print-to-pdf=" + outputFile.getAbsolutePath(),
                          urlObj.getUrl()
                  );

                  Process process = processBuilder.start();
                  int exitCode = process.waitFor();

                  if (exitCode == 0) {
                      pdfPaths.add(outputFile.getAbsolutePath());
                  } else {
                      System.err.println("Error al convertir la URL: " + urlObj.getUrl());
                  }
              } catch (Exception e) {
                  throw new RuntimeException(e);
              }
          });
           futures.add(future);

       }
       // Espera a que todas las tareas finalicen.
       for (Future<?> f : futures) {
           try {
               f.get();
           } catch (ExecutionException e) {
               System.err.println("Error en la ejecución: " + e.getCause().getMessage());
           }
       }

       executor.shutdown();
       return pdfPaths;
   }




}

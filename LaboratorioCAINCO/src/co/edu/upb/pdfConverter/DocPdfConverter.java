package co.edu.upb.pdfConverter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DocPdfConverter {
    private final String outputDir;
    private final List<String> pdfPaths = Collections.synchronizedList(new ArrayList<>());

    public DocPdfConverter(String outputDir) {
        this.outputDir = outputDir;
    }

    public void convertDocument(String docPath) {

        Path tempUserDir = null;
        try {
            tempUserDir = Files.createTempDirectory("LibreOffice_");
        } catch (IOException e) {
            throw new RuntimeException("Error al crear directorio temporal para LibreOffice", e);
        }
        // Convertir la ruta al formato requerido (con barras inclinadas hacia adelante)
        String userInstallationArg = "-env:UserInstallation=file:///"
                + tempUserDir.toAbsolutePath().toString().replace("\\", "/");


        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "C:\\Program Files\\LibreOffice\\program\\soffice.exe",
                    "--headless",
                    userInstallationArg,
                    "--convert-to", "pdf",
                    "--outdir", outputDir,
                    docPath
            );

            Process process = pb.start();
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                // Construir la ruta del PDF generado
                File originalFile = new File(docPath);
                String pdfFileName = originalFile.getName().replaceAll("\\.[^.]+$", ".pdf");
                String pdfFilePath = new File(outputDir, pdfFileName).getAbsolutePath();

                // Agregar la ruta del PDF a la lista
                pdfPaths.add(pdfFilePath);
            } else {
                System.err.println("Error al convertir: " + docPath);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            // Opcional: eliminar el directorio temporal creado para el perfil de LibreOffice.
            deleteDirectory(tempUserDir.toFile());
        }
    }

    public void convertDocuments(List<String> documentPaths, int threadCount) {
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        for (String docPath : documentPaths) {
            executor.submit(() ->{
                convertDocument(docPath);
            });
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.HOURS)) {
                executor.shutdownNow();
                System.err.println("No terminó en el tiempo especifico");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("La ejecución de los hilos fue interrumpida", e);
        }

    }

    public void  printGeneratePdfs(){
        System.out.println("Archivos PDF generados");
        for (String pdfPath : pdfPaths){
            System.out.println(pdfPath);
        }
    }

    private void deleteDirectory(File directory) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    deleteDirectory(file);
                }
            }
        }
        directory.delete();
    }
}

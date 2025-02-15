package co.edu.upb.pdfConverter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DocPdfConverter {
    private final String outputDir;
    List<String> pdfPaths = new ArrayList<>();

    public DocPdfConverter(String outputDir) {
        this.outputDir = outputDir;
    }

    public void convertDocument(String docPath) {
        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "C:\\Program Files\\LibreOffice\\program\\soffice.exe",
                    "--headless",
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
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void convertDocuments(List<String> documentPaths) {
        for (String docPath : documentPaths) {
            convertDocument(docPath);
        }
    }

    public void  printGeneratePdfs(){
        System.out.println("Archivos PDF generados");
        for (String pdfPath : pdfPaths){
            System.out.println(pdfPath);
        }
    }
}

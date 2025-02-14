package co.edu.upb.pdfConverter;

public class URL {
    private final String url;
    private final String name;

    public URL(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }
}

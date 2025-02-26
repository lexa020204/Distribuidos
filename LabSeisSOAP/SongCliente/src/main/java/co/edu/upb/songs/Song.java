package co.edu.upb.songs;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.io.Serializable;


@XmlRootElement(name = "song")
@XmlType(propOrder = {"title", "gender", "composer", "language", "year"})
public class Song implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;
    private String gender;
    private String composer;
    private String language;
    private int year;

    public Song() {
    }

    public Song(String title,String gender, String composer,String language, int year) {
        this.title = title;
        this.gender = gender;
        this.composer = composer;
        this.language = language;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Genre: " + gender + ", Composer: " + composer + ", Language: " + language + ", Year: " + year;
    }

    @XmlElement
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement
    public String getGender() {
        return gender;
    }

    public void setGender ( String gender) {
        this.gender = gender;
    }

    @XmlElement
    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    @XmlElement
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @XmlElement
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


}

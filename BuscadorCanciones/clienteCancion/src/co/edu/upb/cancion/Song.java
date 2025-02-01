package co.edu.upb.cancion;

import co.edu.upb.cancion.Song;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Song implements Serializable{
	 private static final long serialVersionUID = 1L;
	public String title;
	public String gender;
	public String composer;
	public String language;
	public int year;
	
	
	
	public Song(String title,
	String gender,
	String composer,
	String language,
	int year) {
		
		this.title = title;
		this.gender = gender;
		this.composer = composer;
		this.language = language;
		this.year = year;
	}
	
	public String toString() {
        return "Title: " + title + ", Genre: " + gender + ", Composer: " + composer + ", Language: " + language + ", Year: " + year;
    }

	public List<Song> getByComposer(String composer) {
		
		return null;
	}

	public List<Song> getByTitle(String tittle) {

		return null;
	}

	public List<Song> getBygender(String gender) {

		
	
		return null;
	}
}
	
	
	



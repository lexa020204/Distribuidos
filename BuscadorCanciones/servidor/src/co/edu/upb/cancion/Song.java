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
	
	private List<Song> songs = SongDatabase.getAllSongs();
	
	
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
		List<Song> result = new ArrayList<>();
		
		for (Song song : songs) {
			if (song.composer.equalsIgnoreCase(composer))
				result.add(song);
		}
		return result;
	}

	public List<Song> getByTitle(String tittle) {
		List<Song> result = new ArrayList<>();
		
		for (Song song : songs) {
			if (song.title.equalsIgnoreCase(tittle))
				result.add(song);
		}
		return result;
	}

	public List<Song> getBygender(String gender) {
List<Song> result = new ArrayList<>();
		
		for (Song song : songs) {
			if (song.gender.equalsIgnoreCase(gender))
				result.add(song);
		}
		return result;
	}
}
	
	
	



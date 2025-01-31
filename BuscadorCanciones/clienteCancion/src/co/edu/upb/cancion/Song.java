package co.edu.upb.cancion;

import java.util.List;

public class Song implements InterfaceSong{
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

	@Override
	public List<Song> getByComposer(String composer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Song> getByTitle(String Tittle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Song> getBygender(String Gender) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}

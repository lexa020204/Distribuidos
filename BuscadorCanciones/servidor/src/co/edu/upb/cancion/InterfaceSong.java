package co.edu.upb.cancion;

import java.util.List;

public interface InterfaceSong {
	
	List<Song> getByComposer(String composer);
	List<Song> getByTitle(String Tittle);
	List<Song> getBygender(String Gender); 

}

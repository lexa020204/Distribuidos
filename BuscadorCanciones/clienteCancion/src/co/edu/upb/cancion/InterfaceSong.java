package co.edu.upb.cancion;
import java.io.Serializable;

import java.util.List;

public interface InterfaceSong extends Serializable {
	
	
	List<Song> getByComposer(String composer);
	List<Song> getByTitle(String Tittle);
	List<Song> getBygender(String Gender); 

}

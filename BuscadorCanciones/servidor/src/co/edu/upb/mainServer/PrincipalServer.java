package co.edu.upb.mainServer;

import java.util.List;

import co.edu.upb.cancion.Song;

public class PrincipalServer {
	
	public static void main(String[] args) {
        
        Song song = new Song("", "", "", "", 0); 

        
        List<Song> taylorSwiftSongs = song.getByComposer("Taylor Swift");

   
        System.out.println("Canciones de Taylor Swift:");
        for (Song taylorSong : taylorSwiftSongs) {
            System.out.println(taylorSong);  // 
        }
    }

}

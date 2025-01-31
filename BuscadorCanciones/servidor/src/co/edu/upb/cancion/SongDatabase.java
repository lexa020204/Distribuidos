package co.edu.upb.cancion;

import java.util.ArrayList;
import java.util.List;

public class SongDatabase {
    
    
    private static List<Song> songDatabase = new ArrayList<>();
    
    
    static {
        songDatabase.add(new Song("Love Story", "Pop", "Taylor Swift", "English", 2008));
        songDatabase.add(new Song("You Belong with Me", "Pop", "Taylor Swift", "English", 2008));
        songDatabase.add(new Song("Cardigan", "Indie-Folk", "Taylor Swift", "English", 2020));
        songDatabase.add(new Song("Dynamite", "K-pop", "BTS", "Korean", 2020));
        songDatabase.add(new Song("Blood Sweat & Tears", "K-pop", "BTS", "Korean", 2016));
        songDatabase.add(new Song("Spring Day", "K-pop", "BTS", "Korean", 2017));
        songDatabase.add(new Song("Boy with Luv", "K-pop", "BTS", "Korean", 2019));
        songDatabase.add(new Song("Blue Hour", "K-pop", "TXT", "Korean", 2020));
        songDatabase.add(new Song("Crown", "K-pop", "TXT", "Korean", 2019));
        songDatabase.add(new Song("Hips Don't Lie", "Latin-Pop", "Shakira", "Spanish", 2006));
        songDatabase.add(new Song("Whenever, Wherever", "Pop", "Shakira", "Spanish", 2001));
        songDatabase.add(new Song("Waka Waka (This Time for Africa)", "Latin-Pop", "Shakira", "Spanish", 2010));
        songDatabase.add(new Song("Mala Fama", "Latin-pop", "Danna Paola", "Spanish", 2020));
        songDatabase.add(new Song("Stitches", "Pop", "Shawn Mendes", "English", 2015));
        songDatabase.add(new Song("Black Magic", "Pop", "Little Mix", "English", 2015));
        songDatabase.add(new Song("Te Quiero Más", "Latin-pop", "Tini", "Spanish", 2019));
        songDatabase.add(new Song("Loco", "Reggaeton", "Becky G", "Spanish", 2022));
        songDatabase.add(new Song("Blinding Lights", "Pop", "The Weeknd", "English", 2019));
        songDatabase.add(new Song("I Will Survive", "Rock", "Gloria Gaynor", "English", 1978));
        songDatabase.add(new Song("Crazy Little Thing Called Love", "Rock", "Queen", "English", 1979));
        songDatabase.add(new Song("Radio Ga Ga", "Synth Rock", "Queen", "English", 1984));
    }
    
   
    public static List<Song> getAllSongs() {
        return songDatabase;
    }

   
}

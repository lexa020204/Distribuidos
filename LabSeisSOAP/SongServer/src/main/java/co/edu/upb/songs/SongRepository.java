package co.edu.upb.songs;


import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.ArrayList;
import java.util.List;



@WebService(
        endpointInterface = "co.edu.upb.songs.InterfaceSong",
        serviceName = "SongService",
        portName = "SongPort",
        targetNamespace = "http://songs.upb.edu.co/")

public class SongRepository  implements  InterfaceSong{

    private final List<Song> songDatabase;

    public SongRepository(){
        this.songDatabase = new ArrayList<>();
        this.initDatabase();
    }

    private void initDatabase(){
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

    @Override
    @WebMethod(operationName = "getByComposer")
    public List<Song> getByComposer(String composer){
        List<Song> result = new ArrayList<>();

        for (Song song : songDatabase) {
            if (song.getComposer().equalsIgnoreCase(composer))
                result.add(song);
        }
        return result;
    }

    @Override
    @WebMethod(operationName = "getByTitle")
    public List<Song> getByTitle(String tittle) {
        List<Song> result = new ArrayList<>();

        for (Song song : songDatabase) {
            if (song.getTitle().equalsIgnoreCase(tittle))
                result.add(song);
        }
        return result;
    }

    @Override
    @WebMethod(operationName = "getByGender")
    public List<Song> getBygender(String gender) {
        List<Song> result = new ArrayList<>();

        for (Song song : songDatabase) {
            if (song.getGender().equalsIgnoreCase(gender))
                result.add(song);
        }
        return result;
    }
}

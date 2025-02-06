package co.edu.upb.song.classes;

import java.io.Serial;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RMISong extends UnicastRemoteObject implements InterfaceSong {

    private final List<Song> songDatabase;

    protected RMISong() throws RemoteException{
        this.songDatabase = new ArrayList<>();
        this.initDatabase();
    }
    @Serial
    private static final long serialVersionUID = 1L;


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
    public List<Song> getByComposer(String composer){
        List<Song> result = new ArrayList<>();

        for (Song song : songDatabase) {
            if (song.composer().equalsIgnoreCase(composer))
                result.add(song);
        }
        return result;
    }

    @Override
    public List<Song> getBygender(String gender)  {
        List<Song> result = new ArrayList<>();

        for (Song song : songDatabase) {
            if (song.gender().equalsIgnoreCase(gender))
                result.add(song);
        }
        return result;
    }

    @Override
    public List<Song> getByTitle(String tittle){
        List<Song> result = new ArrayList<>();

        for (Song song : songDatabase) {
            if (song.title().equalsIgnoreCase(tittle))
                result.add(song);
        }
        return result;
    }
}

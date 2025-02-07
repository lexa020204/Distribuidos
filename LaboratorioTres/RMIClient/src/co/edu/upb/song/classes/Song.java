package co.edu.upb.song.classes;

import java.io.Serial;
import java.io.Serializable;

public record Song(String title, String gender, String composer,
                   String language, int year) implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;

    public String toString(){
        return String.format("%s , %s ,%s, %s, %d)", title, gender, composer,  language, year);
    }
}


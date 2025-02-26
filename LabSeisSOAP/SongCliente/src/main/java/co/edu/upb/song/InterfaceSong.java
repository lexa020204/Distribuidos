package co.edu.upb.song;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService(targetNamespace = "http://song.upb.edu.co/", name = "InterfaceSong")
public interface InterfaceSong {
    @WebMethod
    List<Song> getByComposer(String composer);

    @WebMethod
    List<Song> getByTitle(String Tittle);

    @WebMethod
    List<Song> getBygender(String Gender);

}

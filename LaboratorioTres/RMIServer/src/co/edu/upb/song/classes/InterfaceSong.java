package co.edu.upb.song.classes;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface InterfaceSong  extends Remote {
    List<Song> getByComposer(String composer)  throws RemoteException;
    List<Song> getByTitle(String Tittle)  throws RemoteException;
    List<Song> getBygender(String Gender)  throws RemoteException;

}

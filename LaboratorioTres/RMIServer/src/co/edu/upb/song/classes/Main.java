package co.edu.upb.song.classes;

import java.rmi.RemoteException;

public class Main {

    public static void main(String[] args) throws RemoteException{
        RMIServer server = new RMIServer(1802);
        server.searchSong();
    }
}
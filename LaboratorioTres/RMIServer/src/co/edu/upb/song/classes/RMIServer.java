package co.edu.upb.song.classes;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.List;

public class RMIServer {

    private int port;

    public RMIServer(int port){
        this.port = port;
    }

    public void searchSong(){
        try{
            RMISong service = new RMISong();
            LocateRegistry.createRegistry(1802);
            try{
                Naming.rebind("//127.0.0.1:1802/service", service);
                System.out.println("Servidor corriendo ..........");

            } catch (RemoteException | MalformedURLException e) {
               e.printStackTrace();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void setPort(int port){
        this.port = port;
    }
}

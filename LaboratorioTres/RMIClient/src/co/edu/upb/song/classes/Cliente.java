package co.edu.upb.song.classes;

public class Cliente {
    RMIClient rmi;

    public Cliente(){
        rmi = new RMIClient();
    }

    public void request(){
        rmi.buscador();
    }
}

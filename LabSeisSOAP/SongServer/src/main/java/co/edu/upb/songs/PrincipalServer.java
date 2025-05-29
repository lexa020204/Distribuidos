package co.edu.upb.songs;

public class Principal {

    public static void main(String[] args) {


        SongRepository songRepository = new SongRepository();
        SOAPServer SOAP = new SOAPServer(songRepository);
        SOAP.run();
        System.out.println("Server running");


    }
}

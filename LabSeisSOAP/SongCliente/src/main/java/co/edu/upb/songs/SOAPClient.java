package co.edu.upb.songs;

import jakarta.xml.ws.Service;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class SOAPClient {
    String busqueda;
    String opc;
    public Scanner sc;
    private InterfaceSong service;

    public SOAPClient() throws MalformedURLException{
        this.sc = new Scanner(System.in);
        this.setup();
    }
    public void setup() throws MalformedURLException {

        URL wsdlURL = new URL("http://localhost:80/song?wsdl");

        QName servQName = new QName("http://songs.upb.edu.co/", "SongService");
        QName portQName = new QName("http://songs.upb.edu.co/", "SongPort");

        Service soapService = Service.create(wsdlURL, servQName);
        service = soapService.getPort(portQName, InterfaceSong.class);
    }

    public void buscador(){
        try{

            System.out.println("\n[Cliente]: Escoge una opción");
            System.out.println("1. Nombre");
            System.out.println("2. Género");
            System.out.println("3. Autor");
            opc = sc.nextLine();

            List<Song> response = null;
            switch (opc){
                case "1":
                    System.out.print("Ingrese el título a buscar: ");
                    busqueda = sc.nextLine();
                    response = service.getByTitle(busqueda);
                    break;
                case "2":
                    System.out.print("Ingrese el genero a buscar: ");
                    busqueda = sc.nextLine();
                    response = service.getBygender(busqueda);
                    break;
                case "3":
                    System.out.print("Ingrese el Autor a buscar: ");
                    busqueda = sc.nextLine();
                    response = service.getByComposer(busqueda);
                    break;
                default:
                    System.out.println("Opción no válida");
            }

            if (response != null){
                System.out.println("\n [Client]: Las canciones son las siguientes: \n");
                for (Song song : response) {
                    System.out.println(song.toString());
                }
            }
            else {
                System.out.println("\n [Client]: No se encontraron canciones: \n");
            }



        }
        catch (Exception  e){
            e.printStackTrace();
        }
    }
}

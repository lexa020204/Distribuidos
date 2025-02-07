package co.edu.upb.song.classes;


import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClient{
    String busqueda;
    String opc;
    public Scanner sc;
    private final String addressName;

    public RMIClient(){
        this.sc = new Scanner(System.in);
        this.addressName = "//127.0.0.1:1802/service";


    }

    public void buscador(){
        try{
            InterfaceSong service = (InterfaceSong) Naming.lookup(this.addressName);

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
        catch (MalformedURLException | RemoteException | NotBoundException e){
                e.printStackTrace();
        }
    }
}

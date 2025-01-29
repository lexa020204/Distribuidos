package co.edu.up.classesclient;

import java.util.Scanner;

public class Client {
    
    String opt;
    String message;
    JSocketClient sk;
    public Scanner sc;

    public Client(String address, int port) {
        sk = new JSocketClient(address, port);    
        sc = new Scanner(System.in);
    }

    public void message() {
        while (true) {
            // Muestra el menú siempre antes de pedir la opción
            System.out.println("\n[Cliente]: Escoge una opción");
            System.out.println("1. Enviar mensaje");
            System.out.println("2. Cerrar conexión");

            opt = sc.nextLine(); // Leer opción

            if (opt.equals("1")) {
                System.out.println("Ingrese un mensaje para enviar:");
                message = sc.nextLine();
                sk.request(message); // Enviar mensaje
            } else if (opt.equals("2")) {
                System.out.println("\n[Cliente]: Cerrando conexión...");
                sk.closeService(); 
                break; // Salir del bucle
            } else {
                System.out.println("[Cliente]: Opción no válida. Intente de nuevo.");
            }
        }
        sc.close(); // Cerrar Scanner una vez fuera del bucle
    }
}

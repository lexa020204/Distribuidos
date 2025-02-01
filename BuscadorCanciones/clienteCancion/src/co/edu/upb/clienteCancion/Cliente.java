package co.edu.upb.clienteCancion;


import java.util.Scanner;

public class Cliente {
	
	
	String busqueda;
	int opc;
	String message;
	public Scanner sc;
	 JSocketClient sk;
	private String[] opciones = {"", "Nombre", "Género", "Autor"};
	
	public Cliente(String address, int port) {
	     sc = new Scanner(System.in);
	     sk= new JSocketClient(address, port);
	}
	
	public void buscador() {
		while(true) {
			System.out.println("\n[Cliente]: Escoge una opción");
			 System.out.println("1. Nombre");
	         System.out.println("2. Género");
	         System.out.println("3. Autor");
	         System.out.println("4. Salir");
	         
	         opc = sc.nextInt();
	         sc.nextLine();
	         
	         if(opc >= 1 && opc<= 3 ) {
	        	 System.out.println("Ingrese el " + opciones[opc] + " para buscar la canción");
	        	 busqueda = sc.nextLine();
	        	 System.out.println(opc + busqueda);
	        	 sk.request(opc + busqueda);
	         }else if (opc == 4) {
	        	 System.out.println("Saliendo del programa...");
	        	 break;
	         }
	         else {
	        	 System.out.println("Opción no válida. Intente de nuevo.");
	         }
		}
			
		}
		
		 
	

}

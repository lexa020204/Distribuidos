package co.edu.upb.mainCliente;
import co.edu.upb.clienteCancion.Cliente;

public class Principal {
	
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente("127.0.0.1", 60);
        
        
    	cliente.buscador();
    }
	

	
	

}

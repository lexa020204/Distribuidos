package co.edu.upb.clienteCancion;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class JSocketClient {
	
	private InetAddress address;
	private int port;
	private Socket clientSk;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;

	public JSocketClient(String address, int port) {
		try {
			this.port = port;
			this.address = InetAddress.getByName(address);
			this.oos = null;
			this.ois = null;
		} catch (UnknownHostException e) {
			System.err.println("[Client]: Error - Dirección desconocida: " + e.getMessage());
		}
	}
	
	   public void request(String query) {
	        try {
	          
	            if(this.clientSk == null || this.clientSk.isClosed()) {
	                this.clientSk = new Socket(this.address, this.port);
	                this.oos = new ObjectOutputStream(this.clientSk.getOutputStream());
	                this.oos.flush();
	                this.ois = new ObjectInputStream(this.clientSk.getInputStream());
	                System.out.println("\n [Client]: Conexión exitosa.");
	            }

	           
	            send(query);

	            // Recibimos la respuesta del servidor
	            try {
	                String response = (String) this.ois.readObject();
	                if (response == null) {
	                    System.out.println("\n [Client]: El servidor cerró la conexión.");
	                    closeService();
	                } else {
	                	
	                    System.out.println("\n [Client]: Las canciones son las siguientes: \n" + response);
	                }
	            } catch (Exception e) {
	                System.out.println("\n [Client]: El servidor cerró la conexión.");
	            }
	        } catch (IOException e) {
	            System.err.println("[Client]: Error en la comunicación: " + e.getMessage());
	            closeService();
	        }
	    }
	   
	   private void send(String data) {
	        try {
	            this.oos.writeObject("[Client]: Buscando canción: " + data);
	            this.oos.flush();
	        } catch (Exception e) {
	            System.out.println("\n [Client]: No se puede enviar la data.");
	        }
	    }
	   
	   public void closeService() {
	        try {
	            if (this.ois != null) this.ois.close();
	            if (this.oos != null) this.oos.close();
	            if (this.clientSk != null) this.clientSk.close();
	        } catch (Exception e) {
	            System.out.println("\n [Client]: No se puede cerrar la conexión.");
	        }
	    }
	

}

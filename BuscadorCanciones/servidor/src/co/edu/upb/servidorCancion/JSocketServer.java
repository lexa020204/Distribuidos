package co.edu.upb.servidorCancion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.List;

import co.edu.upb.cancion.Song;

public class JSocketServer {

	private int port;
	private ServerSocket serverSk;
	private Socket clientSk;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	
	Song songs = new Song("", "", "", "", 0);
 

	public JSocketServer(int port) {
		this.port = port;
		try {
			this.serverSk = new ServerSocket(port, 100);
			System.out.println("[Server]: Servidor corriendo ... ");
			
		} catch (IOException e) {
			 System.err.println("[Server]: Error al iniciar el servidor: " + e.getMessage());
		}
	}
	
	
	public void listening() {
		
		while(true) {
			try {

				System.out.println("\n [Server]: " + "Esperando.");
				this.clientSk = this.serverSk.accept();
				System.out.println("\n [Server]: " + "Conexión exitosa.");
				
				
				this.oos = new ObjectOutputStream(this.clientSk.getOutputStream());
				this.oos.flush();
				this.ois = new ObjectInputStream(this.clientSk.getInputStream());
				
				
					try {
						String data = (String) ois.readObject();	
						
						if (data == null) {
							System.out.println("\n[Server]: Cliente desconectado.");
	                        closeService();
	                        break;
						} else {
							char parametro = data.charAt(0);
							String query = data.substring(1);
							
							
							if (parametro =='1' ) {
								
								System.out.println("Esta por Nombre");
								List<Song> respuesta = this.songs.getByTitle(query);
								send(respuesta);
							
							}else if (parametro == '2') {
								System.out.println("genero");
								List<Song> respuesta = this.songs.getBygender(query);
								
								send(respuesta);
								
							}
							else if (parametro == '3') {
								System.out.println("autor");
								List<Song> respuesta = this.songs.getByComposer(query);
								send(respuesta);
								
							}
							
						}
						
						
					} catch (Exception e) {
						System.out.println("\n [Server]: No se puede recibir la data.");
					      closeService();
		                    break; 
					}
				}
			 catch (IOException e) {
				 System.err.println("[Server]: Error en la conexión: " + e.getMessage());
			}
			
		}
		
	}
	 private void closeService() {
	        try {
	            if (ois != null) ois.close();
	            if (oos != null) oos.close();
	            if (clientSk != null) clientSk.close();
	            if (serverSk != null) serverSk.close();  
	            System.out.println("[Server]: Conexión terminada. Servidor cerrado.");
	        } catch (IOException e) {
	            System.err.println("[Server]: Error al cerrar la conexión: " + e.getMessage());
	        }
	    }

	
	
	private void send(List<Song> data) {
		try {
			if (this.oos != null) {
				if(data.isEmpty()) {
					this.oos.writeObject("[Server]: No se encontraron canciones :(");
				} 
				else {
					this.oos.writeObject(data);
				}
                this.oos.flush();
            }
			
		} catch (Exception e) {
			System.out.println("\n [Server]: No se puede enviar la data.");
		}
	}
	
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}

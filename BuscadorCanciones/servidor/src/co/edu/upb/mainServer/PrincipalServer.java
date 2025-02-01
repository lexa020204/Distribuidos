package co.edu.upb.mainServer;

import co.edu.upb.servidorCancion.Server;

public class PrincipalServer {
	
	public static void main(String[] args) {
		Server server = new Server(60);
		server.run();
	}

}



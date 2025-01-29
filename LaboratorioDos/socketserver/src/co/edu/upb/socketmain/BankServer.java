package co.edu.upb.socketmain;

import co.edu.upb.socketserver.Server;

public class BankServer {
	
	public static void main(String[] args) {
		Server server = new Server(60);
		server.run();
	}

}

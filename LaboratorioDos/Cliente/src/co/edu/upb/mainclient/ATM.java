package co.edu.upb.mainclient;

import co.edu.up.classesclient.Client;

public class ATM {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Client client = new Client("127.0.0.1", 60);
		client.opetation("msn");
	}

}

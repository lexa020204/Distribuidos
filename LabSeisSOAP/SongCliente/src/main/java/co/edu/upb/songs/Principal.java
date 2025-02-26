package co.edu.upb.songs;


import java.net.MalformedURLException;

public class Principal {
    public static void main(String[] args) {


        SOAPClient soapClient;
        try {
            soapClient = new SOAPClient();
            soapClient.buscador();


        }catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}

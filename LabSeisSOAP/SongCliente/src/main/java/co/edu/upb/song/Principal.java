package co.edu.upb.song;


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

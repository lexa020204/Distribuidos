package co.edu.upb.songs;

import jakarta.xml.ws.Endpoint;

public class SOAPServer {
    private final InterfaceSong service;

    public SOAPServer(InterfaceSong service) {
        this.service = service;
    }

    public void run() {
        try {
            Endpoint.publish("http://localhost:80/song", service);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


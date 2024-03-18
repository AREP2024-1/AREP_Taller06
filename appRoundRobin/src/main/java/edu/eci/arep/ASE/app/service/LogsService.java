package edu.eci.arep.ASE.app.service;

import java.util.Collection;
import java.util.List;

import edu.eci.arep.ASE.app.apiExternal.HttpClient;

public class LogsService {

    private String url;
    private int port;
    private HttpClient httpClient;

    public LogsService(String url, int port, HttpClient httpClient) {
        this.url = url;
        this.port = port;
        this.httpClient = httpClient;
    }

    public LogsService(String url, int port) {
        this.url = url;
        this.port = port;
        this.httpClient = new HttpClient();
    }

    public Collection<String> invokerLogs(String cadena) {
        String dataPort = String.format("Port: %d->dataPort: %s", port, cadena);
        String llamado = httpClient.call(url, dataPort);
        return List.of(llamado);
    }
    
}

package edu.eci.arep.ASE.app.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppRoundRobin {

    private List<LogsService> logsServices;
    private int index;

    public AppRoundRobin(int cantLogsServices, int port) {
        index = 0;
        logsServices = new ArrayList<>();
        for (int i = 0; i < cantLogsServices; i++) {
            String url = "http://localhost:" + (port + i) + "/logService";
            
            logsServices.add(new LogsService(url, port + i));
        }

    }

    public AppRoundRobin(){
        this(3, 10000);
    }

    public Collection<String> invokerLogs(String cadena){
        var logs = logsServices.get(index).invokerLogs(cadena);
        this.index = (this.index + 1) % logsServices.size();
        return logs;
    }


    
}

package edu.eci.arep.ASE.app.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


import edu.eci.arep.ASE.app.persistence.GestionLogs;

public class LogsService {

    private GestionLogs gestionLogs;

    public LogsService(GestionLogs gestionLogs){
        this.gestionLogs = gestionLogs;
    }

    public void save(String id){
        LocalDateTime fechayHoraActual = LocalDateTime.now();
        String idRegistro = fechayHoraActual.format(DateTimeFormatter.ISO_DATE_TIME);
        String log =  String.format("%s:%s", idRegistro, id);
        gestionLogs.save(idRegistro, log);
    }

    public Collection<String> getLatest(){
        Collection<String> allLogs = gestionLogs.searchAll();
        Collection<String> lastTen = new ArrayList<>();

        int total = allLogs.size();
        int cont = 0;

        Iterator<String> iterador = allLogs.iterator();

        while(iterador.hasNext()){
            String cadena = iterador.next();

            if (cont >= total - 10) {
                lastTen.add(cadena);
            }

            cont++;
        }

        return lastTen;
    }
    
}

package edu.eci.arep.ASE.app;

import edu.eci.arep.ASE.app.controller.MyController;
import edu.eci.arep.ASE.app.controller.MySparkController;
import edu.eci.arep.ASE.app.persistence.GestionLogs;
import edu.eci.arep.ASE.app.service.LogsService;

public class Main {

    public static void main(String[] args) {
        GestionLogs gestionLogs = GestionLogs.instanciaLogsDAO("logs", "baseDatosLogs");
        LogsService logsService = new LogsService(gestionLogs);
        MyController myController = new MySparkController(logsService);
        myController.inicializar();
    }
    
}

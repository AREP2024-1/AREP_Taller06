package edu.eci.arep.ASE.app;

import edu.eci.arep.ASE.app.controller.MyController;
import edu.eci.arep.ASE.app.controller.MySparkController;
import edu.eci.arep.ASE.app.service.AppRoundRobin;

public class Main {

    public static void main(String[] args) {
        AppRoundRobin appRoundRobin = new AppRoundRobin(3,5000);
        MyController myController = new MySparkController(appRoundRobin);
        myController.inicializar();
    }
    
}

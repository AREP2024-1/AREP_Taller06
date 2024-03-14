package edu.eci.arep.ASE.app;

import edu.eci.arep.ASE.app.controller.MyController;
import edu.eci.arep.ASE.app.controller.MySparkController;
import edu.eci.arep.ASE.app.service.AppRoundRobin;
import static spark.Spark.staticFileLocation;

public class Main {

    public static void main(String[] args) {
        staticFileLocation("/public");
        AppRoundRobin appRoundRobin = new AppRoundRobin(3,5000);
        MyController myController = new MySparkController(appRoundRobin);
        myController.inicializar();
    }
    
}

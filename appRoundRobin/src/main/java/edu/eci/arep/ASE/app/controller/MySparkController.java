package edu.eci.arep.ASE.app.controller;

import static spark.Spark.port;
import static spark.Spark.get;
import edu.eci.arep.ASE.app.service.AppRoundRobin;



public class MySparkController implements MyController{

    private AppRoundRobin appRoundRobin;

    public MySparkController(AppRoundRobin appRoundRobin){
        this.appRoundRobin = appRoundRobin;
    }

    @Override
    public void inicializar() {
        port(80);
        get("/logService", (req, res)->{
            String cad = req.queryParams("cad");
            return appRoundRobin.invokerLogs(cad);
        });
    }
    
}

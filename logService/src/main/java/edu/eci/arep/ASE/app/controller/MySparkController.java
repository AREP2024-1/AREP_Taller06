package edu.eci.arep.ASE.app.controller;

import static spark.Spark.port;
import static spark.Spark.get;

import edu.eci.arep.ASE.app.service.LogsService;

public class MySparkController implements MyController {

    private LogsService logsService;

    public MySparkController(LogsService logsService){
        this.logsService = logsService;
    }

    @Override
    public void inicializar(){
        port(5000);
        get("/logService", (req, res)->{
            String cad = req.queryParams("cad");
            logsService.save(cad);
            return logsService.getLatest();
        });  
    }
    
}

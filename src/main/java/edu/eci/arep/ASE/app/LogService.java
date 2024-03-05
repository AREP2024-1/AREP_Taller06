package edu.eci.arep.ASE.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.staticFiles;

public class LogService {
    public void main(String... args){
        port(5000);
        get("logServiceFacade", (req,res)->{
            res.type("application/json");
            return "{\"logid1\":\"20-2-2024-Log inicial\"}";
        });
    }
    
}

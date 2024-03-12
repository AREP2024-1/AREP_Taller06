package edu.eci.arep.ASE.app.persistence;

import java.util.ArrayList;
import java.util.Collection;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;

public class GestionLogs implements CRUDOperations<String, String>{

    private MongoCollection<Document> logsMongo;
    
    public static GestionLogs instanciaLogsDAO(String nombreColletion, String nombreDB){
        MongoDatabase baseDatos = MongoUtil.getDB(nombreDB);
        GestionLogs logs = new GestionLogs(nombreColletion, baseDatos);
        return logs;
    }

    public GestionLogs(String nombreCollection, MongoDatabase baseDatos){
        this.logsMongo = baseDatos.getCollection(nombreCollection);
    }

    @Override
    public void save(String id, String log){
        Document addLog = new Document("_id", id).append("log", log);
        logsMongo.insertOne(addLog);
    }

    @Override
    public String search(String id){
        return logsMongo.find(eq("_id", id)).toString();
    }

    @Override
    public Collection<String> searchAll(){
        return logsMongo.find()
                .map(doc -> doc.toJson())
                .into(new ArrayList<String>());
    }

    @Override
    public void delete(String id){
        logsMongo.deleteOne(eq("_id"));
    }
    
    
}

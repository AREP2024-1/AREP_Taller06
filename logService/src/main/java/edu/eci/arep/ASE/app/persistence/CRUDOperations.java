package edu.eci.arep.ASE.app.persistence;

import java.util.Collection;

public interface CRUDOperations<D,I> {

    void save(I id, D infoLog);
    D search(I id);
    Collection<D> searchAll();
    void delete(I id);   
}

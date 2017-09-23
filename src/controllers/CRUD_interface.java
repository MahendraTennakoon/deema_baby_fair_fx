package controllers;

import javafx.collections.ObservableList;

/**
 *
 * @author Mahendra Tennakoon
 */
public interface CRUD_interface {
    
    /**
     * retrieve all data associated with a model from database.
     */
    public ObservableList getAllData();
}

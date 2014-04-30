package control.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by franco on 27/04/2014.
 */
public interface GenericDAO< T, ID extends Serializable> {

    T findByID(ID id,boolean lock);
    List <T> findAll();
    List <T> findByExample(T exampleInstance);
    T makePersistence(T entity);
    void makeTransient(T entity);
    void delete(ID id);

}

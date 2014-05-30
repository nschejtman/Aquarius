package control.dao;

import control.HibernateUtil;
import model.Type;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by franco on 09/05/2014.
 */
public class TypeDAO {

    public static boolean addType(Type type){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        boolean ret = false;
        try {
            tx = session.beginTransaction();
            session.persist(type);
            tx.commit();
            ret = true;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ret;
    }

    public static List<Type> getAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (List<Type>) session.createCriteria(Type.class).list();
    }
}

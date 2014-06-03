package control.dao;

import control.HibernateUtil;
import model.Type;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class TypeDAO {

    public static boolean addType(Type type) {
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


}

package control.dao;

import control.HibernateUtil;
import model.Tag;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by franco on 09/05/2014.
 */
public  class TagDAO {


    public static boolean addTag(Tag tag){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        boolean ret = false;
        try {
            tx = session.beginTransaction();
            session.persist(tag);
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

    public static Tag getTag(long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Object tag = null;
        try {
            tx = session.beginTransaction();
            tag = session.get(Tag.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return (Tag) tag;
    }

}

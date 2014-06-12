package control.dao;

import control.HibernateUtil;
import model.Image;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class ImageDAO {


    public static void addImage(Image image) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(image);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public static Image getImage(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Object image = null;
        try {
            tx = session.beginTransaction();
            image = session.get(Image.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return (Image) image;
    }
}

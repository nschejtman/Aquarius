package control.dao;

import com.sun.istack.internal.NotNull;
import control.HibernateUtil;
import model.Tag;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

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

    public static List<Tag> getAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (List<Tag>) session.createCriteria(Tag.class).list();
    }

    public static Tag getSingleTag(@NotNull String tag) throws IllegalAccessError {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Object user = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Tag.class);
            criteria.add(Restrictions.eq("tag", tag));
            List list = criteria.list();
            if (list.size()>0 && list.get(0) != null) user = list.get(0);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return (Tag) user;
    }

}

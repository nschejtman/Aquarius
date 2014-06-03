package control.dao;

import com.sun.istack.internal.NotNull;
import control.HibernateUtil;
import model.Type;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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

    public static Type getType(long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Object tag = null;
        try {
            tx = session.beginTransaction();
            tag = session.get(Type.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return (Type) tag;
    }

    public static Type getType(@NotNull String type) throws IllegalAccessError {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Object user = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Type.class);
            criteria.add(Restrictions.eq("name", type));
            List list = criteria.list();
            if (list.size()>0 && list.get(0) != null) user = list.get(0);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return (Type) user;

    }
}

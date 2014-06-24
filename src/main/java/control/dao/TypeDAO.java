package control.dao;

import control.HibernateUtil;
import model.Type;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

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

    public static Type getType(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Object type = null;
        try{
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Type.class);
            criteria.add(Restrictions.eq("name",name));
            List list = criteria.list();
            if(list != null) type = list.get(0);
            tx.commit();
        } catch (HibernateException e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return (Type) type;
    }

    public static Type getType(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Object type = null;
        try {
            tx = session.beginTransaction();
            type = session.get(Type.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return (Type) type;
    }

    public static List<Type> getAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Type.class);
        return  (List<Type>)criteria.list();
    }


}

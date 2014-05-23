package control.dao;

import com.sun.istack.internal.NotNull;
import control.HibernateUtil;
import model.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class UserDAO {

    public static boolean addUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        boolean ret = false;
        try {
            tx = session.beginTransaction();
            user.setActive(true);
            session.persist(user);
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

    public static User getUser(long id) throws IllegalAccessException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Object user = null;
        try {
            tx = session.beginTransaction();
            user = session.get(User.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return (User) user;
    }

    public static User getUser(@NotNull String username) throws IllegalAccessError {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Object user = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("userName", username));
            List list = criteria.list();
            if (list.size()>0 && list.get(0) != null) user = list.get(0);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return (User) user;

    }

    public static void deleteUser(long id) throws IllegalAccessException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            User user = getUser(id);
            if (user == null) return;
            session.delete(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void deleteUser(@NotNull User user) throws IllegalAccessException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}

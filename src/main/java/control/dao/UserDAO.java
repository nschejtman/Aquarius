package control.dao;

import control.HibernateUtil;
import model.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAO extends DataAO {

    private static UserDAO ourInstance = new UserDAO();

    private UserDAO() {}

    public static UserDAO getInstance() {
        return ourInstance;
    }

    public static void addUser(User user) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(user);
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public User getUser(Session session, String user) {
        super.beginTransaction(session);
        String hql = "from User U where U.userName = :user ";
        Query query = session.createQuery(hql);
        query.setParameter("user", user);
        super.endTransaction(session);
        return (User) query.uniqueResult();
    }

}

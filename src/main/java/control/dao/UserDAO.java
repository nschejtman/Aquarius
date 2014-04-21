package control.dao;

import model.User;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Created by franco on 14/04/2014.
 */
public class UserDAO extends DataAO{

    private static UserDAO ourInstance = new UserDAO();

    private UserDAO() {
    }

    public static UserDAO getInstance() {
        return ourInstance;
    }


    public User getUser(Session session, String user) {
        super.beginTransaction(session);
        Query query = session.createQuery("select user from User user where user.email= :yourUser");
        query.setParameter("yourUser", user);
        super.endTransaction(session);
        return (User) query.uniqueResult();
    }

    public void addUser(Session session, User user) {
        super.beginTransaction(session);
        session.save(user);
        super.endTransaction(session);
    }
}

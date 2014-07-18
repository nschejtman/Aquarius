package control.dao;

import com.sun.istack.internal.NotNull;
import control.HibernateUtil;
import model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class UserDAO extends DataDAO {

    private static UserDAO ourInstance = new UserDAO();

    private UserDAO() {
    }

    public static UserDAO getInstance() {
        return ourInstance;
    }

    public void addUser(User user) {
        Session session = HibernateUtil.getGuestSession();
        beginTransaction(session);
        session.persist(user);
        endTransaction();
    }

    public User getUser(long id) {
        Session session = HibernateUtil.getGuestSession();
        beginTransaction(session);
        User user = (User) session.get(User.class, id);
        endTransaction();
        return user;
    }

    public User getUser(@NotNull String username) {
        Session session = HibernateUtil.getGuestSession();
        beginTransaction(session);
        User user = null;
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("userName", username));
        List list = criteria.list();
        endTransaction();
        if (list.size() > 0 && list.get(0) != null) user = (User) list.get(0);
        return user;

    }

    public void deleteUser(long id) {
        Session session = HibernateUtil.getGuestSession();
        beginTransaction(session);
        User user = getUser(id);
        if (user == null) return;
        session.delete(user);
        endTransaction();
    }

    public void deleteUser(@NotNull User user) {
        Session session = HibernateUtil.getGuestSession();
        beginTransaction(session);
        session.delete(user);
        endTransaction();
    }

    public void updateUser(@NotNull User user) {
        Session session = HibernateUtil.getGuestSession();
        beginTransaction(session);
        session.persist(user);
        endTransaction();
    }


}

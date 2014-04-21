package control;

import model.User;
import control.dao.UserDAO;
import org.hibernate.Session;
import org.securityfilter.realm.SimpleSecurityRealmBase;

/**
 * Created by franco on 16/04/2014.
 */
public class LoginRealm extends SimpleSecurityRealmBase {

    public boolean booleanAuthenticate(String username, String password) {
        Session session = HibernateUtil.getGuestSession();
        User user = UserDAO.getInstance().getUser(session, username);
        return user.getPassword().equals(password);
    }
}
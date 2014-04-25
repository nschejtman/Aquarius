package control;

import control.dao.UserDAO;
import model.User;
import org.securityfilter.realm.SimpleSecurityRealmBase;

/**
 * Created by franco on 16/04/2014.
 */
public class LoginRealm extends SimpleSecurityRealmBase {

    public boolean booleanAuthenticate(String username, String password) {
        User user = UserDAO.getUser(username);
        return user.getPassword().equals(password);
    }
}

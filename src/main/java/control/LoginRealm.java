package control;

import control.dao.UserDAO;
import org.securityfilter.realm.SimpleSecurityRealmBase;

/**
 * Created by franco on 16/04/2014.
 */
public class LoginRealm extends SimpleSecurityRealmBase {

    public boolean booleanAuthenticate(String username, String password) {
        //Checks if instance exists previously + analyse if password is correct
        return UserDAO.getInstance().exists(username)&&UserDAO.getInstance().getUser(username).getPassword().equals(password);
    }
}

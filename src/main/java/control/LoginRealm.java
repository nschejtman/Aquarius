package control;

import control.dao.UserDAO;
import model.User;
import org.securityfilter.realm.SimpleSecurityRealmBase;

public class LoginRealm extends SimpleSecurityRealmBase {

    public boolean booleanAuthenticate(String username, String password) {
        //Checks if instance exists previously + analyse if password is correct
        User user = UserDAO.getInstance().getUser(username);
        if (user == null) return false;
        else return user.getPassword().equals(password);
    }

    public boolean isUserInRole(String username, String role) {
        return true;
    }
}

package servlets;

/**
 * main.java.servlets.Constants - constants for the example applications to facilitate testing
 *
 * @author Max Cooper (max@maxcooper.com)
 * @version $Revision: 1.5 $ $Date: 2004/01/26 10:55:37 $
 */
public interface Constants {

    // shared constants
    public static final String COMMON_TITLE_BASE = "Aquarius";
    // home page constants
    public static final String HOME_TITLE = COMMON_TITLE_BASE + " Home";
    public static final String VALID_USERNAME = "user@example.com";
    public static final String VALID_PASSWORD = "password";
    public static final String LOGIN_FORM_ID = "loginForm";
    public static final String REGISTER_FORM_ID = "registerForm";
    public static final String LOGIN_FORM_ACTION = "j_security_check";
    public static final String LOGIN_USERNAME_FIELD = "j_username";
    public static final String LOGIN_PASSWORD_FIELD = "j_password";
    public static final String REGISTER_USERNAME_FIELD = "r_username";
    public static final String REGISTER_PASSWORD_FIELD = "r_password";
    public static final String LOG_IN = "Log In";
    public static final String REGISTER = "Sign In";
    // project list progress bars
    public static final String SUCCESS_BAR = "progress-bar progress-bar-success animate-progress-bar";
    public static final String DANGER_BAR = "progress-bar progress-bar-danger animate-progress-bar";
    public static final String WARNING_BAR = "progress-bar progress-bar-warning animate-progress-bar";
    public static final String PRIMARY_BAR = "progress-bar progress-bar-primary animate-progress-bar";
}

package servlets;

import control.LoginRealm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;


public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user = req.getParameter(Constants.LOGIN_USERNAME_FIELD);
        String pass = req.getParameter(Constants.LOGIN_PASSWORD_FIELD);
        LoginRealm realm = new LoginRealm();
        if (realm.booleanAuthenticate(user, pass)) {
            resp.sendRedirect(resp.encodeRedirectURL("/secured.jsp"));
        } else
            resp.sendRedirect("/login.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/login.jsp");
    }


}

package servlets.user_action;

import control.LoginRealm;
import servlets.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {processRequest(req,resp);}

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String user = req.getParameter(Constants.LOGIN_USERNAME_FIELD);
        String pass = req.getParameter(Constants.LOGIN_PASSWORD_FIELD);
        LoginRealm realm = new LoginRealm();
        if (realm.booleanAuthenticate(user, pass)) {
            resp.sendRedirect(resp.encodeRedirectURL("/secured.jsp"));
        } else
            resp.sendRedirect("/login.jsp");
    }
}

package servlets.user_action;

import control.dao.UserDAO;
import model.User;
import servlets.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Register", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        resp.sendRedirect("/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter(Constants.REGISTER_USERNAME_FIELD);
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String email = req.getParameter("email");
        String password = req.getParameter(Constants.REGISTER_PASSWORD_FIELD);

        User user = new User(firstName, lastName, null, username, email, password);
        if(UserDAO.getInstance().exists(username))UserDAO.getInstance().addUser(user);
    }
}

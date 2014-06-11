package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        resp.sendRedirect("/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstname = req.getParameter("reg_firstname");
        String lastname = req.getParameter("reg_lastname");
        String username = req.getParameter("reg_username");
        String email = req.getParameter("reg_email");
        String password = req.getParameter("reg_password");
        String birthdate = req.getParameter("reg_birthdate");
        Date date = Date.valueOf(birthdate);
//        User user = new User(firstname, lastname, System.currentTimeMillis(), username, email, password);
//        UserDAO.addUser(user);
        //TODO apendearle el nuevo user a la session para que lo deje pasar el security filter


    }
}

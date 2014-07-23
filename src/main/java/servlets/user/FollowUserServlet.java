package servlets.user;

import control.dao.UserDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FollowUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final User follower = UserDAO.getInstance().getUser(req.getUserPrincipal().getName());
        final User follwee = UserDAO.getInstance().getUser(req.getParameter("profilingId"));
        follwee.addFollower(follower);
        UserDAO.getInstance().save(follwee);
    }
}

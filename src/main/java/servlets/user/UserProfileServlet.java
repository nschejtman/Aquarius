package servlets.user;

import control.dao.ProjectDAO;
import control.dao.UserDAO;
import model.Notification;
import model.Project;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by franco on 03/07/2014.
 */
@WebServlet(name = "UserProfileServlet", urlPatterns = "/secured/profile")
public class UserProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get the user id from the url
        Long id = Long.parseLong(req.getParameter("id"));
        User user = UserDAO.getInstance().getUser(id);

        //Get the User first 3 project from fund's raised stand point
        List<Project> projects = ProjectDAO.getInstance().getTopProjectsByUser(user);

        //Get top following projects
//        List<Project> following = ProjectDAO.getInstance().getTopProjectsUserIsFollowing(user);

        //Get Notifications
        List<Notification> notifications = (List<Notification>)user.getNotifications();

        //Forward request to the project_view.jsp
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/secured/profile.jsp");
        req.setAttribute("profiling", user);
        req.setAttribute("projects", projects);
//        req.setAttribute("following", following);
        req.setAttribute("notifications", notifications);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Methods for editing profile. ONLY WHEN loggedIn = profiling

        // Add button to follow/unfollow. Commands to view projects
    }
}

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

@WebServlet(name = "UserProfileServlet", urlPatterns = "/secured/profile")
public class UserProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get the user id from the url
        User user = UserDAO.getInstance().getUser(req.getRemoteUser());

        //Get the User first 3 project from fund's raised stand point
        List<Project> projects = getTopOwned(user);

        //Get top following projects
        List<Project> following = getTopFollowed(user);

        // Get Follower's numbers
        int followed = UserDAO.getInstance().getFollowedUsers(user).size();

        //Get Notifications
        List<Notification> notifications = (List<Notification>) user.getNotifications();

        //Forward request to the project_view.jsp
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/secured/profile.jsp");
        req.setAttribute("profiling", user);
        req.setAttribute("projects", projects);
        req.setAttribute("followed", followed);
        req.setAttribute("following", following);
        req.setAttribute("notifications", notifications);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Methods for editing profile. ONLY WHEN loggedIn = profiling

        // Add button to follow/unfollow. Commands to view projects
    }

    public static List<Project> getTopOwned(User user) {
        List<Project> projects = ProjectDAO.getInstance().getProjectsByUser(user);
        if (projects.size() > 2) return projects.subList(0, 3);
        return projects;
    }

    public static List<Project> getTopFollowed(User user) {
        List<Project> projects = ProjectDAO.getInstance().getFollowedProjects(user);
        if (projects.size() > 2) return projects.subList(0, 3);
        return projects;
    }
}

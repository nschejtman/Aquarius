package servlets.user;

import control.dao.UserDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by franco on 03/07/2014.
 */
@WebServlet(name = "UserProfileServlet", urlPatterns = "/secured/profile")
public class UserProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //In user profile pages there are 2 attributes for Users: loggedIn and profiling. The latter being the one under analysis
        User profiling = UserDAO.getUser(req.getAttribute("profiling").toString());

        //Show user information: name, userName, reputation, profile pic

        //Display a projectList of top 5 projects from funds raised standpoint

        //Same for users following

        //Counters and Grids with followers and following

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Methods for editing profile. ONLY WHEN loggedIn = profiling

        // Add button to follow/unfollow. Commands to view projects
    }
}

package servlets.project;

import control.dao.ProjectDAO;
import control.dao.UserDAO;
import model.Project;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class ViewProjectListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = UserDAO.getInstance().getUser(req.getRemoteUser());
        List<Project> projects = ProjectDAO.getInstance().getProjectsByUser(user);
        //checking if projects load
        req.setAttribute("projects", projects);
        req.getRequestDispatcher("/secured/projectlist.jsp").forward(req, resp);
    }
}

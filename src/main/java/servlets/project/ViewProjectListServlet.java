package servlets.project;

import control.dao.ProjectDAO;
import control.dao.UserDAO;
import model.Project;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletContext;

/**
 * Created by franco on 10/05/2014.
 */
@WebServlet(name = "ViewProjectList", urlPatterns = "/secured/projectlist")
public class ViewProjectListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = UserDAO.getUser(req.getRemoteUser());
        List<Project> projects = ProjectDAO.getProjectsByUser(user) ;
        //checking if projects load
        if(projects.get(0)== null) {
            req.setAttribute("projects", projects);
            req.getRequestDispatcher("/secured/projectlist.jsp").forward(req, resp);
        } else resp.sendRedirect("/secured/index.jsp");
    }
}

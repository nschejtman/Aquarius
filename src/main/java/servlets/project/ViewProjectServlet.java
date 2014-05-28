package servlets.project;

import control.dao.ProjectDAO;
import model.Project;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by franco on 21/05/2014.
 */
@WebServlet(name = "ViewProject", urlPatterns = "/secured/project")
public class ViewProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long projectID = (long) req.getAttribute("projectID");
        Project project = ProjectDAO.getProject(projectID);
        if(project == null) //do something

        req.setAttribute("project",project);
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/secured/project.jsp?projectID=" + projectID );
        rd.forward(req, resp);
    }
}

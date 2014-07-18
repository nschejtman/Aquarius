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
 * Created by franco on 14/05/2014.
 */
@WebServlet(name = "GoToProject", urlPatterns = "/goto")
public class GoToProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long projectID = Long.parseLong(req.getAttribute("projectID").toString());
        Project project = ProjectDAO.getInstance().getProject(projectID);
        req.setAttribute("project", project);
        req.setAttribute("filterByGoTo", true);
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/index.jsp");
        rd.forward(req, resp);
    }
}

package servlets.user;

import control.dao.ProjectDAO;
import model.Project;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by franco on 20/05/2014.
 */
@WebServlet(name = "CloseProjectServlet", urlPatterns = "/close")
public class CloseProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long projectID = Long.parseLong(req.getAttribute("projectID").toString());
        Project project = ProjectDAO.getInstance().getProject(projectID);
//        project.setActive(false);
        ProjectDAO.getInstance().addProject(project);
        resp.sendRedirect("/aquarius/goTo?goto&projectID=" + project.getId());
    }
}

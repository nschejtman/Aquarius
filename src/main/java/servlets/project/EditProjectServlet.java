package servlets.project;

import control.dao.ProjectDAO;
import model.Project;
import model.Tag;
import model.Type;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by franco on 13/05/2014.
 */
@WebServlet(name = "EditProject", urlPatterns = "/editproject")
public class EditProjectServlet extends HttpServlet {
    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long projectID = (long) req.getAttribute("projectID");
        String projectName = req.getParameter("projectName");
        String description = req.getParameter("description");
        String[] strTags = req.getParameter("tags").split(";");
        String type = req.getParameter("type");
        Project project = ProjectDAO.getProject(projectID);
        project.setName(projectName);
        project.setDescription(description);
        project.setType(new Type(type));
        for (String strTag : strTags) {
            Tag tag = new Tag(strTag);
            project.addTags(tag);
        }

        ProjectDAO.addProject(project);
        resp.sendRedirect("/index");



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long projectID = (long) req.getAttribute("projectID");

        System.out.println(projectID);

        Project project = ProjectDAO.getProject(projectID);
        if(project == null) //do something
        req.setAttribute("project",project);
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/secured/editproject.jsp?projectID=" + projectID);
        rd.forward(req, resp);

    }
}

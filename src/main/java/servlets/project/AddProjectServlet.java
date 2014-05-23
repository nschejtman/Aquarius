package servlets.project;

import control.dao.ProjectDAO;
import control.dao.TagDAO;
import control.dao.TypeDAO;
import control.dao.UserDAO;
import model.Project;
import model.Tag;
import model.Type;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by franco on 30/04/2014.
 */

@WebServlet(name = "AddProject", urlPatterns = "/secured/addproject")
public class AddProjectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Project project = new Project();
        project.setName(req.getParameter("projectName"));
        project.setUser(UserDAO.getUser(req.getRemoteUser()));

        project.setDescription(req.getParameter("description"));
        String[] strTags = req.getParameter("tags").split(";");
        for (String strTag : strTags) {
            Tag tag = new Tag(strTag);
            TagDAO.addType(tag);
            project.addTags(tag);
        }
//        project.setStart(Date.valueOf(req.getParameter("startDate")));
//        project.setEnd(Date.valueOf(req.getParameter("endDate")));
        Type type = new Type(req.getParameter("type"));
        project.setType(type);
        TypeDAO.addType(type);
        ProjectDAO.addProject(project);
    }
}

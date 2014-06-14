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
import java.sql.Date;
import java.util.List;

/**
 * Created by franco on 30/04/2014.
 */

@WebServlet(name = "AddProject", urlPatterns = "/secured/addproject")
public class AddProjectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Type> types = TypeDAO.getAll();
        if(types.size() > 0){
            req.setAttribute("types", types);
            req.getRequestDispatcher("/secured/addproject.jsp").forward(req,resp);
        } else resp.sendRedirect("/secured/index.jsp");

        List<Tag> tags = TagDAO.getAll();
        if(tags.size() > 0){
            req.setAttribute("tagList", tags);
            req.getRequestDispatcher("/secured/addproject.jsp").forward(req,resp);
        } else resp.sendRedirect("/secured/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Project project = new Project();
        project.setUser(UserDAO.getUser(req.getRemoteUser()));
        project.setName(req.getParameter("projectName"));
        project.setObjective(Integer.parseInt(req.getParameter("objective")));
        Type type = TypeDAO.getType(req.getParameter("type"));
        project.setType(type);
        project.setDescription(req.getParameter("description"));
        String[] strTags = req.getParameter("source-tags").split(",");
        for (String strTag : strTags) {
            Tag tag = new Tag(strTag);
            TagDAO.addTag(tag);
            project.addTags(tag);
        }
        project.setStart(Date.valueOf(req.getParameter("startDate")));
        project.setEnd(Date.valueOf(req.getParameter("endDate")));

        ProjectDAO.addProject(project);
    }
}

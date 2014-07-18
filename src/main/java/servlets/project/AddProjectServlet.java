package servlets.project;

import control.dao.ProjectDAO;
import control.dao.TagDAO;
import control.dao.TypeDAO;
import control.dao.UserDAO;
import model.Project;
import model.Tag;
import model.Type;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

        List<Tag> tags = TagDAO.getInstance().getAll();
        if(tags.size() > 0){
            req.setAttribute("tagList", tags);
            req.getRequestDispatcher("/secured/addproject.jsp").forward(req,resp);
        } else resp.sendRedirect("/secured/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = UserDAO.getInstance().getUser(req.getRemoteUser());
        String name = req.getParameter("projectName");
        int objective = Integer.parseInt(req.getParameter("objective"));
        Type type = TypeDAO.getInstance().getType(req.getParameter("type"));
        String description = req.getParameter("description");
        String html = req.getParameter("html");
        String[] strTags = req.getParameter("source-tags").split(",");
        Project project = ProjectDAO.makeProject(new Project(), name, description, objective, html, type, user, strTags);
//        project.setStart((req.getParameter("startDate")).);
//        project.setEnd(Date.valueOf(req.getParameter("endDate")));

        ProjectDAO.getInstance().addProject(project);
        resp.sendRedirect("/secured/project?id=" + project.getId());
    }
}

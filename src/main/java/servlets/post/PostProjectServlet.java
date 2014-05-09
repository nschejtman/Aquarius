package servlets.post;

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

@WebServlet(name = "PostProject", urlPatterns = "/post_project")
public class PostProjectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Project project = new Project();
        project.setName(req.getParameter("projectName"));
        project.setUser(UserDAO.getInstance().getUser(req.getUserPrincipal().getName()));
        project.setDescription(req.getParameter("description"));
        String[] strTags = req.getParameter("tags").split(";");
        for (String strTag : strTags) {
            Tag tag = new Tag(strTag);
            TagDAO.getInstance().addType(tag);
            project.addTags(tag);
        }
//        project.setStart(Date.valueOf(req.getParameter("startDate")));
//        project.setEnd(Date.valueOf(req.getParameter("endDate")));
        Type type = new Type(req.getParameter("type"));
        TypeDAO.getInstance().addTag(type);
        project.setType(type);



        System.out.println("Result: " + ProjectDAO.addProject(project));

    }
}

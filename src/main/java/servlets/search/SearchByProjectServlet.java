package servlets.search;

import control.dao.ProjectDAO;
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
@WebServlet(name = "Search", urlPatterns = "/search")
public class SearchByProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    protected  void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Project project = new Project();
        project.setName(req.getParameter("projectName"));
        project.setUser(UserDAO.getUser(req.getParameter("userName")));
        String[] strTags = req.getParameter("tags").split(";");
        for (String strTag : strTags) {
            Tag tag = new Tag(strTag);
            project.addTags(tag);
        }
//        project.setStart(Date.valueOf(req.getParameter("startDate")));
//        project.setEnd(Date.valueOf(req.getParameter("endDate")));
        Type type = new Type(req.getParameter("type"));
        project.setType(type);

        ProjectDAO.getProjectList(project);
        resp.sendRedirect("/index");
    }
}

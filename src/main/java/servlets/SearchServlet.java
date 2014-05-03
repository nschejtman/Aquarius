package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by franco on 30/04/2014.
 */
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    protected  void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//        //set parameters
//        String projectName = req.getParameter("projectName");
//        String description = req.getParameter("description");
//        Type type = new Type(req.getParameter("type"));
//        User user = new User(req.getParameter("userName"));
////        User collaborator = new User(req.getParameter("collaborator"));
////        Collection<User> collaborators = (Collection<User>) collaborator;
////        Tag tag = new Tag(req.getParameter("tag"));
////        Collection<Tag> tags = (Collection<Tag>) tag;
//        //Apply search
//        Project project = new Project(projectName,description,null,null,type,user);
//        ProjectDAO.getProjectList(project);

    }
}

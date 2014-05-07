package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by franco on 30/04/2014.
 */
public class SaveProjectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        System.out.println(req.getUserPrincipal());
//        Project project = new Project();
//        project.setName(req.getParameter("projectName"));
//
//        project.setDescription(req.getParameter("description"));
//        project.setStart(Date.valueOf(req.getParameter("startDate")));
//        project.setEnd(Date.valueOf(req.getParameter("endDate")));
//        project.setTypeByName(req.getParameter("type"));
//
//        System.out.println("Result: " + ProjectDAO.addProject(project));

    }
}

package servlets.search;

import control.dao.SearchDAO;
import model.Project;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
@WebServlet(name = "Search", urlPatterns = "/secured/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String criteria = req.getParameter("criteria");
        ServletContext context = getServletContext();
        if (criteria != null) {
            List<Project> matchingProjects = SearchDAO.searchResultSet(criteria);
            List<User> matchingUsers = SearchDAO.searchUser(criteria);
            req.setAttribute("user", matchingUsers);
            req.setAttribute("projects", matchingProjects);
            RequestDispatcher rd = context.getRequestDispatcher("/secured/searchresults.jsp");
            rd.forward(req, resp);
        } else {
            List<Project> matchingProjects = SearchDAO.searchProject(req.getParameter("projectName"), req.getParameter("description"), req.getParameter("userName"));
            req.setAttribute("projects", matchingProjects);
            RequestDispatcher rd = context.getRequestDispatcher("/secured/searchresults.jsp");
            rd.forward(req, resp);
        }
    }
}

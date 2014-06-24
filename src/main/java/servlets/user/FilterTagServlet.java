package servlets.user;

import control.dao.TagDAO;
import model.Tag;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by franco on 21/05/2014.
 */
@WebServlet(name = "FilterTagServlet", urlPatterns = "/filtertag")
public class FilterTagServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long tagId = (long) req.getAttribute("tagID");
        Tag tag = TagDAO.getTag(tagId);
        req.setAttribute("tag", tag);
//        req.setAttribute("projectByTag", tag.getProjects());
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/index.jsp");
        rd.forward(req, resp);
    }
}

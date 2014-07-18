package servlets.project;

import control.dao.ProjectDAO;
import model.Project;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditProject", urlPatterns = "/editproject")
public class EditProjectServlet extends HttpServlet {
    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get the project id from the url
        Long id = Long.parseLong(req.getParameter("id"));
        Project project = ProjectDAO.getInstance().getProject(id);

        //If the user is owner redirect to edition view else redirect to not authorized page
        if (project.getUser().getUserName().equals(req.getUserPrincipal().getName())) {
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/secured/editproject.jsp");
            req.setAttribute("project", project);
            requestDispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("secured/index.jsp");
        }
    }
}

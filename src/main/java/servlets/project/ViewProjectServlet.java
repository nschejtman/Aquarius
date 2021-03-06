package servlets.project;

import control.dao.ProjectDAO;
import control.dao.UserDAO;
import model.Project;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ViewProjectServlet", urlPatterns = "/secured/project")
public class ViewProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get the project id from the url
        Long id = Long.parseLong(req.getParameter("id"));
        Project project = ProjectDAO.getInstance().getProject(id);

        //Forward request to the project_view.jsp
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/secured/project_view.jsp");
        req.setAttribute("project", project);
        req.setAttribute("aquser", UserDAO.getInstance().getUser(req.getUserPrincipal().getName()));
        requestDispatcher.forward(req, resp);
    }
       //comment loco
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

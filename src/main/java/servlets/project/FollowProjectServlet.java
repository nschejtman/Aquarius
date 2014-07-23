package servlets.project;

import control.dao.ProjectDAO;
import control.dao.UserDAO;
import model.Project;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FollowProjectServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = UserDAO.getInstance().getUser(req.getUserPrincipal().getName());
        Project project = ProjectDAO.getInstance().getProject(Integer.parseInt(req.getParameter("projectId")));
        project.addFollower(user);
        ProjectDAO.getInstance().saveProject(project);
    }
}

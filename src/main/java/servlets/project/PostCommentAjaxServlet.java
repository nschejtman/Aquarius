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

public class PostCommentAjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pId = Integer.parseInt(req.getParameter("projectId"));
        Project project = ProjectDAO.getInstance().getProject(pId);
        String comment = req.getParameter("comment");
        User user = UserDAO.getInstance().getUser(req.getRemoteUser());
        project.addComment(comment, user, System.currentTimeMillis());
        ProjectDAO.getInstance().saveProject(project);
    }
}

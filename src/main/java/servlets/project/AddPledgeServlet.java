package servlets.project;

import control.dao.FundDAO;
import control.dao.ProjectDAO;
import control.dao.UserDAO;
import model.Fund;
import model.Project;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddPledgeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Project project = ProjectDAO.getInstance().getProject(Integer.parseInt(req.getParameter("projectId")));
        User user = UserDAO.getInstance().getUser(req.getUserPrincipal().getName());
        int amount = Integer.parseInt(req.getParameter("pledge"));
        Fund fund = new Fund(amount, user, project);
        project.addFund(fund);
        user.addFund(fund);
        FundDAO.getInstance().saveFund(fund);
        ProjectDAO.getInstance().saveProject(project);
        UserDAO.getInstance().addUser(user);
    }
}

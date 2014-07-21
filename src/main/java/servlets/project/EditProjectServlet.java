package servlets.project;

import control.dao.ProjectDAO;
import control.dao.TypeDAO;
import model.Project;
import model.Tag;
import model.Type;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "EditProject", urlPatterns = "/secured/editproject")
public class EditProjectServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get the project id from the url
        Long id = Long.parseLong(req.getParameter("id"));
        Project project = ProjectDAO.getInstance().getProject(id);
        //Get all parameters
        String name = req.getParameter("projectName");
        int objective = Integer.parseInt(req.getParameter("objective"));
        Type type = TypeDAO.getInstance().getType(req.getParameter("type"));
        String description = req.getParameter("description");
        String html = req.getParameter("html");
        String[] strTags = req.getParameter("source-tags").split(",");

        Project edited = ProjectDAO.makeProject(project, name, description, objective, html, type, project.getUser(), strTags);
        try {
            edited.setEnd(setDate(req));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        edited.setStart(System.currentTimeMillis());
        ProjectDAO.getInstance().addProject(edited);
        resp.sendRedirect("/secured/project?id=" + project.getId());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get the project id from the url
        Long id = Long.parseLong(req.getParameter("id"));
        Project project = ProjectDAO.getInstance().getProject(id);
        //Tags for editing
        String tags = setTags((List<Tag>) project.getTags());
        //Type
        List<Type> types = setType();
        //End Date
        String dueDate = getDate(project);

        //If the user is owner redirect to edition view else redirect to not authorized page
        if (project.getUser().getUserName().equals(req.getUserPrincipal().getName())) {
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/secured/editproject.jsp");
            req.setAttribute("project", project);
            req.setAttribute("tags", tags);
            req.setAttribute("dueDate", dueDate);
            if(types.size() > 0) req.setAttribute("types",types);
            requestDispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("secured/index.jsp");
        }
    }

    public static String setTags(List<Tag> tags){
        String result = "";
        for (Tag tag: tags){
            result += tag.getName() + ",";
        }
        return result;
    }

    public static List<Type> setType(){return TypeDAO.getAll();}

    public static long setDate(HttpServletRequest request) throws ParseException {
        String date = request.getParameter("endDate");
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date1 = sdf.parse(date);
        return date1.getTime();
    }

    public static String getDate(Project project){
        return new SimpleDateFormat("MM/dd/yyyy").format(project.getEnd());
    }
}

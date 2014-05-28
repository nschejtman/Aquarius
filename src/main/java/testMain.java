import control.dao.ProjectDAO;
import control.dao.UserDAO;
import model.Project;

import java.util.List;

public class testMain {
    public static void main(String[] args) {

        Project project = new Project();
        project.setUser(UserDAO.getUser("ftestori"));
        List<Project> projects = ProjectDAO.getProjectList(project);
        for(Project p: projects ){
            System.out.println(p.getName());
        }


    }
}

import control.dao.ProjectDAO;
import control.dao.UserDAO;
import model.Project;
import model.User;

import java.util.List;

/**
 * Created by franco on 21/07/2014.
 */
public class FollowerTest {
    public static void main (String[] args){

        List<Project> projects = getFollower();
        for(Project project : projects){
            System.out.println(project.getName());
        }
    }

    public static void setFollowers(){
        Project project1 = ProjectDAO.getInstance().getProject(3);
        Project project2 = ProjectDAO.getInstance().getProject(6);
        Project project3 = ProjectDAO.getInstance().getProject(8);

        User user = UserDAO.getInstance().getUser(1);

        project1.addFollower(user);
        project2.addFollower(user);
        project3.addFollower(user);

        ProjectDAO.getInstance().addProject(project1);
        ProjectDAO.getInstance().addProject(project2);
        ProjectDAO.getInstance().addProject(project3);
    }

    public static List<Project> getFollower(){
        User user = UserDAO.getInstance().getUser(1);
        return ProjectDAO.getInstance().getFollowedProjects(user);
    }
}

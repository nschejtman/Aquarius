import control.dao.ProjectDAO;
import control.dao.TypeDAO;
import control.dao.UserDAO;
import model.Project;
import model.Type;
import model.User;

import java.sql.Date;

public class createProject {
    public static void main(String[] args) {


        Type type = new Type("test");
        System.out.println("Added type: " + TypeDAO.addType(type));

        User user = new User("first name", "last name", new Date(System.currentTimeMillis() - 31556926000L), "username", "u@u.com", "password");
        System.out.println("Added user: " + UserDAO.addUser(user));

        for (int i = 1; i <= 10; i++) {
            String name = "test project " + i;
            String description = "this is a test project";
            Date start = new Date(System.currentTimeMillis());
            Date end = new Date(System.currentTimeMillis() + 31556926000L);
            Project project = new Project(name, description, start, end, type, user);
            System.out.println("Added project[" + i + "]: " + ProjectDAO.addProject(project));
        }

    }
}

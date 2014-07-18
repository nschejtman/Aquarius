import control.dao.CountryDAO;
import control.dao.ProjectDAO;
import control.dao.TypeDAO;
import control.dao.UserDAO;
import model.Project;

public class ProjectTest {
    public static void main(String[] args) {


    }


    public static void createTestProject() {
        Project project = new Project("Test Project", "This is a test project's description. It's short and gives some " +
                "info about the project!", "faq", System.currentTimeMillis(), System.currentTimeMillis() + 259200000L, 100,
                "<h1>This is the header</h1><p>This is the first paragraph. This text is <b>bold</b></p>", CountryDAO.getCountry(1),
                TypeDAO.getInstance().getType(1), UserDAO.getInstance().getUser(2)
        );
        ProjectDAO.addProject(project);


    }

    public static void deleteProjects() {
        ProjectDAO.deleteAll();
    }
}

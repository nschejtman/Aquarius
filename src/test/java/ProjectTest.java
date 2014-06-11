import control.dao.ProjectDAO;

public class ProjectTest {
    public static void main(String[] args) {
//        deleteProjects();
        createProjects();


    }


    public static void createProjects() {


    }

    public static void deleteProjects() {
        ProjectDAO.deleteAll();
    }
}

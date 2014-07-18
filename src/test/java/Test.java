import control.dao.ProjectDAO;
import control.dao.TagDAO;
import model.Project;

public class Test {
    public static void main(String[] args) {

        Project project = ProjectDAO.getProject(1);
        project.addTag(TagDAO.getTag(1));
        project.addTag(TagDAO.getTag(3));
        project.addTag(TagDAO.getTag(6));
        ProjectDAO.addProject(project);


    }
}

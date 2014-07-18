import control.dao.ProjectDAO;
import control.dao.TagDAO;
import model.Project;

public class Test {
    public static void main(String[] args) {

        Project project = ProjectDAO.getInstance().getProject(1);
        project.addTag(TagDAO.getInstance().getTag(1));
        project.addTag(TagDAO.getInstance().getTag(3));
        project.addTag(TagDAO.getInstance().getTag(6));
        ProjectDAO.getInstance().addProject(project);


    }
}

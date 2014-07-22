package control.dao;

import control.HibernateUtil;
import model.Project;
import model.Tag;
import model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by franco on 02/06/2014.
 */
public class SearchDAO  extends DataDAO{

    private static SearchDAO ourInstance = new SearchDAO();

    private SearchDAO() {}

    public static SearchDAO getInstance() {
        return ourInstance;
    }

    public static List<Project> searchProjectNames(String criteriaStr) {
        Session session = HibernateUtil.getGuestSession();
        Criteria criteria = session.createCriteria(Project.class);
        criteria.add(Restrictions.like("name", "%" + criteriaStr + "%"));
        return (List<Project>) criteria.list();
    }

    public static List<Project> searchProjectDescriptions(String criteriaStr) {
        Session session = HibernateUtil.getGuestSession();
        Criteria criteria = session.createCriteria(Project.class);
        criteria.add(Restrictions.like("description", "%" + criteriaStr + "%"));
        return (List<Project>) criteria.list();
    }

    //Repasar para el final
    public static List<Project> searchProjectTags(String criteriaStr) {
        Session session = HibernateUtil.getGuestSession();
        List<Project> projects = new ArrayList<>();
        Criteria criteria = session.createCriteria(Tag.class);
        criteria.add(Restrictions.like("name", "%" + criteriaStr + "%"));
        if(criteria.list().size() > 0) {
            Tag tag = (Tag) criteria.list().get(0);
            List<Project> projectTag = ProjectDAO.getInstance().getProjectByTag(tag);
            for (Project project : projectTag) {
                projects.add(project);
            }
        }
        return  projects;
    }

    public static List<Project> searchResultSet(String criteriaStr){
        List<Project> results = new ArrayList<>();

        List<Project> names = searchProjectNames(criteriaStr);
        List<Project> descriptions = searchProjectDescriptions(criteriaStr);
        List<Project> tags = searchProjectTags(criteriaStr);

        for(Project project : names){
            results.add(project);
        }
        for(Project project: descriptions){
            results.add(project);
        }
        for(Project project : tags){
            results.add(project);
        }
        // Must add some method so that there are no results reiterated
        return results;
    }


    public static List<Project> searchProject(String title, String body, String userName) {
        Session session = HibernateUtil.getGuestSession();
        Criteria criteria = session.createCriteria(Project.class);
        if (title != null) {
            criteria.add(Restrictions.like("projectName", "%" + title + "%"));
        }
        if (body != null) {
            criteria.add(Restrictions.like("description", "%" + body + "%"));
        }
        if (userName != null) {
            criteria.add(Restrictions.like("userName", "%" + userName + "%"));
        }
        return (List<Project>) criteria.list();
    }

    public static List<User> searchUser(String criteriaStr) {
        Session session = HibernateUtil.getGuestSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.like("userName", "%" + criteriaStr + "%"));
        return (List<User>) criteria.list();
    }

    public static List<User> searchUser(String userName, String name) {
        Session session = HibernateUtil.getGuestSession();
        Criteria criteria = session.createCriteria(Project.class);
        if (userName != null) {
            criteria.add(Restrictions.like("projectName", "%" + userName + "%"));
        }
        if (name != null) {
            criteria.add(Restrictions.like("description", "%" + name + "%"));
        }

        return (List<User>) criteria.list();
    }
}

package control.dao;


import control.HibernateUtil;
import model.Project;
import model.Tag;
import model.Type;
import model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class ProjectDAO extends DataDAO {

    private static ProjectDAO ourInstance = new ProjectDAO();

    private ProjectDAO() {
    }

    public static ProjectDAO getInstance() {
        return ourInstance;
    }

    public void addProject(Project project) {
        Session session = HibernateUtil.getGuestSession();
        beginTransaction(session);
        session.persist(project);
        endTransaction();
    }

    public Project getProject(long id) {
        Session session = HibernateUtil.getGuestSession();
        beginTransaction(session);
        Project project = (Project) session.get(Project.class, id);
        endTransaction();
        return project;
    }

    public Project getProject(String projectName) throws IllegalAccessError {
        Session session = HibernateUtil.getGuestSession();
        Object project = null;

        beginTransaction(session);
        Criteria criteria = session.createCriteria(Project.class);
        criteria.add(Restrictions.eq("name", projectName));
        List list = criteria.list();
        if (list.get(0) != null) project = list.get(0);
        endTransaction();

        return (Project) project;
    }

    public List<Project> getProjectsByUser(User user) {
        Session session = HibernateUtil.getGuestSession();
        List<Project> projects;
        beginTransaction(session);
        Criteria criteria = session.createCriteria(Project.class);
        criteria.add(Restrictions.eq("user", user));
        projects = (List<Project>) criteria.list();
        endTransaction();
        return projects;
    }

    public List<Project> getFollowedProjects(User user) {
        Session session = HibernateUtil.getGuestSession();
        List<Project> raw;
        List<Project> projects = new ArrayList<>();
        beginTransaction(session);
        raw = (List<Project>) session.createCriteria(Project.class).list();
        endTransaction();
        // Find projects user is following
        for (Project project : raw) {
            for (User follower : project.getFollowers()) {
                if (follower.getId() == user.getId()) {
                    projects.add(project);
                }
            }
        }
        return projects;
    }

    public List<Project> getProjectList(Project project) {
        List<Project> projectList = new ArrayList<>();
        //Set search parameters
//        String projectName = project.getName();
//        String description = project.getDescription();
//        Date start = project.getStart();
//        Date end = project.getEnd();
//        Type type = project.getType();
//        User user = project.getUser();
        Session session = HibernateUtil.getGuestSession();
        beginTransaction(session);
        // Add restrictions unless parameter is null
        Criteria criteria = session.createCriteria(Project.class);
//            if(projectName != null) criteria.add(Restrictions.eq("name", projectName));
//            if(description != null) criteria.add(Restrictions.eq("description", description));
//            if(start != null) criteria.add(Restrictions.eq("start", start));
//            if(end != null) criteria.add(Restrictions.eq("end", end));
//            if(type != null) criteria.add(Restrictions.eq("type", type));
//            if(user != null) criteria.add(Restrictions.eq("user", user));

        // Add to display List
        List list = criteria.list();
        if (list.get(0) != null) projectList = (List<Project>) list;
        endTransaction();
        return projectList;
    }

    public void deleteAll() {
        Session session = HibernateUtil.getGuestSession();
        beginTransaction(session);
        Criteria criteria = session.createCriteria(Project.class);
        List list = criteria.list();
        for (Object project : list) {
            session.delete(project);
        }
        endTransaction();
    }

    public static Project makeProject(Project project, String name, String description, int objective, String html, Type type, User user, String[] tags) {
        return editProject(project, name, description, objective, html, type, user, tags);
    }

    public static void generateTags(Project project, String[] tags) {
        for (String tag1 : tags) {
            Tag tag = new Tag(tag1);
            if (TagDAO.getInstance().getTag(tag.getId()) == null) {
                TagDAO.getInstance().addTag(tag);
                project.addTag(tag);
            } else {
                project.addTag(TagDAO.getInstance().getTag(tag.getId()));
            }
        }
    }

    public static void deleteAllTags(Project project) {
        List<Tag> tags = new ArrayList<Tag>();
        if (project.getTags() != null) tags = (List<Tag>) project.getTags();
        project.deleteAllTags();
        for (Tag tag : tags) {
            TagDAO.getInstance().addTag(tag);
        }
    }

    public static Project editProject(Project project, String name, String description, int objective, String html, Type type, User user, String[] tags) {
        project.setUser(user);
        project.setName(name);
        project.setDescription(description);
        project.setObjective(objective);
        project.setHtml(html);
        project.setType(type);
        generateTags(project, tags);
        return project;
    }

    public void saveProject(Project project) {
        Session session = HibernateUtil.getGuestSession();
        beginTransaction(session);
        session.persist(project);
        endTransaction();
    }

    public List<Project> getFollowedProjectsByUser(User user) {
        Session session = HibernateUtil.getGuestSession();
        beginTransaction(session);

        Criteria criteria = session.createCriteria(Project.class);
        List all = criteria.list();

        List<Project> followed = new ArrayList<Project>();
        for (Object obj : all) {
            Project project = (Project) obj;
            if (project.isFollowedBy(user)) followed.add(project);
        }
        endTransaction();
        return followed;
    }
}

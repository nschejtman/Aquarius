package control.dao;


import control.HibernateUtil;
import model.Project;
import model.Tag;
import model.Type;
import model.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by franco on 25/04/2014.
 */
public class ProjectDAO extends DataDAO {

    private static ProjectDAO ourInstance = new ProjectDAO();

    private ProjectDAO() {
    }

    public static ProjectDAO getInstance() {
        return ourInstance;
    }

    public void addProject(Project project,Session session) {
        beginTransaction(session);
        session.persist(project);
        endTransaction(session);
    }

    public static Project getProject(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Object project = null;
        try {
            tx = session.beginTransaction();
            project = session.get(Project.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return (Project) project;
    }

    public static Project getProject(String projectName) throws IllegalAccessError {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Object project = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Project.class);
            criteria.add(Restrictions.eq("name", projectName));
            List list = criteria.list();
            if (list.get(0) != null) project = list.get(0);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return (Project) project;
    }

    public static List<Project> getProjectsByUser(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Project> projects = null;
        try{
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Project.class);
            criteria.add(Restrictions.eq("user", user));
            projects = (List<Project>) criteria.list();
            tx.commit();
        } catch (HibernateException e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return projects;
    }

    public static List<Project> getProjectList(Project project) {
        List<Project> projectList = null;
        //Set search parameters
//        String projectName = project.getName();
//        String description = project.getDescription();
//        Date start = project.getStart();
//        Date end = project.getEnd();
//        Type type = project.getType();
//        User user = project.getUser();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
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
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return projectList;
    }

    public static void deleteAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Project.class);
            List list = criteria.list();
            for (Object project : list) {
                session.delete(project);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static Project makeProject(Project project,String name, String description, int objective, String html, Type type, User user, String[] tags) {
        return editProject(project, name, description, objective,html,type,user,tags);
    }

    public static void generateTags(Project project, String[] tags) {
        for (String tag1 : tags) {
            Tag tag = new Tag(tag1);
            if (TagDAO.getTag(tag.getId()) == null) {
                TagDAO.addTag(tag);
                project.addTag(tag);
            } else {
                project.addTag(TagDAO.getTag(tag.getId()));
            }
        }
    }

    public static void deleteAllTags(Project project) {
        List<Tag> tags = null;
        if(project.getTags() != null) tags = (List<Tag>)project.getTags();
        project.deleteAllTags();
        for (Tag tag : tags) {
            TagDAO.addTag(tag);
        }
    }

    public static Project editProject(Project project,String name, String description, int objective, String html, Type type, User user, String[] tags) {
        project.setUser(user);
        project.setName(name);
        project.setDescription(description);
        project.setObjective(objective);
        project.setHtml(html);
        project.setType(type);
        generateTags(project, tags);
        return project;
    }
}

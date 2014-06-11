package control.dao;


import control.HibernateUtil;
import model.Project;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by franco on 25/04/2014.
 */
public abstract class ProjectDAO {

    public static boolean addProject(Project project) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        boolean ret = false;
        try {
            tx = session.beginTransaction();
//            project.setActive(true);
            session.persist(project);
            tx.commit();
            ret = true;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ret;
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
                project = (Project) project;
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

}

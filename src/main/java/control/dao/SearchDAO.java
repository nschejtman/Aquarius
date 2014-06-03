package control.dao;

import control.HibernateUtil;
import model.Project;
import model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by franco on 02/06/2014.
 */
public class SearchDAO {

    public static List<Project> searchProject(String criteriaStr) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Project.class);
        criteria.add(Restrictions.like("title", "%" + criteriaStr + "%"));
        return (List<Project>)criteria.list();
    }

    public static List<Project> searchProject(String title, String body, String userName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
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
        return (List<Project>)criteria.list();
    }

    public static List<User> searchUser(String criteriaStr) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Project.class);
        criteria.add(Restrictions.like("title", "%" + criteriaStr + "%"));
        return (List<User>)criteria.list();
    }

    public static List<User> searchUser(String userName, String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Project.class);
        if (userName != null) {
            criteria.add(Restrictions.like("projectName", "%" + userName + "%"));
        }
        if (name != null) {
            criteria.add(Restrictions.like("description", "%" + name + "%"));
        }

        return (List<User>)criteria.list();
    }
}

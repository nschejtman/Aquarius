package control.dao;

import control.HibernateUtil;
import model.Tag;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by franco on 09/05/2014.
 */
public  class TagDAO extends DataDAO {

    private static TagDAO ourInstance = new TagDAO();

    private TagDAO() {
    }

    public static TagDAO getInstance() {
        return ourInstance;
    }


    public  void addTag(Tag tag){
        Session session = HibernateUtil.getGuestSession();
        beginTransaction(session);
            session.persist(tag);
        endTransaction();
    }

    public  Tag getTag(long id){
        Session session = HibernateUtil.getGuestSession();
        Object tag = null;
        beginTransaction(session);
            tag = session.get(Tag.class, id);
        endTransaction();
        return (Tag) tag;
    }

    public  List<Tag> getAll(){
        Session session = HibernateUtil.getGuestSession();
        return (List<Tag>) session.createCriteria(Tag.class).list();
    }

    public  Tag getSingleTag(String tag) throws IllegalAccessError {
        Session session = HibernateUtil.getGuestSession();
        Object user = null;
        beginTransaction(session);
            Criteria criteria = session.createCriteria(Tag.class);
            criteria.add(Restrictions.eq("name", tag));
            List list = criteria.list();
            if (list.size()>0 && list.get(0) != null) user = list.get(0);
        endTransaction();
        return (Tag) user;
    }

    public List<Tag> getTagsByName(String name){
        Session session = HibernateUtil.getGuestSession();
        List<Tag> tags;
        beginTransaction(session);
        Criteria criteria = session.createCriteria(Tag.class);
        criteria.add(Restrictions.eq("name", name));
        tags = (List<Tag>) criteria.list();
        endTransaction();
        return tags;
    }

}

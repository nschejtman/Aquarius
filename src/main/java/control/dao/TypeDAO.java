package control.dao;

import control.HibernateUtil;
import model.Type;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class TypeDAO extends DataDAO {


    private static TypeDAO ourInstance = new TypeDAO();

    private TypeDAO() {
    }

    public static TypeDAO getInstance() {
        return ourInstance;
    }

    public void addType(Type type) {
        Session session = HibernateUtil.getGuestSession();
        beginTransaction(session);
        session.persist(type);
        endTransaction();
    }

    public Type getType(String name) {
        Session session = HibernateUtil.getGuestSession();
        Type type = null;
        beginTransaction(session);
        Criteria criteria = session.createCriteria(Type.class);
        criteria.add(Restrictions.eq("name", name));
        List list = criteria.list();
        if (list != null) type = (Type) list.get(0);
        endTransaction();
        return type;
    }

    public Type getType(long id) {
        Session session = HibernateUtil.getGuestSession();
        Type type = null;
        beginTransaction(session);
        type = (Type) session.get(Type.class, id);
        endTransaction();
        return type;
    }

    public static List<Type> getAll() {
        Session session = HibernateUtil.getGuestSession();
        Criteria criteria = session.createCriteria(Type.class);
        return (List<Type>) criteria.list();
    }


}

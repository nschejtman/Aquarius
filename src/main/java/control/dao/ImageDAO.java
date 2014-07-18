package control.dao;

import control.HibernateUtil;
import model.Image;
import model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public  class ImageDAO extends DataDAO {
    private static ImageDAO ourInstance = new ImageDAO();

    private ImageDAO() {
    }

    public static ImageDAO getInstance() {
        return ourInstance;
    }


    public  void addImage(Image image) {
        Session session = HibernateUtil.getGuestSession();
        beginTransaction(session);
            session.persist(image);
        endTransaction();
    }

    public  Image getImage(long id) {
        Session session = HibernateUtil.getGuestSession();
        Object image = null;
        beginTransaction(session);
            image = session.get(Image.class, id);
        endTransaction();
        return (Image) image;
    }

    public  Image getProfilePicture(User user){
        Session session = HibernateUtil.getGuestSession();
        Image profile = null;
        beginTransaction(session);
            Criteria criteria = session.createCriteria(Image.class);
            criteria.add(Restrictions.eq("path",user.getProfilePicture().getPath()));
            List list = criteria.list();
            if (list.size() > 0 && list.get(0) != null) profile = (Image)list.get(0);
        endTransaction();
        return profile;
    }

}

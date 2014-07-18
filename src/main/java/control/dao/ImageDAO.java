package control.dao;

import control.HibernateUtil;
import model.Image;
import model.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public abstract class ImageDAO {


    public static void addImage(Image image) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(image);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public static Image getImage(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Object image = null;
        try {
            tx = session.beginTransaction();
            image = session.get(Image.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return (Image) image;
    }

    public static Image getProfilePicture(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Image profile = null;
        try{
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Image.class);
            criteria.add(Restrictions.eq("path",user.getProfilePicture().getPath()));
            List list = criteria.list();
            if (list.size() > 0 && list.get(0) != null) profile = (Image)list.get(0);
            tx.commit();
        } catch (HibernateException e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return profile;
    }

//    public static List<Image> getProjectImages(Project project){
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = null;
//        List<Image> images = null;
//        List<Image> projectImages = (List<Image>)project.getImages();
//        try{
//            tx = session.beginTransaction();
//            Query query = session.createQuery("select images_id from project_images where project_id =" +project.getId());
////            Criteria criteria = session.createCriteria(Image.class);
////            for(Image image : projectImages){
////                criteria.add(Restrictions.eq("path", image.getPath()));
////                images.add((Image)criteria.list().get(0));
////            }
//            tx.commit();
//        } catch (HibernateException e){
//            if(tx != null) tx.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return images;
//    }

}

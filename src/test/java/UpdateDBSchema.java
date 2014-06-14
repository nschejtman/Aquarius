import control.HibernateUtil;
import org.hibernate.Session;

public class UpdateDBSchema {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.close();
    }

}

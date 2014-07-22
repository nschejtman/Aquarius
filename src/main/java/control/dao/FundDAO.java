package control.dao;

import control.HibernateUtil;
import model.Fund;
import org.hibernate.Session;

public class FundDAO extends DataDAO {
    private static FundDAO ourInstance = new FundDAO();

    private FundDAO() {
    }

    public static FundDAO getInstance() {
        return ourInstance;
    }

    public void saveFund(Fund fund) {
        Session session = HibernateUtil.getGuestSession();
        beginTransaction(session);
        session.persist(fund);
        endTransaction();
    }


}

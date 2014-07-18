package control.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class DataDAO {
    private Transaction tx;

    protected void beginTransaction(Session session) {
        try {
            tx = session.beginTransaction();
        } catch (RuntimeException e) {
            System.err.println("Could Not Open Session or Begin Transaction" + e);
        }
    }

    protected void endTransaction() {
        try {
            tx.commit();
        } catch (RuntimeException e) {
            try {
                tx.rollback();
            } catch (RuntimeException rbe) {
                System.err.println("Couldn’t roll back transaction " + rbe);
            }
            throw e;
        } finally {
            tx = null;
        }
    }
}

package sda.hibernate.one2one.actions;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sda.hibernate.one2one.Country;
import sda.hibernate.utils.HibernateUtils;

import java.util.List;

public class DeleteMain {

    /**
     * Get SessionFactory instance from HibernateUtils class and open a Session
     *
     * Fetch a country from database and delete it using 'remove' method on session instance
     * Commit transaction and close session
     *
     * Watch in database what was removed
     *
     * Great job!
     */

    public static void main(String[] args) {
        Session hibernateSession = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = hibernateSession.beginTransaction();

        Country country = hibernateSession.get(Country.class, 7);
        hibernateSession.remove(country);

        transaction.commit();
        hibernateSession.close();
    }

}

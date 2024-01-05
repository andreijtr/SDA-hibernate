package sda.hibernate.one2one.actions;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sda.hibernate.many2many.Classroom;
import sda.hibernate.many2many.Trainer;
import sda.hibernate.one2one.Capital;
import sda.hibernate.one2one.Country;
import sda.hibernate.utils.HibernateUtils;

import java.util.List;

public class InsertMain {

    /**
     * Get SessionFactory instance from HibernateUtils class and open a Session and a Transaction
     *
     * Scenario 1:
     * Create a new Country (set a name and a Capital) and insert in database using session instance (methods 'persist' or 'merge')
     * After calling 'persist' method, print country to console. Commit transaction and close session.
     * What is printed in console? Also check the database.
     *
     * Scenario 2:
     * Insert in database a Country, using a capital that already exists in database
     * First, fetch the capital from database
     * Create a new Country, set a name and the capital fetched. Save it to database
     *
     * Great job! You insert some rows in database.
     */

    public static void main(String[] args) {
        Session hibernateSession = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = hibernateSession.beginTransaction();

        Country america = new Country("America", new Capital("Washington"));
        hibernateSession.persist(america);

        Capital abc = hibernateSession.get(Capital.class, 4);
        Country c = new Country("c", abc);
        hibernateSession.persist(c);

        transaction.commit();
        hibernateSession.close();
    }

}

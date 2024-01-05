package sda.hibernate.one2one.actions;

import org.hibernate.Session;
import org.hibernate.query.Query;
import sda.hibernate.many2many.Classroom;
import sda.hibernate.one2one.Country;
import sda.hibernate.utils.HibernateUtils;

import java.util.List;

public class ReadMain {

    /**
     * Get SessionFactory instance from HibernateUtils class and open a Session
     *
     * Fetch all countries from database using a Query object:
     * - on session instance, call 'createQuery' and give as argument an HQL query that selects all countries from database
     * - fetch query result using 'getResultList' on query instance
     * - iterate over list and print elements to console
     *
     * Watch over console to see results and how Hibernate execute SQL queries.
     * Great job!
     */

    public static void main(String[] args) {
        Session hibernateSession = HibernateUtils.getSessionFactory().openSession();

        Query<Country> query = hibernateSession.createQuery("select c from Country c", Country.class);
        List<Country> countries = query.getResultList();
        countries.forEach(System.out::println);

        hibernateSession.close();
    }

}

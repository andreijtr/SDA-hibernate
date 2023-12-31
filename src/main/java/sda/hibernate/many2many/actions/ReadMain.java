package sda.hibernate.many2many.actions;

import org.hibernate.Session;
import org.hibernate.query.Query;
import sda.hibernate.many2many.Classroom;
import sda.hibernate.many2many.Trainer;
import sda.hibernate.one2many.Post;
import sda.hibernate.utils.HibernateUtils;

import java.util.List;

public class ReadMain {

    /**
     * Get SessionFactory instance from HibernateUtils class and open a Session
     *
     * Fetch all classrooms from database using a Query object:
     * - on session instance, call 'createQuery' and give as argument an HQL query that selects all classrooms from database
     * - fetch query result using 'getResultList' on query instance
     * - iterate over list and print elements to console
     *
     * Watch over console to see results and how Hibernate execute SQL queries.
     * Great job!
     */

    public static void main(String[] args) {
        Session hibernateSession = HibernateUtils.getSessionFactory().openSession();

        Query<Classroom> queryClassrooms = hibernateSession.createQuery("select c from Classroom c", Classroom.class);
        List<Classroom> classrooms = queryClassrooms.getResultList();
        classrooms.forEach(System.out::println);

        hibernateSession.close();
    }

}

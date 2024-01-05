package sda.hibernate.one2many.actions;

import org.hibernate.Session;
import org.hibernate.query.Query;
import sda.hibernate.one2many.Post;
import sda.hibernate.utils.HibernateUtils;

import java.util.List;

public class Read {

    // prezentare
    // [EAGER vs LAZY] poti apoi sa modifici fetch-type pe @OneToMany sa aduca eager, observati cum se modifica sql-urile care se executa
    // daca e LAZY si se inchide sesiunea, cand incearca sa printeze Posts, incearca sa incarce PostComment din db dar s a pierdut contextul tranzactional si nu se poate


    /**
     * Get SessionFactory instance from HibernateUtils class and open a Session
     *
     * Fetch all posts from database using a Query object:
     * - on session instance, call 'createQuery' and give as argument an HQL query that selects all classrooms from database
     * - fetch query result using 'getResultList' on query instance
     * - iterate over list and print elements to console
     *
     * Watch over console to see results and how Hibernate execute SQL queries.
     * Great job!
     */


    public static void main(String[] args) {
        Session hibernateSession = HibernateUtils.getSessionFactory().openSession();

        Query<Post> query = hibernateSession.createQuery("select p from Post p", Post.class);
        List<Post> posts = query.getResultList();
        posts.forEach(System.out::println);

        hibernateSession.close();
    }

}

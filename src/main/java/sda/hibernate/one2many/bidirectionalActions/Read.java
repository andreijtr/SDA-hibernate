package sda.hibernate.one2many.bidirectionalActions;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sda.hibernate.one2many.Post;
import sda.hibernate.one2many.PostComment;
import sda.hibernate.utils.HibernateUtils;

import java.util.List;

public class Read {

    /**
     * Get SessionFactory instance from HibernateUtils class and open a Session and a Transaction
     * Fetch a Post from db and print it to console.
     *
     * Next, create a Query from session using 'createQuery' method.
     * The query will be: "select p from Post p join PostComment pc on pc.post.id = p.id where pc.id = :id"
     * Set parameter on query object and then fetch result using 'getSingleResult' or 'getResultList'
     * Print result on console.
     *
     */

    public static void main(String[] args) {
        Session hibernateSession = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = hibernateSession.beginTransaction();

        Post myPost = hibernateSession.find(Post.class, 11);
        System.out.println(myPost);

        Query<Post> query = hibernateSession.createQuery("select p from Post p join PostComment pc on pc.post.id = p.id where pc.id = :id", Post.class);
        query.setParameter("id", 26);
        List<Post> posts = query.getResultList();

        System.out.println(posts);

        transaction.commit();
        hibernateSession.close();
    }
}

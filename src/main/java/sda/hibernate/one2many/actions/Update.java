package sda.hibernate.one2many.actions;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sda.hibernate.one2many.Post;
import sda.hibernate.utils.HibernateUtils;

public class Update {

    /**
     * Get SessionFactory instance from HibernateUtils class and open a Session and a transaction
     *
     * Steps to update a row in database using Hibernate:
     * - use session object to fetch a Post from database by id
     * - set another content to that Post
     * - commit transaction and close session
     *
     * Great job! Check in database how data is changed.
     */

    public static void main(String[] args) {
        Session hibernateSession = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = hibernateSession.beginTransaction();

        Post myPost = hibernateSession.find(Post.class, 2);
        myPost.setContent("Hello from Barcelona!");

        transaction.commit();
        hibernateSession.close();
    }

}

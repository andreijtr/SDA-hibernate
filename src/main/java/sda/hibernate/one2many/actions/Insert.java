package sda.hibernate.one2many.actions;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sda.hibernate.one2many.Post;
import sda.hibernate.one2many.PostComment;
import sda.hibernate.utils.HibernateUtils;

import java.util.Arrays;

public class Insert {

    /**
     * Get SessionFactory instance from HibernateUtils class and open a Session and a Transaction
     * Create a new Post (set a content and add 2 comments to it) and insert in database using session instance (methods 'persist' or 'merge')
     * After calling 'persist' method, print post to console. Commit transaction and close session.
     * What is printed in console? Also check the database.
     *
     * Great job! You insert some rows in database. Now lets read them!
     */

    public static void main(String[] args) {
        Session hibernateSession = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = hibernateSession.beginTransaction();

        Post myPost = new Post();
        myPost.setContent("We are learning OneToMany relationship!");
        myPost.setComments(Arrays.asList(new PostComment("Good luck!"), new PostComment("Next is one2one!")));

        hibernateSession.persist(myPost);
        transaction.commit();
        hibernateSession.close();
    }

}

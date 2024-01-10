package sda.hibernate.one2many.bidirectionalActions;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sda.hibernate.one2many.Post;
import sda.hibernate.utils.HibernateUtils;

public class Delete {

    /**
     * Get SessionFactory instance from HibernateUtils class and open a Session
     * Fetch a Post from database and delete the first PostComment from 'comments' using remove utility method
     * Commit transaction and close session. Watch in database what was removed
     */

    public static void main(String[] args) {
        Session hibernateSession = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = hibernateSession.beginTransaction();

        Post myPost = hibernateSession.find(Post.class, 11);
        myPost.removeComment(myPost.getComments().get(0));

        transaction.commit();
        hibernateSession.close();
    }
}

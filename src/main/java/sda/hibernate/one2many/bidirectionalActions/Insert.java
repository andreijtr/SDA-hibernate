package sda.hibernate.one2many.bidirectionalActions;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sda.hibernate.one2many.Post;
import sda.hibernate.one2many.PostComment;
import sda.hibernate.utils.HibernateUtils;

public class Insert {

    /**
     * Get SessionFactory instance from HibernateUtils class and open a Session and a Transaction
     * Create a new Post and add 2 comments using utility method 'addComment' and insert in database using session instance (methods 'persist' or 'merge')
     * Commit transaction and close session.
     * What is printed in console?
     *
     * If you see only 3 inserted statement, then you configure Hibernate very efficiently. Great work!
     */

    public static void main(String[] args) {
        Session hibernateSession = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = hibernateSession.beginTransaction();

        // !!! this code shows how ownership works in Hibernate !!!

        Post andreiPost = new Post();
        andreiPost.setContent("Andrei post");

        Post mariaPost = new Post();
        mariaPost.setContent("Maria post");

        PostComment comment = new PostComment("This should belong to Andrei post");

        mariaPost.addComment(comment);    // set mariaPost to comment and add this comment to mariaPost's comments
        comment.setPost(andreiPost);      // set andreiPost to comment, but keep the comment in mariaPost list
                                          // when persisting, mariaPost should have no comments and comment should have FK to andreiPost

        // this happens because the PostComment is the owning side and his references take precedence upon, Post references

        hibernateSession.persist(mariaPost);
        hibernateSession.persist(andreiPost);
        transaction.commit();
        hibernateSession.close();
    }
}

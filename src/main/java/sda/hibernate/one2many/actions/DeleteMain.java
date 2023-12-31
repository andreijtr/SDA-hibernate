package sda.hibernate.one2many.actions;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sda.hibernate.one2many.Post;
import sda.hibernate.one2many.PostComment;
import sda.hibernate.utils.HibernateUtils;

import java.util.Arrays;

public class DeleteMain {

    public static void main(String[] args) {
        Session hibernateSession = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = hibernateSession.beginTransaction();

        Post myPost = hibernateSession.find(Post.class, 2);
        hibernateSession.remove(myPost);

        transaction.commit();
        hibernateSession.close();
    }

}

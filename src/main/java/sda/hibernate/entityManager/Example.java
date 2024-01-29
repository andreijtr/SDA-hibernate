package sda.hibernate.entityManager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sda.hibernate.one2many.Post;
import sda.hibernate.one2many.PostComment;
import sda.hibernate.utils.HibernateUtils;

public class Example {

    public static void main(String[] args) {
        EntityManager entityManager = HibernateUtils.getSessionFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        if (!entityTransaction.isActive()) {
            entityTransaction.begin();
        }

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

        entityManager.persist(mariaPost);
        entityManager.persist(andreiPost);
        entityTransaction.commit();
        entityManager.close();
    }
}

package sda.hibernate.many2many.actions;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sda.hibernate.many2many.Classroom;
import sda.hibernate.many2many.Trainer;
import sda.hibernate.one2many.Post;
import sda.hibernate.one2many.PostComment;
import sda.hibernate.utils.HibernateUtils;

import java.util.Arrays;
import java.util.List;

public class InsertMain {

    /**
     * Get SessionFactory instance from HibernateUtils class and open a Session and a Transaction
     * Create a new Classroom (set a name and add 2 trainers to it) and insert in database using session instance (methods 'persist' or 'merge')
     * After calling 'persist' method, print post to console. Commit transaction and close session.
     * What is printed in console? Also check the database.
     *
     * Next, create a new Classroom and assign an existing trainer from db
     *
     * Great job! You insert some rows in database. Now lets read them!
     */

    public static void main(String[] args) {
        Session hibernateSession = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = hibernateSession.beginTransaction();

        Trainer ioana = hibernateSession.get(Trainer.class, 4);

        Classroom java66 = new Classroom("java66", 20);
        java66.getTrainers().addAll(List.of(ioana));

        hibernateSession.persist(java66);
        transaction.commit();
        hibernateSession.close();
    }

}

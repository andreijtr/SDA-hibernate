package sda.hibernate.gettingStarted;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sda.hibernate.utils.DateUtils;
import sda.hibernate.utils.HibernateUtils;

public class Main {

    /**
     * Get SessionFactory instance from HibernateUtils class and open a Session and a Transaction
     *
     * [READ]
     * Use session object to fetch a UserEntity from database by id using 'find' method and print to console. Close session.
     *
     * [UPDATE]
     * Set another age to fetched UserEntity and commit transaction, close session. Check user in database. What is changed?
     *
     * [INSERT]
     * Create a new UserEntity (set a name, age and createdAt using DateUtils.now()) and insert in database using session instance (methods 'persist' or 'merge').
     * After calling 'persist' method, print user to console. What do you observe? Commit transaction and close session.
     *
     * [DELETE]
     * Fetch a UserEntity from database and delete it using 'remove' method on session instance. Check in database.
     *
     */

    public static void main( String[] args ) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        // read
        UserEntity user = session.find(UserEntity.class, 1);
        System.out.println(user);

        // update
        user.setAge(56);

        // insert
        UserEntity newUser = new UserEntity();
        newUser.setName("Iulian");
        newUser.setAge(78);
        newUser.setCreateAt(DateUtils.now());
        session.persist(newUser);
        System.out.println(newUser);

        // commit
        transaction.commit();
        session.close();
    }
}

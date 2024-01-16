package sda.hibernate.one2many.actions;


public class Delete {

    /**
     * Get SessionFactory instance from HibernateUtils class and open a Session and a transaction
     *
     * Steps to delete a row from database using Hibernate:
     * - use session object to fetch a Post from database by id
     * - on session object call 'remove' method and give fetched post as parameter
     * - commit transaction and close session
     *
     * Great job! Check in database how data is changed. If your post has comments, check for them in comments table.
     */

    public static void main(String[] args) {

    }

}

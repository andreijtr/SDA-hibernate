package sda.hibernate.one2many.bidirectionalActions;


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

    }
}

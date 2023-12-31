package sda.hibernate.one2many.actions;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sda.hibernate.one2many.Post;
import sda.hibernate.utils.HibernateUtils;

import java.util.List;

public class ReadMain {

    // scrie query-ul care sa aduca toate Posts din tabel
    // observa si SQL-urile
    // [EAGER vs LAZY] poti apoi sa modifici fetch-type pe @OneToMany sa aduca eager, observati cum se modifica sql-urile care se executa
    // daca e LAZY si se inchide sesiunea, cand incearca sa printeze Posts, incearca sa incarce PostComment din db dar s a pierdut contextul tranzactional si nu se poate

    public static void main(String[] args) {
        Session hibernateSession = HibernateUtils.getSessionFactory().openSession();

        Query<Post> query = hibernateSession.createQuery("select p from Post p", Post.class);
        List<Post> posts = query.getResultList();
        posts.forEach(System.out::println);

        hibernateSession.close();
    }

}

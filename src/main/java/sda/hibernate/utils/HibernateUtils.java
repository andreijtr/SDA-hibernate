package sda.hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import sda.hibernate.many2many.Classroom;
import sda.hibernate.many2many.Trainer;
import sda.hibernate.one2many.Post;
import sda.hibernate.one2many.PostComment;
import sda.hibernate.gettingStarted.UserEntity;

public class HibernateUtils {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration()
                    .setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver")
                    .setProperty(Environment.URL, "jdbc:mysql://localhost:3306/sda-hibernate")
                    .setProperty(Environment.USER, "root")
                    .setProperty(Environment.PASS, "parola")
                    .setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect")
                    .setProperty(Environment.HBM2DDL_AUTO, "none")
                    .setProperty(Environment.SHOW_SQL, "true")
                    .setProperty(Environment.FORMAT_SQL, "true")
                    .setProperty(Environment.HIGHLIGHT_SQL, "true")
                    .addAnnotatedClass(UserEntity.class)
                    .addAnnotatedClass(Post.class)
                    .addAnnotatedClass(Classroom.class)
                    .addAnnotatedClass(Trainer.class)
                    .addAnnotatedClass(PostComment.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
}

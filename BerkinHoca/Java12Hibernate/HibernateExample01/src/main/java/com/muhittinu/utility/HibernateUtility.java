package com.muhittinu.utility;
import com.muhittinu.entitiy.Post;
import com.muhittinu.entitiy.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HibernateUtility {
    private static final SessionFactory SESSION_FACTORY = sessionFactoryHibernate();
    private static SessionFactory sessionFactoryHibernate() {
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Post.class);
            SessionFactory sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
            return sessionFactory;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public static SessionFactory getSessionFactory(){
        return SESSION_FACTORY;
    }
}

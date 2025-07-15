package org.ejercicio.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration().configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e){
            throw new RuntimeException("Failed to initialize DB", e);
        }
    }

    public static Session getSession(){ return sessionFactory.openSession(); }
}

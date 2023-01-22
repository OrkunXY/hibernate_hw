package org.utils;

import org.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null){
            try{
                Configuration configuration = new Configuration();
                configuration.addAnnotatedClass(Film.class);
                configuration.addAnnotatedClass(Actor.class);
                configuration.addAnnotatedClass(Award.class);
                configuration.addAnnotatedClass(Director.class);
                configuration.addAnnotatedClass(FilmCatagory.class);
                sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
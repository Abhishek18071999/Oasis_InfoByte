package com.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class GuessDAO {
    public List<Guess> getAllGuesses() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Guess.class)
                .buildSessionFactory();

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Guess> guesses = session.createQuery("from Guess", Guess.class).getResultList();
            session.getTransaction().commit();
            return guesses;
        } finally {
            factory.close();
        }
    }
}

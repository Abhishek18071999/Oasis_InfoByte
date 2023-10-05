package com.entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class GuessNum {
    public static void main(String[] args) {
        // Set up Hibernate
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Guess.class)
                .buildSessionFactory();

        RandomNum rnd = new RandomNum();
        Scanner sc = new Scanner(System.in);
        System.out.println("You will be given 5 chances, and the maximum score among these 5 chances will be your final score");

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter your guess: ");
            int guessNum = sc.nextInt();

            // Create a Guess object
            Guess guess = new Guess();
            guess.setUserGuess(guessNum);
            Compare cmp = new Compare();
            cmp.compare(guessNum); // Pass the user's guess to the compare method

            // Save the Guess object to the database
            saveGuess(factory, guess);
        }

        // Close the factory when done
        factory.close();
    }

    private static void saveGuess(SessionFactory factory, Guess guess) {
        Session session = factory.getCurrentSession();
        try {
            // Begin a transaction
            session.beginTransaction();

            // Save the Guess object
            session.save(guess);

            // Commit the transaction
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}

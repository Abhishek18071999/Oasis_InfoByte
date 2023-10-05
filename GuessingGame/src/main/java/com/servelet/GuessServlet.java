package com.servelet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.entity.Guess;
@WebServlet("/GuessServlet")
public class GuessServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get user's guess from the form
        int userGuess = Integer.parseInt(request.getParameter("userGuess"));

        // Create a new Guess object with the user's guess
        Guess guess = new Guess();
        guess.setUserGuess(userGuess);

        // Create a Hibernate session
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Guess.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // Begin a transaction
            session.beginTransaction();

            // Save the Guess object
            session.save(guess);

            // Commit the transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions
        } finally {
            // Close the session
            factory.close();
        }

        // Calculate the result of the guess and provide feedback
        int correctValue = getRandomValue(); // Replace with your logic to generate a random value
        int score = calculateScore(userGuess, correctValue); // Implement your scoring logic here

        // Forward to the game.jsp page with the result
        request.setAttribute("resultMessage", "Your guess: " + userGuess + "<br>Correct Value: " + correctValue
                + "<br>Score: " + score);
        request.getRequestDispatcher("game.jsp").forward(request, response);
    }

    // Replace this method with your logic to generate a random value
    private int getRandomValue() {
        return (int) (Math.random() * 100);
    }

    // Implement your scoring logic here
    private int calculateScore(int userGuess, int correctValue) {
        // Example: Calculate the score based on the absolute difference between the user's guess and the correct value
        return 100 - Math.abs(userGuess - correctValue);
    }
}

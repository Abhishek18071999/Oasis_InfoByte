package com.entity;
public class Compare {
    RandomNum rnd = new RandomNum();

    public void compare(int userGuess) {
        int score = 0;
        int maxScore = Integer.MIN_VALUE;

        // Get the random number from RandomNum class
        int randomValue = rnd.getRandomNum();

        // Compare the user's guess to the random number
        if (userGuess == randomValue) {
            score = 100;
        } else if (userGuess > randomValue) {
            score = userGuess - randomValue;
        } else {
            score = randomValue - userGuess;
        }

        maxScore = Math.max(maxScore, score);

        System.out.println("Random Number: " + randomValue);
        System.out.println("Your Guess: " + userGuess);
        System.out.println("Score: " + score);
        System.out.println("Max Score: " + maxScore);
    }
}

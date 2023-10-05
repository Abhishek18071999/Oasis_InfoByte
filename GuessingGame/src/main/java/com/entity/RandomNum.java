package com.entity;
import java.util.Random;

public class RandomNum {
    private int randomNum;
    private Random rand = new Random();

    public RandomNum() {
        // Initialize randomNum with a random value between 0 and 99.
        this.randomNum = rand.nextInt(100);
    }

    public int getRandomNum() {
        // Generate and return a new random number each time this method is called.
        this.randomNum = rand.nextInt(100);
        return this.randomNum;
    }
}
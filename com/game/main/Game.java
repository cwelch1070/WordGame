package com.game.main;

import java.util.Scanner;

public class Game extends WordGenerator {
    private String usersGuess;
    Scanner userInput = new Scanner((System.in));

    public void start() {
        readFile();
        sort();
        selectRandomWord();
        takeGuess();
    }

    public void takeGuess() {
        //selectRandomWord();
        System.out.println("From takeGuess: " + getGameWord());
        System.out.println("Enter your guess: ");
        setUsersGuess(userInput.nextLine());  // Read user input
        System.out.println(getGameWord().equals(getUsersGuess()));
    }

    public String getUsersGuess() {
        return usersGuess;
    }

    public void setUsersGuess(String usersGuess) {
        this.usersGuess = usersGuess;
    }
}

package com.game.main;

import java.util.Scanner;

public class Game {
    /*
        -usersGuess is where the users input that represents their guess is stored
        -stopGame stores users input that determines if they want to play again or quit the game
        -userInput is a scanner object to capture the users guess and store it in usersGuess
        -exit is a scanner object used to capture the users input and store in stopGame to continue or exit the game
        -WordGenerator is an object of the WordGenerator class so that methods from that class can be used here in the Game class
    */

    private String usersGuess;
    private int stopGame;
    private Scanner userInput = new Scanner((System.in));
    private Scanner exit = new Scanner((System.in));
    private char[] charOfGameWord;
    private char[] charOfUsersGuess;
    private WordGenerator wordGenerator = new WordGenerator();

    /*
        Contains all method calls needed to run the game and the main game loop.
    */

    public void start() {
        while (true) {
            wordGenerator.readFile();
            wordGenerator.sort();
            wordGenerator.selectRandomWord();
            intro();
            takeGuess();
            showCorrectChar();

            System.out.println("Would you like to play again?\nEnter 0 to continue or any other number to exit.");

            try {
                stopGame = exit.nextInt();
            }catch(Exception e) {
                System.out.println("You entered a non integer value. Please enter a integer value.\nGoodbye...");
                break;
            }


            if(stopGame == 0) {
                continue;
            }else {
                break;
            }
        }
    }

    /*
        Handles the users guess and determines if the users guess was correct or not
    */

    public void takeGuess() {
        for (int i = 0;i < 5;i++) {
            System.out.println("Your on guess number: " + i);
            System.out.println("Enter your guess: ");
            setUsersGuess(userInput.nextLine());  // Read user input
            System.out.println(wordGenerator.getGameWord().equals(getUsersGuess()));
            if(wordGenerator.getGameWord().equals(getUsersGuess())) {
                System.out.println("That's correct! You win!");
                break;
            }
        }
    }

    public void intro() {
        System.out.println("Word to be guessed: " + wordGenerator.getGameWord());
        System.out.println("Welcome to WordGame.\nThe rules are simple, you get 5 chances to guess a 5 letter word.");
    }

    public void showCorrectChar() {
        charOfGameWord = new char[wordGenerator.getGameWord().length()];
        charOfUsersGuess = new char[getUsersGuess().length()];

        /*
            Breaks usersGuess into characters and stores those characters in charOfUsersGuess
        */

        for(int i = 0;i < getUsersGuess().length();i++) {
            charOfUsersGuess[i] = getUsersGuess().charAt(i);
        }

        for(char c : charOfUsersGuess) {
            System.out.println(c);
        }

        /*
            Breaks gameWord into characters and stores those characters in charOfGameWord array
        */

        for (int i = 0; i < wordGenerator.getGameWord().length(); i++) {
            charOfGameWord[i] = wordGenerator.getGameWord().charAt(i);
        }

        // Printing content of array
        for (char c : charOfGameWord) {
            System.out.println(c);
        }
    }

    /*
        Get and set methods for usersGuess member variable
    */

    public String getUsersGuess() {
        return usersGuess;
    }

    public void setUsersGuess(String usersGuess) {
        this.usersGuess = usersGuess;
    }
}


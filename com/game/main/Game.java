package com.game.main;

import java.util.Scanner;

public class Game {
    /*
        -usersGuess is where the users input that represents their guess is stored
        -stopGame stores users input that determines if they want to play again or quit the game
        -userInput is a scanner object to capture the users guess and store it in usersGuess
        -exit is a scanner object used to capture the users input and store in stopGame to continue or exit the game
        -charOfGame and charOfUsersGuess are the beginnings of the game being able to tell the users what letters are also
         in the word they are trying to guess
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
        while(true) {
            wordGenerator.readFile();
            wordGenerator.sort();
            wordGenerator.selectRandomWord();
            intro();
            takeGuess();

            System.out.println("\nWould you like to play again?\nEnter 0 to continue or any other number to exit.");

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
        Handles the users guess and determines if the users guess was correct.
        Controls the amount of times the user is able to guess.
    */

    public void takeGuess() {
        for (int i = 0;i < 5;i++) {
            System.out.println("\nYour on guess number: " + i);
            System.out.println("Enter your guess: ");
            setUsersGuess(userInput.nextLine());  // Read user input
            System.out.println("Your answer is " + wordGenerator.getGameWord().equals(getUsersGuess()) + ". Try again.");
            System.out.println("The correctly guessed characters in the word are: ");
            showCorrectChar();
            if(wordGenerator.getGameWord().equals(getUsersGuess())) {
                System.out.println("\nThat's correct! You win!");
                break;
            }
        }
    }

    /*
        Into to game called at start of program
    */

    public void intro() {
        //System.out.println("Word to be guessed: " + wordGenerator.getGameWord());
        System.out.println("Welcome to WordGame.\nThe rules are simple, you get 5 chances to guess a 5 letter word.");
    }

    /*
        This method will show the user what letters in the word they have guessed are also in the word they are trying to
        guess. It will function as a hint to the user to decrease the difficulty of the game.
    */

    public void showCorrectChar() {
        charOfGameWord = new char[wordGenerator.getGameWord().length()];
        charOfUsersGuess = new char[getUsersGuess().length()];

        //Breaks usersGuess into characters and stores those characters in charOfUsersGuess
        for(int i = 0;i < getUsersGuess().length();i++) {
            charOfUsersGuess[i] = getUsersGuess().charAt(i);
        }

        //Breaks gameWord into characters and stores those characters in charOfGameWord array
        for (int i = 0; i < wordGenerator.getGameWord().length(); i++) {
            charOfGameWord[i] = wordGenerator.getGameWord().charAt(i);
        }

        /*
            Compare each position in the two char arrays to see if they are equal. If they are equal print the contents
            of that position in the array, if not, ignore that position and move to the next.

            For example take charOfGameWord[0] and check if it is equal to charOfUsersGuess[0]. Continue this for the
            remaining 4 positions in the array.
        */

        if(charOfGameWord[0] == charOfUsersGuess[0]) {
            System.out.print(charOfGameWord[0]);
        } else {
            System.out.print("-");
        }

        if(charOfGameWord[1] == charOfUsersGuess[1]) {
            System.out.print(charOfGameWord[1]);
        } else {
            System.out.print("-");
        }

        if(charOfGameWord[2] == charOfUsersGuess[2]) {
            System.out.print(charOfGameWord[2]);
        } else {
            System.out.print("-");
        }

        if(charOfGameWord[3] == charOfUsersGuess[3]) {
            System.out.print(charOfGameWord[3]);
        } else {
            System.out.print("-");
        }

        if(charOfGameWord[4] == charOfUsersGuess[4]) {
            System.out.print(charOfGameWord[4]);
        } else {
            System.out.print("-");
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


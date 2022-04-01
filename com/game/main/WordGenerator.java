package com.game.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordGenerator {
    /*
    dictionary stores the dictionary words that are being read from the txt file.
    gameWords stores the sorted words that are exactly 5 characters long that will be used for the game.
     */

    private static List<String> dictionary = new ArrayList<String>();
    private static List<String> gameWords = new ArrayList<String>();
    private String gameWord;

    /*
    readFile simply stores the file into the dictionary arrayList.
     */

    public void readFile() {
        try {
            File myObj = new File("C:\\Users\\caleb\\Documents\\dictionary.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                dictionary.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /*
    sorts the words stores in dictionary to only have exactly 5 characters and stores them in gameWords.
     */

    public void sort() {
        readFile();
        String[] sortedWords = dictionary.toArray(new String[0]);
        for(int i = 0;i < sortedWords.length;i++) {
            if (sortedWords[i].length() == 5) {
                gameWords.add(sortedWords[i]);
                //System.out.println("Words with 5 letters: " + sortedWords[i]);
            }
        }
    }

    /*
    Randomly selects a string from the gameWords arrayList.
    This randomly selected string will be used for the game.
     */

    public void selectRandomWord() {
        sort();
        // loop to print elements at random
        for (int i = 0; i < 1; i++)
        {
            // generating the index using Math.random()
            int index = (int)(Math.random() * gameWords.size());

            gameWord = gameWords.get(index);
            setGameWord(this.gameWord);
            //System.out.println("This is getGameWord call: " + getGameWord());
            //System.out.println(gameWord);
            //System.out.println("Random Element is: " + gameWords.get(index));
        }
    }

    public String getGameWord() {
        return gameWord;
    }

    public void setGameWord(String gameWord) {
        this.gameWord = gameWord;
    }
}

# WordGame
This is a command line version of the game Wordle that I recreated as a project to practice programming in java. 
The game is still a work in progress but is functional.
## Project Goals
The goal of this project was to create a java command line game that demonstrated my understanding of object orineted programming with java. The game contains examples
of composition, encapsulation, and polymorphism which are the three major components that make java an object oriented language.

## What it does
The games concept is simple, the players goal is to guess a random five letter word. Only five guesses are allowed and if the word is not guessed correctly within 
those five guesses the game ends and the users is asked if they would like to exit the game or play again.

## How it Works

#### Read Text File
The program first reads a text documnent that contains 58,000 dictionary words. These 58,000 words are then stored in an arrayList, an arrayList was chosen over a
standard array because the size that the array needed to be was unknown. An arrayList does not require a size or length parameter so an arrayList best suited the 
programs needs.

![Screenshot (103)](https://user-images.githubusercontent.com/90748206/162023973-3d6d58a7-2719-4eda-b202-5e9c35f511c3.png)

#### Sort the arrayList
The arrayList is then converted into a String array that is then sorted. Only words that are exactly five characters in length are kept and those words are stored in a 
new arrayList. The new arrayList contains around 4000 words all exactly five characters in length.

![Screenshot (104)](https://user-images.githubusercontent.com/90748206/162024783-862b25fa-17a3-46ef-b574-54bbdfae2a22.png)

#### Select Random Words from arrayList
Next, math.random() is used to randomly select a positon in the arrayList and return the contents of that postion in the array. That word that is returned is then 
stored in a string variable called gameWord and is used as the word that the player will try and guess.

![Screenshot (105)](https://user-images.githubusercontent.com/90748206/162025913-247f65f2-59d4-4cd7-8b44-72eb70dcd462.png)

#### Get Users Guess
Input is then taken from the player to represent the users guess. That input is stored in a string variable called usersGuess and compared to the string gameWord.
If the two strings are equal the player is informed that their guess was correct if the guess was not equal the player is informed their guess was not correct.

![Screenshot (106)](https://user-images.githubusercontent.com/90748206/162028338-fed6f6ea-b3bf-4cf7-827f-921a11ae900c.png)

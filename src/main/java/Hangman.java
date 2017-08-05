/** A game of hangman built for a little console fun
 *  The game uses user input and has a life count, a
 *  player can keep guessing as long as their life
 *  count is greater than 0(life count = word length)
  **/
//Importing utilities that will be used in the project
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
/** Utilities end here **/

public class Hangman {
    public Scanner userInput(Scanner player) {
        Scanner playerIn = new Scanner(System.in);
        return playerIn;
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner userInput = new Scanner(System.in);

        String[] words = { "extravaganza", "superman", "salamander", "marvel", "watermelon", "python" };//This array is used to get the words that a user will be guessing
        boolean gamePlay = true;

        while (gamePlay) {
            // System.out.println("Karibu Hangman");
            //Pick a random word from the words array.
            char[] randomWordArr = words[random.nextInt(words.length)].toCharArray();
            int totalGuesses = randomWordArr.length;// Give a standard amount of chances.
            char[] playerGuess = new char[totalGuesses];

            //Convert all the elements in the array an underscore
            for (int ges = 0; ges < playerGuess.length; ges++) {
                playerGuess[ges] = '_';
            }
            boolean correctGuess = false;
            int tries = 0;

            while (!correctGuess && tries != totalGuesses) {
                System.out.print("Correct Guesses:");
                //function to display the array of correct Guesses, dashes(_ _ _) if  empty
                printArray(playerGuess);
                //output to show tries left
                System.out.printf("You have %d tries left.\n", totalGuesses - tries);

                //prompt user to enter  a new character ,ONLY one character can be accepted
                System.out.println("Enter a single Character");
                char input = userInput.nextLine().charAt(0);
                tries++;
                //if the player enters '-' the player is able to get a new word.
                if (input == '-') {
                    //gamePlay = false;
                    correctGuess = true;
                } else {
                    for (int ind = 0; ind < randomWordArr.length; ind++) {
                        if (randomWordArr[ind] == input) {
                            playerGuess[ind] = input;
                        }
                    }
                    if (isCorrectlyGuessed(playerGuess)) {
                        correctGuess = true;
                        System.out.println("Great job buddy!!!!");
                        printArray(playerGuess);

                    }
                }
            } //End of game play loop.

            if (!correctGuess)
                System.out.println("You ran out of guesses");
            System.out.println("Play again?(yes/no)");

            String newGame = userInput.nextLine();
            if (newGame.equals("no"))
                gamePlay = false;

        }
        System.out.println("Game Over!");
    }

    //public method to print player guesses
    public static void printArray(char[] array) {
        for (int x = 0; x < array.length; x++) {
            System.out.print(array[x] + "  ");
        }
        System.out.println();
    }

    //public method to check if
    public static boolean isCorrectlyGuessed(char[] array) {
        for (int y = 0; y < array.length; y++) {
            if (array[y] == '_')
                return false;
        }
        return true;

    }
}
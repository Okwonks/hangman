import java.util.Scanner;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class Hangman {
    // Scanner userIn = new Scanner(System.in);
    public List<String> hangmanWords = Arrays.asList("word", "computer", "batman", "superman");
    public Random generateWord = new Random();

    public String guessWord = hangmanWords.get(generateWord.nextInt(hangmanWords.size()));

    public String findWord(String user) {
        char[] letterReplace = new char[guessWord.length()];
        int i = 0;
        while (i < guessWord.length()) {
            letterReplace[i] = '-';
            if(guessWord.charAt(i) == ' ') {
                letterReplace[i] = ' ';
            }
            i++;
        }
        return guessWord;
    }


    // public static void main(String[] args) {

    // }

}
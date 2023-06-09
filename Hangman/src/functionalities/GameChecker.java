package functionalities;

import printers.HangmanPrinter;
import printers.WordStatePrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameChecker {

    private List<Character> playerGuesses;

    private Integer wrongCount;

    private HangmanPrinter hangmanPrinter;

    private Scanner keyboard;

    WordStatePrinter wordStatePrinter;


    public void checkGame(String word){
        try{
            wrongCount = 0;
            playerGuesses = new ArrayList<>();
            hangmanPrinter = new HangmanPrinter();
            keyboard = new Scanner(System.in);
            wordStatePrinter = new WordStatePrinter();

            while (true) {
                hangmanPrinter.printHangedMan(wrongCount);

                if (wrongCount == 6) {
                    if (keyboard.nextLine().equals(word)) {
                        System.out.println("You won! The word is:" + word);
                        break;
                    } else {
                        System.out.println("You have lost! The word is: " + word);
                        break;
                    }
                }

                //method to print the state of the word
                wordStatePrinter.printWordState(word, playerGuesses);

                //if the letter is not contained in the word, wrong guesses are increased by 1
                if (!getPlayerGuess(keyboard, word, playerGuesses)) {
                    wrongCount++;
                    System.out.println("Nope! Try again.");
                }

                if(wordStatePrinter.printWordState(word, playerGuesses)){
                    System.out.println("You won! The word is: " + word);
                    break;
                }

            }
        }
        catch(StringIndexOutOfBoundsException stringIndexOutOfBoundsException){
            stringIndexOutOfBoundsException.printStackTrace();
            System.out.println("String Index out of bounds - checkGame method [GameChecker class]");
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error! - checkGame method [GameChecker class]");
        }finally{
            keyboard.close();
        }
    }


    public boolean getPlayerGuess(Scanner keyboard, String word, List<Character> playerGuesses) {

        String letterGuess = null;
        try {
            System.out.println("Please enter a letter:");
            System.out.print("[Your guesses: ");
            for (Character playerGuess : playerGuesses) {
                System.out.print(playerGuess + ", ");
            }
            System.out.print("]\n");
            letterGuess = keyboard.nextLine();

            if (letterGuess.equals(word)) {
                System.out.println("You won! The word is: " + word);
                System.exit(0);
            }else if(letterGuess.isEmpty()) {
                System.out.println("You can't leave it blank");
                getPlayerGuess(keyboard, word, playerGuesses);
            }
            else{
                //we will just consider the first character inserted by the player
                playerGuesses.add(letterGuess.charAt(0));
            }

            return word.contains(letterGuess);

        }
        catch(IllegalStateException illegalStateException){
            illegalStateException.printStackTrace();
            System.out.println("Illegal state exception - getPlayerGuess method [GameChecker class]");
            return word.contains(letterGuess);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error! - getPlayerGuess method [GameChecker class]");
            return word.contains(letterGuess);
        }
        //I cannot close the keyboard here because, if I did, I would get an IllegalStateException cause
        //the keyboard needs to stay open until the game is on. Therefore, we need to close
        //the keyboard just before the game ends, that's why we'll close it in a try-catch-finally block
        //that we'll implement directly in the main method of the Main class.
    }

    public List<Character> getPlayerGuesses() {
        return playerGuesses;
    }

    public void setPlayerGuesses(List<Character> playerGuesses) {
        this.playerGuesses = playerGuesses;
    }

    public Integer getWrongCount() {
        return wrongCount;
    }

    public void setWrongCount(Integer wrongCount) {
        this.wrongCount = wrongCount;
    }

    public HangmanPrinter getHangmanPrinter() {
        return hangmanPrinter;
    }

    public void setHangmanPrinter(HangmanPrinter hangmanPrinter) {
        this.hangmanPrinter = hangmanPrinter;
    }

    public Scanner getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Scanner keyboard) {
        this.keyboard = keyboard;
    }

    public WordStatePrinter getWordStatePrinter() {
        return wordStatePrinter;
    }

    public void setWordStatePrinter(WordStatePrinter wordStatePrinter) {
        this.wordStatePrinter = wordStatePrinter;
    }
}

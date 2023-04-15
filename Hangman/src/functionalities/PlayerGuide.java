package functionalities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PlayerGuide {

    private final String WELCOME = "### Hi, welcome to the Hangman game! ###\n"
                                        + "- Type 1 to play against the computer.\n"
                                        + "- Type any other character for multi-player mode.";

    private final String MULTIPLE_PLAYERS_BEGINNING_RULE_1 =
                        "Choose the player who'll write the word to guess. "
                        + "When you chose the player, the others will close their eyes.\n"
                        + "Now the chosen player will insert the word (type in lower-case and without accents):";

    private final String MULTIPLE_PLAYERS_BEGINNING_RULE_2 =
            "Perfect! Now the others can open their eyes. "
            + "\nDon't scroll up if you want to play honestly.\n"
            + "Let the game begin, good luck!\n";

    private String playersNumber;

    private String chosenWord;

    private WordGenerator wordGenerator;

    private GameChecker gameChecker;


    public void welcomePlayer(){
        System.out.println(WELCOME);
    }

    public void readPlayerModeChoise(Scanner scanner) throws FileNotFoundException{
        try{
            welcomePlayer();
            wordGenerator = new WordGenerator(new File("C:\\Users\\icaro\\Desktop\\JavaCore\\JavaCore\\Hangman\\hangmanWords.txt"));
            playersNumber = scanner.nextLine();

            if (playersNumber.equals("1")){
                System.out.println("Dare you challenge a computer, human? May the best win!");
                wordGenerator.generateWord(wordGenerator.getFile());
            }else {
                gameChecker = new GameChecker();
                System.out.println(MULTIPLE_PLAYERS_BEGINNING_RULE_1);

                //one of the players will choose and type a word in, then the program will print automatically
                //some lines to hide the word that has been chosen, so that the other players don't cheat
                chosenWord = scanner.nextLine();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                System.out.println(MULTIPLE_PLAYERS_BEGINNING_RULE_2);
                gameChecker.checkGame(chosenWord);

            }
        } catch(NullPointerException nullPointerException){
            nullPointerException.printStackTrace();
            System.out.println("Null pointer exception! - readPlayerModeChoise method [PlayerGuide class]");
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Error! - readPlayerModeChoise method [PlayerGuide class]");
        }finally {
            scanner.close();
        }
    }

    public String getWELCOME() {
        return WELCOME;
    }

    public String getMULTIPLE_PLAYERS_BEGINNING_RULE_1() {
        return MULTIPLE_PLAYERS_BEGINNING_RULE_1;
    }

    public String getMULTIPLE_PLAYERS_BEGINNING_RULE_2() {
        return MULTIPLE_PLAYERS_BEGINNING_RULE_2;
    }

    public String getPlayersNumber() {
        return playersNumber;
    }

    public void setPlayersNumber(String playersNumber) {
        this.playersNumber = playersNumber;
    }

    public String getChosenWord() {
        return chosenWord;
    }

    public void setChosenWord(String chosenWord) {
        this.chosenWord = chosenWord;
    }

    public WordGenerator getWordGenerator() {
        return wordGenerator;
    }

    public void setWordGenerator(WordGenerator wordGenerator) {
        this.wordGenerator = wordGenerator;
    }

    public GameChecker getGameChecker() {
        return gameChecker;
    }

    public void setGameChecker(GameChecker gameChecker) {
        this.gameChecker = gameChecker;
    }
}

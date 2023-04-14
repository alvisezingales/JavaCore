package functionalities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordGenerator {

    private String word;
    private List<String> words;
    private Scanner scanner;
    private Random rand;
    private File file;

    private GameChecker gameChecker;

    public WordGenerator() {
    }

    public WordGenerator(File file) {
        this.file = file;
    }

    public void generateWord(File file){
        try{
            rand = new Random();
            scanner = new Scanner(new File(file.toURI()));
            words = new ArrayList<>();
            gameChecker = new GameChecker();

            while (scanner.hasNext()) {
                words.add(scanner.nextLine());
            }
            word = words.get(rand.nextInt(words.size()));
            gameChecker.checkGame(word);

        } catch(NullPointerException nullPointerException){
            nullPointerException.printStackTrace();
            System.out.println("Null pointer exception! - generateWord method");
        }catch(FileNotFoundException fileNotFoundException){
            fileNotFoundException.printStackTrace();
            System.out.println("File not found error! - generateWord method");
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Error! - generateWord method");
        }finally {
            scanner.close();
        }
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public GameChecker getGameChecker() {
        return gameChecker;
    }

    public void setGameChecker(GameChecker gameChecker) {
        this.gameChecker = gameChecker;
    }
}

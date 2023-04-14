package printers;

import java.util.List;

public class WordStatePrinter {
    public boolean printWordState(String word, List<Character> playerGuesses) {
        int correctCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (playerGuesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                correctCount++;
            }
            else {
                System.out.print("-");
            }
        }

        //we need this to add a next line after the dashes
        System.out.println("\n");

        return (word.length() == correctCount);
    }
}

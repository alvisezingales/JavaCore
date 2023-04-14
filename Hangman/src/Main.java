import functionalities.PlayerGuide;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        PlayerGuide playerGuide = new PlayerGuide();
        Scanner keyboard = new Scanner(System.in);

        playerGuide.readPlayerModeChoise(keyboard);


    }
}

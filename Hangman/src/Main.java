import functionalities.PlayerGuide;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner keyboard = new Scanner(System.in);
        try{
            PlayerGuide playerGuide = new PlayerGuide();
            playerGuide.readPlayerModeChoise(keyboard);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error! - main method [Main class]");
        }
        finally {
            keyboard.close();
        }



    }
}

import functionalities.RPSChecker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        try{
            RPSChecker rpsChecker = new RPSChecker();
            rpsChecker.playRPS(keyboard);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error! - main method [Main class]");
        }finally{
            keyboard.close();
        }
    }
}

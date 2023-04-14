package functionalities;

import java.util.Random;
import java.util.Scanner;

public class RPSChecker {

    private final String WELCOME = "Hi there! Are you ready to play with me?";

    private final String[] RPS = {"rock", "paper", "scissors"};

    private String computerMove;

    private String playerMove;

    private String playAgain;

    public void playRPS(Scanner keyboard){
        System.out.println(WELCOME);
        try{
            while(true){
                computerMove = RPS[new Random().nextInt(RPS.length)];

                while (true) {
                    System.out.println("Please enter your move (rock, paper, scissors):");
                    playerMove = keyboard.nextLine();
                    if (playerMove.equals("rock") || playerMove.equals("paper") || playerMove.equals("scissors")) {
                        break;
                    }
                    System.out.println(playerMove + " is not a valid move.");
                }

                System.out.println("### Computer played: " + computerMove + " ###");
                System.out.println("### You have played: " + playerMove + " ###");

                if (playerMove.equals(computerMove)) {
                    System.out.println("The game was a tie!\n");
                }
                else if (playerMove.equals("rock")) {
                    if (computerMove.equals("paper")) {
                        System.out.println("You lose!\n");
                    }else if (computerMove.equals("scissors")){
                        System.out.println("You win!\n");
                    }
                }
                else if (playerMove.equals("paper")) {
                    if (computerMove.equals("rock")) {
                        System.out.println("You win!\n");
                    } else if (computerMove.equals("scissors")) {
                        System.out.println("You lose!\n");
                    }
                }
                else if (playerMove.equals("scissors")) {
                    if (computerMove.equals("paper")) {
                        System.out.println("You win!\n");
                    } else if (computerMove.equals("rock")) {
                        System.out.println("You lose!\n");
                    }
                }

                System.out.println("Do you want to play again? (y/n)");
                playAgain = keyboard.nextLine();
                System.out.println("\n");

                if(!playAgain.equals("y") && !playAgain.equals("n")){
                    System.out.println("I suppose you don't, see you!");
                    break;
                }else if(playAgain.equals("n")){
                    System.out.println("Well, it was fun. See you!");
                    break;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error!- playRPS method [RPSChecker class]" );
        }finally {
            keyboard.close();
        }
    }

    public String getWELCOME() {
        return WELCOME;
    }

    public String[] getRPS() {
        return RPS;
    }

    public String getComputerMove() {
        return computerMove;
    }

    public void setComputerMove(String computerMove) {
        this.computerMove = computerMove;
    }

    public String getPlayerMove() {
        return playerMove;
    }

    public void setPlayerMove(String playerMove) {
        this.playerMove = playerMove;
    }

    public String getPlayAgain() {
        return playAgain;
    }

    public void setPlayAgain(String playAgain) {
        this.playAgain = playAgain;
    }
}


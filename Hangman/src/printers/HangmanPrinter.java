package printers;

public class HangmanPrinter {

    public void printHangedMan(Integer wrongCount) {

        if (wrongCount == 0) {
            System.out.println("  ________");
            System.out.println("  |     ||");
            System.out.println("        ||");
            System.out.println("        ||");
            System.out.println("        ||");
            System.out.println("        ||\n");

        } else if (wrongCount == 1) {
            System.out.println("  ________");
            System.out.println("  |     ||");
            System.out.println("  O     ||");
            System.out.println("        ||");
            System.out.println("        ||");
            System.out.println("        ||\n");

        } else if (wrongCount == 2) {
            System.out.println("  ________");
            System.out.println("  |     ||");
            System.out.println("  O     ||");
            System.out.println(" /      ||");
            System.out.println("        ||");
            System.out.println("        ||\n");

        } else if (wrongCount == 3) {
            System.out.println("  ________");
            System.out.println("  |     ||");
            System.out.println("  O     ||");
            System.out.println(" / \\    ||");
            System.out.println("        ||");
            System.out.println("        ||\n");

        } else if (wrongCount == 4) {
            System.out.println("  ________");
            System.out.println("  |     ||");
            System.out.println("  O     ||");
            System.out.println(" /|\\    ||");
            System.out.println("        ||");
            System.out.println("        ||\n");

        } else if (wrongCount == 5) {
            System.out.println("  ________");
            System.out.println("  |     ||");
            System.out.println("  O     ||");
            System.out.println(" /|\\    ||");
            System.out.println(" /      ||");
            System.out.println("        ||\n");

        } else if (wrongCount == 6) {
            System.out.println("  ________");
            System.out.println("  |     ||");
            System.out.println("  O     ||");
            System.out.println(" /|\\    ||");
            System.out.println(" / \\    ||");
            System.out.println("        ||\n");
            System.out.println("Last chance, enter the complete word or you will lose!\n");

        } else {
            System.out.println("You have lost!");
        }
    }
}

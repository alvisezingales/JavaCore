import exceptions.FibonacciMismatchException;
import functionalities.FibonacciFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //try-with-resources will automatically close the Closeable/Autocloseable resources
        //declared within the parentheses immediately after the try keyword
        //after the program is finished with them
        //https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
        try(Scanner scanner = new Scanner(System.in);){
            FibonacciFactory fibonacciFactory = new FibonacciFactory();
            fibonacciFactory.welcome();
            int n = scanner.nextInt();
            fibonacciFactory.fibonacciSequenceFactory(n);
        }catch(InputMismatchException inputMismatchException){
            //Why did I do this? Well, I just wanted to throw my personal InputMismatchException, and I tried different ways that didn't work.
            //After some research I understood from https://stackoverflow.com/questions/35415733/how-to-throw-a-customized-inputmismatchexception-java
            //that, looking at the documentation for Scanner.nextInt() [https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html#nextInt%28%29],
            //Scanner.nextInt() throws its own InputMismatchException. Therefore, this Exception is being thrown before my throw code is even reached,
            //and the message from the Exception will be from the nextInt() call itself. That's why I caught the InputMismatchException myself,
            //and simply threw a new InputMismatchException with the message that I wanted it to have.
            //This is a fairly common practice, as sometimes Exception messages don't fit well with the context of the situation.
            //I had so much fun finding this out :D
            FibonacciMismatchException fibonacciMismatchException = new FibonacciMismatchException("Well... that's not a number my friend");
            fibonacciMismatchException.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error! - main method [Main class]");
        }

    }
}

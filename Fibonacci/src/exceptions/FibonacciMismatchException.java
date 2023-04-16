package exceptions;

import java.util.InputMismatchException;

//We'll use this exception when the user will enter a non-numeric value input
//I make it extend RunTimeException because I want it to be an unchecked exception
//it will be an exception that Java will verify at run-time
public class FibonacciMismatchException extends InputMismatchException {

    public FibonacciMismatchException() {
    }

    //we call the constructor of the mother class RuntimeException so that we
    //can use its constructor with the message capabilities
    public FibonacciMismatchException(String s) {
        super(s);
    }

    //Why isn't here a throwable parameter? Because it extends InputMismatchException,
    //if it extended the RuntimeException or Exception class, we could also inherit
    //the constructors with throwable, but we're not. We are instead extending the
    //InputMismatchException. Why so? Because it is better to extend the exception class we know
    //it is the most similar to the one we're implementing.

}

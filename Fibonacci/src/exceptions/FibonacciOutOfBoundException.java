package exceptions;

//We'll use this exception when the user will enter a value greater than 92 as input
//I make it extend RunTimeException because I want it to be an unchecked exception
//it will be an exception that Java will verify at run-time
public class FibonacciOutOfBoundException extends RuntimeException{

    public FibonacciOutOfBoundException() {
    }

    //we call the constructor of the mother class RuntimeException so that we
    //can use its constructor with the message capabilities
    public FibonacciOutOfBoundException(String message) {
        super(message);
    }

    //another constructor offered by the generic Exception class, it takes a message and a throwable as parameters.
    //It is useful in case my custom exception is caused by some other exception, in this case I can pass the throwable
    //of this other exception printing the cause.
    public FibonacciOutOfBoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

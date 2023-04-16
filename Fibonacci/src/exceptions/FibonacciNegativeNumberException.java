package exceptions;

//We'll use this exception when the user will enter a negative value input
//I make it extend RunTimeException because I want it to be an unchecked exception
//it will be an exception that Java will verify at run-time
public class FibonacciNegativeNumberException extends RuntimeException {

    public FibonacciNegativeNumberException() {
    }

    //we call the constructor of the mother class RuntimeException so that we
    //can use its constructor with the message capabilities
    public FibonacciNegativeNumberException(String message) {
        super(message);
    }

    //another constructor offered by the generic Exception class, it takes a message and a throwable as parameters.
    //It is useful in case my custom exception is caused by some other exception, in this case I can pass the throwable
    //of this other exception printing the cause.
    public FibonacciNegativeNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}

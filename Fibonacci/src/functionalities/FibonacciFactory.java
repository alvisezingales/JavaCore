package functionalities;


import exceptions.FibonacciNegativeNumberException;
import exceptions.FibonacciOutOfBoundException;

public class FibonacciFactory {

    //We'll use this array to store all the Fibonacci numbers that we'll calculate,
    //so that they will be ready to use for the future operations.
    //This strategy is called Memoization https://www.geeksforgeeks.org/memoization-1d-2d-and-3d/
    private long[] fibonacciCache;

    private final String WELCOME = "Hello User! This program prints the Fibonacci Sequence's elements!\n"
                                    + "The number you'll specify as input will be the last element "
                                    + "of the sequence to be returned.";

    private final String RULE = "This program can print from the 1st up to the 92th element of the Fibonacci Sequence.\n\n"
                                + "### Please, enter a number from 0 to 92 (this number will be the last printed element of the sequence): ###";


    private final String OBSERVATION = "*** OBSERVATION: This program considers 0 as the first element of the Fibonacci Sequence ***";

    public void welcome(){
        System.out.println(WELCOME);
        System.out.println(RULE);
    }

    //that parameter is the last Fibonacci Sequence's number that our program will return
    public void fibonacciSequenceFactory(int n) {

        try{
            if(n >= 0 && n <= 92){

                fibonacciCache = new long[n + 1];

                System.out.println("\nFibonacci Sequence up to element n°" + n + ":");
                for (int i = 0; i <= n; i++) {
                    //I'll use the switch case to go to a new line for each
                    //set of 10 elements of the sequence, because I just
                    //wouldn't like to have all the numbers in just one line
                    switch(i){
                        case(10):
                            System.out.print("\n  " + fibonacci(i) + " ");
                            break;
                        case(20):
                            System.out.print("\n  " + fibonacci(i) + " ");
                            break;
                        case(30):
                            System.out.print("\n  " + fibonacci(i) + " ");
                            break;
                        case(40):
                            System.out.print("\n  " + fibonacci(i) + " ");
                            break;
                        case(50):
                            System.out.print("\n  " + fibonacci(i) + " ");
                            break;
                        case(60):
                            System.out.print("\n  " + fibonacci(i) + " ");
                            break;
                        case(70):
                            System.out.print("\n  " + fibonacci(i) + " ");
                            break;
                        case(80):
                            System.out.print("\n  " + fibonacci(i) + " ");
                            break;
                        case(90):
                            System.out.print("\n  " + fibonacci(i) + " ");
                            break;
                        default:
                            System.out.print("  " + fibonacci(i) + " ");
                    }
                }

                if(fibonacci(n) == 0){
                    System.out.println("\n\n-> " + n + " is the 1st element of the Fibonacci Sequence");
                }else if(fibonacci(n) == 1 && fibonacci(n -1) == 0){
                    System.out.println("\n\n-> " + n + " is the 2nd element of the Fibonacci Sequence");
                }else if(fibonacci(n) == 1 && fibonacci(n -1) == 1){
                    System.out.println("\n\n-> " + n + " is the 3rd element of the Fibonacci Sequence");
                }else{
                    System.out.println("\n\n-> " + fibonacci(n) + " is the " + n + "th element of the Fibonacci Sequence");
                    System.out.println(OBSERVATION);
                }
            }else if(n > 92){
                throw new FibonacciOutOfBoundException("This program uses long types, it can calculate up to the 92th element of the Fibonacci Sequence", new RuntimeException());
            }else if(n < 0){
                throw new FibonacciNegativeNumberException("You can only enter a value from 0 to 92, negative numbers are not valid", new RuntimeException());
            }

        }catch(FibonacciOutOfBoundException fibonacciOutOfBoundException){
            fibonacciOutOfBoundException.printStackTrace();
        }catch(FibonacciNegativeNumberException fibonacciNegativeNumberException){
            fibonacciNegativeNumberException.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public long fibonacci(int n) {
        //we need to hardcode the base cases: f(0) = 0, f(1) = 1
        if (n <= 1) {
            return n;
        }

        //we're using primitives, a primitive long will have 0 as default
        //(primitives don't have "null" as default value, they have 0 instead).
        //This if condition means that if we look at the array
        //and the nth element of that array isn't zero
        //(meaning that it has a value that is not the default one) then
        //it means that it has already been found before and stored.
        //It means that it exists in the cache we built,
        //so we can take it and use it to speed the operations up
        if (fibonacciCache[n] != 0) {
            return fibonacciCache[n];
        }

        long nthFibonacciNumber = (fibonacci(n - 1) + fibonacci(n - 2));
        fibonacciCache[n] = nthFibonacciNumber;

        return nthFibonacciNumber;
    }

    public long[] getFibonacciCache() {
        return fibonacciCache;
    }

    public void setFibonacciCache(long[] fibonacciCache) {
        this.fibonacciCache = fibonacciCache;
    }
}

package _000extraFibonacciExercise;

public class MyFirstFibonacciExercise {

    //write a program that prints the elements of the Fibonacci Sequence up to the 10th element

    //0, 1, 1, 2, 3, 5, 8, 13, 21,    -> 34 <-    , 55, 89, 144,...

    public void printFibonacciUpTo10thElement(){

        int j = 0, k = 1, fibonacci;

        for(int i = 0; i <10; i++){
            if(i<=1){
                fibonacci = i;
            }else{
                fibonacci = j + k;
                j = k;
                k = fibonacci;
            }
            System.out.print(fibonacci + " ");
        }
    }

}

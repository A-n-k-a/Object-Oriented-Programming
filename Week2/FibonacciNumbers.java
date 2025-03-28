package Week2;

public class FibonacciNumbers {
    // The first two numbers of the Fibonacci sequence are 0 and 1 and its successive term is the sum of the previous two. Thus the sequence starts 0, 1, 1, 2, 3, 5, 8, 13,… Write a program that creates an array of 20 numbers and fills it with the first 20 Fibonacci numbers, finally the program should display all the numbers in the array.
    public static void main(String[] args) {
        int[] fibonacci = new int[20];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i < fibonacci.length; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        /*for (int j : fibonacci) {
            System.out.println(j);
        }*/
        for (int i = 0; i < fibonacci.length; i++) {
            System.out.print(fibonacci[i] + " ");
        }
    }
}

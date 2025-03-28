package Week2;
import java.util.Scanner;
public class Average {
    // a program that asks the user for a set of numbers and displays the average. The program keeps reading numbers until number 0 is inputted. You do not need to store the numbers
    public static void main(String[] args) {
        System.out.println("Please enter a set of numbers. Enter 0 to finish.");
        Scanner keyboard = new Scanner(System.in);
        double number = 1;
        double sum = 0;
        int count = 0;
        while (number != 0) {
            number = keyboard.nextDouble();
            if (number != 0) {
                sum += number;
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No numbers were entered.");
        } else {
            double average = sum / count;
            System.out.println("The average is " + average);
        }
    }
}

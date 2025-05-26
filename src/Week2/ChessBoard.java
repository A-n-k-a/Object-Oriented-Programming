package Week2;
import java.util.Scanner;
public class ChessBoard {
    // Each square in a chess board can be described by a letter and a number (e.g. a4).
    // Write a program in java that asks the user for a letter and a number shows whether the square will be white or black.
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a letter:");
        // String letter = keyboard.next();
        char letter = keyboard.next().charAt(0);
        System.out.println("Please enter a number:");
        int number = keyboard.nextInt();
        if (letter >= 'a' && letter <= 'h' && number >= 1 && number <= 8) { // (letter.equals("a") || letter.equals("b") || letter.equals("c") || letter.equals("d") || letter.equals("e") || letter.equals("f") || letter.equals("g") || letter.equals("h")) {
            System.out.println((letter - 'a' + number));
            if ((letter - 'a' + number) % 2 == 0) {
                System.out.println("The square is black.");
            } else {
                System.out.println("The square is white.");
            }
        } else {
            System.out.println("Invalid input.");
        }
        keyboard.close();
    }
}

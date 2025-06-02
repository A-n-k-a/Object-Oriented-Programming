package Week2;
import java.util.Scanner;

public class SwitchDemo {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int number1, number2, choice; // To hold keyboard input
        System.out.println("Please enter number1:");
        number1 = keyboard.nextInt();
        System.out.println("Please enter number2:");
        number2 = keyboard.nextInt();
        System.out.println("Please enter 1 for addition, 2 for subtraction, 3 for multiplication, 4 for division:");
        choice = keyboard.nextInt();

        switch (choice) {
            case 1:
                System.out.println("The result is " + (number1 + number2));
                break;
            case 2:
                System.out.println("The result is " + (number1 - number2));
                break;
            case 3:
                System.out.println("The result is " + (number1 * number2));
                break;
            case 4:
                System.out.println("The result is " + (number1 / number2));
                break;
            // case 5:
            //     System.out.println("You entered 5");
            //     break;
            default:
                System.out.println("Incorrect answer");
        }
        keyboard.close();
    }
}

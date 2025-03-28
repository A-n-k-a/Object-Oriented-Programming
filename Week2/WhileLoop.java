package Week2;
import java.util.Scanner;
public class WhileLoop {
    public static void main(String[] args) {
        /*
        Initialise a year counter to 0   
        Initialise the balance of the account to the initial value   
        While the balance of the account is less than 1000000   
        Add one to the year   
        Add interest to the balance   
        Display the final year value to the user   
         */
        int yearCount = 0;
        Scanner Balance = new Scanner(System.in);
        System.out.println("Please enter the initial balance of the account:");
        double AccoutBalance = Balance.nextDouble();
        while (AccoutBalance <= 1000000.00){
            yearCount ++;
            AccoutBalance = AccoutBalance * 1.05;
        }
        System.out.println("It will take " + yearCount + " years to reach 1 million dollars.");
        Balance.close();
    }
}

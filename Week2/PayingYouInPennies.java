package Week2;

public class PayingYouInPennies {
    // a program that calculates the money that you would earn at the end of the month if you are paid 1p in the first day, 2p the second day, 4p the third day, 8 p the fourth day and continue every day by doubling the previous day’s salary. Display the salary each day and the total amount at the end of the month. The output should be in pounds and not pennies.
    public static void main(String[] args) {
        double salary = 1; // 1 penny
        double total = 0;
        for (int i = 1; i <= 30; i++) {
            System.out.println("Day " + i + ": " + salary / 100 + " pounds");
            total += salary;
            salary *= 2; // double the salary for the next day
        }
        System.out.println("Total amount at the end of the month: " + total / 100 + " pounds");
    }
}

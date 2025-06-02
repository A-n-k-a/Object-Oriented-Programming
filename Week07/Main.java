package Week7;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void printShape(Rectangle rectangle) {
        System.out.println("Area is " + rectangle.getArea());
        System.out.println("Perimeter is " + rectangle.getPerimeter());
    }

    public static void printCircle(Circle circle) {
        System.out.println("Area is " + circle.getArea());
        System.out.println("Perimeter is " + circle.getPerimeter());
    }

    public static void menu() {
        System.out.println("Options are: ");
        System.out.println("1: Add a Rectangle");
        System.out.println("2: Add a Circle");
        System.out.println("3: Display information about a Rectangle");
        System.out.println("4: Display information about a Circle");
        System.out.println("0: Stop");
    }

    public static void main(String[] args) {
        ArrayList<Rectangle> myRectangles = new ArrayList<>();
        ArrayList<Circle> myCircles = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        int option = 1;
        while (option != 0) {
            menu();
            System.out.print("Enter your option ");
            option = input.nextInt();
            switch (option) {
                case 1:
                    System.out.println("1: Add a Rectangle");
                    System.out.print("Enter width ");
                    double width = input.nextDouble();
                    System.out.print("Enter length ");
                    double length = input.nextDouble();
                    myRectangles.add(new Rectangle(width, length));
                    break;
                case 2:
                    System.out.println("2: Add a circle");
                    //You need to implement the code that will add circles
                    //System.out.println("NOT IMPLEMENTED YET!");
                    System.out.print("Enter radius ");
                    double radius = input.nextDouble();
                    myCircles.add(new Circle(radius));
                    break;
                case 3:
                    System.out.println("3: Display area and perimeter of a Rectangle by position");
                    System.out.print("Enter the position ");
                    printShape(myRectangles.get(input.nextInt()));
                    break;
                case 4:
                    System.out.println("4: Display area and perimeter of a Circle by position");
                    //You need to implement the code that will add circles
                    //System.out.println("NOT IMPLEMENTED YET!");
                    System.out.print("Enter the position ");
                    printCircle(myCircles.get(input.nextInt()));
                    break;
                case 0:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Wrong option");
            }
        }
    }
}

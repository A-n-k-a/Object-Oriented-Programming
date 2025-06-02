package Week7;
import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void printShape(AbstractShape shape) {
        System.out.println("Area is " + shape.getArea());
        System.out.println("Perimeter is " + shape.getPerimeter());
        System.out.println("Position is " + shape.getX() + ", " + shape.getY());
    }

    public static void menu() {
        System.out.println("Options are: ");
        System.out.println("1: Add a Rectangle");
        System.out.println("2: Add a Circle");
        System.out.println("3: Display information about a Shape");
        System.out.println("4: Move a Shape to a new position");
        System.out.println("5: Scale a Shape by a factor");
        System.out.println("0: Stop");
    }

    public static void main(String[] args) {
        ArrayList<AbstractShape> myShapes = new ArrayList<>();
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
                    myShapes.add(new Rectangle2(width, length));
                    break;
                case 2:
                    System.out.println("2: Add a circle");
                    //You need to implement the code that will add circles
                    //System.out.println("NOT IMPLEMENTED YET!");
                    System.out.print("Enter radius ");
                    double radius = input.nextDouble();
                    myShapes.add(new Circle2(radius));
                    break;
                case 3:
                    System.out.println("3: Display area and perimeter of a Rectangle by position");
                    System.out.print("Enter the position ");
                    printShape(myShapes.get(input.nextInt()));
                    break;
                case 4:
                    System.out.println("4: Move a Shape to a new position");
                    System.out.print("Enter the position ");
                    int pos = input.nextInt();
                    System.out.print("Enter new X ");
                    double newX = input.nextDouble();
                    System.out.print("Enter new Y ");
                    double newY = input.nextDouble();
                    myShapes.get(pos).move(newX, newY);
                    break;
                case 5:
                    System.out.println("5: Scale a Shape by a factor");
                    System.out.print("Enter the position ");
                    int pos2 = input.nextInt();
                    System.out.print("Enter scale factor ");
                    double scaleFactor = input.nextDouble();
                    myShapes.get(pos2).scale(scaleFactor);
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

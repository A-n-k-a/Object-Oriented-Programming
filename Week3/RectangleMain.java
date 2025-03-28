package Week3;
import java.util.Scanner;
import java.util.ArrayList;

public class RectangleMain {
    public static void main(String[] args) {
        Rectangle box = new Rectangle(15, 12);
        System.out.println("Length: " + box.length);
        System.out.println("Width: " + box.width);
        box.setLength(30);
        box.setWidth(24);
        System.out.println("Area: " + box.getArea());
        System.out.println("Perimeter: " + box.getPerimeter());
        Rectangle defaultBox = new Rectangle();
        System.out.println("Default Length: " + defaultBox.getLength());
        System.out.println("Default Width: " + defaultBox.getWidth());
        System.out.println("Default Area: " + defaultBox.getArea());
        System.out.println("Default Perimeter: " + defaultBox.getPerimeter());
        ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rectangles you want to create:");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter length for rectangle " + (i + 1) + ":");
            int length = scanner.nextInt();
            System.out.println("Enter width for rectangle " + (i + 1) + ":");
            int width = scanner.nextInt();
            Rectangle rect = new Rectangle(length, width);
            rectangles.add(rect);
        }
        int allArea = 0;
        for (int i = 0; i < rectangles.size(); i++) {
            Rectangle rect = rectangles.get(i);
            System.out.println("Rectangle " + (i + 1) + "'s area:");
            System.out.println(rect.getArea());
            allArea += rect.getArea();
        }
        System.out.println("All rectangles' area:");
        System.out.println(allArea);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Week8.bounceboxapp;

import Week8.bouncebox.BounceBox;
import Week8.bouncebox.Circle;
import Week8.bouncebox.Square;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author ashongtical
 */
public class Main {

    /**
     * @param args the command line arguments
     */

            
    public static void main(String[] args) throws FileNotFoundException {

        //setUpDemo1(); //Call static method setUpDemo1 directly.

        //For practical exercises, comment out the line above, and uncomment the one below
        
        //simpleDemo();
        addShapes_ex5();
    }
    
    
    
    public static void setUpDemo1() {
        BounceBox box = new BounceBox(700,500);
        
		//Create instance of Circle
        Circle c1 = new Circle(20,50,20);
//        c1.setColor(Color.BLUE);
        c1.setColor(new Color(102, 204, 255, 255));
        c1.setVelocity(100, 0);
                
        Circle c2 = new Circle(300,50,20);
        c2.setColor(Color.CYAN);
        Circle c3 = new Circle(360,50,20);
        c3.setColor(Color.MAGENTA);
        Circle c4 = new Circle(420,50,20);
        c4.setColor(Color.ORANGE);
        Circle c5 = new Circle(480,50,20);
        c5.setColor(Color.PINK);
        Circle c6 = new Circle(540,50,20);
        c6.setColor(Color.RED);
        Circle c7 = new Circle(400,440,40);
        c7.setColor(Color.CYAN);
        c7.setVelocity(30, 30);
        
        Circle c8 = new Circle(300,440,40);
        c8.setColor(Color.BLUE);
        c8.setVelocity(30, 20);
        
        Circle c9 = new Circle(500,440,40);
        c9.setColor(Color.GREEN);
        c9.setVelocity(-20, 30);

        Circle c10 = new Circle(120,50,20);
        c10.setColor(Color.CYAN);
        Circle c11 = new Circle(180,50,20);
        c11.setColor(Color.ORANGE);
        Circle c12 = new Circle(240,50,20);
        c12.setColor(Color.PINK);
        
        Square s1 = new Square(120,120,40);
        s1.setColor(Color.BLUE);
        s1.setVelocity(30, 20);
        
        Square s2 = new Square(240,120,40);
        s2.setColor(Color.GREEN);
        s2.setVelocity(-20, 30);
        
        //Add shape to bouncebox
        box.addShape(c1); 
        box.addShape(c2);
        box.addShape(c3); 
        box.addShape(c4);
        box.addShape(c5);
        box.addShape(c6);
        box.addShape(c7);
        box.addShape(c8);
        box.addShape(c9);
        box.addShape(c10);
        box.addShape(c11);
        box.addShape(c12);
        
        box.addShape(s1);
        box.addShape(s2);
        
		//Start bouncebox
        box.start();
    }
    
    public static void simpleDemo() {
        //Implement this as exercise 2
        BounceBox box = new BounceBox(700,500);
        Circle c1 = new Circle(40,50,40);
        c1.setColor(Color.BLUE);
        c1.setVelocity(100, 0);
        Square s1 = new Square(560,50,45);
        s1.setColor(Color.RED);
        s1.setVelocity(-100, 0);
        box.addShape(c1);
        box.addShape(s1);
        box.start();
    }

    public static void addShapes_ex3() throws FileNotFoundException {
        // creates black circles by reading from a text file(ex3.txt) in which each circle is described by 5 integers
        // x y r vx vy
        // where x and y are the coordinates of the circle, r is its radius and vx and vy are the coordinates of its velocity.
        FileInputStream fileIn = new FileInputStream("[中英]Object Oriented Programming/Week8/ex3.txt");
        Scanner sc = new Scanner(fileIn);
        BounceBox box = new BounceBox(700,500);
        while (sc.hasNext()) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int r = sc.nextInt();
            int vx = sc.nextInt();
            int vy = sc.nextInt();
            Circle c1 = new Circle(x,y,r);
            c1.setColor(Color.BLACK);
            c1.setVelocity(vx, vy);
            box.addShape(c1);
        }
        box.start();
    }

    public static void addShapes_ex4() throws FileNotFoundException {
        // creates black shapes by reading from a text file(ex4.txt) in which each shape is described like this:
        // Circle x y r vx vy
        // Square x y w vx vy
        // where x and y are the coordinates of the shape, r is its radius or w is its width and vx and vy are the coordinates of its velocity.
        FileInputStream fileIn = new FileInputStream("[中英]Object Oriented Programming/Week8/ex4.txt");
        Scanner sc = new Scanner(fileIn);
        BounceBox box = new BounceBox(700,500);
        while (sc.hasNext()) {
            String shapeType = sc.next();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int rOrW = sc.nextInt();
            int vx = sc.nextInt();
            int vy = sc.nextInt();
            if (shapeType.equalsIgnoreCase("Circle")) {
                Circle c1 = new Circle(x,y,rOrW);
                c1.setColor(Color.BLACK);
                c1.setVelocity(vx, vy);
                box.addShape(c1);
            } else if (shapeType.equalsIgnoreCase("Square")) {
                Square s1 = new Square(x,y,rOrW);
                s1.setColor(Color.BLACK);
                s1.setVelocity(vx, vy);
                box.addShape(s1);
            }
        }
        box.start();
    }

    public static void addShapes_ex5() throws FileNotFoundException {
        // modify the code in addShapes_ex4() to read from a text file(ex5.txt) and let the integers defining the velocity are optional. If they are not present, then the shape is assumed to be stationary.
        // The file ex5.txt should look like this:
        // Circle x y r
        // Circle x y r vx vy
        // Square x y w
        // Square x y w vx vy
        FileInputStream fileIn = new FileInputStream("[中英]Object Oriented Programming/Week8/ex5a.txt");
        Scanner sc = new Scanner(fileIn);
        BounceBox box = new BounceBox(700,500);
        while (sc.hasNext()) {
            String shapeType = sc.next();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int rOrW = sc.nextInt();
            Circle c1;
            Square s1;
            if (shapeType.equalsIgnoreCase("Circle")) {
                if (sc.hasNextInt()) {
                    int vx = sc.nextInt();
                    int vy = sc.nextInt();
                    c1 = new Circle(x,y,rOrW);
                    c1.setColor(Color.BLACK);
                    c1.setVelocity(vx, vy);
                } else {
                    c1 = new Circle(x,y,rOrW);
                    c1.setColor(Color.BLACK);
                }
                box.addShape(c1);
            } else if (shapeType.equalsIgnoreCase("Square")) {
                if (sc.hasNextInt()) {
                    int vx = sc.nextInt();
                    int vy = sc.nextInt();
                    s1 = new Square(x,y,rOrW);
                    s1.setColor(Color.BLACK);
                    s1.setVelocity(vx, vy);
                } else {
                    s1 = new Square(x,y,rOrW);
                    s1.setColor(Color.BLACK);
                }
                box.addShape(s1);
            }
        }
        sc.close();
        box.start();
    }
}

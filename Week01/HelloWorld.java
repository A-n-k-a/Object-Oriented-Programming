package Week1;
import java.util.Scanner;
public class HelloWorld
{public static void main(String[] args)
    {
        System.out.println("Hello World"); //sout+tab键
        System.out.println(0.0 / 0.0); // NaN
        System.out.println(1.0 / 0.0); // Infinity
        System.out.println(-1.0 / 0.0); // -Infinity
        // 请将下面一组int值视为字符的Unicode码，把它们拼成一个字符串：
        int a = 72;
        int b = 105;
        int c = 65281;
        System.out.println("" + (char) a + (char) b + (char) c); //注意：加号两边只要有一个是字符串，Java编译器会把另一个自动转型为字符串，否则为数字相加（72+105+65281=65458）
        /* 
        Scanner sc = new Scanner(System.in); // 创建Scanner对象，接收输入
        int x = sc.nextInt(); // 读取整数
        System.out.println(x);
        sc.close(); // 关闭Scanner对象
        */
        
        // Q3
        // ...

        // Q4
        Scanner keyboard = new Scanner(System.in);
        int width, height, area;
        width = keyboard.nextInt();
        height = keyboard.nextInt();
        area = width * height;
        System.out.println(area);
        keyboard.close();

        // Q5
        Scanner keyboard2 = new Scanner(System.in);
        double tmpC, tmpF;
        System.out.println("Please input the temperature in Celsius:");
        tmpC = keyboard2.nextDouble();
        tmpF = tmpC * 9 / 5 + 32;
        System.out.println("The temperature in Fahrenheit is:");
        System.out.println(tmpF);
        keyboard2.close();

        // Q6
        Scanner keyboard3 = new Scanner(System.in);
        int inputNumber = keyboard3.nextInt();
        if (inputNumber % 2 == 0 && inputNumber > 0) {
            System.out.println("Positive even number");
        } else if (inputNumber % 2 == 0 && inputNumber < 0) {
            System.out.println("Negative even number");
        } else if (inputNumber % 2 != 0 && inputNumber > 0) {
            System.out.println("Positive odd number");
        } else if (inputNumber % 2 != 0 && inputNumber < 0) {
            System.out.println("Negative odd number");
        } else {
            System.out.println("Zero");
        }
        keyboard3.close();

        // Q7: Write a program that inputs a temperature and tells the user if the water will be ice, liquid or gas at that temperature.
        Scanner keyboard4 = new Scanner(System.in);
        double temperature = keyboard4.nextDouble();
        if (temperature < 0) {
            System.out.println("Ice");
        } else if (temperature >= 0 && temperature < 100) {
            System.out.println("Liquid");
        } else {
            System.out.println("Gas");
        }
        keyboard4.close();

        // Q8: Using a switch statement write a program that asks the user for the number of a day of the week (1 for Monday, 2 for Tuesday…) and displays the name of that day. The program should print an error message if the number entered by the user is not between 1 and 7.
        Scanner keyboard5 = new Scanner(System.in);
        int day = keyboard5.nextInt();
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Error");
                break;
        }
        keyboard5.close();

        //Q9: Write a program that asks the user for a radius, and calculates the area of a circle with this radius and the volume of a sphere with that radius. The constant Pi is available as Math. PI. The program should check that the input by the user is a positive number.
        Scanner keyboard6 = new Scanner(System.in);
        double radius = keyboard6.nextDouble();
        if (radius <= 0) {
            System.out.println("Error");
        } else {
            double areaCircle = Math.PI * radius * radius;
            double volumeSphere = 4.0 / 3.0 * Math.PI * radius * radius * radius;
            System.out.println(areaCircle);
            System.out.println(volumeSphere);
        }
        keyboard6.close();

        //Q10: Write a program that receives the length of the two sides of a rectangle (a2 and b2) and calculates the diagonal (d)
        Scanner keyboard7 = new Scanner(System.in);
        double a2 = keyboard7.nextDouble();
        double b2 = keyboard7.nextDouble();
        double d = Math.sqrt(a2 * a2 + b2 * b2);
        System.out.println(d);
        keyboard7.close();
    }
}
// 单行注释
/* 多行注释 */
/*
 * 多行注释
 * 多行注释
 */
/** 文档注释 */
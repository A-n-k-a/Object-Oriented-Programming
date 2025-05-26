package Week2;
import java.util.Random;
public class TheMarksOfStudents {
//    The marks of 20 students are stored in an array called marks. Initialise the array with 20 marks (numbers from 0 to 100).
//    Write a program that calculates and displays:
//    The average mark,
//    The highest mark and the lowest and the number of students that have got those marks.
//    The number of students that have passed the course (marks >= 40%)
//    You can initialise the array at the time of the declaration (or use class Random)
    public static void main(String[] args) {
//        int[] marks = {45, 78, 56, 89, 34, 67, 90, 23, 45, 67, 89, 12, 34, 56, 78, 90, 100, 45, 67, 89};
        int[] marks = new int[20];
        Random random = new Random();
        for (int i = 0; i < marks.length; i++) {
            marks[i] = random.nextInt(101); // Generates a random number between 0 and 100
        }
        int sum = 0;
        int highestMark = marks[0];
        int lowestMark = marks[0];
        int passCount = 0;

        for (int mark : marks) {
            sum += mark;
            if (mark > highestMark) {
                highestMark = mark;
            }
            if (mark < lowestMark) {
                lowestMark = mark;
            }
            if (mark >= 40) {
                passCount++;
            }
        }

        double average = (double) sum / marks.length;

        System.out.println("Average mark: " + average);
        System.out.println("Highest mark: " + highestMark);
        System.out.println("Lowest mark: " + lowestMark);
        System.out.println("Number of students that passed: " + passCount);
    }
}

package Week2;
import java.util.ArrayList; // ArrayList 的长度是动态的，可以根据需要增加或减少
public class ArraysOfNumbers {
    // initialise an array with 10 integer numbers and write code that displays to the user the numbers in the array that are multiple of 3 and smaller than 100.
    public static void main(String[] args) {
        int[] intArray = {1, 21, 3, 4, 5, 60, 7, 8, 100, 120}; //or int[] intArray = new int[] {1, 21, 3, 4, 5, 60, 7, 8, 100, 120};
        /*for (int j : intArray) {
            if (j % 3 == 0 && j < 100) {
                System.out.println(j);
            }
        }*/
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] % 3 == 0 && intArray[i] < 100) {
                System.out.println(intArray[i]);
            }
        }
    }
}

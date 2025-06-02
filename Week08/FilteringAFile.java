package Week8;
import java.io.*;
import java.util.Scanner;
//The *Scanner* class can be used to divide an input stream into *tokens* separated by *white space*.
//White space means space characters, tabs, and new lines.
//A token is any sequence of characters that does not contain any white space.
//If one token only contains numbers, it can be converted to an integer or a double (or float, something like that).
public class FilteringAFile {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cScan = new Scanner(System.in);
        System.out.print("Input file ? ");
        String inFile = cScan.nextLine();
        FileInputStream fileInput = new FileInputStream(inFile);
        Scanner fScan = new Scanner(fileInput);
        System.out.print("Output file ? ");
        String outFile = cScan.nextLine();
        PrintWriter fileOutput = new PrintWriter(outFile);
        System.out.print("String to search for ? ");
        String findStr = cScan.nextLine();
        while (fScan.hasNextLine()) {
            String line = fScan.nextLine();
            if (line.contains(findStr)){
                fileOutput.println(line);
            }
        }
        fileOutput.close();
    }
}
//Scanner Methods:
//If scan is a Scanner object then…
//scan.next() returns the next token in the input stream (as a String).
//scan.hasNext() is a boolean valued method that returns true if another token can be read from the input stream.
//scan.hasNextInt() is also boolean and returns true if another token can be read from the input stream and this token can be interpreted as an integer
//scan.nextInt() returns the next token as an integer.
package Week8;
import java.io.*;
import java.util.Scanner;
public class CopyingAFile {
    public static void main(String[] args) throws FileNotFoundException {
        //We don’t want to handle (catch) the exception so the main method must throw it.
        Scanner streamInput = new Scanner(System.in); //‘Built in’ standard input stream
        FileInputStream fileIn = new FileInputStream("infile.txt");
        //The operation above may generate a FileNotFoundException
        Scanner scan = new Scanner(fileIn); //File input stream
        System.out.println("Hello world"); //Built in standard output stream
        PrintWriter fileOut = new PrintWriter("outfile.txt");
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            fileOut.println(line); //File output stream
            //This does not necessarily transfer data to disc.
            System.out.println(line); //Built in standard output stream
        }
        fileOut.close(); //Make sure that all output is ‘flushed’ to disc.
    }
}

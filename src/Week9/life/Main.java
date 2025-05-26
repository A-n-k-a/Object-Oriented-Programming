/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Week9.life;

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
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Game game = new Game(70,70);
        readFromFile(game, "[中英]Object Oriented Programming/Week9/cells_0.txt");
        Display display = new Display(game, 10,100);
        display.start();
    }
    
    public static void readFromFile(Game game, String file) throws FileNotFoundException {
        FileInputStream fileIn = new FileInputStream(file);
        Scanner scan = new Scanner(fileIn);
        while(scan.hasNextInt()) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            game.makeCellLive(x, y);
        }
    }
}

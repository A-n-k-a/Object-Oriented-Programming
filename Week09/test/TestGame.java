/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Week9.test;

import Week9.life.Game;

import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author ashongtical
 */
public class TestGame {

    private static Game game = new Game(70, 70);

    public static void main(String[] args) {

        //create a horizontal blinker
        game.makeCellLive(10, 10);
        game.makeCellLive(10, 11);
        game.makeCellLive(10, 12);
        //move through one generation
        game.newGeneration();
        ArrayList<Point>  newCells = game.getLiveCells();
        ArrayList<Point> expected = new ArrayList<>();
        expected.add(new Point(9,11));
        expected.add(new Point(10,11));
        expected.add(new Point(11,11));
      
        //check that the horizontal blinker has turned into a vertical one
        assertEqual(newCells, expected);
    }

    private static void assertEqual(ArrayList<Point>actual,ArrayList<Point> expected) {
        if (actual.size() != expected.size()) {
            System.out.println("TEST FAILED!!!: WRONG NUMBER OF CELLS");
        } else {
            for (int i = 0; i < actual.size(); i++) {
                System.out.println("Point " + i + "=" + actual.get(i));
                if (!actual.get(i).equals(expected.get(i))) {
                    System.out.println("TEST FAILED!!!");
                }
            }
        }

    }
}

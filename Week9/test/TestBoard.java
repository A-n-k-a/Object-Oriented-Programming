/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Week9.test;

import Week9.life.Board;

import java.awt.*;
import java.util.ArrayList;


public class TestBoard {

    private static Board board = new Board(70, 70);

    public static void main(String[] args) {
        board.makeCellLive(10, 15);
        board.makeCellLive(30, 30);

        testGetCell(10, 15, true);
        testGetCell(15, 10, false);
        testGetCell(30, 30, true);
        testGetCell(40, 40, false);

        ArrayList<Point>expected = new ArrayList<>();
        expected.add(new Point(10, 15));
         expected.add(new Point(30, 30));
      
        testGetLiveCells(expected);
    }

    private static void testGetCell(int col, int row, boolean expectedResult) {
        System.out.println("=======================");
        boolean actualResult = board.getCell(col, row);
        System.out.println("Value of cell (" + col + "," + row
                + ") = " + actualResult);
        if (actualResult != expectedResult) {
            System.out.println("TEST FAILED!!!!!!");
        }
        System.out.println("=======================");
    }

    private static void testGetLiveCells(ArrayList<Point> expected) {
        System.out.println("=======================");
        ArrayList<Point> actual = board.getLiveCells();
        System.out.println("Nbr of live cells = " + actual.size());
        if (actual.size() != expected.size()) {
            System.out.println("TEST FAILED!!!");
        } else {
            for (int i = 0; i < actual.size(); i++) {
                System.out.println("Point i = " + actual.get(i));
                if (!actual.get(i).equals(expected.get(i))) {
                    System.out.println("TEST FAILED!!!");
                }
            }
        }
        System.out.println("=======================");
    }
}
 
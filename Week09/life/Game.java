package Week9.life;

import java.awt.*;
import java.util.ArrayList;
public class Game {

    private int width, height;
    private Board currentBoard, oldBoard;

    public Game(int width, int height) {
        this.width = width;
        this.height = height;
        currentBoard = new Board(width, height);
        oldBoard = new Board(width, height);
    }
    public void makeCellLive(int x, int y) {
        currentBoard.makeCellLive(x, y);
    }
    public ArrayList<Point> getLiveCells() {
        return currentBoard.getLiveCells();
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public void newGeneration() {
        Board temp = oldBoard;
        oldBoard = currentBoard;
        currentBoard = temp;
        currentBoard.clear();

        for (int x = 0; x < width; x++) {
            for (int y = 0;y < height; y++) {
                int nl = getNbrLivingNeighbours(x, y);
                if (oldBoard.getCell(x, y)
                        && (nl == 2 || nl == 3)) {
                    currentBoard.makeCellLive(x, y);
                }
                if (!oldBoard.getCell(x, y) && nl == 3) {
                    currentBoard.makeCellLive(x, y);
                }
            }
        }
    }
    // Continuing the Game class...
    private int getNbrLivingNeighbours(int x, int y) {
        int total = 0;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx != 0 || dy != 0) {
                    if (inBounds(x + dx, y + dy)
                            && oldBoard.getCell(x + dx, y + dy)) {
                        total++;
                    }
                }
            }
        }
        return total;
    }
    private boolean inBounds(int x, int y) {
        return x >= 0 && y >= 0 && x < width && y < height;
    }
}
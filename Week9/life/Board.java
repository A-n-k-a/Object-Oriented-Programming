package Week9.life;
import java.awt.*;
import java.util.ArrayList;
public class Board {
    private int width, height;
    private boolean[][] cells;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        cells = new boolean[width][height];
    }

    public void clear() {
        cells = new boolean[width][height];
    }

    public boolean getCell(int x, int y) {
        return cells[x][y];
    }

    public void makeCellLive(int x, int y) {
        cells[x][y] = true;
    }
    public ArrayList<Point>  getLiveCells(){
        ArrayList<Point>  liveCells = new ArrayList<>();
        int i = 0;
        for (int x = 0; x < width ; x++) {
            for (int y = 0; y < height; y++) {
                if (cells[x][y]) {
                    liveCells.add(new Point(x, y));
                }
            }
        }
        return liveCells;
    }
}

package Week9.life;
import java.awt.*;
import java.util.ArrayList;

public class Board2 {
    private int width, height;
    private ArrayList<Point> LiveCells;

    public Board2(int width, int height) {
        this.width = width;
        this.height = height;
        LiveCells = new ArrayList<>();
    }

    public void clear() {
        LiveCells.clear();
    }

    public boolean getCell(int x, int y) {
        for (Point p : LiveCells) {
            if (p.x == x && p.y == y) {
                return true;
            }
        }
        return false;
    }

    public void makeCellLive(int x, int y) {
        if (!getCell(x, y)) {
            LiveCells.add(new Point(x, y));
        }
    }
    public ArrayList<Point>  getLiveCells(){
        ArrayList<Point>  liveCells = new ArrayList<>();
        int i = 0;
        for (int x = 0; x < width ; x++) {
            for (int y = 0; y < height; y++) {
                if (getCell(x, y)) {
                    liveCells.add(new Point(x, y));
                }
            }
        }
        return liveCells;
    }
}

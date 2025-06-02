/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Week9.life;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 *
 * @author ashongtical
 */
public class Display {

    private final JFrame frame = new JFrame("Life");
    private final JPanel panel;
    private final int cellSize;
    private final int genTime;
    private final Game game;
    private final Timer timer;

    public Display(Game game, int cellSize, int genTime) {
        this.cellSize = cellSize;
        this.genTime = genTime;
        this.game = game;
        panel = new LifePanel();
        panel.setPreferredSize(new Dimension(cellSize * game.getWidth(),
                cellSize * game.getHeight()));

        timer = new Timer(genTime, (ActionEvent e) -> {
            Display.this.game.newGeneration();
            Display.this.frame.repaint();
        });
        

        frame.setContentPane(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void start() {
        timer.start();
    }


    private class LifePanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            int width = game.getWidth();
            int height = game.getHeight();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, cellSize * width, cellSize * height);

            g.setColor(Color.BLACK);
            ArrayList<Point> liveCells = game.getLiveCells();
            for (Point liveCell : liveCells) {
                int x = liveCell.x;
                int y = liveCell.y;
                g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
            }
        }
    }
}

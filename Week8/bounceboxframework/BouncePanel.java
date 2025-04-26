/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Week8.bounceboxframework;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author ashongtical
 */
public class BouncePanel extends JPanel {
    private int width;
    private int height;
    private List<Drawable> drawshapes = new LinkedList<Drawable>();
    
    public BouncePanel(int width, int height) {
        super();
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, width, height);
        
        for (Drawable d: drawshapes) {
            d.draw(g2);
        }
    }
    
    public void addDrawable(Drawable d) {
        drawshapes.add(d);
  
    }
}

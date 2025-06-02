/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Week8.bounceboxframework;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;

/**
 *
 * @author ashongtical
 */
public class BounceView implements Observer  {
    
    private JFrame frame;
    private BouncePanel panel;
    private BounceModel model;
    
    public BounceView(int width, int height, BounceModel model) {
        this.model = model;
       model.addObserver(this);
        
        frame = new JFrame("Bounce Box");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new BouncePanel(width, height);
        frame.setContentPane(panel);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void update(Observable obs,  Object arg) {
        panel.repaint();
    }
 
    public void addDrawable(Drawable d) {
        panel.addDrawable(d);
    }
}

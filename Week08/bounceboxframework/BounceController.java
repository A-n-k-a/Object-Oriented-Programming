/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Week8.bounceboxframework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author ashongtical
 */
public class BounceController implements ActionListener {
    BounceModel model;
    Timer timer;
    int refreshInterval;
    double doubleInterval;
    public BounceController(BounceModel model, int refreshInterval)  {
        this.model = model;
        this.refreshInterval = refreshInterval;
        timer = new Timer(refreshInterval,this);
        doubleInterval = refreshInterval/1000.0;
    }
    
    public void start() {
            timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        model.moveShapes(doubleInterval);
    }

}

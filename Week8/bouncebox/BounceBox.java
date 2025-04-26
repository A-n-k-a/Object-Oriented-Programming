/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Week8.bouncebox;

import Week8.bounceboxframework.Shape;
import Week8.bounceboxframework.Wall;
import Week8.bounceboxframework.BounceModel;
import Week8.bounceboxframework.BounceController;
import Week8.bounceboxframework.BounceView;

/**
 *
 * @author ashongtical
 */
public class BounceBox {
    BounceModel model;
    BounceView view;
    BounceController controller;
    public static final int TIMER_INTERVAL = 50;
    
    public BounceBox(int width, int height) {
        
        model = new BounceModel();
        
        model.addWall(new Wall(1,0,0));
        model.addWall(new Wall(-1, 0, width));
        model.addWall(new Wall(0, 1, 0));
        model.addWall(new Wall(0, -1, height));
        
        view = new BounceView(width, height, model);
        controller = new BounceController(model, TIMER_INTERVAL);
    }
    
  
    public synchronized void addShape(Shape s) {
        model.addShape(s);
        view.addDrawable(s);
    }
    
   
    
    public void start() {
        controller.start();
    }

}

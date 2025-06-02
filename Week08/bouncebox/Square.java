/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Week8.bouncebox;

import Week8.bounceboxframework.Shape;
import java.awt.Graphics2D;

/**
 *
 * @author ashongtical
 */
public class Square extends Shape {
    
    private double contactRadius;
    private int width;
    
    public Square(int x, int y, int width) {
        super(x,y);
        this.width = width;
        contactRadius = Math.sqrt(width*width/2);
    }
    
    public int getWidth(){return width;}
    
    public double getContactRadius() {return contactRadius;}
    public double getMass() {return width*width;}
    public void draw(Graphics2D g) {
        g.setColor(getColor());
       
        int left = (int) (getX()-width/2);
        int top = (int) (getY()-width/2);
        g.fillRect(left,top, width, width);
        
  
    }
}

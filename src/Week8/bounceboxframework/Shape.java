/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Week8.bounceboxframework;

import java.awt.Color;

/**
 *
 * @author ashongtical
 */
public abstract class Shape implements Drawable, Moveable{
    private double x;
    private double y;
    private double vx = 0;
    private double vy = 0;
    private Color color = Color.BLACK;
    
    public Shape(int x, int y) {
        this.x = x;
        this.y  =y;
    }
    @Override
    public double getX(){return x;}
    @Override
    public double getY(){return y;}
    //public void setX(int x) {this.x = x;}
    //public void setY(int y) {this.y = x;}
    
    @Override
    public void setVelocity(double vx, double vy) {
        this.vx = vx;
        this.vy = vy;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    public Color getColor() {return color;}
    public void move(double time) {
        x+= vx * time;
        y+= vy * time;
    }
    
    private void reflect(double nx, double ny) {
        double dot = Util.dotprod(nx,ny,vx,vy);
        double absn = Util.mag(nx, ny);
        vx -= 2*nx*dot/(absn*absn);
        vy -= 2*ny*dot/(absn*absn);
    }
    
    /**
     * Interact with a wall bounding the space ax+by+c>0 in which the shape can
     * We assume (a,b) is normalised
     * move
     * @param a
     * @param b
     * @param c
     */
    public void interactWall(Wall wall) {
        double a = wall.getA();
        double b = wall.getB();
        double c = wall.getC();
        //are we close enough to the wall to bounce
        if (Util.dotprod(x, y, a, b) + c < getContactRadius()) {
            //are we moving towards the wall
            if (Util.dotprod(vx, vy, a, b)<0) {
                reflect(a, b);
            }
            
        }
    }
    
    public void interactShape(Shape s) {
        double dx = s.x-x;
        double dy = s.y-y;
        // are the two shapes close enough to interact
        if (Util.mag(dx, dy) < (getContactRadius() + s.getContactRadius())) {
            double dvx = s.vx-vx;
            double dvy = s.vy-vy;
            //are the two shapes moving together
            if (Util.dotprod(dx, dy, dvx, dvy)<0) {
               //ndx,ndy = normalised (dx,dy)
                double magd = Util.mag(dx, dy);
                double ndx = dx/magd;
                double ndy = dy/magd;
                
               //uperp = velocity of this perpendicular to line between shapes
               double uperp = Util.dotprod(vx, vy, -ndy, ndx);
               //usperp = velocity of s perpendicular to line between shapes
               double usperp = Util.dotprod(s.vx, s.vy, -ndy, ndx);
               //upar = init. velocity of this parallel to line between shapes
               double upar = Util.dotprod(vx, vy, ndx, ndy);
               //uspar = init. velocity of s parallel to line between shapes
               double uspar = Util.dotprod(s.vx, s.vy, ndx, ndy);
               
               double m = getMass();
               double ms = s.getMass();
               
               //vpar = final velocity of this parallel to line between shapes
               double vpar = (upar*(m-ms)+2*ms*uspar)/(m+ms); 
               //vspar = final velocity of this parallel to line between shapes
               double vspar = (uspar*(ms-m)+2*m*upar)/(m+ms); 
               
               vx = vpar*ndx-uperp*ndy;
               vy = vpar*ndy+uperp*ndx;
               s.vx = vspar*ndx-usperp*ndy;
               s.vy = vspar*ndy+usperp*ndx;
               
               
            }
        }
    }
    
    public abstract double getContactRadius();
    public abstract double getMass();
    
}

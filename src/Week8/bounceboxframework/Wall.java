/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Week8.bounceboxframework;

/**
 *
 * @author ashongtical
 */
// a wall that restricts shapes to moving in the area ax+by+c>0
public class Wall {
    private double a,b,c;
    
    public Wall(double a, double b, double c) {
        this.a=a; this.b=b; this.c=c;
    }
    
    public double getA(){return a;}
    public double getB(){return b;}
    public double getC(){return c;}
}

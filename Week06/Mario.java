/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// package oop.demo.game;
package Week6;

/**
 *
 * @author ashongtical
 */
    
public class Mario extends Character {
    //Exercise 2
    private int strength;
    private String kingdom;
    private boolean isSuperMario;
    
    //constructor
    public Mario(String n, int hP, int lvl, int x, int y, int str, String Kn, boolean isSM){
        // Set Mario's symbol as '#'
        super(n, hP, lvl, x, y, "#");   // inherit by calling the superclass constructor
        this.strength = str;
        this.kingdom = Kn;
        this.isSuperMario = isSM;
    }
    
    //getter and setters
    public int getStrength(){
        return strength;
    }
    
    public boolean getIsSuperMario(){
        return isSuperMario;
    }
    
    public String getKingdom(){
        return kingdom;
    }
    
    public void setStrength(int str){
        this.strength =  str;
    }
    
    public void setIsSuperMario(boolean isSM){
        this.isSuperMario = isSM;
    }
    
    public void getKingdom(String kn){
        this.kingdom = kn;
    }
    
     public void powerUp() {
        this.isSuperMario = true;
        this.strength += 20;
    }

    // Power down method
    public void powerDown() {
        this.isSuperMario = false;
        this.strength -= 20;
    }
    
    
    //Exercise 4
    // Override move method
    @Override
    public void move(int dx, int dy) {
        if (isSuperMario) {
            // Move twice as fast
            setX(getX() + (dx * 2));
            setY(getY() + (dy * 2));
        } else if (strength < 20) {
            // Move slower
            setX(getX() + (dx / 2));
            setY(getY() + (dy / 2));
        } else {
            // Normal movement
            setX(getX() + dx);
            setY(getY() + dy);
        }
    }
    
    //Exercise 6
    //overide the toString method
    @Override
    public String toString() {
        return super.toString() + ", Strength: " + strength + 
               ", Super Mario: " + isSuperMario;
    }
    
    // Exercise 7 - Overload constructors in Mario clas
    //Different parameters 
    // Overloaded constructor
    public Mario(String name) {
        super(name, 100, 1, 0, 0, "#");
        this.strength = 50;
        this.kingdom = "Mushroom Kingdom";
        this.isSuperMario = false;
    }
}

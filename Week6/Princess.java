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
public class Princess extends Character {
    private int age;
    private int wisdom;
    private String dressColor;
    private boolean capturedStatus;

    public Princess(String name, int healthPoints, int level, int x, int y, 
                   int age, int wisdom, String dressColor, boolean capturedStatus) {
        super(name, healthPoints, level, x, y, "@"); // Set Princess's symbol as '@'
        this.age = age;
        this.wisdom = wisdom;
        this.dressColor = dressColor;
        this.capturedStatus = capturedStatus;
    }

    // Getters and setters
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public String getDressColor() {
        return dressColor;
    }

    public void setDressColor(String dressColor) {
        this.dressColor = dressColor;
    }

    public boolean isCapturedStatus() {
        return capturedStatus;
    }

    public void setCapturedStatus(boolean capturedStatus) {
        this.capturedStatus = capturedStatus;
    }

    // Capture method
    public void capture() {
        this.capturedStatus = true;
    }

    // Rescue method
    public void rescue() {
        this.capturedStatus = false;
    }
    
    //Exercise 4
    // Override move method
    @Override
    public void move(int dx, int dy) {
        // Restrict movement to ±5 positions
        int newDx = Math.min(5, Math.max(-5, dx));
        int newDy = Math.min(5, Math.max(-5, dy));
        
        setX(getX() + newDx);
        setY(getY() + newDy);
    }
    
    // Teleport method specific to Princess
    public void teleport(int x, int y) {
        setX(x);
        setY(y);
    }
    
    //Exercise 6
    // Same attributes and methods from Exercise 3 and 4
    
    @Override
    public String toString() {
        return super.toString() + ", Wisdom: " + wisdom + 
               ", Age: " + age + ", Captured: " + capturedStatus;
    }
    
    // Exercise 7 - Overload constructors in Princess class
    //Different parameters 
    // Overloaded constructor
    public Princess(String name) {
        super(name, 80, 1, 0, 0, "@");
        this.age = 21;
        this.wisdom = 75;
        this.dressColor = "Yellow";
        this.capturedStatus = false;
    }
}

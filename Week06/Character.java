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

import java.util.ArrayList;

public class Character {
    private String name;
    private int healthPoints;
    private ArrayList<String> abilities;
    private int level;
    private int x;
    private int y;
    private String symbol;
    //private Game game; // Will be added later for Exercise 8

    // Constructor
    public Character(String name, int healthPoints, int level, int x, int y, String symbol) {
       this.name = name;
        this.healthPoints = healthPoints;
        this.level = level;
        this.x = x;
        this.y = y;
        this.symbol = symbol;
        this.abilities = new ArrayList<>();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public ArrayList<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<String> abilities) {
        this.abilities = abilities;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

//    public Game getGame() {
//        return game;
//    }
//
//    public void setGame(Game game) {
//        this.game = game;
//    }

    // Method to add a new ability
    public void addAbility(String ability) {
        abilities.add(ability);
    }

    // Move method (will be updated in Exercise 4)
    public void move(int new_x, int new_y) {
        this.x += new_x;
        this.y += new_y;
    }
    //Exercise 6
    //Override toString method
    @Override
    public String toString() {
        return name + " [" + symbol + "] at position (" + x + "," + y + 
               ") - Level: " + level + " HP: " + healthPoints;
    }
}


// Exercise 8 - Convert class to abstract class
//public abstract class Character {
    // Same attributes from previous exercises...
    
    // Constructor
    //public Character(String name, int healthPoints, int level, int x, int y, char symbol) {
        // Same initialization as before
    //}
    
    // Same getters/setters from previous exercises...
    
    // Abstract move method
    //public abstract void move(int dx, int dy);
    
    // toString method stays the same
//}



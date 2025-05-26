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
public class Ability {
    private String name;
    private Integer level;
    
    public Ability(String name, Integer level) {
        this.name = name;
        this.level = level;
    }
    
    // Getters and setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getLevel() {
        return level;
    }
    
    public void setLevel(Integer level) {
        this.level = level;
    }
    
}

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
import java.util.*;
public class CharacterStats {
    private String name;
    private ArrayList<Ability> abilities;
    
    public CharacterStats(String name) {
        this.name = name;
        this.abilities = new ArrayList<>();
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public ArrayList<Ability> getAbilities() {
        return abilities;
    }
    
    // Add ability method
    public void addAbility(Ability ability) {
        abilities.add(ability);
    }
    
    // Get ability by name
    public Ability getAbilityByName(String abilityName) {
        for (Ability ability : abilities) { //enhanced for loop 
            if (ability.getName().equals(abilityName)) {
                return ability;
            }
        }
        return null;
    }
    
}

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
public class SkillTracker {
    private HashMap<String, CharacterStats> characterSkills;
    
    public SkillTracker() {
        this.characterSkills = new HashMap<>();
    }
    
    // Add character method
    public void addCharacter(String name) {
        characterSkills.put(name, new CharacterStats(name));
    }
    
    // Add ability method
    public void addAbility(String characterName, String abilityName, int level) {
        CharacterStats stats = characterSkills.get(characterName);
        if (stats != null) {
            Ability existingAbility = stats.getAbilityByName(abilityName);
            if (existingAbility != null) {
                existingAbility.setLevel(level);
            } else {
                stats.addAbility(new Ability(abilityName, level));
            }
        }
    }
    
    // Get ability level method
    public Integer getAbilityLevel(String characterName, String abilityName) {
        CharacterStats stats = characterSkills.get(characterName);
        if (stats != null) {
            Ability ability = stats.getAbilityByName(abilityName);
            if (ability != null) {
                return ability.getLevel();
            }
        }
        return null;
    }
    
    // Get character average method
    public double getCharacterAverage(String characterName) {
        CharacterStats stats = characterSkills.get(characterName);
        if (stats != null && !stats.getAbilities().isEmpty()) {
            int sum = 0;
            for (Ability ability : stats.getAbilities()) {
                sum += ability.getLevel();
            }
            return (double) sum / stats.getAbilities().size();
        }
        return 0;
    }
    
    // Get ability average method
    public double getAbilityAverage(String abilityName) {
        int count = 0;
        int sum = 0;
        
        for (CharacterStats stats : characterSkills.values()) {
            Ability ability = stats.getAbilityByName(abilityName);
            if (ability != null) {
                sum += ability.getLevel();
                count++;
            }
        }
        
        return count > 0 ? (double) sum / count : 0;//
    }
    
    // Display all skills method
    public void displayAllSkills() {
        for (HashMap.Entry<String, CharacterStats> entry : characterSkills.entrySet()) { //enhanced for-loop with HashMap
            String characterName = entry.getKey();
            CharacterStats stats = entry.getValue();
            System.out.println("Character: " + characterName);
            for (Ability ability : stats.getAbilities()) {
                System.out.println(" Ability: " + ability.getName() + ", Level: " + ability.getLevel());
            }
            System.out.println(" Average Skill Level ---- " + getCharacterAverage(characterName));
            System.out.println();
        }
    }
    
}

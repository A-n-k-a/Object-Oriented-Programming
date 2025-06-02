/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

// package oop.demo.game;
package Week6;

/**
 *
 * @author ashongtical
 */
public class Game {

    public static void main(String[] args) {
        
        //Exercise 1
        System.out.println("Exercise 1!");
        // Create a character
        Character character = new Character("Bowser", 100, 1, 0, 0, "#");
        
        // Add abilities
        character.addAbility("Run");
        character.addAbility("Jump");
        character.addAbility("Hide");
        
        
        // Display information
        System.out.println("Character Name: " + character.getName());
        System.out.println("Health Points: " + character.getHealthPoints());
        System.out.println("Level: " + character.getLevel());
        System.out.println("Position: (" + character.getX() + "," + character.getY() + ")");
        System.out.println("Symbol: " + character.getSymbol());
        System.out.println("Abilities: " + character.getAbilities());
        
        //Exercise 2
        System.out.println("------------------------------------------");
        System.out.println("Exercise 2!");
        // Create a Mario character
        Mario mario = new Mario("Mario", 100, 1, 10, 10, 50, "Mushroom Kingdom", false);
        
        // Display initial information
        System.out.println("Name: " + mario.getName());
        System.out.println("Health Points: " + mario.getHealthPoints());
        System.out.println("Level: " + mario.getLevel());
        System.out.println("Position: (" + mario.getX() + "," + mario.getY() + ")");
        System.out.println("Symbol: " + mario.getSymbol());
        System.out.println("Strength: " + mario.getStrength());
        System.out.println("Kingdom: " + mario.getKingdom());
        System.out.println("Is Super Mario: " + mario.getIsSuperMario());
        
        // Test power up method
        mario.powerUp();
        System.out.println("\nAfter power up:");
        System.out.println("Strength: " + mario.getStrength());
        System.out.println("Is Super Mario: " + mario.getIsSuperMario());
        
        // Test power down method
        mario.powerDown();
        System.out.println("\nAfter power down:");
        System.out.println("Strength: " + mario.getStrength());
        System.out.println("Is Super Mario: " + mario.getIsSuperMario());
        
        //Exercise 3
        System.out.println("------------------------------------------");
        System.out.println("Exercise 3!");
        // Create a Princess character
        Princess peach = new Princess("Peach", 80, 1, 20, 20, 21, 75, "Pink", false);
        
        // Display initial information
        System.out.println("Name: " + peach.getName());
        System.out.println("Health Points: " + peach.getHealthPoints());
        System.out.println("Level: " + peach.getLevel());
        System.out.println("Position: (" + peach.getX() + "," + peach.getY() + ")");
        System.out.println("Symbol: " + peach.getSymbol());
        System.out.println("Age: " + peach.getAge());
        System.out.println("Wisdom: " + peach.getWisdom());
        System.out.println("Dress Color: " + peach.getDressColor());
        System.out.println("Captured Status: " + peach.isCapturedStatus());
        
        // Test capture method
        peach.capture();
        System.out.println("\nAfter capture:");
        System.out.println("Captured Status: " + peach.isCapturedStatus());
        
        // Test rescue method
        peach.rescue();
        System.out.println("\nAfter rescue:");
        System.out.println("Captured Status: " + peach.isCapturedStatus());
        
        
        //Exercise 4
        System.out.println("------------------------------------------");
        System.out.println("Exercise 4!");
        // Test Mario movement
        System.out.println("Mario initial position: (" + mario.getX() + "," + mario.getY() + ")");
        mario.move(3, 4); //mario can move to any location
        System.out.println("Mario position after normal move: (" + mario.getX() + "," + mario.getY() + ")");
        
        // Test Mario super movement
        mario.powerUp();
        mario.move(3, 4);
        System.out.println("Mario position after super move: (" + mario.getX() + "," + mario.getY() + ")");
        
        // Test Princess movement
        System.out.println("\nPeach initial position: (" + peach.getX() + "," + peach.getY() + ")");
        peach.move(5, 5); // Princesses can only move within their kingdom
        System.out.println("Peach position after restricted move: (" + peach.getX() + "," + peach.getY() + ")");
        
        // Test Princess teleport
        peach.teleport(20, 20);
        System.out.println("Peach position after teleport: (" + peach.getX() + "," + peach.getY() + ")");
        
        
        //Exercise 5 
        System.out.println("------------------------------------------");
        System.out.println("Exercise 5!");
        SkillTracker skillTracker = new SkillTracker();
        
        // Add characters
        skillTracker.addCharacter("Mario");
        skillTracker.addCharacter("Peach");
        skillTracker.addCharacter("Bowser");
        
        // Add abilities for Mario
        skillTracker.addAbility("Mario", "Jump", 85);
        skillTracker.addAbility("Mario", "Fireball", 70);
        skillTracker.addAbility("Mario", "Swimming", 60);
        
        // Add abilities for Peach
        skillTracker.addAbility("Peach", "Float", 90);
        skillTracker.addAbility("Peach", "Shield", 75);
        skillTracker.addAbility("Peach", "Jump", 65);
        
        // Add abilities for Bowser
        skillTracker.addAbility("Bowser", "Fire Breath", 95);
        skillTracker.addAbility("Bowser", "Shell Spin", 80);
        skillTracker.addAbility("Bowser", "Jump", 50);
        
        // Display all skills
        System.out.println("All Character Skills:");
        skillTracker.displayAllSkills();
        
        // Test getting specific ability level
        System.out.println("Mario's Jump Level: " + skillTracker.getAbilityLevel("Mario", "Jump"));
        
        // Test character average
        System.out.println("Peach's Average Skill Level: " + String.format("%.2f", skillTracker.getCharacterAverage("Peach")));
        //"%.2f" is to format the output using float
        
        // Test ability average across characters
        System.out.println("Jump Ability Average Across Characters: " + String.format("%.2f", skillTracker.getAbilityAverage("Jump")));
        
        //Exercise 6 - Test toString methods
        System.out.println("------------------------------------------");
        System.out.println("Exercise 6!");
        System.out.println("Character toString:");
        System.out.println(character);
        
        System.out.println("\nMario toString:");
        System.out.println(mario);
        
        System.out.println("\nPrincess toString:");
        System.out.println(peach);
        
        //Exercise 7 - Create characters using overloaded constructors
        System.out.println("------------------------------------------");
        System.out.println("Exercise 7!");
        // 
        Mario luigi = new Mario("Luigi");
        Princess daisy = new Princess("Daisy");
        
        // Test Mario constructor
        System.out.println("Luigi (using Mario overloaded constructor):");
        System.out.println("Name: " + luigi.getName());
        System.out.println("Health: " + luigi.getHealthPoints());
        System.out.println("Level: " + luigi.getLevel());
        System.out.println("Position: (" + luigi.getX() + "," + luigi.getY() + ")");
        System.out.println("Strength: " + luigi.getStrength());
        System.out.println("Kingdom: " + luigi.getKingdom());
        System.out.println("Is Super: " + luigi.getIsSuperMario());
        
        // Test Princess constructor
        System.out.println("\nDaisy (using Princess overloaded constructor):");
        System.out.println("Name: " + daisy.getName());
        System.out.println("Health: " + daisy.getHealthPoints());
        System.out.println("Level: " + daisy.getLevel());
        System.out.println("Position: (" + daisy.getX() + "," + daisy.getY() + ")");
        System.out.println("Age: " + daisy.getAge());
        System.out.println("Wisdom: " + daisy.getWisdom());
        System.out.println("Dress Color: " + daisy.getDressColor());
        System.out.println("Captured: " + daisy.isCapturedStatus());
    }
}

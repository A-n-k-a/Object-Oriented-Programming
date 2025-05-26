package Week4;
import java.util.ArrayList;
public class Game {
    private String name;
    private String difficulty;
    private ArrayList<Character> characters = new ArrayList<>();

    // Constructor
    public Game(String name, String difficulty) {
        this.name = name;
        this.difficulty = difficulty;
    }

    // Display game details
    public void display() {
        System.out.println("Game: " + name);
        System.out.println("Difficulty: " + difficulty);
        System.out.println("Characters:");
        for (Character c : characters) {
            c.display();
        }
    }

    // Change game difficulty
    public void changeDifficulty(String newDifficulty) {
        this.difficulty = newDifficulty;
        System.out.println("Difficulty changed to " + newDifficulty);
    }

    // Add a character to the game
    public void addCharacter(Character character) {
        characters.add(character);
        System.out.println(character.getName() + " added to the game.");
    }

    // Remove a character by position
    public Character removeCharacter(int position) {
        if (position >= 0 && position < characters.size()) {
            return characters.remove(position);
        }
        return null;
    }

    // Find a character by name and return its index
    public int findCharacter(String name) {
        for (int i = 0; i < characters.size(); i++) {
            if (characters.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    // Heal a character by name
    public void healCharacter(String name, int amount) {
        int index = findCharacter(name);
        if (index != -1) {
            Character character = characters.get(index);
            character.setHealthPoint(character.getHealthPoint() + amount);
            System.out.println(name + " healed by " + amount + ". Current health: " + character.getHealthPoint());
        } else {
            System.out.println("Character not found.");
        }
    }
}

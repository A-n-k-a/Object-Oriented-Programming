package Week4;

public class Character {
    private String name;
    private int healthPoint;
    private int level;

    // Constructor
    public Character(String name, int healthPoint, int level) {
        this.name = name;
        this.healthPoint = healthPoint;
        this.level = level;
    }

    // Display character details
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Health: " + healthPoint);
        System.out.println("Level: " + level);
    }

    // Level up the character
    public void levelUp() {
        level++;
        System.out.println(name + " leveled up to level " + level);
    }

    // Take damage and reduce health
    public void takeDamage(int damage) {
        healthPoint -= damage;
        if (healthPoint < 0) {
            healthPoint = 0;
        }
        System.out.println(name + " took " + damage + " damage. Current health: " + healthPoint);
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public int getLevel() {
        return level;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setHealthPoint(int hp) {
        this.healthPoint = hp;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}

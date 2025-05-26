package Week4;

public class Entity {
    private String name;
    private int x;
    private int y;

    public Entity(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
    public void display() {
        System.out.println("Entity name: " + name);
        System.out.println("Entity position: (" + x + ", " + y + ")");
    }
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}

package Week4;
// 没有专门写出constructor时，Java会以空值初始化
public class World {
    String name;
    Entity[] entities = new Entity[10];
    public void addEntity(Entity entity) {
        for (int i = 0; i < entities.length; i++) {
            if (entities[i] == null) {
                entities[i] = entity;
                break;
            }
        }
        System.out.println("This world is full, cannot add more entities.");

    }
    public Entity deleteEntity(int index) {
        if (index >= 0 && index < entities.length) {
            Entity entity = entities[index];
            entities[index] = null;
            return entity;
        }
        return null;
    }
    public int findEntity(String name) {
        for (int i = 0; i < entities.length; i++) {
            if (entities[i] != null && entities[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
    public void moveEntity(int index, int dx, int dy) {
        if (index >= 0 && index < entities.length && entities[index] != null) {
            entities[index].move(dx, dy);
        }
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public Entity[] getEntities() {
        return entities;
    }
    public void setEntities(Entity[] entities) {
        this.entities = entities;
    }
    public void display() {
        System.out.println("World name: " + name);
        for (Entity entity : entities) {
            if (entity != null) {
                entity.display();
            }
        }
    }
}

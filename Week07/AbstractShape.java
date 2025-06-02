package Week7;

public abstract class AbstractShape implements IShape, Transformable {
    private double x, y;

    public AbstractShape(double x, double y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public abstract double getArea();
    @Override
    public abstract double getPerimeter();
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void setX(double newX) {
        x = newX;
    }
    public void setY(double newY) {
        y = newY;
    }
    public void move(double newX, double newY) {
        x = newX;
        y = newY;
    }
    public void scale(double factor) {
        // Scaling logic can be implemented in subclasses
        // For example, if the shape is a rectangle, scale its width and height
        // If it's a circle, scale its radius
    }
}

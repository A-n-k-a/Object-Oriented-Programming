package Week7;

public class Circle implements IShape {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
//    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
//    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

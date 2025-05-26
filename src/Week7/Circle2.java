package Week7;

public class Circle2 extends AbstractShape {
    private double radius;
    public Circle2(double radius) {
        super(0, 0); // Call the constructor of AbstractShape with default values
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
//    @Override
    public void scale(double factor) {
        radius *= factor;
    }
}

package Week7;

public class Rectangle2 extends AbstractShape {
    private double width, height;
    public Rectangle2(double width, double height) {
        super(0, 0); // Call the constructor of AbstractShape with default values
        this.width = width;
        this.height = height;
    }
//    @Override
    public double getArea() {
        return width * height;
    }
//    @Override
    public double getPerimeter() {
        return 2 * width + 2 * height;
    }
//    @Override
    public void scale(double factor) {
        width *= factor;
        height *= factor;
    }
}

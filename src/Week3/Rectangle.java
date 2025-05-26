package Week3;

public class Rectangle {
    public int length;
    public int width;
    public Rectangle(int l, int w){
        length = l;
        width = w;
    }
    public void setLength(int l){
        length = l;
    }
    public void setWidth(int w){
        width = w;
    }
    public int getLength(){
        return length;
    }
    public int getWidth(){
        return width;
    }
    public int getArea(){
        return length * width;
    }
    public int getPerimeter(){
        return 2 * (length + width);
    }
    // Add a new constructor to the class Rectangle that creates a rectangle with the default value for length 5 and width 4.
    public Rectangle() {
        length = 5;
        width = 4;
    }
}

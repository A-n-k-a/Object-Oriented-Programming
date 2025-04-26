package Week8;
import javax.swing.*;
import java.awt.*;
public class BouncingShapes extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    Color colorBLUE = Color.BLUE;
    Color colorRGB = new Color(255,0,0);
    public BouncingShapes() {
        setTitle("Bouncing Shapes");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Draw bouncing shapes here
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BouncingShapes bouncingShapes = new BouncingShapes();
            bouncingShapes.setVisible(true);
        });
    }
}

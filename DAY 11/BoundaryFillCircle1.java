import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class BoundaryFillCircle1 extends JFrame {

    BufferedImage canvas;
    Graphics g;
    int width = 500, height = 500;

    Color boundaryColor = Color.BLACK;  // Circle boundary
    Color fillColor = Color.RED;        // Fill color

    public BoundaryFillCircle1() {
        setTitle("Boundary Fill - Filled Circle");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        g = canvas.getGraphics();

        // Background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // Draw boundary circle
        int xc = 250, yc = 250, r = 100;
        g.setColor(boundaryColor);
        g.drawOval(xc - r, yc - r, 2 * r, 2 * r);

        // Fill circle automatically from the center
        boundaryFill4(xc, yc, fillColor, boundaryColor);

        setVisible(true);
    }

    // 4-connected boundary fill
    void boundaryFill4(int x, int y, Color fillColor, Color boundaryColor) {
        if (x < 0 || y < 0 || x >= width || y >= height)
            return;

        int currentColor = canvas.getRGB(x, y);
        if (currentColor != boundaryColor.getRGB() && currentColor != fillColor.getRGB()) {
            canvas.setRGB(x, y, fillColor.getRGB());

            boundaryFill4(x + 1, y, fillColor, boundaryColor);
            boundaryFill4(x - 1, y, fillColor, boundaryColor);
            boundaryFill4(x, y + 1, fillColor, boundaryColor);
            boundaryFill4(x, y - 1, fillColor, boundaryColor);

            repaint();
        }
    }

    public void paint(Graphics g2) {
        g2.drawImage(canvas, 0, 0, null);
    }

    public static void main(String[] args) {
        new BoundaryFillCircle1();
    }
}

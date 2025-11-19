import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class BoundaryFillWithCondition extends JFrame implements MouseListener {

    int width = 800, height = 600;
    BufferedImage canvas;
    Color boundaryColor = Color.BLACK;
    Color fillColor = Color.RED;
    Graphics2D g;

    public BoundaryFillWithCondition() {
        setTitle("Boundary Fill (with Color Condition)");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(this);
        setLocationRelativeTo(null);
        setVisible(true);

        // Create blank canvas
        canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g = canvas.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // Draw the boundary rectangle
        g.setColor(boundaryColor);
        g.drawRect(200, 150, 400, 300);

        g.setColor(Color.BLACK);
        g.drawString("Click inside the rectangle to fill", 20, 60);
    }

    // Boundary Fill using color checking (4-connected)
    private void boundaryFill(int x, int y, Color fillColor, Color boundaryColor) {
        if (x < 0 || y < 0 || x >= width || y >= height)
            return;

        Color currentColor = new Color(canvas.getRGB(x, y), true);

        if (!currentColor.equals(boundaryColor) && !currentColor.equals(fillColor)) {
            canvas.setRGB(x, y, fillColor.getRGB());

            // Recursive calls (4-connected)
            boundaryFill(x + 1, y, fillColor, boundaryColor);
            boundaryFill(x - 1, y, fillColor, boundaryColor);
            boundaryFill(x, y + 1, fillColor, boundaryColor);
            boundaryFill(x, y - 1, fillColor, boundaryColor);
        }
    }

    // Repaint the canvas
    public void paint(Graphics gScreen) {
        gScreen.drawImage(canvas, 0, 0, null);
    }

    public void mouseClicked(MouseEvent e) {
        boundaryFill(e.getX(), e.getY(), fillColor, boundaryColor);
        repaint();
    }

    // Unused mouse events
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new BoundaryFillWithCondition();
    }
}

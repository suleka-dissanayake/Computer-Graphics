import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

/*
    A simple Java Swing application demonstrating the Flood Fill algorithm.
    Clicking inside the drawn rectangle will fill the area using a recursive 4-connected boundary fill.
*/
public class FloodFill extends JFrame implements MouseListener {

    // Canvas to draw on
    BufferedImage canvas;

    // Colors used for boundary and fill
    Color boundaryColor = Color.BLACK;
    Color fillColor = Color.RED;

    // Graphics context for drawing on the canvas
    Graphics2D g;

    // Constructor to set up the JFrame and initialize the canvas.
    public FloodFill() {
        setTitle("Flood Fill");
        setSize(800, 600); // Set window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit on close
        addMouseListener(this); // Register mouse listener
        setLocationRelativeTo(null); // Center the window

        // Create a blank canvas with transparency support
        canvas = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        g = canvas.createGraphics();

        // Fill the canvas with white background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 800, 600);

        // Draw a rectangle to serve as the boundary
        g.setColor(boundaryColor);
        g.drawRect(200, 150, 400, 300); // Rectangle from (200,150) to (600,450)

        setVisible(true); // Make the window visible
    }

    private void floodFill(int x, int y, Color boundaryColor, Color fillColor) {
        // Check if the point is within the rectangle bounds
        if (x < 0 || y < 0 || x >= canvas.getWidth() || y >= canvas.getHeight())
            return;

        // Get the current color at the pixel
        Color currentColor = new Color(canvas.getRGB(x, y), true);

        // If the pixel is not boundary or already filled, fill it and recurse
        if (!currentColor.equals(boundaryColor) && !currentColor.equals(fillColor)) {
            canvas.setRGB(x, y, fillColor.getRGB());

            // Recursively fill neighboring pixels (4-connected)
            floodFill(x + 1, y, boundaryColor, fillColor); // Right
            floodFill(x - 1, y, boundaryColor, fillColor); // Left
            floodFill(x, y + 1, boundaryColor, fillColor); // Down
            floodFill(x, y - 1, boundaryColor, fillColor); // Up
        }
    }

    public void paint(Graphics gScreen) {
        super.paint(gScreen); // Ensure proper rendering
        gScreen.drawImage(canvas, 0, 0, null);
    }

    // Mouse click event triggers the boundary fill starting from the clicked point.
    public void mouseClicked(MouseEvent e) {
        floodFill(e.getX(), e.getY(), boundaryColor, fillColor);
        repaint(); // Refresh the screen to show the filled area
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new FloodFill();
    }
}
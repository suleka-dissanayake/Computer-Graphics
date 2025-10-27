import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

/**
 * A simple Java Swing application demonstrating the 8-connected Boundary Fill algorithm.
 * Clicking inside the drawn rectangle will fill the area using a recursive 8-connected boundary fill.
 */
public class BoundaryFill8 extends JFrame implements MouseListener {

    // Canvas to draw on
    BufferedImage canvas;

    // Colors used for boundary and fill
    Color boundaryColor = Color.BLACK;
    Color fillColor = Color.RED;

    // Graphics context for drawing on the canvas
    Graphics2D g;

    // Constructor to set up the JFrame and initialize the canvas.
    public BoundaryFill8() {
        setTitle("Boundary Fill (8-Connected)");
        setSize(800, 600); // Set window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit on close
        addMouseListener(this); // Register mouse listener
        setLocationRelativeTo(null); // Center the window
        setVisible(true); // Make the window visible

        // Create a blank canvas with transparency support
        canvas = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        g = canvas.createGraphics();

        // Fill the canvas with white background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 800, 600);

        // Draw a rectangle to serve as the boundary
        g.setColor(boundaryColor);
        g.drawRect(200, 150, 400, 300); // Rectangle from (200,150) to (600,450)
    }

    /**
     * Recursive boundary fill algorithm (8-connected).
     * Fills the area until it hits the boundary color.
     */
    private void boundaryFill8(int x, int y, Color fillColor, Color boundaryColor) {
        // Check if the point is within canvas bounds
        if (x < 0 || y < 0 || x >= canvas.getWidth() || y >= canvas.getHeight())
            return;

        // Get the current color at the pixel
        Color currentColor = new Color(canvas.getRGB(x, y), true);

        // If the pixel is not boundary or already filled, fill it and recurse
        if (!currentColor.equals(boundaryColor) && !currentColor.equals(fillColor)) {
            canvas.setRGB(x, y, fillColor.getRGB());

            // Recursively fill neighboring pixels (8-connected)
            boundaryFill8(x + 1, y, fillColor, boundaryColor);     // Right
            boundaryFill8(x - 1, y, fillColor, boundaryColor);     // Left
            boundaryFill8(x, y + 1, fillColor, boundaryColor);     // Down
            boundaryFill8(x, y - 1, fillColor, boundaryColor);     // Up
            boundaryFill8(x + 1, y + 1, fillColor, boundaryColor); // Bottom-right
            boundaryFill8(x - 1, y - 1, fillColor, boundaryColor); // Top-left
            boundaryFill8(x + 1, y - 1, fillColor, boundaryColor); // Top-right
            boundaryFill8(x - 1, y + 1, fillColor, boundaryColor); // Bottom-left
        }
    }

    // Override paint method to draw the canvas on the screen.
    public void paint(Graphics gScreen) {
        gScreen.drawImage(canvas, 0, 0, null);
    }

    // Mouse click event triggers the boundary fill starting from the clicked point.
    public void mouseClicked(MouseEvent e) {
        boundaryFill8(e.getX(), e.getY(), fillColor, boundaryColor);
        repaint(); // Refresh the screen to show the filled area
    }

    // Unused mouse event methods (required by MouseListener interface)
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    // Main method to launch the application.
    public static void main(String[] args) {
        new BoundaryFill8();
    }
}
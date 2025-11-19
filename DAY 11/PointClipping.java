import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class PointClipping extends JFrame implements MouseListener {

    int xMin = 200, yMin = 150, xMax = 600, yMax = 450; // Clipping rectangle
    ArrayList<Point> points = new ArrayList<>(); // Store points

    public PointClipping() {
        setTitle("Point Clipping Example");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(this);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);           // Clear screen
        g.fillRect(0, 0, 800, 600);

        g.setColor(Color.BLACK);           // Draw clipping rectangle
        g.drawRect(xMin, yMin, xMax - xMin, yMax - yMin);

        g.setColor(Color.RED);             // Draw points inside rectangle
        for (Point p : points) {
            if (p.x >= xMin && p.x <= xMax && p.y >= yMin && p.y <= yMax) {
                g.fillOval(p.x - 10, p.y - 10, 20, 20); // small circle for point
            }
        }
    }

    // When you click, add a point
    public void mouseClicked(MouseEvent e) {
        points.add(e.getPoint());
        repaint(); // redraw everything
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new PointClipping();
    }
}

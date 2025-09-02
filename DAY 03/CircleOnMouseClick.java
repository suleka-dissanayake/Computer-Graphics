import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CircleOnMouseClick extends JFrame {
    private final DrawPanel drawPanel;

    public CircleOnMouseClick() {
        setTitle("Click to Draw Circles");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        drawPanel = new DrawPanel();
        add(drawPanel);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drawPanel.addCircle(e.getX(), e.getY());
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CircleOnMouseClick::new);
    }

    // Inner class for custom drawing
    static class DrawPanel extends JPanel {
        private final java.util.List<Point> circles = new ArrayList<>();

        public void addCircle(int x, int y) {
            circles.add(new Point(x, y));
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            for (Point p : circles) {
                g.fillOval(p.x - 15, p.y - 15, 30, 30); // Center the circle
            }
        }
    }
}
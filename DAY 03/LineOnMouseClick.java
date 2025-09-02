import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LineOnMouseClick extends JFrame {
    private final DrawPanel drawPanel;

    public LineOnMouseClick() {
        setTitle("Click to Draw Lines");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        drawPanel = new DrawPanel();
        add(drawPanel);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drawPanel.addPoint(e.getX(), e.getY());
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LineOnMouseClick::new);
    }

    // Inner class for custom drawing
    static class DrawPanel extends JPanel {
        private final java.util.List<Point> points = new ArrayList<>();

        public void addPoint(int x, int y) {
            points.add(new Point(x, y));
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.RED);
            for (int i = 1; i < points.size(); i++) {
                Point p1 = points.get(i - 1);
                Point p2 = points.get(i);
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }
    }
}
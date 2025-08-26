import javax.swing.*;
import java.awt.*;

public class Snowman extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Set background
        g2.setColor(Color.CYAN);
        g2.fillRect(0, 0, getWidth(), getHeight());

        // Draw snowman body
        g2.setColor(Color.WHITE);
        g2.fillOval(100, 200, 100, 100); // bottom
        g2.fillOval(115, 130, 70, 70);   // middle
        g2.fillOval(125, 80, 50, 50);    // head

        // Draw eyes
        g2.setColor(Color.BLACK);
        g2.fillOval(135, 95, 5, 5);
        g2.fillOval(150, 95, 5, 5);

        // Draw carrot nose
        g2.setColor(Color.ORANGE);
        g2.fillPolygon(new int[]{145, 145, 90}, new int[]{105, 110, 115}, 3);

        // Draw hat
        g2.setColor(Color.BLACK);
        g2.fillRect(125, 60, 50, 20); // top of hat
        g2.fillRect(115, 80, 70, 5);  // brim

        // Draw arms
        g2.setColor(new Color(139, 69, 19)); // brown
        g2.drawLine(115, 150, 80, 130); // left arm
        g2.drawLine(185, 150, 220, 130); // right arm
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snowman with Hat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.add(new Snowman());
        frame.setVisible(true);
    }
}
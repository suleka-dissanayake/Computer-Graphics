import javax.swing.*;
import java.awt.*;

public class CrossOvals extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Ensures proper painting behavior

        g.setColor(Color.RED);
        int x = 0;
        for (int i = 0; i < 60; i++) {
            g.drawOval(100 + x, 300, 50, 50);
            x += 5;
        }

        g.setColor(Color.BLUE);
        int y = 50;
        for (int i = 0; i < 60; i++) {
            g.drawOval(250, 150 + y, 50, 50);
            y += 5;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cross Ovals");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);

        CrossOvals panel = new CrossOvals();
        frame.add(panel);
        frame.setVisible(true);
    }
}
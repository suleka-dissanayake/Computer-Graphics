import javax.swing.*;
import java.awt.*;

public class MultipleOvals extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // First set of ovals in default color (black)
        int t1 = 10;
        for (int i = 0; i < 40; i++) {
            g.drawOval(100, 100, t1, t1);
            t1 += 5;
        }

        // Second set of ovals in blue
        g.setColor(Color.BLUE);
        int t2 = 10;
        for (int i = 0; i < 40; i++) {
            g.drawOval(300, 100, t2, t2);
            t2 += 5;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Multiple Ovals");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(new MultipleOvals());
        frame.setVisible(true);
    }
}
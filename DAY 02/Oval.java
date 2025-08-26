import javax.swing.*;
import java.awt.*;

// Custom JPanel to draw the oval
class OvalPanel extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set color (optional)
        g.setColor(Color.BLUE);

        // Draw oval: x, y, width, height
        g.drawOval(50, 50, 200, 100);
    }
}

public class Oval {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Oval Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        frame.add(new OvalPanel()); // Add custom panel
        frame.setVisible(true);
    }
}
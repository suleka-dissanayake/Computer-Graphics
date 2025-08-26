import javax.swing.*;
import java.awt.*;

class ArcsPanel extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);
        g.fillArc(100, 100, 50, 50, 180, 180);

        g.setColor(Color.PINK);
        g.fillArc(200, 100, 100, 100, 0, 180);

        g.setColor(Color.GREEN);
        g.fillArc(100, 200, 100, 100, 0, 270);

        g.setColor(Color.YELLOW);
        g.fillArc(220, 200, 100, 100, 180, 270);
    }
}

public class Arcs extends JFrame {
    Arcs() {
        setTitle("Arcs");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new ArcsPanel()); // Add the custom panel
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Arcs());
    }
}
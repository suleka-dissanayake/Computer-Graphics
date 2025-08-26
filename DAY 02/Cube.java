import javax.swing.*;
import java.awt.*;

class CubePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);

        // Front face
        g.drawLine(50, 50, 50, 150);
        g.drawLine(50, 150, 150, 150);
        g.drawLine(150, 150, 150, 50);
        g.drawLine(150, 50, 50, 50);

        // Back face
        g.drawLine(90, 90, 90, 190);
        g.drawLine(90, 190, 190, 190);
        g.drawLine(190, 190, 190, 90);
        g.drawLine(190, 90, 90, 90);

        // Connecting edges
        g.drawLine(50, 50, 90, 90);
        g.drawLine(150, 50, 190, 90);
        g.drawLine(50, 150, 90, 190);
        g.drawLine(150, 150, 190, 190);
    }
}

public class Cube extends JFrame {
    Cube() {
        setTitle("3D Cube");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new CubePanel());
        setVisible(true);
    }

    public static void main(String[] args) {
        new Cube();
    }
}
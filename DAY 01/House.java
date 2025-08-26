import javax.swing.*;
import java.awt.*;

class House extends JPanel {

    House() {
        JFrame frame = new JFrame("Simple House Drawing");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        setBackground(Color.white);

        g.setColor(Color.BLUE);
        g.fillRect(100, 150, 200, 150);

        g.setColor(Color.RED);
        int[] xPoints = {100, 200, 300};
        int[] yPoints = {150, 50, 150};
        g.fillPolygon(xPoints, yPoints, 3);

        g.setColor(Color.DARK_GRAY);
        g.fillRect(180, 220, 40, 80);

        g.setColor(Color.WHITE);
        g.fillRect(120, 180, 40, 40);
        g.fillRect(240, 180, 40, 40);
    }

    // Main method to run the program
    public static void main(String[] args) {
        new House();
    }
}
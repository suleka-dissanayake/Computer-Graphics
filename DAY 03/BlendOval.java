import javax.swing.*;
import java.awt.*;

class BlendOval extends JFrame {

    public BlendOval() {
        setTitle("Blend Oval");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new DrawOvalPanel());
    }

    class DrawOvalPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            GradientPaint gradient = new GradientPaint(0, 0, Color.CYAN, getWidth(), getHeight(), Color.MAGENTA);
            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, getWidth(), getHeight());
            
            g2d.setColor(new Color(0, 0, 255, 128));
            g2d.fillOval(200, 200, 400, 400);
        }
    }

    public static void main(String[] args) {
        BlendOval frame = new BlendOval();
        frame.setVisible(true);
    }
}
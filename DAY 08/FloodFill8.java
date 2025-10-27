import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class FloodFill8 extends JFrame {

    BufferedImage canvas;
    Color boundaryColor = Color.BLACK;
    Color fillColor = Color.GREEN;

    public FloodFill8() {
        setTitle("Flood Fill");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        canvas = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = canvas.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 800, 600);
        g.setColor(boundaryColor);
        g.drawRect(200, 150, 400, 300); // Rectangle from (200,150) to (600,450)

        DrawPanel drawPanel = new DrawPanel();
        drawPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                floodFill8(e.getX(), e.getY(), boundaryColor, fillColor);
                drawPanel.repaint();
            }
        });

        add(drawPanel);
        setVisible(true);
    }

    private void floodFill8(int x, int y, Color boundaryColor, Color fillColor) {
        if (x < 0 || y < 0 || x >= canvas.getWidth() || y >= canvas.getHeight())
            return;

        Color currentColor = new Color(canvas.getRGB(x, y), true);
        if (!currentColor.equals(boundaryColor) && !currentColor.equals(fillColor)) {
            canvas.setRGB(x, y, fillColor.getRGB());

            floodFill8(x + 1, y, boundaryColor, fillColor);
            floodFill8(x - 1, y, boundaryColor, fillColor);
            floodFill8(x, y + 1, boundaryColor, fillColor);
            floodFill8(x, y - 1, boundaryColor, fillColor);
            floodFill8(x - 1, y - 1, boundaryColor, fillColor);
            floodFill8(x + 1, y + 1, boundaryColor, fillColor);
            floodFill8(x + 1, y - 1, boundaryColor, fillColor);
            floodFill8(x - 1, y + 1, boundaryColor, fillColor);
        }
    }

    class DrawPanel extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(canvas, 0, 0, null);
        }
    }

    public static void main(String[] args) {
        new FloodFill8();
    }
}
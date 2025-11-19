import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class FloodFill extends JFrame implements MouseListener {

    BufferedImage canvas;
    Color oldcolor=Color.RED; 
    Color newcolor = Color.green;
    Graphics g;

    public FloodFill() {
        setTitle("Flood Fill Algorithm");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(this);
        setLocationRelativeTo(null);
        setVisible(true);

        canvas = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        g = canvas.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 800, 600);

        
        g.setColor(Color.red);
        g.fillRect(200, 150, 400, 300);
    }

    private void floodFill(int x, int y, Color oldcolor, Color newcolor) {
     if (x < 200 || y < 150 || x >= 600 || y >= 450)
        return;

	

        Color currentColor = new Color(canvas.getRGB(x, y), true);

        if (currentColor.equals(oldcolor) && !currentColor.equals(newcolor)) {
            canvas.setRGB(x, y, newcolor.getRGB());

            floodFill(x + 1, y, oldcolor, newcolor);
            floodFill(x - 1, y, oldcolor, newcolor);
            floodFill(x, y + 1, oldcolor, newcolor);
            floodFill(x, y - 1, oldcolor, newcolor);
        }
    }

    
    public void paint(Graphics gScreen) {
        gScreen.drawImage(canvas, 0, 0, null);
    }

    // Mouse click triggers flood fill
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        targetColor = new Color(canvas.getRGB(x, y), true);
        floodFill(x, y, targetColor, fillColor);
        repaint();
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new FloodFill();
    }
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Stylish_Circle_Bresenham extends JFrame implements MouseListener {
    int xc, yc, r;
    boolean isDraw = false;
	Graphics g;

    Stylish_Circle_Bresenham() {
        setTitle("Stylish Circle using Midpoint");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(this);
        setLocationRelativeTo(null);
        setVisible(true);
		g = getGraphics();
    }

    // Midpoint Circle Algorithm
    public void drawCircle(int xc, int yc, int r) {
        int x = 0;
        int y = r;
        int d = 3 - 2 * r;  // decision parameter

        while (x <= y) {
            plotCirclePoints(xc, yc, x, y);
            if (d < 0)
                d = d + (4 * x) + 6;
            else {
                d = d + 4 * (x - y) + 10;
                y--;
            }
            x++;
        }
    }

    public void plotCirclePoints(int xc, int yc, int x, int y) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(xc + x, yc + y, 2, 2);

        g.setColor(Color.GREEN);
        g.fillRect(xc - x, yc + y, 2, 2);

        g.setColor(Color.BLUE);
        g.fillRect(xc + x, yc - y, 2, 2);

        g.setColor(Color.YELLOW);
        g.fillRect(xc - x, yc - y, 2, 2);

        g.setColor(Color.MAGENTA);
        g.fillRect(xc + y, yc + x, 2, 2);

        g.setColor(Color.ORANGE);
        g.fillRect(xc - y, yc + x, 2, 2);

        g.setColor(Color.CYAN);
        g.fillRect(xc + y, yc - x, 2, 2);

        g.setColor(Color.RED);
        g.fillRect(xc - y, yc - x, 2, 2);
    }


    // Mouse Events
    public void mousePressed(MouseEvent e) {
        xc = e.getX();
        yc = e.getY();
    }

    public void mouseReleased(MouseEvent e) {
        int x2 = e.getX();
        int y2 = e.getY();
		if (!isDraw) {
            g.setColor(Color.RED);
            r = (int) Math.sqrt(Math.pow(x2 - xc, 2) + Math.pow(y2 - yc, 2));
            drawCircle(xc, yc, r);
            isDraw = true;
        }
        
    }

    public void mouseClicked(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new Stylish_Circle_Bresenham();
    }
}

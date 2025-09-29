import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MidpointCircleAlgorithm extends JFrame implements MouseListener {
    int xc, yc, r;
    boolean isDraw = false;
	Graphics g;

    MidpointCircleAlgorithm() {
        setTitle("Midpoint Circle Algorithm");
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
        int p = 1 - r;  // decision parameter

        while (x <= y) {
            plotCirclePoints(xc, yc, x, y);

            if (p < 0)
                p = p + 2 * x + 3;
            else {
                p = p + 2 * (x - y) + 5;
                y--;
            }
            x++;
        }
    }

    // Plotting 8 symmetric points
    public void plotCirclePoints(int xc, int yc, int x, int y) {
        g.fillRect(xc + x, yc + y, 2, 2);
        g.fillRect(xc - x, yc + y, 2, 2);
        g.fillRect(xc + x, yc - y, 2, 2);
        g.fillRect(xc - x, yc - y, 2, 2);
        g.fillRect(xc + y, yc + x, 2, 2);
        g.fillRect(xc - y, yc + x, 2, 2);
        g.fillRect(xc + y, yc - x, 2, 2);
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
        isDraw = true;}
        
    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new MidpointCircleAlgorithm();
    }
}

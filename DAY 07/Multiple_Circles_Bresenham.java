import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class Multiple_Circles_Bresenham extends JFrame implements MouseListener {
    ArrayList<Circle> circles = new ArrayList<>();
    int xc, yc;
    boolean isPressed = false;

    Multiple_Circles_Bresenham() {
        setTitle("Multiple Concentric Circles using Midpoint Algorithm");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(this);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    class Circle {
        int xc, yc, r;

        Circle(int xc, int yc, int r) {
            this.xc = xc;
            this.yc = yc;
            this.r = r;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (Circle circle : circles) {
            drawCircle(g, circle.xc, circle.yc, circle.r);
        }
    }

    public void drawCircle(Graphics g, int xc, int yc, int r) {
        int x = 0;
        int y = r;
        int d = 3 - 2 * r;

        while (x <= y) {
            plotCirclePoints(g, xc, yc, x, y);
            if (d < 0) {
                d = d + (4 * x) + 6;
            } else {
                d = d + 4 * (x - y) + 10;
                y--;
            }
            x++;
        }
    }

    public void plotCirclePoints(Graphics g, int xc, int yc, int x, int y) {
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

    public void mousePressed(MouseEvent e) {
        xc = e.getX();
        yc = e.getY();
        isPressed = true;
    }

    public void mouseReleased(MouseEvent e) {
        if (isPressed) {
            int x2 = e.getX();
            int y2 = e.getY();
            int r = (int) Math.sqrt(Math.pow(x2 - xc, 2) + Math.pow(y2 - yc, 2));
            circles.add(new Circle(xc, yc, r));

            int step = 10;
            int currentRadius = r - step;
            while (currentRadius > 0) {
                circles.add(new Circle(xc, yc, currentRadius));
                currentRadius -= step;
            }

            repaint();
            isPressed = false;
        }
    }

    public void mouseClicked(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new Multiple_Circles_Bresenham();
    }
}
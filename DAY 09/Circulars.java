import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Circulars extends JFrame implements MouseListener {
    Graphics2D g2;

    public Circulars() {
        setTitle("Circular Rosette with 16 petals");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(this);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void drawCircle(int xc, int yc, int r) {
        int x = 0;
        int y = r;
        int d = 3 - 2 * r;

        while (x <= y) {
            plotCirclePoints(xc, yc, x, y);

            if (d < 0)
                d = d + 4 * x + 6;
            else {
                d = d + 4 * (x - y) + 10;
                y--;
            }
            x++;
        }
    }

    public void plotCirclePoints(int xc, int yc, int x, int y) {
        g2.fillRect(xc + x, yc + y, 2, 2);
        g2.fillRect(xc - x, yc + y, 2, 2);
        g2.fillRect(xc + x, yc - y, 2, 2);
        g2.fillRect(xc - x, yc - y, 2, 2);
        g2.fillRect(xc + y, yc + x, 2, 2);
        g2.fillRect(xc - y, yc + x, 2, 2);
        g2.fillRect(xc + y, yc - x, 2, 2);
        g2.fillRect(xc - y, yc - x, 2, 2);
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) {
 
        g2 = (Graphics2D) getGraphics();
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.BLUE);

        int xc = e.getX();
        int yc = e.getY();

        int radiusEach = 20;
        int centerDist = 100;
        int petals = 8;

        drawCircle(xc, yc, 100);

        for (int i = 0; i < petals; i++) {
 
            double angle = 2 * Math.PI * i / petals;

            int x = (int) (xc + centerDist * Math.cos(angle));
            int y = (int) (yc + centerDist * Math.sin(angle));

            if(i == 1 || i == 5){
                g2.setColor(Color.RED);
            }

            if(i == 2 || i == 6){
                g2.setColor(Color.BLUE);
            }

            if(i == 3 || i == 7){
                g2.setColor(Color.ORANGE);
            }

            if(i == 4 || i == 8){
                g2.setColor(Color.GREEN);
            }

            drawCircle(x, y, radiusEach);
        }
    }

    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new Circulars();
    }
}

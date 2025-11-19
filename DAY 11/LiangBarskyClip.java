import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class LiangBarskyClip extends JFrame implements MouseListener {

    BufferedImage canvas;
    Graphics2D g;

    int x1, y1, x2, y2;
    boolean firstClick = true;

    int xmin = 200, ymin = 150, xmax = 600, ymax = 450;

    public LiangBarskyClip() {
        setTitle("Liang-Barsky Line Clipping");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(this);
        setLocationRelativeTo(null);
        setVisible(true);

        canvas = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        g = canvas.createGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 800, 600);

       
        g.setColor(Color.BLACK);
        g.drawRect(xmin, ymin, xmax - xmin, ymax - ymin);
    }

  
    public void liangBarsky(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;

        double[] p = {-dx, dx, -dy, dy};
        double[] q = {x1 - xmin, xmax - x1, y1 - ymin, ymax - y1};

        double tEnter = 0.0, tLeave = 1.0;

        for (int i = 0; i < 4; i++) {
            if (p[i] == 0) {
                if (q[i] < 0)
                    return; 
            } else {
                double t = q[i] / p[i];
                if (p[i] < 0) {
                    tEnter = Math.max(tEnter, t);
                } else {
                    tLeave = Math.min(tLeave, t);
                }
            }
        }

        if (tEnter > tLeave)
            return; 

        double xStart = x1 + tEnter * dx;
        double yStart = y1 + tEnter * dy;
        double xEnd = x1 + tLeave * dx;
        double yEnd = y1 + tLeave * dy;

       
        g.setColor(Color.RED);
        g.drawLine((int) xStart, (int) yStart, (int) xEnd, (int) yEnd);
    }

    @Override
    public void paint(Graphics gScreen) {
        gScreen.drawImage(canvas, 0, 0, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (firstClick) {
            x1 = e.getX();
            y1 = e.getY();
            firstClick = false;
        } else {
            x2 = e.getX();
            y2 = e.getY();
            firstClick = true;

            g.setColor(Color.LIGHT_GRAY);
            g.drawLine(x1, y1, x2, y2);

            liangBarsky(x1, y1, x2, y2);
            repaint();
        }
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new LiangBarskyClip();
    }
}

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class LineClippingBFA extends JFrame implements MouseListener {

    BufferedImage canvas;
    Graphics2D g;

    
    int x1, y1, x2, y2;
    boolean firstClick = true;

    int clipX = 200, clipY = 150, clipWidth = 400, clipHeight = 300;

    public LineClippingBFA() {
        setTitle("Brute Force Line Clipping");
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
        g.drawRect(clipX, clipY, clipWidth, clipHeight);
    }
    public void lineClip(int x1, int y1, int x2, int y2) {
		double m=(double)(y2 - y1) / (x2 - x1);
        double cx1 = x1, cy1 = y1, cx2 = x2, cy2 = y2;
        int xmin = clipX;
        int xmax = clipX + clipWidth;
        int ymin = clipY;
        int ymax = clipY + clipHeight;
        if (cx1 < xmin) {
            cy1 = y1 + m * (xmin - x1);
            cx1 = xmin;
        }
        if (cx2 < xmin) {
            cy2 = y2 + m * (xmin - x2);
            cx2 = xmin;
        }
        if (cx1 > xmax) {
            cy1 = y1 + m * (xmax - x1);
            cx1 = xmax;
        }
        if (cx2 > xmax) {
            cy2 = y2 + m * (xmax - x2);
            cx2 = xmax;
        }
        if (cy1 < ymin) {
            cx1 = x1 + (ymin - y1) / m;
            cy1 = ymin;
        }
        if (cy2 < ymin) {
            cx2 = x2 + (ymin - y2) / m;
            cy2 = ymin;
        }
        if (cy1 > ymax) {
            cx1 = x1 + (ymax - y1) / m;
            cy1 = ymax;
        }
        if (cy2 > ymax) {
            cx2 = x2 + (ymax - y2) / m;
            cy2 = ymax;
        }
        if (cx1 >= xmin && cx1 <= xmax && cy1 >= ymin && cy1 <= ymax &&
            cx2 >= xmin && cx2 <= xmax && cy2 >= ymin && cy2 <= ymax) {

            g.setColor(Color.RED);
            g.drawLine((int) cx1, (int) cy1, (int) cx2, (int) cy2);
        
        }
    }
    public void paint(Graphics gScreen) {
        gScreen.drawImage(canvas, 0, 0, null);
    }

  
    public void mouseClicked(MouseEvent e) {
        if (firstClick) {
            x1 = e.getX();
            y1 = e.getY();
            firstClick = false;
        } else {
            x2 = e.getX();
            y2 = e.getY();
            firstClick = true;

            lineClip(x1, y1, x2, y2);
            repaint();
        }
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new LineClippingBFA();
    }
}

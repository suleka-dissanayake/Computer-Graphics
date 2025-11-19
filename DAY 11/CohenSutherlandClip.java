import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class CohenSutherlandClip extends JFrame implements MouseListener {

    BufferedImage canvas;
    Graphics2D g;

    int x1, y1, x2, y2;
    boolean firstClick = true;

    
    int xmin = 200, ymin = 150, xmax = 600, ymax = 450;

    
    const int INSIDE = 0; 
    const int LEFT = 1;   
    const int RIGHT = 2; 
    const int BOTTOM = 4; 
    const int TOP = 8;    

    public CohenSutherlandClip() {
        setTitle("Cohen–Sutherland Line Clipping");
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

    
    int computeCode(double x, double y) {
        int code = INSIDE;

        if (x < xmin)
            code |= LEFT;
        else if (x > xmax)
            code |= RIGHT;
        if (y < ymin)
            code |= BOTTOM;
        else if (y > ymax)
            code |= TOP;

        return code;
    }

 
    void cohenSutherlandClip(double x1, double y1, double x2, double y2) {
        int code1 = computeCode(x1, y1);
        int code2 = computeCode(x2, y2);
        boolean accept = false;

        while (true) {
            if ((code1 | code2) == 0) {
             
                accept = true;
                break;
            } else if ((code1 & code2) != 0) {
             
                break;
            } else {
                double x = 0, y = 0;
                int codeOut = (code1 != 0) ? code1 : code2;
                double m = (double)(y2 - y1) / (x2 - x1);

                if ((codeOut & TOP) != 0) {
                    x = x1 + (1.0 / m) * (ymax - y1);
                    y = ymax;
                } else if ((codeOut & BOTTOM) != 0) {
                    x = x1 + (1.0 / m) * (ymin - y1);
                    y = ymin;
                } else if ((codeOut & RIGHT) != 0) {
                    y = y1 + m * (xmax - x1);
                    x = xmax;
                } else if ((codeOut & LEFT) != 0) {
                    y = y1 + m * (xmin - x1);
                    x = xmin;
                }

                if (codeOut == code1) {
                    x1 = x;
                    y1 = y;
                    code1 = computeCode(x1, y1);
                } else {
                    x2 = x;
                    y2 = y;
                    code2 = computeCode(x2, y2);
                }
            }
        }

        if (accept) {
           
            g.setColor(Color.RED);
            g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        } else {
            g.setColor(Color.LIGHT_GRAY);
            g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
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

            cohenSutherlandClip(x1, y1, x2, y2);
            repaint();
        }
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new CohenSutherlandClip();
    }
}

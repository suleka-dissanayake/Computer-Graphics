import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class MidpointSubdivisionClip extends JFrame implements MouseListener {

    BufferedImage canvas;
    Graphics2D g;

    int x1, y1, x2, y2;
    boolean firstClick = true;

    int INSIDE = 0; 
    int LEFT = 1;   
    int RIGHT = 2; 
    int BOTTOM = 4; 
    int TOP = 8;  
   
    int xmin = 200, ymin = 150, xmax = 600, ymax = 450;

    public MidpointSubdivisionClip() {
        setTitle("Midpoint Subdivision Line Clipping");
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

   
    void midpointClip(double x1, double y1, double x2, double y2) {
        int code1 = computeCode(x1, y1);
        int code2 = computeCode(x2, y2);

        if ((code1 | code2) == 0) {
            g.setColor(Color.RED);
            g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
            return;
        }

     
        if ((code1 & code2) != 0) {
            g.setColor(Color.LIGHT_GRAY);
            g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
            return;
        }

      
        double xm = (x1 + x2) / 2.0;
        double ym = (y1 + y2) / 2.0;

        
        if (Math.abs(x1 - x2) < 0.5 && Math.abs(y1 - y2) < 0.5)
            return;

        midpointClip(x1, y1, xm, ym);
        midpointClip(xm, ym, x2, y2);
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

            midpointClip(x1, y1, x2, y2);
            repaint();
        }
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new MidpointSubdivisionClip();
    }
}

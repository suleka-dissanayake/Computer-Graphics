import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class LineClipping1 extends JFrame implements MouseListener {

    BufferedImage canvas;
    Graphics g;

    // First and second click points
    int x1 , y1, x2 , y2 ;
    boolean firstClick = true;

    // Clipping rectangle
    int clipX = 200, clipY = 150, clipWidth = 400, clipHeight = 300;

    public LineClipping1() {
        setTitle("Line Clipping");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(this);
        setLocationRelativeTo(null);
        setVisible(true);

        canvas = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        g = canvas.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 800, 600);

        // Draw clipping rectangle
        g.setColor(Color.BLACK);
        g.drawRect(clipX, clipY, clipWidth, clipHeight);
    }

    // Simple line clipping (draw only if both points are inside)
    public void lineClip(int x1, int y1, int x2, int y2) {
       
        if ((x1 >= clipX && x1 <= clipX + clipWidth && y1 >= clipY && y1 <= clipY + clipHeight) &&
            (x2 >= clipX && x2 <= clipX + clipWidth && y2 >= clipY && y2 <= clipY + clipHeight)) {
            g.setColor(Color.RED);
            g.drawLine(x1, y1, x2, y2);
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
        new LineClipping1();
    }
}

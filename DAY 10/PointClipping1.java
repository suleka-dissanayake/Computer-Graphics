import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class PointClipping1 extends JFrame implements MouseListener {

    BufferedImage canvas;
    Graphics g;

    public PointClipping1() {
        setTitle("Point Clipping");
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
        g.fillRect(200, 150, 400, 300);
    }

    public void pointClip(int x, int y) {
        if (x >= 200 && x <= 600 && y >= 150 && y <= 450) {
            g.setColor(Color.RED);
            g.fillOval(x - 10, y - 10, 20, 20);
        }
    }

    public void lineClip(int x1, int y1, int x2, int y2){
        if((x1 >= 200 && x1 <= 600 && y1 >= 150 && y1 <= 450) && (x2 >= 200 && x2 <= 600 && y2 >= 150 && y2 <= 450)){
            g.setColor(Color.RED);
            g.drawLine(x1, y1, x2, y2);
        }
    }

    public void paint(Graphics gScreen) {
        gScreen.drawImage(canvas, 0, 0, null);
    }

    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        pointClip(x, y); 
        repaint();
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new PointClipping1();
    }
}

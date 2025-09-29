import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BresenhamLineAlgorithm extends JFrame implements MouseListener {
    Graphics g;
    int x1, y1, x2, y2;

    BresenhamLineAlgorithm() {
        setTitle("Bresenham Algorithm");
        setSize(800, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(this);
        setLocationRelativeTo(null);
        setVisible(true);
        g = getGraphics();
    }

    public void bresenhamLine(int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int step_x = x1 < x2 ? 1 : -1;
        int step_y = y1 < y2 ? 1 : -1;
        boolean isStep = dy > dx;

        if(isStep){
            int temp = dx;
            dx = dy;
            dy = temp;
        }

        int decision_parameter = 2*dy - dx;
        int x = x1, y = y1;

        for (int i = 0; i <= dx; i++) {
            g.fillRect(x, y, 1, 1);

            if(decision_parameter > 0){
                if(isStep) x += step_x;
                else y += step_y;
                decision_parameter -= 2*dx;
            }

            if(isStep) y += step_y;
            else x += step_x;
            decision_parameter += 2*dy;
        }
    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
    }
    public void mouseReleased(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        bresenhamLine(x1, y1, x2, y2);
    }

    public static void main(String[] args) {
        new BresenhamLineAlgorithm();
    }
}
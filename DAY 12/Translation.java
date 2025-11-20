import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Translation extends JFrame implements MouseListener {
    int x1, y1;
    double[][] p;
    boolean shapeDrawn = false;

    public Translation() {
        setTitle("Translation - Graphics");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(this);
        p = new double[3][3];
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (shapeDrawn) {
            int[] xPoints = new int[3];
            int[] yPoints = new int[3];
            for (int i = 0; i < 3; i++) {
                xPoints[i] = (int) p[i][0];
                yPoints[i] = (int) p[i][1];
            }
            g.setColor(Color.BLUE);
            g.drawPolygon(xPoints, yPoints, 3);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();

        p[0][0] = x1;
        p[0][1] = y1;
        p[1][0] = x1 + 100;
        p[1][1] = y1;
        p[2][0] = x1 + 50;
        p[2][1] = y1 - 100;

        shapeDrawn = true;
        repaint();

        for (int i = 0; i < 3; i++) {
            p[i][0] += 50;
            p[i][1] += 50;
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        repaint();
    }

    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new Translation();
    }
}
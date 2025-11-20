import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rotation extends JFrame implements MouseListener {

    int x1, y1;
    double[][] P;
    boolean shapeDrawn = false;

    public Rotation() {
        setTitle("Rotation - Computer Graphics");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(this);
        P = new double[3][3];
        setVisible(true);
    }

    public void DDA(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;

        int steps = Math.max(Math.abs(dx), Math.abs(dy));

        double xinc = dx * 1.0 / steps;
        double yinc = dy * 1.0 / steps;

        double x = x1;
        double y = y1;

        for (int i = 0; i <= steps; i++) {
            g.drawLine((int) Math.round(x), (int) Math.round(y),
                       (int) Math.round(x), (int) Math.round(y));
            x += xinc;
            y += yinc;
        }
    }

    void drawObject(Graphics g, double[][] p) {
        DDA(g, (int)p[0][0], (int)p[1][0], (int)p[0][1], (int)p[1][1]);
        DDA(g, (int)p[0][1], (int)p[1][1], (int)p[0][2], (int)p[1][2]);
        DDA(g, (int)p[0][2], (int)p[1][2], (int)p[0][0], (int)p[1][0]);
    }

    double[][] multiply(double[][] A, double[][] B) {
        double[][] R = new double[A.length][B[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    R[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return R;
    }

    double[][] rotationMatrix(double angle) {
        double theta = Math.toRadians(angle);
        return new double[][] {
            {Math.cos(theta), -Math.sin(theta), 0},
            {Math.sin(theta),  Math.cos(theta), 0},
            {0, 0, 1}
        };
    }

    void rotate() {
        double[][] ro = rotationMatrix(60.0);
        P = multiply(ro, P);
    }

    void drawShape() {
        P[0][0] = x1;
        P[1][0] = y1;
        P[2][0] = 1;

        P[0][1] = x1 + 50;
        P[1][1] = y1 + 100;
        P[2][1] = 1;

        P[0][2] = x1 - 50;
        P[1][2] = y1 + 100;
        P[2][2] = 1;

        shapeDrawn = true;
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (shapeDrawn) {
            g.setColor(Color.BLUE);
            drawObject(g, P);
            rotate();
            g.setColor(Color.RED);
            drawObject(g, P);
        }
    }

    public void mouseClicked(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
        drawShape();
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new Rotation();
    }
}
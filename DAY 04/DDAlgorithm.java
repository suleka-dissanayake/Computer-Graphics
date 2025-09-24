import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class DDAlgorithm extends JFrame {
    private DrawPanel drawPanel;

    public DDAlgorithm() {
        setTitle("DDA Algorithm - Draw MATH");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        drawPanel = new DrawPanel();
        add(drawPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new DDAlgorithm();
    }
}

class DrawPanel extends JPanel implements MouseListener {
    private java.util.List<Line> lines = new ArrayList<>();

    public DrawPanel() {
        addMouseListener(this);
    }

    public void drawMATH(int x, int y){
        lines.clear();

        // Defining M
        dda(x, y, x, y + 50);
        dda(x, y, x + 10, y + 25);
        dda(x + 10, y + 25, x + 20, y);
        dda(x + 20, y, x + 20, y + 50);

        // Defining A
        dda(x + 30, y + 50, x + 40, y);
        dda(x + 40, y, x + 50, y + 50);
        dda(x + 35, y + 25, x + 45, y + 25);

        // Defining T
        dda(x + 60, y, x + 80, y);
        dda(x + 70, y, x + 70, y + 50);

        // Defining H
        dda(x + 90, y, x + 90, y + 50);
        dda(x + 110, y, x + 110, y + 50);
        dda(x + 90, y + 25, x + 110, y + 25);

        repaint();
    }

    private void dda(int x1, int y1, int x2, int y2){
        lines.add(new Line(x1, y1, x2, y2));
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.BLACK);
        g.setColor(Color.WHITE);

        for(Line line : lines){
            drawDDALine(g, line.x1, line.x2, line.y1, line.y2);
        }
    }

    private void drawDDALine(Graphics g, int x1, int x2, int y1, int y2){
        int dx = x2 - x1;
        int dy = y2 - y1;
        int steps = Math.max(Math.abs(dx), Math.abs(dy));

        float xInc = dx / (float) steps;
        float yInc = dy / (float) steps;

        float x = x1;
        float y = y1;

        for(int i = 0; i <= steps; i++){
            g.drawRect(Math.round(x), Math.round(y), 1, 1);
            x += xInc;
            y += yInc;
        }
    }

    private static class Line{
        int x1, y1, x2, y2;

        public Line(int x1, int y1, int x2, int y2){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        drawMATH(e.getX(), e.getY());
    }

    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
}

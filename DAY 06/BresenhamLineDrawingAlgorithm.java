import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class BresenhamLineDrawingAlgorithm extends JFrame implements MouseListener{
    Graphics g;
    Graphics2D g2;
    int x1, y1, x2, y2;
    boolean isDrawn = false;

    BresenhamLineDrawingAlgorithm(){
        setTitle("Incremetal Algorithm");
        setSize(800, 600);
        setLayout(null);
        addMouseListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        g = getGraphics();
        g2 = (Graphics2D) g;
    }

    public void incrementalLineAlgorithm(int x1, int y1, int x2, int y2){
        if(x1 > x2){
            incrementalLineAlgorithm(x2, y2, x1, y1);
        }

        int y = y1;
        int dy = y2 - y1;
        int dx = x2 - x1;
        int p = 2 * dy - dx;

        if(Math.abs(m) <= 1){   // if m < 45 degrees
            for (int i = x1; i <= x2; i++) {
                g.drawLine(
                    (int) Math.round(i),
                    (int) Math.round(y),
                    (int) Math.round(i),
                    (int) Math.round(y)
                );               
                y += m;
                if(p < 0){
                    x += 1;
                }
            }
        } else{
            System.out.println("Error in slope!");
        }
    }

    public void mouseClicked(MouseEvent e){
        if(!isDrawn){
            Font myFont = new Font("Arial", Font.BOLD, 24);
            g.setFont(myFont);
            g2.drawString("Incremental line", 100, 100);
            isDrawn = true;
        }
    }

    public void mouseEntered(MouseEvent e){

    }

    public void mouseExited(MouseEvent e){

    }

    public void mousePressed(MouseEvent e){
        x1 = e.getX();
        y1 = e.getY();
    }

    public void mouseReleased(MouseEvent e){
        x2 = e.getX();
        y2 = e.getY();
        g.setColor(Color.RED);
        g2.setStroke(new BasicStroke(3));
        
        incrementalLineAlgorithm(x1, y1, x2, y2);
    }

    public static void main(String[] args) {
        new BresenhamLineDrawingAlgorithm();
    }
}
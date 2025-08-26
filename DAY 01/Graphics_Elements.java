import java.awt.*;
import javax.swing.*;

public class Graphics_Elements extends JFrame {
    Graphics_Elements(){
        setSize(800, 500);
        setTitle("Frame");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void paint(Graphics g){
        g.setColor(Color.green);
        g.drawLine(40, 50, 500, 50);

        g.setColor(Color.red);
        g.drawString("Hi", 250, 150);

        g.setColor(Color.blue);
        g.drawRect(50, 50, 200, 30);
        g.fillRect(50, 50, 200, 30);
    }

    public static void main(String[] args) {
        new Graphics_Elements();
    }
}

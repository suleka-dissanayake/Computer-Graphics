import javax.swing.*;

public class First_Frame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(new java.awt.Point(100, 30));
        frame.setTitle("Empty Frame");
        frame.setVisible(true);
    }
}
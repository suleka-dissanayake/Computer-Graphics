import javax.swing.*;

public class Second_Frame {
    public static void main(String[] args) {
        JFrame frame1 = new JFrame();
        frame1.setSize(400, 300);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLocation(new java.awt.Point(100, 30));
        frame1.setTitle("My 2nd Frame");

        JButton button = new JButton("Click here");
        button.setBounds(130, 100, 100, 40);

        frame1.add(button);
        frame1.setLayout(null);
        frame1.setVisible(true);
    }
}
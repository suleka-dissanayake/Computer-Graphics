import javax.swing.*;

class Login_Button{
    
    Login_Button(){
        JFrame frame = new JFrame("Image example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JButton button = new JButton(new ImageIcon("btn.png"));
        button.setBounds(100, 100, 200, 40);
        frame.add(button);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Login_Button();
    }
}
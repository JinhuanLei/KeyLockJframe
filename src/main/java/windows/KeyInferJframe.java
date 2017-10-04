package windows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyInferJframe extends JFrame implements ActionListener {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        KeyInferJframe test=new KeyInferJframe();
    }
    public KeyInferJframe(){
        this.setTitle("Search Information");
        this.setBounds(720, 360, 550, 350);
        JPanel panel2 = new JPanel();
       this.add(panel2);
        placeComponents(panel2);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void placeComponents(JPanel panel) {

    }

    public void actionPerformed(ActionEvent e) {

    }
}

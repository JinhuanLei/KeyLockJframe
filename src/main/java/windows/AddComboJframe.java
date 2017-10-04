package windows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddComboJframe extends JFrame implements ActionListener {

    public static void main(String args[])
    {
        AddComboJframe akj=new AddComboJframe();
    }
    public AddComboJframe()
    {
        this.setTitle("Add");
        this.setBounds(720, 360, 550, 360);
        JPanel panel2 = new JPanel();
        this.add(panel2);
       placeComponents(panel2);
        this.setVisible(true);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

    }


    public void actionPerformed(ActionEvent e) {

    }
}

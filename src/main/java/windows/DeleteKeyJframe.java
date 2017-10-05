package windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteKeyJframe extends JFrame implements ActionListener {

    JTextField jtf;
    JTextField jtf2;

    int keyid1;
    public DeleteKeyJframe(int keyid2)
    {
        keyid1=keyid2;
        this.setTitle("Update");
        this.setBounds(720, 360, 550, 360);
        JPanel panel2 = new JPanel();
        this.add(panel2);
        placeComponents(panel2);
        this.setVisible(true);

        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);
        JLabel jl=new JLabel("Key Id:");
        jl.setBounds(50,50,150,30);
        jl.setFont(new   java.awt.Font("Dialog",   1,   20));
        panel.add(jl);


        jtf=new JTextField();
        jtf.setBounds(160,50,120,30);
        panel.add(jtf);
        if(keyid1!=0)
        {
            jtf.setText(String.valueOf(keyid1));
        }


        JLabel j2=new JLabel("Lock Id:");
        j2.setBounds(50,100,150,30);
        j2.setFont(new   java.awt.Font("Dialog",   1,   20));
        panel.add(j2);

        jtf2=new JTextField();
        jtf2.setBounds(160,100,120,30);
        panel.add(jtf2);

        JButton submitButton=new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(100,30));
        submitButton.setFont(new   java.awt.Font("Dialog",   1,   20));
        submitButton.setBounds(200, 200, 100, 50);
        panel.add(submitButton);
        submitButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String source = e.getActionCommand();
        if(source=="Submit")
        {
            String skeyid=jtf.getText().trim();
            String slockid=jtf2.getText().trim();
            int keyid=Integer.parseInt(skeyid);
            int lockid=Integer.parseInt(slockid);
            try {
                MainJframe.m.deleteKey(keyid,lockid);
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(this, "Invaid Input.", "Wrong", JOptionPane.ERROR_MESSAGE);
            }
        dispose();
        }
    }
}
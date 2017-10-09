package windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddComboJframe extends JFrame implements ActionListener {
    JTextField jtf;
//    JRadioButton radioButton1;
//    JRadioButton radioButton2;
//    boolean selected;
    static Boolean status;
    public static void main(String args[])
    {
        AddComboJframe akj=new AddComboJframe();
    }
    public AddComboJframe()
    {
        this.setTitle("Add");
        this.setBounds(640, 360, 550, 360);
        JPanel panel2 = new JPanel();
        this.add(panel2);
       placeComponents(panel2);
        this.setVisible(true);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);
        JLabel jl=new JLabel("Room Number:");
        jl.setBounds(50,50,200,30);
        jl.setFont(new   java.awt.Font("Dialog",   1,   20));
        panel.add(jl);

        jtf=new JTextField();
        jtf.setBounds(200,50,120,30);
        panel.add(jtf);

//        JLabel j2=new JLabel("Key Type :");
//        j2.setBounds(50,100,120,30);
//        j2.setFont(new   java.awt.Font("Dialog",   1,   20));
//        panel.add(j2);
//
//        radioButton1=new JRadioButton("Swipe Card",true);
//        radioButton2=new JRadioButton("Physical key");
//
//       // System.out.println("..........................."+selected);
//        radioButton1.setBounds(150,105,120,30);
//        radioButton2.setBounds(270,105,120,30);
//        panel.add(radioButton1);
//        panel.add(radioButton2);
//        ButtonGroup group=new ButtonGroup();
//        group.add(radioButton1);
//        group.add(radioButton2);

        JButton submitButton=new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(100,30));
        submitButton.setFont(new   java.awt.Font("Dialog",   1,   20));
        submitButton.setBounds(100, 200, 100, 50);
        panel.add(submitButton);
        submitButton.addActionListener(this);

        JButton cancelButton=new JButton("Cancel");
        cancelButton.setPreferredSize(new Dimension(100,30));
        cancelButton.setFont(new   java.awt.Font("Dialog",   1,   20));
        cancelButton.setBounds(300, 200, 100, 50);
        panel.add(cancelButton);
        cancelButton.addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
         status=false;
        String source = e.getActionCommand();
        if(source=="Submit")
        {
            //selected=  radioButton2.isSelected();
            //System.out.println("..........................."+selected);
            String roomNumber=jtf.getText().trim();
            int id=Integer.parseInt(roomNumber);
            try {
                MainJframe.m.addNewLock(id);
                status=true;

               } catch (Exception e1) {
                JOptionPane.showMessageDialog(this, "There is no such room.", "Wrong", JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            dispose();

        }

    if(status==true)
    {
        dispose();
    }

    }
    }


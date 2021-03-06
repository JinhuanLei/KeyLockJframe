package windows;

import core.Key1;
import core.Lock1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import static windows.MainJframe.m;

public class DeleteKeyJframe extends JFrame implements ActionListener {

    JTextField jtf;
    JTextField jtf2;

    int keyid1;
    int lockid1;
    int status=0;
    public DeleteKeyJframe(int keyid2)
    {
        keyid1=keyid2;
        status=0;
        this.setTitle("Delete");
        this.setBounds(640, 360, 550, 360);
        JPanel panel2 = new JPanel();
        this.add(panel2);
        placeComponents(panel2);
        this.setVisible(true);

        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public DeleteKeyJframe(int lockid2,String str)
    {
        lockid1=lockid2;
        status=1;                 //1 是锁  0是key
        this.setTitle("Delete");
        this.setBounds(640, 360, 550, 360);
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
        if(lockid1!=0)
        {
            jtf2.setText(String.valueOf(lockid1));
        }

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
        String source = e.getActionCommand();
        Boolean status=false;
        if(source=="Submit")
        {
            String skeyid=jtf.getText().trim();
            String slockid=jtf2.getText().trim();
            int keyid=Integer.parseInt(skeyid);
            int lockid=Integer.parseInt(slockid);
            try {
                m.deleteKey(keyid,lockid);
                //Key1 k=m.searchKey(keyid);
                //System.out.println("删除后搜索keyid"+k.getID());
               //HashSet<Lock1> hs= m.searchLocksOpenedByGivenKey(keyid);
               //System.out.println("size"+ hs.size());
                status=true;
            } catch (Exception e1) {
               //e1.printStackTrace();
                JOptionPane.showMessageDialog(this, e1, "Wrong", JOptionPane.ERROR_MESSAGE);
            }

        }else{
            dispose();
        }

        if(status==true)
        {
            dispose();
        }


    }
}

package windows;

import bean.lockbean;
import core.Key1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyInferJframe extends JFrame implements ActionListener {

//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        KeyInferJframe test=new KeyInferJframe(null,null);
//    }
   Key1  ki;
   lockbean[] lb;
    JTextArea jta;
    public KeyInferJframe(Key1 keyinfer, lockbean[] lockbean){
        this.setTitle("Search Information");
        this.setBounds(720, 360, 550, 360);
        JPanel panel2 = new JPanel();
       this.add(panel2);
        ki=keyinfer;
        lb=lockbean;
       placeComponents(panel2);
        this.setVisible(true);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);
        JLabel nameLable = new JLabel("Key"+ki.getID());
        nameLable.setBounds(30,20,80,30);
        nameLable.setFont(new   java.awt.Font("Dialog",   1,   20));
        panel.add(nameLable);

        jta=new JTextArea();
        jta.setFont(new   java.awt.Font("Dialog",   0,   16));
        jta.setBounds(30,50,450,220);
        panel.add(jta);
         showdata();

        JButton updateButton = new JButton("Update the key");
        updateButton.setPreferredSize(new Dimension(180,30));
        updateButton.setFont(new   java.awt.Font("Dialog",   1,   20));
        updateButton.setBounds(30, 270, 180, 50);
        panel.add(updateButton);
        if(ki.getType()==true)
        {
            updateButton.addActionListener(this);
        }

        JButton deleteButton = new JButton("Delete the key");
        deleteButton.setPreferredSize(new Dimension(180,30));
        deleteButton.setFont(new   java.awt.Font("Dialog",   1,   20));
        deleteButton.setBounds(280, 270, 180, 50);
        panel.add(deleteButton);
        deleteButton.addActionListener(this);


    }
public void showdata()
{
    if(lb.length>1)
    {
        jta.append("Key Type: Master key"+"\r\n");
    }
    else {
        if (ki.getType()==true)
        {
            jta.append("Key Type: Physical key"+"\r\n");
        }
        else{
            jta.append("Key Type: Swipe Card"+"\r\n");
        }


    }
    if(lb.length==0)
    {
        jta.append("This key can not find any match lock");
    }
    for(int x=0;x<lb.length;x++)
    {
        jta.append("Match Lock "+(x+1)+" [ ID: "+lb[x].getID()+" roomNumber: "+lb[x].getRoomNumber()+"]"+"\r\n");
    }
}
    public void actionPerformed(ActionEvent e) {
        String source = e.getActionCommand();
        if(source=="Update the key")
        {
            new UpdateKeyJframe(ki.getID());
        }
        else if(source=="Delete the key")
        {
               new DeleteKeyJframe(ki.getID());
        }
    }
}

package windows;

import bean.lockbean;
import core.Key1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyInferJframe extends JFrame implements ActionListener {

//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        KeyInferJframe test=new KeyInferJframe(null,null);
//    }
   Key1  ki;
   lockbean[] lb;
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
        JTextArea jta=new JTextArea();
        jta.setFont(new   java.awt.Font("Dialog",   0,   16));
        jta.setBounds(30,50,450,220);
        panel.add(jta);
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
        for(int x=0;x<lb.length;x++)
        {
            jta.append("Match Lock "+(x+1)+" [ ID: "+lb[x].getID()+" roomNumber: "+lb[x].getRoomNumber()+"]"+"\r\n");
        }


    }

    public void actionPerformed(ActionEvent e) {

    }
}

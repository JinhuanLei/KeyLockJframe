package windows;

import bean.keybean;
import bean.lockbean;
import com.google.gson.Gson;
import core.ConvertJson;
import core.Lock1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LockInferJframe extends JFrame implements ActionListener {
    Lock1 li;
    keybean[] kb;
    public LockInferJframe(Lock1 lockinfer, keybean[] keybean)
    {
        this.setTitle("Search Information");
        this.setBounds(640, 360, 550, 360);
        JPanel panel2 = new JPanel();
        this.add(panel2);
        li=lockinfer;
        kb=keybean;
        placeComponents(panel2);
        this.setVisible(true);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);
        JLabel nameLable = new JLabel("Lock"+li.getID());
        nameLable.setBounds(30,20,120,30);
        nameLable.setFont(new   java.awt.Font("Dialog",   1,   20));
        panel.add(nameLable);
        JTextArea jta=new JTextArea();
        jta.setFont(new java.awt.Font("Dialog",   0,   16));
        jta.setBounds(30,50,450,220);
        panel.add(jta);
        jta.append("RoomNumber :"+li.getRoomNumber()+"\r\n");
        for(int x=0;x<kb.length;x++)
        {
            jta.append("Match Key "+(x+1)+" [ ID: "+kb[x].getID()+" KeyType: "+judgeKeys(kb[x].getID(),kb[x].isType())+"]"+"\r\n");
        }
    }

    public String judgeKeys(String sid,Boolean type)
    {
        int id=Integer.parseInt(sid);

        try {

            ConvertJson cj=new ConvertJson();
            String lock=cj.set2json(MainJframe.m.searchLocksOpenedByGivenKey(id));
            lockbean[] lb=new Gson().fromJson(lock,lockbean[].class);
            if(lb.length>1)
            {

                return "Master key";
            }
            else {
                if (type==true)
                {

                    return "Physical key";
                }
                else{
                   return "Swipe card";
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
              return null;
    }
    public void actionPerformed(ActionEvent e) {

    }
}

package windows;

import bean.keybean;
import bean.lockbean;
import com.google.gson.Gson;
import core.ConvertJson;
import core.Lock1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static windows.MainJframe.m;

public class LockInferJframe extends JFrame implements ActionListener {
    Lock1 li;
    keybean[] kb;
    JTextArea jta;
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
         jta=new JTextArea();
        jta.setFont(new java.awt.Font("Dialog",   0,   16));
        jta.setBounds(30,50,450,220);
        panel.add(jta);
        showdata();


        JButton deleteButton = new JButton("Delete the key");
        deleteButton.setPreferredSize(new Dimension(180,30));
        deleteButton.setFont(new   java.awt.Font("Dialog",   1,   20));
        deleteButton.setBounds(330, 270, 180, 50);
        panel.add(deleteButton);
        deleteButton.addActionListener(this);

        JButton freshButton = new JButton("Refresh");
        freshButton.setPreferredSize(new Dimension(60,30));
        freshButton.setFont(new   java.awt.Font("Dialog",   1,   20));
        freshButton.setBounds(210, 270, 110, 50);
        panel.add(freshButton);
        freshButton.addActionListener(this);
    }

    private void showdata() {
        jta.setText("");
        jta.append("RoomNumber :"+li.getRoomNumber()+"\r\n");
        if(kb==null)
        {
            jta.append("This key can not find any match lock");
            return;
        }
        for(int x=0;x<kb.length;x++)
        {
            jta.append("Match Key "+(x+1)+" [ ID: "+kb[x].getID()+" KeyType: "+judgeKeys(kb[x].getID(),kb[x].isType())+"]"+"\r\n");
        }
    }
    private void refreshdata() {
        int lockid =li.getID();
        ConvertJson cj=new ConvertJson();
        try {
            if(m.searchKeysOpeningGivenLock(lockid).size()!=0)
            {
                String key=cj.set2json(m.searchKeysOpeningGivenLock(lockid));
                keybean[] kb1;
                kb1=new Gson().fromJson(key,keybean[].class);
                kb=kb1;
                for(int x=0;x<kb.length;x++)
                {
                    System.out.println(kb[x].getID());
                }

            }
            else{
                kb=null;
            }

            showdata();


        } catch (Exception e) {
            e.printStackTrace();
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
        String source = e.getActionCommand();
        if(source=="Delete the key")
        {
            new DeleteKeyJframe(li.getID(),"");
        }

        if(source=="Refresh")
        {
refreshdata();
        }
    }


}

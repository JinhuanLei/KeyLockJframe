package windows;

import core.*;
import function.dataoperate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import function.dataoperate;
class Jframe2 extends JFrame implements ActionListener {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
       Jframe2 test=new Jframe2();
    }
    public Jframe2(){
        this.setTitle("窗口2");
        this.setBounds(100, 100, 1500, 900);

        JPanel panel2 = new JPanel();
        // 添加面板
        this.add(panel2);
        /*
         * 调用用户定义的方法并添加组件到面板
         */
        placeComponents(panel2);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         }

       public void placeComponents(JPanel panel)
       {
           panel.setLayout(null);
           JButton InitialButton = new JButton("Initial Data");
           InitialButton.setPreferredSize(new Dimension(100,30));
           InitialButton.setFont(new   java.awt.Font("Dialog",   1,   20));
           InitialButton.setBounds(130, 90, 160, 50);
           panel.add(InitialButton);
           InitialButton.addActionListener(this);

           JButton RefreshButton = new JButton("Refresh Data");
           RefreshButton.setPreferredSize(new Dimension(100,30));
           RefreshButton.setFont(new   java.awt.Font("Dialog",   1,   20));
           RefreshButton.setBounds(320, 90, 160, 50);
           panel.add(RefreshButton);
           RefreshButton.addActionListener(this);

           JButton ComboButton = new JButton("Add a combination");
           ComboButton.setPreferredSize(new Dimension(190,30));
           ComboButton.setFont(new   java.awt.Font("Dialog",   1,   20));
           ComboButton.setBounds(130, 195, 220, 50);
           panel.add(ComboButton);
           ComboButton.addActionListener(this);

           JButton KeyButton = new JButton("Add a new key");
           KeyButton.setPreferredSize(new Dimension(190,30));
           KeyButton.setFont(new   java.awt.Font("Dialog",   1,   20));
           KeyButton.setBounds(130, 300, 190, 50);
           panel.add(KeyButton);
           KeyButton.addActionListener(this);

           JButton UpdateKeyButton = new JButton("Update a  key");
           UpdateKeyButton.setPreferredSize(new Dimension(190,30));
           UpdateKeyButton.setFont(new   java.awt.Font("Dialog",   1,   20));
           UpdateKeyButton.setBounds(350, 300, 180, 50);
           panel.add(UpdateKeyButton);
           UpdateKeyButton.addActionListener(this);

           JTextArea jtakey=new JTextArea(100,100);
           jtakey.setBounds(900,70,500,350);
           panel.add(jtakey);

           JTextArea jtalock=new JTextArea(100,100);
           jtalock.setBounds(900,480,500,350);
           panel.add(jtalock);


       }

    public void actionPerformed(ActionEvent e) {
        String source = e.getActionCommand();
        if(source=="Initial Data")
        {
            dataoperate.initialdata();
        }


    }
}
package windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class mainpage extends JFrame implements ActionListener {

    JButton jbutton=null;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        mainpage test=new mainpage();
    }
    public mainpage(){
        jbutton=new JButton("点击打开窗口2");
        jbutton.addActionListener(this);
        this.add(jbutton);
        this.setTitle("窗口1");
        this.setBounds(200, 200, 600, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent arg0) {
        if(arg0.getSource()==jbutton){
            //创建一个新窗口

            new Jframe2();
        }

    }

}
//这个类可以单独写在同包下目录 也可以在这直接写
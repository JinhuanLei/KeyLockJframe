package windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class mainpage extends JFrame implements ActionListener {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        mainpage test=new mainpage();
    }
    public mainpage(){
//        jbutton=new JButton("点击打开窗口2");
//        jbutton.addActionListener(this);
//        jbutton.setBounds(10, 80, 800, 250);
       // this.add(jbutton);
        this.setTitle("窗口1");
        this.setBounds(100, 100, 1500, 900);

        JPanel panel = new JPanel();
        // 添加面板
        this.add(panel);
        /*
         * 调用用户定义的方法并添加组件到面板
         */
        placeComponents(panel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    private  void placeComponents(JPanel panel) {

        /* 布局部分我们这边不多做介绍
         * 这边设置布局为 null
         */
        panel.setLayout(null);

        // 创建 JLabel
        JLabel nameLable = new JLabel("Locks&Keys");

        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        nameLable.setBounds(640,160,300,150);
        nameLable.setFont(new   java.awt.Font("Dialog",   1,   40));
        panel.add(nameLable);


        JButton startButton = new JButton("Start");
        startButton.setPreferredSize(new Dimension(50,30));
        startButton.setFont(new   java.awt.Font("Dialog",   1,   20));
        startButton.setBounds(700, 560, 80, 50);
        panel.add(startButton);
        startButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent arg0) {
        String source = arg0.getActionCommand();
        if (source.equals("Start")) {
            new Jframe2();
        }

//        if(arg0.getSource()==jbutton){
//            //创建一个新窗口
//
//            new Jframe2();
//        }

    }

}

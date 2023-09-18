package Day0704;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingEvent_07 extends JFrame  {
    Container cp;
    JButton btn1,btn2;
    public SwingEvent_07(String title) { // 생성자 호출
        super(title);
        cp=this.getContentPane();
        this.setBounds(200,100,300,400);
        cp.setBackground(new Color(121,124,141));
        setDesign();
        setVisible(true);
    }

    public void setDesign(){
        this.setLayout(new FlowLayout());

        // 버튼1 생성, 이벤트
        btn1=new JButton("배경색을 마젠타로 변경");
        this.add(btn1);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cp.setBackground(Color.magenta);
            }
        });

        // 버튼2 생성, 이벤트
        btn2=new JButton("배경색을 오렌지색으로 변경");
        this.add(btn2);

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cp.setBackground(Color.orange);
            }
        });
    }

    public static void main(String[] args) {

        new SwingEvent_07("스윙이벤트_7"); // 생성자 생성
    }
}

package Day0630;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SwingNullLay_10 extends JFrame implements ActionListener {

        Container cp; // this.에 없는거 받아옴
        JButton btn1,btn2; // 버튼 소환!
        public SwingNullLay_10(String title) { // 생성자 호출
            super(title);
            cp=this.getContentPane();
            this.setBounds(200,100,300,400);
            cp.setBackground(new Color(121,124,141));
            setDesign();
            setVisible(true);
        }

        //디자인
        public void setDesign(){
            // 기본레이아웃을 없애기
            this.setLayout(null);
            btn1=new JButton("◀︎");
            btn2=new JButton("▶︎");

            // 위치 직접 지정
            btn1.setBounds(50,100,80,30);
            btn2.setBounds(150,100,80,30);

            // 프레임추가
            this.add(btn1);
            this.add(btn2);

            //색상
            btn1.setBackground(Color.RED);
            btn2.setBackground(Color.YELLOW);
            btn1.setForeground(Color.cyan);
            btn2.setForeground(Color.green);

            // 버튼에 이벤트 발생 : 이벤트 핸들러랑 이벤트 발생하는 객체랑 연결해줘야 한다.
            btn1.addActionListener(this); // 상속받았으니까 this를 쓴다.
            btn2.addActionListener(this); // 상속받았으니까 this를 쓴다.
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Object ob=e.getSource();
            if(ob==btn1) { // ob를 정의하여 버튼을 명확하게(버튼마다 지정하여) 설정할 수 있다.
                JOptionPane.showMessageDialog(this, "뒤로가기");
            }
            else if (ob==btn2) {
                JOptionPane.showMessageDialog(this,"앞으로가기");
            }
        }

    public static void main(String[] args) {
        new SwingNullLay_10("레이아웃 이벤트"); // 생성자 생성


    }
}

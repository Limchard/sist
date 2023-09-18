package Day0630;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingLay_09 extends JFrame implements ActionListener {
    Container cp; // this.에 없는거 받아옴
    JButton btn1,btn2,btn3; // 버튼 가져오기
    public SwingLay_09(String title) { // 생성자 호출
        super(title);
        cp=this.getContentPane();
        this.setBounds(200,100,300,400);
        cp.setBackground(new Color(121,124,141));
        setDesign();
        setVisible(true);
    }
    // 보더레이아웃이 기본, 다르게 할꺼면 일단 변경후 지정해야 한다.
    // 내맘대로할꺼면 null,
    //디자인
    public void setDesign(){
        // 기본 레이아웃 변경
        this.setLayout(new FlowLayout());
        // 버튼 생성
        btn1=new JButton("버튼 #1");
        btn2=new JButton("버튼 #2");
        btn3=new JButton("버튼 #3");
        // 프레임에 추가
        this.add(btn1);
        this.add(btn2);
        this.add(btn3);
        // 버튼 속성
        btn1.setBackground(Color.green);
        btn1.setOpaque(true);
        btn1.setBorderPainted(false);
        btn2.setBackground(Color.pink);
        btn2.setOpaque(true);
        btn2.setBorderPainted(false);
        btn3.setBackground(Color.RED);
        btn3.setOpaque(true);
        btn3.setBorderPainted(false);
        // 버튼에 이벤트 발생 : 이벤트 핸들러랑 이벤트 발생하는 객체랑 연결해줘야 한다.
        btn1.addActionListener(this); // 상속받았으니까 this를 쓴다.
        btn2.addActionListener(this); // 상속받았으니까 this를 쓴다.
        btn3.addActionListener(this); // 상속받았으니까 this를 쓴다.
    }

    //액션
    @Override
    public void actionPerformed(ActionEvent e) {
        Object ob=e.getSource(); // getSource()의 경우 object를 지정 해줘야 한다. //명확하게 하기 위해

        // 메세지를 다이얼로그 형태로 보여주는 것
        //JOptionPane.showMessageDialog(this,"버튼클릭");
        if(ob==btn1) { // ob를 정의하여 버튼을 명확하게(버튼마다 지정하여) 설정할 수 있다.
            JOptionPane.showMessageDialog(this, "1번째 버튼클릭");
        }
        else if (ob==btn2) {
            JOptionPane.showMessageDialog(this,"2번째 버튼클릭");
        }
        else if (ob==btn3) {
            JOptionPane.showMessageDialog(this,"3번째 버튼클릭");
        }
    }

    public static void main(String[] args) {

        new SwingLay_09("레이아웃 이벤트"); // 생성자 생성

    }


}

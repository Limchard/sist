package Day0704;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SwingGrid_06 extends JFrame implements ActionListener {

    Container cp; // this.에 없는거 받아옴
    // 이미지 아이콘 가져오기

    // 버튼 선언
    JButton btn1,btn2,btn3,btn4;
    ImageIcon icon1=new ImageIcon("/Users/imhyeongjun/Desktop/sist0615/file/swingimage/toy01.png");
    ImageIcon icon2=new ImageIcon("/Users/imhyeongjun/Desktop/sist0615/file/swingimage/toy02.png");
    ImageIcon icon3=new ImageIcon("/Users/imhyeongjun/Desktop/sist0615/file/swingimage/toy03.png");
    ImageIcon icon4=new ImageIcon("/Users/imhyeongjun/Desktop/sist0615/file/swingimage/toy04.png");
    public SwingGrid_06(String title) { // 생성자 호출
            super(title);
            cp=this.getContentPane();
            this.setBounds(200,100,300,400);
            cp.setBackground(new Color(121,124,141));
            setDesign();

            setVisible(true);
    }

    public void setDesign(){

        // 버튼4개 생성
        this.setLayout(new GridLayout(2,2)); // 버튼을 2행 2열로 배치하기
        btn1=new JButton("hello",icon1);
        btn1.setVerticalTextPosition(JButton.BOTTOM); // 텍스트 세로로 위치
        btn1.setHorizontalTextPosition(JButton.CENTER);
        this.add(btn1);

        btn1.setRolloverIcon(icon2);
        btn1.setPressedIcon(icon4);

        //2
        btn2=new JButton(icon4);
        this.add(btn2);

        //3
        btn3=new JButton("JAVA");
        this.add(btn3);

        //4
        btn4=new JButton("Hi!!!",icon3);
        this.add(btn4);

        // 버튼에 액션이벤트 추가
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
    }

    public static void main(String[] args) {

        new SwingGrid_06("그리드 레이아웃");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object ob=e.getSource(); // 선택하기 위한 변수를 준 것.

        if(ob==btn1){
            JOptionPane.showMessageDialog(this,"1번 이미지 입니다.");
        } else if (ob==btn2) {
            JOptionPane.showMessageDialog(this,"2번 이미지 입니다.");
        }else if (ob==btn3) {
            JOptionPane.showMessageDialog(this,"3번 java 입니다.");
        }else if (ob==btn4) {
            JOptionPane.showMessageDialog(this,"4번 이미지 입니다.");
        }
    }
}

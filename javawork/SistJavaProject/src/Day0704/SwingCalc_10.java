package Day0704;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingCalc_10 extends JFrame {

    Container cp; // this.에 없는거 받아옴
    JLabel lblResult,lbl1,lbl2; // 결과 나오는 라벨(결과창, 결과 나오는곳), 숫자1제목, 숫자2제목
    JTextField tfSu1,tfSu2; // 입력하는곳
    JButton btnAdd; // 이벤트 발생 버튼
    public SwingCalc_10(String title) { // 생성자 호출
        super(title);
        cp=this.getContentPane();
        this.setBounds(1000,100,300,400);
        cp.setBackground(new Color(121,124,141));
        setDesign();
        setVisible(true);

    }

    public void setDesign(){
        this.setLayout(null);

        lbl1=new JLabel("숫자1");
        lbl2=new JLabel("숫자2");

        lbl1.setBounds(20,20,50,30);
        this.add(lbl1);
        lbl2.setBounds(20,80,50,30);
        this.add(lbl2);

        tfSu1=new JTextField();
        tfSu1.setBounds(70,20,60,30);
        this.add(tfSu1);
        tfSu2=new JTextField();
        tfSu2.setBounds(70,80,60,30);
        this.add(tfSu2);

        btnAdd=new JButton("숫자더하기");
        btnAdd.setBounds(30,120,150,30);
        this.add(btnAdd);

        lblResult=new JLabel("결과 나오는곳");
        lblResult.setBounds(10,180,250,60);
        this.add(lblResult);


        // 버튼 이벤트인데 익명내부 클래스 형식으로 만들기
        btnAdd.addActionListener(new ActionListener() { // 익명내부클래스
            @Override
            public void actionPerformed(ActionEvent e) {
                int su1=Integer.parseInt(tfSu1.getText()); // 숫자를 가지고 온다.
                int su2=Integer.parseInt(tfSu2.getText()); // 숫자를 가지고 온다.

                int sum=su1+su2;

                String s1=sum+""; // 숫자를 문자로 보내는 방법들
                String s2=String.valueOf(sum); // 숫자를 문자로 보내는 방법들
                String s3=su1+"+"+su2; // 숫자를 문자로 보내는 방법들

                // 결과라벨지에 출력(setting 해주는 것, 결과창에 보내주는것)
                lblResult.setText(s2);
            }
        });
    }

    public static void main(String[] args) {

        new SwingCalc_10("간단계산연습"); // 생성자 생성
    }
}


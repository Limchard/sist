package Day0704;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingRandom_11 extends JFrame implements ActionListener {
    Container cp; // this.에 없는거 받아옴
    JLabel[] lblName=new JLabel[9];  // 3행 3열 이므로
    String [] str={"와일드보어","슬라임","뿔버섯","리본돼지","발록","혼테일","좀비버섯","머쉬맘","달팽이"};
    JButton btn;

    public SwingRandom_11(String title) { // 생성자 호출
        super(title);
        cp=this.getContentPane();
        this.setBounds(200,100,300,400);
        cp.setBackground(new Color(121,124,141));
        setDesign();
        setVisible(true);
    }
    // 디자인
    public void setDesign() {
        // 패널을 프레임의 센터에 추가
        JPanel pCenter=new JPanel(new GridLayout(3,3));
        this.add(pCenter,BorderLayout.CENTER);

        // 라벨을 패널에 추가
        for(int i=0;i<lblName.length;i++){
            lblName[i]=new JLabel(str[i],JLabel.CENTER);

            int r=(int)(Math.random()*256);  // rgb 컬러 0~255
            int g=(int)(Math.random()*256);  // rgb 컬러 0~255
            int b=(int)(Math.random()*256);  // rgb 컬러 0~255

            lblName[i].setBackground(new Color(r,g,b));

            //panel에 라벨 추가
            pCenter.add(lblName[i]);

            lblName[i].setOpaque(true); // 투명도 제거.. 색상이 나온다.
        }

        // 버튼 추가
        btn=new JButton("라밸색상변경");
        this.add(btn,BorderLayout.SOUTH);

        // 이벤트 추가
        btn.addActionListener(this);

    }
    public static void main(String[] args) {

        new SwingRandom_11("랜덤색상구하기"); // 생성자 생성
    }
    // 액션
    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<lblName.length;i++){
            int r=(int)(Math.random()*256);  // rgb 컬러 0~255
            int g=(int)(Math.random()*256);  // rgb 컬러 0~255
            int b=(int)(Math.random()*256);  // rgb 컬러 0~255

            lblName[i].setBackground(new Color(r,g,b));
        }

    }
}

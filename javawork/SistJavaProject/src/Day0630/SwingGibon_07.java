package Day0630;

import javax.swing.*;
import java.awt.*;

public class SwingGibon_07 extends JFrame {

    public SwingGibon_07(String Title) {
        super(Title);

        // 시작위치, 너비, 높이
        this.setBounds(500,100,300,300); // this란 JFrame을 뜻한다.
        // 종료
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 배경색
        //this.setBackground(Color.MAGENTA);
        //this.setBackground((new Color(190,234,111)));
        this.getContentPane().setBackground(Color.MAGENTA); // 색을 위에 컨테이너로 가져와 덮는 느낌이다. 그래서 색상은 컨테이너 먼저 호출해줘야 함.

        // 프레임 보이게
        this.setVisible(true);
    }


    public static void main(String[] args) {

        new SwingGibon_07("스윙기본");

    }
}

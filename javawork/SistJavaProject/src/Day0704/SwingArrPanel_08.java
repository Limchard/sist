package Day0704;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingArrPanel_08 extends JFrame implements ActionListener {

    Container cp; // this.에 없는거 받아옴
    JButton [] btn=new JButton[6];
    String [] btnLabel={"Red","Green","Gray","Cyan","Yellow","White"}; // label은 보통 제목으로 들어간다.
    Color [] btnColor={Color.red,Color.green,Color.gray,Color.cyan,Color.yellow,Color.white};
    public SwingArrPanel_08(String title) { // 생성자 호출
        super(title);
        cp=this.getContentPane();
        this.setBounds(500,100,600,400);
        cp.setBackground(new Color(121,124,141));
        setDesign();

        setVisible(true);
    }
    public void setDesign(){
        //panel 기본이 FlowLayout
        JPanel panel=new JPanel();
        panel.setBackground(Color.orange);
        // 프레임에 패널을 추가_상단인지 하단인지 위치 선택해서 해야한다.
        this.add(panel,BorderLayout.NORTH);

        // 버튼 생성
        for(int i=0;i<btn.length;i++){
            btn[i]=new JButton(btnLabel[i]);

            // 패널에 버튼 추가
            panel.add(btn[i]);

            // 버튼 6개 색상 추가
            btn[i].addActionListener(this);

            // 컬러 6가지 바꾸기
            btn[i].setBackground(btnColor[i]);
            btn[i].setOpaque(true);
            btn[i].setBorderPainted(false);

        }
    }

    public static void main(String[] args) {

        new SwingArrPanel_08("스윙 배열연습"); // 생성자 생성
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object ob=e.getSource();

        for(int i=0;i<btn.length;i++){
            //배경색 변경
            if(ob==btn[i]) {
                cp.setBackground(btnColor[i]);
                // 제목바꾸기
                this.setTitle("color: " + btnLabel[i]);
            }
        }
    }
}



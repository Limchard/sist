package Day0705;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingRadioCheck_01 extends JFrame implements ActionListener{

    Container cp; // this.에 없는거 받아옴
    JRadioButton [] rb=new JRadioButton[4]; // 하나만 선택하고 싶을때
    JCheckBox[] cb=new JCheckBox[4]; // 다중 선택의 경우 CheckBox 사용 함
    JLabel lblMessage; // 라디오버튼, 체크박스 결과값 출력할 곳.
    JPanel pTop,pBottom; // 라디오버튼, 체크박스 올릴 패널.
    Color [] colors={Color.red,Color.pink,Color.blue,Color.green};
    public SwingRadioCheck_01(String title) { // 생성자 호출
        super(title);
        cp=this.getContentPane();
        this.setBounds(500,200,700,600);
        cp.setBackground(new Color(121,124,141));
        setDesign();
        setVisible(true);
    }
    public void setDesign(){
        // 상단패널에 보더로 감싼 4개의 radio버튼 만들기
        String [] str1={"빨강","핑크","파랑","초록"};
        pTop=new JPanel();
        pTop.setBorder(new TitledBorder("글자색"));
        this.add("North",pTop);

        // 라디오 버튼 하나만 선택되도록 하려면 라디오 그룹에다가 라디오버튼을 둔다.
        ButtonGroup bg=new ButtonGroup();

        for(int i=0;i<rb.length;i++){
            rb[i]=new JRadioButton(str1[i],i==2?true:false); // 라디오버튼 생성
            rb[i].addActionListener(this); // 라디오버튼에 액션 추가
            pTop.add(rb[i]); // 4개의 버튼을 탑패널에 추가한다.
            bg.add(rb[i]); // 버튼그룹에 추가!!
        }
        ImageIcon icon=new ImageIcon("/Users/imhyeongjun/Desktop/sist0615/file/swingimage/redbird.png");
        lblMessage=new JLabel("앵그리버드 가즈아!!",icon,JLabel.CENTER);
        lblMessage.setHorizontalTextPosition(JLabel.LEFT);
        lblMessage.setBorder(new LineBorder(Color.magenta,2));
        this.add("Center",lblMessage);

        // 하든패널에 보더로 감싼 4개의 checkbox 버튼 만들기
        pBottom=new JPanel();
        pBottom.setBorder(new TitledBorder("여행해본 나라"));
        this.add("South",pBottom);

        String [] str2={"Vietnam","Japan","Taiwan","Korea"};

        for(int i=0;i<cb.length;i++){
            cb[i]= new JCheckBox(str2[i]); //
            pBottom.add(cb[i]);
            cb[i].addActionListener(this); //
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object ob=e.getSource();

        // 라디오버튼 호출처리, 메세지를 컬러별로 출력해보자.
        for(int i=0;i<rb.length;i++){
            if(ob==rb[i]){
                lblMessage.setForeground(colors[i]);
                lblMessage.setFont(new Font("",Font.BOLD,30));
            }
        }

        // 체크박스 호출처리.. 선택한 체크를 라벨베세지별 출력
        String lang="내가 여행한 나라는  ";
        for (int i=0;i<cb.length;i++){
            if(cb[i].isSelected()){
                lang+=cb[i].getText()+" ";
            }
        }
        lblMessage.setText(lang);

        // ob와 cb 분리를 위해서 클래스타입 비교를 해줘야 한다.
        if(ob instanceof JCheckBox){
            lblMessage.setText(lang);
        } else if (ob instanceof JRadioButton) {
            lblMessage.setText("앵그리버드 가즈아!!");
        }
    }

    public static void main(String[] args) {

        new SwingRadioCheck_01("라디오 체크 연습"); // 생성자 생성
    }


}


package Day0705;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SwingJTable_02 extends JFrame {
    Container cp; // this.에 없는거 받아옴
    JTable table; // 테이블
    JLabel lblTitle; // 제목
    JLabel lblOut; // 출력(마우스 클릭을 확인하기 위함)
    public SwingJTable_02(String title) { // 생성자 호출
        super(title);
        cp=this.getContentPane();
        this.setBounds(200,100,300,400);
        cp.setBackground(new Color(121,124,141));
        setDesign();
        setVisible(true);
    }
    public void setDesign(){
        String[][]data={{"김영주","서울","010-2323-4242"},
                {"최성현","경기","010-2434-2545"},
                {"장미란","인천","010-6586-5745"},
                {"박세리","제주","010-3856-8462"}
                };
        String[]title={"이름","주소","연락처"};

        lblTitle=new JLabel("JTable연습",JLabel.CENTER);
        lblOut=new JLabel("결과출력...",JLabel.CENTER);

        table=new JTable(data,title);
        JScrollPane pane=new JScrollPane(table);

        // 테이블에 마우스 이벤트 추가
        table.addMouseListener(new TableEvent()); // 내부클래스를 생성해줘야 한다.

        this.add("North",lblTitle);
        this.add("Center",pane);
        this.add("South",lblOut);
    }
    // 테이블 클릭시 발생하는 마우스 이벤트를 추가하기 위해 내부 클래스를 생성해야 한다.(상속받기 위해서)
    class TableEvent extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);

            //System.out.println("테이블 클릭!!!"); 콘솔창에 문구가 뜨면 잘 되고 있는거다.

            //선택한 행번호 얻기
            int rowNum=table.getSelectedRow();
            String str="이름: "+table.getValueAt(rowNum,0)+"\t주소: "+table.getValueAt(rowNum,1)+"\t연락처: "+table.getValueAt(rowNum,2);
            lblOut.setText(str);
        }
    }
    public static void main(String[] args) {

        new SwingJTable_02("스윙 테이블 연습"); // 생성자 생성
    }
}

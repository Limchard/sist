package Day0705;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Vector;

public class SwingTableShop_03 extends JFrame implements ActionListener {

    Container cp; // this.에 없는거 받아옴
    JTextField tfSang,tfSu,tfDan;
    JButton btnAdd;
    JTable table;
    DefaultTableModel model;

    // 저장하고 불러올 파일명
    String FILENAME="/Users/imhyeongjun/Desktop/sist0615/file/fruit.txt";
    public SwingTableShop_03(String title) { // 생성자 호출
        super(title);
        cp=this.getContentPane();
        this.setBounds(500,200,400,400);
        cp.setBackground(new Color(121,124,141));

        // 디자인
        setDesign();

        // 테이블데이터
        tableData();

        setVisible(true);
    }
    // 디자인
    public void setDesign(){
        this.setLayout(null);
        JLabel lbl1=new JLabel("상품명");
        JLabel lbl2=new JLabel("수량");
        JLabel lbl3=new JLabel("단가");

        lbl1.setBounds(30,20,80,30);
        this.add(lbl1);
        lbl2.setBounds(130,20,80,30);
        this.add(lbl2);
        lbl3.setBounds(230,20,80,30);
        this.add(lbl3);

        tfSang=new JTextField();
        tfSang.setBounds(20,60,100,40);
        this.add(tfSang);
        tfSu=new JTextField();
        tfSu.setBounds(120,60,100,40);
        this.add(tfSu);
        tfDan=new JTextField();
        tfDan.setBounds(220,60,100,40);
        this.add(tfDan);

        //버튼
        btnAdd=new JButton("추가하기");
        btnAdd.setBounds(120,120,100,30);
        this.add(btnAdd);

        //버튼에 이벤트
        btnAdd.addActionListener(this);

        //테이블 생성
        String [] title={"상품명","수량","단가","총금액"};
        model=new DefaultTableModel(title,0); //0은 행갯수
        table=new JTable(model);
        JScrollPane js=new JScrollPane(table);
        js.setBounds(20,160,350,160);
        this.add(js);

        //테이블 클릭시 선택한 행번호를 selectRow값에 저장하기.
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int selectRow=table.getSelectedRow(); // 행번호 저장하는 것

            }
        });

    }


    // 처음생성시 테이블에 불러올 메서드 만들기
    public void tableData(){
        FileReader fr=null;
        BufferedReader br=null;

        try {
            fr=new FileReader(FILENAME);
            br=new BufferedReader(fr);

            while (true){
                String s=br.readLine();

                if(s==null){
                    break;
                }
                String[] data=s.split(",");

                //table에 배열형 데이터  추가
                model.addRow(data);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        new SwingTableShop_03("상품테이블"); // 생성자 생성
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object ob=e.getSource();
        if(ob==btnAdd){
            String sang=tfSang.getText().trim(); // 공백도 인식하는게 trim. 안전빵으로 써주는게 좋다.
            String su=tfSu.getText().trim();
            String dan=tfDan.getText().trim();

            if(sang.length()==0||su.length()==0||dan.length()==0){
                JOptionPane.showMessageDialog(this,"3개의 값을 모두 입력해주세요.");
                return;
            }
            int total=0;
            total=Integer.parseInt(su)*Integer.parseInt(dan);

            NumberFormat nf=NumberFormat.getInstance();

            Vector<String> data=new Vector<>();
            data.add(sang);
            data.add(su);
            data.add(dan);
            data.add(nf.format(total));

            // table에 추가
            model.addRow(data);

            // 입력값 지워주기
            tfSang.setText("");
            tfSu.setText("");
            tfDan.setText("");
        }

    }
}
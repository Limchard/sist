package homework;

import java.sql.*;
import java.util.Scanner;

public class MyStudent {

//    static final String ORACLEURL="jdbc:oracle:thin:@localhost:1521:XE";
    DBConnect db=new DBConnect();
    Scanner sc=new Scanner(System.in);

   // String sql="select * from mystudent";


    // 1. insert
    public void insertMyStu(){

        Connection conn= db.getConnection();
        Statement stmt=null;

        System.out.println("학생명? ");
        String name=sc.nextLine();
        System.out.println("학년?");
        String grade=sc.nextLine();
        System.out.println("핸드폰 번호?");
        String hp=sc.nextLine();
        System.out.println("주소?");
        String addr=sc.nextLine();
        System.out.println("나이는?");
        String age=sc.nextLine();

        String sql="insert into mystudent values (seq_stu.nextval,'"+name+"','"+grade+"','"+hp+"','"+addr+"','"+age+"',sysdate)";

        try {
            stmt= conn.createStatement(); //
            stmt.execute(sql); // sql 의 컨트롤 엔터 같은 실행버튼 느낌
            System.out.println("***정보가 추가되었습니다.***");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(stmt,conn);
        }
    }


    // 2. select (출력)
    public void selectMystu(){

        System.out.println("번호\t이름\t\t학년\t\t핸드폰번호\t\t주소\t\t나이\t\t현재날짜");
        System.out.println("============================================================");

        String sql="select * from mystudent order by stu_num";

        Connection conn= db.getConnection();
        Statement stmt=null;
        ResultSet rs=null;

        try {
            stmt= conn.createStatement();
            rs= stmt.executeQuery(sql);

            while(rs.next()){
                int num=rs.getInt("stu_num");
                String name=rs.getString("stu_name");
                int grade=rs.getInt("stu_grade");
                String hp=rs.getString("hp");
                String addr=rs.getString("addr");
                int age=rs.getInt("age");
                Date sdate=rs.getDate("sdate");
                System.out.println(num+"\t"+name+"\t"+grade+"\t"+hp+"\t"+addr+"\t"+age+"\t"+sdate);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs,stmt,conn);
        }
    }

    // 3. delete

    public void deleteMystu() {


        Connection conn = db.getConnection();
        Statement stmt = null;

        System.out.println("삭제할 시퀀스는 ?");
        String num = sc.nextLine();

        String sql = "delete from mystudent where stu_num=" + num;

        try {
            stmt = conn.createStatement();
            int a = stmt.executeUpdate(sql);
            if (a == 0) {
                System.out.println("없는 데이터 입니다.");
            } else {
                System.out.println("삭제되었습니다.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    // 4. update
    // 4-1 조회
    public boolean isDate(String stu_num){
        boolean flag=false;

        String sql="select * from mystudent where stu_num="+stu_num;

        Connection conn=db.getConnection();
        Statement stmt=null;
        ResultSet rs=null;

        try {
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);

            if(rs.next()){
                flag=true;
            } else {
                flag=false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs,stmt,conn);
        }

        return flag;
    }

    // 4-2 update
    public void updateMystu(){

        System.out.println("수정할 시퀀스는? ");
        String num=sc.nextLine();

        if(!this.isDate(num)){
            System.out.println("해당 번호는 존재하지 않습니다.");
            return;
        }

        System.out.println("학생명? ");
        String name=sc.nextLine();
        System.out.println("학년?");
        String grade=sc.nextLine();
        System.out.println("핸드폰 번호?");
        String hp=sc.nextLine();
        System.out.println("주소?");
        String addr=sc.nextLine();
        System.out.println("나이는?");
        String age=sc.nextLine();

        Connection conn= db.getConnection();
        Statement stmt=null;


        String sql="update mystudent set stu_name='"+name+"',stu_grade='"+grade+"',hp='"+hp+"',addr='"+addr+"',age='"+age+"' where stu_num="+num;

        try {
            stmt=conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(stmt,conn);
        }

    }

    public void searchMystu(){

        System.out.println("검색할 사원명을 입력해 주세요. (일부 입력도 가능합니다.)");
        String ireum=sc.nextLine();

        String sql="select * from mystudent where stu_name like '%"+ireum+"%'";

        Connection conn= db.getConnection();
        Statement stmt=null;
        ResultSet rs=null;

        try {
            stmt= conn.createStatement();
            rs= stmt.executeQuery(sql);

            while(rs.next()){
                int num=rs.getInt("stu_num");
                String name=rs.getString("stu_name");
                int grade=rs.getInt("stu_grade");
                String hp=rs.getString("hp");
                String addr=rs.getString("addr");
                int age=rs.getInt("age");
                Date sdate=rs.getDate("sdate");
                System.out.println(num+"\t"+name+"\t"+grade+"\t"+hp+"\t"+addr+"\t"+age+"\t"+sdate);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs,stmt,conn);
        }


    }

    public static void main(String[] args) {

        MyStudent my=new MyStudent();
        Scanner sc=new Scanner(System.in);
        int n;


        while(true){
            System.out.println("***학생정보***");
            System.out.println("1.입력\t2.출력\t3.삭제\t4.수정\t5.검색\t9.종료");
            System.out.println("=============================================");
            n=Integer.parseInt(sc.nextLine());

            if(n==1){
                my.insertMyStu();
            } else if (n==9) {
                System.out.println("종료되었습니다.");
                break;
            } else if (n==2) {
                my.selectMystu();
            } else if (n==3) {
                my.deleteMystu();
            } else if (n==4) {
                my.updateMystu();
            } else if (n==5) {
                my.searchMystu();
            }
        }
    }
}

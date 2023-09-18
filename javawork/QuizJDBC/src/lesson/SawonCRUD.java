package lesson;

import homework.DBConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SawonCRUD {

    DBConnect db=new DBConnect();
    Scanner sc=new Scanner(System.in);

    // 1. insert
    public void insertSawon(){
        System.out.println("*** 사원 추가하기 ***");

        System.out.println("사원명?");
        String name=sc.nextLine();
        System.out.println("성별은? (여자 or 남자)");
        String gender=sc.nextLine();
        System.out.println("부서는?");
        String buseo=sc.nextLine();
        System.out.println("급여는?");
        int pay=Integer.parseInt(sc.nextLine());

        String sql="insert into sawon values (seq_sawon.nextval,'"+name+"','"+gender+"','"+buseo+"',"+pay+")";
        System.out.println(sql);

        //오라클에 연결
        Connection conn= db.getConnection();
        Statement stmt=null;

        try {
            stmt=conn.createStatement();
            stmt.execute(sql); // sql문 실행

            System.out.println("DB에 추가 되었습니다.");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(stmt,conn);
        }

    }

    // 2.select
    public void selectSawon(){
        String sql="select num,name,gender,buseo,to_char(pay,'L999,999,999') pay from sawon order by num";

        System.out.println("\t\t [전체사원명단]");
        System.out.println();

        System.out.println("시퀀스\t사원명\t성별\t부서명\t\t\t월급여");
        System.out.println("============================================");

        // db연결
        Connection conn=db.getConnection(); //연결
        Statement stmt=null; // 전달
        ResultSet rs=null; // 출력

        try {
            stmt= conn.createStatement();
            rs=stmt.executeQuery(sql);

            while (rs.next()){
                System.out.println(rs.getInt("num")+"\t\t"
                        +rs.getString("name")+"\t"
                        +rs.getString("gender")+"\t"
                        +rs.getString("buseo")
                        +rs.getString("pay"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs,stmt,conn);
        }
    }

    // 3. delete
    public void deleteSawon(){

        System.out.println("삭제할 이름은?");
        String name=sc.nextLine();

        String sql="delete from sawon where name='"+name+"'";

        Connection conn=db.getConnection();
        Statement stmt=null;

        try {
            stmt=conn.createStatement();
            stmt.execute(sql);
            System.out.println("삭제가 완료되었습니다.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(stmt,conn);
        }
    }

    // 4.update .. 시퀀스 입력 후 부서, 급여만 수정
    public boolean isDate(String num){

        boolean flag=false;

        String sql="select * from myinfo where num="+num;

        Connection conn=db.getConnection();
        Statement stmt=null;
        ResultSet rs=null;

        try {
            stmt= conn.createStatement();
            rs=stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs,stmt,conn);
        }

        return flag;
    }

    public void update(){

        System.out.println("수정할 시퀀스는?");
        String num=sc.nextLine();

        if(!this.isDate(num)){
            System.out.println("해당번호는 존재하지 않습니다.");
            return;
        }

        System.out.println("수정할 부서는?");
        String buseo=sc.nextLine();
        System.out.println("수정할 급여는?");
        int pay=Integer.parseInt(sc.nextLine());

        String sql="update sawon set buseo='"+buseo+"',pay="+pay+" where num="+num;
        System.out.println(sql);

        Connection conn= db.getConnection();
        Statement stmt=null;

        try {
            stmt= conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(stmt,conn);
        }

    }

    //5. 사원검색

    public void searchName(){

        System.out.println("검색할 사원명을 검색해주세요 (일부 검색도 됨)");
        String name=sc.nextLine();

        String sql="select num,name,gender,buseo,to_char(pay,'L999,999,999') pay from sawon where name like '%"+name+"%'";

        System.out.println("\t\t [검색사원명단]");
        System.out.println();

        System.out.println("시퀀스\t사원명\t성별\t부서명\t\t\t월급여");
        System.out.println("============================================");

        // db연결
        Connection conn=db.getConnection(); //연결
        Statement stmt=null; // 전달
        ResultSet rs=null; // 출력

        try {
            stmt= conn.createStatement();
            rs=stmt.executeQuery(sql);

            while (rs.next()){
                System.out.println(rs.getInt("num")+"\t\t"
                        +rs.getString("name")+"\t"
                        +rs.getString("gender")+"\t"
                        +rs.getString("buseo")
                        +rs.getString("pay"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs,stmt,conn);
        }

    }



    public static void main(String[] args) {

        SawonCRUD sw=new SawonCRUD();
        Scanner sc=new Scanner(System.in);


        while (true){

            System.out.println("Oracle DB Sawon 문제");
            System.out.println("1.insert\t2.select\t3.delete\t4.update\t5.사원검색\t9.종료");
            int n=Integer.parseInt(sc.nextLine());

            if (n==1){
                sw.insertSawon();
            } else if (n==9) {
                System.out.println("종료합니다.");
                break;
            } else if (n==2) {
                sw.selectSawon();
            } else if (n==3) {
                sw.deleteSawon();
            } else if (n==4) {
                sw.update();
            } else if (n==5) {
                sw.searchName();
            }
        }
    }
}

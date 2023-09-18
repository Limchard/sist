package dbtest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CRUDTest {

    DBConnect db=new DBConnect(); // DBConnect 생성의 이유 : 메서드 만든거 가지고 올려구.. URL 하고 close 사용 하려구..

    // insert
    public void insert(){
        Scanner sc=new Scanner(System.in);
        System.out.println("이름 입력");
        String name=sc.nextLine();
        System.out.println("주소 입력");
        String addr=sc.nextLine();

        String sql="insert into myinfo values (seq1.nextval,'"+name+"','"+addr+"',sysdate)"; // insert 구문을 가지고 할꺼야 (Oracle sql 디벨로퍼에 적는거 기준으로 작성) - 완성된 구문.
        // '"+name+"' : 숫자의 경우 소따옴표만 없다.

        // 1. db연결
        Connection conn=db.getConnection();
        // 2. statement
        Statement stmt=null;
        try {
            stmt=conn.createStatement(); // sql문 전송에 필요한 객체를 createStatement 객체를 통해서 얻어오는 것이다.
            stmt.execute(sql);

            System.out.println("*** 정보가 추가되었습니다 ***");

            System.out.println(sql); // sql 에러나는경우 확인하는 법.. 콘솔창에 보면 Oracle에서 어떻게 입력되는지 확인할 수 있다.



        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("insert error: "+e.getMessage());
        } finally {
            db.dbClose(stmt, conn); // DBConnect 에서 close 문 썼던거 가져올려고 불러온다.
        }
        // 3. ResultSet = 완전 출력문에만 필요하다. insert에는 필요 없다.
    }

    // select 문
    public void select(){
        System.out.println("시퀀스\t이름\t주소\t날짜");
        System.out.println("=================================");

        // 요청한 sql문을 String에 저장하기
        String sql="select * from myinfo order by num asc";

        // 객체 3개 필요 Connection
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;

        conn=db.getConnection();
        try {
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql); // ResultSet 만 executeQuery 사용. 나머지는 execute 사용하면 됨.

            // 2개 이상일경우 while문
            while(rs.next()){ // resulrtset 객체 이용해서 행을 선택하고, get메서드를 이용해서 table의 column 값을 얻는다.
                System.out.println(rs.getInt("num")
                        +"\t"+rs.getString("name")
                        +"\t"+rs.getString("addr")
                        +"\t"+rs.getDate("sdate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(rs,stmt,conn);
        }
    }

    // delete 문
    public void delete(){
        // 시퀀스 입력후 삭제하기.
        Scanner sc=new Scanner(System.in);
        String num; // int나 String은 상관 없으나, 나중에 프론트랑 백이랑 이어줄때(모두 text로 받아옴) int로 하면 추가로 형변환 해줘야 함
        System.out.println("삭제할 시퀀스는?");
        num=sc.nextLine();

        String sql="delete from myinfo where num="+num;

        // db연결
        Connection conn=db.getConnection();
        // Statement
        Statement stmt=null; // 여기서 선언하면 try-catch 블락괄호에 같힌다. finally 에서 불러올 수 없다.

        try {
            stmt=conn.createStatement();

            // sql문 실행
            int a=stmt.executeUpdate(sql); // execute 로 하면 boolean 이라서 유,무만 가능, update하면 int값으로 없는번호 커버 가능.. 이따가 정리하자. execute 도 할 수 있음
            if(a==0){ // 없는 번호 입력시 실제 삭제가 되지않아 0 반환
                System.out.println("***없는 데이타 번호입니다.***");
            }else // 삭제되면 1 반환
                System.out.println("***삭제되었습니다.***");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(stmt,conn);
        }
    }

    // update

    // 수정은 항상 method가 2개 입니다. 있는지 없는지 먼저 조회하기 하나, 조회한 값을 수정하기 또 하나, 총 2개

    // 업데이트시 먼저 조회하기 ( 있는번호인지 없는번호인지 찾아주기)
    public boolean isDate(String num){
        // num에 해댕하는 데이터가 있으면 true, 없으면 false

        boolean flag=false;

        String sql="select * from myinfo where num="+num;

        Connection conn=db.getConnection();
        Statement stmt=null;
        ResultSet rs=null;

        try {
            stmt=conn.createStatement();
            rs= stmt.executeQuery(sql);

            // 1개일 경우 if문
            if(rs.next()){ // 데이터가 있는경우
                flag=true;
            } else {  // 데이터가 없는경우
                flag=false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(rs,stmt,conn);
        }

        return flag;

    }


    public void update(){  // 수정은 항상 method가 2개 입니다.
        // 있는지 없는지 먼저 조회하기 하나, 조회한 값을 수정하기 또 하나, 총 2개

        // 수정할 시퀀스 입력 후 이름,주소 입력
        Scanner sc=new Scanner(System.in);
        String num;
        System.out.println("수정할 시퀀스는?");
        num=sc.nextLine();

        // 위의 boolean 메서드 가져와서 실행
        if(!this.isDate(num)){
            System.out.println("해당번호는 존재하지 않습니다.");
            return; // 메서드 종료
        }

        System.out.println("수정할 이름은?");
        String name=sc.nextLine();

        System.out.println("수정할 주소는?");
        String addr=sc.nextLine();

        //sql
        String sql="update myinfo set name='"+name+"',addr='"+addr+"' where num="+num; // 디벨로퍼와 같이 where 앞에 띄어쓰기 해야한다.

        System.out.println(sql);

        // db연결
        Connection conn=db.getConnection();
        Statement stmt=null;
        try {
            stmt=conn.createStatement();
            int a=stmt.executeUpdate(sql);
            if(a==0){
                System.out.println("수정할 데이터가 존재하지 않습니다.");
            } else {
                System.out.println("**수정되었습니다.**");
            }


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("update error: "+e.getMessage());
        } finally {
            db.dbClose(stmt,conn);
        }

    }


    public static void main(String[] args) {
        CRUDTest crud=new CRUDTest();
        Scanner sc=new Scanner(System.in);
        int n;

        while(true){
            System.out.println("***Oracle db연습_myinfo***");
            System.out.println("1.insert\t2.select\t3.delete\t4.update\t9.종료");

            n=Integer.parseInt(sc.nextLine());

            if(n==1){
                crud.insert();
            } else if (n==9) {
                System.out.println("종료합니다.");
                break;
            } else if (n==2) {
                crud.select();
            } else if (n==3) {
                crud.delete();
            } else if (n==4) {
                crud.update();
            }
        }
    }
}

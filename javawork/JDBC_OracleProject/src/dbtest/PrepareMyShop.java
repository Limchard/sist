package dbtest;

import java.sql.*;
import java.util.Scanner;

public class PrepareMyShop {

    DBConnect db=new DBConnect();
    Scanner sc=new Scanner(System.in);


    // insert
    public void insertMyshop(){
        // Connection
        Connection conn=db.getConnection();
        PreparedStatement pstmt=null;

        System.out.println("상품명은?");
        String sang=sc.nextLine();
        System.out.println("수량?");
        int su=Integer.parseInt(sc.nextLine());
        System.out.println("가격?");
        int dan=Integer.parseInt(sc.nextLine());

        // sql문에 변수값을 담아볼껀데 'PreparedStatement'는 미완의 sql문이다.
        // sql.. PreparedStatement는 미완의 sql문을 작성
        String sql="insert into myshop values (seq1.nextval,?,?,?,sysdate)"; // ?표 처리는 update 직전에 해줄께요


        try {
            pstmt= conn.prepareCall(sql);

            // 업데이트 전에 ?표를 순서대로 바인딩 해야 함
            pstmt.setString(1,sang); // 1은 '첫번째 물음표 라는 뜻이다.
            pstmt.setInt(2,su);  // 2는 '두번째 물음표 라는 뜻이다.
            pstmt.setInt(3,dan);

            // 업데이트
            int a=pstmt.executeUpdate();

            if(a==1){
                System.out.println("인서트 성공!!");
            } else {
                System.out.println("인서트 실패ㅠㅠ");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(pstmt,conn);
        }
    }

    // select
    public void selectMyshop(){
        System.out.println("번호\t상품명\t수량\t숫자\t입고일");
        System.out.println("============================");

        // 요청한 sql문을 String에 저장하기
        String sql="select * from myshop order by shopnum asc";

        Connection conn= db.getConnection();
        Statement stmt=null;
        ResultSet rs=null;

        try {
            stmt= conn.createStatement();
            rs= stmt.executeQuery(sql);

            while (rs.next()){
                System.out.println(rs.getInt("shopnum")
                        +"\t"+rs.getString("sangpum")
                        +"\t"+rs.getInt("su")
                        +"\t"+rs.getInt("price")
                        +"\t"+rs.getDate("ipgo"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs,stmt,conn);
        }

    }

    // delete .. 삭제할 번호는 시퀀스 번호 입력 후 삭제
    public void deleteMyshop(){
        Connection conn=db.getConnection();
        PreparedStatement pstmt=null;

        System.out.println("삭제할 시퀀스는?");
        int num=Integer.parseInt(sc.nextLine());

        String sql="delete from myshop where shopnum=?";

        try {
            pstmt=conn.prepareStatement(sql);
            // ? 한거 바인딩
            pstmt.setInt(1,num);

//            pstmt.execute();
//            System.out.println("***삭제성공***");

            int a= pstmt.executeUpdate();
            if(a==1){
                System.out.println("***삭제성공***");
            }
            else {
                System.out.println("삭제실패 ㅠㅠ");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(pstmt,conn);
        }
    }

    // 수정할 시퀀스가 존재하는지에 대한 메서드
    public boolean isdataMyshop(String shopnum){

        boolean b=false;

        Connection conn=db.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        String sql="select * from myshop where shopnum=?";

        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,shopnum);
            rs= pstmt.executeQuery();

            if(rs.next())
                b=true;
            else
                b=false;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs,pstmt,conn);
        }
        return b;
    }

    // 수정 시퀀스가 존재할 시 update에 대한 메서드
    public void updateMyshop(){
        Connection conn= db.getConnection();
        PreparedStatement pstmt=null;

        System.out.println("수정할 시퀀스 번호?");
        String num=sc.nextLine();

        // 여기서 시퀀스가 없다면 종료
        if(!isdataMyshop(num)){
            System.out.println("해당번호는 존재하지 않습니다.");
            return;
        }

        System.out.println("수정할 상품명?");
        String sang=sc.nextLine();
        System.out.println("수정할 수량은?");
        int su=Integer.parseInt(sc.nextLine());
        System.out.println("수정할 가격은?");
        int price=Integer.parseInt(sc.nextLine());

        // sql
        String sql="update myshop set sangpum=?,su=?,price=? where shopnum=?";

        try {
            pstmt= conn.prepareStatement(sql);

            // 4개 순서대로 바인딩
            pstmt.setString(1,sang);
            pstmt.setInt(2,su);
            pstmt.setInt(3,price);
            pstmt.setString(4,num);

            // 최종적으로 업데이트!!
            pstmt.execute();
            System.out.println("*** 수정 성공 ***");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(pstmt,conn);
        }
    }

    // 검색
    public void searchSangpum(){
        System.out.println("검색할 상품명(일부)");
        String sang=sc.nextLine();
        String sql="select * from myshop where sangpum like ?";
        System.out.println(sql);

        System.out.println("시퀀스\t상품명\t수량\t가격\t입고날짜");
        System.out.println("------------------------------------------[");

        Connection conn=db.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        try {
            pstmt=conn.prepareStatement(sql);
            // ? 바인딩
            pstmt.setString(1,"%"+sang+"%");
            rs= pstmt.executeQuery();

            while (rs.next()){
                System.out.println(rs.getInt("shopnum")
                        +"\t"+rs.getString("sangpum")
                        +"\t"+rs.getInt("su")
                        +"\t"+rs.getInt("price")
                        +"\t"+rs.getDate("ipgo"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.dbClose(rs,pstmt,conn);
        }
    }

    public static void main(String[] args) {

        PrepareMyShop shop=new PrepareMyShop();
        Scanner sc=new Scanner(System.in);
        int n;

        while (true){
            System.out.println("***상품입고***");
            System.out.println("1.상품추가\t2.상품삭제\t3.상품수정\t4.상품전체출력\t5.상품검색\t9.종료");
            n=Integer.parseInt(sc.nextLine());

            if(n==1){
                shop.insertMyshop();
            } else if (n==9) {
                System.out.println("종료합니다.");
                break;
            } else if (n==4) {
                shop.selectMyshop();
            } else if (n==2) {
                shop.deleteMyshop();
            } else if (n==3) {
                shop.updateMyshop();
            } else if (n==5) {
                shop.searchSangpum();
            }

        }
    }
}

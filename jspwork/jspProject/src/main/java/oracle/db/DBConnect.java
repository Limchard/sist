package oracle.db;

import java.sql.*;

public class DBConnect {

    // driver(OJDBC), url, 계정, 비밀번호를 반드시 connection 해줘야 한다.

    // url
    static final String ORACLE_URL="jdbc:oracle:thin:@localhost:1521:XE";

    // driver : 딱 1번만 실행.. 생성자 단에서 실행
    String driver="oracle.jdbc.driver.OracleDriver";
    public DBConnect(){

        try{
            Class.forName(driver);
            System.out.println("오라클 드라이버 성공!!");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("오라클 드라이버 실패!! "+e.getMessage());
        }
    }

    // Connection
    public Connection getConnection(){
        Connection conn=null;

        try {
            conn= DriverManager.getConnection(ORACLE_URL,"scott","tiger");



        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("오라클 연결실패: url, 계정, 비밀번호 확인 요함 "+e.getMessage());
        }

        return  conn;
        // void return이 없다. 해당 method에 void가 아니기 때문에 return이 없으면 아래 중괄호에 오류가 난다.
    }

    // close 메서드 생성.. 총 4개
    public void dbClose(ResultSet rs, Statement stmt, Connection conn){
        try {
            if(rs!=null) rs.close();
            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void dbClose(Statement stmt, Connection conn){  // ResultSet이 없는 이유는 출력이 필요 없기 때문
        try {
            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn){  //PreparedStatement : 미완의.. 뭐라고?
        try {
            if(rs!=null) rs.close();
            if(pstmt!=null) pstmt.close();
            if(conn!=null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void dbClose(PreparedStatement pstmt, Connection conn){
        try {
            if(pstmt!=null) pstmt.close();
            if(conn!=null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

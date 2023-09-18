package Day0710;

import java.sql.*;

public class OracleConnectHomework {

    static final String URL="jdbc:oracle:thin:@localhost:1521:XE";

    public void connectSnsboard(){

        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null; // 이건 select 문 즉 출력문을 읽어올때만 사용

        String sql="select * from snsboard";

        try {
            conn=DriverManager.getConnection(URL,"scott","tiger");
            System.out.println("클라우드 오라클 서버 연결 성공!!");

            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                int num=rs.getInt("b_num");
                String nick=rs.getString("nick");
                String sub=rs.getString("subject");
                String con=rs.getString("content");
                String date=rs.getString("wday");
                System.out.println(num+"\t"+nick+"\t"+sub+"\t"+con+"\t"+date);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        OracleConnectHomework oc=new OracleConnectHomework();
        oc.connectSnsboard();
    }
}

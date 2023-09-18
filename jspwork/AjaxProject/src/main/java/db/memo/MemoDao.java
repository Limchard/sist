package db.memo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import oracle_db.DBConnect;

public class MemoDao {

	DBConnect db=new DBConnect();
	
	// 추가
	public void insertMemo(MemoDto dto) {
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="insert into memo values(seq1.nextval,?,?,?,sysdate)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getStory());
			pstmt.setString(3, dto.getAvata());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	// 조회
	public List<MemoDto> getAllMemos(){
		List<MemoDto> list=new Vector<MemoDto>();
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from memo order by num desc";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				MemoDto dto=new MemoDto();
				
				dto.setNum(rs.getString("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setStory(rs.getString("story"));
				dto.setAvata(rs.getString("avata"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		return list;
	}
	
	// 삭제
	
	// 1. dao에서 삭제 메서드 만들기 deleteMemo
	// 2. delete를 처리해주는 jsp 만들기. memodelete.jsp
	// 3. 다시 memo.html에 와서 삭제관련 이벤트 해주기 -> alert 창을 통해 이벤트가 먹히는지 먼저 확인해야 함 
	// 4. 수정을 누르면 num값 받아 오는지 alert창으로 확인 후 삭제 ajax로 삭제 한다.
	// 5. 성공시 다시 list() 호출해야 한다.
	
	public void deleteMemo(String num) {
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="delete from memo where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}	
	}
	
	// 수정
	// num에 해당하는 dto 반환하기 
	public MemoDto getData(String num) {
		MemoDto dto=new MemoDto();
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from memo where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				
				dto.setNum(rs.getString("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setStory(rs.getString("story"));
				dto.setAvata(rs.getString("avata"));
				dto.setWriteday(rs.getTimestamp("writeday"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		return dto;
	}
	
	public void updateMemo(MemoDto dto) {
	
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="update memo set writer=?,story=?,avata=? where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			
			// 바인딩
			
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getStory());
			pstmt.setString(3, dto.getAvata());
			pstmt.setString(4, dto.getNum());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Macro;
import vo.BoardVO;

public class BoardDAO {

	private BoardDAO(){}

	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance(){
		return instance;
	}
	
	public List<BoardVO> selectAll(){
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM CATTUBE_BOARD ORDER BY NUM DESC";
			
			if(Macro.DB_CONNECTION_POOL){
				conn = DBManager.getConnection();
			} else {
				conn = DBHelper.makeConnection();
			}
			pstmt = conn.prepareStatement(sql);
						
			rs = pstmt.executeQuery();
			while(rs.next()){
				BoardVO bvo = new BoardVO();

				bvo.setNum(rs.getInt("num"));
				bvo.setTitle(rs.getString("title"));
				bvo.setContent(rs.getString("content"));
				bvo.setWriter(rs.getString("writer"));
				bvo.setWriteDate(rs.getTimestamp("writedate"));
				bvo.setReadCount(rs.getInt("readcount"));
				bvo.setVoteCount(rs.getInt("votecount"));
				bvo.setVideoPath(rs.getString("videopath"));
				bvo.setImagePath(rs.getString("imagepath"));
				bvo.setClosed(rs.getString("closed"));

				list.add(bvo);
			}
			
		} catch (Exception e) {
			System.out.println("selectAll error");
			e.printStackTrace();
		} finally {
			if(Macro.DB_CONNECTION_POOL){
				DBManager.close(conn, pstmt, rs);
			} else {
				DBHelper.close(conn);
				DBHelper.close(pstmt);
				DBHelper.close(rs);
			}
		}
		return list;
	}
	
	public List<BoardVO> selectPopularList(){
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM CATTUBE_BOARD ORDER BY READCOUNT DESC";
			if(Macro.DB_CONNECTION_POOL){
				conn = DBManager.getConnection();
			} else {
				conn = DBHelper.makeConnection();
			}
			pstmt = conn.prepareStatement(sql);
						
			rs = pstmt.executeQuery();
			while(rs.next()){
				BoardVO bvo = new BoardVO();

				bvo.setNum(rs.getInt("num"));
				bvo.setTitle(rs.getString("title"));
				bvo.setContent(rs.getString("content"));
				bvo.setWriter(rs.getString("writer"));
				bvo.setWriteDate(rs.getTimestamp("writedate"));
				bvo.setReadCount(rs.getInt("readcount"));
				bvo.setVoteCount(rs.getInt("votecount"));
				bvo.setVideoPath(rs.getString("videopath"));
				bvo.setImagePath(rs.getString("imagepath"));
				bvo.setClosed(rs.getString("closed"));

				list.add(bvo);
			}
			
		} catch (Exception e) {
			System.out.println("selectAll error");
			e.printStackTrace();
		} finally {
			if(Macro.DB_CONNECTION_POOL){
				DBManager.close(conn, pstmt, rs);
			} else {
				DBHelper.close(conn);
				DBHelper.close(pstmt);
				DBHelper.close(rs);
			}
		}
		return list;
	}
	

	public List<BoardVO> selectData(String data){

		String sql = "SELECT * FROM CATTUBE_BOARD WHERE TITLE LIKE '%"+data+"%' ORDER BY NUM DESC";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> list = new ArrayList<BoardVO>();

		try {
			if(Macro.DB_CONNECTION_POOL){
				conn = DBManager.getConnection();
			} else {
				conn = DBHelper.makeConnection();
			}
			pstmt = conn.prepareStatement(sql);

			//pstmt.setString(1, data);
			rs = pstmt.executeQuery();
			while(rs.next()){
				BoardVO bvo = new BoardVO();

				bvo.setNum(rs.getInt("num"));
				bvo.setTitle(rs.getString("title"));
				bvo.setContent(rs.getString("content"));
				bvo.setWriter(rs.getString("writer"));
				bvo.setWriteDate(rs.getTimestamp("writedate"));
				bvo.setReadCount(rs.getInt("readcount"));
				bvo.setVoteCount(rs.getInt("votecount"));
				bvo.setVideoPath(rs.getString("videopath"));
				bvo.setImagePath(rs.getString("imagepath"));
				bvo.setClosed(rs.getString("closed"));

				list.add(bvo);
			}
		} catch (Exception e) {
			System.out.println("selectData error");
			e.printStackTrace();
		} finally {
			if(Macro.DB_CONNECTION_POOL){
				DBManager.close(conn, pstmt, rs);
			} else {
				DBHelper.close(conn);
				DBHelper.close(pstmt);
				DBHelper.close(rs);
			}
		}
		return list;
	}

	public BoardVO selectNum(int num){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        BoardVO bvo = null;
         
        try {
			if(Macro.DB_CONNECTION_POOL){
				con = DBManager.getConnection();
			} else {
				con = DBHelper.makeConnection();
			}
            String sql = 
                "SELECT * FROM CATTUBE_BOARD WHERE NUM=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, num);
             
            rs = pstmt.executeQuery();
            if(rs.next()){
                bvo = new BoardVO();
                bvo.setNum(rs.getInt(1));
                bvo.setTitle(rs.getString(2));
                bvo.setContent(rs.getString(3));
                bvo.setWriter(rs.getString(4));
                bvo.setWriteDate(rs.getTimestamp(5));
                bvo.setReadCount(rs.getInt(6));
                bvo.setVoteCount(rs.getInt(7));
				bvo.setVideoPath(rs.getString(8));
				bvo.setImagePath(rs.getString(9));
				bvo.setClosed(rs.getString(10));
            }
        } catch (SQLException e) {
            System.out.println("selectNum 에러");
            e.printStackTrace();
        } finally{
        	if(Macro.DB_CONNECTION_POOL){
        		DBManager.close(con, pstmt, rs);
        	} else {
				DBHelper.close(rs);
				DBHelper.close(pstmt);
				DBHelper.close(con);
        	}
        }
        return bvo;
    }
//	public int selectArticleCount(){
//		Connection con = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		int articleCount = 0;
//
//		try {
//			con = DBHelper.makeConnection();
//			String sql = "SELECT COUNT(*) FROM ARTICLE_BOARD";
//			stmt = con.createStatement();
//			rs = stmt.executeQuery(sql);
//
//			rs.next();
//			articleCount = rs.getInt(1);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return articleCount;
//	}

	
	public int updateReadCount(int articleId){
		String sql = "UPDATE CATTUBE_BOARD SET READCOUNT = READCOUNT+1 WHERE NUM=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			if(Macro.DB_CONNECTION_POOL){
				conn = DBManager.getConnection();
			} else {
				conn = DBHelper.makeConnection();
			}
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, articleId);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("updateReadCount error");
			e.printStackTrace();
		} finally {
			if(Macro.DB_CONNECTION_POOL){
				DBManager.close(conn, pstmt);
			} else {
				DBHelper.close(conn);
				DBHelper.close(pstmt);
			}
		}
		return result;
	}
}

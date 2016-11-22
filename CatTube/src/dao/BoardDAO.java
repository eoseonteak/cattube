package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
			
			conn = DBHelper.makeConnection();
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
			DBHelper.close(conn);
			DBHelper.close(pstmt);
			DBHelper.close(rs);
		}
		return list;
	}	


	public List<BoardVO> selectData(String data){

		String sql = "SELECT * FROM ARTICLE_BOARD WHERE TITLE LIKE '%"+data+"%' ORDER BY ARTICLE_ID DESC";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> list = new ArrayList<BoardVO>();

		try {
			conn = DBHelper.makeConnection();
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
			DBHelper.close(conn);
			DBHelper.close(pstmt);
			DBHelper.close(rs);
		}
		return list;
	}

	public int selectArticleCount(){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		int articleCount = 0;

		try {
			con = DBHelper.makeConnection();
			String sql = "SELECT COUNT(*) FROM ARTICLE_BOARD";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			rs.next();
			articleCount = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articleCount;
	}

	
	public int updateReadCount(int articleId){
		String sql = "UPDATE ARTICLE_BOARD SET READ_COUNT = READ_COUNT+1 WHERE ARTICLE_ID=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = DBHelper.makeConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, articleId);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("updateReadCount error");
			e.printStackTrace();
		} finally {
			DBHelper.close(conn);
			DBHelper.close(pstmt);
		}
		return result;
	}
}

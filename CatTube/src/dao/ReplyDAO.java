package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.Macro;
import vo.ReplyVO;

public class ReplyDAO {
	private static ReplyDAO instance = new ReplyDAO();

	public static ReplyDAO getInstance() {
		return instance;
	}

	private ReplyDAO() {
	}

	public int insertBoardReply(ReplyVO rvo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			if (Macro.DB_CONNECTION_POOL) {
				conn = DBManager.getConnection();
			} else {
				conn = DBHelper.makeConnection();
			}

			String sql = "INSERT INTO REPLY(ARTICLE_NUM,RE_WRITER,RE_MEMO,RE_DATE) " + "VALUE(?,?,?,NOW())";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rvo.getArticleNum());
			pstmt.setString(2, rvo.getReWriter());
			pstmt.setString(3, rvo.getReMemo());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (Macro.DB_CONNECTION_POOL) {
				DBManager.close(conn, pstmt);
			} else {
				DBHelper.close(pstmt);
				DBHelper.close(conn);
			}
		}
		return result;
	}

	public List<ReplyVO> selectBoardReply() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReplyVO> replyList = new ArrayList<>();

		try {
			if(Macro.DB_CONNECTION_POOL){
				conn = DBManager.getConnection();
			} else {
				conn = DBHelper.makeConnection();
			}

			String sql = "SELECT * FROM CATTUBE_BOARD,REPLY WHERE CATTUBE_BOARD.NUM = REPLY.ARTICLE_NUM ORDER BY REPLY.RE_DATE ASC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ReplyVO rvo = new ReplyVO();

				rvo.setArticleNum(rs.getString("article_num"));
				rvo.setReWriter(rs.getString("re_writer"));
				rvo.setReMemo(rs.getString("re_memo"));
				rvo.setReDate(rs.getTimestamp("re_date"));
				rvo.setReNo(rs.getString("re_no"));

				replyList.add(rvo);
			}
		} catch (Exception e) {
			System.out.println("selectBoardReply error");
			e.printStackTrace();
		} finally {
			if(Macro.DB_CONNECTION_POOL){
				DBManager.close(conn, pstmt, rs);
			} else {
				DBHelper.close(rs);
				DBHelper.close(pstmt);
				DBHelper.close(conn);
			}
		}
		return replyList;
	}

	public int deleteBoardReply(int reNo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			if(Macro.DB_CONNECTION_POOL){
				conn = DBManager.getConnection();
			} else {
				conn = DBHelper.makeConnection();
			}

			String sql = "DELETE FROM REPLY " + "WHERE RE_NO=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reNo);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("deleteBoardReply error");
			e.printStackTrace();
		} finally {
			if(Macro.DB_CONNECTION_POOL){
				DBManager.close(conn, pstmt);
			} else {
				DBHelper.close(pstmt);
				DBHelper.close(conn);
			}
		}
		return result;
	}
}

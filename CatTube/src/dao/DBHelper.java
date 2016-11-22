package dao;
 
import java.sql.*;
 
public class DBHelper {
    public static Connection makeConnection(){
        String DB_URL = "jdbc:mysql://70.12.109.101:3306/jsp";
        String DB_ID = "root";
        String DB_PW = "sds902";
         
        Connection con = null;
         
        try {
            con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW);
        } catch (SQLException e) {
            System.out.println("커넥션 생성 에러");
            e.printStackTrace();
        }
        return con;
    }
 
    public static void close(Connection con){
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Statement stmt){
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(PreparedStatement pstmt){
        if(pstmt != null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
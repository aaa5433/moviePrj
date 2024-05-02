package yes.src.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class UserDao {
	static ArrayList list = new ArrayList<>();

	public UserDao() {
	}

	private static UserDao instance = new UserDao();

	public static UserDao getInstance() {
		return instance;
	}

	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	public static ArrayList selectOne(String userId) {
		String sql = "SELECT * FROM USERS WHERE ID = ?";
		conn = DBConnection.getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				list.add(rs.getString("ID"));
				list.add(rs.getString("PASSWORD"));
				list.add(rs.getString("NAME"));
				list.add(rs.getString("IDNUM"));
				list.add(rs.getString("MAIL"));
				list.add(rs.getString("PHONE"));
				list.add(rs.getString("GENDER"));
				conn.close();
				return list;
			} else {
				conn.close();
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static void insertUser(HashMap<String,String> list) throws SQLException {
		String sql = "INSERT INTO USERS VALUES(?,?,?,?,?,?,?)";
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, list.get("id"));				//insert문의 ?에 순서대로 회원정보 셋팅 
			pstmt.setString(2, list.get("pw"));	
			pstmt.setString(3, list.get("name"));	
			pstmt.setString(4, list.get("idNum"));	
			pstmt.setString(5, list.get("mail"));	
			pstmt.setString(6, list.get("phone"));
			pstmt.setString(7, list.get("gender"));
			System.out.println(pstmt.toString());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
	}public static void insertUserHistory(String id,String time) throws SQLException {
		String sql = "INSERT INTO USERHISTORY VALUES(?,?)";
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, time);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
	}

	public static int login(String userID, String password) {
		String SQL = "SELECT * FROM USERS WHERE ID = ?";
		conn = DBConnection.getConnection();
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				if (rs.getString(2).equals(password))
					return 0; // 로그인 성공
				else if (!rs.getString(2).equals(password))
					return 1; // 비밀번호 맞지 않음
				else if (rs == null)
					return 2; // id존재하지 않음
			}
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2;
	}

	public static int duplCheck(String userID) {
		String SQL = "SELECT * FROM USERS WHERE ID = ?";

		conn = DBConnection.getConnection();

		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(userID))
					return 0;
			}

		} catch (Exception e) {

			return 1;
		}
		return -1;
	}

	public static ArrayList selectAll() {
		String sql = "SELECT * FROM USERS";
		conn = DBConnection.getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(rs.getString("ID"));
				list.add(rs.getString("PASS"));
				list.add(rs.getString("NAME"));
				list.add(rs.getString("IDNUM"));
				list.add(rs.getString("MAIL"));
				list.add(rs.getString("GENDER"));
			}
			conn.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public int updatePassword(String userId) {
		String sql = "UPDATE USERS SET PASSWORD = PHONE WHERE USER_ID = ?";

		conn = DBConnection.getConnection();
		try {
			int returnCnt = 0;
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			returnCnt = pstmt.executeUpdate();

			conn.close();
			return returnCnt;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}

	public int updateDel(String userId) {
		String sql = "UPDATE USERS SET DEL_FG = 'Y', DEL_DT = SYSDATE WHERE USER_ID = ?";

		conn = DBConnection.getConnection();
		try {
			int returnCnt = 0;
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			returnCnt = pstmt.executeUpdate();

			conn.close();
			return returnCnt;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}

}

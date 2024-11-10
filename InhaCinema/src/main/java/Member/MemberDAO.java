package Member;

import java.sql.*;
import java.text.SimpleDateFormat;

import Common.DB;

public class MemberDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public MemberDAO() {
		try {
			Class.forName(DB.DRIVER);
			conn = DriverManager.getConnection(DB.URL, DB.USERID, DB.USERPW);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean IdCheck(String id) throws SQLException {
		boolean isExist = false;
		try {
			pstmt = conn.prepareStatement(DB.SQL_SELECT_MEMBER);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				isExist = true;
				break;
			}
		} finally {
			close();
		}
		return isExist;
	}
	
	public int Register(String[] registerData) throws SQLException {
		int result = 0;
		try {
			pstmt = conn.prepareStatement(DB.SQL_REGISTER_MEMBER);
			pstmt.setString(1, registerData[0]);
			pstmt.setString(2, registerData[1]);
			pstmt.setString(3, registerData[2]);
			pstmt.setString(4, registerData[3]);
			pstmt.setString(5, registerData[4]);
			pstmt.setString(6, "일반");
			result = pstmt.executeUpdate();
		} finally {
			close();
		}
		return result;
	}	
	
	public MemberDTO Login(String loginId, String loginPw) throws SQLException {
		MemberDTO member = null;
		try {
			pstmt = conn.prepareStatement(DB.SQL_SELECT_MEMBER);
			pstmt.setString(1, loginId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String pw = rs.getString(3);
				if(!loginPw.equals(pw)) return null;
				member = new MemberDTO(
						rs.getInt(1),
						loginId,
						pw,
						rs.getString(4),
						rs.getDate(5),
						rs.getString(6),
						rs.getDate(7),
						rs.getString(8)
				);			
			}
		} finally {
			close();
		}
		return member;
	}		
	
	public void close() throws SQLException {
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
		if (conn != null) conn.close();
	}
}
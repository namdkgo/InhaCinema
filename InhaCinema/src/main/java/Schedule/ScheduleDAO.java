package Schedule;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Common.DB;
import Movie.MovieDTO;

public class ScheduleDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ScheduleDAO() {
		try {
			Class.forName(DB.DRIVER);
			conn = DriverManager.getConnection(DB.URL, DB.USERID, DB.USERPW);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<ScheduleDTO> SelectScheduleAll() throws SQLException {
		ArrayList<ScheduleDTO> schedules = new ArrayList<ScheduleDTO>();
		try {
			pstmt = conn.prepareStatement(DB.SQL_SELECT_SCHEDULE_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ScheduleDTO schedule = new ScheduleDTO(
						rs.getInt(1), 
						rs.getInt(2),
						rs.getString(3),
						rs.getDate(4),
						rs.getString(5),
						rs.getString(6) 
				);
				schedules.add(schedule);
			}
		} finally {
			close();
		}
		return schedules;
	}	
	
	public ScheduleDTO SelectScheduleByCinemaIndex(String cinemaIndex) throws SQLException {
		ScheduleDTO scheduleDTO = null;
		try {
			pstmt = conn.prepareStatement(DB.SQL_SELECT_SCHEDULE_BY_CINEMAINDEX);
			pstmt.setString(1, cinemaIndex);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				scheduleDTO = new ScheduleDTO(
					rs.getInt(1),
					rs.getInt(2),
					rs.getString(3),
					rs.getDate(4),
					rs.getString(5),
					rs.getString(6)
				);
				break;
			}
		} finally {
			close();
		}
		return scheduleDTO;
	}	
	
	public ScheduleDTO SelectScheduleByScheduleIndex(int scheduleIndex) throws SQLException {
		ScheduleDTO scheduleDTO = null;
		try {
			pstmt = conn.prepareStatement(DB.SQL_SELECT_SCHEDULE_BY_SCHEDULEINDEX);
			pstmt.setInt(1, scheduleIndex);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				scheduleDTO = new ScheduleDTO(
					rs.getInt(1),
					rs.getInt(2),
					rs.getString(3),
					rs.getDate(4),
					rs.getString(5),
					rs.getString(6)
				);
				break;
			}
		} finally {
			close();
		}
		return scheduleDTO;
	}	
	
	public int UpdateSchedule(int scheduleIndex, String movieIndex, String cinemaIndex, String screenDate, String startDate) throws SQLException {
		int result = 0;
		try {
			pstmt = conn.prepareStatement(DB.SQL_UPDATE_SCHEDULE);
			pstmt.setString(1, movieIndex);
			pstmt.setString(2, cinemaIndex);
			pstmt.setString(3, screenDate);
			pstmt.setString(4, startDate);
			pstmt.setInt(5, scheduleIndex);
			result = pstmt.executeUpdate();
		} finally {
			close();
		}
		return result;
	}	
	
	public int DeleteSchedule(int scheduleIndex) throws SQLException {
		int result = 0;
		try {
			pstmt = conn.prepareStatement(DB.SQL_DELETE_SCHEDULE);
			pstmt.setInt(1, scheduleIndex);
			result = pstmt.executeUpdate();
		} finally {
			close();
		}
		return result;
	}		
	
	public int RegisterSchedule(String[] registerData) throws SQLException {
		int result = 0;
		try {
			pstmt = conn.prepareStatement(DB.SQL_REGISTER_SCHEDULE);
			pstmt.setInt(1, Integer.parseInt(registerData[0]));
			pstmt.setString(2, registerData[1]);
			pstmt.setString(3, registerData[2]);
			pstmt.setString(4, registerData[3]);
			pstmt.setString(5, "0:0,1:0,2:0,3:0,4:0,5:0,6:0,7:0,8:0,9:0,10:0,11:0,12:0,13:0,14:0,15:0,16:0,17:0,18:0,19:0,20:0,21:0,22:0,23:0,24:0,25:0,26:0,27:0,28:0,29:0,30:0,31:0,32:0,33:0,34:0,35:0,36:0,37:0,38:0,39:0,40:0,41:0,42:0,43:0,44:0,45:0,46:0,47:0,48:0,49:0,50:0,51:0,52:0,53:0,54:0,55:0,56:0,57:0,58:0,59:0,60:0,61:0,62:0,63:0,64:0,65:0,66:0,67:0,68:0,69:0,70:0,71:0,72:0,73:0,74:0,75:0,76:0,77:0,78:0,79:0,80:0,81:0,82:0,83:0,84:0,85:0,86:0,87:0,88:0,89:0,90:0,91:0,92:0,93:0,94:0,95:0,96:0,97:0,98:0,99:0");
			result = pstmt.executeUpdate();
		} finally {
			close();
		}
		return result;
	}		
	
	public void close() throws SQLException {
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
		if (conn != null) conn.close();
	}
}
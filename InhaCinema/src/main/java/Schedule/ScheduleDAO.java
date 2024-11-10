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
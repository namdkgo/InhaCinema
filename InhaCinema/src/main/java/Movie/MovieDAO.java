package Movie;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Common.DB;

public class MovieDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public MovieDAO() {
		try {
			Class.forName(DB.DRIVER);
			conn = DriverManager.getConnection(DB.URL, DB.USERID, DB.USERPW);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<MovieDTO> SelectMovieAll() throws SQLException {
		ArrayList<MovieDTO> movies = new ArrayList<MovieDTO>();
		try {
			pstmt = conn.prepareStatement(DB.SQL_SELECT_MOVIE_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MovieDTO movie = new MovieDTO(
						rs.getInt(1), 
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getDate(7),
						rs.getString(8),
						rs.getString(9),
						rs.getInt(10) 
				);
				movies.add(movie);
			}
		} finally {
			close();
		}
		return movies;
	}
	public MovieDTO SelectMovieByIndex(int movieIndex) throws SQLException {
		MovieDTO movie = null;
		try {
			pstmt = conn.prepareStatement(DB.SQL_SELECT_MOVIE_BY_INDEX);
			pstmt.setInt(1, movieIndex);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				movie = new MovieDTO(
						rs.getInt(1), 
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getDate(7),
						rs.getString(8),
						rs.getString(9),
						rs.getInt(10) 
				);
			}
		} finally {
			close();
		}
		return movie;
	}	
	public int RegisterMovie(String[] registerData) throws SQLException {
		int result = 0;
		try {
			pstmt = conn.prepareStatement(DB.SQL_REGISTER_MOVIE);
			pstmt.setString(1, registerData[0]);
			pstmt.setString(2, registerData[1]);
			pstmt.setString(3, registerData[2]);
			pstmt.setString(4, registerData[3]);
			pstmt.setString(5, registerData[4]);
			pstmt.setString(6, registerData[5]);
			pstmt.setString(7, registerData[6]);
			pstmt.setString(8, registerData[7]);
			pstmt.setInt(9, 0);
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
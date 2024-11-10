package Common;

public class DB { //Database Connector
	public static final String DRIVER = "org.mariadb.jdbc.Driver";
	public static final String URL = "jdbc:mariadb://localhost:3306/inhacinema";
	public static final String USERID = "root";
	public static final String USERPW = "root";

	public static final String SQL_SELECT_MEMBER = "SELECT * from MEMBERS where memberId = ?";
	public static final String SQL_REGISTER_MEMBER = "INSERT INTO MEMBERS (memberId, memberPw, memberName, memberBirth, memberEmail, memberGrade) VALUES(?, ?, ?, ?, ?, ?)";
	
	public static final String SQL_SELECT_MOVIE_BY_INDEX = "SELECT * from MOVIE WHERE movieIndex = ?";
	public static final String SQL_SELECT_MOVIE_ALL = "SELECT * from MOVIE";
	public static final String SQL_REGISTER_MOVIE = "INSERT INTO MOVIE (movieTitle, movieDirector, movieGenre, movieLength, movieGrade, movieOpenDate, movieCast, movieImage, movieAudience) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String SQL_SELECT_SCHEDULE_ALL = "SELECT * FROM SCHEDULES";
	public static final String SQL_SELECT_SCHEDULE_BY_CINEMAINDEX = "SELECT * FROM SCHEDULES WHERE cinemaIndex = ?";
	public static final String SQL_SELECT_SCHEDULE_BY_SCHEDULEINDEX = "SELECT * FROM SCHEDULES WHERE scheduleIndex = ?";
	public static final String SQL_REGISTER_SCHEDULE = "INSERT INTO SCHEDULES (movieIndex, cinemaIndex, screenDate, startTime, seatState) VALUES(?, ?, ?, ?, ?)";
	public static final String SQL_UPDATE_SCHEDULE = "UPDATE SCHEDULES SET movieIndex = ?, cinemaIndex = ?, screenDate = ?, startTime = ? WHERE scheduleIndex = ?";
	public static final String SQL_DELETE_SCHEDULE = "DELETE FROM SCHEDULES WHERE scheduleIndex = ?";
}

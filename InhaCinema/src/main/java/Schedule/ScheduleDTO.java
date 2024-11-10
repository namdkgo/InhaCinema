package Schedule;

import java.util.Date;

public class ScheduleDTO {
	private int scheduleIndex;
	private int movieIndex;
	private String cinemaIndex;
	private Date screenDate;
	private String startTime;
	private String seatState;
	
	public ScheduleDTO(int scheduleIndex, int movieIndex, String cinemaIndex, Date screenDate, String startTime, String seatState) {
		this.scheduleIndex = scheduleIndex;
		this.movieIndex = movieIndex;
		this.cinemaIndex = cinemaIndex;
		this.screenDate = screenDate;
		this.startTime = startTime;
		this.seatState = seatState;
	}
	
	public int getScheduleIndex() {
		return scheduleIndex;
	}
	public void setScheduleIndex(int scheduleIndex) {
		this.scheduleIndex = scheduleIndex;
	}
	public String getCinemaIndex() {
		return cinemaIndex;
	}
	public void setCinemaIndex(String cinemaIndex) {
		this.cinemaIndex = cinemaIndex;
	}
	public int getMovieIndex() {
		return movieIndex;
	}
	public void setMovieIndex(int movieIndex) {
		this.movieIndex = movieIndex;
	}
	public Date getScreenDate() {
		return screenDate;
	}
	public void setScreenDate(Date screenDate) {
		this.screenDate = screenDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getSeatState() {
		return seatState;
	}
	public void setSeatState(String seatState) {
		this.seatState = seatState;
	}

	
}

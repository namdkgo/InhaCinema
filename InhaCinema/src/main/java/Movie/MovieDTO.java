package Movie;

import java.util.Date;

public class MovieDTO {
	private int movieIndex;
	private String movieTitle;
	private String movieDirector;
	private String movieGenre;
	private String movieLength;
	private String movieGrade;
	private Date movieOpenDate;
	private String movieCast;
	private String movieImage;
	private int movieAudience;
	

	
	public MovieDTO(int movieIndex, String movieTitle, String movieDirector, String movieGenre, String movieLength,
			String movieGrade, Date movieOpenDate, String movieCast, String movieImage, int movieAudience) {
		super();
		this.movieIndex = movieIndex;
		this.movieTitle = movieTitle;
		this.movieDirector = movieDirector;
		this.movieGenre = movieGenre;
		this.movieLength = movieLength;
		this.movieGrade = movieGrade;
		this.movieOpenDate = movieOpenDate;
		this.movieCast = movieCast;
		this.movieImage = movieImage;
		this.movieAudience = movieAudience;
	}
	
	public int getMovieIndex() {
		return movieIndex;
	}
	public void setMovieIndex(int movieIndex) {
		this.movieIndex = movieIndex;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getMovieDirector() {
		return movieDirector;
	}
	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}
	public String getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	public String getMovieLength() {
		return movieLength;
	}
	public void setMovieLength(String movieLength) {
		this.movieLength = movieLength;
	}
	public String getMovieGrade() {
		return movieGrade;
	}
	public void setMovieGrade(String movieGrade) {
		this.movieGrade = movieGrade;
	}
	public Date getMovieOpenDate() {
		return movieOpenDate;
	}
	public void setMovieOpenDate(Date movieOpenDate) {
		this.movieOpenDate = movieOpenDate;
	}
	public String getMovieCast() {
		return movieCast;
	}
	public void setMovieCast(String movieCast) {
		this.movieCast = movieCast;
	}
	public String getMovieImage() {
		return movieImage;
	}
	public void setMovieImage(String movieImage) {
		this.movieImage = movieImage;
	}
	public int getMovieAudience() {
		return movieAudience;
	}
	public void setMovieAudience(int movieAudience) {
		this.movieAudience = movieAudience;
	}
}

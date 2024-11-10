package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Member.MemberDAO;
import Movie.MovieDAO;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterMovieController")
public class RegisterMovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		MovieDAO movieDAO = new MovieDAO();
		String[] registerData = new String[8];
				
		int fileSize = 1024*1024*10; //10mb
		ServletContext context = getServletContext();
	    String uploadPath = "C:/movieImage"; 
	    try {
	    	MultipartRequest multi = new MultipartRequest(
	    			request, uploadPath, fileSize, "UTF-8",new DefaultFileRenamePolicy());
	    	
	    	registerData[0] = multi.getParameter("movieTitle");
			registerData[1] = multi.getParameter("movieDirector");
			registerData[2] = multi.getParameter("movieGenre");
			registerData[3] = multi.getParameter("movieLength");
			registerData[4] = multi.getParameter("movieGrade");
			registerData[5] = multi.getParameter("movieOpenDate");
			registerData[6] = multi.getParameter("movieCast");
			
			
	    	String originalFile = multi.getOriginalFileName("movieImage");
	    	String uploadFile = multi.getFilesystemName("movieImage");  	    	
	    	registerData[7] = uploadFile;
	    	
	    	movieDAO.RegisterMovie(registerData);
	    } catch(Exception e) {
	    	e.printStackTrace();
	    } finally {
			response.sendRedirect("CheckData.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

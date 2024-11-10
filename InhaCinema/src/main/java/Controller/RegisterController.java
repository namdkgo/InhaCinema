package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Member.MemberDAO;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		MemberDAO memberDAO = new MemberDAO();
		String[] registerData = new String[5];
		registerData[0] = request.getParameter("memberId");
		registerData[1] = request.getParameter("memberPw");
		registerData[2] = request.getParameter("memberName");
		registerData[3] = request.getParameter("memberBirth");
		registerData[4] = request.getParameter("memberEmail");
		try {
			if(memberDAO.IdCheck(registerData[0])) memberDAO.Register(registerData);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			response.sendRedirect("Login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

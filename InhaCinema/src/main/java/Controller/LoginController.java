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
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import Member.MemberDAO;
import Member.MemberDTO;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		MemberDAO memberDAO = new MemberDAO();
		String loginId = request.getParameter("memberId");
		String loginPw = request.getParameter("memberPw");
		try {
			HttpSession session=request.getSession();
			MemberDTO memberDTO = memberDAO.Login(loginId, loginPw);
			if(memberDTO != null) session.setAttribute("member", memberDTO);
		} catch (SQLException e) {
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

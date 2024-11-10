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
import Schedule.ScheduleDAO;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/ScheduleController")
public class ScheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		ScheduleDAO scheduleDAO = new ScheduleDAO();
		String type = request.getParameter("type");
		String message;
		String scheduleIndexParam = request.getParameter("scheduleIndex");
		int scheduleIndex = -1;
		if(scheduleIndexParam != null && !scheduleIndexParam.equals("null"))  
			scheduleIndex = Integer.parseInt(request.getParameter("scheduleIndex"));
		String movieIndex = request.getParameter("movieIndex");
		String cinemaIndex = request.getParameter("cinemaIndex");
		String screenDate = request.getParameter("screenDate");
		String startTime = request.getParameter("startTime");
		int result = 0;
		switch(type) {
		case "register":
			String[] registerData = {movieIndex, cinemaIndex, screenDate, startTime};
			try {
				result = scheduleDAO.RegisterSchedule(registerData);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(result == 0) setMessage(request, "오류로 인해 등록되지 않았습니다.");
				else setMessage(request, "정상적으로 등록되었습니다.");
				response.sendRedirect("RegisterSchedule.jsp");
			}
			break;
		case "modify":
			try {
				result = scheduleDAO.UpdateSchedule(scheduleIndex, movieIndex, cinemaIndex, screenDate, startTime);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(result == 0) setMessage(request, "오류로 인해 수정되지 않았습니다.");
				else setMessage(request, "정상적으로 수정되었습니다.");
				response.sendRedirect("ModifySchedule.jsp?scheduleIndex="+scheduleIndex);
			}			
			break;
		case "delete":
			try {
				result = scheduleDAO.DeleteSchedule(scheduleIndex);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(result == 0) setMessage(request, "오류로 인해 삭제되지 않았습니다.");
				else setMessage(request, "정상적으로 삭제되었습니다.");
				response.sendRedirect("ScheduleList_admin.jsp");
			}			
			break;
		default:
			setMessage(request, "type이 존재하지 않습니다.");
			response.sendRedirect("ScheduleList_admin.jsp");
		}
	}
	private void setMessage(HttpServletRequest request, String message) {
		HttpSession session = request.getSession();
		session.setAttribute("message", message);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

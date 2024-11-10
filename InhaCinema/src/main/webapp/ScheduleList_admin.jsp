<%@page import="java.util.HashMap"%>
<%@page import="java.util.Set"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Map"%>
<%@page import="Schedule.ScheduleDAO"%>
<%@page import="Schedule.ScheduleDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="TopMenu_admin.jsp" %>
<head>
<meta charset="UTF-8">
<title>인하씨네마 관리자 페이지 시간표 목록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<style>
	#form-wrap {
	text-align: center;
	width:600px; height:400px;
	margin: 0 auto;
	}
	#login-form {
	width:600px; height:400px;
	margin: 0 auto;
	}
	.form-control {
	display: inline;
	width: 300px; height: 40px;
	}
	.mb-3 {
	width: 500px; height: 40px;
	text-align: right;
	}
	.input-label {
	margin-right: 20px;
	}
	.datesWrap {
	display: flex;
	width: 600px;
	justify-content: flex-start;
	flex-wrap: wrap;
	margin: 50px auto;
	}
	.dates {
	display: inline-block;
	width: 110px; height: 40px;
	margin-top: 10px;
	border: 1px solid black;
	text-align: center;
	font-weight: bold;
	line-height: 40px;
	}
</style>
</head>
<body>
	<div class="datesWrap">
<%
	String screenDateParam = request.getParameter("screenDate");
	if(screenDateParam == null || screenDateParam.equals("null")) screenDateParam = "2024-11-09";
	String cinemaIndexParam = request.getParameter("cinemaIndex");
	int cinemaIndex = 0;
	if(cinemaIndexParam != null && !cinemaIndexParam.equals("null")) cinemaIndex = Integer.parseInt(cinemaIndexParam);
	else cinemaIndexParam = "0";
	for(int i = 0; i < 5; i++) {%>
		<a href="ScheduleList_admin.jsp?cinemaIndex=<%=i%>&screenDate=<%=request.getParameter("screenDate")%>"><span class="dates">상영관 <%=i %></span></a>
<%	}%>
	</div>
<%
	ScheduleDAO scheduleDAO = new ScheduleDAO();
	ArrayList<ScheduleDTO> schedules = scheduleDAO.SelectScheduleAll();
	Map<Date, ArrayList<ScheduleDTO>> scheduleMap = new HashMap<>();
	for(ScheduleDTO schedule : schedules) {
		scheduleMap.computeIfAbsent(schedule.getScreenDate(), key -> new ArrayList<>()).add(schedule);
	}
	Set<Date> Dates = scheduleMap.keySet();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 	Date screenDate = sdf.parse(screenDateParam);
%>
	<div class=datesWrap>
	<%for(Date date : Dates) {%>
		<a href="ScheduleList_admin.jsp?cinemaIndex=<%=request.getParameter("cinemaIndex")%>&screenDate=<%=date.toString()%>"><span class="dates"><%=date.toString() %></span></a>
	<%}%>
	</div>
	
<table class="table" style="text-align: center; margin: 50px auto; width: 700px;">
  <thead>
     <tr>
      <th scope="col" colspan="5">시간표 목록</th>
    </tr>
    <tr>
      <th scope="col" width="100px">#</th>
      <th scope="col" width="300px">영화 제목</th>
      <th scope="col" width="200px">상영 시간</th>
      <th scope="col" width="100px" colspan="2">수정 / 삭제</th>
    </tr>
  </thead>
  <tbody>
 <%

 	ArrayList<ScheduleDTO> schedulesInDate = scheduleMap.get(screenDate);
 	for(int i = 8; i <= 20; i++) {
 		boolean nullChecker = true;%>
	  	<tr>
	  	<th scope="row"><%=i %>시</th>
 		<%for(ScheduleDTO schedule : schedulesInDate) {
 			if(cinemaIndexParam != null && !cinemaIndexParam.equals("null")) {
 				System.out.println(schedule.getCinemaIndex());
 				System.out.println(cinemaIndexParam);
 				if(schedule.getCinemaIndex().equals(cinemaIndexParam)) {
		 			int startHour = Integer.parseInt(schedule.getStartTime().substring(0, 2));
		 			if(startHour == i) {
		 				MovieDTO movie = new MovieDAO().SelectMovieByIndex(schedule.getMovieIndex());
		 				if(movie != null) {
			 				int startMinute = Integer.parseInt(schedule.getStartTime().substring(3, 5));
			 				int movieLength = Integer.parseInt(movie.getMovieLength());
			 				int sumMinute = startMinute + movieLength;
			 				int endHour = startHour + sumMinute / 60;
			 				int endMinute = sumMinute % 60;
			 				String endTime = endHour+":"+endMinute;
			 				nullChecker = false;
			 			%>
					 	 <td><%=movie.getMovieTitle() %></td>
					 	 <td><%=schedule.getStartTime() + " ~ " + endTime %></td>
					 	 <td><a href="ModifySchedule.jsp?scheduleIndex=<%=schedule.getScheduleIndex()%>">수정</a></td>
					 	 <td><a href="DeleteSchedule.jsp?scheduleIndex=<%=schedule.getScheduleIndex()%>">삭제</a></td>		
		 			<%	}
		 			}
	 			}
 			}
	 	}%>
	 	<%if(nullChecker) {%><td></td><td></td><td></td><td></td>
	 	<%} %>
		</tr>
 <%}
 %>
 	</tbody>
 </table>
</body>
</html>
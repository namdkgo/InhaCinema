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
<title>인하씨네마 관리자 페이지 시간표 수정</title>
<style>
	#form-wrap {
	text-align: center;
	width:600px; height:400px;
	margin: 50px auto;
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
</style>
</head>
<body>
<%
	String scheduleIndexParam = request.getParameter("scheduleIndex");
	int scheduleIndex = 1;
	if(scheduleIndexParam != null && !scheduleIndexParam.equals("null")) scheduleIndex = 
			Integer.parseInt(scheduleIndexParam);
	ScheduleDTO schedule = new ScheduleDAO().SelectScheduleByScheduleIndex(scheduleIndex);
%>
<div id="form-wrap">
 <form id="login-form" action="ScheduleController" method="post">
 <input type="hidden" name="type" value="modify">
  <div class="mb-3">
    <span class="input-label">시간표번호</span> <input type="text" class="form-control" name="scheduleIndex" value="<%=schedule.getScheduleIndex() %>" readonly="readonly">
  </div>
  <div class="mb-3">
    <span class="input-label">영화번호</span> <input type="text" class="form-control" name="movieIndex" value="<%=schedule.getMovieIndex() %>" required>
  </div>
  <div class="mb-3">
    <span class="input-label">상영관번호</span> <input type="text" class="form-control" name="cinemaIndex" value="<%=schedule.getCinemaIndex() %>" min="0" max="4" required>
  </div>
  <div class="mb-3">
  <%SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  String minDate = sdf.format(new Date());%>
    <span class="input-label">상영일자</span> <input type="date" class="form-control" id="screenDate" name="screenDate" min="<%=minDate%>" value="<%=schedule.getScreenDate() %>" required>
  </div>
  <div class="mb-3">
    <span class="input-label">시작시간</span> <input type="text" class="form-control" name="startTime" value="<%=schedule.getStartTime() %>" required>
  </div>
  <button type="submit" class="btn btn-primary">수정</button>
 </form>
</div>
</body>
</html>
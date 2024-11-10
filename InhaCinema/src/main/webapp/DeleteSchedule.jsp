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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
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
	if(scheduleIndexParam != null && !scheduleIndexParam.equals("null")) scheduleIndex = Integer.parseInt(scheduleIndexParam);
	else response.sendRedirect("ScheduleList_admin.jsp");
	ScheduleDTO schedule = new ScheduleDAO().SelectScheduleByScheduleIndex(scheduleIndex);
%>
<div id="form-wrap">
 <form id="login-form" action="ScheduleController" method="post">
 <input type="hidden" name="type" value="delete">
  <div class="mb-3">
    <span class="input-label">시간표번호</span> <input type="text" class="form-control" name="scheduleIndex" value="<%=schedule.getScheduleIndex() %>" readonly="readonly">
  </div>
  <div class="mb-3">
    <span class="input-label">영화번호</span> <input type="text" class="form-control" name="movieIndex" value="<%=schedule.getMovieIndex() %>" readonly="readonly" required>
  </div>
  <div class="mb-3">
    <span class="input-label">상영관번호</span> <input type="text" class="form-control" name="cinemaIndex" value="<%=schedule.getCinemaIndex() %>" min="0" max="4" readonly="readonly" required>
  </div>
  <div class="mb-3">
  <%SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  String minDate = sdf.format(new Date());%>
    <span class="input-label">상영일자</span> <input type="date" class="form-control" id="screenDate" name="screenDate" min="<%=minDate%>" value="<%=schedule.getScreenDate() %>" readonly="readonly" required>
  </div>
  <div class="mb-3">
    <span class="input-label">시작시간</span> <input type="text" class="form-control" name="startTime" value="<%=schedule.getStartTime() %>" readonly="readonly" required>
  </div>
  <button type="submit" style="background-color: red; font-weight: bold;"class="btn btn-primary">삭제</button>
 </form>
</div>
</body>
</html>
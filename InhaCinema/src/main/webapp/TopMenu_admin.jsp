<%@page import="java.util.ArrayList"%>
<%@page import="Movie.MovieDTO"%>
<%@page import="Movie.MovieDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>인하씨네마 관리자 페이지 영화 목록</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="Home_admin.jsp">관리자페이지</a>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
        <a class="nav-link" href="RegisterMovie.jsp">영화 등록</a>
        <a class="nav-link" href="ScheduleList_admin.jsp">시간표 목록</a>
        <a class="nav-link" href="RegisterSchedule.jsp">시간표 등록</a>
      </div>
    </div>
  </div>
</nav>
<details style="margin-top: 30px;">
   <summary style="text-align: center;">영화 목록</summary>
<table class="table" style="text-align: center; margin: 0 auto; width: 500px;">
  <thead>
    <tr>
      <th scope="col" width="100px">영화 번호</th>
      <th scope="col" width="300px">영화 제목</th>
      <th scope="col" width="100px">영화 길이</th>
    </tr>
  </thead>
  <tbody>
 <%
 	MovieDAO movieDAO = new MovieDAO();
 	ArrayList<MovieDTO> movies = movieDAO.SelectMovieAll();
 	for(int i = 0; i < movies.size(); i++) {%>
 	<tr>
 	 <th scope="row"><%=i %></th>
 	 <td><%=movies.get(i).getMovieTitle()%></td>
 	 <td><%=movies.get(i).getMovieLength()%>분</td>
 	</tr>	
 <%}
 %>
  </tbody>
</table>
</details>
<%@include file="Message.jsp" %>
</body>
</html>
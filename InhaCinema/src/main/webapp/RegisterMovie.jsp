<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="TopMenu_admin.jsp" %>
<head>
<meta charset="UTF-8">
<title>인하씨네마 영화 등록 페이지</title>
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
</style>
</head>
<body>
<div id="form-wrap">
 <form id="login-form" action="RegisterMovieController" method="post" enctype="multipart/form-data">
  <div class="mb-3">
    <span class="input-label">영화 제목</span> <input type="text" class="form-control" name="movieTitle" required>
  </div>
  <div class="mb-3">
    <span class="input-label">영화 감독</span> <input type="text" class="form-control" name="movieDirector" required>
  </div>
  <div class="mb-3">
    <span class="input-label">영화 장르</span> <input type="text" class="form-control" name="movieGenre" required>
  </div>
  <div class="mb-3">
    <span class="input-label">영화 길이</span> <input type="number" class="form-control" name="movieLength" required>
  </div>
  <div class="mb-3">
    <span class="input-label">영화 등급</span> <input type="text" class="form-control" name="movieGrade" required>
  </div>
  <div class="mb-3">
    <span class="input-label">개봉일</span> <input type="date" class="form-control" name="movieOpenDate" required>
  </div>
  <div class="mb-3">
    <span class="input-label">출연진</span> <input type="text" class="form-control" name="movieCast" required>
  </div>
  <div class="mb-3">
    <span class="input-label">포스터</span> <input type="file" class="form-control" name="movieImage" required>
  </div>
  <button type="submit" class="btn btn-primary">회원가입</button>
 </form>
</div>
</body>
</html>
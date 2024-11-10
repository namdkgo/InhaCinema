<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인하씨네마 로그인 페이지</title>
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
 <form id="login-form" action="LoginController" method="post">
  <div class="mb-3">
    <span class="input-label">아이디</span> <input type="text" class="form-control" name="memberId" required>
  </div>
  <div class="mb-3">
    <span class="input-label">비밀번호</span> <input type="password" class="form-control" name="memberPw" required>
  </div>
  <button type="submit" class="btn btn-primary">로그인</button>
 </form>
</div>
</body>
</html>
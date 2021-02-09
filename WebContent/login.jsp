<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div class="card align-middle" style="width:20rem; border-radius:20px;  margin:auto; margin-top:280px;">
		<div class="card-title" style="margin-top:30px;">
			<h2 class="card-title text-center" style="color:#113366;">로그인</h2>
		</div>
		<div class="card-body">
      <form class="form-signin" action = "Login" method="POST" onSubmit="logincall();return false">
        <h5 class="form-signin-heading"></h5>
        <label for="inputEmail" class="sr-only">Your ID</label>
        
        <input type="text" id="uid" name="member_id" class="form-control" placeholder="Your ID" required autofocus><BR>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="upw" name="member_pw" class="form-control" placeholder="Password" required><br>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 기억하기
          </label>
        </div>
        
        <button id="btn-Yes" class="btn btn-lg btn-primary btn-block" type="submit">로 그 인</button>
        
      </form>
      <br>
      <a href="join.jsp" class="btn btn-lg btn-primary btn-block"><span class="txt_type">회원가입</span></a>
        <!-- <button id="btn-Yes2" class="btn btn-lg btn-primary btn-block" type="submit">회원가입</button> --> 
		
		
		<br><br><br><br><br>
		</div>
	</div>
	

</body>
</html>
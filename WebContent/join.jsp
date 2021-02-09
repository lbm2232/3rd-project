<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<div class="col-md-6 col-md-offset-3">
				<h3>회원가입 Form</h3>
			</div>
		</div>
		<div class="col-sm-6 col-md-offset-3">
			<form action = "Join" method = "post">
				<div class="form-group">
					<label for="inputId">아이디</label> <input type="text"
						class="form-control" id="inputId" name="member_id" placeholder="아이디를 입력해 주세요">
				</div>
				<div class="form-group">
					<label for="InputPw">비밀번호</label> <input type="password"
						class="form-control" id="InputPw" name="member_pw" placeholder="비밀번호를 입력해주세요">
				</div>
				
						
						
				<div class="form-group text-center">
					<button type="submit" id="join-submit" class="btn btn-primary">
						회원가입<i class="fa fa-check spaceLeft"></i>
					</button>
					<input type="button" onclick="location.href='main1.jsp'" class="btn btn-warning" value= "가입취소">
						
					</button>
				</div>
			</form>
		</div>




</body>
</html>
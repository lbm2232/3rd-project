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
				<h3>ȸ������ Form</h3>
			</div>
		</div>
		<div class="col-sm-6 col-md-offset-3">
			<form action = "Join" method = "post">
				<div class="form-group">
					<label for="inputId">���̵�</label> <input type="text"
						class="form-control" id="inputId" name="member_id" placeholder="���̵� �Է��� �ּ���">
				</div>
				<div class="form-group">
					<label for="InputPw">��й�ȣ</label> <input type="password"
						class="form-control" id="InputPw" name="member_pw" placeholder="��й�ȣ�� �Է����ּ���">
				</div>
				
						
						
				<div class="form-group text-center">
					<button type="submit" id="join-submit" class="btn btn-primary">
						ȸ������<i class="fa fa-check spaceLeft"></i>
					</button>
					<input type="button" onclick="location.href='main1.jsp'" class="btn btn-warning" value= "�������">
						
					</button>
				</div>
			</form>
		</div>




</body>
</html>
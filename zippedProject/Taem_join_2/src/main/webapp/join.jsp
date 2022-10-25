<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1" >  <!-- 반응형 웹에 사용하는 메타태그 -->
<link rel="stylesheet" href="css/bootstrap.css"> <!-- 참조  -->
<link rel="stylesheet" href="css/custom.css">
<title>로그인 화면</title>
</head>

<body>

<div class="container">
		<div class="jumbotron" style="padding-top : 20px;">
			<form method="post" action="userJoinAction.usr">
				<h3 style="text-align : center;"> 회원가입</h3>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="아이디" name="member_id" maxlength="20">
				</div>
					<div class="form-group">
					<input type="password" class="form-control" placeholder="비밀번호" name="member_pw" maxlength="20">
				</div>
					<div class="form-group">
					<input type="text" class="form-control" placeholder="이름" name="member_name" maxlength="20">
				</div>
				
				<div class="form-group">
					<input type="date" class="form-control" placeholder="생일" name="member_birth" maxlength="20">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="번호" name="member_phone" maxlength="20">
				</div>
				<div class="form-group">
						<input type="email" class="form-control" placeholder="이메일" name="member_email" maxlength="20">
					</div>
					<div class="form-group" style="text-align:center;">
						<div class="btn-group" data-toggle="button">
							<label class="btn btn-primary active">
								<input type="radio" name="member_gender" autocomplete="off" value="M" checked>남자
							</label>
							<label class="btn btn-primary active">
								<input type="radio" name="member_gender" autocomplete="off" value="F" checked>여자
							</label>
						</div>
					
					</div>
				
				<input type="submit" class="btn btn-primary form-control" value="회원가입">
			</form>
		</div>
</div>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
</body>
</html>
</body>
</html>
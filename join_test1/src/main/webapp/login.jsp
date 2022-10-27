<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1" >  <!-- 반응형 웹에 사용하는 메타태그 -->
<link rel="stylesheet" href="css/bootstrap.css"> <!-- 참조  -->
<link rel="stylesheet" href="css/custom.css">
<title>로그인 화면</title>
<script type="text/javascript">
	function save_idCheckCheck() {
		if(f.remember.checked){
			f.remember.value = 'checked';
		}else{
			f.remember.value = null;
		}
			
	}
</script>
</head>

<body>
    <%
	String member_id = null;
	if(session.getAttribute("member_id")!= null){
		member_id = (String) session.getAttribute("member_id");
	}
	
%>
<div class="container">
	<div class="col-lg-4"></div>
	<div class="col-lg-4"></div>
		<div class="jumbotron" style="padding-top : 20px;">
			<form method="post" action="userLoginAction.usr" name="f">
				<h3 style="text-align : center;"> 로그인</h3>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="아이디" name="member_id" id="login_id" maxlength="20" value="${cookie.login_id.value }">
				</div>
					<div class="form-group">
					<input type="password" class="form-control" placeholder="비밀번호" name="member_pwd" maxlength="20">
				</div>
				<input type="checkbox" name="remember" class="remember" onclick="save_idCheckCheck()" ${(cookie.save_id.value != null)?'checked':null}/>아이디 저장
				<input type="submit" class="btn btn-primary form-control" value="로그인">
			</form>
		</div>
	<div class="col-lg-4"></div>
</div>


</body>
</html>
</body>
</html>
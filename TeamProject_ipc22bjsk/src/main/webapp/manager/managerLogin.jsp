<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1" >  <!-- 반응형 웹에 사용하는 메타태그 -->
<link rel="stylesheet" href="../css/custom.css">
<link rel="stylesheet" href="../css/login.css">

<title>로그인 화면(관리자)</title>

</head>

<body>
	<!-- <div class="col-lg-4"></div>
	<div class="col-lg-4"></div>
		<div class="jumbotron" >
			<form method="post" action="managerLoginAction.mgr" name="f">
				<h3 style="text-align : center;">관리자 로그인</h3>
				
				<div class="form-group">
					<input type="text" class="form-control" placeholder="아이디" name="manager_id" id="login_id" maxlength="20">
				</div>
				
				<div class="form-group">
					<input type="password" class="form-control" placeholder="비밀번호" name="manager_pwd" maxlength="20">
				</div>
				<input type="submit" class="btn btn-primary form-control" value="로그인">
			</form>
		</div>
	<div class="col-lg-4"></div>
 -->
 
<div class="omb_login" style="margin-bottom: 20px;">
    	<h1 class="omb_authTitle">Login</h1>
		
			<div class="row omb_row-sm-offset-3">
				<div class="col-xs-12 col-sm-6">	
						<form method="post" action="managerLoginAction.mgr" name="f">
							
							<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<input type="text" class="form-control" placeholder="아이디" name="manager_id" id="login_id" maxlength="20" value="${cookie.login_id.value }">
							</div>
							
							<span class="help-block"></span>
							
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-lock"></i></span>
								<input type="password" class="form-control" placeholder="비밀번호" name="manager_pwd" maxlength="20">
							</div>
							
							
							<input type="submit" class="btn btn-lg btn-primary btn-block" value="로그인" style="margin-top : 10px;">
						
						</form>
					</div>
	</div>
	</div>
	

</body>
</html>
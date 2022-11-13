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
<link rel="stylesheet" href="css/login.css">

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


<div class="omb_login" style="margin-bottom: 20px;">
    	<h1 class="omb_authTitle">Login</h1>
		<div class="row omb_row-sm-offset-3 omb_socialButtons">
    	    <div class="col-xs-4 col-sm-2">
		        <a href="https://ko-kr.facebook.com/facebook/" class="btn btn-lg btn-block omb_btn-facebook">
			        <i class="fa fa-facebook visible-xs"></i>
			        <span class="hidden-xs">Facebook</span>
		        </a>
	        </div>
        	<div class="col-xs-4 col-sm-2">
		        <a href="https://twitter.com/" class="btn btn-lg btn-block omb_btn-twitter">
			        <i class="fa fa-twitter visible-xs"></i>
			        <span class="hidden-xs">Twitter</span>
		        </a>
	        </div>	
        	<div class="col-xs-4 col-sm-2">
		        <a href="https://www.google.co.kr/" class="btn btn-lg btn-block omb_btn-google">
			        <i class="fa fa-google-plus visible-xs"></i>
			        <span class="hidden-xs">Google+</span>
		        </a>
	        </div>	
		</div>

		<div class="row omb_row-sm-offset-3 omb_loginOr">
			<div class="col-xs-12 col-sm-6">
				<hr class="omb_hrOr">
				<span class="omb_spanOr">or</span>
			</div>
		</div>
		
			<div class="row omb_row-sm-offset-3">
				<div class="col-xs-12 col-sm-6">	
						<form method="post" action="userLoginAction.usr" name="f">
							
							<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<input type="text" class="form-control" placeholder="아이디" name="member_id" id="login_id" maxlength="20" value="${cookie.login_id.value }">
							</div>
							
							<span class="help-block"></span>
							
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-lock"></i></span>
								<input type="password" class="form-control" placeholder="비밀번호" name="member_pwd" maxlength="20">
							</div>
							
							
							<input type="submit" class="btn btn-lg btn-primary btn-block" value="로그인" style="margin-top : 10px;">
						
						
							<div class="row omb_row-sm-offset-3">
								<div class="col-xs-12 col-sm-3" style="margin-left: 20px;">
									<label class="checkbox">
										<input type="checkbox"  name="remember" class="remember" onclick="save_idCheckCheck()" ${(cookie.save_id.value != null)?'checked':null}/>아이디 저장
									</label>
								</div>
								
							</div>	
						</form>
					</div>
	</div>
	</div>
	
</body>
</html>
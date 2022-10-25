<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="member.MemberDAO" %>
    <%@ page import="java.io.PrintWriter" %>
    <%
    

        request.setCharacterEncoding("UTF-8");
    %>
    <jsp:useBean id="member" class="member.Member" scope="page" />
    <jsp:setProperty name="member" property="member_id"/>
    <jsp:setProperty name="member" property="member_pw"/>
    <jsp:setProperty name="member" property="member_name"/>
    <jsp:setProperty name="member" property="member_birth"/>
    <jsp:setProperty name="member" property="member_phone"/>
    <jsp:setProperty name="member" property="member_email"/>
    <jsp:setProperty name="member" property="member_gender"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>로그인 처리</title>
</head>
<body>
	<%
	String member_id=null;
	if(session.getAttribute("member_id") != null){
		member_id=(String)session.getAttribute("member_id");
	}
	if(member_id != null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('이미로그인이되어있습니다.')");
		script.println("location.href = 'main2.jsp'");
		script.println("<script>");
	}
	if(member.getMember_id()==null || member.getMember_pw()==null || member.getMember_name()==null ||
	   member.getMember_birth() ==null || member.getMember_phone()==null || member.getMember_email()==null||member.getMember_gender()==null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('입력이 안된사항이 있습니다.')");
		script.println("histoty.back()");
		script.println("<script>");
	}else{
		MemberDAO memberDAO = new MemberDAO();
		int result =memberDAO.join(member);
		if(result ==-1){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('이미존재하는아이디 입니다.')");
			script.println("histoty.back()");
			script.println("<script>");
		}
		else {
			session.setAttribute("member_id", member.getMember_id());
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = 'main2.jsp'");
			script.println("<script>");
		}
	}


	
	%>

</body>
</html>
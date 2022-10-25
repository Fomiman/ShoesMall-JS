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
	MemberDAO memberDAO = new MemberDAO();
	int result =memberDAO.login(member.getMember_id(), member.getMember_pw());
	if(result ==1){
		session.setAttribute("member_id", member.getMember_id());
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("location.href = 'main2.jsp'");
		script.println("<script>");
	}
	else if (result == 0){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('비밀번호가 틀립니다.')");
		script.println("histoty.back()");
		script.println("<script>");
	}
	else if (result == -1){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('존재하지않는 아이디 입니다.')");
		script.println("histoty.back()");
		script.println("<script>");
	}
	
	else if (result == -2){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('데이터베이스 오류 입니다.')");
		script.println("histoty.back()");
		script.println("<script>");
	}
	
	%>

</body>
</html>
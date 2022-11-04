<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="bbs.BbsDAO" %>
    <%@ page import="java.io.PrintWriter" %>
    <%
    request.setCharacterEncoding("UTF-8");
    %>
    <jsp:useBean id="bbs" class="bbs.Bbs" scope="page" />
    <jsp:setProperty name="user_board" property="post_no"/>
    <jsp:setProperty name="user_board" property="member_id"/>
    <jsp:setProperty name="user_board" property="post_date"/>
    <jsp:setProperty name="user_board" property="post_pw"/>
    <jsp:setProperty name="user_board" property="post_subject"/>
    <jsp:setProperty name="user_board" property="post_text"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>게시판 처리</title>
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
		script.println("alert('로그인을 하세요')");
		script.println("location.href = 'login.jsp'");
		script.println("<script>");
	}else{
		if(bbs.getPost_subject()==null || bbs.getPost_text()==null){
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('입력이 안된사항이 있습니다.')");
					script.println("histoty.back()");
					script.println("<script>");
				}else{
					BbsDAO bbsDAO = new BbsDAO();
					int result = bbsDAO.write(bbs.getPost_no(),bbs.getPost_id(),bbs.getPost_date(),bbs.getPost_pw(),
							                  bbs.getPost_subject(),bbs.getPost_text());
					if(result ==-1){
						PrintWriter script = response.getWriter();
						script.println("<script>");
						script.println("alert('글쓰기에 실패했습니다.')");
						script.println("histoty.back()");
						script.println("<script>");
					}
					else {
						PrintWriter script = response.getWriter();
						script.println("<script>");
						script.println("location.href = 'bbs.jsp'");
						script.println("<script>");
					}
				}
	}
	


	
	%>

</body>
</html>
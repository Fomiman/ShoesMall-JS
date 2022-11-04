<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.io.PrintWriter" %>
    <%@ page import="bbs.Bbs" %>
    <%@ page import="bbs.BbsDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1" >  <!-- 반응형 웹에 사용하는 메타태그 -->
<link rel="stylesheet" href="css/bootstrap.css"> <!-- 참조  -->
<link rel="stylesheet" href="css/custom.css">
<title>게시판</title>
</head>

<body>
	  <%@ include file="head_nav.jsp" %>
<%
	int post_id=0;
	if(request.getParameter("post_id") != null){
		post_id=Integer.parseInt(request.getParameter("post_id"));
	}
	if(post_id == 0){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert(유효하지않는글입니다.')");
		script.println("location.href='bbs.jsp'");
		script.println("<script>");
	}
	Bbs bbs = new BbsDAO().getBbs(post_id);

%>

<div class="container">
        <div class="row">
            <table class="table table-striped" style="text-align:center; border:1px solid #dddddd">
                <thead>
                    <tr>
                        <th colspan="3" style="background-color:#eeeeee; text-align:center;">게시판 글 보기</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td style="width:20%;">글 제목</td>
                        <td colspan="2"><%= bbs.getPost_subject()%></td>                  
                    </tr>
                    <tr>
                        <td>작성자</td>
                        <td colspan="2"><%= bbs.getPost_id() %></td>
                    </tr>
                    <tr>
                        <td>작성일자</td>
                        <td colspan="2"><%= bbs.getPost_date().substring(0,11) + bbs.getPost_date().substring(11, 13) + "시" 
                                + bbs.getPost_date().substring(14,16) + "분"  %></td>
                    </tr>
                    <tr>
                        <td>내용</td>
                        <td colspan="2" style="min-height:200px; text-align:left;">
                        <!-- 특수문자를 제대로 출력하기위해 & 악성스크립트를 방지하기위해 -->
                        <%= bbs.getPost_text() %></td>    
                    </tr>
                </tbody>
            </table>
            <a href="bbs.jsp" class="btn btn-primary">목록</a>
            <%
                if(member_id != null && member_id.equals(bbs.getPost_id())) {
            %>
                <a href="update.jsp?bbsID=<%=post_id %>" class="btn btn-primary">수정</a>
                <a href="deleteAction.jsp?bbsID=<%=post_id %>" class="btn btn-primary">삭제</a>
                
            <%     
                }
            %>
        </div>
    </div>
  <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
</body>
</html>
</body>
</html>
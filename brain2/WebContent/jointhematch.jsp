<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@page import="vo.MemberVO" %>
<%@page import="dao.MemberDAO" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="dao.BBSListActionDAO" %>
<%@ page import="vo.MatchVO" %>
<%@ page import="java.util.ArrayList" %>
﻿<!DOCTYPE html>
<%
	String id = (String)session.getAttribute("id");
System.out.printf("now id : %s\n",id);
MemberVO vo = new MemberVO();
MemberDAO dao = new MemberDAO();
vo = dao.getInfo(id);
int succ = vo.getSuccessMatch();
int all = vo.getAllMatch();
double avg=0;
if(succ == 0)avg=0;
else avg = (double)(succ/all)*100;

//BBS View
int pageNumber=1;
if(request.getParameter("pageNumber")!=null){
	pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
}
%>
<html>
<head>
	<title>매치 참가</title>
	<link rel="stylesheet" type="text/css" href="style.css" />
	<style>
		.circle {
			background: aliceblue;
			width: 400px;
			padding: 20px;
			border-radius: 50px;
			text-align: center;
			border-style: solid;
			margin: auto;
		}
		a:hover {
			color:red;
		}
	</style>

</head>
<body>

    <header>
        <div id="HL"> &nbsp;<a href="main.jsp">CUKBM</a></div>

        <div id="HR"><%
        	if (id == null) {
        %>
        <a href="login.jsp">로그인</a> | <a href="register.jsp">회원가입</a>
         <%
         	} 
                           else {
         %>
          <a href="mypage.jsp"><%=id%></a> | <a href="LogoutProc">로그아웃</a>
        <%
        	}
        %> | <a href="alarm.jsp">ALARM</a></div>
        <br />
    </header>
	<div class="header">
		<div class="title">&nbsp;JOIN THE MATCH</div>
		<div class="menu"><img src="image/menubar.png" /></div>
	</div>
	<br />
	<%
		if(id != null){
	%>
	<div class="container">
	<div class="row">
	<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
		<thead>
			<tr>
				<th style="background-color: #eeeeee; text-align:center;">번호</th>
				<th style="background-color: #eeeeee; text-align:center;">제목</th>
				<th style="background-color: #eeeeee; text-align:center;">시작</th>
				<th style="background-color: #eeeeee; text-align:center;">종료</th>
				<th style="background-color: #eeeeee; text-align:center;">최대인원</th>
				<th style="background-color: #eeeeee; text-align:center;">참가인원</th>
			</tr>
		</thead>
		<tbody>
		<%
			MatchVO match = new MatchVO();
				ArrayList<MatchVO> list = BBSListActionDAO.getList(pageNumber);
				for(int i=0;i<list.size();i++){
		%>
			<tr>
				<td><%=list.get(i).getSeqNo()%></td>
				<td><a href="jointhematch.jsp?bbsID=<%=list.get(i).getSeqNo()%>"><%=list.get(i).getTitle()%></a></td>
				<td><%=list.get(i).getStime()%></td>
				<td><%=list.get(i).getEtime()%></td>
				<td><%=list.get(i).getNeedman()%></td>
				<td><%=list.get(i).getNowman()%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<%
		if(pageNumber !=1){
	%>
	<a href="jointhematch.jsp?pageNumber=<%=pageNumber-1%>">이전</a>
	<%
		} if(BBSListActionDAO.nextPage(pageNumber+1)){
	%>
	<a href="jointhematch.jsp?pageNumber=<%=pageNumber+1 %>">다음</a>
	<%
	}
	%>
	<a href="makethematch.jsp" class="btn btn-primary pull-right">글쓰기</a>
	</div>
	</div>
	<%}else{ %>
 	 <script language="javascript">
            location.href="login.jsp";
            </script>	<%} %>
		<br />
	<br />
	<br />
	<div class="foot">
		number : 010 - 1234 - 5678<br />
		Facebook : object-oriented paradime	<br />
		address : catholic university<br />
		name : hong gil dong
	</div>
	

</body>
</html>
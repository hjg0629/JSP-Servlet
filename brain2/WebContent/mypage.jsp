<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@page import="vo.MemberVO" %>
     <%@page import="dao.MemberDAO" %>
﻿<!DOCTYPE html>
<%
System.out.println("--------------------mypage.jsp--------------------");

String id = (String)session.getAttribute("id");
if(id == null){
	System.out.println("로그인 미완료 : login.jsp로 이동합니다....\n");
}
else System.out.printf("Now User ID : %s\n",id);

MemberVO vo = new MemberVO();
MemberDAO dao = new MemberDAO();
vo = dao.getInfo(id);
int succ = vo.getSuccessMatch();
int all = vo.getAllMatch();
double avg=0;
if(succ == 0)avg=0;
else avg = (double)(succ/all)*100;
%>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="utf-8" />
	<title>My Page</title>
	<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
	
    <header>
        <div id="HL"> &nbsp;<a href="main.jsp">CUKBM</a></div>

        <div id="HR"> <%if (id == null) {%>
        <a href="login.jsp">로그인</a> | <a href="register.jsp">회원가입</a>
         <%} 
         else {%>
          <a href="mypage.jsp"><%=id %></a> | <a href="LogoutProc">로그아웃</a>
        <%} %> | <a href="alarm.jsp">ALARM</a></div>
        <br />
            <div class="header">
		        <div class="title">&nbsp;Main Page</div>
		        <div class="menu"><img src="image/menubar.png" /></div>
        </div>
        <br />
    </header>
	<div class="Bheader">
		<div class="title">&nbsp;MYPAGE</div>
		<div class="menu"><img src="image/menubar.png" /></div>
	</div>
	<br />
	<br />
	<%
	if(id == null){
	%>
	<script language="javascript">
		location.href = "login.jsp";
	</script>
	<%}
	else {%>
	<form method="get">
		<table class="t"border="1"> <!--getParameter-->
			<tr>
				<td style="text-align:center"><strong style="font-size:20px;color:blue; text-align:center"><%=id %></strong>님</td>
			</tr>
		</table>
		<br />
		<table class="t"border="1">
			<caption> <h2 style="color:darkblue">MYPAGE information</h2></caption>
			<tr>
				<td style="background:lightgray; ">전체 매칭 시도수</td>
				<td><%= all %> 회</td>
			</tr>
			<tr>
				<td style="background:lightgray;">매칭 성공 수</td>
				<td><%= succ %> 회</td>
			</tr>
			<tr>
				<td style="background:lightgray;">매칭 성공률</td>
				<td><%= avg %> %</td>
		</table>
		<br />
		<div class="Wheader">
			<div class="circle">현재 참가중인 매칭</div>
		</div>
		<br />
		<hr style="MARGIN:auto;width:80%; border-style:solid" />

		<table class="t"border="1">
			<!-- 매치 정보가 몇개인지 알아야 테이블 작성 가능-->
			<!-- -->
		</table>

		
	</form>
	<%} %>
	<br />
	<br />
	<br />
	<br />
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
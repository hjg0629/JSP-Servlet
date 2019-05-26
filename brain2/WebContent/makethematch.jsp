<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
    <%@page import="vo.MemberVO" %>
     <%@page import="dao.MemberDAO" %>
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
%>
<html>
<head>
	<title>매치생성</title>
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

        <div id="HR"><%if (id == null) {%>
        <a href="login.jsp">로그인</a> | <a href="register.jsp">회원가입</a>
         <%} 
         else {%>
          <a href="mypage.jsp"><%=id %></a> | <a href="LogoutProc">로그아웃</a>
        <%} %> | <a href="alarm.jsp">ALARM</a></div>
        <br />
    </header>
	<div class="header">
		<div class="title">&nbsp;MAKE THE MATCH</div>
		<div class="menu"><img src="image/menubar.png" /></div>
	</div>
	<br />
	<%if(id != null){ %>
	<form>
		<table class="t"border="1">
			<tr>
				<td style="text-align:center;">자신의 매치 성사율</td>
				<td style="text-align:center;">생성중인 매치</td>
			</tr>

		</table>
		<br />
		<table class="t"border="1">
			<tr>
				<td style="background:lightgreen; color:black; font-size:35px; text-align:center; "><%=avg %></td>
				<td style="background:lightgreen; color:black; font-size:35px; text-align:center; "><%= succ%></td>
			</tr>
			<tr>
				<td style="background:lightgray;">매칭 성공 수</td>
				<td><%=succ %></td>
			</tr>
			<tr>
				<td style="background:lightgray;">매칭 성공률</td>
				<td><%=avg %></td>
		</table>
		<br />
		<br />
		<hr style="margin-right:auto; border-style:solid" />

		<br />
		<p style="text-align:center; font-size:20px;border-radius:0px; width:400px; padding:20px; margin:auto; background:orange; color:black;">생성하고 싶은 종목을 선택하세요</p>
		<br />
		<div class="Wheader">
			<div class="circle"><a href="makeasports.jsp">ATHLETIC SPORTS</a></div>
			<div class="circle"><a href="makeesports.jsp">E-SPORTS</a></div>
		</div>

	</form>
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
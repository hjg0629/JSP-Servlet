<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
﻿<!DOCTYPE html>
<%
String id = (String)session.getAttribute("id");
System.out.printf("now id : %s\n",id);
%>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="utf-8" />
	<title></title>

	<link rel="stylesheet" type="text/css" href="style.css" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<style>

	</style>

</head>
<body>
	<header>
		<div id="HL"> &nbsp;<a href="main.jsp">CUKBM</a></div>
        <div id="HR">
        <%if (id == null) {%>
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

	<article>
		<table id="mainimage" border="0">
			<tbody>
				<tr>
					<td style="font-size:20px"><a href="joinamatch.jsp">Sports</a></td>
					<td rowspan="5"><img src="image/12345.png" width="300" height="340" /></td>
					<td style="font-size:20px"><a href="joinematch.jsp">E-Sports</a></td>
				</tr>
				<tr>
					<td><a href="joinamatch.jsp"><img src="image/soccer.png"  width="70" height="50"/><br />축구</a></td>
					<td><a href="joinematch.jsp"><img src="image/lol.png" width="70" height="50" /><br />롤</a></td>
				</tr>
				<tr>
					<td><a href="joinamatch.jsp"><img src="image/basketball.png" width="70" height="50" /><br />농구</a></td>
					<td><a href="joinematch.jsp"><img src="image/battleground.png" width="70" height="50" /><br />배틀그라운드</a></td>
				</tr>
				<tr>
					<td><a href="joinamatch.jsp"><img src="image/badminton.png" width="70" height="50" /><br />배드민턴</a></td>
					<td><a href="joinematch.jsp"><img src="image/kartrider.png" width="70" height="50" /><br />카트라이더</a></td>
				</tr>
				<tr>
					<td><a href="joinamatch.jsp"><img src="image/tennis.png" width="70" height="50" /><br />테니스</a></td>
					<td><a href="joinematch.jsp"><img src="image/overwatch.png" width="70" height="50" /><br />오버워치</a></td>

				</tr>
			</tbody>
		</table>

		<br />

		<div class="Carousel">
			<ol class="dots"></ol>
			<ol class="slides">
				<li class="slide link">
					<img src="image/생성.png" alt="매칭 생성 이미지" />
				</li>
				<li class="slide link">
					<img src="image/참가.png" alt="매칭 참가 이미지" />
				</li>
				<li class="slide link">
					<img src="image/마이페이지.png" alt="My Page 이미지" />
				</li>
			</ol>
			<div class="next">
				<div class="button"></div>
			</div>
			<div class="prev">
				<div class="button"></div>
			</div>
		</div>
		<script type="text/javascript" src="script.js"></script>

		<table id="Category">
			<tr>
                <td rowspan="5">
                    <a href="makethematch.jsp"><img src="image/생성.png" width="200" height="200" /></a>
                </td>
				<td rowspan="5">
					<a href="jointhematch.jsp"><img src="image/참가.png" width="200" height="200" /></a>
				</td>
				<td rowspan="5">
					<a href="mypage.jsp"><img src="image/마이페이지.png" width="200" height="200" /></a>
				</td>
			</tr>

		</table>
	</article>

	<div class="foot">
		number : 010 - 1234 - 5678<br />
		Facebook : object-oriented paradime	<br />
		address : catholic university<br />
		name : hong gil dong
	</div>
</body>
</html>
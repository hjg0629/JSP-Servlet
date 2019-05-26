<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
﻿<!DOCTYPE html>
<%
String result =request.getParameter("result");
String id = request.getParameter("id");
if(result != null){
if(result.equals("idno")) 
{%>
<script language="javascript">
alert("ID가 존재하지 않습니다.");
document.userinput.id.value="";
</script>
<%} 
if(result.equals("passwdno")) {%>
<script language="javascript">
alert("PW가 일치하지 않습니다.");
document.userinput.id.value=id;
document.userinput.pw.value="";
document.userinput.pw.focus();
</script>
<%}} %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
    <style>
      #HEADER {
         background: white;
      }

      a {
         text-decoration: none;
         color: black;
      }

      #HL {
         text-align: center;
         font-size: 35px;
      }
      
      #loginarea{
          margin-left:30%;
          margin-right:30%;
      }
      .menubar {
         display: flex;
         background: black;
      }

      .title {
         margin-right: auto;
         color: white;
         font-size: 30px;
      }
      a:hover{
          color:blue;
      }
    </style>
    <script language ="javascript">
    function login(){
    	if(!document.userinput.id.value){
    		alert("ID를 입력하세요");
    		document.userinput.id.focus();
    		return false;
    	}
    	if(!document.userinput.pw.value){
    		alert("PassWord를 입력하세요");
    		document.userinput.pw.focus();
    		return false;
    	}
    }
    
    </script>
</head>
<body>
    <header>
        <div id="HL"> &nbsp;<a href="main.jsp">CUKBM</a></div>
        <div id="HR"><a href="login.jsp">로그인</a> | <a href="register.jsp">회원가입</a> | <a href="alarm.jsp">ALARM</a></div>
        <br />
        <div class="header">
            <div class="title">&nbsp;Main Page</div>
            <div class="menu"><img src="image/menubar.png" /></div>
        </div>
    </header>
    <article>
        <h2>로그인</h2><br /><br />
        <div id="loginarea">
        <form action="LoginProc" method="post" name="userinput" id ="userinput"  onsubmit="return login()"> 
            <input type="text" name ="id" id="id" maxlength="50" title="id" placeholder="  아이디"><br /><br />
            <input type="text" name="pw" id="pw" maxlength="50" placeholder="  비밀번호"/><br /><br />
            <input type="submit" id="sb"value="로 그 인" /><br /><br />
        </form>
            <h6>아직 회원이 아니신가요? <a href="register.jsp">&nbsp;&nbsp;&nbsp;&nbsp;회원가입하기</a></h6>    
        </div>
    </article>
</body>
</html>
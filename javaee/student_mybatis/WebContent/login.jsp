<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/common.css" type="text/css" />
<link rel="stylesheet" href="css/login.css" type="text/css" />
<title>登录页面</title>
</head>
<body>
	<div class="main">
		<div class="header">
			<h1>学生信息管理系统</h1>
		</div>
		<div class="loginMain">
		    <p>${msg}</p>
			<form action="LoginController" method="post" onsubmit="return checkLogin()">
				<input type="text" name="username" placeholder="用户名" /> 
				<input type="password" name="password" placeholder="密码" /> 
				<input type="submit" value="登录" class="btn" />
			</form>
		</div>
	</div>
	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>

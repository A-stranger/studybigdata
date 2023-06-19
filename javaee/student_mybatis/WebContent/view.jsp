<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息管理系统主页</title>
<link rel="stylesheet" type="text/css" href="css/common.css"/>
<link rel="stylesheet" type="text/css" href="css/view.css"/>
</head>
<body>
	<div class="main">
		<div class="header">
			<h1>学生信息管理系统</h1>
		</div>
	
		<div class="content">
			<p>${account.type.name}：${account.account}&nbsp;&nbsp;&nbsp;<a href="LoginController">注销</a></p>
		
			<c:if test="${account.type.id==1}">
				<form action="StudentController" method="post" class="formclass">
					<input type="hidden" name="operation" value="find" />     
					id: <input type="text" name="id" value="" class="information"/>
					name: <input type="text" name="name" value="" class="information"/>
					age: <input type="text" name="age" value="" class="information"/>
					<input type="submit" value="查询" class="btn"/>
				</form>
			  
				<a href="add.jsp">添加</a>
			  
				<h2>学生信息列表</h2>
				<table border="1">
					<tr>
					    <td>编号</td>
					    <td>名称</td>
					    <td>年龄</td>
					    <td>性别</td>
					    <td>账户</td>
					    <td>密码</td>
					    <td>类型</td>
					    <td colspan="2">操作</td>
					</tr>
				     
					<c:forEach items="${studentList}" var="student">
					<tr>
						<td>${student.id}</td>
						<td>${student.name}</td>
						<td>${student.age}</td>		           
						<td>${student.sex=='m'?"男":"女"}</td>
						<td>${student.account}</td>
						<td>${student.password}</td>
						<td>${student.type.name}</td>
						<td><a href="StudentController?id=${student.id}&operation=delete">删除</a></td>
						<td><a href="StudentController?id=${student.id}&operation=getById">更新</a></td>
					</tr>
					</c:forEach>
				</table>
			</c:if>
		
			<c:if test="${account.type.id==2}">
				<h2>学生信息</h2>
				<table border="1">
					<tr>
						<td>编号</td>
						<td>名称</td>
						<td>年龄</td>
						<td>性别</td>
						<td>账户</td>
						<td>密码</td>
						<td>类型</td>
					</tr>
				    
					<tr>
						<td>${account.id}</td>
						<td>${account.name}</td>
						<td>${account.age}</td>		           
						<td>${account.sex=='m'?"男":"女"}</td>
						<td>${account.account}</td>
						<td>${account.password}</td>
						<td>${account.type.name}</td>
					</tr>
				</table>
			</c:if>
		</div>
	   
		<div class="footer"><p>《Java EE 应用开发及实训》第2版（机械工业出版社）</p></div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新学生信息</title>
<link rel="stylesheet" type="text/css" href="css/common.css"/>
</head>
<body>
	<div class="main"> 
		<div class="header">
			<h1>学生信息管理系统</h1>
		</div>
	   
		<div class="content">
			<h2>更新学生信息</h2>
			<form action="StudentController" method="post" onsubmit="return check()" class="contact_form">
				<input type="hidden" name="operation" value="update" />
				<input type="hidden" name="id" value="${student.id}"  />
				<ul>
					<li class="usually">
						<span>用户名：</span>
						<input type="text" name="name" value="${student.name}" />
					</li>				
					<li class="usually">
						<span>年龄：</span>
						<input type="text" name="age" value="${student.age}" />
					</li>					
					<li class="usually">
						<span>性别： </span>
						<input type="radio" name="sex" value="m" class="information"  ${student.sex=="m" ? "checked":""} id="male"/>
						<label for="male">男</label>
						<input type="radio" name="sex" value="f" class="information"  ${student.sex=="f" ? "checked":""} id="female"/>
						<label for="female">女</label>
					</li>					
					<li class="usually">
						<span>账号：</span>
						<input type="text" name="account" value="${student.account}" />
					</li>					
					<li class="usually">
						<span>密码：</span>
						<input type="text" name="password" value="${student.password}" />
					</li>					
					<li class="usually">
						<span>类型：</span>
						<select name="typeId">
							<option value="1" ${student.type.id==1 ? "selected":""}>管理员</option>
							<option value="2" ${student.type.id==2 ? "selected":""}>用户</option>
						</select> 
					</li>					    
					<li>
						<input type="submit" value="修改" class="submit" />
					</li>
				</ul>            
			</form>
		</div>
		<div class="footer"><p>《Java EE 应用开发及实训》第2版（机械工业出版社）</p></div>
	</div>
	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>小区物业信息管理系统</title>
		<link rel="stylesheet" href="css/login.css">
		<script type="text/javascript" src="js/jQuery/jquery-1.7.1.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$("#submit").click(function() {
					if($("#username").val() == "" || $("#password").val() == "") {
						alert("用户名和密码不能为空！");
						return false;
					}
					$("#loginForm").submit();
				});
				loginFail();
				haslogged();
			});

			//已经登陆过
			function haslogged() {
				var x = "${sessionScope.user.id}";
				if(x != "")
					window.location.href = "main.jsp";
			}
			//登录失败
			function loginFail() {
				var x = "${requestScope.fail}";
				if(x != "") {
					alert("用户名或密码错误！");
				}
			}
		</script>
	</head>

	<body>
		<div class="form">
			<div class="forceColor"></div>
			<div class="topbar">
				<div class="spanColor"></div>
				<form action="loginCheck" method="post" id="loginForm">
					<input type="text" class="input" id="username" name="username" placeholder="username" />
					<input type="password" class="input" id="password" name="password" placeholder="password" />
				</form>
			</div>
			<button class="submit" id="submit">登录</button>
		</div>
	</body>

</html>
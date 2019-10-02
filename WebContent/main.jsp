<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<title>小区物业信息管理系统</title>
		<link rel="stylesheet" href="css/amazeui.min.css" type="text/css" />
		<link rel="stylesheet" href="css/admin.css" type="text/css">
		<link rel="stylesheet" href="css/main.css" />
		<script src="js/jQuery/jquery-1.7.1.js" type="text/javascript"></script>
		<script type="text/javascript" src="js/main.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				userId = "${sessionScope.user.id}";
				userRid = "${sessionScope.user.rid}";
				userPassword = "${sessionScope.user.password}";
				userBuilding = "${sessionScope.user.resident.building}";
				userRoom = "${sessionScope.user.resident.room}";
			})

			//显示模块下子功能
			function showChildren(a) {
				<c:forEach items="${menu}" var="menuItem">
			if("${menuItem.name}"==a.innerText){
				$("#nav1").html("${menuItem.name}");
				var rs="";
				<c:forEach items="${menuItem.children}" var="child">
					var link="${child.link}";
					rs+="<li><a href=\"javascript:switchPage('"+link+"')\">";
					rs+="${child.name}"+"</a></li>";
				</c:forEach>
				$("#nav2").html(rs);
			}
				</c:forEach>
			}
		</script>
	</head>

	<body>
		<header class="am-topbar admin-header">
			<div class="am-topbar-brand"><img src="images/logo.png" width="427px" height="80px"></div>
			<div class="am-collapse am-topbar-collapse" id="topbar-collapse">
				<ul class="am-nav am-nav-pills am-topbar-nav admin-header-list">
					<li class="kuanjie">
						<c:forEach items="${menu}" var="menuItem">
							<a href="javascript:void(0)" onclick="showChildren(this)">${menuItem.name}</a>
						</c:forEach>
					</li>
					<li class="kuanjie" style="height: 80px;padding-top: 25px;padding-left: 40px;font-size: 1.8rem;">当前用户：${sessionScope.user.username}
					</li>
					<li class="kuanjie">
						<a href="javascript:out()">退出系统</a>
					</li>
				</ul>
			</div>
		</header>

		<div class="am-cf admin-main">
			<div class="nav-navicon admin-main admin-sidebar">
				<div class="sideMenu">
					<h3 id=nav1 style="font-size: 2rem;">首页</h3>
					<ul id=nav2>
						<li>
							<a href="javascript:switchPage('briefing')">小区概述</a>
						</li>
					</ul>
				</div>
				<!-- sideMenu End -->
			</div>

			<div class=" admin-content">
				<!--显示具体内容-->
				<div class="admin" id="neirong">
					<iframe src="briefing.jsp" height="888px" width="1710px"></iframe>
				</div>
			</div>
		</div>

	</body>

</html>
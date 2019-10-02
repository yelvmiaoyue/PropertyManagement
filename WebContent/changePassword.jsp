<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>修改密码</title>
	</head>

	<body>
		<div class="admin-biaogelist">
			<div class="listbiaoti am-cf">
				<ul>修改密码</ul>
			</div>
			<div class="fbneirong">
				<br /><br /><br /><br /><br />
				<form class="am-form" action="javascript:changePassword()" method="post">
					<div class="am-form-group am-cf">
						<div class="zuo">旧密码：</div>
						<div class="you"><input type="password" class="am-input-sm" id="old"></div>
					</div>
					<div class="am-form-group am-cf">
						<div class="zuo">新密码：</div>
						<div class="you"><input type="password" class="am-input-sm" id="new1"></div>
					</div>
					<div class="am-form-group am-cf">
						<div class="zuo">确认新密码：</div>
						<div class="you"><input type="password" class="am-input-sm" id="new2"></div>
					</div>
					<div class="am-form-group am-cf">
						<div class="you" style="margin-left: 11%;">
							<button type="submit" class="am-btn am-btn-success am-radius">提交</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</body>

</html>
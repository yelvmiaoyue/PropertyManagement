<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>新增公告</title>

	</head>

	<body>
		<div class="admin-biaogelist">
			<div class="listbiaoti am-cf">
				<ul>新增公告</ul>
			</div>
			<div class="fbneirong">
				<br /><br /><br /><br /><br />
				<form class="am-form" action="javascript:addStatement()" method="post">
					<div class="am-form-group am-cf">
						<div class="zuo">标题：</div>
						<div class="you"><input type="text" class="am-input-sm" id="title" placeholder="请输入标题"></div>
					</div>
					<div class="am-form-group am-cf">
						<div class="zuo">内容：</div>
						<div class="you"><textarea class="" rows="20" id="content"></textarea></div>
					</div>
					<div class="am-form-group am-cf">
						<div class="you" style="margin-left: 11%;">
							<button type="submit" class="am-btn am-btn-success am-radius">发布</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</body>

</html>
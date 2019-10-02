<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>新增设备</title>
	</head>

	<body>
		<div class="admin-biaogelist">
			<div class="listbiaoti am-cf">
				<ul>新增设备</ul>
			</div>
			<div class="fbneirong">
				<br /><br /><br /><br /><br />
				<form class="am-form" action="javascript:addDevice()" method="post" id="form">
					<div class="am-form-group am-cf">
						<div class="zuo">设备号：</div>
						<div class="you" style="width: 400px;"><input type="text" class="am-input-sm" id="id"></div>
					</div>
					<div class="am-form-group am-cf">
						<div class="zuo">类型：</div>
						<div class="you" style="width: 400px;"><input type="text" class="am-input-sm" id="type"></div>
					</div>
					<div class="am-form-group am-cf">
						<div class="zuo">厂商：</div>
						<div class="you" style="width: 400px;"><input type="text" class="am-input-sm" id="manufacturer"></div>
					</div>
					<div class="am-form-group am-cf">
						<div class="zuo">位置：</div>
						<div class="you" style="width: 400px;"><input type="text" class="am-input-sm" id="position"></div>
					</div>
					<div id="change"></div>
					<div class="am-form-group am-cf">
						<div class="you" style="margin-left: 11%;" id="cancel">
							<button type="submit" class="am-btn am-btn-success am-radius">提交</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</body>

</html>
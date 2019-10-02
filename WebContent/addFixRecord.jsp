<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>新增检修记录</title>
	</head>

	<body>
		<div class="admin-biaogelist">
			<div class="listbiaoti am-cf">
				<ul>新增检修记录</ul>
			</div>
			<div class="fbneirong">
				<br /><br /><br /><br /><br />
				<form class="am-form" action="javascript:addFixRecord()" method="post">
					<div class="am-form-group am-cf">
						<div class="zuo">设备号：</div>
						<div class="you" style="width: 400px;"><input type="text" class="am-input-sm" id="deviceId"></div>
					</div>
					<div class="am-form-group am-cf">
						<div class="zuo">检修时间：</div>
						<div class="you" style="width: 400px;"><input type="date" class="am-input-sm" id="time" /></div>
					</div>
					<div class="am-form-group am-cf">
						<div class="zuo">检修人：</div>
						<div class="you" style="width: 400px;"><input type="text" class="am-input-sm" id="man"></div>
					</div>
					<div class="am-form-group am-cf">
						<div class="zuo">结果：</div>
						<div class="you" style="width: 400px;">
							<select id="result">
								<option value="1">正常</option>
								<option value="2">需维修</option>
							</select>
						</div>
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
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>车辆登记</title>
	</head>

	<body>
		<div class="admin-biaogelist">
			<div class="listbiaoti am-cf">
				<ul>车辆登记</ul>
			</div>
			<div class="fbneirong">
				<br /><br /><br /><br /><br />
				<form class="am-form" action="javascript:carRegister()" method="post">
					<div class="am-form-group am-cf">
						<div class="zuo">业主地址：</div>
						<div class="you" style="width: 400px;"><input type="text" class="am-input-sm" id="address" disabled="disabled"></div>
					</div>
					<div class="am-form-group am-cf">
						<div class="zuo">车位位置：</div>
						<div class="you" style="width: 400px;"><input type="text" class="am-input-sm" id="position" disabled="disabled"></div>
					</div>
					<div class="am-form-group am-cf">
						<div class="zuo">车牌号码：</div>
						<div class="you" style="width: 400px;"><input type="text" class="am-input-sm" id="carNumber"></div>
					</div>
					<div class="am-form-group am-cf">
						<div class="zuo">车辆型号：</div>
						<div class="you" style="width: 400px;"><input type="text" class="am-input-sm" id="type"></div>
					</div>
					<div class="am-form-group am-cf">
						<div class="zuo">车辆颜色：</div>
						<div class="you" style="width: 400px;"><input type="text" class="am-input-sm" id="color"></div>
					</div>
					<div class="am-form-group am-cf">
						<div class="you" style="margin-left: 11%;">
							<button type="submit" class="am-btn am-btn-success am-radius" id="submit">提交申请</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<input type="hidden" id="hasApplied" value="0" />
	</body>

</html>
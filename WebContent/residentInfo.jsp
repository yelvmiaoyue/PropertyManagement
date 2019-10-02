<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>业主信息</title>
	</head>

	<body>
		<div class="admin-biaogelist">
			<div class="listbiaoti am-cf">
				<ul>业主信息</ul>
			</div>
			<div class="fbneirong">
				<br /><br /><br /><br /><br />
				<form class="am-form" action="javascript:residentInfo(userId)" method="post">
					<table style="margin: 0 auto;">
						<tr>
							<td width="80px">业主地址：</td>
							<td width="350px">
								<div class="you" style="width: 300px;"><input type="text" class="am-input-sm" id="address" disabled="disabled"></div>
							</td>
							<td width="80px">户主姓名：</td>
							<td width="350px">
								<div class="you" style="width: 300px;"><input type="text" class="am-input-sm" id="owner"></div>
							</td>
						</tr>
						<tr>
							<td width="80px">联系电话：</td>
							<td width="350px">
								<div class="you" style="width: 300px;"><input type="text" class="am-input-sm" id="phone"></div>
							</td>
							<td width="80px">电子邮箱：</td>
							<td width="350px">
								<div class="you" style="width: 300px;"><input type="email" class="am-input-sm" id="email"></div>
							</td>
						</tr>
						<tr height="40px"></tr>
						<tr>
							<td width="350px" height="45px" colspan="2">
								<span style="font-size: 1.6rem;"><b>以下是住户家庭成员的信息</b></span>
							</td>
						</tr>
						<tr>
							<td width="350px" height="45px" colspan="2">
								<span style="font-size: 1.6rem;"><input type="button" value="增加家庭成员" onclick="addMember()"/></span>
							</td>
						</tr>
					</table>
					<div style="margin: 0 auto;" id="out">

					</div>
					<table style="margin: 0 auto;">
						<tr>
							<td width="350px" height="45px" colspan="2">
								<button type="submit" class="am-btn am-btn-success am-radius">提交</button>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<input type="hidden" id="memberNum" value="0" />
	</body>

</html>
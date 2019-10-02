<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>家庭报修</title>
		<script>
			function secondLevel() {
				var second = [
					["开关插座类", "室内照明类", "其他"],
					["水龙头类", "房屋漏水类", "下水疏通类"],
					["热水器类", "天然气灶类"],
					["瓷砖类", "墙面类", "下水管道类"]
				];
				var temp = second[$("#type1").val()];
				$("#type2").empty();
				for(var j = 0; j < temp.length; j++) {
					$("#type2").append(new Option(temp[j], j));
				}
			}
		</script>
	</head>

	<body>
		<div class="admin-biaogelist">
			<div class="listbiaoti am-cf">
				<ul>家庭报修</ul>
			</div>
			<div class="fbneirong">
				<br /><br /><br /><br /><br />
				<form class="am-form" action="javascript:addRepairRecord()" method="post">
					<div class="am-form-group am-cf">
						<div class="zuo">家庭地址：</div>
						<div class="you" style="width: 400px;"><input type="text" class="am-input-sm" id="address" disabled="disabled"></div>
					</div>
					<div class="am-form-group am-cf">
						<div class="zuo">维修项目：</div>
						<div class="you" style="width: 300px;">
							<table width="300px">
								<tr >
									<select id="type1" onchange="secondLevel()">
										<option value="0">电</option>
										<option value="1">水</option>
										<option value="2">气</option>
										<option value="3">泥</option>
									</select>
								</tr>
								<tr>
									<select id="type2">
										<option value="1">开关插座类</option>
										<option value="2">室内照明类</option>
										<option value="3">其他</option>
									</select>
								</tr>
							</table>
						</div>
					</div>
					<div class="am-form-group am-cf">
						<div class="zuo">故障描述：</div>
						<div class="you" style="width: 400px;"><textarea class="" rows="2" id="content"></textarea></div>
					</div>
					<div class="am-form-group am-cf">
						<div class="zuo">联系电话：</div>
						<div class="you" style="width: 400px;"><input type="text" class="am-input-sm" id="phone"></div>
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
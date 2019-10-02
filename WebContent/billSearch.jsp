<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>缴费查询</title>
		<script>
			$("#code").load(function() {
				getCode();
			})
			$("#notClear").click(function() {
				$("#code").attr("src", "validCode?date=" + new Date());
				return false;
			})
		</script>
	</head>

	<body>
		<div class="admin-biaogelist">
			<div class="listbiaoti am-cf">
				<ul>缴费查询</ul>
			</div>
			<form class="am-form am-g">
				<table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover">
					<thead>
						<tr class="am-success">
							<th class="table-id" width="18%">流水号</th>
							<th class="table-id" width="20%">类型</th>
							<th class="table-title" width="18%">费用</th>
							<th class="table-type" width="18%">时间</th>
							<th class="table-author am-hide-sm-only" width="16%">状态</th>
							<th width="10%">操作</th>
						</tr>
					</thead>
					<tbody id="tableBody">
					</tbody>
				</table>

				<!-- 分页-->
				<ul class="am-pagination am-fr">
					<li id="pageUp" class="am-disabled">
						<a href="javascript:void(0)" onclick="{var pageNum=Number($('#pageNum').val())-1;$.get('billSearch',{pageNum:pageNum,building:userBuilding,room:userRoom},function(data){showbill(data);})}">上一页</a>
					</li>
					<li id="pageDown" class="">
						<a href="javascript:void(0)" onclick="{var pageNum=Number($('#pageNum').val())+1;$.get('billSearch',{pageNum:pageNum,building:userBuilding,room:userRoom},function(data){showbill(data);})}">下一页</a>
					</li>
					<li class="am-disabled">
						<a href="javascript:void(0)" id="currentPage"></a>
					</li>
				</ul>
				<hr />
			</form>
			<input type="hidden" id="pageNum" value="" />
			<input type="hidden" id="codeString" value="" />
			<!--弹出层-->
			<div id="light" class="white_content">
				<p>您的账户余额为：<span id="account"></span></p><br /><br />
				<p>请输入验证码：</p>
				<input type="text" id="validCode" maxlength="4" width="60px" />
				<img id="code" src="validCode" width="150" height="75" />
				<a id="notClear" href="">看不清</a>
				<table style="margin:0 auto;" width="200px">
					<tr>
						<td width="100px">
							<input type="button" value="确定" onclick="payBill(source)" />
						</td>
						<td width="100px">
							<input type="button" value="取消" onclick="hideValidCode()" />
						</td>
					</tr>
				</table>
			</div>
			<div id="fade" class="black_overlay"></div>
		</div>
	</body>

</html>
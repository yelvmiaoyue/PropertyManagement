<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>收费管理</title>
		<script type="text/javascript">
			var billSearchData = {
				id: 0,
				type: -1,
				status: -1
			};
			var billSearchPageNum= {
					pageNum: "1"
				};

			function billSearch() {
				billSearchPageNum = {
					pageNum: "1"
				};
				billSearchData = {
					id: $("#id").val(),
					type: $("#type").val(),
					status: $("#status").val()
				};
				billSearchTurn();
			}

			function billSearchTurn() {
				$.ajax({
					url: "billManagementSearch",
					async: false,
					type: "POST",
					contentType: "application/json",
					data: JSON.stringify({
						data: billSearchPageNum,
						bill: billSearchData
					}),
					success: function(data) {
						loseSession(data);
						showBillManagement(data);
					}
				});
			}
		</script>
	</head>

	<body>
		<div class="admin-biaogelist">
			<div class="listbiaoti am-cf">
				<ul>收费管理</ul>
			</div>
			<form class="am-form am-g">
				<table style="font-size: 1.6rem;">
					<tbody>
						<tr>
							<td width="10%">
								<input type="button" value="新增" id="deleteMany" onclick="showValidCode()" />
							</td>
							<td width="3%">流水号:</td>
							<td width="15%">
								<input type="text" id="id" style="width:150px" />
							</td>
							<td width="5%">类型:</td>
							<td width="15%">
								<select id="type" style="width: 150px;">
								</select>
							</td>
							<td width="5%">状态:</td>
							<td width="15%">
								<select id="status" style="width: 150px;">
								</select>
							</td>
							<td width="10%">
								<input type="button" value="搜索" onclick="billSearch()" />
							</td>
						</tr>
					</tbody>
				</table>
				<br /><br />
				<table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover">
					<thead>
						<tr class="am-success">
							<th width="15%">流水号</th>
							<th width="20%">地址</th>
							<th width="15%">类型</th>
							<th width="15%">费用</th>
							<th width="20%">时间</th>
							<th width="15%">状态</th>
						</tr>
					</thead>
					<tbody id="tableBody">
					</tbody>
				</table>

				<!-- 分页-->
				<ul class="am-pagination am-fr">
					<li id="pageUp" class="am-disabled">
						<a href="javascript:void(0)" onclick="{var temp=Number($('#pageNum').val())-1;billSearchPageNum={pageNum:temp};billSearchTurn();}">上一页</a>
					</li>
					<li id="pageDown" class="">
						<a href="javascript:void(0)" onclick="{var temp=Number($('#pageNum').val())+1;billSearchPageNum={pageNum:temp};billSearchTurn();}">下一页</a>
					</li>
					<li class="am-disabled">
						<a href="javascript:void(0)" id="currentPage"></a>
					</li>
				</ul>
				<hr />
			</form>
			<input type="hidden" id="pageNum" value="" />
		</div>
		<!--弹出层-->
		<div id="light" class="white_content">
			<span>栋号：<input type="text" id="newBuilding" maxlength="4" width="60px" /></span><br />
			<span>室号：<input type="text" id="newRoom" maxlength="3" width="60px" /></span><br />
			<span>费用：<input type="text" id="newCost" width="60px" /></span><br />
			<span>类型：<select id="newType"></select></span><br /><br /><br />
			<table style="margin:0 auto;" width="200px">
				<tr>
					<td width="100px">
						<input type="button" value="确定" onclick="addBill()" />
					</td>
					<td width="100px">
						<input type="button" value="取消" onclick="hideValidCode()" />
					</td>
				</tr>
			</table>
		</div>
		<div id="fade" class="black_overlay"></div>
	</body>

</html>
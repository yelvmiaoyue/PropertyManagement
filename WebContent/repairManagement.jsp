<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>报修管理</title>
		<script>
			var repairSearchData = {
				id: 0,
				building: 0,
				room: 0,
				status: -1
			};
			var repairSearchPageNum;

			function repairSearch() {
				repairSearchPageNum = {
					pageNum: "1"
				};
				repairSearchData = {
					id: $("#id").val(),
					building: $("#building").val(),
					room: $("#room").val(),
					status: $("#status").val()
				};
				repairSearchTurn();
			}

			function repairSearchTurn() {
				$.ajax({
					url: "repairSearch",
					async: false,
					type: "POST",
					contentType: "application/json",
					data: JSON.stringify({
						data: repairSearchPageNum,
						record: repairSearchData
					}),
					success: function(data) {
						loseSession(data);
						showRepairRecord(data, 2);
					}
				});
			}
		</script>
	</head>

	<body>
		<div class="admin-biaogelist">
			<div class="listbiaoti am-cf">
				<ul>报修管理</ul>
			</div>
			<form class="am-form am-g">
				<table style="margin:0 auto;font-size: 1.6rem;">
					<tbody>
						<tr>
							<td width="5%">流水号:</td>
							<td width="15%">
								<input type="text" id="id" style="width:150px" />
							</td>
							<td width="5%">栋号:</td>
							<td width="15%">
								<input type="text" id="building" style="width:150px" />
							</td>
							<td width="5%">室号:</td>
							<td width="15%">
								<input type="text" id="room" style="width:150px" />
							</td>
							<td width="5%">类型:</td>
							<td width="15%">
								<select id="status"></select>
							</td>
							<td width="10%">
								<input type="button" value="搜索" onclick="repairSearch()" />
							</td>
						</tr>
					</tbody>
				</table>
				<br /><br />
				<table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover">
					<thead>
						<tr class="am-success">
							<th width="10%">流水号</th>
							<th width="10%">地址</th>
							<th width="10%">维修项目</th>
							<th width="25%">内容</th>
							<th width="10%">联系电话</th>
							<th width="15%">报修时间</th>
							<th width="10%">状态</th>
							<th width="10%">操作</th>
						</tr>
					</thead>
					<tbody id="tableBody">
					</tbody>
				</table>

				<!-- 分页-->
				<ul class="am-pagination am-fr">
					<li id="pageUp" class="am-disabled">
						<a href="javascript:void(0)" onclick="{var temp=Number($('#pageNum').val())-1;repairSearchPageNum={pageNum:temp};repairSearchTurn();}">上一页</a>
					</li>
					<li id="pageDown" class="">
						<a href="javascript:void(0)" onclick="{var temp=Number($('#pageNum').val())+1;repairSearchPageNum={pageNum:temp};repairSearchTurn();}">下一页</a>
					</li>
					<li class="am-disabled">
						<a href="javascript:void(0)" id="currentPage"></a>
					</li>
				</ul>
				<hr />
			</form>
			<input type="hidden" id="pageNum" value="" />
		</div>
	</body>

</html>
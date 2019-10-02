<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>车位管理</title>
		<script>
			var carBtn;
			var carSearchData = {
				carNumber: ''
			};
			var carSearchPageNum = {
				pageNum: "1"
			};

			function carSearch() {
				carSearchPageNum = {
					pageNum: "1"
				};
				carSearchData = {
					carNumber: $("#carNumber").val()
				};
				carSearchTurn();
			}

			function carSearchTurn() {
				$.ajax({
					url: "carSearch",
					async: false,
					type: "POST",
					contentType: "application/json",
					data: JSON.stringify({
						data: carSearchPageNum,
						car: carSearchData
					}),
					success: function(data) {
						loseSession(data);
						showCarManagement(data);
					}
				});
			}

			function givePosition() {
				var carNumber = carBtn.parentNode.parentNode.cells[1].innerText;
				$.get("giveCarPostion", {
						position: $("#carPosition").val(),
						carNumber: carNumber
					},
					function(data) {
						if(data == true) {
							alert("分配成功");
							hideValidCode();
							carSearchTurn();
							selCarPosition();
						} else {
							alert("分配失败，服务器异常");
						}
					})
			}
		</script>
	</head>

	<body>
		<div class="admin-biaogelist">
			<div class="listbiaoti am-cf">
				<ul>车位管理</ul>
			</div>
			<form class="am-form am-g">
				<table style="margin:0 auto;font-size: 1.6rem;">
					<tbody>
						<tr>
							<td width="40px">车牌号:</td>
							<td width="170px">
								<input type="text" id="carNumber" style="width:150px" />

								<td width="10%">
									<input type="button" value="搜索" onclick="carSearch()" />
								</td>
						</tr>
					</tbody>
				</table>
				<br /><br />
				<table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover">
					<thead>
						<tr class="am-success">
							<th width="20%">车主住址</th>
							<th width="20%">车牌号</th>
							<th width="20%">车型</th>
							<th width="15%">颜色</th>
							<th width="15%">位置</th>
							<th width="10%">操作</th>
						</tr>
					</thead>
					<tbody id="tableBody">
					</tbody>
				</table>

				<!-- 分页-->
				<ul class="am-pagination am-fr">
					<li id="pageUp" class="am-disabled">
						<a href="javascript:void(0)" onclick="{var temp=Number($('#pageNum').val())-1;carSearchPageNum={pageNum:temp};carSearchTurn();}">上一页</a>
					</li>
					<li id="pageDown" class="">
						<a href="javascript:void(0)" onclick="{var temp=Number($('#pageNum').val())+1;carSearchPageNum={pageNum:temp};carSearchTurn();}">下一页</a>
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
			<span>车位：<select id="carPosition" style="width: 100px;"></select></span>
			<br /><br /><br />
			<table style="margin:0 auto;" width="200px">
				<tr>
					<td width="100px">
						<input type="button" value="确定" onclick="givePosition()" />
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
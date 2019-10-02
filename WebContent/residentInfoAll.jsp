<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>居民信息</title>
		<script>
			var residentSearchData = {
				building: 0,
				room: 0
			};
			var residentSearchPageNum = {
				pageNum: "1"
			};

			function residentSearch() {
				residentSearchPageNum = {
					pageNum: "1"
				};
				residentSearchData = {
					building: $("#building").val(),
					room: $("#room").val()
				};
				residentSearchTurn();
			}

			function residentSearchTurn() {
				$.ajax({
					url: "residentSearch",
					async: false,
					type: "POST",
					contentType: "application/json",
					data: JSON.stringify({
						data: residentSearchPageNum,
						resident: residentSearchData
					}),
					success: function(data) {
						loseSession(data);
						showResidentManagement(data);
					}
				});
			}
		</script>
	</head>

	<body>
		<div class="admin-biaogelist">
			<div class="listbiaoti am-cf">
				<ul>居民信息</ul>
			</div>
			<form class="am-form am-g">
				<table style="margin:0 auto;font-size: 1.6rem;">
					<tbody>
						<tr>
							<td width="5%">栋号:</td>
							<td width="15%">
								<input type="text" id="building" style="width:150px" />
							</td>
							<td width="5%">室号:</td>
							<td width="15%">
								<input type="text" id="room" style="width:150px" />
							</td>
							<td width="10%">
								<input type="button" value="搜索" onclick="residentSearch()" />
							</td>
						</tr>
					</tbody>
				</table>
				<br /><br />
				<table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover">
					<thead>
						<tr class="am-success">
							<th width="10%">栋号</th>
							<th width="10%">室号</th>
							<th width="10%">户主名字</th>
							<th width="25%">联系电话</th>
							<th width="10%">电子邮件</th>
							<th width="10%">操作</th>
						</tr>
					</thead>
					<tbody id="tableBody">
					</tbody>
				</table>

				<!-- 分页-->
				<ul class="am-pagination am-fr">
					<li id="pageUp" class="am-disabled">
						<a href="javascript:void(0)" onclick="{var temp=Number($('#pageNum').val())-1;residentSearchPageNum={pageNum:temp};residentSearchTurn();}">上一页</a>
					</li>
					<li id="pageDown" class="">
						<a href="javascript:void(0)" onclick="{var temp=Number($('#pageNum').val())+1;residentSearchPageNum={pageNum:temp};residentSearchTurn();}">下一页</a>
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
		<div id="light" class="white_content" style="top: 25%;left: 25%;width: 50%;height: 50%; ">
			<table style="margin: 0 auto;">
				<tr>
					<td width="100px">业主地址：</td>
					<td width="350px">
						<div class="you" style="width: 300px;"><input type="text" class="am-input-sm" id="address" disabled="disabled"></div>
					</td>
					<td width="100px">户主姓名：</td>
					<td width="350px">
						<div class="you" style="width: 300px;"><input type="text" class="am-input-sm" id="owner"></div>
					</td>
				</tr>
				<tr>
					<td width="100px">联系电话：</td>
					<td width="350px">
						<div class="you" style="width: 300px;"><input type="text" class="am-input-sm" id="phone"></div>
					</td>
					<td width="100px">电子邮箱：</td>
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
			<table style="margin:0 auto;" width="200px">
				<tr>
					<td width="100px">
						<input type="button" value="确定" onclick="{residentInfo(tempUserId);hideValidCode();residentSearchTurn();}" />
					</td>
					<td width="100px">
						<input type="button" value="取消" onclick="hideValidCode()" />
					</td>
				</tr>
			</table>
		</div>
		<div id="fade" class="black_overlay"></div>

		<input type="hidden" id="memberNum" value="0" />
	</body>

</html>
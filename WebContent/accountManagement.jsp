<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>账户管理</title>
		<script type="text/javascript">
			function selectCheckBox(checkbox) {
				var flag;
				if(checkbox.checked)
					flag = true;
				else flag = false;
				var check = $("[name='check']");
				for(var i = 0; i < check.length; i++) {
					check[i].checked = flag;
				}
			}

			var accountSearchData = {
				id: 0,
				username: "",
				rid: -1
			};
			var accountSearchPageNum = {
				pageNum: "1"
			};

			function accountSearch() {
				accountSearchPageNum = {
					pageNum: "1"
				};
				accountSearchData = {
					id: $("#id").val(),
					username: $("#username").val(),
					rid: $("#rid").val()
				};
				accountSearchTurn();
			}

			function accountSearchTurn() {
				$.ajax({
					url: "accountSearch",
					async: false,
					type: "POST",
					contentType: "application/json",
					data: JSON.stringify({
						data: accountSearchPageNum,
						user: accountSearchData
					}),
					success: function(data) {
						loseSession(data);
						showAccount(data);
					}
				});
			}
		</script>
	</head>

	<body>
		<div class="admin-biaogelist">
			<div class="listbiaoti am-cf">
				<ul>账户管理</ul>
			</div>
			<form class="am-form am-g">
				<table style="font-size: 1.6rem;">
					<tbody>
						<tr>
							<td width="10%">
								<input type="button" value="新增" id="deleteMany" onclick="showValidCode()" />
							</td>
							<td width="3%">id:</td>
							<td width="15%">
								<input type="text" id="id" style="width:150px" />
							</td>
							<td width="5%">用户名:</td>
							<td width="15%">
								<input type="text" id="username" style="width:150px" />
							</td>
							<td width="5%">角色:</td>
							<td width="15%">
								<select id="rid">
									<option value="-1">全部</option>
									<option value="1">管理员</option>
									<option value="2">业主</option>
								</select>
							</td>
							<td width="10%">
								<input type="button" value="搜索" onclick="accountSearch()" />
							</td>
						</tr>
					</tbody>
				</table>
				<br /><br />
				<input type="button" class="am-btn am-btn-danger am-round am-btn-xs" value="删除选中" id="deleteMany" onclick="deleteAccount(this)" /><br />
				<table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover">
					<thead>
						<tr class="am-success">
							<th width="3%"><input id="checkControl" type="checkbox" onclick="selectCheckBox(this)" /></th>
							<th width="12%">id</th>
							<th width="20%">用户名</th>
							<th width="20%">密码</th>
							<th width="15%">角色</th>
							<th width="20%">账户余额</th>
							<th width="10%">操作</th>
						</tr>
					</thead>
					<tbody id="tableBody">
					</tbody>
				</table>

				<!-- 分页-->
				<ul class="am-pagination am-fr">
					<li id="pageUp" class="am-disabled">
						<a href="javascript:void(0)" onclick="{var temp=Number($('#pageNum').val())-1;accountSearchPageNum={pageNum:temp};accountSearchTurn();}">上一页</a>
					</li>
					<li id="pageDown" class="">
						<a href="javascript:void(0)" onclick="{var temp=Number($('#pageNum').val())+1;accountSearchPageNum={pageNum:temp};accountSearchTurn();}">下一页</a>
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
			<span>用户名：<input type="text" id="newUsername" width="60px" /></span><br />
			<span>密码：<input type="text" id="newPassword" width="60px" /></span><br />
			<span>角色：<select id="newRid" onchange="{if(this.value==1){
					$('#newBuilding').attr('disabled',true);$('#newRoom').attr('disabled',true);}
					else{$('#newBuilding').attr('disabled',false);$('#newRoom').attr('disabled',false);}}">
									<option value="2">业主</option>
									<option value="1">管理员</option>
								</select></span><br />
			<span>栋号：<input type="text" id="newBuilding" maxlength="4" width="60px" /></span><br />
			<span>室号：<input type="text" id="newRoom" maxlength="3" width="60px" /></span><br />
			<table style="margin:0 auto;" width="200px">
				<tr>
					<td width="100px">
						<input type="button" value="确定" onclick="{addAccount();}" />
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
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>查改设备</title>
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
		</script>
	</head>

	<body>
		<div class="admin-biaogelist">
			<div class="listbiaoti am-cf">
				<ul>查改设备</ul>
			</div>
			<form class="am-form am-g">
				<input type="button" class="am-btn am-btn-danger am-round am-btn-xs" value="删除选中" id="deleteMany" onclick="deleteDevice(this)" /><br /><br />
				<table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover">
					<thead>
						<tr class="am-success">
							<th class="table-check" width="3%"><input id="checkControl" type="checkbox" onclick="selectCheckBox(this)" /></th>
							<th class="table-id" width="7%">设备号</th>
							<th class="table-id" width="8%">类型</th>
							<th class="table-title" width="18%">厂商</th>
							<th class="table-type" width="24%">位置</th>
							<th class="table-author am-hide-sm-only" width="15%">添加日期</th>
							<th class="table-author am-hide-sm-only" width="15%">最近检修日期</th>
							<th width="10%">操作</th>
						</tr>
					</thead>
					<tbody id="tableBody">
					</tbody>
				</table>

				<!-- 分页-->
				<ul class="am-pagination am-fr">
					<li id="pageUp" class="am-disabled">
						<a href="javascript:void(0)" onclick="{var pageNum=Number($('#pageNum').val())-1;$.get('updateDevice',{pageNum:pageNum},function(data){showDevice(data);deviceList=data;})}">上一页</a>
					</li>
					<li id="pageDown" class="">
						<a href="javascript:void(0)" onclick="{var pageNum=Number($('#pageNum').val())+1;$.get('updateDevice',{pageNum:pageNum},function(data){showDevice(data);deviceList=data;})}">下一页</a>
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
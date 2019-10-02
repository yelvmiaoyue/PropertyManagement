<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>检修记录</title>
	</head>

	<body>
		<div class="admin-biaogelist">
			<div class="listbiaoti am-cf">
				<ul>检修记录</ul>
			</div>
			<form class="am-form am-g">
				<button type="button" class="am-btn am-btn-danger am-round am-btn-xs" id="addFixRecord" onclick="{$.get('addFixRecord.jsp',function(data){$('#neirong').html(data)})}">添加</button><br /><br />
				<table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover">
					<thead>
						<tr class="am-success">
							<th class="table-id" width="20%">设备号</th>
							<th class="table-title" width="20%">设备类别</th>
							<th class="table-type" width="25%">检修时间</th>
							<th class="table-author am-hide-sm-only" width="20%">检修人</th>
							<th class="table-type" width="15%">结果</th>
						</tr>
					</thead>
					<tbody id="tableBody">
					</tbody>
				</table>

				<!-- 分页-->
				<ul class="am-pagination am-fr">
					<li id="pageUp" class="am-disabled">
						<a href="javascript:void(0)" onclick="{var pageNum=Number($('#pageNum').val())-1;$.get('fixRecord',{pageNum:pageNum},function(data){showFixRecord(data);})}">上一页</a>
					</li>
					<li id="pageDown" class="">
						<a href="javascript:void(0)" onclick="{var pageNum=Number($('#pageNum').val())+1;$.get('fixRecord',{pageNum:pageNum},function(data){showFixRecord(data);})}">下一页</a>
					</li>
					<li class="am-disabled">
						<a href="javascript:void(0)" id="currentPage"></a>
					</li>
				</ul>
				<hr />
			</form>
		</div>
		<input type="hidden" id="pageNum" value="" />
	</body>

</html>
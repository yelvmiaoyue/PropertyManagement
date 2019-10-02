<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>报修记录</title>
		<style>
			table {
				table-layout: fixed;
			}
			
			td {
				white-space: nowrap;
				overflow: hidden;
				text-overflow: ellipsis;
			}
		</style>
	</head>

	<body>
		<div class="admin-biaogelist">
			<div class="listbiaoti am-cf">
				<ul>报修记录</ul>
			</div>
			<form class="am-form am-g">
				<table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover">
					<thead>
						<tr class="am-success">
							<th width="15%">流水号</th>
							<th width="15%">维修项目</th>
							<th width="25%">内容</th>
							<th width="25%">联系电话</th>
							<th width="15%">报修时间</th>
							<th width="15%">状态</th>
						</tr>
					</thead>
					<tbody id="tableBody">
					</tbody>
				</table>

				<!-- 分页-->
				<ul class="am-pagination am-fr">
					<li id="pageUp" class="am-disabled">
						<a href="javascript:void(0)" onclick="{var pageNum=Number($('#pageNum').val())-1;$.get('repairRecord',{pageNum:pageNum,userId:userId},function(data){showRepairRecord(data,1);})}">上一页</a>
					</li>
					<li id="pageDown" class="">
						<a href="javascript:void(0)" onclick="{var pageNum=Number($('#pageNum').val())+1;$.get('repairRecord',{pageNum:pageNum,userId:userId},function(data){showRepairRecord(data,1);})}">下一页</a>
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
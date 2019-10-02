<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>政策公告</title>
	</head>

	<body>
		<div class="admin-biaogelist">
			<div class="listbiaoti am-cf">
				<ul>政策公告</ul>
			</div>
			<form class="am-form am-g">
				<table id="statementTable" width="100%" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover">
				</table>

				<!--做个分页-->
				<ul class="am-pagination am-fr">
					<li id="pageUp" class="am-disabled">
						<a href="javascript:void(0)" onclick="{var pageNum=Number($('#pageNum').val())-1;$.get('statements',{pageNum:pageNum},function(data){showStatement(data);statementList=data})}">上一页</a>
					</li>
					<li id="pageDown" class="">
						<a href="javascript:void(0)" onclick="{var pageNum=Number($('#pageNum').val())+1;$.get('statements',{pageNum:pageNum},function(data){showStatement(data);statementList=data})}">下一页</a>
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
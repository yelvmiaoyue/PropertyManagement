//公告当前页面列表
var statementList;
//设备当前页面列表
var deviceList;
//记录登录信息
var userId;
var userPassword;
var userRid;
var userBuilding;
var userRoom;
var repairStatus = ["待受理", "已受理", "已完工"];
var btnValue = ["确认受理", "确认完工", "无"];
var billType = ["电费", "水费", "燃气费", "车位费", "物业费"];
var billStatus = ["待缴费", "已缴清"];
var tempUserId;
var upd = [];
var ins = [];
/**
 * 退出系统
 */
function out() {
	var flag = confirm("确认退出吗");
	if(flag) {
		$(window).attr("location", "logOut");
	}
}

/**
 * 	发送ajax请求时判断是否session还有登录状态
 */
function loseSession(data) {
	if(data == 'loseSession') {
		$(window).attr("location", "login");
		return;
	}
}

/**
 * 切换功能页面
 */
function switchPage(link) {
	//小区概述
	if(link == "briefing") {
		$("#neirong").html("<iframe src='briefing.jsp' height='888px' width='1710px'></iframe>");
		return;
	}
	//联系我们
	if(link == "contactus") {
		$("#neirong").html("<iframe src='contactus.jsp' height='888px' width='1710px'></iframe>");
		return;
	}
	//获取页面
	$.ajax({
		url: link + "T",
		async: false,
		success: function(data) {
			loseSession(data);
			$("#neirong").html(data)
		}
	});
	//需要另外加载数据的页面
	if(link == "statements") {
		$.get(link, {
			pageNum: "1"
		}, function(data) {
			showStatement(data);
			statementList = data;
		})
	} else if(link == "fixRecord") {
		$.get(link, {
			pageNum: "1"
		}, function(data) {
			showFixRecord(data)
		})
	} else if(link == "updateDevice") {
		$.get(link, {
			pageNum: "1"
		}, function(data) {
			showDevice(data);
			deviceList = data;
		})
	} else if(link == "carRegister") {
		$.get(link, {
			userId: userId
		}, function(data) {
			showCar(data);
		})
	} else if(link == "residentInfo") {
		$.get(link, {
			id: userId
		}, function(data) {
			showResidentInfo(data);
		})
	} else if(link == "repairRecord") {
		$.get(link, {
			pageNum: "1",
			userId: userId
		}, function(data) {
			showRepairRecord(data, 1);
		})
	} else if(link == "repair") {
		$("#address").val(userBuilding + "栋" + userRoom + "室");
	} else if(link == "billSearch") {
		$.get(link, {
			pageNum: "1",
			building: userBuilding,
			room: userRoom
		}, function(data) {
			showbill(data);
		})
	} else if(link == "repairManagement") {
		$.get(link, {
			pageNum: "1"
		}, function(data) {
			showRepairRecord(data, 2);
		})
	} else if(link == "accountManagement") {
		$.get(link, {
			pageNum: "1"
		}, function(data) {
			showAccount(data);
		})
	} else if(link == "billManagement") {
		$.get(link, {
			pageNum: "1"
		}, function(data) {
			showBillManagement(data);
		})
	} else if(link == "carManagement") {
		$.get(link, {
			pageNum: "1"
		}, function(data) {
			showCarManagement(data);
		})
	} else if(link == "residentInfoAll") {
		$.get(link, {
			pageNum: "1"
		}, function(data) {
			showResidentManagement(data);
		})
	}

}

/**
 * 	控制翻页按钮
 */
function pageCheck(data) {
	if(data.pageNum >= data.total) {
		$("#pageDown").addClass("am-disabled");
	} else {
		$("#pageDown").removeClass("am-disabled");
	}
	if(data.pageNum == 1) {
		$("#pageUp").addClass("am-disabled");
	} else {
		$("#pageUp").removeClass("am-disabled");
	}
}

/**
 * 	显示公告列表
 */
function showStatement(data) {
	$("#pageNum").val(data.pageNum);
	var rs = "";
	for(var i = 0; i < data.statement.length; i++) {
		rs += "<tr><td><a href='javascript:" + "statementContent(" + "\"" + data.statement[i].title + "\"" + ")'>" + data.statement[i].title + "</a></td></tr>";
	}
	$("#statementTable").html(rs);
	$("#currentPage").text("当前第" + data.pageNum + "/" + data.total + "页");
	pageCheck(data);
}

/**
 * 显示公告详情
 */
function statementContent(title) {
	$.ajax({
		url: "statementContentT",
		async: false,
		success: function(data) {
			loseSession(data);
			$("#neirong").html(data)
		}
	});
	$.get("showContent", {
		title: title
	}, function(data) {
		$("h1").html(data.title);
		$("#content").html(data.content);
	})
}

/**
 * 新增公告
 */
function addStatement() {
	if($("#title").val() == "" || $("#content").val() == "") {
		alert("请输入标题和内容！");
		return;
	}
	$.post("addStatement", {
		title: $("#title").val(),
		content: $("#content").val()
	}, function(data) {
		loseSession(data);
		if(data == true) {
			alert("发布成功");
			$("#title").val("");
			$("#content").val("");
		} else {
			alert("发布失败，请修改标题，或稍后再试");
		}
	})
}

/**
 * 返回公告列表
 */
function returnToStatement() {
	$.ajax({
		url: "statementsT",
		async: false,
		success: function(data) {
			loseSession(data);
			$("#neirong").html(data)
		}
	});
	showStatement(statementList);
}

/**
 * 显示检修记录列表
 */
function showFixRecord(data) {
	$("#pageNum").val(data.pageNum);
	var rs = "";
	for(var i = 0; i < data.fixRecord.length; i++) {
		rs += "<tr><td>" + data.fixRecord[i].deviceId + "</td>";
		rs += "<td>" + data.fixRecord[i].type + "</td>";
		rs += "<td>" + data.fixRecord[i].time + "</td>";
		rs += "<td>" + data.fixRecord[i].man + "</td>";
		if(data.fixRecord[i].result == 1) {
			rs += "<td>通过</td>";
		} else if(data.fixRecord[i].result == 2) {
			rs += "<td>需维修</td>";
		}
		rs += "</tr>";
	}
	$("#tableBody").html(rs);
	$("#currentPage").text("当前第" + data.pageNum + "/" + data.total + "页");
	pageCheck(data);
}

/**
 * 新增检修记录
 */
function addFixRecord() {
	if($("#deviceId").val() == "" || $("#time").val() == "" || $("#man").val() == "" || $("#result").val() == "") {
		alert("请填写完整！");
		return;
	}
	$.post("addFixRecord", {
		deviceId: $("#deviceId").val(),
		time: $("#time").val(),
		man: $("#man").val(),
		result: $("#result").val()
	}, function(data) {
		loseSession(data);
		if(data == true) {
			alert("添加成功");
			$("#deviceId").val("");
			$("#time").val("");
			$("#man").val("");
			$("#result").val("");
		} else {
			alert("添加失败，设备号不存在，或服务器繁忙");
		}
	})
}

/**
 * 新增设备
 */
function addDevice() {
	if($("#id").val() == "" || $("#type").val() == "" || $("#manufacturer").val() == "" || $("#position").val() == "") {
		alert("请填写完整！");
		return;
	}
	var re = /^[0-9]+$/;
	if(!re.test($("#id").val())) {
		alert("请输入纯数字串");
		return;
	}
	$.post("addDevice", {
		id: $("#id").val(),
		type: $("#type").val(),
		manufacturer: $("#manufacturer").val(),
		position: $("#position").val()
	}, function(data) {
		loseSession(data);
		if(data == true) {
			alert("添加成功");
			$("#id").val("");
			$("#type").val("");
			$("#manufacturer").val("");
			$("#position").val("");
		} else {
			alert("添加失败，设备号重复，或服务器繁忙");
		}
	})
}

/**
 * 显示设备列表
 */
function showDevice(data) {
	$("#pageNum").val(data.pageNum);
	var rs = "";
	for(var i = 0; i < data.device.length; i++) {
		rs += "<tr><td><input type='checkbox' name='check'/></td>"
		rs += "<td>" + data.device[i].id + "</td>";
		rs += "<td>" + data.device[i].type + "</td>";
		rs += "<td>" + data.device[i].manufacturer + "</td>";
		rs += "<td>" + data.device[i].position + "</td>";
		rs += "<td>" + data.device[i].addTime + "</td>";
		if(data.device[i].fixTime == null) {
			rs += "<td>暂无</td>"
		} else {
			rs += "<td>" + data.device[i].fixTime + "</td>";
		}
		rs += "<td><input type='button' value='修改' onclick='changeDevice(this)' />"
		rs += "<input type='button' value='删除' onclick='deleteDevice(this)' /></td>"
		rs += "</tr>";
	}
	$("#tableBody").html(rs);
	$("#currentPage").text("当前第" + data.pageNum + "/" + data.total + "页");
	pageCheck(data);
}

/**
 * 修改设备信息
 */
function changeDevice(btn) {
	var tr = btn.parentNode.parentNode;
	var id = tr.cells[1].innerText;
	var type = tr.cells[2].innerText;
	var manufacturer = tr.cells[3].innerText;
	var position = tr.cells[4].innerText;
	var addTime = tr.cells[5].innerText;
	var fixTime = tr.cells[6].innerText;
	$.ajax({
		url: "addDeviceT",
		async: false,
		success: function(data) {
			loseSession(data);
			$("#neirong").html(data);
		}
	});
	$("#id").attr("disabled", "disabled");
	$("#form").attr("action", "javascript:updateDevice()");
	var rs = "";
	rs += '<div class="am-form-group am-cf" ><div class="zuo">添加日期：</div>'
	rs += '<div class="you" style="width: 400px;"><input type="text" class="am-input-sm" id="addTime" disabled="disabled"></div></div>'
	rs += '<div class="am-form-group am-cf" ><div class="zuo">最近检修日期：</div>'
	rs += '<div class="you" style="width: 400px;"><input type="text" class="am-input-sm" id="fixTime" disabled="disabled"></div></div>'
	$("#change").html(rs);
	rs = $("#cancel").html() + '<input type="button" class="am-btn am-btn-success am-radius" value="返回" onclick="returnToDevice()"/>'
	$("#cancel").html(rs);
	$("#id").val(id);
	$("#type").val(type);
	$("#manufacturer").val(manufacturer);
	$("#position").val(position);
	$("#addTime").val(addTime);
	$("#fixTime").val(fixTime);
}

/**
 * 返回设备列表
 */
function returnToDevice() {
	$.ajax({
		url: "updateDeviceT",
		async: false,
		success: function(data) {
			loseSession(data);
			$("#neirong").html(data)
		}
	});
	showDevice(deviceList);
}

/**
 * 更新设备信息
 */
function updateDevice() {
	if($("#type").val() == "" || $("#manufacturer").val() == "" || $("#position").val() == "") {
		alert("请填写完整！");
		return;
	}
	$.post("updateDeviceInfo", {
		id: $("#id").val(),
		type: $("#type").val(),
		manufacturer: $("#manufacturer").val(),
		position: $("#position").val()
	}, function(data) {
		loseSession(data);
		if(data == true) {
			alert("更新成功");
		} else {
			alert("更新失败，服务器繁忙");
		}
	})
	for(var i = 0; i < deviceList.device.length; i++) {
		if(deviceList.device[i].id == $("#id").val()) {
			deviceList.device[i].type = $("#type").val();
			deviceList.device[i].manufacturer = $("#manufacturer").val();
			deviceList.device[i].position = $("#position").val();
		}
	}
	returnToDevice();
}

/**
 * 删除设备信息
 */
function deleteDevice(btn) {
	var flag = window.confirm("确认删除吗");
	if(!flag) {
		return false;
	}
	var test = [];
	if($(btn).attr("id") == "deleteMany") {
		var temp = $("[name='check']");
		for(var i = 0; i < temp.length; i++) {
			if(temp[i].checked) {
				test.push(temp[i].parentNode.parentNode.cells[1].innerText);
			}
		}
	} else {
		test.push(btn.parentNode.parentNode.cells[1].innerText);
	}
	var id = JSON.stringify(test);
	$.ajax({
		url: "deleteDevice",
		async: false,
		data: id,
		type: "POST",
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		success: function(data) {
			loseSession(data);
			if(data == true) {
				alert("删除成功");
				$("#checkControl").attr("checked", false);
			} else {
				alert("删除失败，服务器繁忙");
			}
		}
	});
	$.get("updateDevice", {
		pageNum: $("#pageNum").val()
	}, function(data) {
		showDevice(data);
		deviceList = data;
	})
}

/**
 * 修改用户密码
 */
function changePassword() {
	if($("#old").val() == $("#new1").val()) {
		alert("新密码不能与旧密码相同！");
		return;
	} else if($("#new1").val() != $("#new2").val()) {
		alert("新密码两次输入不相同！");
		return;
	} else if($("#old").val() != userPassword) {
		alert("旧密码不正确！");
		return;
	} else {
		$.get("changePassword", {
			id: userId,
			password: $("#new1").val()
		}, function(data) {
			loseSession(data);
			if(data) alert("修改成功");
			else alert("修改失败，服务器繁忙");
		})
	}

}

/**
 * 显示车辆登记信息
 */
function showCar(data) {
	$("#address").val(userBuilding + "栋" + userRoom + "室");
	$("#position").val(data.position);
	$("#carNumber").val(data.carNumber);
	$("#type").val(data.type);
	$("#color").val(data.color);
	if(data.position != null) {
		$("#submit").val("提交修改");
	} else {
		$("#position").val("申请后由管理员分配");
	}
	if($("#type").val() != "") {
		$("#hasApplied").val("1");
	}
}

/**
 * 新增或修改登记信息
 */
function carRegister() {
	if($("#carNumber").val() == "" || $("#type").val() == "" || $("#color").val() == "") {
		alert("请填写完整！");
		return;
	}
	var url;
	if($("#hasApplied").val() == "0") {
		url = "insCarInfo";
	} else {
		url = "updCarInfo";
	}
	$.post(url, {
		residentId: userId,
		position: $("#position").val(),
		type: $("#type").val(),
		carNumber: $("#carNumber").val(),
		color: $("#color").val()
	}, function(data) {
		loseSession(data);
		if(data == true) {
			alert("提交成功");
		} else {
			alert("提交失败，服务器繁忙");
		}
	})
}

/**
 * 更新业主信息
 */
function residentInfo(id) {
	if($("#owner").val() == "" || $("#phone").val() == "" || $("#email").val() == "") {
		alert("请填写完整！");
		return;
	}
	var re = /^1[0-9]{10}$/;
		if(!re.test($("#phone").val())) {
			alert("请输入正确手机号");
			return;
		}
	var num = $("#memberNum").val();
	var a = {};
	//重置
	ins=[];
	upd=[];
	for(var i = 0; i < num; i++) {
		a = {};
		if($("#" + i).html() != "") {
			if($("#name" + i).val() == "" || $("#idCard" + i).val() == "" || $("#phone" + i).val() == "" || $("#place" + i).val() == "") {
				alert("请填写完整！");
				return;
			}
			a.num=i;
			a.id = $("#memberId" + i).val();
			a.name = $("#name" + i).val();
			a.sex = $("#sex" + i).val();
			var re = /^[0-9]{18}$/;
			if(!re.test($("#idCard" + i).val())) {
				alert("请输入正确的身份证号");
				return;
			}
			a.idCard = $("#idCard" + i).val();
			var re = /^1[0-9]{10}$/;
			if(!re.test($("#phone" + i).val())) {
				alert("请输入正确的手机号");
				return;
			}
			a.phone = $("#phone" + i).val();
			a.workPlace = $("#place" + i).val();
			if(a.id == "") {
				a.pid = id;
				ins.push(a);
			} else {
				upd.push(a);
			}
		}
	}
	submitResidentInfo(id);

}

function submitResidentInfo(id) {
	$.ajax({
		url: "updResidentInfo",
		async: false,
		data: JSON.stringify({
			ins: ins,
			upd: upd,
			resident: {
				id: id,
				owner: $("#owner").val(),
				phone: $("#phone").val(),
				email: $("#email").val()
			}
		}),
		type: "POST",
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		success: function(data) {
			loseSession(data);
			alert("更新成功");
			updateMemberId(data);
		}
	});
}

function updateMemberId(data){
	for(var i=0;i<data.length;i++){
		$("#memberId" + ins[i].num).val(data[i]);
	}
}

/**
 * 删除家庭成员
 */
function deleteMember(id) {
	var flag = confirm("确认要删除成员吗？");
	if(!flag) {
		return;
	}
	var temp = id.charAt(id.length - 1);
	if($("#memberId" + temp).val() == "") {
		$("#" + temp).html("");
	} else {
		$.get("delMember", {
			id: $("#memberId" + temp).val()
		}, function(data) {
			loseSession(data);
			if(data) {
				$("#" + temp).html("");
			} else alert("删除失败，服务器异常");
		})
	}
}

/**
 * 添加家庭成员
 */
function addMember() {
	rs = "";
	var i = Number($("#memberNum").val());
	rs += '<div id=' + i + '><input type="hidden" id="memberId' + i + '"/><table style="margin: 0 auto;">';
	rs += '<tr><td width="80px">姓名：</td><td width="350px"><div class="you" style="width: 300px;"><input type="text" class="am-input-sm" id="name' + i + '"></div></td>';
	rs += '<td width="80px">性别：</td><td width="350px"><div class="you" style="width: 300px;"><select id="sex' + i + '"><option value="0">女</option><option value="1">男</option></select></div></td></tr>';
	rs += '<tr><td width="80px">身份证号：</td><td width="350px"><div class="you" style="width: 300px;"><input type="text" class="am-input-sm" id="idCard' + i + '"></div></td>';
	rs += '<td width="80px">联系电话：</td><td width="350px"><div class="you" style="width: 300px;"><input type="text" class="am-input-sm" id="phone' + i + '"></div></td></tr>';
	rs += '<tr><td width="80px">工作单位：</td><td width="350px"><div class="you" style="width: 300px;"><input type="text" class="am-input-sm" id="place' + i + '"></div></td>';
	rs += '<td width="80px"><a href="javascript:void(0)" onclick="deleteMember(this.id)" id="delete' + i + '">删除该成员</a></td></tr><tr height="40px"></tr></table></div>';
	$("#out").append(rs);
	$("#memberNum").val(i + 1);
}

/**
 * 显示业主信息
 */
function showResidentInfo(data) {
	$("#address").val(data.building + "栋" + data.room + "室");
	$("#owner").val(data.owner);
	$("#phone").val(data.phone);
	$("#email").val(data.email);
	var temp = 0;
	if(data.residentMember != null) {
		var member = data.residentMember;
		var rs = "";
		for(var i = 0; i < member.length; i++) {
			rs += '<div id=' + i + '><input type="hidden" id="memberId' + i + '"/><table style="margin: 0 auto;">';
			rs += '<tr><td width="80px">姓名：</td><td width="350px"><div class="you" style="width: 300px;"><input type="text" class="am-input-sm" id="name' + i + '"></div></td>';
			rs += '<td width="80px">性别：</td><td width="350px"><div class="you" style="width: 300px;"><select id="sex' + i + '"><option value="0">女</option><option value="1">男</option></select></div></td></tr>';
			rs += '<tr><td width="80px">身份证号：</td><td width="350px"><div class="you" style="width: 300px;"><input type="text" class="am-input-sm" id="idCard' + i + '"></div></td>';
			rs += '<td width="80px">联系电话：</td><td width="350px"><div class="you" style="width: 300px;"><input type="text" class="am-input-sm" id="phone' + i + '"></div></td></tr>';
			rs += '<tr><td width="80px">工作单位：</td><td width="350px"><div class="you" style="width: 300px;"><input type="text" class="am-input-sm" id="place' + i + '"></div></td>';
			rs += '<td width="80px"><a href="javascript:void(0)" onclick="deleteMember(this.id)" id="delete' + i + '">删除该成员</a></td></tr><tr height="40px"></tr></table></div>';
		}
		$("#out").html(rs);
		for(var i = 0; i < member.length; i++) {
			$("#name" + i).val(member[i].name);
			$("#idCard" + i).val(member[i].idCard);
			$("#phone" + i).val(member[i].phone);
			$("#place" + i).val(member[i].workPlace);
			$("#sex" + i).val(member[i].sex);
			$("#memberId" + i).val(member[i].id);
			temp = temp + 1;
		}
		$("#memberNum").val(temp);
	}
}

/**
 * 显示报修记录
 */
function showRepairRecord(data, type) {
	$("#pageNum").val(data.pageNum);
	var rs = "";
	if(type == 1) {
		for(var i = 0; i < data.repairRecord.length; i++) {
			rs += "<tr><td>" + data.repairRecord[i].id + "</td>";
			rs += "<td>" + data.repairRecord[i].type + "</td>";
			rs += "<td>" + data.repairRecord[i].content + "</td>";
			rs += "<td>" + data.repairRecord[i].phone + "</td>";
			rs += "<td>" + data.repairRecord[i].timeString + "</td>";
			rs += "<td>" + repairStatus[data.repairRecord[i].status] + "</td>";
			rs += "</tr>";
		}
	} else if(type == 2) {
		for(var i = 0; i < data.repairRecord.length; i++) {
			rs += "<tr><td>" + data.repairRecord[i].id + "</td>";
			rs += "<td>" + data.repairRecord[i].building + "栋" + data.repairRecord[i].room + "室</td>";
			rs += "<td>" + data.repairRecord[i].type + "</td>";
			rs += "<td>" + data.repairRecord[i].content + "</td>";
			rs += "<td>" + data.repairRecord[i].phone + "</td>";
			rs += "<td>" + data.repairRecord[i].timeString + "</td>";
			rs += "<td>" + repairStatus[data.repairRecord[i].status] + "</td>";
			if(data.repairRecord[i].status == 0 || data.repairRecord[i].status == 1) {
				rs += "<td><input type='button' value='" + btnValue[data.repairRecord[i].status] + "' onclick='confirmRepair(this)' /></td>";
			} else if(data.repairRecord[i].status == 2) {
				rs += "<td><input type='button' value='" + btnValue[data.repairRecord[i].status] + "' disabled='disabled' /></td>";
			}
			rs += "</tr>";
		}
		$("#status").empty();
		$("#status").append(new Option("全部", -1));
		for(var i = 0; i < repairStatus.length; i++) {
			$("#status").append(new Option(repairStatus[i], i));
		}
	}
	$("#tableBody").html(rs);
	$("#currentPage").text("当前第" + data.pageNum + "/" + data.total + "页");
	pageCheck(data);

}

function confirmRepair(btn) {
	var flag = confirm("确认操作吗？");
	if(!flag) {
		return;
	}
	var id = btn.parentNode.parentNode.cells[0].innerText;
	if(btn.value == "确认受理") {
		var sta = 1;
	} else if(btn.value == "确认完工") {
		var sta = 2;
	}
	$.get("confirmRepair", {
		id: id,
		status: sta
	}, function(data) {
		loseSession(data);
		if(data == true) {
			alert("处理成功");
			btn.parentNode.parentNode.cells[6].innerText = repairStatus[sta];
			$(btn).val(btnValue[sta]);
			if(sta == 2) {
				$(btn).attr("disabled", "disabled");
			}
		} else {
			alert("处理失败，服务器繁忙");
		}
	})
}

/**
 * 提交报修
 */
function addRepairRecord() {
	if($("#content").val() == "" || $("#phone").val() == "") {
		alert("请填写完整！");
		return;
	}
	var re = /^1[0-9]{10}$/;
	if(!re.test($("#phone").val())) {
		alert("请输入正确的手机号");
		return;
	}
	var type = $("#type1").find("option:selected").text() + "/" + $("#type2").find("option:selected").text();
	$.post("insRepairRecord", {
		residentId: userId,
		building: userBuilding,
		room: userRoom,
		type: type,
		content: $("#content").val(),
		phone: $("#phone").val()
	}, function(data) {
		loseSession(data);
		if(data == true) {
			alert("提交成功");
			$("#content").val("");
			$("#phone").val("");
		} else {
			alert("提交失败，服务器繁忙");
		}
	})
}

/**
 * 显示个人账单
 */
function showbill(data) {
	$("#pageNum").val(data.pageNum);
	var rs = "";
	var bill = data.bill;
	for(var i = 0; i < bill.length; i++) {
		rs += "<tr><td>" + bill[i].id + "</td>";
		rs += "<td>" + billType[bill[i].type] + "</td>";
		rs += "<td>" + bill[i].cost + "</td>";
		rs += "<td>" + bill[i].time + "</td>";
		rs += "<td>" + billStatus[bill[i].status] + "</td>";
		if(bill[i].status == 0) {
			rs += "<td><input type=\"button\" value=\"支付\" onclick = \"showValidCode(this)\" /></td>;"
		} else {
			rs += "<td><input type=\"button\" value=\"无\" disabled=\"disabled\" onclick = \"showValidCode(this)\" /></td>;"
		}
		rs += "</tr>";
	}
	$("#tableBody").html(rs);
	$("#currentPage").text("当前第" + data.pageNum + "/" + data.total + "页");
	pageCheck(data);
}

//记录支付的条目
var source;

/**
 * 显示支付页面
 */
function showValidCode(btn) {
	source = btn;
	$('#light').css('display', 'block');
	$('#fade').css('display', 'block');
	$.get("getMoney", {
		id: userId
	}, function(data) {
		loseSession(data);
		$("#account").html(data + "元");
	})
}

/**
 * 从session读取验证码
 */
function getCode() {
	$.get("getCode", function(data) {
		$("#codeString").val(data);
	})
}

/**
 * 关闭支付页面
 */
function hideValidCode() {
	$('#light').css('display', 'none');
	$('#fade').css('display', 'none');
}

/**
 * 提交支付
 */
function payBill(btn) {
	if($("#validCode").val() != $("#codeString").val()) {
		alert("验证码不正确");
		return;
	}
	var id = btn.parentNode.parentNode.cells[0].innerText;
	var cost = btn.parentNode.parentNode.cells[2].innerText;
	$.post("payBill", {
		id: id,
		cost: cost,
		userId: userId
	}, function(data) {
		loseSession(data);
		if(data == true) {
			alert("支付成功");
			hideValidCode();
			$("#validCode").val("");
			btn.parentNode.parentNode.cells[4].innerText = "已缴清";
			$(btn).val("无");
			$(btn).attr("disabled", "disabled");
			$("#code").attr("src", "validCode?date=" + new Date());
		} else {
			alert("支付失败，服务器繁忙");
		}
	})
}

function showAccount(data) {
	$("#pageNum").val(data.pageNum);
	var rs = "";
	var role = [0, "管理员", "业主"];
	var account = data.account;
	for(var i = 0; i < account.length; i++) {
		if(account[i].rid == 1) {
			rs += "<tr><td><input type='checkbox'  disabled='disabled'/></td>"
		} else if(account[i].rid == 2) {
			rs += "<tr><td><input type='checkbox' name='check'/></td>"
		}
		rs += "<td>" + account[i].id + "</td>";
		rs += "<td>" + account[i].username + "</td>";
		rs += "<td>" + account[i].password + "</td>";
		rs += "<td>" + role[account[i].rid] + "</td>";
		if(account[i].money==null){
			rs += "<td>无</td>";
		}else{
			rs += "<td>" + account[i].money + "</td>";
		}
		if(account[i].rid == 1) {
			rs += "<td><input type=\"button\" value=\"无\" disabled='disabled' /></td>;"
		} else if(account[i].rid == 2) {
			rs += "<td><input type=\"button\" value=\"删除\" onclick = \"deleteAccount(this)\" /></td>;"
		}
		rs += "</tr>";
	}
	$("#tableBody").html(rs);
	$("#currentPage").text("当前第" + data.pageNum + "/" + data.total + "页");
	pageCheck(data);
	$("#role").selectedIndex = -1;
}

function deleteAccount(btn) {
	var flag = window.confirm("确认删除吗");
	if(flag) {
		flag = window.confirm("真的确认删除吗，本操作结果无法逆转");
		if(!flag)
			return false;
	} else {
		return false;
	}
	var test = [];
	if($(btn).attr("id") == "deleteMany") {
		var temp = $("[name='check']");
		for(var i = 0; i < temp.length; i++) {
			if(temp[i].checked) {
				test.push(temp[i].parentNode.parentNode.cells[1].innerText);
			}
		}
	} else {
		test.push(btn.parentNode.parentNode.cells[1].innerText);
	}
	var id = JSON.stringify(test);
	$.ajax({
		url: "deleteAccount",
		async: false,
		data: id,
		type: "POST",
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		success: function(data) {
			loseSession(data);
			if(data == true) {
				alert("删除成功");
				$("#checkControl").attr("checked", false);
			} else {
				alert("删除失败，服务器繁忙");
			}
		}
	});
	accountSearchTurn();
}

function addAccount() {
	if($("#newUsername").val() == "" || $("#newPassword").val() == "" ||
		($("#newRid").val() == 2 && ($("#newBuilding").val() == "" || $("#newRoom").val() == ""))) {
		alert("请填写完整！");
		return;
	}
	if($("#newRid").val() == 2) {
		var re = /^[0-9]+$/;
		if(!(re.test($("#newBuilding").val()) && re.test($("#newRoom").val()))) {
			alert("请输入纯数字串");
			return;
		}
		$.post("addAccount", {
			username: $("#newUsername").val(),
			password: $("#newPassword").val(),
			building: $("#newBuilding").val(),
			room: $("#newRoom").val(),
			rid: $("#newRid").val()
		}, function(data) {
			loseSession(data);
			if(data == true) {
				alert("创建成功");
				hideValidCode();
				accountSearchTurn();
			} else {
				alert("创建失败，用户名重复，或房屋号重复，或服务器繁忙");
			}
		})
	} else {
		$.post("addAccount", {
			username: $("#newUsername").val(),
			password: $("#newPassword").val(),
			rid: $("#newRid").val()
		}, function(data) {
			loseSession(data);
			if(data == true) {
				alert("创建成功");
				hideValidCode();
				accountSearchTurn();
			} else {
				alert("创建失败，用户名重复，或服务器繁忙");
			}
		})
	}
}

function showBillManagement(data) {
	$("#pageNum").val(data.pageNum);
	var rs = "";
	var bill = data.bill;
	for(var i = 0; i < bill.length; i++) {
		rs += "<tr><td>" + bill[i].id + "</td>";
		rs += "<td>" + bill[i].building + "栋" + bill[i].room + "室</td>";
		rs += "<td>" + billType[bill[i].type] + "</td>";
		rs += "<td>" + bill[i].cost + "</td>";
		rs += "<td>" + bill[i].time + "</td>";
		rs += "<td>" + billStatus[bill[i].status] + "</td>";
		rs += "</tr>";
	}
	$("#tableBody").html(rs);
	$("#currentPage").text("当前第" + data.pageNum + "/" + data.total + "页");
	pageCheck(data);
	$("#status").empty();
	$("#type").empty();
	$("#newType").empty();
	$("#status").append(new Option("全部", -1));
	$("#type").append(new Option("全部", -1));
	for(var i = 0; i < billStatus.length; i++) {
		$("#status").append(new Option(billStatus[i], i));
	}
	for(var i = 0; i < billType.length; i++) {
		$("#type").append(new Option(billType[i], i));
		$("#newType").append(new Option(billType[i], i));
	}
}

function addBill() {
	if($("#newBuilding").val() == "" || $("#newRoom").val() == "" || $("#newCost").val() == "") {
		alert("请填写完整！");
		return;
	}
	$.post("addBill", {
		building: $("#newBuilding").val(),
		room: $("#newRoom").val(),
		cost: $("#newCost").val(),
		type: $("#newType").val()
	}, function(data) {
		loseSession(data);
		if(data == true) {
			alert("创建成功");
			hideValidCode();
			billSearchTurn();
		} else {
			alert("创建失败，该房屋没有住户，或服务器繁忙");
		}
	})

}

function showCarManagement(data) {
	$("#pageNum").val(data.pageNum);
	var rs = "";
	var car = data.car;
	for(var i = 0; i < car.length; i++) {
		rs += "<tr><td>" + car[i].building + "栋" + car[i].room + "室</td>";
		rs += "<td>" + car[i].carNumber + "</td>";
		rs += "<td>" + car[i].type + "</td>";
		rs += "<td>" + car[i].color + "</td>";
		if(car[i].position == null || car[i].position == "无") {
			rs += "<td>暂未分配</td>";
			rs += "<td><input type=\"button\" value=\"分配\" onclick='{showValidCode();carBtn=this}' /></td>;"
		} else {
			rs += "<td>" + car[i].position + "</td>";
			rs += "<td><input type=\"button\" value=\"重新分配\" onclick='{showValidCode();carBtn=this}' /></td>;"
		}
		rs += "</tr>";
	}
	$("#tableBody").html(rs);
	$("#currentPage").text("当前第" + data.pageNum + "/" + data.total + "页");
	pageCheck(data);
	selCarPosition();
}

function selCarPosition() {
	$.get("selCarPostion", function(data) {
		$("#carPosition").empty();
		$("#carPosition").append(new Option("无", "无"));
		for(var i = 0; i < data.length; i++) {
			$("#carPosition").append(new Option(data[i].position, data[i].position));
		}
	})
}

function showResidentManagement(data) {
	$("#pageNum").val(data.pageNum);
	var rs = "";
	var resident = data.resident;
	for(var i = 0; i < resident.length; i++) {
		rs += "<tr><td style='display: none;'>" + resident[i].id + "</td>";
		rs += "<td>" + resident[i].building + "</td>";
		rs += "<td>" + resident[i].room + "</td>";
		if(resident[i].owner == null) {
			rs += "<td>暂无</td>"
		} else {
			rs += "<td>" + resident[i].owner + "</td>";
		}
		if(resident[i].phone == null) {
			rs += "<td>暂无</td>"
		} else {
			rs += "<td>" + resident[i].phone + "</td>";
		}
		if(resident[i].email == null) {
			rs += "<td>暂无</td>"
		} else {
			rs += "<td>" + resident[i].email + "</td>";
		}
		rs += "<td><input type=\"button\" value=\"查看详情\" onclick='{showValidCode();showResidentDetail(this);}' /></td>;"
		rs += "</tr>";
	}
	$("#tableBody").html(rs);
	$("#currentPage").text("当前第" + data.pageNum + "/" + data.total + "页");
	pageCheck(data);
}

function showResidentDetail(btn) {
	tempUserId = btn.parentNode.parentNode.cells[0].innerText
	$.get("residentInfo", {
		id: tempUserId
	}, function(data) {
		showResidentInfo(data);
	})
}
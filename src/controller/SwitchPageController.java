package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SwitchPageController {

	@RequestMapping("addDeviceT")
	public String addDeviceT() {
		return "addDevice.jsp";
	}

	@RequestMapping("addFixRecordT")
	public String addFixRecordT() {
		return "addFixRecord.jsp";
	}

	@RequestMapping("addStatementT")
	public String addStatementT() {
		return "addStatement.jsp";
	}

	@RequestMapping("carRegisterT")
	public String carRegisterT() {
		return "carRegister.jsp";
	}

	@RequestMapping("changePasswordT")
	public String changePasswordT() {
		return "changePassword.jsp";
	}

	@RequestMapping("fixRecordT")
	public String fixRecordT() {
		return "fixRecord.jsp";
	}

	@RequestMapping("repairT")
	public String repairT() {
		return "repair.jsp";
	}

	@RequestMapping("repairRecordT")
	public String repairRecordT() {
		return "repairRecord.jsp";
	}

	@RequestMapping("residentInfoT")
	public String residentInfoT() {
		return "residentInfo.jsp";
	}

	@RequestMapping("statementContentT")
	public String statementContentT() {
		return "statementContent.jsp";
	}

	@RequestMapping("statementsT")
	public String statementsT() {
		return "statements.jsp";
	}

	@RequestMapping("updateDeviceT")
	public String updateDeviceT() {
		return "updateDevice.jsp";
	}

	@RequestMapping("billSearchT")
	public String billSearchT() {
		return "billSearch.jsp";
	}

	@RequestMapping("accountManagementT")
	public String accountManagementT() {
		return "accountManagement.jsp";
	}

	@RequestMapping("repairManagementT")
	public String repairManagementT() {
		return "repairManagement.jsp";
	}

	@RequestMapping("billManagementT")
	public String billManagementT() {
		return "billManagement.jsp";
	}

	@RequestMapping("carManagementT")
	public String carManagementT() {
		return "carManagement.jsp";
	}

	@RequestMapping("residentInfoAllT")
	public String residentInfoAllT() {
		return "residentInfoAll.jsp";
	}
}

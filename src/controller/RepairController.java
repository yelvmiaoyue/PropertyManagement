package controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.RepairRecord;
import pojo.SearchCondition;
import pojo.SearchData;
import service.RepairService;

@Controller
public class RepairController {
	@Resource
	private RepairService repairServiceImpl;

	@RequestMapping("repairRecord")
	@ResponseBody
	public SearchData repairRecord(SearchData data, int userId) {
		return repairServiceImpl.selRepairRecord(data, userId);
	}

	@RequestMapping("insRepairRecord")
	@ResponseBody
	public boolean insRepairRecord(RepairRecord record) {
		return repairServiceImpl.insRepairRecord(record);
	}

	@RequestMapping("repairManagement")
	@ResponseBody
	public SearchData repairManagement(SearchData data) {
		return repairServiceImpl.selRepairManagement(data);
	}

	@RequestMapping("confirmRepair")
	@ResponseBody
	public boolean confirmRepair(RepairRecord record) {
		return repairServiceImpl.updRepairRecord(record);
	}

	@RequestMapping("repairSearch")
	@ResponseBody
	public SearchData repairSearch(@RequestBody SearchCondition con) {
		return repairServiceImpl.selRepairSearch(con);
	}
}

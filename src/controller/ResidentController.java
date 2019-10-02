package controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.Resident;
import pojo.ResidentAndMember;
import pojo.SearchCondition;
import pojo.SearchData;
import service.ResidentService;

@Controller
public class ResidentController {
	@Resource
	private ResidentService residentServiceImpl;

	@RequestMapping("residentInfo")
	@ResponseBody
	public Resident selResidentInfo(int id) {
		return residentServiceImpl.selResidentInfo(id);
	}

	@RequestMapping("delMember")
	@ResponseBody
	public boolean delMember(int id) {
		return residentServiceImpl.delMember(id);
	}

	@RequestMapping("updResidentInfo")
	@ResponseBody
	public List<Integer> updResidentInfo(@RequestBody ResidentAndMember x) {
		List<Integer> rs = residentServiceImpl.updResidentInfo(x);
		return rs;
	}

	@RequestMapping("residentInfoAll")
	@ResponseBody
	public SearchData residentInfoAll(SearchData data) {
		return residentServiceImpl.selResidentManagement(data);
	}

	@RequestMapping("residentSearch")
	@ResponseBody
	public SearchData residentSearch(@RequestBody SearchCondition con) {
		return residentServiceImpl.selResidentSearch(con);
	}
}

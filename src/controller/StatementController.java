package controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.SearchData;
import pojo.Statement;
import service.StatementService;

@Controller
public class StatementController {
	@Resource
	private StatementService statementServiceImpl;

	@RequestMapping("statements")
	@ResponseBody
	public SearchData showStatements(SearchData data) {
		SearchData rs = statementServiceImpl.selAllTitles(data);
		return rs;
	}

	@RequestMapping("showContent")
	@ResponseBody
	public Statement showContent(String title) {
		Statement rs = statementServiceImpl.selContent(title);
		return rs;
	}

	@RequestMapping("addStatement")
	@ResponseBody
	public boolean addStatement(Statement stat) {
		stat.setContent(stat.getContent().replaceAll("\n|\r\n", "<br/>"));
		boolean rs = statementServiceImpl.insStatement(stat);
		return rs;
	}
}

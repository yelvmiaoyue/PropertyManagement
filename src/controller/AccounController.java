package controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.Account;
import pojo.SearchCondition;
import pojo.SearchData;
import service.AccountService;

@Controller
public class AccounController {
	@Resource
	private AccountService accountServiceImpl;

	@RequestMapping("accountManagement")
	@ResponseBody
	public SearchData billSearch(SearchData data) {
		return accountServiceImpl.selAccountManagement(data);
	}

	@RequestMapping("accountSearch")
	@ResponseBody
	public SearchData accountSearch(@RequestBody SearchCondition con) {
		return accountServiceImpl.selAccountSearch(con);
	}

	@RequestMapping("deleteAccount")
	@ResponseBody
	public boolean deleteAccount(@RequestBody ArrayList<Integer> id) {
		return accountServiceImpl.deleteAccount(id);
	}

	@RequestMapping("addAccount")
	@ResponseBody
	public boolean addAccount(Account account) {
		return accountServiceImpl.insAccount(account);
	}
}

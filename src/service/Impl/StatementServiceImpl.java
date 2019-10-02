package service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mapper.StatementMapper;
import pojo.SearchData;
import pojo.Statement;
import service.StatementService;

@Service
public class StatementServiceImpl implements StatementService {

	@Resource
	private StatementMapper statementMappper;

	@Override
	public SearchData selAllTitles(SearchData data) {
		data.setPageStart(data.getPageSize() * (data.getPageNum() - 1));
		data.setStatement(statementMappper.selAllTitles(data));
		int total = statementMappper.selTotal();
		int temp = total % data.getPageSize();
		if (temp == 0) {
			data.setTotal(total / data.getPageSize());
		} else {
			data.setTotal(total / data.getPageSize() + 1);
		}
		return data;
	}

	@Override
	public boolean insStatement(Statement stat) {
		int check = statementMappper.selTitleCheck(stat.getTitle());
		if (check == 0)
			return statementMappper.insStatement(stat);
		else
			return false;
	}

	@Override
	public Statement selContent(String title) {
		return statementMappper.selContent(title);
	}

}

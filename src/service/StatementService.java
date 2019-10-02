package service;

import pojo.SearchData;
import pojo.Statement;

public interface StatementService {
	SearchData selAllTitles(SearchData data);

	Statement selContent(String title);

	boolean insStatement(Statement stat);
}

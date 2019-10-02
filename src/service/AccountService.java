package service;

import java.util.List;

import pojo.Account;
import pojo.SearchCondition;
import pojo.SearchData;

public interface AccountService {
	SearchData selAccountManagement(SearchData data);

	SearchData selAccountSearch(SearchCondition con);

	boolean deleteAccount(List<Integer> id);

	boolean insAccount(Account account);
}

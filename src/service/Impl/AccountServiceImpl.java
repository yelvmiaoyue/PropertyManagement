package service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mapper.AccountMapper;
import mapper.BillMapper;
import pojo.Account;
import pojo.HouseStatus;
import pojo.SearchCondition;
import pojo.SearchData;
import pojo.User;
import service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Resource
	private AccountMapper accountMapper;

	@Resource
	private BillMapper billMapper;

	@Override
	public SearchData selAccountManagement(SearchData data) {
		data.setPageStart(data.getPageSize() * (data.getPageNum() - 1));
		User user = new User();
		user.setUsername("");
		user.setRid(-1);
		List<Account> temp = accountMapper.selAccountSearch(user, data);
		for (int i = 0; i < temp.size(); i++) {
			temp.get(i).setMoney(billMapper.selMoney(temp.get(i).getId()));
		}
		data.setAccount(temp);
		int total = accountMapper.selAccountAll(user);
		int temp1 = total % data.getPageSize();
		if (temp1 == 0) {
			data.setTotal(total / data.getPageSize());
		} else {
			data.setTotal(total / data.getPageSize() + 1);
		}
		return data;
	}

	@Override
	public SearchData selAccountSearch(SearchCondition con) {
		SearchData data = con.getData();
		User user = con.getUser();
		data.setPageStart(data.getPageSize() * (data.getPageNum() - 1));
		List<Account> temp = accountMapper.selAccountSearch(user, data);
		for (int i = 0; i < temp.size(); i++) {
			temp.get(i).setMoney(billMapper.selMoney(temp.get(i).getId()));
		}
		data.setAccount(temp);
		int total = accountMapper.selAccountAll(user);
		int temp1 = total % data.getPageSize();
		if (temp1 == 0) {
			data.setTotal(total / data.getPageSize());
		} else {
			data.setTotal(total / data.getPageSize() + 1);
		}
		return data;
	}

	@Override
	public boolean deleteAccount(List<Integer> id) {
		Account account;
		for (int i = 0; i < id.size(); i++) {
			account = accountMapper.selResident(id.get(i));
			accountMapper.delAccount(id.get(i));
			accountMapper.delUser(id.get(i));
			accountMapper.delResident(id.get(i));
			accountMapper.delResidentMember(id.get(i));
			if(account!=null) {
				accountMapper.updHouse(account,0);
			}
		}
		return true;
	}

	@Override
	public boolean insAccount(Account account) {
		//判断用户名重复
		Integer temp = accountMapper.selUserId(account);
		if (temp != null)
			return false;
		//判断房屋重复
		if(account.getRid()==2) {
			HouseStatus house = accountMapper.selHouse(account);
			if (house == null || house.getTaken() == 1) {
				return false;
			}else {
				boolean rs=accountMapper.updHouse(account,1);
				if(!rs)
					return false;
			}
		}
		boolean rs1 = accountMapper.insUser(account);
		if (!rs1) {
			throw new RuntimeException("创建用户失败");
		}
		if(account.getRid()==2) {
			account.setId(accountMapper.selUserId(account));
			boolean rs2, rs3;
			rs2 = accountMapper.insAccount(account);
			rs3 = accountMapper.insResident(account);
			if (!(rs3 && rs2)) {
				throw new RuntimeException("创建账户失败");
			}
		}
		return true;
	}

}

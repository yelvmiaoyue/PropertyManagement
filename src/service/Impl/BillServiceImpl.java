package service.Impl;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mapper.BillMapper;
import mapper.ResidentMapper;
import pojo.Bill;
import pojo.Resident;
import pojo.SearchCondition;
import pojo.SearchData;
import service.BillService;

@Service
public class BillServiceImpl implements BillService {
	@Resource
	private BillMapper billMapper;
	@Resource
	private ResidentMapper residentMapper;

	@Override
	public SearchData selBill(int building, int room, SearchData data) {
		data.setPageStart(data.getPageSize() * (data.getPageNum() - 1));
		data.setBill(billMapper.selBill(building, room, data));
		int total = billMapper.selTotal(building, room);
		int temp = total % data.getPageSize();
		if (temp == 0) {
			data.setTotal(total / data.getPageSize());
		} else {
			data.setTotal(total / data.getPageSize() + 1);
		}
		return data;
	}

	@Override
	public BigDecimal selMoney(int id) {
		return billMapper.selMoney(id);
	}

	@Override
	public boolean updBill(int id, int userId, BigDecimal cost) {
		boolean flag1 = billMapper.updBill(id);
		if (!flag1)
			return false;
		boolean flag2 = billMapper.updMoney(userId, cost);
		if (!flag2)
			return false;
		return true;
	}

	@Override
	public SearchData selBillManagement(SearchData data) {
		data.setPageStart(data.getPageSize() * (data.getPageNum() - 1));
		Bill bill = new Bill();
		bill.setType(-1);
		bill.setStatus(-1);
		data.setBill(billMapper.selBillSearch(bill, data));
		int total = billMapper.selTotalAll(bill);
		int temp = total % data.getPageSize();
		if (temp == 0) {
			data.setTotal(total / data.getPageSize());
		} else {
			data.setTotal(total / data.getPageSize() + 1);
		}
		return data;
	}

	@Override
	public SearchData selBillSearch(SearchCondition con) {
		SearchData data = con.getData();
		Bill bill = con.getBill();
		data.setPageStart(data.getPageSize() * (data.getPageNum() - 1));
		data.setBill(billMapper.selBillSearch(bill, data));
		int total = billMapper.selTotalAll(bill);
		int temp1 = total % data.getPageSize();
		if (temp1 == 0) {
			data.setTotal(total / data.getPageSize());
		} else {
			data.setTotal(total / data.getPageSize() + 1);
		}
		return data;
	}

	@Override
	public boolean insBill(Bill bill) {
		Resident check = residentMapper.selResidentCheck(bill);
		if (check == null) {
			return false;
		}
		bill.setTime(new Date(new GregorianCalendar().getTimeInMillis()));
		return billMapper.insBill(bill);
	}

}

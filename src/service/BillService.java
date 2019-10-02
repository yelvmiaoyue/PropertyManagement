package service;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Param;

import pojo.Bill;
import pojo.SearchCondition;
import pojo.SearchData;

public interface BillService {
	SearchData selBill(int building, int room, @Param("data") SearchData data);

	BigDecimal selMoney(int id);

	boolean updBill(int id, int userId, BigDecimal cost);

	SearchData selBillManagement(SearchData data);

	SearchData selBillSearch(SearchCondition con);

	boolean insBill(Bill bill);
}

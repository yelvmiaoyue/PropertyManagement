package mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pojo.Bill;
import pojo.SearchData;

public interface BillMapper {
	@Select("select * from bill where building=#{0} and room=#{1} order by time desc limit #{data.pageStart},#{data.pageSize}")
	List<Bill> selBill(int building, int room, @Param("data") SearchData data);

	@Select("select count(id) from bill where building=#{0} and room=#{1}")
	int selTotal(int building, int room);

	@Select("select money from account where id=#{0}")
	BigDecimal selMoney(int id);

	@Update("update bill set status=1 where id=#{0}")
	boolean updBill(int id);

	@Update("update account set money=money-#{1} where id=#{0}")
	boolean updMoney(int id, BigDecimal cost);

	List<Bill> selBillSearch(@Param("bill") Bill bill, @Param("data") SearchData data);

	int selTotalAll(@Param("bill") Bill bill);

	@Insert("insert into bill values(default,#{building},#{room},#{type},#{cost},#{time},0)")
	boolean insBill(Bill bill);
}

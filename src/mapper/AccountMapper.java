package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pojo.Account;
import pojo.HouseStatus;
import pojo.SearchData;
import pojo.User;

public interface AccountMapper {
	List<Account> selAccountSearch(@Param("user") User user, @Param("data") SearchData data);

	int selAccountAll(@Param("user") User user);

	@Delete("delete from user where id=#{0}")
	boolean delUser(int id);

	@Delete("delete from account where id=#{0}")
	boolean delAccount(int id);

	@Delete("delete from resident where id=#{0}")
	boolean delResident(int id);

	@Delete("delete from residentMember where pid=#{0}")
	boolean delResidentMember(int id);

	@Insert("insert into user values(default,#{username},#{password},#{rid})")
	boolean insUser(Account account);

	@Select("select id from user where username=#{username}")
	Integer selUserId(Account account);

	@Insert("insert into account values(#{id},#{money})")
	boolean insAccount(Account account);

	@Insert("insert into resident(id,building,room) values(#{id},#{building},#{room})")
	boolean insResident(Account account);

	@Select("select * from buildingAndRoom where building=#{building} and room=#{room}")
	HouseStatus selHouse(Account account);
	
	@Update("update buildingAndRoom set taken=#{id} where building=#{account.building} and room=#{account.room}")
	boolean updHouse(@Param("account") Account account,@Param("id") int id);
	
	@Select("select * from resident where id=#{0}")
	Account selResident(int id);
}

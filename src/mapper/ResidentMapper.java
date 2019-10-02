package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pojo.Bill;
import pojo.Resident;
import pojo.ResidentMember;
import pojo.SearchData;

public interface ResidentMapper {
	@Select("select * from resident where id=#{id}")
	Resident selResidentInfo(int id);

	@Update("update resident set owner=#{owner},phone=#{phone},email=#{email} where id=#{id}")
	boolean updResidentInfo(Resident resident);

	@Select("select * from residentMember where pid=#{pid}")
	List<ResidentMember> selResidentMember(int pid);

	@Delete("delete from residentMember where id=#{id}")
	boolean delMember(int id);

	@Insert("insert into residentMember values(default,#{pid},#{name},#{sex},#{idCard},#{phone},#{workPlace})")
	boolean insMember(ResidentMember member);
	
	@Select("select id from residentMember where pid=#{pid} and name=#{name} and sex=#{sex} and idCard=#{idCard} and phone=#{phone} and workPlace=#{workPlace}")
	int selMember(ResidentMember member);

	@Update("update residentMember set name=#{name},sex=#{sex},idCard=#{idCard},phone=#{phone},workPlace=#{workPlace} where id=#{id}")
	boolean updMember(ResidentMember member);

	@Select("select * from resident where building=#{building} and room=#{room}")
	Resident selResidentCheck(Bill bill);

	List<Resident> selResidentSearch(@Param("resident") Resident resident, @Param("data") SearchData data);

	int selTotalAll(@Param("resident") Resident resident);
}

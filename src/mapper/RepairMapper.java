package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pojo.RepairRecord;
import pojo.SearchData;

public interface RepairMapper {
	@Select("select * from repairRecord where residentId=#{id} order by id desc limit #{data.pageStart},#{data.pageSize}")
	List<RepairRecord> selRepairRecord(@Param("data") SearchData data, @Param("id") int id);

	@Select("select count(id) from repairRecord where residentId=#{id}")
	int selRepairRecordOne(int id);

	@Insert("insert into repairRecord values(default,#{residentId},#{building},#{room},#{type},#{content},#{phone},#{addTime},#{status})")
	boolean insRepairRecord(RepairRecord record);

	int selRepairRecordAll(@Param("record") RepairRecord record);

	@Update("update repairRecord set status=#{status} where id=#{id}")
	boolean updRepairRecord(RepairRecord record);

	List<RepairRecord> selRepairSearch(@Param("record") RepairRecord record, @Param("data") SearchData data);
}

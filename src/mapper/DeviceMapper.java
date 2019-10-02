package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pojo.Device;
import pojo.FixRecord;
import pojo.SearchData;

public interface DeviceMapper {
	@Select("select * from fixRecord order by time desc limit #{pageStart},#{pageSize}")
	List<FixRecord> selFixRecord(SearchData data);

	@Select("select count(id) from fixRecord")
	int selFixRecordTotal();

	@Select("select id,type from device where id=#{0}")
	Device selDeviceCheck(String deviceId);

	@Insert("insert into fixRecord values(default,#{deviceId},#{type},#{time},#{man},#{result})")
	boolean insFixRecord(FixRecord record);

	@Update("update device set fixTime=#{time} where id=#{deviceId} and (fixTime is null or fixTime<#{time})")
	boolean updFixTime(FixRecord record);

	@Insert("insert into device values(#{id},#{type},#{manufacturer},#{position},#{addTime},null)")
	boolean insDevice(Device device);

	@Select("select * from device order by addTime desc limit #{pageStart},#{pageSize}")
	List<Device> selDevice(SearchData data);

	@Select("select count(id) from device")
	int selDeviceTotal();

	@Update("update device set type=#{type},manufacturer=#{manufacturer},position=#{position} where id=#{id}")
	boolean updDevice(Device device);

	@Delete("delete from device where id=#{id}")
	boolean delDevice(String id);
}

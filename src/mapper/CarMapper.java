package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pojo.Car;
import pojo.CarPosition;
import pojo.SearchData;

public interface CarMapper {

	@Select("select * from car where residentId=#{id}")
	Car selCarById(int id);

	@Insert("insert into car values(default,#{residentId},null,#{carNumber},#{type},#{color})")
	boolean insCarInfo(Car car);

	@Update("update car set color=#{color},carNumber=#{carNumber},type=#{type} where residentId=#{residentId}")
	boolean updCarInfo(Car car);

	@Select("select building,room from resident where id=#{0}")
	Car selBuildingAndRoom(int id);

	List<Car> selCarSearch(@Param("car") Car car, @Param("data") SearchData data);

	int selTotalAll(@Param("car") Car car);

	@Select("select * from carPosition where taken=0")
	List<CarPosition> selCarPosition();

	@Select("select * from car where carNumber=#{0}")
	Car selOldPosition(String carNumber);

	@Update("update carPosition set taken=#{1} where position=#{0}")
	boolean updPosition(String position, int taken);

	@Update("update car set position=#{1} where carNumber=#{0}")
	boolean updCarPosition(String carNumber, String position);

}

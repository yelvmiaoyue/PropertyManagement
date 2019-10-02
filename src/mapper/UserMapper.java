package mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pojo.User;

public interface UserMapper {
	@Select("select id,username,password,rid from user where username=#{username} and password=#{password}")
	User selLogin(User user);

	@Update("update user set password=#{password} where id=#{id}")
	boolean updPassword(User user);

}

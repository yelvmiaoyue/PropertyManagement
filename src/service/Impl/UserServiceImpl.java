package service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mapper.ResidentMapper;
import mapper.UserMapper;
import pojo.User;
import service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	@Resource
	private ResidentMapper residentMapper;

	@Override
	public User login(User user) {
		User rs = userMapper.selLogin(user);
		if (rs != null && rs.getRid() != 1) {
			rs.setResident(residentMapper.selResidentInfo(rs.getId()));
		}
		return rs;
	}

	@Override
	public boolean updPassword(User user) {
		return userMapper.updPassword(user);
	}

}

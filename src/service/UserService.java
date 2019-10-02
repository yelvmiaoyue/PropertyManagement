package service;

import pojo.User;

public interface UserService {
	User login(User user);

	boolean updPassword(User user);
}

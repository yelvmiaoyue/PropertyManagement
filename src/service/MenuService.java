package service;

import java.util.List;

import pojo.Menu;

public interface MenuService {
	List<Menu> selByRid(int rid, int pid);
}

package service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mapper.MenuMapper;
import pojo.Menu;
import service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	@Resource
	private MenuMapper menuMapper;

	@Override
	public List<Menu> selByRid(int rid, int pid) {
		return menuMapper.selByRid(rid, pid);
	}

}

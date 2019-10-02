package controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.Menu;
import pojo.User;
import service.MenuService;
import service.UserService;

@Controller
public class UserController {
	@Resource
	private UserService userServiceImpl;
	@Resource
	private MenuService menuServiceImpl;

	@RequestMapping({ "login", "/" })
	public String login() {
		return "login.jsp";
	}

	@RequestMapping("main")
	public String main() {
		return "main.jsp";
	}

	@RequestMapping("loginCheck")
	public String login(User user, HttpServletRequest req) {
		User rs = userServiceImpl.login(user);
		if (rs != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", rs);
			List<Menu> menu = menuServiceImpl.selByRid(rs.getRid(), 0);
			session.setAttribute("menu", menu);
			return "redirect:main";
		} else {
			req.setAttribute("fail", "true");
			return "login";
		}
	}

	@RequestMapping("logOut")
	public String logOut(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.removeAttribute("user");
		return "redirect:login";
	}

	@RequestMapping("changePassword")
	@ResponseBody
	public boolean updateDevice(User user) {
		return userServiceImpl.updPassword(user);
	}
}

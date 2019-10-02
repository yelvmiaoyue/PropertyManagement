package interceptor;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		if (arg0.getHeader("x-requested-with") != null
				&& arg0.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) { // 如果是ajax请求响应头会有x-requested-with
			HttpSession session = arg0.getSession();
			Object user = session.getAttribute("user");
			if (user == null) {
				ServletOutputStream out = arg1.getOutputStream();
				out.print("loseSession");// session失效
				out.flush();
				return false;
			}
		}

		HttpSession session = arg0.getSession();
		Object user = session.getAttribute("user");
		if (user == null) {
			arg1.sendRedirect("login");
			return false;
		}
		return true;
	}

}

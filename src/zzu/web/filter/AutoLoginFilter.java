package zzu.web.filter;

import zzu.domin.Student;
import zzu.service.StudentService;
import zzu.service.StudentServiceImp;
import zzu.utils.CookUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AutoLoginFilter implements Filter {

	public void destroy() {
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		//chain.doFilter(request, response);
		
		
		
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse) res;

		String servletPath = request.getServletPath();
		if(servletPath.startsWith("/LoginServlet")){
			String method = request.getParameter("method");
			if("login".equals(method)){
				chain.doFilter(request, response);
				System.out.println("filter ： studentLogin");
				return;
			}
		}

		Student loginUser = (Student)request.getSession().getAttribute("loginStudent");
		if(null != loginUser){
			chain.doFilter(request, response);
			System.out.println("(null != loginUser)");
			return;
		}
		
		
		//获取用户携带到服务端cookie对象
		Cookie userCookie = CookUtils.getCookieByName("autoLogin",request.getCookies());
		//获取不到,放行
		if( userCookie == null){
			chain.doFilter(request, response);
			return;
		}

		String[] u = userCookie.getValue().split("@");
		String userName = u[0];
		String passWord = u[1];
		Student user = new Student();
		user.setID( Integer.parseInt(userName) );
		user.setPassWord(passWord);

		try {
			StudentService userService = new StudentServiceImp();
			loginUser = userService.findOneStudent(user.getID(),user.getPassWord());
			if(loginUser == null){
				chain.doFilter(request, response);
				return;
			}
			request.getSession().setAttribute("loginStudent", loginUser);
			chain.doFilter(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("自动登录异常");
		} finally {
		}

	}


}

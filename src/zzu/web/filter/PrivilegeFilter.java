package zzu.web.filter;

import zzu.domin.Student;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class PrivilegeFilter implements Filter {

	public void destroy() {
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		Student uu=(Student)req.getSession().getAttribute("loginStudent");
		if(null==uu){
			req.setAttribute("msg", "请登录后在访问");
			req.getRequestDispatcher("/login.jsp").forward(req, response);
			return;
		}
		
		chain.doFilter(request, response);
	}

	

}

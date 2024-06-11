package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter("/*")
//urlPatterns = { "/ToDoServlet", "/ToDoAddServlet" }
public class AuthFilter extends HttpFilter implements Filter {

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public AuthFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
//<<<<<<< HEAD
////		/HttpServletRequest req = (HttpServletRequest) request;
////		HttpServletResponse res = (HttpServletResponse) response;
////		
//=======
//		HttpServletRequest req = (HttpServletRequest) request;
//		HttpServletResponse res = (HttpServletResponse) response;
//		
//>>>>>>> branch 'main' of https://github.com/NaokiIshideWork/Java_PBL_2024.git
//		String path = req.getServletPath();
//		if(!path.equals("/ToDoLoginServlet")) {
//				var obj = req.getSession().getAttribute("person");		
//				if(obj == null) {
//					res.sendRedirect("ToDoLoginServlet");
//				return;
//				}
//		}
		chain.doFilter(request, response);
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AccountsBean;
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

		HttpSession session = ((HttpServletRequest) request).getSession();
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		AccountsBean ab = (AccountsBean)req.getSession().getAttribute("LoginUser");		
		
		String path = req.getServletPath();
		 
		 
		if (session.getAttribute("LoginUser")== null) {
			if(!path.equals("/LoginServlet")) {
				res.sendRedirect("LoginServlet");
				return;
			}
		}else {	
			if((ab.getAuthority() == 1 ||ab.getAuthority() == 11) && !(path.equals("/SearchSales")||path.equals("/SearchSalesServlet"))) {
				request.setAttribute("isAuth", true);
				res.sendRedirect("SearchSalesServlet");
				return;
			}
			
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

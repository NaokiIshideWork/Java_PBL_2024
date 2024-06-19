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

		AccountsBean ab = (AccountsBean) req.getSession().getAttribute("LoginUser");

		String path = req.getServletPath();
		String referer = "";

		try {
			referer = req.getHeader("referer").replaceAll(".*/([^/?]+).*", "$1");
		} catch (Exception e) {
			referer = null;//直打ちである
		}
		//		System.out.println("->"+referer);
		System.out.println("S:->"+session.getAttribute("redirectedFromRegister"));
		
		if (session.getAttribute("LoginUser") == null) {
			if (!path.equals("/LoginServlet")) {
				res.sendRedirect("LoginServlet");
				return;
			}
		} else {
			boolean flag1 = referer == null;
			boolean flag2 = ab.getAuthority() == 0 || ab.getAuthority() == 10;
			boolean flag3 = path.equals("/RegisterServlet") || path.equals("/RegisterSalesServlet");
			if (flag1 && flag2 && flag3) {
			    Boolean redirected = (Boolean) session.getAttribute("redirectedFromRegister");
			    if (redirected == null) {
			        session.setAttribute("redirectedFromRegister", true);
			        res.sendRedirect("RegisterServlet");
			        return;
			    }else {
			    	res.sendRedirect("RegisterServlet");
			        return;
			    }
			    
			}
		}

		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		super.init(fConfig);
	}

}

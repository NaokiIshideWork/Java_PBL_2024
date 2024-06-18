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
		String ErrorMessage = "";
		try {
			referer = req.getHeader("referer").replaceAll(".*/([^/?]+).*", "$1");
		} catch (Exception e) {
			referer = null;//直打ちである
		}
//		System.out.println("->"+referer);
		if (session.getAttribute("LoginUser") == null) {
			if (!path.equals("/LoginServlet")) {
				res.sendRedirect("LoginServlet");
				return;
			}
		}else {
			if (referer == null && !(ab.getAuthority() == 1 || ab.getAuthority() == 11)
					&& (path.equals("/RegisterServlet") || path.equals("/RegisterSalesServlet"))) {
				ErrorMessage ="売上編集権限はありません";
				req.getSession().setAttribute("isAuthSales", ErrorMessage);
				res.sendRedirect("RegisterServlet");//検索条件に返す
				return;
			}
			else if (referer == null && !(ab.getAuthority() == 1 || ab.getAuthority() == 11)
					&& !(path.equals("/SearchSales") || path.equals("/SearchSalesServlet"))) {
				ErrorMessage ="売上編集権限はありません,ページを直打ちしないでください";
				req.getSession().setAttribute("isAuth", ErrorMessage);
				res.sendRedirect("SearchSalesServlet");//検索条件に返す
				return;
			}
			
//			else if(referer == null && !(ab.getAuthority() == 10 || ab.getAuthority() == 11)
//			&& !(path.equals("/") || path.equals("/"))) {
//				ErrorMessage ="アカウント編集権限はありません,ページを直打ちしないでください";
//				req.getSession().setAttribute("isAuth", ErrorMessage);
//				res.sendRedirect("");//
//				return;
//			}

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

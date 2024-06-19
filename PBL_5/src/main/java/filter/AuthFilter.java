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
			referer = null;
		}
		if (session.getAttribute("LoginUser") == null) {
			if (!path.equals("/LoginServlet")) {
				res.sendRedirect("LoginServlet");
				return;
			}
		} else {
			boolean isRefer = referer == null;
			boolean isSalesRegAuth = ab.getAuthority() == 0 || ab.getAuthority() == 10;
			boolean isAccountRegAuth = ab.getAuthority() == 0 || ab.getAuthority() == 1;
			boolean isRegSale = path.equals("/RegisterServlet") || path.equals("/RegisterSalesServlet");
			boolean isEditSale = path.equals("/SalesDetailsDisplayServlet") || path.equals("/EditSalesDetails")
					|| path.equals("/ConfirmationSalesDeletion") || path.equals("/ConfirmationSalesEdit");
			boolean isRegAccount = path.equals("/AccountServlet") || path.equals("/AccountRegisterServlet");
			boolean isEditAccount = path.equals("/EditAccountServlet") || path.equals("/EditScreenServlet") ||
					path.equals("/DeleteAccountServlet");

			Boolean redirected = (Boolean) session.getAttribute("redirectedFromRegister");
			Boolean redirected1 = (Boolean) session.getAttribute("redirectedFromRegister1");
			Boolean redirected2 = (Boolean) session.getAttribute("redirectedFromRegister2");
			Boolean redirected3 = (Boolean) session.getAttribute("redirectedFromRegister3");
			if (isRefer && isSalesRegAuth && isRegSale) {

				if (redirected == null || !redirected) {
					session.setAttribute("redirectedFromRegister", true);
					res.sendRedirect("RegisterServlet");
					return;
				} else {
					session.removeAttribute("redirectedFromRegister");
					request.getRequestDispatcher("/S0010.jsp").forward(request, response);
					return;
				}
			}
			if (isRefer && isSalesRegAuth && isEditSale) {
				if (redirected1 == null || !redirected1) {
					session.setAttribute("redirectedFromRegister1", true);
					res.sendRedirect("SearchSalesServlet");
					return;
				} else {
					session.removeAttribute("redirectedFromRegister1");
					res.sendRedirect("SearchSalesServlet");
					return;
				}
			}
			if (isRefer && isAccountRegAuth && isRegAccount) {

				if (redirected2 == null || !redirected2) {
					session.setAttribute("redirectedFromRegister2", true);
					res.sendRedirect("AccountServlet");
					return;
				} else {
					session.removeAttribute("redirectedFromRegister2");
					request.getRequestDispatcher("/S0030.jsp").forward(request, response);
					return;
				}
			}
			if (isRefer && isAccountRegAuth && isEditAccount) {

				if (redirected3 == null || !redirected3) {
					session.setAttribute("redirectedFromRegister3", true);
					res.sendRedirect("AccountSearchServlet");
					return;
				} else {
					session.removeAttribute("redirectedFromRegister3");
					res.sendRedirect("AccountSearchServlet");
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

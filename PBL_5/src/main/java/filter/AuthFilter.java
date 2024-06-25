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

		String path = req.getServletPath();
		String referer = "";

		try {
			referer = req.getHeader("referer").replaceAll(".*/([^/?]+).*", "$1");
		} catch (Exception e) {
			referer = null;
		}
		if (path.endsWith(".jsp")) {
			session.invalidate();
			res.sendRedirect("LoginServlet");
			return;
		}

		if (session.getAttribute("LoginUser") == null && !path.contains("css")) {
			if (!path.equals("/LoginServlet")) {
				request.getRequestDispatcher("/C0010.jsp").forward(request, response);
				return;
				
			}
		} else {
			boolean isRefer = referer == null;//参照元

			//権限がない
			boolean isRegSales = path.equals("/RegisterConfirm");
			boolean isEditSale = path.equals("/SalesDetailsDisplayServlet") || path.equals("/EditSalesDetails")
					|| path.equals("/ConfirmationSalesDeletion") || path.equals("/ConfirmationSalesEdit")
					|| path.equals("/SearchSalesServlet");

			boolean isRegAccount = path.equals("/AccountRegisterServlet");
			boolean isEditAccount = path.equals("/EditAccountServlet") || path.equals("/EditScreenServlet") ||
					path.equals("/DeleteAccountServlet") || path.equals("/AccountSearchServlet");

			//権限なし
			Boolean redirected = (Boolean) session.getAttribute("redirectedFromRegister");
			Boolean redirected1 = (Boolean) session.getAttribute("redirectedFromRegister1");
			Boolean redirected2 = (Boolean) session.getAttribute("redirectedFromRegister2");
			Boolean redirected3 = (Boolean) session.getAttribute("redirectedFromRegister3");

			//売上登録画面 
			if (isRefer && isRegSales) {
				if (redirected == null || !redirected) {
					session.setAttribute("redirectedFromRegister", true);
					res.sendRedirect("RegisterServlet");
					return;
				} else {
					session.removeAttribute("redirectedFromRegister");
					res.sendRedirect("RegisterServlet");
					return;
				}
			}
			//売上編集画面
			if (isRefer && isEditSale) {
				if (redirected1 == null || !redirected1) {
					session.setAttribute("redirectedFromRegister1", true);
					res.sendRedirect("SearchSales");
					return;
				} else {
					session.removeAttribute("redirectedFromRegister1");
					res.sendRedirect("SearchSales");
					return;
				}
			}
			if (isRefer && isRegAccount) {
				if (redirected2 == null || !redirected2) {
					session.setAttribute("redirectedFromRegister2", true);
					res.sendRedirect("AccountServlet");
					return;
				} else {
					session.removeAttribute("redirectedFromRegister2");
					res.sendRedirect("AccountServlet");
					return;
				}
			}

			if (isRefer && isEditAccount)
				if (redirected3 == null || !redirected3) {
					session.setAttribute("redirectedFromRegister3", true);
					request.getRequestDispatcher("/S0040.jsp").forward(request, response);
					return;
				} else {
					session.removeAttribute("redirectedFromRegister3");
					res.sendRedirect("AccountSearchServlet");
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
		super.init(fConfig);
	}

}

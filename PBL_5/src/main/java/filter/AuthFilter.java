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

		if (session.getAttribute("LoginUser") == null) {
			if (!path.equals("/LoginServlet")) {
				res.sendRedirect("LoginServlet");
				return;
			}
		} else {
			boolean isRefer = referer == null;//参照元がない

			//権限がない
			boolean isRegSales = path.equals("/RegisterSalesServlet");//path.equals("/RegisterServlet") ||
			boolean isEditSale = path.equals("/SalesDetailsDisplayServlet") || path.equals("/EditSalesDetails")
					|| path.equals("/ConfirmationSalesDeletion") || path.equals("/ConfirmationSalesEdit")
					|| path.equals("/SearchSalesServlet");

			boolean isEditAccount = path.equals("/EditAccountServlet") || path.equals("/EditScreenServlet") ||
					path.equals("/DeleteAccountServlet") || path.equals("/AccountSearchServlet");

			//権限なし
			Boolean redirected = (Boolean) session.getAttribute("redirectedFromRegister");
			Boolean redirected1 = (Boolean) session.getAttribute("redirectedFromRegister1");
			Boolean redirected2 = (Boolean) session.getAttribute("redirectedFromRegister2");
		

			//売上登録画面 ok
			if (isRefer && isRegSales) {

				if (redirected == null || !redirected) {
					session.setAttribute("redirectedFromRegister", true);
					res.sendRedirect("RegisterServlet");
					return;
				} else {
					session.removeAttribute("redirectedFromRegister");
//					request.getRequestDispatcher("/S0010.jsp").forward(request, response);
					res.sendRedirect("RegisterServlet");
					return;
				}
			}
			//売上編集画面　ok
			if (isRefer && isEditSale) {
				if (redirected1 == null || !redirected1) {
					session.setAttribute("redirectedFromRegister1", true);
					res.sendRedirect("SearchSales");//修正
					return;
				} else {
					session.removeAttribute("redirectedFromRegister1");
					res.sendRedirect("SearchSales");//修正
					return;
				}
			}

			if (isRefer && isEditAccount)
				if (redirected2 == null || !redirected2) {
					session.setAttribute("redirectedFromRegister2", true);
					request.getRequestDispatcher("/S0040.jsp").forward(request, response);
					return;
				} else {
					session.removeAttribute("redirectedFromRegister2");
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

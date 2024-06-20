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
			boolean hasnotSalesReg = ab.getAuthority() == 0 || ab.getAuthority() == 10;//売上登録権限がない人
			boolean hasnotAccountReg = ab.getAuthority() == 0 || ab.getAuthority() == 1;//アカウント登録がない人
			boolean hasSalesReg = ab.getAuthority() == 1 || ab.getAuthority() == 11;//売上登録権限を所持
			boolean hasAccountReg = ab.getAuthority() == 10 || ab.getAuthority() == 11;//アカウント登録権限を所持

			//権限がない
			boolean isRegSales = path.equals("/RegisterServlet") || path.equals("/RegisterSalesServlet");
			boolean isEditSale = path.equals("/SalesDetailsDisplayServlet") || path.equals("/EditSalesDetails")
					|| path.equals("/ConfirmationSalesDeletion") || path.equals("/ConfirmationSalesEdit")||path.equals("/SearchSalesServlet");

			boolean isRegAccount = path.equals("/AccountServlet") || path.equals("/AccountRegisterServlet");
			boolean isEditAccount = path.equals("/EditAccountServlet") || path.equals("/EditScreenServlet") ||
					path.equals("/DeleteAccountServlet");

			//権限がある
			boolean isRegisterSalesServlet = path.equals("/RegisterSalesServlet");
			boolean isEditSalesServlet = path.equals("/SearchSalesServlet")
					|| path.equals("/SalesDetailsDisplayServlet") || path.equals("/EditSalesDetails")
					|| path.equals("/ConfirmationSalesDeletion") || path.equals("/ConfirmationSalesEdit");

			boolean isEditAccountsServlet = path.equals("/EditAccountServlet") || path.equals("/EditScreenServlet") ||
					path.equals("/DeleteAccountServlet") || path.equals("/AccountSearchServlet");
			//権限なし
			Boolean redirected = (Boolean) session.getAttribute("redirectedFromRegister");
			Boolean redirected1 = (Boolean) session.getAttribute("redirectedFromRegister1");
			Boolean redirected2 = (Boolean) session.getAttribute("redirectedFromRegister2");
			Boolean redirected3 = (Boolean) session.getAttribute("redirectedFromRegister3");

			//権限あり
			Boolean redirected4 = (Boolean) session.getAttribute("redirectedFromRegister4");
			Boolean redirected5 = (Boolean) session.getAttribute("redirectedFromRegister5");
			Boolean redirected7 = (Boolean) session.getAttribute("redirectedFromRegister7");

			//売上登録権限なし
			if (isRefer && hasnotSalesReg && isRegSales) {

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
			//売上編集権限がなく　編集画面一覧等に打ち込んだ場合
			if (isRefer && hasnotSalesReg && isEditSale	) {
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
			//売上登録権限あり
			if (isRefer && hasSalesReg && isRegisterSalesServlet) {
				if (redirected4 == null || !redirected4) {
					session.setAttribute("redirectedFromRegister4", true);
					res.sendRedirect("RegisterServlet");
					return;
				} else {
					session.removeAttribute("redirectedFromRegister4");
					res.sendRedirect("RegisterServlet");
					return;
				}
			}
			if (isRefer && hasSalesReg && isEditSalesServlet)
				if (redirected5 == null || !redirected5) {
					session.setAttribute("redirectedFromRegister5", true);
					res.sendRedirect("SearchSales");
					return;
				} else {
					session.removeAttribute("redirectedFromRegister5");
					res.sendRedirect("SearchSales");
					return;
				}

			//アカウント登録権限関連
			if (isRefer && hasnotAccountReg && isRegAccount) {

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
			if (isRefer && hasnotAccountReg && isEditAccount) {

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
			
			if (isRefer && hasAccountReg && isEditAccountsServlet) {
				if (redirected7 == null || !redirected7) {
					session.setAttribute("redirectedFromRegister7", true);
					res.sendRedirect("AccountSearchServlet");
					return;
				} else {
					session.removeAttribute("redirectedFromRegister7");
					request.getRequestDispatcher("/S0030.jsp").forward(request, response);
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

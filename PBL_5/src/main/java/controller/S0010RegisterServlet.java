package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AccountsBean;
import model.CategoriesBean;
import services.SQLServicesPBLreg;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class S0010RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public S0010RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		SQLServicesPBLreg sqlserv = new SQLServicesPBLreg();
		String ErrorMessage = "";
		HttpSession session = request.getSession();

		//担当表示用
		ArrayList<AccountsBean> account_list = null;
		account_list = sqlserv.canSelectAllAcount();
		//商品カテゴリー表示用
		ArrayList<CategoriesBean> categories_list = null;
		categories_list = sqlserv.canSelectAllCategory();

		if (account_list.isEmpty()) {
			ErrorMessage += "アカウントテーブルに存在しません";
			request.setAttribute("err", ErrorMessage);
		} else {
			request.setAttribute("accounts", account_list);
		}

		if (categories_list.isEmpty()) {
			ErrorMessage += "商品カテゴリーテーブルに存在しません";
			request.setAttribute("err", ErrorMessage);
		} else {
			request.setAttribute("cate", categories_list);
		}
//		String datavalue = request.getParameter("cancel");
//		System.out.println("cancel: " + datavalue);

		String queryString = request.getQueryString();
		if (queryString != null && !queryString.isEmpty()) {
			
		} else {
			// クエリ文字列がない場合の処理
			session.removeAttribute("sblist");
			System.out.println("クエリ文字列は存在しません");
		}

		this.getServletContext().getRequestDispatcher("/S0010.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}

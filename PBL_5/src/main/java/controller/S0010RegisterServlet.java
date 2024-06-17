package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AccountsBean;
import model.CategoriesBean;
import model.SalesBean;
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
		String error_message = "";

		//担当表示用
		ArrayList<AccountsBean> account_list = null;
		account_list = sqlserv.SelectAllAcount();
		//商品カテゴリー表示用
		ArrayList<CategoriesBean> categories_list = null;
		categories_list = sqlserv.SelectAllCategory();

		if (account_list.isEmpty()) {
			error_message += "アカウントテーブルに存在しません";
			request.setAttribute("err", error_message);
		} else {
			request.setAttribute("accounts", account_list);
		}

		if (categories_list.isEmpty()) {
			error_message += "商品カテゴリーテーブルに存在しません";
			request.setAttribute("err", error_message);
		} else {
			request.setAttribute("cate", categories_list);
		}

		this.getServletContext().getRequestDispatcher("/S0010.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		SQLServicesPBLreg sqlreg = new SQLServicesPBLreg();
		SalesBean sblist = null;
		String error_message = "";

		String sales_date = request.getParameter("sale_date");
		if (sales_date.isEmpty()) {
			error_message += "販売日を入力して下さい,";//ok
		} else {
			sales_date = sales_date.replace("-", "/");
		}

		//担当に対するName
		String account_id = request.getParameter("account");//id
		String accountName = "";
		if (account_id.equals("選択して下さい。")) {
			error_message += "担当が未選択です,";
		} else {
			accountName = sqlreg.SelectRegName(Integer.parseInt(account_id));//担当名
		}

		//商品カテゴリーに対する
		String item_category_id = request.getParameter("item_category");//id
		String item_category_name = "";
		if (item_category_id.equals("選択して下さい。")) {
			error_message += "担当が未選択です,";
		} else {
			item_category_name = sqlreg.SelectCategory_Name(Integer.parseInt(item_category_id));
		}

		//商品名
		String trade_name = request.getParameter("trade_name");
		if (trade_name.isEmpty()) {
			error_message += "商品名を入力して下さい,";//ok
		} else if (trade_name.length() > 100) {
			error_message += "商品名が長すぎます,";//ok
		}

		//単価
		String unit_price = request.getParameter("unit_price");
		if (unit_price.isEmpty()) {
			error_message += "単価を入力して下さい,";//ok
		} else if (unit_price.length() > 10) {
			error_message += "単価が長すぎます,";//ok
		} else if (!unit_price.matches("\\d{1,3}(,\\d{3})*")) {
			error_message += "単価を正しく入力して下さい,";//ok
		}

		//個数
		String sale_number = request.getParameter("sale_number");
		if (sale_number.isEmpty()) {
			error_message += "個数を入力して下さい,";//ok
		} else if (sale_number.length() > 10) {
			error_message += "個数が長すぎます,";//ok
		} else if (!sale_number.matches("\\d{1,3}(,\\d{3})*")) {
			error_message += "個数を正しく入力して下さい,";//ok
		}

		//備考
		String note = request.getParameter("note");
		if (note.length() > 400) {
			error_message += "備考が長すぎます,";
		}

		int subtotal = 0;
		if (error_message.isEmpty()) {
			unit_price = unit_price.replace(",", "");
			sale_number = sale_number.replace(",", "");
			subtotal = Integer.parseInt(unit_price) * Integer.parseInt(sale_number);
		}

		if (error_message.isEmpty()) {
			sblist = new SalesBean(sales_date, accountName, Integer.parseInt(account_id), item_category_name,
					Integer.parseInt(item_category_id), trade_name, Integer.parseInt(unit_price),
					Integer.parseInt(sale_number), subtotal, note);
			request.setAttribute("list", sblist);
			this.getServletContext().getRequestDispatcher("/S0011.jsp").forward(request, response);
		} else {
			request.setAttribute("err", error_message);
			doGet(request, response);
		}

	}

}

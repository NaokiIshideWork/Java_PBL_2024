package controller;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AccountsBean;
import model.CategoriesBean;
import model.SalesBean;
import services.SQLServicesPBLreg;
import util.CharUtil;

/**
 * Servlet implementation class S0010RegisterShow
 */
@WebServlet("/RegisterConfirm")
public class S0010RegisterShow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public S0010RegisterShow() {
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
		String ErrorMessage = "";
		HttpSession session = request.getSession();
		String salesDate = request.getParameter("sale_date");
		if (salesDate.isEmpty()) {
			ErrorMessage += "販売日を入力して下さい,";
		}

		//担当
		String account_id = request.getParameter("account");//id
		String accountName = "";
		if (account_id.equals("選択して下さい。")) {
			ErrorMessage += "担当が未選択です,";
			account_id = "0";
		} else {
			accountName = sqlreg.SelectRegName(Integer.parseInt(account_id));//担当名
		}

		//商品カテゴリー
		String item_category_id = request.getParameter("item_category");//id
		String item_category_name = "";
		if (item_category_id.equals("選択して下さい。")) {
			ErrorMessage += "商品カテゴリーが未選択です,";
			item_category_id = "0";
		} else {
			item_category_name = sqlreg.SelectCategory_Name(Integer.parseInt(item_category_id));
		}

		//商品名
		String trade_name = request.getParameter("trade_name");
		if (trade_name.isEmpty()) {
			ErrorMessage += "商品名を入力して下さい,";
		} else if (trade_name.length() > 100) {
			ErrorMessage += "商品名が長すぎます,";
		}

		trade_name = sanitizing(trade_name);

		//単価
		String unit_price = request.getParameter("unit_price");
		if (unit_price.isEmpty()) {
			ErrorMessage += "単価を入力して下さい,";
		} else if (unit_price.length() > 10) {
			ErrorMessage += "単価が長すぎます,";
		} else if (!unit_price.matches("\\d{1,3}(,\\d{3})*")) {
			ErrorMessage += "4桁以上の場合は3桁ごとに,を入力して下さい,";
		}

		//個数
		String sale_number = request.getParameter("sale_number");
		if (sale_number.isEmpty()) {
			ErrorMessage += "個数を入力して下さい,";
		} else if (sale_number.length() > 10) {
			ErrorMessage += "個数が長すぎます,";
		} else if (!sale_number.matches("\\d{1,3}(,\\d{3})*")) {
			ErrorMessage += "4桁以上の場合は3桁ごとに,を入力して下さい,";
		}

		//備考
		String note = request.getParameter("note");
		if (note.length() > 400) {
			ErrorMessage += "備考が長すぎます,";
		}
		note = note.trim();

		int subtotal = 0;
		if (ErrorMessage.isEmpty()) {
			unit_price = unit_price.replace(",", "");
			sale_number = sale_number.replace(",", "");
			subtotal = Integer.parseInt(unit_price) * Integer.parseInt(sale_number);
		}

		if (ErrorMessage.isEmpty()) {
			//登録確認
			sblist = new SalesBean(salesDate, accountName, Integer.parseInt(account_id), item_category_name,
					Integer.parseInt(item_category_id), trade_name, formatNumber(Integer.parseInt(unit_price)),
					formatNumber(Integer.parseInt(sale_number)), formatNumber(subtotal), note);
			session.setAttribute("sblist", sblist);

			this.getServletContext().getRequestDispatcher("/S0011.jsp").forward(request, response);
		} else {
			ErrorMessage = CharUtil.replaceCommaAtEnd(ErrorMessage);
			request.setAttribute("err", ErrorMessage);
			sblist = new SalesBean(salesDate, accountName, Integer.parseInt(account_id), item_category_name,
					Integer.parseInt(item_category_id), trade_name, unit_price,
					sale_number, formatNumber(subtotal), note);
			session.setAttribute("sblist", sblist);
			doGet(request, response);
		}

	}

	public static final String formatNumber(long num) {
		NumberFormat nf = NumberFormat.getNumberInstance();
		return nf.format(num);
	}

	public static String sanitizing(String str) {
		if (null == str || "".equals(str)) {
			return str;
		}

		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		str = str.replaceAll("'", "&apos;");

		return str;
	}

}

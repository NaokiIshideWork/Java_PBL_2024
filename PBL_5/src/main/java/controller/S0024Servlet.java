package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.S0023ConfirmBean;
import services.SQLServicesPBLsfs;
import util.CharUtil;

/**
 * Servlet implementation class S0024Servlet
 */
@WebServlet("/ConfirmationSalesEdit")
public class S0024Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public S0024Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		SQLServicesPBLsfs mts = new SQLServicesPBLsfs();
		S0023ConfirmBean S0023Confirmlist = null;
		String error_message = "";

		String up_date_id = request.getParameter("up_date_id");
		String sale_date = request.getParameter("sale_date");//販売日
		if (sale_date.isEmpty()) {
			error_message += "販売日を入力して下さい,";
		} else {
			sale_date = sale_date.replaceAll("-", "/");
		}

		//担当
		String account_id = request.getParameter("account_id");
		String account_name = "";
		if (account_id.equals("選択して下さい。")) {
			error_message += "担当が未選択です,";
		} else {
			account_name = mts.SearchName(Integer.parseInt(account_id));
		}

		//商品カテゴリー
		String category_id = request.getParameter("category_id");
		String category_name = "";
		if (category_id.equals("選択して下さい。")) {
			error_message += "商品カテゴリーが未選択です,";
		} else {
			category_name = mts.SearchCategory_name(Integer.parseInt(category_id));
		}

		//商品名
		String trade_name = request.getParameter("tard_name");
		if (trade_name.isEmpty()) {
			error_message += "商品名を入力して下さい,";
		} else if (trade_name.length() > 100) {
			error_message += "商品名が長すぎます,";
		}
		trade_name = sanitizing(trade_name);
		//単価
		String unit_price = request.getParameter("unit_price");
		if (unit_price.isEmpty()) {
			error_message += "単価を入力して下さい,";
		} else if (unit_price.length() > 9) {
			error_message += "単価の桁数が長すぎます,";
		} else if (!unit_price.matches("\\d{1,3}(,\\d{3})*")) {
			error_message += "単価を正しく入力して下さい,";

		}
		//個数
		String sale_number = request.getParameter("sale_namber");
		if (sale_number.isEmpty()) {
			error_message += "個数を入力して下さい,";
		} else if (sale_number.length() > 9) {
			error_message += "個数の桁数が長すぎます,";
		} else if (!sale_number.matches("\\d{1,3}(,\\d{3})*")) {
			error_message += "個数を正しく入力して下さい,";
		}
		//備考
		String note = request.getParameter("note");
		if (note.length() > 400) {
			error_message += "備考が長すぎます,";
		}

		if (error_message.isEmpty()) {
			S0023Confirmlist = new S0023ConfirmBean(Integer.parseInt(up_date_id), sale_date, account_name,
					Integer.parseInt(account_id), category_name, Integer.parseInt(category_id), trade_name, unit_price,
					sale_number, note);
			request.setAttribute("S0024list", S0023Confirmlist);
			this.getServletContext().getRequestDispatcher("/S0024.jsp").forward(request, response);
		} else {
			error_message = CharUtil.replaceCommaAtEnd(error_message);
			request.setAttribute("err", error_message);
			this.getServletContext().getRequestDispatcher("/S0023.jsp").forward(request, response);
		}
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	public static String sanitizing(String str) {
		if (null == str || "".equals(str)) {
			return str;
		}

		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		str = str.replaceAll("'", "&#39;");

		return str;
	}

}

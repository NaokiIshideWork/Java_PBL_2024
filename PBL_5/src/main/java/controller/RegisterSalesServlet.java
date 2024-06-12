package controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SalesBean;
import services.SQLServicesPBLreg;

/**
 * Servlet implementation class RegisterSalesServlet
 */
@WebServlet("/RegisterSalesServlet")
public class RegisterSalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterSalesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/S0011.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		SQLServicesPBLreg mts = new SQLServicesPBLreg();
		SalesBean list = null;
		String error_message = "";

		String sales_date = request.getParameter("sale_date");
		if(Objects.isNull(sales_date)) {
			error_message += "販売日を入力して下さい";
		}else {
			//販売日を正しく入力して下さい
		}

		//担当に対するName
		String account_id = request.getParameter("account");//id	
		String accountName = mts.SelectRegName(Integer.parseInt(account_id));//担当名
		if(Objects.isNull(accountName)) {
			error_message += "担当が未選択です";
		}

		//商品カテゴリーに対する
		String item_category_id = request.getParameter("item_category");//id
		String item_category_name = mts.SelectCategory_Name(Integer.parseInt(item_category_id));
		if(Objects.isNull(item_category_name)) {
			error_message += "商品カテゴリーが未選択です";
		}

		//商品名
		String trade_name = request.getParameter("trade_name");
		if(Objects.isNull(trade_name)) {
			error_message += "商品名を入力して下さい";
		}else {
			if(trade_name.length() > 100) {
				error_message += "商品名が長すぎます";
			}
		}
		
		//単価
		String unit_price = request.getParameter("unit_price");
		if(Objects.isNull(unit_price)) {
			error_message += "単価を入力して下さい";
		}else {
			if(unit_price.length() >10) {
				error_message += "単価が長すぎます";
			}else {
				//形式チェック　単価を正しく入力して下さい
			}
		}
		//個数
		String sale_number = request.getParameter("sale_number");
		if(Objects.isNull(sale_number)) {
			error_message += "個数を入力して下さい";
		}else {
			if(sale_number.length() > 10) {
				error_message += "個数が長すぎます";
			}else {
				//個数を正しく入力して下さい
			}
		}
		
		//備考
		String note = request.getParameter("note");
		if(note.length() > 400) {
			error_message += "備考が長すぎます";
		}
		
		int subtotal = 0;
		if(!Objects.isNull(unit_price) && !Objects.isNull(sale_number)) {
			subtotal = Integer.parseInt(unit_price) * Integer.parseInt(sale_number);
		}
		
		if(!Objects.isNull(error_message)) {
			list = new SalesBean(sales_date, accountName, Integer.parseInt(account_id), item_category_name,
					Integer.parseInt(item_category_id), trade_name, Integer.parseInt(unit_price),
					Integer.parseInt(sale_number), subtotal, note);
			request.setAttribute("list", list);
			doGet(request, response);
		}else {
			request.setAttribute("err", error_message);
			this.getServletContext().getRequestDispatcher("/S0010.jsp").forward(request, response);
		}
			
		
		
		
	}

}

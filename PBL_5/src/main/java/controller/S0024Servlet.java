package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.S0023ConfirmBean;
import services.SQLServicesPBLsfs;

/**
 * Servlet implementation class S0024Servlet
 */
@WebServlet("/S0024Servlet")
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
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/S0024.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		SQLServicesPBLsfs mts = new SQLServicesPBLsfs();
		S0023ConfirmBean S0023Confirmlist = null;//id混みのやつ
		String error_message = "";

		//
		String up_date_id = request.getParameter("up_date_id");
		String sale_date = request.getParameter("sale_date");
		if (sale_date.isEmpty()) {
			error_message += "販売日を入力して下さい";
		}

		String account_id = request.getParameter("account_id");
		String account_name = mts.SearchName(Integer.parseInt(account_id));

		String category_id = request.getParameter("category_id");
		String category_name = mts.SearchCategory_name(Integer.parseInt(category_id));

		String trade_name = request.getParameter("tard_name");
		if (trade_name.isEmpty()) {
			error_message += "商品名を入力して下さい";
		} else {
			if (trade_name.length() > 100) {
				error_message += "商品名が長すぎます";
			}
		}

		String unit_price = request.getParameter("unit_price");
		if (unit_price.isEmpty()) {
			error_message += "単価を入力して下さい";
		} else {
			if (!unit_price.matches("\\d{1,3}(,\\d{3})*")) {
				error_message += "単価を正しく入力して下さい,";
			}
		}

		String sale_number = request.getParameter("sale_namber");
		if (sale_number.isEmpty()) {
			error_message += "個数を入力して下さい,";
		} else {
			//個数を正しく入力して下さい
			if (!sale_number.matches("\\d{1,3}(,\\d{3})*")) {
				error_message += "個数を正しく入力して下さい,";
			}
		}
	

	String note = request.getParameter("note");
	if (note.length() > 400) {
		error_message += "備考が長すぎます,";
	}

	S0023Confirmlist=new S0023ConfirmBean(Integer.parseInt(up_date_id),sale_date,account_name,Integer.parseInt(account_id),category_name,Integer.parseInt(category_id),trade_name,unit_price,sale_number,note);
	request.setAttribute("S0024list",S0023Confirmlist);
	doGet(request, response);
		
	}

}

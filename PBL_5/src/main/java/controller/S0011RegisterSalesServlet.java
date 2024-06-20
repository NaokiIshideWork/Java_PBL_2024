package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.SQLServicesPBLreg;

/**
 * Servlet implementation class RegisterSalesServlet
 */
@WebServlet("/RegisterSalesServlet")
public class S0011RegisterSalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public S0011RegisterSalesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/S0010.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		SQLServicesPBLreg mts = new SQLServicesPBLreg();
		
		String sales_date = request.getParameter("sale_date");//販売日		
		String account_id =  request.getParameter("account_id");//account_id	
		String category_id = request.getParameter("category_id");//categori_id
		String trade_name = request.getParameter("trade_name");//商品名
		String unit_price = request.getParameter("unit_price");//単価
		unit_price = unit_price.replace(",", "");
		String sale_number = request.getParameter("sale_number");//個数
		sale_number = sale_number.replace(",", "");
		String note = request.getParameter("note");//備考
		
		mts.insert(sales_date, Integer.parseInt(account_id), Integer.parseInt(category_id), trade_name, Integer.parseInt(unit_price), Integer.parseInt(sale_number), note);
		response.sendRedirect("RegisterServlet");
	}

}

package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SalesBean;
import services.SQLservicesPBL;

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
		SQLservicesPBL mts = new SQLservicesPBL();
		SalesBean list = null;
		
		String sales_date = request.getParameter("sale_date");
		String account = request.getParameter("account");
		String item_category = request.getParameter("item_category");
		String trade_name = request.getParameter("trade_name");
		String unit_price = request.getParameter("unit_price");
		String sale_number = request.getParameter("sale_number");
		String note = request.getParameter("note");
		
		int subtotal = Integer.parseInt(unit_price)*Integer.parseInt(sale_number);
		
		list = new SalesBean(sales_date, account, item_category, trade_name,Integer.parseInt(unit_price),
				Integer.parseInt(sale_number), subtotal, note);
		request.setAttribute("list", list);
		doGet(request, response);
	}

}

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
		
		String sales_date = request.getParameter("sale_date");
		//account_id
		String account_id =  request.getParameter("account_id");
		//categori_id
		String category_id = request.getParameter("category_id");
		String trade_name = request.getParameter("trade_name");
		String unit_price = request.getParameter("unit_price");
		String sale_number = request.getParameter("sale_number");
		String note = request.getParameter("note");
		

		mts.insert(sales_date, Integer.parseInt(account_id), Integer.parseInt(category_id), trade_name, Integer.parseInt(unit_price), Integer.parseInt(sale_number), note);
		
		response.sendRedirect("RegisterServlet");
	}

}

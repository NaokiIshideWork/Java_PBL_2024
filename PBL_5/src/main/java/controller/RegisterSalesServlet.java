package controller;

import java.io.IOException;
import java.sql.Date;

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
		Date sales_date = Date.valueOf(request.getParameter("sales_date"));
		System.out.println(sales_date);
		String responsible = request.getParameter("responsible");
		String items = request.getParameter("items");
		String item_name = request.getParameter("item_name");
		String price = request.getParameter("price");
		String number = request.getParameter("number");
		String note = request.getParameter("note");
		
		list = new SalesBean(1, sales_date, 1, 1,item_name, Integer.parseInt(price),Integer.parseInt(number),note);
		request.setAttribute("list", list);
		doGet(request, response);
	}

}

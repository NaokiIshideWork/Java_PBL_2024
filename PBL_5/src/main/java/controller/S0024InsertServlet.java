package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.SQLServicesPBLsfs;

/**
 * Servlet implementation class S0024InsertServlet
 */
@WebServlet("/S0024InsertServlet")
public class S0024InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S0024InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/S0021.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		SQLServicesPBLsfs mts = new SQLServicesPBLsfs();
		
		String up_date_id = request.getParameter("up_date_id");
		
		String sale_date = request.getParameter("sale_date");
		String account_id = request.getParameter("account_id");
		String category_id = request.getParameter("category_id");
		
		String trade_name = request.getParameter("trade_name");
		String unit_price = request.getParameter("unit_price");
		String sale_number = request.getParameter("sale_number");
		String note = request.getParameter("note");
		
		System.out.println(up_date_id+sale_date+account_id);
		System.out.println(category_id+trade_name+unit_price);
		System.out.println(sale_number+note);
		
		mts.insert(Integer.parseInt(up_date_id), sale_date, account_id, category_id, trade_name,
				unit_price, sale_number, note);
		doGet(request, response);
		
		
	}

}

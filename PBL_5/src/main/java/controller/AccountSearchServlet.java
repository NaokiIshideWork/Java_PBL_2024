package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AccountSearchServlet
 */
@WebServlet("/AccountSearchServlet")
public class AccountSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/S0040.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		SQLservicesPBL ssp = new SQLservicesPBL();
//		
//		
//		ArrayList<AccountsBean> accountsList = new ArrayList<AccountsBean>();
//		
//		SalesBean list = null;
//		
//		String sales_date = request.getParameter("sale_date");
//		String account = request.getParameter("account");
//		String item_category = request.getParameter("item_category");
//		String trade_name = request.getParameter("trade_name");
//		String unit_price = request.getParameter("unit_price");
//		String sale_number = request.getParameter("sale_number");
//		String note = request.getParameter("note");
//		
//		int subtotal = Integer.parseInt(unit_price)*Integer.parseInt(sale_number);
//		
//		list = new SalesBean(sales_date, account, item_category, trade_name,Integer.parseInt(unit_price),
//				Integer.parseInt(sale_number), subtotal, note);
//		request.setAttribute("list", list);
//		
//		// 次の遷移ページに飛ばす
//		doGet(request, response);
		
	}

}

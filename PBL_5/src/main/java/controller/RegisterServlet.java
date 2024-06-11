package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AccountsBean;
import model.CategoriesBean;
import model.SalesBean;
import services.SQLServicesPBLreg;
import services.SQLservicesPBL;
/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		SQLServicesPBLreg sqlserv = new SQLServicesPBLreg();
		ArrayList<AccountsBean> account_list = null;
		//担当表示用
		account_list = sqlserv.SelectAllAcount();
		request.setAttribute("accounts", account_list);
		
		//商品カテゴリー表示用
		ArrayList<CategoriesBean> categories_list = null;
		categories_list = sqlserv.SelectAllCategory();
		request.setAttribute("cate", categories_list);
		
		this.getServletContext().getRequestDispatcher("/S0010.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AccountsBean;
import model.CategoriesBean;
import model.Sales2Bean;
import model.SalesSearchDisplayBean;
import services.SQLServicesPBLreg;
import services.SQLServicesPBLsfs;

/**
 * Servlet implementation class SearchSalesServlet
 */
@WebServlet("/SearchSalesServlet")
public class SearchSalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchSalesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		SQLServicesPBLreg sqlserv = new SQLServicesPBLreg();
		SQLServicesPBLsfs sqlservsfs = new SQLServicesPBLsfs();
		String error_message = "";

		ArrayList<AccountsBean> account_list = null;
		account_list = sqlservsfs.SelectAllAcount();

		if (account_list.isEmpty()) {
			error_message += "アカウントテーブルに存在しません";
			request.setAttribute("err", error_message);
		} else {
			request.setAttribute("accounts", account_list);
		}

		//商品カテゴリー表示用
		ArrayList<CategoriesBean> categories_list = null;
		categories_list = sqlserv.SelectAllCategory();

		if (categories_list.isEmpty()) {
			error_message += "商品カテゴリーテーブルに存在しません";
			request.setAttribute("err", error_message);
		} else {
			request.setAttribute("cate", categories_list);
		}
		
		this.getServletContext().getRequestDispatcher("/S0020.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		SQLServicesPBLsfs mts = new SQLServicesPBLsfs();
		ArrayList<Sales2Bean> Sales2Bean_list = new ArrayList<Sales2Bean>();
		ArrayList<SalesSearchDisplayBean> account_list = new ArrayList<SalesSearchDisplayBean>();
		String error_message = "";

		String salesDateB = request.getParameter("salesDateB");
		if (salesDateB.isEmpty()) {
			error_message += "販売日(検索開始日)を入力して下さい,";//ok
		} else {
			salesDateB = salesDateB.replace("-", "/");
		}
		
		String salesDateA = request.getParameter("salesDateA");
		if (salesDateA.isEmpty()) {
			error_message += "販売日(検索終了日)を入力して下さい,";//ok
		} else {
			salesDateA = salesDateA.replace("-", "/");
		}
		
		String salesPerson = request.getParameter("salesPerson");//int
		String productCategory = request.getParameter("productCategory");//int
		String productName = request.getParameter("productName");
		String remarks = request.getParameter("remarks");
		

		HttpSession session = request.getSession();
		//select で0だった場合に0件だから　商品名と備考がなくてもOK
		
		Sales2Bean_list = mts.selectAllSales(salesDateB, salesDateA, salesPerson, productCategory, productName, remarks);
		if(Sales2Bean_list.isEmpty()) {
			error_message += "検索結果はありません";
			request.setAttribute("err", error_message);
			doGet(request, response);
		}else {
			//表示用
			account_list =mts.SalesSearchDisplay(salesDateB, salesDateA, salesPerson, productCategory, productName, remarks);	
			session.setAttribute("list", account_list);
			this.getServletContext().getRequestDispatcher("/S0021.jsp").forward(request, response);
			
		}
	}

}

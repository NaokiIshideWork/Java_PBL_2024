package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Sales2Bean;
import model.SalesSearchBean;
import model.SalesSearchDisplayBean;
import services.SQLServicesPBLsfs;
import util.CharUtil;

/**
 * Servlet implementation class SearchSalesServlet
 */
@WebServlet("/SearchSalesServlet")
public class S0020SearchSalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public S0020SearchSalesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		SQLServicesPBLsfs mts = new SQLServicesPBLsfs();
		HttpSession session = request.getSession();
		SalesSearchBean ssb_list = (SalesSearchBean) session.getAttribute("ssb");
		ArrayList<SalesSearchDisplayBean> account_list = new ArrayList<SalesSearchDisplayBean>();

		String search = (String) session.getAttribute("search");
		//コメント
		if (search.equals("1")) {
			account_list = mts.SalesSearchDisplay3(ssb_list.getSalesDateB(),
					ssb_list.getSalesDateA(), ssb_list.getPersonName(), ssb_list.getItem_category(),
					ssb_list.getProductName(), ssb_list.getRemarks());//これ
		} else if (search.equals("2")){
			account_list = mts.SalesSearchDisplay(ssb_list.getSalesDateB(),
					ssb_list.getSalesDateA(), ssb_list.getPersonName(), ssb_list.getItem_category(),
					ssb_list.getProductName(), ssb_list.getRemarks());//これ
			
		} else if (search.equals("3")) {
			account_list = mts.SalesSearchDisplay1(ssb_list.getSalesDateB(),
					ssb_list.getSalesDateA(), ssb_list.getPersonName(), ssb_list.getItem_category(),
					ssb_list.getProductName(), ssb_list.getRemarks());
		} else if (search.equals("4")) {
			account_list = mts.SalesSearchDisplay2(ssb_list.getSalesDateB(),
					ssb_list.getSalesDateA(), ssb_list.getPersonName(), ssb_list.getItem_category(),
					ssb_list.getProductName(), ssb_list.getRemarks());
		}

		session.removeAttribute("slist");
		session.setAttribute("slist", account_list);

		this.getServletContext().getRequestDispatcher("/S0021.jsp").forward(request, response);

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

		String ErrorMessage = "";

		String salesDateB = request.getParameter("salesDateB");

		if (salesDateB.isEmpty()) {
			salesDateB = "0000-00-00";
		} else {
			salesDateB = salesDateB.replace("-", "/");
		}

		String salesDateA = request.getParameter("salesDateA");
		if (salesDateA.isEmpty()) {
			salesDateA = "9999-12-31";
		} else {
			salesDateA = salesDateA.replace("-", "/");
		}

		String salesPerson = request.getParameter("salesPerson");//担当者id
		String productCategory = request.getParameter("productCategory");//商品カテゴリーid
		String productName = request.getParameter("productName");//商品名
		String remarks = request.getParameter("remarks");//備考

		HttpSession session = request.getSession();

		//検索結果が0件か?
		if (salesPerson.equals("選択して下さい。") && productCategory.equals("選択して下さい。")) {
			Sales2Bean_list = mts.selectAllSales3(salesDateB, salesDateA, productName,
					remarks);
		} else if (salesPerson.equals("選択して下さい。") && !productCategory.equals("選択して下さい。")) {
			Sales2Bean_list = mts.selectAllSales1(salesDateB, salesDateA, productCategory, productName,
					remarks);
		} else if (!salesPerson.equals("選択して下さい。") && productCategory.equals("選択して下さい。")) {
			Sales2Bean_list = mts.selectAllSales2(salesDateB, salesDateA, salesPerson, productName,
					remarks);
		} else {
			Sales2Bean_list = mts.selectAllSales(salesDateB, salesDateA, salesPerson, productCategory, productName,
					remarks);
		}

		ErrorMessage = CharUtil.replaceCommaAtEnd(ErrorMessage);

		if (Sales2Bean_list.isEmpty() && ErrorMessage.isEmpty()) {
			ErrorMessage += "検索結果はありません";
			request.setAttribute("err", ErrorMessage);
			this.getServletContext().getRequestDispatcher("/S0020.jsp").forward(request, response);
		} else if (!ErrorMessage.isEmpty()) {
			request.setAttribute("err", ErrorMessage);
			this.getServletContext().getRequestDispatcher("/S0020.jsp").forward(request, response);
		} else {
			if (salesPerson.equals("選択して下さい。") && productCategory.equals("選択して下さい。")) {
				account_list = mts.SalesSearchDisplay1(salesDateB, salesDateA, salesPerson, productCategory,
						productName,
						remarks);
				System.out.println(3);
				
				session.setAttribute("search", "3");
			} else if (salesPerson.equals("選択して下さい。") && !productCategory.equals("選択して下さい。")) {
				account_list = mts.SalesSearchDisplay2(salesDateB, salesDateA, salesPerson, productCategory,
						productName,
						remarks);
				System.out.println(4);
				session.setAttribute("search", "4");
				
			} else if (!salesPerson.equals("選択して下さい。") && productCategory.equals("選択して下さい。")) {
				account_list = mts.SalesSearchDisplay3(salesDateB, salesDateA, salesPerson, productCategory,
						productName,
						remarks);//これ
				System.out.println(1);
				session.setAttribute("search", "1");
				
			} else {
				account_list = mts.SalesSearchDisplay(salesDateB, salesDateA, salesPerson, productCategory, productName,
						remarks);//これ
				System.out.println(2);
				session.setAttribute("search", "2");
			
			}
			request.setAttribute("slist", account_list);
			SalesSearchBean ssb = new SalesSearchBean(salesDateB, salesDateA, salesPerson, productCategory, productName,
					remarks);
			session.setAttribute("ssb", ssb);
			this.getServletContext().getRequestDispatcher("/S0021.jsp").forward(request, response);
		}
	}

}

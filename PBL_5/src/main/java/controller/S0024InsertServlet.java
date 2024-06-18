package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SalesSearchBean;
import model.SalesSearchDisplayBean;
import services.SQLServicesPBLsfs;

/**
 * Servlet implementation class S0024InsertServlet
 */
@WebServlet("/InsertServlet")
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
		
		
		
		mts.insert(Integer.parseInt(up_date_id), sale_date, account_id, category_id, trade_name,
				unit_price, sale_number, note);
		
		
		HttpSession session = request.getSession();
		SalesSearchBean ssb_list =(SalesSearchBean) session.getAttribute("ssb");
		ArrayList<SalesSearchDisplayBean> account_list = new ArrayList<SalesSearchDisplayBean>();
		
		account_list =mts.SalesSearchDisplay(ssb_list.getSalesDateB(),
				ssb_list.getSalesDateA(), ssb_list.getPersonName(), ssb_list.getItem_category(),ssb_list.getProductName(), ssb_list.getRemarks());	
		
		session.removeAttribute("list");
		session.setAttribute("list", account_list);
		response.sendRedirect("SearchSalesServlet");
	}

}

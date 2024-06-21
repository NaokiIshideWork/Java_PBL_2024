package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.S0023ConfirmBean;
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
		HttpSession session = request.getSession();
		SQLServicesPBLsfs mts = new SQLServicesPBLsfs();
		S0023ConfirmBean s023cfb = (S0023ConfirmBean)session.getAttribute("S0024list");
		
		
		int up_date_id = s023cfb.getSale_id();
		
		String sale_date = s023cfb.getSale_date();
		int account_id = s023cfb.getAccount_id();
		int category_id = s023cfb.getCategory_id();
		
		String trade_name = s023cfb.getTrade_name();
		String unit_price = s023cfb.getUnit_price();
		String sale_number = s023cfb.getSale_number();
		String note = s023cfb.getNote();
		
		
		
		mts.update(up_date_id, sale_date, account_id, category_id, trade_name,
				unit_price, sale_number, note);
		
		
		
		SalesSearchBean ssb_list =(SalesSearchBean) session.getAttribute("ssb");
		ArrayList<SalesSearchDisplayBean> account_list = new ArrayList<SalesSearchDisplayBean>();
		
		account_list =mts.SalesSearchDisplay(ssb_list.getSalesDateB(),
				ssb_list.getSalesDateA(), ssb_list.getPersonName(), ssb_list.getItem_category(),ssb_list.getProductName(), ssb_list.getRemarks());	
		
		session.removeAttribute("slist");
		session.setAttribute("slist", account_list);
		response.sendRedirect("SearchSalesServlet");
	}

}

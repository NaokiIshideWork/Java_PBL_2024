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
 * Servlet implementation class S0025DeleteServlet
 */
@WebServlet("/S0025DeleteServlet")
public class S0025DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S0025DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 response.sendRedirect("SearchSalesServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		SQLServicesPBLsfs mts = new SQLServicesPBLsfs();
		String delete_id = request.getParameter("delete_id");
		mts.delete(Integer.parseInt(delete_id));
		
		HttpSession session = request.getSession();
		SalesSearchBean ssb_list =(SalesSearchBean) session.getAttribute("ssb");
		ArrayList<SalesSearchDisplayBean> account_list = new ArrayList<SalesSearchDisplayBean>();
		
		account_list =mts.SalesSearchDisplay(ssb_list.getSalesDateB(),
				ssb_list.getSalesDateA(), ssb_list.getPersonName(), ssb_list.getItem_category(),ssb_list.getProductName(), ssb_list.getRemarks());	
		
		session.removeAttribute("list");
		session.setAttribute("list", account_list);
		for (SalesSearchDisplayBean salesSearchDisplayBean : account_list) {
			System.out.println(account_list.get(0).getCategory_name());
		}
		this.getServletContext().getRequestDispatcher("/S0021.jsp").forward(request, response);
	}

}

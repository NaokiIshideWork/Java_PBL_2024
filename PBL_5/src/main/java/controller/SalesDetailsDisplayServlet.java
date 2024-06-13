package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SalesDetailsDisplayBean;
import services.SQLServicesPBLsfs;

/**
 * Servlet implementation class SalesDetailsDisplayServlet
 */
@WebServlet("/SalesDetailsDisplayServlet")
public class SalesDetailsDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalesDetailsDisplayServlet() {
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
		SalesDetailsDisplayBean SalesDeetail_list =null;
		
		String sale_id = request.getParameter("sale_id");
		SalesDeetail_list = mts.SalesDetailsDisplay(Integer.parseInt(sale_id));
		
		request.setAttribute("list", SalesDeetail_list);
		this.getServletContext().getRequestDispatcher("/S0022.jsp").forward(request, response);
	
	}

}

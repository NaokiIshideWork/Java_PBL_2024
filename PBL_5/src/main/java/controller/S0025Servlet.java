package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.S0025Bean;
import services.SQLServicesPBLsfs;

/**
 * Servlet implementation class S0025Servlet
 */
@WebServlet("/ConfirmationSalesDeletion")
public class S0025Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S0025Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		SQLServicesPBLsfs mts = new SQLServicesPBLsfs();
		S0025Bean S0025Bean_list=null;
		
		String sale_id = request.getParameter("sale_id");
		S0025Bean_list= mts.SalesDetailsDelete(Integer.parseInt(sale_id));		
		request.setAttribute("list", S0025Bean_list);
				
		this.getServletContext().getRequestDispatcher("/S0025.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
	}

}

package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.S0023ConfirmBean;
import services.SQLServicesPBLsfs;

/**
 * Servlet implementation class S0024Servlet
 */
@WebServlet("/S0024Servlet")
public class S0024Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S0024Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/S0024.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		SQLServicesPBLsfs mts = new SQLServicesPBLsfs();
		S0023ConfirmBean S0023Confirmlist = null;//id混みのやつ
		
		//
		String up_date_id = request.getParameter("up_date_id");
		String sale_date = request.getParameter("sale_date");
		String account_id = request.getParameter("account_id");
		String category_id = request.getParameter("category_id");
		String trade_name = request.getParameter("tard_name");
		String unit_price = request.getParameter("unit_price");
		String sale_number = request.getParameter("sale_namber");
		String note = request.getParameter("note");
	
		
//		sql で id 属性をもとにとってくる
		
		S0023Confirmlist= mts.SalesConfirm(Integer.parseInt(up_date_id), Integer.parseInt(account_id), Integer.parseInt(category_id),
				sale_date, trade_name, unit_price, sale_number, note);
		request.setAttribute("S0024list", S0023Confirmlist);
		doGet(request, response);
		
	}

}

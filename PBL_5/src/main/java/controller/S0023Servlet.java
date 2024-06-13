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
import model.S0023Bean;
import services.SQLServicesPBLreg;
import services.SQLServicesPBLsfs;

/**
 * Servlet implementation class S0023Servlet
 */
@WebServlet("/S0023Servlet")
public class S0023Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S0023Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/S0023.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		SQLServicesPBLsfs mts = new SQLServicesPBLsfs();
		SQLServicesPBLreg sqlserv = new SQLServicesPBLreg();
		String sale_id = request.getParameter("sale_id");
		S0023Bean S0023Bean_list = null;
		
		S0023Bean_list = mts.SalesEdit(Integer.parseInt(sale_id));
		ArrayList<AccountsBean> account_list = null;
		account_list = sqlserv.SelectAllAcount();
		//商品カテゴリー表示用
		ArrayList<CategoriesBean> categories_list = null;
		categories_list = sqlserv.SelectAllCategory();

		
		request.setAttribute("accounts", account_list);
		request.setAttribute("cate", categories_list);
		
		request.setAttribute("S0023list", S0023Bean_list);
		doGet(request, response);
	}

}

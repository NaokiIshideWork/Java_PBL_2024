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
import services.SQLServicesPBLreg;

/**
 * Servlet implementation class S0020PageShow
 */
@WebServlet("/SearchSales")
public class S0020PageShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S0020PageShow() {
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
		
		String ErrorMessage = "";

		ArrayList<AccountsBean> account_list = null;
		account_list = sqlserv.canSelectAllAcount();
		HttpSession session = request.getSession();

		if (account_list.isEmpty()) {
			ErrorMessage += "アカウントテーブルに存在しません";
			request.setAttribute("err", ErrorMessage);
		} else {
			session.setAttribute("accounts", account_list);
		}
		
		//商品カテゴリー表示用
		ArrayList<CategoriesBean> categories_list = null;
		categories_list = sqlserv.canSelectAllCategory();

		if (categories_list.isEmpty()) {
			ErrorMessage += "商品カテゴリーテーブルに存在しません";
			request.setAttribute("err", ErrorMessage);
		} else {
			session.setAttribute("cate", categories_list);
		}
		
		this.getServletContext().getRequestDispatcher("/S0020.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

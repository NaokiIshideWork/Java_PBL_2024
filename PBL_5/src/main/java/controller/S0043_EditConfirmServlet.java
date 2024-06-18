package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.AccountRecord;

/**
 * Servlet implementation class S0043_EditConfirmServlet
 */
@WebServlet("/S0043_EditConfirmServlet")
public class S0043_EditConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S0043_EditConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/S0043.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		AccountRecord ar = new AccountRecord();
		System.out.println("S0043_EditConfirmのpost");
		
		String str_id = request.getParameter("tmpId");
		String name = request.getParameter("tmpName");
		String mail = request.getParameter("tmpMail");
		String password = request.getParameter("tmpPassword");
		String str_authority = request.getParameter("tmpAuthority");
		
		System.out.println("POSTに届いたtmpId: " + str_id);
		System.out.println("POSTに届いたtmpName: " + name);
		System.out.println("POSTに届いたtmpMail: " + mail);
		System.out.println("POSTに届いたtmpPassword: " + password);
		System.out.println("POSTに届いたtmpAuthority: " + str_authority);
		
		
		
		int id = Integer.parseInt(str_id);
		int authority = Integer.parseInt(str_authority);
		
		
		ar.updateAccount(id, name, mail, password, authority);
		System.out.println(str_id + name + "さん" + "を更新しました。");
		
		response.sendRedirect("AccountSearchServlet");
	}

}

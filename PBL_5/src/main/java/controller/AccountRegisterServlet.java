package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.AccountRecord;

/**
 * Servlet implementation class AccountRegisterServlet
 */
@WebServlet("/AccountRegisterServlet")
public class AccountRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html: charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		int authority = Integer.parseInt(request.getParameter("authority"));
		
		AccountRecord.makeaccount(name, mail, password, authority);
		response.sendRedirect("accounts");
	}

}

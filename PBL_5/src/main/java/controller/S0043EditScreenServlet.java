package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class S0043EditConfirmServlet
 */
@WebServlet("/S0043EditScreenServlet")
public class S0043EditScreenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S0043EditScreenServlet() {
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

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String authority = request.getParameter("authority");
		
		System.out.println("43servlet ");
		System.out.println(id);
		System.out.println(name);
		System.out.println(mail);
		System.out.println(password);
		System.out.println(confirmPassword);
		System.out.println(authority);
		
		request.setAttribute("id", id);
		request.setAttribute("name", name);
		request.setAttribute("mail", mail);
		request.setAttribute("password", password);
		request.setAttribute("confirmPassword", confirmPassword);
		request.setAttribute("authority", authority);
		
		request.getRequestDispatcher("/S0043.jsp").forward(request, response);
	}

}

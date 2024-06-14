package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class S0044DeleteAccountServlet
 */
@WebServlet("/S0044DeleteAccountServlet")
public class S0044DeleteAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S0044DeleteAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		

		String name = request.getParameter("tmpName");
		String mail = request.getParameter("tmpMail");
		String authority = request.getParameter("tmpAuthority");
		
		System.out.println("44servlet ");
		System.out.println(name);
		System.out.println(mail);
		System.out.println(authority);
		
		request.setAttribute("name", name);
		request.setAttribute("mail", mail);
		request.setAttribute("authority", authority);
		
		request.getRequestDispatcher("/S0044.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// サービスのニューインスタンス
		
		// delete
		doGet(request, response);
	}

}

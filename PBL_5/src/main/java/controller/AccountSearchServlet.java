package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.AccountRecord;

/**
 * Servlet implementation class AccountSearchServlet
 */
@WebServlet("/AccountSearchServlet")
public class AccountSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/S0040.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		AccountRecord ar = new AccountRecord();
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		System.out.println("jspからの受け取り" + name);
		System.out.println("jspからの受け取り" + mail);
		
		 String authorityParam = request.getParameter("authority");
		
        int authority = 0; // 権限がない場合のデフォルト値

//	    int authority = Integer.parseInt(request.getParameter("authority"));
		
        try {
            if (authorityParam != null && !authorityParam.isEmpty()) {
                authority = Integer.parseInt(authorityParam);
            }
        } catch (NumberFormatException e) {
            // Handle the error appropriately
            e.printStackTrace();
        }
        
        System.out.println(authority);

		
		
		request.setAttribute("AccountSearch", ar.EnterAccountSearchCriteria(name, mail, authority));
		request.getRequestDispatcher("/S0041.jsp").forward(request, response);
		
	}

}

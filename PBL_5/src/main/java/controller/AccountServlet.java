package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/S0030.jsp").forward(request, response);
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
		System.out.println(name);
		System.out.println(mail);
		System.out.println(password);
		System.out.println(authority);
//		response.sendRedirect(""); 2回以上送れない
		
		// サーブレットからサーブレットに値を受け渡しているが、あとでセッションで解決？
		
		// ここに記入　パスワードが確認用と比較してあっていたらsetAttributeできるようにする（あとで）
		
	        request.setAttribute("name", name);
	        request.setAttribute("mail", mail);
	        request.setAttribute("password", password);
	        // なぜか0をうけとってしまう
	        request.setAttribute("authority", authority);
	        request.getRequestDispatcher("/S0031.jsp").forward(request, response);
	}

}

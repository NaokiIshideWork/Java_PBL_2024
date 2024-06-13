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
		request.getServletContext().getRequestDispatcher("/S0031.jsp").forward(request, response);
		System.out.println(request.getAttribute("name"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		int authority = Integer.parseInt(request.getParameter("authority"));
		
		System.out.println("doPost name: " + name);
		System.out.println("doPost mail: " + mail);
		System.out.println("doPost password: " + password);
		System.out.println("doPost authority: " + authority);

        // リクエストに属性として設定
        
        AccountRecord.makeaccount(name, mail, password, authority);

        
        // 追加 AccountServletにリダイレクト
        response.sendRedirect("AccountServlet");
        System.out.println("登録しました");
        
        // どこかでパスワードチェック
        
	}

}

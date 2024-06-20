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
@WebServlet("/DeleteAccountServlet")
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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("tmpId");
		String name = request.getParameter("tmpName");
		String mail = request.getParameter("tmpMail");
		String password = request.getParameter("tmpPassword");
		// 一つのインスタンス？データのセット？としてconfirmPasswordにも"<---が入られると　それ用の対策もしておかないといけない
		// 表示しなくても
		
		String confirmPassword = request.getParameter("confirmPassword");
		String authority = request.getParameter("tmpAuthority");
		
		name = sanitizing(name);
		password = sanitizing(password);
		confirmPassword = sanitizing(confirmPassword);
		
		
		
		System.out.println("44servlet ");
		System.out.println(name);
		System.out.println(mail);
		System.out.println(authority);
		
		request.setAttribute("id", id);
		request.setAttribute("name", name);
		request.setAttribute("mail", mail);
		request.setAttribute("password", password);
		request.setAttribute("authority", authority);
		
		request.getRequestDispatcher("/S0044.jsp").forward(request, response);
		// TODO Auto-generated method stub
				
			}
	
	public static String sanitizing(String str) {
		if (null == str || "".equals(str)) {
			return str;
		}

		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		str = str.replaceAll("'", "&#39;");

		return str;
	}

}





























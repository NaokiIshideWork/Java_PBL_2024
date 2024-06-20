package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AccountsBean;
import services.SQLservicesPBL;
import util.CharUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/C0010.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		SQLservicesPBL sqlserv = new SQLservicesPBL();

		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		String error_display = "";

		//メールアドレス未入力
		if (mail.isEmpty()) {
			error_display += "メールアドレスを入力して下さい,";
		}
		//メールアドレス長さチェック
		if (mail.length() > 100) {
			error_display += "メールアドレスが長すぎます,";
		}

		//メールアドレス形式チェック
		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		boolean result = mail.matches(regex);
		if (result == false) {
			error_display += "メールアドレスの形式ではありません,";
		}

		//パスワード必須入力チェック
		if (password.isEmpty()) {
			error_display += "パスワードを入力して下さい,";
		}

		//パスワード長さチェック
		if (mail.length() > 30) {
			error_display += "パスワードが長すぎます, ";
		}
		if(!sqlserv.SearchMail(mail) || !sqlserv.SearchPassword(password)) {
			error_display += "メールアドレス、パスワードを正しく入力して下さい,";
		}
		
		if (error_display.endsWith(",")) {
            System.out.println("後方一致しました");
        } else {
            System.out.println("後方一致しませんでした");
        }
		
        error_display = CharUtil.replaceCommaAtEnd(error_display);

		// このままだと複数でエラーが起きた場合文章が繋がって出てくるかも
		HttpSession session = request.getSession();
		AccountsBean ab = sqlserv.Login(mail, password);
			
		if (ab != null) {
			session.setAttribute("LoginUser", ab);
			response.sendRedirect("DashboardServlet");
		} else if (!error_display.isEmpty()) {
			request.setAttribute("error_display", error_display);
			doGet(request, response);
		}
	}
	
	

}

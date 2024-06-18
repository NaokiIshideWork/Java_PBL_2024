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
	private static final int DEFAULT_AUTHORITY = 0;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/S0031.jsp").forward(request, response);
		System.out.println(request.getAttribute("name"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		int authority;

		// authority パラメータの取得と解析
		String authorityParam = request.getParameter("authority");
		if (authorityParam != null && !authorityParam.isEmpty()) {
			try {
				authority = Integer.parseInt(authorityParam);
			} catch (NumberFormatException e) {
				// authority パラメータが数値でない場合のエラーハンドリング
				System.err.println("権限値が不正です。デフォルト値を使用します。");
				authority = DEFAULT_AUTHORITY; // デフォルトの権限値を設定
			}
		} else {
			// authority パラメータが null もしくは空文字列の場合のエラーハンドリング
			System.err.println("権限値が指定されていません。デフォルト値を使用します。");
			authority = DEFAULT_AUTHORITY; // デフォルトの権限値を設定
		}
		
		// リクエストに属性として設定
		AccountRecord.makeaccount(name, mail, password, authority);

		// 追加 AccountServletにリダイレクト
		response.sendRedirect("AccountServlet");
		System.out.println("登録しました");

		// どこかでパスワードチェック
	}

	private boolean isEmailAlreadyRegistered(String mail) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

}

package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/S0030.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html: charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		String confirmpassword = request.getParameter("confirmPassword");

		// authority_salesとauthority_accountの値を受け取る
		String[] authorities = request.getParameterValues("authority");

		System.out.println(name);
		System.out.println(mail);
		System.out.println("パスワード" + password);
		System.out.println("確認用パスワード" + confirmpassword);
		System.out.println(authorities);
		//		response.sendRedirect(""); 2回以上送れない

		// サーブレットからサーブレットに値を受け渡しているが、あとでセッションで解決？

		// ここに記入　パスワードが確認用と比較してあっていたらsetAttributeできるようにする（あとで）

		String unit_price = request.getParameter("unit_price");
		String error_message = "";
		String error_display = "";

		//氏名
		if (name.isEmpty()) {
			error_display += "氏名を入力して下さい。";//ok
		} else if (name.length() > 20) {
			error_display += "氏名が長すぎます。";//ok
		}

		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		boolean result = mail.matches(regex);

		//メールアドレス
		if (!result) {
			error_display += "メールアドレスの形式ではありません。";
		} else if (isEmailAlreadyRegistered(mail)) {
			error_display += "このメールアドレスは既に登録されています。";
		} else if (mail.isEmpty()) {
			error_display += "メールアドレスを入力して下さい。";
		} else if (mail.length() > 30) {
			error_display += "メールアドレスが長すぎます。";
		} //else {
			//String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
			//boolean result1 = mail.matches(regex);
			//}

		//パスワード
		if (password.isEmpty()) {
			error_display += "パスワードを入力して下さい。";//ok
		} else if (password.length() > 30) {
			error_display += "パスワードが長すぎます。";//ok
		} else if (!password.equals(confirmpassword)) {
			error_display += "パスワードが一致しません。";
		}

		if (!error_display.equals("")) {
			request.setAttribute("err", error_display);
			request.getRequestDispatcher("/S0030.jsp").forward(request, response);
			return;
		}

		if (password.equals(confirmpassword)) {
			// パスワードが一致する場合
			List<String> authorityList = Arrays.asList(authorities);
			request.setAttribute("name", name);
			request.setAttribute("mail", mail);
			request.setAttribute("password", password);
			request.setAttribute("authorities", authorityList);
			// 次の処理に進む
			request.getRequestDispatcher("/S0031.jsp").forward(request, response);
		} else {
			// パスワードが一致しない場合同じ画面に留まる
			error_message += "パスワードが一致しません。";
			request.getRequestDispatcher("/S0030.jsp").forward(request, response);
		}
	}

	private boolean isEmailAlreadyRegistered(String mail) {
		boolean exists = false;
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pbl", "root", "root")) {
			String sql = "SELECT COUNT(*) FROM accounts WHERE mail = ?";
			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setString(1, mail);
				try (ResultSet rs = stmt.executeQuery()) {
					if (rs.next() && rs.getInt(1) > 0) {
						System.out.println("重複あり");
						exists = true; // メールアドレスが既に登録されている場合
					}
				}
			}
		} catch (SQLException e) {
			// エラー処理
			e.printStackTrace();
		}
		return exists;
	}

}

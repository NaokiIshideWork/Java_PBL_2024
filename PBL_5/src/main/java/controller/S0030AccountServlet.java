package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/AccountServlet")
public class S0030AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public S0030AccountServlet() {
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

		String[] authorities = request.getParameterValues("authority");
		String authority = null;


		if (authorities.length == 1) {
		    authority = "0";
		} else if (authorities.length == 2) {
		    // 0という文字列と任意の文字列が入っていたら、1または10のみ受け付ける
		    if (authorities[0].equals("0") && (authorities[1].equals("1") || authorities[1].equals("10"))) {
		        authority = authorities[1];
		    } else if (authorities[1].equals("0") && (authorities[0].equals("1") || authorities[0].equals("10"))) {
		        authority = authorities[0];
		    }
		} else if (authorities.length == 3) {
		    // 三つの要素が0と1と10という文字列の場合
		    boolean hasZero = false;
		    boolean hasOne = false;
		    boolean hasTen = false;
		    for (String auth : authorities) {
		        if (auth.equals("0")) hasZero = true;
		        else if (auth.equals("1")) hasOne = true;
		        else if (auth.equals("10")) hasTen = true;
		    }
		    if (hasZero && hasOne && hasTen) {
		        authority = "11";
		    }
		}

		
		String unit_price = request.getParameter("unit_price");
		String error_message = "";
		String error_display = "";

		//氏名
		if (name.isEmpty()) {
			error_display += "氏名を入力して下さい。";//ok
		} else if (name.length() > 20) {
			error_display += "氏名が長すぎます。";//ok
		}

		//メールアドレス
		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		boolean result = mail.matches(regex);
		if (!result) {
			error_display += "メールアドレスを正しく入力してください。";
		} else if (isEmailAlreadyRegistered(mail)) {
			error_display += "このメールアドレスは既に登録されています。";
		} else if (mail.isEmpty()) {
			error_display += "メールアドレスを入力して下さい。";
		} else if (mail.length() > 100) {
			error_display += "メールアドレスが長すぎます。";
		}

		if (password.isEmpty()) {
			error_display += "パスワードを入力して下さい。";
		} else if (confirmpassword.isEmpty()) {
			error_display += "パスワード（確認）を入力してください。";
		} else if (password.length() > 30) {
			error_display += "パスワードが長すぎます。";
		} else if (!password.equals(confirmpassword)) {
			error_display += "パスワード又はパスワード（確認）の入力内容が異なっています。";
		}

		if (!error_display.equals("")) {
			request.setAttribute("err", error_display);
			request.getRequestDispatcher("/S0030.jsp").forward(request, response);
			return;
		}

		if (password.equals(confirmpassword)) {
			name = sanitizing(name);
			password = sanitizing(password);
			// パスワードが一致する場合
			request.setAttribute("name", name);
			request.setAttribute("mail", mail);
			request.setAttribute("password", password);
			// アカウント検索結果表示の編集ページからの移動対策
			request.setAttribute("authority", authority);
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
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pbl", "root", "root");
			String sql = "SELECT COUNT(*) FROM accounts WHERE mail = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, mail);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() && rs.getInt(1) > 0) {
				exists = true; // メールアドレスが既に登録されている場合
			}
		} catch (SQLException e) {
			// エラー処理
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return exists;
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

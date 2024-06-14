package controller;

import java.io.IOException;
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
		String confirmpassword = request.getParameter("confirmPassword");
		
		// authority_salesとauthority_accountの値を受け取る
		String[] authorities = request.getParameterValues("authority");
		
		System.out.println(name);
		System.out.println(mail);
		System.out.println("パスワード" + password);
		System.out.println("確認用パスワード" + confirmpassword);
		System.out.println(authorities);
		String error_display = "";
//		response.sendRedirect(""); 2回以上送れない
		
		// サーブレットからサーブレットに値を受け渡しているが、あとでセッションで解決？
		
		// ここに記入　パスワードが確認用と比較してあっていたらsetAttributeできるようにする（あとで）
		
		String unit_price = request.getParameter("unit_price");
		String error_message = "";
		
		//氏名
		if (name.isEmpty()) {
			error_message += "氏名を入力して下さい,";//ok
		} else if (name.length() > 20) {
			error_message += "氏名が長すぎます,";//ok
		}
		
		//メールアドレス
        String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        boolean result = mail.matches(regex);
        if(result==false) {
        	error_display += "メールアドレスの形式ではありません";
        }
		if (mail.isEmpty()) {
			error_message += "メールアドレスを入力して下さい,";//ok
		} else if (mail.length() > 30) {
			error_message += "メールアドレスが長すぎます,";//ok
		}
		
		//パスワード
		if (password.isEmpty()) {
			error_message += "パスワードを入力して下さい,";//ok
		} else if (password.length() > 30) {
			error_message += "パスワードが長すぎます,";//ok
		}
		
		
		if(!error_display.equals("")) {
			request.setAttribute("error_display", error_display);
			request.getRequestDispatcher("/S0030.jsp").forward(request, response);
			return;
		}
		
//		if(mail.isEmpty()) {
//			error_display +="メールアドレスを入力して下さい。"; 
//		}
//		//メールアドレス長さチェック
//		if(mail.length() > 100) {
//			error_display += "メールアドレスが長すぎます";
//		}
//
//		//メールアドレス形式チェック
//        String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
//        boolean result = mail.matches(regex);
//        if(result==false) {
//        	error_display += "メールアドレスの形式ではありません";
//        }
//		
//		//パスワード必須入力チェック
//        if(password.isEmpty()) {
//			error_display +="パスワードを入力して下さい。"; 
//		}
//		
//		//パスワード長さチェック
//  		if(password.length() > 30) {
//  			error_display += "パスワードが長すぎます";
//  		}
  		
  		
		
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
		    // パスワードが一致しない場合
		    // 同じ画面に留まる
		    request.setAttribute("errorMessage", "パスワードが一致しません。");
		    error_message += "パスワードが一致しません。";
		    request.getRequestDispatcher("/S0030.jsp").forward(request, response);
		    
		}
		
	}

}

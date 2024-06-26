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
public class S0031AccountRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_AUTHORITY = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S0031AccountRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/S0031.jsp").forward(request, response);
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
	    String mail = request.getParameter("mail");
	    String password = request.getParameter("password");
	    int authority;
	    String[] authorities = request.getParameterValues("submitAuthority");
		String strAuthority = null;


		if (authorities != null) {
		    if (authorities.length == 1) {
		        // 一つの要素だけauthoritiesに入っていたらその要素をstrAuthorityに代入する
		        strAuthority = authorities[0];
		    } else if (authorities.length == 2) {
		        // 二つの要素が入っていて、それらの要素が1という文字列と10という文字列ならばstrAuthorityに11という文字列を代入する
		        boolean hasOne = false;
		        boolean hasTen = false;
		        for (String auth : authorities) {
		            if (auth.equals("1")) hasOne = true;
		            else if (auth.equals("10")) hasTen = true;
		        }
		        if (hasOne && hasTen) {
		            strAuthority = "11";
		        }
		    }
		}
		
	    // authority パラメータの取得と解析
	    String authorityParam = strAuthority;
	    if (authorityParam != null && !authorityParam.isEmpty()) {
	        try {
	            authority = Integer.parseInt(authorityParam);
	        } catch (NumberFormatException e) {
	            // authority パラメータが数値でない場合のエラーハンドリング
	            authority = DEFAULT_AUTHORITY; // デフォルトの権限値を設定
	        }
	    } else {
	        // authority パラメータが null もしくは空文字列の場合のエラーハンドリング
	        authority = DEFAULT_AUTHORITY; // デフォルトの権限値を設定
	    }

	    name = sanitizing(name);
		password = sanitizing(password);
 
	    // リクエストに属性として設定
	    AccountRecord.makeaccount(name, mail, password, authority);
 
	    // 追加 AccountServletにリダイレクト
	    response.sendRedirect("AccountServlet");
	 
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

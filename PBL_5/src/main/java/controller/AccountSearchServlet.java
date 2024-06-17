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
		
		String authorityParam = null;
		
		String authorityOne = null;
		String authorityTwo = null;
		
		int intAuthorityOne = 999;
		int intAuthorityTwo = 999;
		
		 String[] authorities = request.getParameterValues("authority");

	        if (authorities != null) {
	            switch (authorities.length) {
                case 1:
                    // 配列の中身が一つの場合の処理
                    authorityParam = authorities[0];
                    break;
                case 2:
                    // 配列の中身が二つの場合の処理
                    authorityOne = authorities[0];
                    authorityTwo = authorities[1];
                    intAuthorityOne = Integer.parseInt(authorityOne);
                    intAuthorityTwo = Integer.parseInt(authorityTwo);
                    break;
                case 3:
                    // 配列の中身が三つの場合の処理
                	// 何も押さない場合もAllだが押してもAllになるように
                	authorityParam = "99"; //権限での絞り込みがなかった場合 -> int型でnullでの比較ができないため
                    break;
                default:
                    // その他の場合の処理
                	System.out.println("default");
                	break;
            }
        } else {
            	System.out.println("No authority selected.");
	            authorityParam = "99"; //権限での絞り込みがなかった場合 -> int型でnullでの比較ができないため
	        }
		
		
        int authority = -1; // authority int型用の初期化
		
        try {
            if (authorityParam != null && !authorityParam.isEmpty()) {
                authority = Integer.parseInt(authorityParam);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
		
		if(name.isEmpty()) {
			name = null;
		} 
		if(mail.isEmpty()) {
			mail = null;
		} 
		
		if (authorities == null || authorities.length == 0 || authorities.length == 1 || authorities.length == 3) {
		    // 配列がnullまたは空の場合の処理 一つ選択した際にw保持者も表示する
			System.out.println("Allの場合（何も選択なし、３つ選択）または一つ選択");
			request.setAttribute("AccountSearch", ar.EnterAccountSearchCriteria(name, mail, authority));
		} else if (authorities.length == 2) {
			System.out.println("二つ選択の場合");
			request.setAttribute("AccountSearch", ar.AccountMultiSearchCriteria(name, mail, intAuthorityOne, intAuthorityTwo));
		}
		
		
		request.getRequestDispatcher("/S0041.jsp").forward(request, response);
		
	}

}

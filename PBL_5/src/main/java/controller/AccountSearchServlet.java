package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.AccountRecord;

@WebServlet("/AccountSearchServlet")
public class AccountSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AccountSearchServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/S0040.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        
        // キャンセルボタンが押されたかどうかを確認
        if ("true".equals(request.getParameter("cancel"))) {
            // セッションから検索条件を取得
            String name = (String) session.getAttribute("searchName");
            String mail = (String) session.getAttribute("searchMail");
            String authorityParam = (String) session.getAttribute("searchAuthorityParam");
            String authorityOne = (String) session.getAttribute("searchAuthorityOne");
            String authorityTwo = (String) session.getAttribute("searchAuthorityTwo");

            int intAuthorityOne = 999;
            int intAuthorityTwo = 999;

            if (authorityOne != null) {
                intAuthorityOne = Integer.parseInt(authorityOne);
            }
            if (authorityTwo != null) {
                intAuthorityTwo = Integer.parseInt(authorityTwo);
            }

            int authority = -1;
            try {
                if (authorityParam != null && !authorityParam.isEmpty()) {
                    authority = Integer.parseInt(authorityParam);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            AccountRecord ar = new AccountRecord();
            if (authorityParam == null || authorityParam.isEmpty() || authorityParam.equals("99") || authorityTwo == null) {
                request.setAttribute("AccountSearch", ar.EnterAccountSearchCriteria(name, mail, authority));
            } else {
                request.setAttribute("AccountSearch", ar.AccountMultiSearchCriteria(name, mail, intAuthorityOne, intAuthorityTwo));
            }

            request.getRequestDispatcher("/S0041.jsp").forward(request, response);
            return;
        }

        // 通常の検索処理
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
                    authorityParam = authorities[0];
                    break;
                case 2:
                    authorityOne = authorities[0];
                    authorityTwo = authorities[1];
                    intAuthorityOne = Integer.parseInt(authorityOne);
                    intAuthorityTwo = Integer.parseInt(authorityTwo);
                    break;
                case 3:
                    authorityParam = "99";
                    break;
                default:
                    break;
            }
        } else {
            authorityParam = "99";
        }

        int authority = -1;
        try {
            if (authorityParam != null && !authorityParam.isEmpty()) {
                authority = Integer.parseInt(authorityParam);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        if (name.isEmpty()) {
            name = null;
        }
        if (mail.isEmpty()) {
            mail = null;
        }
        
        
        // エラーチェック
        String error_display = "";

		//氏名
        if(name!=null) {
        	if (name.length() > 20) {
    			error_display += "氏名が長すぎます。";//ok
    		}
        }
		

		//メールアドレス 正しい正規表現でないかも　一応AccountServletと同じ
        String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		boolean result = true;
		if(mail != null) {
			result = mail.matches(regex);
		
			// error
			if (!result) {
				error_display += "メールアドレスを正しく入力してください。";
			} else if (mail.length() > 100) {
				error_display += "メールアドレスが長すぎます。";
			}
		}
		
		

		if (!error_display.equals("")) {
			request.setAttribute("err", error_display);
			request.getRequestDispatcher("/S0040.jsp").forward(request, response);
			return;
		} else {
        if (authorities == null || authorities.length == 0 || authorities.length == 1 || authorities.length == 3) {
            request.setAttribute("AccountSearch", ar.EnterAccountSearchCriteria(name, mail, authority));
        } else if (authorities.length == 2) {
            request.setAttribute("AccountSearch", ar.AccountMultiSearchCriteria(name, mail, intAuthorityOne, intAuthorityTwo));
        }

        // 検索条件をセッションに保存
        session.setAttribute("searchName", name);
        session.setAttribute("searchMail", mail);
        session.setAttribute("searchAuthorityParam", authorityParam);
        session.setAttribute("searchAuthorityOne", authorityOne);
        session.setAttribute("searchAuthorityTwo", authorityTwo);

        request.getRequestDispatcher("/S0041.jsp").forward(request, response);
    }
  }
}

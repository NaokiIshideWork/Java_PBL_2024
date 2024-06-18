package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class S0043EditConfirmServlet
 */
@WebServlet("/S0043EditScreenServlet")
public class S0043EditScreenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S0043EditScreenServlet() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String[] authorities = request.getParameterValues("authority");
		String authority = assignAuthority(authorities);
		
		System.out.println("Received authorityValue: " + authority);
		
		
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("43EditScreenServlet ");
		System.out.println(id);
		System.out.println(name);
		System.out.println(mail);
		System.out.println(password);
		System.out.println(confirmPassword);
		System.out.println(authority);
		
		request.setAttribute("id", id);
		request.setAttribute("name", name); //文字化け
		request.setAttribute("mail", mail);
		request.setAttribute("password", password);
		request.setAttribute("confirmPassword", confirmPassword);
		request.setAttribute("authority", authority);
		
		request.getRequestDispatcher("/S0043.jsp").forward(request, response);
	}
	
	
	public static String assignAuthority(String[] authorities) {
        String authority = null;
        
        if (authorities.length == 0) {
            authority = "0";
        } else if (authorities.length == 1) {
            authority = authorities[0];
        } else if (authorities.length == 2) {
            if (contains(authorities, "0")) {
                authority = authorities[0].equals("0") ? authorities[1] : authorities[0];
            } else if (contains(authorities, "1") && contains(authorities, "10")) {
                authority = "11";
            }
        } else if (authorities.length == 3) {
            if (contains(authorities, "0")) {
                if (contains(authorities, "1") && contains(authorities, "10")) {
                    authority = "11";
                } else {
                    for (String auth : authorities) {
                        if (!auth.equals("0")) {
                            authority = auth;
                            break;
                        }
                    }
                }
            }
        }

        return authority;
    }

    private static boolean contains(String[] array, String value) {
        for (String element : array) {
            if (element.equals(value)) {
                return true;
            }
        }
        return false;
    }
}






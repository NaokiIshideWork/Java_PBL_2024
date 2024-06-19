package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AccountsBean;
import services.AccountRecord;

@WebServlet("/GraphingAccountsServlet")
public class GraphingAccountsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountRecord accountRecord = new AccountRecord();
        ArrayList<AccountsBean> accountsList = accountRecord.EnterAccountSearchCriteria(null, null, 99);
        
        int noAuthCount = 0;
        int salesAuthCount = 0;
        int accountAuthCount = 0;
        int bothAuthCount = 0;

        for (AccountsBean account : accountsList) {
            switch (account.getAuthority()) {
                case 0:
                    noAuthCount++;
                    break;
                case 1:
                    salesAuthCount++;
                    break;
                case 10:
                    accountAuthCount++;
                    break;
                case 11:
                    bothAuthCount++;
                    break;
            }
        }

        request.setAttribute("accountsList", accountsList);
        request.setAttribute("noAuthCount", noAuthCount);
        request.setAttribute("salesAuthCount", salesAuthCount);
        request.setAttribute("accountAuthCount", accountAuthCount);
        request.setAttribute("bothAuthCount", bothAuthCount);
        request.getRequestDispatcher("account_search_results.jsp").forward(request, response);
    }

}

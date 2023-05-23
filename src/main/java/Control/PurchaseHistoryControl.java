package Control;

import business.PurchaseHistory;
import business.User;
import database.InvoiceDataBase;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import org.jboss.weld.context.http.Http;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PurchaseHistoryControl", value = "/PurchaseHistoryControl")
public class PurchaseHistoryControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        ArrayList<PurchaseHistory> histories = InvoiceDataBase.getPurchaseHistoryByUsername(user.getUserName());
        request.setAttribute("user",user);
        request.setAttribute("history",histories);
        getServletContext()
                .getRequestDispatcher("/PurchaseHistory.jsp")
                .forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

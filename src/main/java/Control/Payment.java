package Control;

import business.*;
import database.InvoiceDataBase;
import database.RoomDatabase;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Byte.parseByte;

@WebServlet(name = "Payment", value = "/Payment")
public class Payment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<Booking> bookings = (ArrayList<Booking>)session.getAttribute("itemLines");
        if(bookings==null||bookings.size()==0)
        {
            request.setAttribute("PaymentMessage","No Item Found In Your Cart");
            getServletContext()
                    .getRequestDispatcher("/PersonalInfo.jsp")
                    .forward(request,response);
        }
        else {
            for(int i=0;i<bookings.size();i++)
            {
                String check = request.getParameter(String.valueOf(bookings.get(i).getID()));
//                String check = (String) request.getAttribute(String.valueOf(itemLines.get(i).getInvoice().getID()));
                if(check != null && check.equals("on"))
                {
                    if(!InvoiceDataBase.addToPurchaseHistory(bookings.get(i)))
                    {
                        request.setAttribute("PaymentMessage","Error While Executing Payment");
                        getServletContext()
                                .getRequestDispatcher("/PersonalInfo.jsp")
                                .forward(request,response);
                        return;
                    }
                    bookings.remove(i);
                    i--;
                }
            }
            final Object lock = request.getSession().getId().intern();
            synchronized (lock){
                request.setAttribute("itemLines",bookings);
                session.setAttribute("itemLines",bookings);
                User user = (User)session.getAttribute("user");
                session.setAttribute("user",user);
                request.setAttribute("user",user);
            }
            getServletContext()
                    .getRequestDispatcher("/PersonalInfo.jsp")
                    .forward(request,response);
        }
    }
}

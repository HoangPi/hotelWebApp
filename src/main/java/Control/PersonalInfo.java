package Control;

import business.Booking;
import business.Invoice;
import business.ItemLine;
import business.User;
import database.InvoiceDataBase;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PersonalInfo", value = "/PersonalInfo")
public class PersonalInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        ArrayList<Booking> bookings = InvoiceDataBase.getAllBookingByUserName(user.getUserName());

        final Object lock = request.getSession().getId().intern();
        synchronized (lock){
            request.setAttribute("itemLines",bookings);
            session.setAttribute("itemLines",bookings);
            session.removeAttribute("user");
            session.setAttribute("user",user);
            request.setAttribute("user",user);
        }
        getServletContext()
                .getRequestDispatcher("/PersonalInfo.jsp")
                .forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
